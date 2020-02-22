package app;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
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

    public void createData() throws IOException {
        URL url = getClass().getResource("questionAnswers.txt");
        File file = new File(url.getPath());
        URL url2 = getClass().getResource("Categories.txt");
        File file2 = new File(url2.getPath());
        // File file2 = new File("./Categories.txt");
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
        URL url = getClass().getResource("questionAnswers.txt");
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.replaceAll(oldLine, newLine);
        FileWriter writer = new FileWriter(file);
        writer.append(fileContents);
        writer.flush();
    }

    public void addData(String x, String fileName) throws IOException {
        URL url = getClass().getResource(fileName);
        File file = new File(url.getPath());
        Scanner sc = new Scanner(file);
        StringBuffer buffer = new StringBuffer();
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine() + System.lineSeparator());
        }
        String fileContents = buffer.toString();
        sc.close();
        fileContents = fileContents.concat(x);
        FileWriter writer = new FileWriter(file);
        writer.append(fileContents);
        writer.flush();
    }

    public void eraseData() {
        this.Categories.clear();
        this.questionAnswers.clear();
    }
}