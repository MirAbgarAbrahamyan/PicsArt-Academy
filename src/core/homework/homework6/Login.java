package core.homework.homework6;

import core.homework.homework6.Helper.Utility;
import core.homework.homework6.MyExceptions.LoginException;

import java.io.File;
import java.util.Scanner;

public class Login implements MenuAdmin {
    @Override
    public User launch(File file, String path, String name) {
        User user;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scan.nextLine();
        System.out.println("Enter your password:");
        String password = Utility.MD5(scan.nextLine());
        if (Utility.usernameSet.containsKey(username) && Utility.usernameSet.get(username).equals(password))
            user = Utility.setUser(username);
        else
            throw new LoginException();
        return user;
    }
}
