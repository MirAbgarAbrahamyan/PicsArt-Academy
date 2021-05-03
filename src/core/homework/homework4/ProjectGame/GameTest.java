package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Service;

import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        System.out.println("\t\tStart Menu\n" +
                "1) New Game\n" +
                "2) Load Game\n" +
                "0) Exit Game");
        Scanner scan = new Scanner(System.in);
        int startMenuOption = 2;
        boolean isLoaded = false;
        while (startMenuOption != 1) {
            startMenuOption = scan.nextInt();
            if (startMenuOption == 2) {
                isLoaded = true;
                startMenuOption = 1;
            }
            else if (startMenuOption == 0) {
                System.exit(0);
            }
        }

        Player player;
        // fake coordinates for future checking if the game is loaded or not
        int x = -1;
        int y = -1;

        if (!isLoaded) {
            String playerName = "";
            while (Service.checkForCommaAndEmpty(playerName)) {
                System.out.print("(don't use comma or blank)Enter your name: ");
                scan.nextLine();
                playerName = scan.nextLine();
            }
            player = new Player(playerName, 100, 17,
                    new Weapon("Sword", 5, 10), 100, 100);
        }
        else {
            String[] loads = GameSystem.loadGame();
            if (loads.length == 0) {
                System.out.print("Enter your name: ");
                scan.next();
                String playerName = scan.nextLine();
                player = new Player(playerName, 100, 17,
                        new Weapon("Sword", 5, 10), 100, 100);
            }
            else {
                String[] loadInfo = loads[0].split(",");
                player = Service.constructPlayerFromStringArray(loadInfo);
                x = Integer.parseInt(loadInfo[8]);
                y = Integer.parseInt(loadInfo[9]);
            }
        }

        Grid game = new Grid();
        game.setxPos(x);
        game.setyPos(y);
        boolean isPlaying = true;
        System.out.print("-------------------\n" +
                "The game started, and ");
        while (isPlaying) {
            System.out.println("you are at " +
                    game.printPlayerPos() + " coordinates");
            game.showMap();
            System.out.println("1) Move\n" +
                               "2) View Stats\n" +
                               "3) Eat an Apple\n" + // if I update the game this might be changed as "Open Backpack"
                               "4) Save Game and Exit\n" +
                               "0) Exit Game");
            int button = scan.nextInt();
            switch (button) {
                case 1:
                    game.movePlayer();
                    Vendor vendor = game.generateVendor();
                    if (vendor != null) {
                        boolean isAtShop = true;
                        vendor.greet();
                        while (isAtShop) {
                            if (vendor instanceof Trader) {
                                System.out.println("1) Move/Exit\n" +
                                        "2) Buy\n" +
                                        "3) Sell\n" +
                                        "0) Exit Game");
                            }
                            else {
                                System.out.println("1) Move/Exit\n" +
                                        "2) Buy\n" +
                                        "3) Sell\n" +
                                        "4) Heal\n" +
                                        "0) Exit Game");
                            }
                            int selection = scan.nextInt();
                            switch (selection) {
                                case 1:
                                    game.movePlayer();
                                    isAtShop = false;
                                    break;
                                case 2: // player buys an item
                                    vendor.sell(player);
                                    break;
                                case 3: // player sells an item
                                    vendor.buy(player);
                                    break;
                                case 4:
                                    if (vendor instanceof Wizard) {
                                        ((Wizard) vendor).heal(player);
                                    }
                                    else {
                                        System.out.println("No such button exists");
                                    }
                                    break;
                                case 0:
                                    System.exit(0);
                                default:
                                    System.out.println("No such button exists");
                            }
                        }
                        continue;
                    }
                    Enemy enemy = game.generateEnemy();
                    if (enemy != null) {
                        while (!enemy.isDead()) {
                            boolean correctButton = false;
                            while (!correctButton) {
                                player.displayHp();
                                enemy.displayHp();
                                System.out.println("1) Attack 2) Use Magical Sand");
                                int choice = scan.nextInt();
                                switch (choice) {
                                    case 1:
                                        player.attack(enemy);
                                        if (enemy.isDead()) {
                                            player.winTheBattle(enemy.getLocalXp(), enemy.getLocalCoins());
                                            correctButton = true;
                                            break;
                                        }
                                        enemy.attack(player);
                                        if (player.isDead()) {
                                            player.gameOver();
                                        }
                                        break;
                                    case 2:
                                        if (player.useMagicalSand(enemy)) {
                                            player.winTheBattle(enemy.getLocalXp(), enemy.getLocalCoins());
                                            correctButton = true;
                                        }
                                        break;
                                    default:
                                        System.out.println("No such button exists");
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    player.showStats();
                    break;
                case 3:
                    // this type of initialization of subservience can be changed if I update the game later
                    player.eatApple(15);
                    break;
                case 4:
                    String info = player.getName() + "," + player.getHp() + "," + player.getAccuracy() + "," +
                            player.getWeapon() + "," + player.getMaxHp() + "," + player.getNextLvlXp() + "," +
                            game.getxPos() + "," + game.getyPos() + "," + player.getLvl() + "," + player.getXp() + "," +
                            player.getCoins() + "," + player.getNumOfApples() + "," + player.getNumOfMagicalSand();
                    GameSystem.saveGame(info);
                case 0:
                    isPlaying = false;
                    break;
                default:
                    System.out.println("No such button exists");
            }
        }
    }
}
