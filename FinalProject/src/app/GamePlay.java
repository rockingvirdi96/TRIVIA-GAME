package app;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GamePlay extends GameData {
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    short choiceOne = 0;
    boolean trial = true;
    GameData gd = new GameData();

    public ArrayList<String> getQuestions() {
        return this.questions;
    }

    public ArrayList<String> getAnswers() {
        return this.answers;
    }

    public void clearData() {
        this.answers.clear();
        this.questions.clear();
    }

    public short selectCategory(GameData gd) throws IOException {
        gd.updateData();
        boolean trial = true;
        while (trial) {
            Scanner input = new Scanner(System.in);
            short index = 0;
            trial = false;
            System.out.println("\nSelect the Category for the Quiz:-");
            for (String x : gd.getCategories()) {
                System.out.println((index + 1) + "." + x);
                index++;
            }
            try {
                choiceOne = input.nextShort();
                if (choiceOne < 1 || choiceOne > gd.getCategories().size()) {
                    System.out.println("Wrong value only " + gd.getCategories().size() + " options available.");
                    trial = true;
                }
            } catch (Exception e) {
                System.out.println("Wrong value entered.");
                trial = true;
            }
        }
        return (short) (choiceOne - 1);
    }

    public short selectCategory() throws IOException {
        gd.updateData();
        boolean trial = true;
        while (trial) {
            Scanner input;
            short index = 0;
            trial = false;
            System.out.println("\nSelect the Category for the Quiz:-");
            for (String x : gd.getCategories()) {
                System.out.println((index + 1) + "." + x);
                index++;
            }
            try {
                input = new Scanner(System.in);
                choiceOne = input.nextShort();
                if (choiceOne < 1 || choiceOne > gd.getCategories().size()) {
                    System.out.println("Wrong value.");
                    trial = true;
                }
            } catch (Exception e) {
                System.out.println("Only digits please.");
                trial = true;
            }
        }
        return (short) (choiceOne - 1);
    }

    public void DivideQuestionAndAnswers(String Question, String Answer) {
        this.questions.add(Question);
        this.answers.add(Answer);

    }

    public void DivideQandA(GameData gd) throws IOException {
        this.clearData();
        gd.updateData();
        String answer = "";
        String question = "";
        short choice = this.selectCategory();
        String SelectedCat = "cat" + gd.getCategories().get(choice);
        for (String x : gd.getQuestionAnswers()) {
            if (x.equals(SelectedCat)) {
                for (int y = (gd.getQuestionAnswers().indexOf(x) + 1), index = 0; index < 10; y += 2, index++) {
                    question = gd.getQuestionAnswers().get(y);
                    answer = gd.getQuestionAnswers().get(y + 1);
                    DivideQuestionAndAnswers(question, answer);
                }
            } else {
                if (question != "") {
                    break;
                }
            }
        }

    }

}
