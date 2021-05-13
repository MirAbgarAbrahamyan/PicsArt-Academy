package core.homework.homework6;

import core.homework.homework6.Helper.FileService;
import core.homework.homework6.Helper.Utility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\PicsArt Academy\\src\\core\\" +
                "homework\\homework6\\users_list.txt");
        String path = "C:\\Users\\User\\PicsArt Academy\\src\\core\\homework\\homework6";
        String name = "users_list.txt";
        if (!file.exists()) {
            FileService.createFile(path, name);
        }
        else {
            try {
                Utility.usersList = FileService.readFromFile(path, name);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Utility.addUsernamesToHashSet(Utility.usersList);
        }

        Scanner scan = new Scanner(System.in);
        int choice = 0;
        MenuAdmin program;
        while (choice != 1 && choice != 2) {
            System.out.println("1) Registration 2) Login");
            choice = scan.nextInt();
        }
        if (choice == 1)
            program = new Registration();
        else
            program = new Login();

        User user = program.launch(file, path, name);
        System.out.println(user);
    }
}
