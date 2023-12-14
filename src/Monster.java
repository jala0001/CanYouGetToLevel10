public class Monster {
    private String name;
    private double health;
    private double attackPower;
    private double defence;
    private double level;

    public Monster(String name, double health, double attackPower, double defence, double level) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defence = defence;
        this.level = level;
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

    public double getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nHealth: " + health + "\nAttackPower: " + attackPower + "\nDefence: " + defence + "\nLevel: " + level;
    }
}
