package core.homework.homework4.ProjectGame;

public class Trader implements Vendor {
    @Override
    public void greet() {
        System.out.println("Hello I am the trader! You can buy an apple, eat and get some HP");
    }

    @Override
    public void buy(Player player) {
        if (player.getNumOfMagicalSand() > 0) {
            player.setNumOfMagicalSand(player.getNumOfMagicalSand() - 1);
            player.setCoins(player.getCoins() + 200); // the trader doesn't know about wizard's place XD (harif eli XD)
            System.out.println("You have sold a magical sand and now you have " + player.getCoins() + " coins");
        }
        else {
            System.out.println("You do not have a magical sand to sell");
        }
    }

    @Override
    public void sell(Player player) {
        if (player.getCoins() < 10) {
            System.out.println("Sorry but you cannot buy an apple, because you haven't enough money");
        }
        else {
            player.setCoins(player.getCoins() - 10);
            player.setNumOfApples(player.getNumOfApples() + 1);
            System.out.println("You have bought an apple and now you have " + player.getCoins() + " coins" +
                    " and " + player.getNumOfApples() + " apples");
        }
    }
}
