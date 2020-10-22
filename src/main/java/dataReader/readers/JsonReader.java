package dataReader.readers;


import dataReader.exceptions.DataReaderException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonReader  implements IDataReader {
    @Override
    public List<HashMap<String, String>> readFile(String file)  throws Throwable {
        System.out.println("JsonReader: " + PROJECT_WORK + file);
        List<HashMap<String, String>> data;
        try {
            data = new ArrayList<>();
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(PROJECT_WORK+file);
            Object object = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject)object;
            JSONArray employeeList = (JSONArray) jsonObject.get("set_data");
            for (Object rowData : employeeList) {
                data.add((HashMap)rowData);
            }
            return data;
        } catch (Throwable throwable) {
            throw new DataReaderException("Error al abrir el archivo: " + throwable.getMessage());
        }
    }
}
