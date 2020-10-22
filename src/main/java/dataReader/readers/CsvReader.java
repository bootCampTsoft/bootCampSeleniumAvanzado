package dataReader.readers;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import dataReader.exceptions.DataReaderException;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CsvReader implements IDataReader {

    @Override
    public List<HashMap<String, String>> readFile(String file) throws Throwable {
        System.out.println("CsvReader: " + PROJECT_WORK + file);
        List<HashMap<String, String>> data;
        try {
            data = new ArrayList<>();
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
//            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(PROJECT_WORK + file), StandardCharsets.UTF_8);
//            CSVReader csvReader = new CSVReaderBuilder(bufferedReader).withCSVParser(parser).build();
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(PROJECT_WORK + file))
                    .withCSVParser(parser)
                    .build();
            List<String[]> rows = csvReader.readAll();
            csvReader.close();
            HashMap<String, String> rowData;
            for (int i = 1; i < rows.size(); i++) {
                rowData = new HashMap<>();
                for (int j = 0; j < rows.get(i).length; j++) {
                    rowData.put(rows.get(0)[j], rows.get(i)[j]);
                }
                data.add(rowData);
            }
            return data;
        } catch (Throwable throwable) {
            throw new DataReaderException("Error al abrir el archivo: " + throwable.getMessage());
        }
    }
}