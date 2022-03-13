import java.util.Scanner;

public class BattleFrame {

    Character hero;
    Lifeform monster;

    public BattleFrame(Character hero, Lifeform monster) {
        this.hero = hero;
        this.monster = monster;
    }

    private void askUser() {
        System.out.println("What action will you take?");
        System.out.println("1. Attack");
        System.out.println("2. Heal");

        Scanner input = new Scanner(System.in);

        int option = input.nextInt();

        while (option != 1 && option != 2) {
            System.out.println("Please enter either 1 or 2!");
            option = input.nextInt();
        }

        if (option == 1) {
            hero.attack(monster);
        }

        if (option == 2) {
            hero.heal();
        }
    }

    public void fightTurns() {

        while (monster.getHp() > 0) {

            display();
            askUser();
            if (monster.getHp() <= 0) {
                System.out.println("The monster has been slain!");
                hero.setExp(hero.getExp() + 2);
                hero.checkLevel();
                hero.setHp(hero.getMaxHp());
                monster.setHp(monster.getMaxHp());
                return;

            }

            monster.attack(hero);

            if (hero.getHp() <= 0) {
                System.out.println("The monster has killed you! Do more tasks!");
                hero.setHp(hero.getMaxHp());
                monster.setHp(monster.getMaxHp());
                return;

            }
        }
    }



    private void display() {
        System.out.println("Hero HP: " + hero.getHp());
        System.out.println("Monster HP: " + monster.getHp());
    }

}
