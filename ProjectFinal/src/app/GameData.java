package app;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 * gamedata
 */
public class GameData {

    private ArrayList<String> Categories = new ArrayList<String>();
    private ArrayList<String> IceBreakers = new ArrayList<String>();
    private ArrayList<String> Countries = new ArrayList<String>();
    private ArrayList<String> Movies = new ArrayList<String>();

    public ArrayList<String> getCategories() {
        return this.Categories;
    }

    public ArrayList<String> getIceBreakers() {
        return this.IceBreakers;
    }

    public ArrayList<String> getCountries() {
        return this.Countries;
    }

    public ArrayList<String> getMovies() {
        return this.Movies;
    }

    public void createData() {
        File file = new File("D:\\Sem_Troisieme\\JAVA\\Projects\\Project\\src\\app\\dataFile.txt");
        try {
            short i = 0;
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isEmpty()) {
                    for (short x = 0; x < 10; x++) {
                        String Question = reader.nextLine();
                        String Answer = reader.nextLine();
                        if (i == 0) {
                            this.IceBreakers.add(Question);
                            this.IceBreakers.add(Answer);
                        }
                        if (i == 1) {
                            this.Countries.add(Question);
                            this.Countries.add(Answer);
                        }
                        if (i == 2) {
                            this.Movies.add(Question);
                            this.Movies.add(Answer);
                        }
                        if (i == 3) {
                            break;
                        }
                    }
                    i++;
                }
                if (i == 0) {
                    this.Categories.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
        }
    }

    public void eraseData() {
        this.Categories.clear();
        this.Countries.clear();
        this.IceBreakers.clear();
        this.Movies.clear();
    }
}