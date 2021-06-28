package advanced.homework5;

import java.io.Serializable;

public class User implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;

    private String login;
    private String password;
    private int year;

    private User() {

    }

    private static class UserHolder {
        private static final User INSTANCE = new User();
    }

    public static User getInstance() {
        return UserHolder.INSTANCE;
    }

    private Object readResolve() {
        return getInstance();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
