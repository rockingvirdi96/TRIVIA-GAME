package app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.math.*;

/**
 * gamee
 */
public class Game extends GameData {
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    short choiceOne = 0;

    public ArrayList<String> getQuestions() {
        return this.questions;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    // Welcome to the Game.
    public short selectCategory() {
        createData();
        boolean trial = true;
        while (trial) {
            Scanner input = new Scanner(System.in);
            short index = 0;
            trial = false;
            System.out.println("Select the Category for the Questions.");
            for (String x : getCategories()) {
                System.out.println((index + 1) + "." + x);
                index++;
            }
            try {
                choiceOne = input.nextShort();
                if (choiceOne < 1 || choiceOne > 3) {
                    System.out.println("Wrong value only 3 options available.");
                    trial = true;
                }
            } catch (Exception e) {
                System.out.println("Wrong option Selected.");
                trial = true;
            }
        }
        this.eraseData();
        return choiceOne;
    }

    public void DivideQuestionAndAnswers(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                this.questions.add(list.get(i));
            } else {
                this.answers.add(list.get(i));
            }
        }
    }

    public void ReadyQuiz(short choice) {

        this.answers.clear();
        this.questions.clear();
        if (choice == 1) {
            this.createData();
            DivideQuestionAndAnswers(this.getIceBreakers());
        }
        if (choice == 2) {
            this.createData();
            DivideQuestionAndAnswers(this.getCountries());
        }
        if (choice == 3) {
            this.createData();
            DivideQuestionAndAnswers(this.getMovies());
        }
    }

    public void DisplayQuestion() {
        short x = 0;
        for (String question : this.questions) {
            System.out.println("\n" + (x + 1) + question + "\n");
            x++;
            for (int i = 0; i < 4; i++) {
                int random = (int) ((Math.random() * 10) - 1);
                if (random < 0) {
                    random *= -1;
                }
                System.out.println(i + 1 + this.answers.get(random));
            }
        }
    }
}