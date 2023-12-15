import java.util.*;

public class RunProgram {
    private Gear gear = new Gear();
    private ArrayList<Hero> heroArrayList = new ArrayList<>();
    private Filer filer = new Filer();
    private Hero hero;
    Scanner in = new Scanner(System.in);
    Random random = new Random();

    public static void main(String[] args) {
        new RunProgram().run();
    }

    private void run() {
    heroArrayList = filer.indlæsHeroFraFil("hero.txt");
        if (heroArrayList.isEmpty()) {
            presentationToTheGame();
            createHero();
        }
        hero = heroArrayList.get(0);
        if (hero.isInBattle()) {
            heroArrayList.remove(hero);
            filer.gemHeroTilFil(heroArrayList, "hero.txt");
            presentationToTheGame();
            createHero();
        }

        boolean menu = true;
        while (menu) {
            updateHeroStats();
            double maxHealth = hero.getHealth();
            hero.setMaxHealth(maxHealth);
            mainMenu();
        }

    }


    public void createHero() {
        System.out.println("What's your name? ");
        String name = in.nextLine();
        double health = 125;
        double attackPower = 12;
        double defence = 0;
        Hero newHero = new Hero(name, health, attackPower, defence);
        printHeroStats(newHero);
        heroArrayList.add(newHero);
        filer.gemHeroTilFil(heroArrayList, "hero.txt");
    }


    public void presentationToTheGame() {
        System.out.println("Hello champion and welcome to the game where your main objective is to reach and beat level 10!");
        pressEnterToContinue();
        System.out.println("Through the game you will gain gear, items and XP that will help you increase your level");
        pressEnterToContinue();
        System.out.println("Every round you are in charge of which level you will try to beat, but be careful..");
        pressEnterToContinue();
        System.out.println("If the level you picked is to differcult for your hero to beat, you will die and you will have to start over");
        pressEnterToContinue();
        System.out.println("I hope you are ready. Press Enter to create your hero!");
        pressEnterToContinue();
    }

    public void pressEnterToContinue() {
        System.out.println("Press ENTER to continue");
        String enter = in.nextLine();
        if (enter.equalsIgnoreCase("")) {
        } else {
            System.out.println("Invalid input. Try agian");
            pressEnterToContinue();
        }
    }

    public void printHeroStats(Hero hero) {
        System.out.println("Your hero's stats at the moment: ");
        System.out.println("\033[34m" + "Name: " + hero.getName() + "\033[0m");
        System.out.println("\033[31m" + "Health: " + hero.getHealth() + "\033[0m");
        System.out.println("\033[35m" + "AttackPower: " + hero.getAttackPower() + "\033[0m");
        System.out.println("\033[37m" + "Defence: " + hero.getDefence() + "\033[0m");
        System.out.println("\033[32m" + "XP: " + hero.getXp() + "\033[0m");
        System.out.println("\033[33m" + "Gold: " + hero.getGold() + "\033[0m");
        System.out.println("\033[36m" + "Level: " + hero.getLevel() + "\033[0m");
        System.out.println();
    }


    public void printHeroStatsWithoutGoldAndXp(Hero hero) {
        System.out.println();
        System.out.println("\033[34m" + "Name: " + hero.getName() + "\033[0m");

        System.out.println("\033[31m" + "Health: " + String.format("%.2f", hero.getHealth()) + "/" + String.format("%.2f", hero.getMaxHealth()) + "\033[0m");

        System.out.println("\033[35m" + "AttackPower: " + String.format("%.2f", hero.getAttackPower()) + "\033[0m");

        System.out.println("\033[37m" + "Defence: " + String.format("%.2f", hero.getDefence()) + "\033[0m");

        System.out.println("\033[36m" + "Level: " + hero.getLevel() + "\033[0m");

        System.out.println();

    }

    public void printMonsterStats(Monster monster) {
        System.out.println("\033[34m" + "Name: " + monster.getName() + "\033[0m");
        System.out.println("\033[31m" + "Health: " + String.format("%.2f", monster.getHealth()) + "/" + String.format("%.2f", monster.getMaxHealth()) + "\033[0m");
        System.out.println("\033[35m" + "AttackPower: " + String.format("%.2f", monster.getAttackPower()) + "\033[0m");
        System.out.println("\033[37m" + "Defence: " + String.format("%.2f", monster.getDefence()) + "\033[0m");
        System.out.println("\033[36m" + "Level: " + monster.getLevel() + "\033[0m");
        System.out.println();
        // todo
    }


    public void mainMenu() {
        System.out.println("Type the number of the desired option: ");
        System.out.println("1. See hero stats");
        System.out.println("2. Buy gear");
        System.out.println("3. Buy items");
        System.out.println("4. Go to battle!");
        int number = in.nextInt();
        in.nextLine();
        numberFromMainMenu(number);
    }

    public void numberFromMainMenu(int number) {
        switch (number) {
            case 1 -> printHeroStats(heroArrayList.get(0));
            case 2 -> buyGear();
            case 3 -> buyItems();
            case 4 -> goToBattle();
        }

    }

    public void buyGear() {
        System.out.println("What would you like to purchase?");
        System.out.println("1. Helmet");
        System.out.println("2. body armor");
        System.out.println("3. leg armor");
        System.out.println("4. Boots");
        int number = in.nextInt();
        in.nextLine();
        gearSwitch(number);
    }
    public void gearSwitch(int number) {
        switch (number) {
            case 1 -> helmetGear();
            case 2 -> bodyArmorGear();
            case 3 -> legArmorGear();
            case 4 -> bootsGear();
            default -> buyGear();
        }
    }
    public void helmetGear() {
        System.out.println("Which helmet do you want to buy?");

        System.out.println("\033[32m" + "1. 'Featherlight-helmet' - '50 HP' - '0 attackPower' - '0.5 defense' - PRICE: 85 gold");
        System.out.println("2. 'Soft-helmet' - '100 HP' - '0 attackPower' - '0.8 defense' - PRICE: 170 gold");
        System.out.println("3. 'Guard-helmet' - '200 HP' - '0 attackPower' - '1.1 defense' - PRICE: 340 gold" + "\033[0m");


        System.out.println("\033[33m" + "4. 'Iron-helmet' - '400 HP' - '0 attackPower' - '1.4 defense' - PRICE: 680 gold");
        System.out.println("5. 'SilverMoon-helmet' - '800 HP' - '0 attackPower' - '1.7 defense' - PRICE: 1360 gold");
        System.out.println("6. 'StormForged-helmet' - '1600 HP' - '0 attackPower' - '2.0 defense' - PRICE: 3000 gold");
        System.out.println("7. 'DragonBone-helmet' - '3200 HP' - '0 attackPower' - '2.3 defense' - PRICE: 6050 gold" + "\033[0m");


        System.out.println("\033[31m" + "8. 'WarBringer-helmet' - '6400 HP' - '0 attackPower' - '2.6 defense' - PRICE: 14610 gold");
        System.out.println("9. 'InfernoSkull-helmet' - '12800 HP' - '0 attackPower' - '3.0 defense' - PRICE: 29000 gold");
        System.out.println("10. 'Pikachu-cap' - '30000 HP' - '0 attackPower' - '6.0 defense' - PRICE: 60000 gold" + "\033[0m");

        int number = in.nextInt();
        in.nextLine();
        helmetGearSwitch(number);
    }



    public void helmetGearSwitch(int number) {
        List<Gear> gears = new ArrayList<>();
        gears.add(new Gear("Featherlight-helmet", 50, 0, 0.5, 85));
        gears.add(new Gear("Soft-helmet", 100, 0, 0.8, 170));
        gears.add(new Gear("Guard-helmet", 200, 0, 1.1, 340));
        gears.add(new Gear("Iron-helmet", 400, 0, 1.4, 680));
        gears.add(new Gear("SilverMoon-helmet", 800, 0, 1.7, 1360));
        gears.add(new Gear("StormForged-helmet", 1600, 0, 2, 3000));
        gears.add(new Gear("DragonBone-helmet", 3200, 0, 2.3, 6050));
        gears.add(new Gear("WarBringer-helmet", 6400, 0, 2.6, 14610));
        gears.add(new Gear("InfernoSkull-helmet", 12800, 0, 3, 29000));
        gears.add(new Gear("Pikachu-cap", 30000, 0, 6, 60000));

        if (number >= 1 && number <= gears.size()) {
            Gear selectedGear = gears.get(number - 1);
            if (hero.getGold() >= selectedGear.getPrice()) {
                buyHelmet(selectedGear);
            } else {
                System.out.println("\033[31m" + "You don't have the gold to buy that item" + "\033[0m");
            }
        } else {
            System.out.println("\033[31m" + "Invalid gear selection" + "\033[0m");
        }
    }

    private void buyHelmet(Gear gear) {
        hero.setHelmet(gear);
        hero.setGold(hero.getGold() - gear.getPrice());
        hero.setHealth(hero.getHealth() + gear.getIncreasedHp());
        hero.setAttackPower(hero.getAttackPower() + gear.getIncreasedAttackPower());
        hero.setDefence(hero.getDefence() + gear.getIncreasedDefence());
        filer.gemHeroTilFil(heroArrayList, "hero.txt");
    }


    public void bodyArmorGear() {
        System.out.println("hej2");
    }

    public void legArmorGear() {
        System.out.println("hej3");
    }

    public void bootsGear() {
        System.out.println("hej4");
    }

    public void buyItems() {

    }

    public void goToBattle() {
        System.out.println("I hope you are ready for battle " + hero.getName() + "!");
        pressEnterToContinue();
        System.out.println("You can choose any level you want and if you beat level 10 then you win the game!");
        pressEnterToContinue();
        System.out.println("But keep in mind, that if you die, you will have to start over!");
        pressEnterToContinue();
        System.out.println("Type a number from 1-10, where the number equals the level of the round!");
        while (true) {
            try {
                int number = in.nextInt();
                in.nextLine();
                numberFromGoToBattle(number);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again");
                in.nextLine();
            }
        }

    }

    public void numberFromGoToBattle(int number) {
        switch (number) {
            case 1 -> levelOne();
            case 2 -> levelTwo();
            case 3 -> levelThree();
            case 4 -> levelFour();
            case 5 -> levelFive();
            case 6 -> levelSix();
            case 7 -> levelSeven();
            case 8 -> levelEight();
            case 9 -> levelNine();
            case 10 -> levelTen();
        }
    }

    public void levelOne() {
    Monster monster = monsterForEachLevel(1);
    introToBattle();
    heroVsMonster(monster);
    }

    public void levelTwo() {
      if (hero.getLevel() < 2) {
          warningToPlayer();
      }
        Monster monster = monsterForEachLevel(2);
        heroVsMonster(monster);
    }

    public void levelThree() {
        if (hero.getLevel() < 3) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(3);
        heroVsMonster(monster);
    }

    public void levelFour() {
        if (hero.getLevel() < 4) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(4);
        heroVsMonster(monster);
    }

    public void levelFive() {
        if (hero.getLevel() < 5) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(5);
        heroVsMonster(monster);
    }

    public void levelSix() {
        if (hero.getLevel() < 6) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(6);
        heroVsMonster(monster);
    }

    public void levelSeven() {
        if (hero.getLevel() < 7) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(7);
        heroVsMonster(monster);
    }

    public void levelEight() {
        if (hero.getLevel() < 8) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(8);
        heroVsMonster(monster);
    }

    public void levelNine() {
        if (hero.getLevel() < 9) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(9);
        heroVsMonster(monster);
    }

    public void levelTen() {
        if (hero.getLevel() < 10) {
            warningToPlayer();
        }
        Monster monster = monsterForEachLevel(10);
        heroVsMonster(monster);
    }

    public void warningToPlayer() {
        System.out.println("WARNING! This level is beyond your hero's level. Be careful!");
        pressEnterToContinue();
    }

    public void introToBattle() {
        System.out.println("You are about to go into battle! There are a few things you should know.");
        pressEnterToContinue();
        System.out.println("You will have the choice of rolling a dice that shows the numbers 1-6");
        pressEnterToContinue();
        System.out.println("If you choose to roll the dice, then the following things can happen: ");
        pressEnterToContinue();
        System.out.println("if you hit the correct number, then you attack will deal half the amount of the monster's current HP");
        pressEnterToContinue();
        System.out.println("If you are +-1 away from the currect number, then you will gain 25% of your max health");
        pressEnterToContinue();
        System.out.println("If you are more than +-1 away, then you will lose your turn and lose 10% of you current health");
        pressEnterToContinue();
    }

    public void heroVsMonster(Monster monster) {
        double monsterMaxHealth = monster.getHealth();
        monster.setMaxHealth(monsterMaxHealth);
        hero.setInBattle(true);
        filer.gemHeroTilFil(heroArrayList, "hero.txt");
        int rolls = 0;
        double maxHealth = hero.getHealth();
        double heroDefence = hero.getDefence() / 100;
        double monsterDefence = monster.getDefence() / 100;
        System.out.print("Welcome to the battle! Lets see the stats of the hero: ");
        printHeroStatsWithoutGoldAndXp(hero);
        System.out.println("______________________________________________\n");
        System.out.println("Lets see the stats of the monster: ");
        printMonsterStats(monster);
        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            String rollOrAttack = rollOrAttackHero();
            if (rollOrAttack.equalsIgnoreCase("roll")) {
                rolls++;
                int number = random.nextInt(6) + 1;
                System.out.println("Guess the number of the dice before you roll it: " );
               // System.out.println(number);
                int guess = in.nextInt();
                in.nextLine();
                System.out.println("The dice showed " + "\033[97m" + number + "\033[0m" + " and you guessed the number " + "\033[97m" + guess + "\033[0m");
                pressEnterToContinue();
                if (number - guess == 0) {
                    System.out.println("You guessed right! You will now deal half the amount of the monster's current HP.");
                    double defenceBack = monsterDefence * (monster.getHealth() / 2);
                    System.out.println("The monsters defence blocked " + "\033[37m" + String.format("%.2f", defenceBack) + "\033[0m" + " damage!");
                    System.out.println("The damage you will be dealing is: " + "\033[35m" + String.format("%.2f", (monster.getHealth() / 2 - defenceBack)) + "\033[0m" + " damage!");
                    monster.setHealth(monster.getHealth() / 2 + defenceBack);
                }
                else if (number - guess == 1 || number - guess == -1) {
                    System.out.println("You were one away from the correct number and you will gain 25% of your max health.");
                    System.out.println("That means that you get " + "\033[31m" + String.format("%.2f", maxHealth * 0.25) + "\033[0m" + " more HP"); // changed
                    double twentyFive = maxHealth * 0.25;
                    hero.setHealth(hero.getHealth() + twentyFive);
                }
                else {
                    System.out.println("That was unlucky! You will now lose 10% of your current health");
                    System.out.println("Which is: " + "\033[31m" + String.format("%.2f", hero.getHealth() * 0.1) + "\033[m" + "HP"); // C
                    hero.setHealth(hero.getHealth() * 0.9);
                }
            }
            if (rollOrAttack.equalsIgnoreCase("attack")) {
                System.out.println("You chose to attack, which deals " + "\033[35m" + String.format("%.2f", hero.getAttackPower()) + "\033[0m" + " damage!"); // C
                double defenceBack = monsterDefence * hero.getAttackPower();
                System.out.println("The monsters defence blocked " + "\033[37m" + String.format("%.2f", defenceBack) + "\033[0m" + " damage!"); // C
                monster.setHealth(monster.getHealth() - hero.getAttackPower() + defenceBack);
            }
            if (monster.getHealth() <= 0) {
                System.out.println("Monster defeated!");
                printHeroStatsWithoutGoldAndXp(hero);
                monster.setHealth(0);
                printMonsterStats(monster);
                break;
            }
            pressEnterToContinue();
            System.out.println("NOW IT IS THE MONSTERS TURN!");
            System.out.println("The monster attacks with the power of " + "\033[35m" + String.format("%.2f", monster.getAttackPower()) + "\033[0m" + " damage!"); // C
            double defenceBack = heroDefence * monster.getAttackPower();
            System.out.println("The hero's defence blocked " + "\033[37m" + String.format("%.2f", defenceBack) + "\033[0m" + "damage!"); // C
            hero.setHealth(hero.getHealth() - monster.getAttackPower() + defenceBack);
            if (hero.getHealth() <= 0) {
                System.out.println("______________\n" + "\033[97m" + "HERO DEFEATED!" + "\033[0m");
                System.out.println("______________");
                hero.setHealth(0);
                printHeroStatsWithoutGoldAndXp(hero);
                printMonsterStats(monster);
                break;
            }
            pressEnterToContinue();
            System.out.println("THE STATS OF THE HERO: ");
            printHeroStatsWithoutGoldAndXp(hero);
            System.out.println("______________________________________________\n");
            System.out.println("THE STATS OF THE MONSTER: ");
            printMonsterStats(monster);
        }
        if (hero.getHealth() > 0) {
            System.out.println("\n" + "\033[92m" + "HERO WON!" + "\033[0m");
            System.out.println("Amount of rolls you made: " + "\033[92m" + rolls + "\033[0m");
            System.out.println("you get 10XP pr roll you made: " + rolls + " * 10 = " + "\033[92m" + (rolls * 10) + " XP" + "\033[0m");
            System.out.println("You gain 50XP for defeating the monster + 100XP extra for each level the monster is above level 1: " + "\033[92m" +
                    ((monster.getLevel() - 1) * 100 + 50) + " XP" + "\033[0m");
            double xp = rewardAfterBattle(monster) + (rolls * 10);
            System.out.println("You gained " + "\033[92m" + xp + " xp!" + "\033[0m");
            int gold = (int) ((int) xp * 0.23);
            System.out.println("You also gained " + "\033[92m" + gold + " gold!\n" + "\033[0m");
            hero.setHealth(maxHealth);
            hero.setXp(xp + hero.getXp());
            hero.setGold(hero.getGold() + gold);
            hero.setInBattle(false);
            filer.gemHeroTilFil(heroArrayList, "hero.txt");


        }
        else {
            System.out.println("Monster won!");
            System.out.println("Game over...");
            heroArrayList.remove(hero);
            filer.gemHeroTilFil(heroArrayList, "hero.txt");
            System.exit(0);
        }
    }

    public String rollOrAttackHero() {
        while (true) {
            System.out.println("It's your turn! What would you like to do? ");
            System.out.println("\033[93m" + "1. Roll the dice");
            System.out.println("\033[93m" + "2. Attack" + "\033[0m");
            System.out.println("\033[93m" + "3. Use item" + "\033[0m");
            System.out.println("\033[93m" + "4. Use spell" + "\033[0m");
            int number = in.nextInt();
            in.nextLine();
            try {
                switch (number) {
                    case 1 -> {
                        return "Roll";
                    }
                    case 2 -> {
                        return "Attack";
                    }
                    case 3 -> {
                       return "Use item";
                    }
                    case 4 -> {
                        return "Use spell";
                    }
                }
                return rollOrAttackHero();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again");
                in.nextLine();
            }
        }
    }


    public double rewardAfterBattle(Monster monster) {
        double monsterLevel = monster.getLevel() - 1;
        return 50 + (100 * monsterLevel);
    }




    public void updateHeroStats() {
        if (heroArrayList.isEmpty()) {
            return;
        }

        int[] xpThresholds = {100, 300, 600, 1000, 1500, 2100, 2800, 3600, 4500, 5500, 6600, 7800, 9100, 10500, 12000};
        double attackPowerMultiplier = 1.5;
        double defenceIncrement = 0.5;
        double healthMultiplier = 1.5;

        for (int i = hero.getLevel(); i < xpThresholds.length; i++) {
            if (hero.getXp() >= xpThresholds[i] && hero.getXp() < xpThresholds[i + 1]) {
                hero.setLevel(i + 1);
                hero.setAttackPower(hero.getAttackPower() * attackPowerMultiplier);
                hero.setDefence(hero.getDefence() + defenceIncrement);
                hero.setHealth(hero.getHealth() * healthMultiplier);
                filer.gemHeroTilFil(heroArrayList, "hero.txt");
                break;
            }
        }
    }


    public Monster monsterForEachLevel(int number) {
        String[] monsterNames = {
                "Fluffy Bunny", // Level 1
                "Mischievous Imp", // Level 2
                "Sneaky Goblin", // Level 3
                "Shadow Sprite", // Level 4
                "Thorned Treant", // Level 5
                "Howling Werewolf", // Level 6
                "Crimson Vampire", // Level 7
                "Ghastly Wraith", // Level 8
                "Fearsome Gorgon", // Level 9
                "Abyssal Leviathan" // Level 10
        };

        String name = monsterNames[number - 1]; // Arrays er 0-indekseret, så træk 1 fra nummeret
        double health = (93 * number) * 1.16;
        double attackPower = (8 * number) * 1.16;
        double defence = number * 1.06;
        return new Monster(name, health, attackPower, defence, number);
    }


}
