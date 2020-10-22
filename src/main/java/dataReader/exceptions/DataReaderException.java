package dataReader.exceptions;

import java.io.IOException;

public class DataReaderException extends IOException {
    public DataReaderException() {
        super();
    }

    public DataReaderException(String message) {
        super(message);
    }
}
