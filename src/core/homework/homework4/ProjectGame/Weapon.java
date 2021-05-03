package core.homework.homework4.ProjectGame;

import core.homework.homework4.ProjectGame.helper.Range;

public class Weapon {
    private String name;
    private Range damageRange;

    public Weapon(String name, int left, int right) {
        this.name = name;
        damageRange = new Range(left, right);
    }

    public String getName() {
        return name;
    }

    public Range getDamageRange() {
        return damageRange;
    }

    @Override
    public String toString() {
        return name + "," + damageRange;
    }
}
