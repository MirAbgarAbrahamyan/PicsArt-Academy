package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Service;
import core.homework.homework4.ProjectGame.myexceptions.InvalidMapException;

import java.io.File;

public abstract class GameSystem {
    protected static final char FLOOR = ' ';
    protected static final char WALL = '#';
    protected static final char PLAYER = 'P';
    protected static final char WIZARD = 'W';
    protected static final char TRADER = '$';

    protected int xPos = 2;
    protected int yPos = 6;

    /*
        ********
        ***###**
        $*****#W
        *******#
        **#*#***
        ***#****
        **P***#*
        ##*$****
     */
    // where # is Wall * is road and P is the player
    // $ - trader, W - wizard


    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setxPos(int xPos) {
        if (xPos >= 0)
            this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        if (yPos >= 0)
            this.yPos = yPos;
    }

    protected abstract void movePlayer();

    protected abstract void showMap();

    protected abstract Vendor generateVendor();

    public String printPlayerPos() {
        return "Your position: (" + xPos + "," + yPos + ")";
    }

    public Enemy generateEnemy() {
        Enemy enemy = null;
        // rolling a die, some probability theory XD
        int roll = Service.random(1, 4);
        // 25% probability for generating a bully
        if (roll == 1) {
            Weapon weapon = new Weapon("Baseball bat", 3, 5);
            enemy = new Enemy("Bully", 10, 10, weapon, 5);
            System.out.println("You are faced a bully he wants to kill you" +
                    " fight or escape!");
        }
        else if (roll == 2) { // 25% probability
            Weapon weapon = new Weapon("Glaive", 5, 10);
            enemy = new Enemy("Soldier", 30, 15, weapon, 10);
            System.out.println("You are faced a soldier he wants to kill you" +
                    " fight or escape!");
        }
        // 50% probability for nothing
        return enemy;
    }

    public static char[][] constructMap(String[] map) throws InvalidMapException {
        String[] size = map[0].split("x");
        //System.out.println("Debug: " + size.length + " " + size[0] + "x" + size[1]);
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        if (map.length != n + 1) {
            throw new InvalidMapException("Wrong size of map is given inside Map.txt file.");
        }
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            if (map[i + 1].length() != m) {
                throw new InvalidMapException("Wrong size of map is given inside Map.txt file.");
            }
            if (checkForWrongParameter(map))
                throw new InvalidMapException("Wrong parameters given inside Map.txt file.");
            grid[i] = map[i + 1].toCharArray();
        }
        return grid;
    }

    private static boolean checkForWrongParameter(String[] map) {
        for (int i = 1; i < map.length; i++) {
            for (int j = 0; j < map[i].length(); j++) {
                if (map[i].charAt(j) != PLAYER && map[i].charAt(j) != FLOOR &&
                        map[i].charAt(j) != WALL && map[i].charAt(j) != WIZARD &&
                        map[i].charAt(j) != TRADER) {
                    System.out.println(map[i].charAt(j));
                    return true;
                }
            }
        }
        return false;
    }

    public static void saveGame(String info) {
        File file = new File("C:\\Users\\User\\PicsArt Academy\\src\\" +
                "core\\homework\\homework4\\ProjectGame\\loads.txt");
        String path = "C:\\Users\\User\\PicsArt Academy\\src\\" +
                "core\\homework\\homework4\\ProjectGame";
        if (!file.exists()) {
            Service.createFile(path, "loads.txt");
        }
        Service.writeInFile(path, "loads.txt", info);
        System.out.println("Game has been saved");
    }

    public static String[] loadGame() {
        return Service.readLoad("C:\\Users\\User\\PicsArt Academy\\src\\" +
                "core\\homework\\homework4\\ProjectGame\\loads.txt");
    }
}
