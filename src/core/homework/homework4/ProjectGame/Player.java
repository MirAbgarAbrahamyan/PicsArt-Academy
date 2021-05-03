package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Service;

public class Player extends Character {
    private int xp;
    private int lvl;
    private int maxHp;
    private int nextLvlXp;
    private int coins;
    // we did not cover Lists yet in our course so it is possible that I can update and add
    // list of Items (Item = class name) instead of this uncomfortable way i.e. numOfApples and numOfMagicalSand
    private int numOfApples;
    private int numOfMagicalSand;

    public Player(String name, int hp, int accuracy, Weapon weapon,
                  int maxHp, int nextLvlXp) {
        super(name, hp, accuracy, weapon);
        this.maxHp = maxHp;
        this.nextLvlXp = nextLvlXp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getNumOfApples() {
        return numOfApples;
    }

    public void setNumOfApples(int numOfApples) {
        this.numOfApples = numOfApples;
    }

    public int getNumOfMagicalSand() {
        return numOfMagicalSand;
    }

    public int getNextLvlXp() {
        return nextLvlXp;
    }

    public int getLvl() {
        return lvl;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setNextLvlXp(int nextLvlXp) {
        this.nextLvlXp = nextLvlXp;
    }

    public void setNumOfMagicalSand(int numOfMagicalSand) {
        this.numOfMagicalSand = numOfMagicalSand;
    }

    @Override
    public void attack(Character enemy) {
        System.out.print(name + " you attack a " + enemy.getName() +
                " with your " + weapon.getName());
        if (Service.random(0, 20) < accuracy) {
            int damage = Service.random(weapon.getDamageRange());
            System.out.println(" and you take " + damage + "!\n");
            enemy.takeDamage(damage);
        }
        else {
            System.out.println(" and you miss!\n");
        }
    }

    public void showStats() {
        System.out.println("\tYOUR STATS\n-----------------------------\n" +
                "Name:              " + name + "\n" +
                "HP:                " + hp + "\n" +
                "Accuracy:          " + accuracy + "\n" +
                "Weapon:            " + weapon.getName() + "\n" +
                "XP:                " + xp + "\n" +
                "Level:             " + lvl + "\n" +
                "Max HP:            " + maxHp + "\n" +
                "XP for Next Level: " + nextLvlXp + "\n" +
                "Coins:             " + coins + "\n" +
                "Number of Apples:  " + numOfApples + "\n" +
                "Number of Mag.Sand:" + numOfMagicalSand);
    }

    public void winTheBattle(int xp, int coins) {
        System.out.println("YOU WIN\n You have earned " + xp + " XP and " + coins + " coins");
        this.xp += xp;
        this.coins += coins;
        lvlUp();
    }

    public void lvlUp() {
        if (xp >= nextLvlXp) {
            lvl++;
            xp -= nextLvlXp;
            nextLvlXp = nextLvlXp + lvl * 100;
        }
    }

    // Die
    public void gameOver() {
        System.out.println("#############################\n" +
                "\t\tGAME OVER" +
                "#############################");
        System.exit(0);
    }

    public void eatApple(int subservience) {
        if (numOfApples > 0) {
            if (hp + subservience < maxHp) {
                hp += subservience;
            }
            else {
                hp = maxHp;
            }
            System.out.println("You have ate an apple and now you have " + hp + " HP");
            numOfApples--;
        }
        else {
            System.out.println("You haven't an apple to eat");
        }
    }

    public boolean useMagicalSand(Character enemy) {
        if (numOfMagicalSand > 0) {
            enemy.takeDamage(enemy.getHp());
            numOfMagicalSand--;
            return true;
        }
        System.out.println("You do not have a magical sand to use");
        return false;
    }
}
