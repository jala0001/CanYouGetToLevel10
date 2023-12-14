public class Hero {
    private String name;
    private double health;
    private double attackPower;
    private double defence;
    private double xp;
    private int gold;
    private int level;
    private Gear helmet;
    private Gear body;
    private Gear leg;
    private Gear boots;
    private Items items;

    public Hero(String name, double health, double attackPower, double defence) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defence = defence;
        this.xp = 0;
        this.gold = 0;
    }

    public Hero(String name, double health, double attackPower, double defence, double xp, int gold, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defence = defence;
        this.xp = xp;
        this.gold = gold;
        this.level = level;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name + "," + health + "," + attackPower + "," + defence + "," + xp + "," + gold + "," + level;
    }
}
