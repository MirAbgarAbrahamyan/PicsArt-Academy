package core.homework.homework3.oop;

public class Player {
    private String name;
    private int hp = 100;
    private int maxHp = 100;
    private int level = 1;
    private int xp;
    private int maxXp = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Enemy enemy) {
        System.out.println("You have attacked and took 25 hp from the enemy!");
        enemy.takeDamage(25);
    }

    public void getDamage(int damage) {
        hp -= damage;
        if (isDead())
            gameOver();
    }

    public boolean isDead() {
        return hp <= 0;
    }

    private void gameOver() {
        System.out.println("\n\nGAME OVER!");
        System.exit(0);
    }

    public void levelUp(int xp) {
        if (xp >= maxXp) {
            this.xp = maxXp - xp;
            maxXp *= 10;
            level++;
        }
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    // here we could implement the method, because both classes have the same method
    // but we didn't cover it yet so I don't include it
    public void displayData() {
        System.out.println("Player's Data\n" +
                "Name:  " + name + "\n" +
                "HP:    " + hp + "/" + maxHp + "\n" +
                "Level: " + level + "\n" +
                "XP:    " + xp + "/" + maxXp + "\n");
    }
}
