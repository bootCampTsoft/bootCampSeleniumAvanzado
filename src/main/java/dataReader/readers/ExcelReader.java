package dataReader.readers;

import dataReader.exceptions.DataReaderException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelReader  implements IDataReader {
    @Override
    public List<HashMap<String, String>> readFile(String file) throws Throwable {
        System.out.println("ExcelReader: " + PROJECT_WORK + file);
        List<HashMap<String, String>> data;
        try {
            data = new ArrayList<>();
            FileInputStream fs;
            File rutaFile = new File(PROJECT_WORK + file);
            if (!rutaFile.exists()) throw new Exception("El archivo " + rutaFile.getName() + " no existe!");
            fs = new FileInputStream(rutaFile);
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheetAt(0);//Primera hoja por defecto
            if (sheet == null) throw new Exception("La hoja " + sheet.getSheetName() + " no existe!");
            Row headerRow = sheet.getRow(0);
            int nroFilas = sheet.getPhysicalNumberOfRows();
            int nroColumnas = headerRow.getPhysicalNumberOfCells();
            for (int i = 1; i < nroFilas; i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                HashMap<String, String> currentHash = new HashMap<>();
                for (int j = 0; j < nroColumnas; j++) {
                    Cell currentCell = currentRow.getCell(j);
                    // NOTA: solo considera a las celdas del tipo string, cualquier otro caso lo pone como cadena vacía
                    if (currentCell != null) {
                        if (currentCell.getCellTypeEnum().equals(CellType.STRING)) {
                            currentHash.put(
                                    StringUtils.trimToEmpty(headerRow.getCell(j).getStringCellValue()),
                                    StringUtils.trimToEmpty(currentCell.getStringCellValue()));
                        } else if (currentCell.getCellTypeEnum().equals(CellType.BLANK)) {
                            currentHash.put(
                                    StringUtils.trimToEmpty(headerRow.getCell(j).getStringCellValue()),
                                    StringUtils.EMPTY);
                        } else if (currentCell.getCellTypeEnum().equals(CellType.NUMERIC)) {
                            double valor = currentCell.getNumericCellValue(), input = Math.abs(valor);
                            String inputString;
                            if (input - (int) input > 0)  inputString = String.valueOf(valor);
                            else inputString = String.valueOf((int) valor);
                            currentHash.put(
                                    StringUtils.trimToEmpty(headerRow.getCell(j).getStringCellValue()),
                                    inputString);
                        } else {
                            // por default se pone empty si no es ni string, ni blank, ni numeric
                            currentHash.put(
                                    StringUtils.trimToEmpty(headerRow.getCell(j).getStringCellValue()),
                                    StringUtils.EMPTY);
                        }
                    } else {
                        // por default se pone empty si es null
                        currentHash.put(
                                StringUtils.trimToEmpty(headerRow.getCell(j).getStringCellValue()),
                                StringUtils.EMPTY);
                    }
                }
                data.add(currentHash);
            }
            return data;

        } catch (Throwable throwable) {
            throw new DataReaderException("Error al abrir el archivo: " + throwable.getMessage());
        }
    }
}
