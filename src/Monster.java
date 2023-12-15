public class Monster {
    private String name;
    private double health;
    private double maxHealth;
    private double attackPower;
    private double defence;
    private int level;

    public Monster(String name, double health, double attackPower, double defence, int level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defence = defence;
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

    public double getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
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

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nHealth: " + health + "\nAttackPower: " + attackPower + "\nDefence: " + defence + "\nLevel: " + level;
    }
}
