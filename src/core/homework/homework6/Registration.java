package core.homework.homework6;

import core.homework.homework6.Helper.FileService;

import java.io.File;
import java.util.Scanner;

public class Registration implements MenuAdmin {
    @Override
    public User launch(File file, String path, String name) {
        User user = new User();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your full name:");
        user.setFullName(scan.nextLine());
        System.out.println("Enter your e-mail:");
        user.setEmail(scan.nextLine());
        System.out.println("Enter your password:");
        user.setPassword(scan.nextLine());
        System.out.println("Enter your username:");
        user.setUsername(scan.nextLine());
        FileService.writeInFile(path, name, user.getUserInfo());
        return user;
    }
}
