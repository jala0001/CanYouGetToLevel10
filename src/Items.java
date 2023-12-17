import java.util.ArrayList;
import java.util.Scanner;

public class Items {
    private String name;
    private double amountOfHpPoints;
    private double amountOfManaPoints;
    private double price;
    private ArrayList<Items> healthItem;
    private ArrayList<Items> manaItem;

    Scanner in = new Scanner(System.in);

    public Items() {

    }

    public Items(String name, double amountOfHpPoints, double amountOfManaPoints, double price) {
        this.name = name;
        this.amountOfHpPoints = amountOfHpPoints;
        this.amountOfManaPoints = amountOfManaPoints;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmountOfHpPoints() {
        return amountOfHpPoints;
    }

    public void setAmountOfHpPoints(double amountOfHpPoints) {
        this.amountOfHpPoints = amountOfHpPoints;
    }

    public double getAmountOfManaPoints() {
        return amountOfManaPoints;
    }

    public void setAmountOfManaPoints(double amountOfManaPoints) {
        this.amountOfManaPoints = amountOfManaPoints;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void buyItems(ArrayList<Hero> heroArrayList) {
        Hero hero = heroArrayList.get(0);
        System.out.println("What would you like to purchase?");
        System.out.println("1. Health potion");
        System.out.println("2. Mana potions");
        System.out.println("3. Spells"); // todo - skal måske rykkes
        System.out.println("4. xx");
        //todo              Spells
        int number = in.nextInt();
        in.nextLine();
        itemSwitch(number, hero);
    }

    public void itemSwitch(int number, Hero hero) {
        switch (number) {
           case 1 -> healthPotion(hero);
           case 2 -> manaPotion();
           case 3 -> spells();
           // case 4 -> bootsGear();
           // default -> buyGear();
        }
    }

    public void healthPotion(Hero hero) {
        System.out.println("What would you like to purchase: ");
        System.out.println("1. Little health potion - ' 75 HP' - 'price:  57 gold' ");
        System.out.println("2. Medium health potion - '231 HP' - 'price: 162 gold ");
        System.out.println("3. Large health potion  - '539 HP' - 'price: 328 gold");
        int number = in.nextInt();
        in.nextLine();
        healthPotionSwitch(number, hero);
    }

    public void healthPotionSwitch(int number, Hero hero) {
        healthItem = new ArrayList<>();
        healthItem.add(new Items("Featherlight-helmet", 75, 0, 57));
        healthItem.add(new Items("Soft-helmet", 231, 0, 162));
        healthItem.add(new Items("Guard-helmet", 539, 0, 328));

        GoldEnoughForItem(number, healthItem, hero);
    }

    public void GoldEnoughForItem(int number, ArrayList<Items> items, Hero hero) {
        if (number >= 1 && number <= items.size()) {
            Items selectedItem = items.get(number - 1);
            if (hero.getGold() >= selectedItem.getPrice()) {
                buyingGear(selectedItem, hero);
            } else {
                System.out.println("\033[31m" + "You don't have the gold to buy that item" + "\033[0m");
            }
        } else {
            System.out.println("\033[31m" + "Invalid gear selection" + "\033[0m");
        }
    }

    private void buyingGear(Items items, Hero hero) {
        System.out.println("heeeeeey");

        hero.addItem(items);
       // hero.setGold((int) (hero.getGold() - items.getPrice()));

    }

    public void manaPotion() {
        System.out.println("What would you like to purchase: ");
        System.out.println("1. Little mana potion - ' 75 MP' ");
        System.out.println("2. Medium mana potion - '231 MP' ");
        System.out.println("3. Large mana potion  - '539 MP'");
    }

    public void spells() {

    }


}
