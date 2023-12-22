import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Spell {
    Scanner in = new Scanner(System.in);
    private String name;
    private String description;
    private double manaCost;
    private double price;
    private ArrayList<Spell> spells;

    public Spell(String name, String description, double manaCost, double price) {
        this.name = name;
        this.description = description;
        this.manaCost = manaCost;
        this.price = price;
    }

    public Spell(){

    }

    public void spells(Hero hero) {
        System.out.println("What would you like to purchase? ");
        System.out.println("1. 'Frost nova' - 'Cost: 50 MP' - 'price: 78 gold'");
        System.out.println("2. 'Double damage' - 'Cost: 58 MP' - 'price: 82 gold'");
        System.out.println("3. 'Avada-Kadabra' - 'Cost: 150 MP' - 'price: 205 gold'");
        System.out.println("4. 'Magic shield' - 'Cost: 43 MP' - 'price: 57 gold'");
        String frostNovaDescription = "Frost nova is a spell that deals damage and stuns the opponent for x amount of rounds " +
                "based on the level difference and the dice roll";

        String doubleDamageDescription = "Gives the hero double damage in x amount of rounds based on the number of the dice";

        String avadaKadabraDescription = "I believe you know the Harry-Potter universe? This spells kills the opponent immediately " +
                "if the odds are in your favor. It's 50/50 if it is the monster or you that gets killed. Furthermore, " +
                "there will be added/subtracted 5% extra risk for backfire pr level difference there is between the hero and monster";

        String magicShieldDescription = "Gives the hero ekstra 30 armor for x amount of rounds based on the number of the dice";
        int number = in.nextInt();
        in.nextLine();
        spellsSwitch(number, hero, frostNovaDescription, doubleDamageDescription, avadaKadabraDescription, magicShieldDescription);
    }

    public void spellsSwitch(int number, Hero hero, String frostNovaDescription, String doubleDamageDescription, String avadaKadabraDescription, String magicShieldDescription) {
        spells = new ArrayList<>();
        spells.add(new Spell("Frost nova", frostNovaDescription, 50, 78));
        spells.add(new Spell("Double damage", doubleDamageDescription, 58, 82));
        spells.add(new Spell("Avada-Kadabra", avadaKadabraDescription, 150, 205));
        spells.add(new Spell("Magic shield", magicShieldDescription, 43, 57));

        goldEnoughForSpell(number, spells, hero);

    }

    public void goldEnoughForSpell(int number, ArrayList<Spell> spells, Hero hero) {
        if (number >= 1 && number <= spells.size()) {
            Spell selectedSpell = spells.get(number - 1);
            if (hero.getGold() >= selectedSpell.price) {
                buyingSpell(selectedSpell, hero);
            } else {
                System.out.println("\033[31m" + "You don't have the gold to buy that spell" + "\033[0m");
            }
        } else {
            System.out.println("\033[31m" + "Invalid spell selection" + "\033[0m");
        }
    }

    private void buyingSpell(Spell spell, Hero hero) {
        // Tilføj udstyr til helten og opdater heltenes guld
        for (int i = 0; i < hero.getHeroSpells().size(); i++) {
            if (spell.name.equalsIgnoreCase(hero.getHeroSpells().get(i).name)) {
                System.out.println("\n" + "\033[34m" + "You already have: " + spell.name + "\n" + "\033[0m");
                return;
            }
        }
        System.out.println("\n" + "\033[34m" + spell.name + " has been purchased!\n" + "\033[0m");


        hero.addSpell(spell);
        hero.setGold((int) (hero.getGold() - spell.price));

    }

    public String showSpellsThatAreAvailable(Hero hero) {
        if (hero.getHeroSpells().isEmpty()) {
            System.out.println("You dont know any spells at the moment!");
        }
        else {
            System.out.println("What spell do you want to use: ");
            for (int i = 0; i < hero.getHeroSpells().size(); i++) {
                System.out.println((i + 1) + ". " + hero.getHeroSpells().get(i).name);
            }
            int number = in.nextInt() - 1;
            in.nextLine();
            return updateHeroStatsAfterUsedSpell(number, hero);

        }
return null;
    }

    public String updateHeroStatsAfterUsedSpell(int number, Hero hero) {
        hero.setMana(hero.getMana() - hero.getHeroSpells().get(number).manaCost);
        return hero.getHeroSpells().get(number).name;
    }

    public int frostNova(Hero hero, Monster monster) {
        RunProgram runProgram = new RunProgram();
        Random random = new Random();
        System.out.println("You chose to use frost nova.");
        System.out.println("It deals 150% of your normal attackPower.");
        runProgram.pressEnterToContinue();
        System.out.println("You have to roll a dice to see how many rounds you stun your opponent.");
        System.out.println("If the hero and monster is evenly leveled: YOU CAN STUN 1, 2 OR 3 ROUNDS");
        runProgram.pressEnterToContinue();
        System.out.println("If the monster is higher/lower leveled than the hero, then 1+- stun-round will be added/subtracted for each level difference.");
        System.out.println("If the monster is 3 levels or more higher than the hero, then there is no chance for any stun rounds.");
        runProgram.pressEnterToContinue();
        int levelDifference = hero.getLevel() - monster.getLevel();
        System.out.println("The level difference between hero and monster is: " + levelDifference);
        if (levelDifference == 0) {
            return random.nextInt(3) + 1;
        }
        else if (levelDifference > 0) {
            return random.nextInt(3 + levelDifference) + 1;
        }
        else if (levelDifference >= -3) {
            return random.nextInt(3 + levelDifference) + 1;
        }
        else {
            return 0;
        }

    }


}
