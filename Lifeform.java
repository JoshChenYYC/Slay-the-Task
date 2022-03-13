public abstract class Lifeform {

    boolean alive = true;
    int exp;
    int level;
    int hp;
    int attack;
    int speed;
    int maxHp;
    String name;

    public Lifeform(int exp, int level, int hp, int attack, int speed, int maxHp, String name) {
        this.exp = exp;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.maxHp = maxHp;
        this.name = name;
    }

    public int getExp() {
        return this.exp;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHp() {
        return this.hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public int speed() {
        return this.speed;
    }

    public String getName() {
        return this.name;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    public int getMaxHp(){
        return this.maxHp;
    }

    public void takeDamage(int attackDamage) {
        this.hp = this.hp - attackDamage;
    }

    public void attack(Lifeform target) {
        int attackDamage = this.getAttack();
        target.takeDamage(attackDamage);
        System.out.println(this.getName() + " attacks " + target.getName());
    }

    public void heal() {
        this.hp  += this.hp * 0.10;
        System.out.println(this.getName() + " heals for " + this.hp * 0.10);
    }






}
