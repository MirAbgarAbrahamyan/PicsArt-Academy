package core.homework.homework4.ProjectGame;

public class Wizard implements Vendor {
    @Override
    public void greet() {
        System.out.println("Hello I am the wizard! you can buy a magical sand to" +
                " eliminate the enemies or you can sell something...\n" +
                "Also you can sell an apple to me and get healed here for 100% for free!");
    }

    @Override
    public void buy(Player player) {
        if (player.getNumOfApples() > 0) {
            player.setNumOfApples(player.getNumOfApples() - 1);
            player.setCoins(player.getCoins() + 5);
            System.out.println("You have sold an apple and now you have " + player.getCoins() + " coins");
        }
        else {
            System.out.println("You do not have an apple to sell");
        }
    }

    @Override
    public void sell(Player player) {
        if (player.getCoins() < 100) {
            System.out.println("Sorry but you cannot buy a magical sand, because you haven't enough money");
        }
        else {
            player.setCoins(player.getCoins() - 100);
            player.setNumOfMagicalSand(player.getNumOfMagicalSand() + 1);
            System.out.println("You have bought a magical sand and now you have " + player.getCoins() + " coins" +
                    " and " + player.getNumOfMagicalSand() + " magical sand");
        }
    }

    public void heal(Player player) {
        player.setHp(player.getMaxHp());
        System.out.println("You have been healed for 100%, now you have " + player.getHp());
    }
}
