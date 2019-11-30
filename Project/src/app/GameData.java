package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

/**
 * gamedata
 */
public class GameData {

    private ArrayList<String> Categories = new ArrayList<String>();
    private ArrayList<String> questionAnswers = new ArrayList<String>();

    public void Gamedata(String name) {
    }

    public void setCategories(String x) {
        this.Categories.add(x);
    }

    public ArrayList<String> getCategories() {
        return this.Categories;
    }

    public void setQuestionAnswers(String x) {
        this.questionAnswers.add(x);
    }

    public ArrayList<String> getQuestionAnswers() {
        return this.questionAnswers;
    }

    // public ArrayList<String> getIceBreakers() {
    // return this.IceBreakers;
    // }

    // public ArrayList<String> getCountries() {
    // return this.Countries;
    // }

    // public ArrayList<String> getMovies() {
    // return this.Movies;
    // }

    // public void createData() {
    // File file = new
    // File("D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\questionAnswers");
    // File file2 =new File()
    // try {
    // short i = 0;
    // Scanner reader = new Scanner(file);
    // while (reader.hasNextLine()) {
    // String line = reader.nextLine();
    // if (line.isEmpty()) {
    // for (short x = 0; x < 10; x++) {
    // String Question = reader.nextLine();
    // String Answer = reader.nextLine();
    // if (i == 0) {
    // this.IceBreakers.add(Question);
    // this.IceBreakers.add(Answer);
    // }
    // if (i == 1) {
    // this.Countries.add(Question);
    // this.Countries.add(Answer);
    // }
    // if (i == 2) {
    // this.Movies.add(Question);
    // this.Movies.add(Answer);
    // }
    // if (i == 3) {
    // break;
    // }
    // }
    // i++;
    // }
    // if (i == 0) {
    // this.Categories.add(line);
    // }
    // }
    // } catch (FileNotFoundException e) {
    // System.out.println("File Not Found.");
    // }
    // }

    public void createData() throws IOException {
        File file = new File("D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\questionAnswers.txt");
        File file2 = new File("D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\Categories.txt");
        Scanner readCat = new Scanner(file2);
        Scanner readerQuestion = new Scanner(file);
        while (readCat.hasNextLine()) {
            String line = readCat.nextLine();
            this.Categories.add(line);
        }
        while (readerQuestion.hasNextLine()) {
            String line = readerQuestion.nextLine();
            this.questionAnswers.add(line);
        }
    }

    public void updateData() throws IOException {
        this.eraseData();
        this.createData();
    }

    public void modifyData(String oldLine, String newLine) throws IOException {
        String filePath = "D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\questionAnswers.txt";
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    public void addData(String x, String fileName) throws IOException {
        String filePath = "D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\" + fileName;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.concat(x);
        FileWriter writer = new FileWriter(filePath);
        writer.append(fileContents);
        writer.flush();
    }

    public void eraseData() {
        this.Categories.clear();
        this.questionAnswers.clear();
    }
}