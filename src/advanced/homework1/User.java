package advanced.homework1;

public class User {
    //private static final long SERIAL_VERSION_UID = 1L;

    private String login;
    private String password;
    private int year;

    public User() {
    }

    public User(String login, String password, int year) {
        this.login = login;
        this.password = password;
        this.year = year;
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

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", year=" + year +
                '}';
    }
}
