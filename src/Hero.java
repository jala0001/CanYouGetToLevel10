public class Hero {
    private String name;
    private double health;
    private double maxHealth;
    private double attackPower;
    private double defence;
    private double xp;
    private int gold;
    private int level;
    private boolean inBattle;
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
        this.inBattle = false;
    }

    public Hero(String name, double health, double attackPower, double defence, double xp, int gold, int level, boolean inBattle) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defence = defence;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
        this.inBattle = inBattle;

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

    public boolean isInBattle() {
        return inBattle;
    }

    public void setInBattle(boolean inBattle) {
        this.inBattle = inBattle;
    }

    public Gear getHelmet() {
        return helmet;
    }

    public void setHelmet(Gear helmet) {
        this.helmet = helmet;
    }

    public Gear getBody() {
        return body;
    }

    public void setBody(Gear body) {
        this.body = body;
    }

    public Gear getLeg() {
        return leg;
    }

    public void setLeg(Gear leg) {
        this.leg = leg;
    }

    public Gear getBoots() {
        return boots;
    }

    public void setBoots(Gear boots) {
        this.boots = boots;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return name + "," + health + "," + attackPower + "," + defence + "," + xp + "," + gold + "," + level + "," + inBattle;
    }
}
