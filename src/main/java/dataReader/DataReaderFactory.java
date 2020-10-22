package dataReader;

import dataReader.readers.*;

public class DataReaderFactory {
    public static IDataReader getReader(String readerType){
        readerType = readerType.toUpperCase();
        switch (readerType){
            case "CSV":  return new CsvReader();
            case "TXT":  return new TxtReader();
            case "JSON":  return new JsonReader();
            case "EXCEL":  return new ExcelReader();
            default:
                throw new IllegalStateException("Unexpected value:  "+readerType);
        }
    }
}
