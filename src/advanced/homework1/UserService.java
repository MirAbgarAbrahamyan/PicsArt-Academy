package advanced.homework1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UserService {
    private static final String FILE_NAME = "userinfoXMLcode";

    public static void serializeXML(User user) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                XMLEncoder encoder = new XMLEncoder(fos);
                encoder.writeObject(user);
                encoder.close();
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static User deserializeXML() {
        FileInputStream fis = null;
        User user = null;
        try {
            fis = new FileInputStream(FILE_NAME);
            XMLDecoder decoder = new XMLDecoder(fis);
            Object obj = decoder.readObject();
            user = (User) obj;
            decoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
