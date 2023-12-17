public class Gear {
    private String name;
    private double increasedHp;
    private double increasedAttackPower;
    private double increasedDefence;
    private int price;
    private int helmetIsx;



    public Gear(String name, double increasedHp, double increasedAttackPower, double increasedDefence, int price, int helmetIs1) {
        this.name = name;
        this.increasedHp = increasedHp;
        this.increasedAttackPower = increasedAttackPower;
        this.increasedDefence = increasedDefence;
        this.price = price;
        this.helmetIsx = helmetIs1;
    }

    public Gear() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncreasedHp() {
        return increasedHp;
    }

    public void setIncreasedHp(double increasedHp) {
        this.increasedHp = increasedHp;
    }

    public double getIncreasedAttackPower() {
        return increasedAttackPower;
    }

    public void setIncreasedAttackPower(double increasedAttackPower) {
        this.increasedAttackPower = increasedAttackPower;
    }

    public double getIncreasedDefence() {
        return increasedDefence;
    }

    public void setIncreasedDefence(double increasedDefence) {
        this.increasedDefence = increasedDefence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHelmetIsx() {
        return helmetIsx;
    }

    public void setHelmetIsx(int helmetIsx) {
        this.helmetIsx = helmetIsx;
    }


}
