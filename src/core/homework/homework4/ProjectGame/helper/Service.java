package core.homework.homework4.ProjectGame.helper;

import core.homework.homework4.ProjectGame.Player;
import core.homework.homework4.ProjectGame.Weapon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Service {
    // Math.random() return value in range [0.0 ; 1.0)
    // So we perform this to get random val in range [left, right]
    public static int random(int left, int right) {
        return (int) (Math.random() * (right - left + 1) + left);
    }

    public static int random(Range range) {
        return (int) (Math.random() * (range.getRight() - range.getLeft() + 1) + range.getLeft());
    }

    public static String[] readMap(String name) {
        try {
            return Files.readAllLines(Paths.get(name)).toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("Map.txt file is missing!");
            System.exit(0);
        }
        return new String[]{};
    }

    public static String[] readLoad(String name) {
        try {
            return Files.readAllLines(Paths.get(name)).toArray(new String[0]);
        } catch (IOException e) {
            System.out.println("loads.txt file is missing!");
        }
        return new String[]{};
    }

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
            Files.write(Paths.get(path + File.separator + name), text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkForCommaAndEmpty(String text) {
        if (text.length() == 0) {
            return true;
        }
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ',') {
                return true;
            }
        }
        return false;
    }

    public static Player constructPlayerFromStringArray(String[] info) {
        String playerName = info[0];
        int hp = Integer.parseInt(info[1]);
        int accuracy = Integer.parseInt(info[2]);
        String weaponName = info[3];
        int weaponRangeLeft = Integer.parseInt(info[4]);
        int weaponRageRight = Integer.parseInt(info[5]);
        int maxHp = Integer.parseInt(info[6]);
        int nextLvlXp = Integer.parseInt(info[7]);
        Player player = new Player(playerName, hp, accuracy,
                new Weapon(weaponName, weaponRangeLeft, weaponRageRight), maxHp, nextLvlXp);
        player.setLvl(Integer.parseInt(info[10]));
        player.setXp(Integer.parseInt(info[11]));
        player.setCoins(Integer.parseInt(info[12]));
        player.setNumOfApples(Integer.parseInt(info[13]));
        player.setNumOfMagicalSand(Integer.parseInt(info[14]));
        return player;
    }
}
