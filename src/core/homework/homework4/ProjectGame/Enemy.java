package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Service;

public class Enemy extends Character {
    private int localXp;
    private int localCoins;

    public Enemy(String name, int hp, int accuracy,
                 Weapon weapon, int localXp) {
        super(name, hp, accuracy, weapon);
        this.localXp = localXp;
        this.localCoins = Service.random(0, 50);
    }

    @Override
    public void attack(Character player) {
        System.out.print(name + " attacks you with " + weapon.getName());
        if (Service.random(0, 30) < accuracy) {
            int damage = Service.random(weapon.getDamageRange());
            System.out.println(" and you are hit for " + damage + "!\n");
            player.takeDamage(damage);
        }
        else {
            System.out.println(" and " + name + " misses!\n");
        }
    }

    public int getLocalXp() {
        return localXp;
    }

    public int getLocalCoins() {
        return localCoins;
    }
}
