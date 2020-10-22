package dataReader.readers;

import java.util.HashMap;
import java.util.List;

public interface IDataReader {
    String PROJECT_WORK = System.getProperty("user.dir")+"/src/main/java/testData/";
    List<HashMap<String,String>> readFile(String file) throws Throwable;
}
