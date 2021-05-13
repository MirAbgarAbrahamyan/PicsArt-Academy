package core.homework.homework6;

import core.homework.homework6.Helper.Utility;
import core.homework.homework6.MyExceptions.RegistrationException;

public class User {
    private static final String emailRegex = "^(.+)@(.+)$";

    private String fullName;
    private String email;
    private String password;
    private String username;

    public User() {}

    public User(String fullName, String email, String password, String username) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.matches(emailRegex))
            throw new RegistrationException("Please enter a valid email address");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!isValidPassword(password))
            throw new RegistrationException("Enter a combination of at list 9 symbols where are " +
                    "exactly 2 numbers and 3 uppercase letters");
        password = Utility.MD5(password);
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (Utility.usernameSet.containsKey(username))
            throw new RegistrationException("This username exists choose another one");
        this.username = username;
    }

    private static boolean isValidPassword(String password) {
        if (password.length() <= 8)
            return false;
        int numOfUppercaseLetters = 0;
        int numOfDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9')
                numOfDigits++;
            // to calculate other languages too
            else if (Character.isUpperCase(password.charAt(i)))
                numOfUppercaseLetters++;
        }
        if (numOfDigits != 2 || numOfUppercaseLetters != 3)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUserInfo() {
        StringBuilder tmp = new StringBuilder();
        tmp.append(fullName);
        tmp.append(",");
        tmp.append(email);
        tmp.append(",");
        tmp.append(password);
        tmp.append(",");
        tmp.append(username);
        tmp.append("\n");
        return tmp.toString();
    }
}
