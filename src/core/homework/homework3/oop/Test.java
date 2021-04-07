package core.homework.homework3.oop;

public class Test {
    private static boolean checkForEnemies(Enemy enemy) {
        if (enemy != null)
            return true;
        System.out.println("There is no enemy");
        return false;
    }

    public static void main(String[] args) {
        Player player = new Player();
        player.setName("Zelda");
        player.displayData();

        Enemy enemy = new Enemy();
        enemy.setName("Zombie");
        enemy.setHp(50);
        enemy.displayData();

        /*
        // Game Over Test
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        enemy.attack(player);
        */

        if (checkForEnemies(enemy)) {
            player.attack(enemy);
            if (enemy.isDead())
                enemy = null;
            enemy.displayData();
        }
        if (checkForEnemies(enemy)) {
            enemy.attack(player);
            enemy.attack(player);
            player.displayData();
            player.attack(enemy);
            if (enemy.isDead()) {
                // we didn't cover parsing but I prefer to add this king of logic here :)
                // random number in [1, 10] range
                player.setXp(player.getXp() + ((int) (Math.random() * 9)) + 1);
                player.levelUp(player.getXp());
                enemy = null;
            }
        }
        if (checkForEnemies(enemy))
            enemy.displayData();
        player.displayData();
    }
}
