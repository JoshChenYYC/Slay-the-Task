public class Monster extends Lifeform {

    public static final int EXP = 0;
    public static final int LEVEL = 0;
    public static final int HP = 5;
    public static final int ATTACK = 2;
    public static final int SPEED = 2;

    public Monster(String name) {
        super(EXP, LEVEL, HP, ATTACK, SPEED, HP, name);
    }
}
