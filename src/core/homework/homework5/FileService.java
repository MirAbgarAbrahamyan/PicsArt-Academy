package core.homework.homework5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static String[] readLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }
}
