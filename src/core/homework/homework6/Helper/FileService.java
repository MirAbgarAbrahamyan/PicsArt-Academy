package core.homework.homework6.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    public static void createFile(String path, String name) {
        File file = new File(path + File.separator + name);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInFile(String path, String name, String text) {
        try {
            Files.write(Paths.get(path + File.separator + name), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFromFile(String path, String name) throws IOException {
        return Files.readAllLines(Paths.get(path + File.separator + name));
    }
}
