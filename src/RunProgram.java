import java.util.*;

public class RunProgram {
    private Gear gear = new Gear();
    private ArrayList<Hero> heroArrayList = new ArrayList<>();
    private ArrayList<Gear> helmetGear;
    private ArrayList<Gear> weaponGear;

    private Items items = new Items();
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
            hero = heroArrayList.get(0);
        }

        boolean menu = true;
        while (menu) {
            updateHeroStats();
            double maxHealth = hero.getHealth();
            hero.setMaxHealth(maxHealth);
            double maxMana = hero.getMana();
            hero.setMaxMana(maxMana);
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
        System.out.println("\033[31m" + "Health: " + String.format("%.2f", hero.getHealth()) + "\033[0m");
        System.out.println("\033[35m" + "AttackPower: " + String.format("%.2f", hero.getAttackPower()) + "\033[0m");
        System.out.println("\033[37m" + "Defence: " + String.format("%.2f", hero.getDefence()) + "\033[0m");
        System.out.println("\033[34m" + "mana: " + String.format("%.2f", hero.getMana()) + "\033[0m");
        System.out.println("\033[32m" + "XP: " + String.format("%.0f", hero.getXp()) + "\033[0m");
        System.out.println("\033[33m" + "Gold: " + hero.getGold() + "\033[0m");
        System.out.println("\033[36m" + "Level: " + hero.getLevel() + "\033[0m");
        System.out.println();
        if (hero.getHeroGears() != null) {
            for (int i = 0; i < hero.getHeroGears().size(); i++) {
                if (hero.getHeroGears().get(i).getHelmetIsx() == 1) {
                    System.out.print("Helmet-Gear: ");
                } else {
                    System.out.print("Weapon-Gear: ");
                }
                System.out.println("\033[95m" + hero.getHeroGears().get(i).getName() + "\033[0m" + "\n");

            }

        }
        if (!hero.getHeroItems().isEmpty()) {
            System.out.println("Items: ");
            for (int i = 0; i < hero.getHeroItems().size(); i++) {
                if (hero.getHeroItems().get(i).getAmountOfHpPoints() > 0) {
                    System.out.println("\033[31m" +hero.getHeroItems().get(i).getName() + " - Gives: " + hero.getHeroItems().get(i).getAmountOfHpPoints() + "HP" +"\033[0m");
                } else {
                    System.out.println("\033[34m" +hero.getHeroItems().get(i).getName() + " - Gives: " + hero.getHeroItems().get(i).getAmountOfManaPoints() + "MP" + "\033[0m");
                }
            }
            System.out.println("\033[0m");

        }
        else {
            System.out.println("No items\n");
        }
    }


    public void printHeroStatsWithoutGoldAndXp(Hero hero) {
        System.out.println();
        System.out.println("\033[34m" + "Name: " + hero.getName() + "\033[0m");

        System.out.println("\033[31m" + "Health: " + String.format("%.2f", hero.getHealth()) + "/" + String.format("%.2f", hero.getMaxHealth()) + "\033[0m");

        System.out.println("\033[35m" + "AttackPower: " + String.format("%.2f", hero.getAttackPower()) + "\033[0m");

        System.out.println("\033[37m" + "Defence: " + String.format("%.2f", hero.getDefence()) + "\033[0m");

        System.out.println("\033[34m" + "Mana: " + String.format("%.2f", hero.getMana()) + "/" + String.format("%.2f", hero.getMaxMana()) + "\033[0m");

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
    }


    public void mainMenu() { // todo fejlHåndtering
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
            case 3 -> items.buyItems(heroArrayList);
            case 4 -> goToBattle();
        }

    }

    public void buyGear() { // todo fejlHåndtering
        System.out.println("What would you like to purchase?");
        System.out.println("1. Helmet");
        System.out.println("2. Body armor");
        System.out.println("3. Weapons");
        System.out.println("4. Boots");
        int number = in.nextInt();
        in.nextLine();
        gearSwitch(number);
    }
    public void gearSwitch(int number) {
        switch (number) {
            case 1 -> helmetGear();
            case 2 -> bodyArmorGear();
            case 3 -> weapons();
            case 4 -> bootsGear();
            default -> buyGear();
        }
    }
    public void helmetGear() {
        System.out.println("Which helmet do you want to buy?");

        System.out.println("\033[32m" + "1. 'Featherlight-helmet' - '50 HP' - '0 attackPower' - '0.5 defense' - PRICE: 8 gold");
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
        helmetGear = new ArrayList<>();
        helmetGear.add(new Gear("Featherlight-helmet", 50, 0, 0.5, 8, 1));
        helmetGear.add(new Gear("Soft-helmet", 100, 0, 0.8, 170, 1));
        helmetGear.add(new Gear("Guard-helmet", 200, 0, 1.1, 340, 2));
        helmetGear.add(new Gear("Iron-helmet", 400, 0, 1.4, 680, 1));
        helmetGear.add(new Gear("SilverMoon-helmet", 800, 0, 1.7, 1360, 1));
        helmetGear.add(new Gear("StormForged-helmet", 1600, 0, 2, 3000, 1));
        helmetGear.add(new Gear("DragonBone-helmet", 3200, 0, 2.3, 6050, 1));
        helmetGear.add(new Gear("WarBringer-helmet", 6400, 0, 2.6, 14610, 1));
        helmetGear.add(new Gear("InfernoSkull-helmet", 12800, 0, 3, 29000, 1));
        helmetGear.add(new Gear("Pikachu-cap", 30000, 0, 6, 60000, 1));

       GoldEnoughForGear(number, helmetGear);
    }
    public void GoldEnoughForGear(int number, ArrayList<Gear> gear) {
        if (number >= 1 && number <= gear.size()) {
            Gear selectedGear = gear.get(number - 1);
            if (hero.getGold() >= selectedGear.getPrice()) {
                buyingGear(selectedGear);
            } else {
                System.out.println("\033[31m" + "You don't have the gold to buy that item" + "\033[0m");
            }
        } else {
            System.out.println("\033[31m" + "Invalid gear selection" + "\033[0m");
        }
    }

    private void buyingGear(Gear gear) {
        // Tilføj udstyr til helten og opdater heltenes guld
        for (int i = 0; i < hero.getHeroGears().size(); i++) {
            if (gear.getName().equalsIgnoreCase(hero.getHeroGears().get(i).getName())) {
                System.out.println("\n" + "\033[34m" + "You already have: " + gear.getName() + "\n" + "\033[0m");
                return;
            }
        }
        System.out.println("\n" + "\033[34m" + gear.getName() + " has been purchased!\n" + "\033[0m");
        for (int i = 0; i < hero.getHeroGears().size(); i++) {
            if (hero.getHeroGears().get(i).getHelmetIsx() == 1 && gear.getHelmetIsx() == 1) {
                System.out.println(hero.getHeroGears().get(i).getName() + " has been removed!");
                hero.updateStatsBasedOnGearDeleted(hero.getHeroGears().get(i));
                hero.removeGear(hero.getHeroGears().get(i));
                // todo Denne metode skal have noget frisk hjerne, godnat!
            }
        }

        for (int i = 0; i < hero.getHeroGears().size(); i++) {
            if (hero.getHeroGears().get(i).getHelmetIsx() == 2 && gear.getHelmetIsx() == 2) {
                System.out.println(hero.getHeroGears().get(i).getName() + " has been removed!");
                hero.updateStatsBasedOnGearDeleted(hero.getHeroGears().get(i));
                hero.removeGear(hero.getHeroGears().get(i));
                // todo Denne metode skal have noget frisk hjerne, godnat!
            }
        }
        hero.addGear(gear);
        hero.setGold(hero.getGold() - gear.getPrice());

        // Opdater heltenes stats baseret på det nye udstyr
        hero.updateStatsBasedOnGear(hero);

        // Gem opdateringer til fil
        filer.gemHeroTilFil(heroArrayList, "hero.txt");
    }


    public void bodyArmorGear() {
        System.out.println("1. ");
    }

    public void weapons() {
        System.out.println("\033[32m" + "1. Plush Bunny Hammer - '0HP' - '5 attackPower' - '0 defence' - 'PRICE: 85");
        System.out.println("2. Thunder Staff - '0HP' - '7 attackPower' - '0 defence' - 'PRICE: 148'");
        System.out.println("3. Glowblade - '0HP' - '10 attackPower' - '0 defence' - 'PRICE: 260'" + "\033[0m");

        System.out.println("\033[33m" + "4. Frost Halberd - '0HP' - '13 attackPower' - '0 defence' - 'PRICE: 455'");
        System.out.println("5. Shadowblade - '0HP' - '17 attackPower' - '0 defence' - 'PRICE: 797'");
        System.out.println("6. Flame Halberd - '0HP' - '22 attackPower' - '0 defence' - 'PRICE: 1395'");
        System.out.println("7. Lightning Axe - '0HP' - '28 attackPower' - '0 defence' - 'PRICE: 2441'" + "\033[0m");

        System.out.println("\033[31m" + "8. Earthquake Hammer - '0HP' - '37 attackPower' - '0 defence' - 'PRICE: 4272'");
        System.out.println("9. Hurricane Boomerang - '0HP' - '48 attackPower' - '0 defence' - 'PRICE: 7476'");
        System.out.println("10. Cosmic Annihilator - '0HP' - '63 attackPower' - '0 defence' - 'PRICE: 13084'" + "\033[0m");
        int number = in.nextInt();
        in.nextLine();
        weaponsGearSwitch(number);
    }

    public void weaponsGearSwitch(int number) {
        weaponGear = new ArrayList<>();
        weaponGear.add(new Gear("Plush Bunny Hammer", 0, 5, 0, 85, 2));
        weaponGear.add(new Gear("Thunder Staff", 0, 7, 0, 148, 2));
        weaponGear.add(new Gear("Glowblade", 0, 10, 0, 260, 2));
        weaponGear.add(new Gear("Frost Halberd", 0, 13, 0, 455, 2));
        weaponGear.add(new Gear("Shadowblade", 0, 17, 0, 797, 2));
        weaponGear.add(new Gear("Flame Halberd", 0, 22, 0, 1395, 2));
        weaponGear.add(new Gear("Lightning Axe", 0, 28, 0, 2441, 2));
        weaponGear.add(new Gear("Earthquake Hammer", 0, 37, 0, 4272, 2));
        weaponGear.add(new Gear("Hurricane Boomerang", 0, 48, 0, 7476, 2));
        weaponGear.add(new Gear("Cosmic Annihilator", 0, 63, 0, 13084, 2));

       GoldEnoughForGear(number, weaponGear);

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
            if (rollOrAttack.equalsIgnoreCase("roll")) { // todo - alle if og else skal i egne metoder så man ikke mister en tur ved at prøve at bruge et item som ikke eksisterer!
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
            if (rollOrAttack.equalsIgnoreCase("Use item")) {
                if (!hero.getHeroItems().isEmpty()) {
                    whichItemDoYouWantToUse();
                }
                else {
                    System.out.println("You dont have any items available");
                }

            }

            if (rollOrAttack.equalsIgnoreCase("Use spell")) {
                Spell spell = new Spell();
                String whatSpell = spell.showSpellsThatAreAvailable(hero);
                if (whatSpell.equalsIgnoreCase("Frost nova")) {
                   int stuns = spell.frostNova(hero, monster);
                   // todo lav heroVsMonster til mindre metoder så dette kan implementeret!


                }
                else if (whatSpell.equalsIgnoreCase("Double damage")) {
                    System.out.println("buubbuub");
                }

                else if (whatSpell.equalsIgnoreCase("Avada-Kadabra")) {

                }
                else {

                }

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
            System.out.println("You gained " + "\033[92m" + xp + " XP!" + "\033[0m");
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

    public void whichItemDoYouWantToUse() {
        if (hero.getHeroItems().isEmpty()) { //todo logik skal ændres til at være i heroVsMonster
            System.out.println("You dont have any items available");
            rollOrAttackHero();
            return;
        }
        System.out.println("Which item do you want to use?" );
        for (int i = 0; i < hero.getHeroItems().size(); i++) {
            if (hero.getHeroItems().get(i).getAmountOfHpPoints() > 0) {
                System.out.println("\033[31m" + (i + 1) + ". " + hero.getHeroItems().get(i) + hero.getHeroItems().get(i).getAmountOfHpPoints() + "HP" + "\033[0m");
            }
            else if (hero.getHeroItems().get(i).getAmountOfManaPoints() > 0) {
                System.out.println("\033[34m" + (i + 1) + ". " + hero.getHeroItems().get(i) + hero.getHeroItems().get(i).getAmountOfManaPoints() + "MP" + "\033[0m");
            }
        }
        int number = in.nextInt() - 1;
        in.nextLine();
        updateHeroStatsAfterUsedItem(number);


    }

    public void updateHeroStatsAfterUsedItem(int number) {
        if (hero.getHeroItems().get(number).getAmountOfHpPoints() > 0) {
            System.out.println("You chose to use: " + "\033[31m" + hero.getHeroItems().get(number).getName() + "\033[0m");
            if (hero.getHealth() + hero.getHeroItems().get(number).getAmountOfHpPoints() <= hero.getMaxHealth()) {
                System.out.print("Your heros health went from: " + "\033[31m" + String.format("%.2f", hero.getHealth()) + "HP" + "\033[0m");
                hero.setHealth(hero.getHealth() + hero.getHeroItems().get(number).getAmountOfHpPoints());
                System.out.println(" to: " + "\033[31m" + String.format("%.2f", hero.getHealth()) + "HP" + "\033[0m");
            } else {
                System.out.println("You hero is now at max health. You only used: " + "\033[31m" + String.format("%.2f", (hero.getMaxHealth() - hero.getHealth())) + "HP" + "\033[0m" + " from the potion");
                hero.setHealth(hero.getMaxHealth());
            }
        }
        else {
            System.out.println("You chose to use: " + "\033[34m" + hero.getHeroItems().get(number).getName() + "\033[0m");
            if (hero.getMana() + hero.getHeroItems().get(number).getAmountOfManaPoints() <= hero.getMaxMana()) {
                System.out.print("Your heros mana went from: " + "\033[34m" + String.format("%.2f", hero.getMana()) + "MP" + "\033[0m");
                hero.setMana(hero.getMana() + hero.getHeroItems().get(number).getAmountOfManaPoints());
                System.out.println(" to: " + "\033[34m" + String.format("%.2f", hero.getMana()) + "MP" + "\033[0m");
            } else {
                System.out.println("You hero is now at max mana. You only used: " + "\033[34m" + String.format("%.2f", (hero.getMaxMana() - hero.getMana())) + "MP" + "\033[0m" + " from the potion");
                hero.setMana(hero.getMaxMana());
            }

        }
        hero.getHeroItems().remove(hero.getHeroItems().get(number));
       // hero.setHealth(hero.getHealth() + hero.getHeroItems().get(number).getAmountOfHpPoints()); todo lav samme for mana


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
        double attackPowerMultiplier = 7; // todo giv brugeren mulighed for selv at vælge den stat de vil have forøget!
        double defenceIncrement = 0.5;
        double healthMultiplier = 35;

        for (int i = hero.getLevel(); i < xpThresholds.length; i++) {
            if (hero.getXp() >= xpThresholds[i] && hero.getXp() < xpThresholds[i + 1]) {
                hero.setLevel(i + 1);
                hero.setAttackPower((hero.getAttackPower() + attackPowerMultiplier) + (hero.getLevel() * 1.75));
                hero.setDefence((hero.getDefence() + defenceIncrement) + ((double) hero.getLevel() / 3));
                hero.setHealth((hero.getHealth() + healthMultiplier) * 1.13);
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
        double health = (93 * number) * 1.28;
        double attackPower = (8 * number) * 1.35;
        double defence = number * 1.16;
        return new Monster(name, health, attackPower, defence, number);
    }


}
