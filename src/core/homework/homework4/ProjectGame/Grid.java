package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Service;
import core.homework.homework4.ProjectGame.myexceptions.InvalidMapException;

import java.util.Scanner;

public class Grid extends GameSystem {
    private char[][] grid;
    /*
    private static final char[][] GRID = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                          {' ', ' ', ' ', '#', '#', '#', ' ', ' '},
                                          {' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                                          {' ', ' ', '#', ' ', '#', ' ', ' ', '#'},
                                          {' ', ' ', ' ', '#', ' ', ' ', ' ', ' '},
                                          {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                                          {' ', ' ', ' ', ' ', ' ', ' ', '#', ' '},
                                          {'#', '#', ' ', ' ', ' ', ' ', ' ', ' '}};
    */
    // 8 x 8 standard grid
    /*
    private static final char[][] GRID = {"        ".toCharArray(),
                                          "   ###  ".toCharArray(),
                                          "$     #W".toCharArray(),
                                          "       #".toCharArray(),
                                          "  # #   ".toCharArray(),
                                          "   #    ".toCharArray(),
                                          "      # ".toCharArray(),
                                          "## $    ".toCharArray()};
    */
    public Grid() {
        String[] map = Service.readMap("C:\\Users\\User\\PicsArt Academy\\src\\" +
                "core\\homework\\homework4\\ProjectGame\\Map.txt");
        try {
            grid = GameSystem.constructMap(map);
        } catch (InvalidMapException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void movePlayer() {
        Scanner scan = new Scanner(System.in);
        boolean ok = true;
        while (ok) {
            System.out.println("1) Up 2) Right 3) Down 4) Left");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: // Up
                    if (!checkForWallAndBorders(0, -1))
                        yPos--;
                    ok = false;
                    break;
                case 2: // Right
                    if (!checkForWallAndBorders(1, 0))
                        xPos++;
                    ok = false;
                    break;
                case 3: // Down
                    if (!checkForWallAndBorders(0, 1))
                        yPos++;
                    ok = false;
                    break;
                case 4: // Left
                    if (!checkForWallAndBorders(-1, 0))
                        xPos--;
                    ok = false;
                    break;
                default:
                    System.out.println("No such button exists try again");
            }
        }
    }

    private boolean checkForWallAndBorders(int directionX, int directionY) {
        if (xPos + directionX == 8 || yPos + directionY == 8 ||
                xPos + directionX == -1 || yPos + directionY == -1 ||
                grid[yPos + directionY][xPos + directionX] == WALL) {
            return true;
        }
        return false;
    }

    @Override
    protected Vendor generateVendor() {
        if (grid[yPos][xPos] == WIZARD) {
            return new Wizard();
        }
        else if (grid[yPos][xPos] == TRADER) {
            return new Trader();
        }
        return null;
    }

    @Override
    public void showMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == yPos && j == xPos) {
                    System.out.print(PLAYER);
                }
                else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }
}
