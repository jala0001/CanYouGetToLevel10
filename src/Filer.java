import java.io.*;
import java.util.ArrayList;

public class Filer {

    public void gemHeroTilFil(ArrayList<Hero> heroArrayList, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Hero hero : heroArrayList) {
                writer.write(hero.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        }


    public ArrayList<Hero> indlæsHeroFraFil(String filnavn) {
        ArrayList<Hero> heroArrayList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filnavn))) {
            String linje;
            while ((linje = reader.readLine()) != null) {
                Hero hero = opretMedlemFraString(linje);
                heroArrayList.add(hero);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return heroArrayList;
    }

    public Hero opretMedlemFraString(String linje) {
        String[] data = linje.split(",");
        String name = data[0];
        double health = Double.parseDouble(data[1]);
        double attackPower = Double.parseDouble(data[2]);
        double defence = Double.parseDouble(data[3]);
        double xp = Double.parseDouble(data[4]);
        int gold = Integer.parseInt(data[5]);
        int level = Integer.parseInt(data[6]);

        return new Hero(name, health, attackPower, defence, xp, gold, level);
    }
    }

