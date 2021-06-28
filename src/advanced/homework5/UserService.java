package advanced.homework5;

import java.io.*;

public class UserService {
    private static final String FILE_NAME = "h5userinfo";

    public static void serialize(User user) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(FILE_NAME);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static User deserialize() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User user = null;
        try {
            fis = new FileInputStream(FILE_NAME);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            user = (User) obj;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
