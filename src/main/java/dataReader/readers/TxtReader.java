package dataReader.readers;

import dataReader.exceptions.DataReaderException;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TxtReader  implements IDataReader {

    private static final String DELIMITER = ";";
    @Override
    public List<HashMap<String, String>> readFile(String file)  throws Throwable {
        System.out.println("TxtReader: " + PROJECT_WORK + file);
        List<HashMap<String, String>> data;
        try {
            data = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(PROJECT_WORK+file));
            String line;
            int i = 0;
            String[] keys = null;
            HashMap<String, String> rowData;
            while ((line = br.readLine()) != null) {
                if(i==0) {
                    i++;  keys = line.split(DELIMITER);
                    continue;
                }
                String[] values = new String[keys.length];
                for (int k = 0; k < keys.length; k++) {
                    values[k] = (k < line.split(DELIMITER).length) ? line.split(DELIMITER)[k] : StringUtils.EMPTY;
                }
                rowData = new HashMap<>();
                for (int j = 0; j < keys.length ; j++) {
                    rowData.put(keys[j], values[j]);
                }
                data.add(rowData);
            }
            return data;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw new DataReaderException("Error al abrir el archivo: " + throwable.getMessage());
        }
    }
}
