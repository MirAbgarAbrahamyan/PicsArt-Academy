package core.homework.homework6.MyExceptions;

public class LoginException extends RuntimeException {
    public LoginException() {
        super("Wrong username or password entered");
    }
}
