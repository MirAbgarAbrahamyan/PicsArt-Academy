package core.homework.homework4.ProjectGame;

public abstract class Character {
    protected String name;
    protected int hp;
    protected int accuracy;
    protected Weapon weapon;

    public Character(String name, int hp, int accuracy, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.accuracy = accuracy;
        this.weapon = weapon;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void displayHp() {
        System.out.println(name + "'s HP = " + hp);
    }

    public abstract void attack(Character character);
}
