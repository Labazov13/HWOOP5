package personal.model;

import java.io.IOException;
import java.util.List;

public interface FileOperation {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
    void deleteLine(String lines) throws IOException;
    void deleteAllLine(List<String> lines) throws IOException;
}
