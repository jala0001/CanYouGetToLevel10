import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        
    }

