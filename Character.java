public class Character extends Lifeform {


    public static final int EXP = 0;
    public static final int LEVEL = 0;
    public static final int HP = 5;
    public static final int ATTACK = 2;
    public static final int SPEED = 2;
    int levelUpRequirement = 2;


    public Character(String name) {
        super(EXP, LEVEL, HP, ATTACK, SPEED, HP, name);
    }

    public void levelUp() {
        this.exp = 0;
        this.level = this.level + 1;
        this.maxHp = this.maxHp + 1;
        this.hp = this.maxHp;
        this.attack = this.attack + 1;
        this.speed = this.speed + 1;
        this.levelUpRequirement = this.levelUpRequirement + 4;
    }

    public void checkLevel() {
        if (exp >= levelUpRequirement) {
            this.levelUp();
            System.out.println("This character has leveled up to level " + this.getLevel());
        }

    }





}





