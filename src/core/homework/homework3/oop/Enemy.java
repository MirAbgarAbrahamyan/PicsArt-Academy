package core.homework.homework3.oop;

public class Enemy {
    private String name;
    private int hp = 75;
    private int maxHp = 75;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // I wouldn't create a setHp method, I would initialize it by constructor to avoid future bugs
    // but we haven't covered that topic yet so I use only the things that we've covered
    // also the name of the enemy could be generated in the constructor because the enemy's name
    // cannot be changed during the game, but the main player's name can be changed
    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
            maxHp = hp;
        }
        else {
            System.out.println("Warning! The enemy's hp cannot be negative or 0 initially." +
                               " So the enemy's initial hp will be set the default value (75)");
        }
    }

    public void attack(Player player) {
        System.out.println("The enemy attacked and took 10 hp from you!");
        player.getDamage(10);
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    // again we could use inheritance
    public boolean isDead() {
        return hp <= 0;
    }

    public void displayData() {
        System.out.println("Enemy's Data\n" +
                "Name:  " + name + "\n" +
                "HP:    " + hp + "/" + maxHp + "\n");
    }
}
