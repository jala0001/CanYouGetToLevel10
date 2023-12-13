import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RunProgram {
    private ArrayList<Hero> heroArrayList = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    Random random = new Random();
    public static void main(String[] args) {
        new RunProgram().run();
    }

    private void run() {
        if (heroArrayList.isEmpty()) {
            presentationToTheGame();
            createHero();
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
        }
        else {
            System.out.println("Invalid input. Try agian");
            pressEnterToContinue();
        }
    }

    public void printHeroStats(Hero hero) {
        System.out.println("Your hero's stats at the moment: ");
        System.out.println("Name: " + hero.getName() + "\nHealth: " + hero.getHealth() + "\nAttackPower: " + hero.getAttackPower()
                + "\nDefence: " + hero.getDefence() + "\nXP: " + hero.getXp() + "\nGold: " + hero.getGold());
    }
}
