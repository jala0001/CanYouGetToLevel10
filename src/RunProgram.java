import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RunProgram {
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

        boolean menu = true;
        while (menu) {
            updateHeroStats();
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
        System.out.println("Name: " + hero.getName() + "\nHealth: " + hero.getHealth() + "\nAttackPower: " + hero.getAttackPower()
                + "\nDefence: " + hero.getDefence() + "\nXP: " + hero.getXp() + "\nGold: " + hero.getGold() + "\nLevel: " + hero.getLevel());
        System.out.println();
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
        // todo    if (heroArrayList.get(0))

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
        int number = in.nextInt();
        in.nextLine();
        numberFromGoToBattle(number);
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
        int rolls = 0;
        double maxHealth = hero.getHealth();
        double heroDefence = hero.getDefence() / 100;
        double monsterDefence = monster.getDefence() / 100;
        System.out.print("Welcome to the battle! Lets see the stats of the hero: ");
        printHeroStats(hero);
        System.out.println("Lets see the stats of the monster: " + monster);
        while (hero.getHealth() > 0 && monster.getHealth() > 0) {
            System.out.println("It's your turn! Would you like to roll the dice or make a normal attack? Type 'roll' or 'attack'");
            String rollOrAttack = in.nextLine();
            if (rollOrAttack.equalsIgnoreCase("roll")) {
                rolls++;
                int number = random.nextInt(6) + 1;
                System.out.println("Guess the number of the dice before you roll it: " );
                System.out.println(number);
                int guess = in.nextInt();
                in.nextLine();
                System.out.println("The dice showed " + number + " and you guessed the number " + guess);
                pressEnterToContinue();
                if (number - guess == 0) {
                    System.out.println("You guessed right! You will now deal half the amount of the monster's current HP.");
                    double defenceBack = monsterDefence * (monster.getHealth() / 2);
                    System.out.println("The monsters defence blocked " + defenceBack + " damage!");
                    System.out.println("The damage you will be dealing is: " + (monster.getHealth() / 2 - defenceBack));
                    monster.setHealth(monster.getHealth() / 2 + defenceBack);
                }
                else if (number - guess == 1 || number - guess == -1) {
                    System.out.println("You were one away from the correct number and you will gain 25% of your max health.");
                    System.out.println("That means that you get " + (maxHealth * 0.25) + " more HP");
                    double twentyFive = maxHealth * 0.25;
                    hero.setHealth(hero.getHealth() + twentyFive);
                }
                else {
                    System.out.println("That was unlucky! You will now lose 10% of your current health");
                    System.out.println("Which is: " + hero.getHealth() * 0.1 + "HP you lost");
                    hero.setHealth(hero.getHealth() * 0.9);
                }
            }
            if (rollOrAttack.equalsIgnoreCase("attack")) {
                System.out.println("You chose to attack, which deals " + hero.getAttackPower() + " damage!");
                double defenceBack = monsterDefence * hero.getAttackPower();
                System.out.println("The monsters defence blocked " + defenceBack + " damage!");
                monster.setHealth(monster.getHealth() - hero.getAttackPower() + defenceBack);
            }
            pressEnterToContinue();
            System.out.println("Now it is the monsters turn!");
            System.out.println("The monster attacks with the power of " + monster.getAttackPower() + " damage!");
            double defenceBack = heroDefence * monster.getAttackPower();
            System.out.println("The hero's defence blocked " + defenceBack + "damage");
            hero.setHealth(hero.getHealth() - monster.getAttackPower() + defenceBack);
            pressEnterToContinue();
            System.out.println("The stats of the hero: ");
            printHeroStats(hero);
            System.out.println("The stats of the monster: " + monster);
        }
        if (hero.getHealth() > 0) {
            System.out.println("Hero won!");
            System.out.println("Amount of rolls you made: " + rolls);
            System.out.println("you get 10XP pr roll you made");
            System.out.println("You gain 50XP for defeating the monster plus the bonus from the rolls!");
            System.out.println("This monster was level " + monster.getLevel() + " and you get 100xp pr level over 1 from the monster");
            double xp = rewardAfterBattle(monster) + (rolls * 10);
            System.out.println("You gained " + xp + " xp!");
            hero.setHealth(maxHealth);
            hero.setXp(xp + hero.getXp());
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

    public double rewardAfterBattle(Monster monster) {
        double monsterLevel = monster.getLevel() - 1;
        return 50 + (100 * monsterLevel);
    }




    public void updateHeroStats() {
        if (heroArrayList.isEmpty()) {

        } else {
            if (hero.getLevel() < 2) {
                if (hero.getXp() >= 100 && hero.getXp() < 250) {
                    hero.setLevel(2);
                    hero.setAttackPower(hero.getAttackPower() * 1.5);
                    hero.setDefence(hero.getDefence() + 0.5);
                    hero.setHealth(hero.getHealth() * 1.5);
                }
            }

            if (hero.getLevel() < 3) {
                if (hero.getXp() >= 250 && hero.getXp() < 625) {
                    hero.setLevel(3);
                    hero.setAttackPower(hero.getAttackPower() * 1.5);
                    hero.setDefence(hero.getDefence() + 0.75);
                    hero.setHealth(hero.getHealth() * 1.5);
                }
            }

            if (hero.getLevel() < 4) {
                if (hero.getXp() >= 625 && hero.getXp() < 1550) {
                    hero.setLevel(4);
                    hero.setAttackPower(hero.getAttackPower() * 1.5);
                    hero.setDefence(hero.getDefence() + 1);
                    hero.setHealth(hero.getHealth() * 1.5);
                }
            }
        }
    }

    public Monster monsterForEachLevel(double number) {
        String name = "Monster level " + number;
        double health = 93 * number;
        double attackPower = 8 * number;
        double defence = 0 + number;
        double level = 0 + number;
        Monster newMonster = new Monster(name, health, attackPower, defence, level);
        return newMonster;

    }

}
