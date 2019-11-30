package app;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Game extends GameData {
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
        this.updateData();
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

    public void PlayQuestion(User u) {
        u.resetScore();
        float result = 0;
        for (int i = 0; i < this.questions.size(); i++) {
            String currentQuestion = this.questions.get(i);
            String answer = this.answers.get(i);
            short UserAnswer = 0;

            ArrayList<String> options = new ArrayList<String>();

            System.out.println((i + 1) + ". " + currentQuestion);
            while (options.size() != 4) {
                int random = ThreadLocalRandom.current().nextInt(0, 10);

                if (!options.contains(this.answers.get(random)) && (this.answers.get(random) != answer)) {
                    options.add(this.answers.get(random));
                }
            }

            int random = ThreadLocalRandom.current().nextInt(0, 4);
            System.out.println(random);
            options.set(random, answer);
            for (String opt : options) {
                System.out.println("-- " + opt);
            }
            trial = true;
            while (trial) {
                Scanner input = new Scanner(System.in);
                try {
                    System.out.print("Enter the correct answer(1-4):");
                    UserAnswer = input.nextShort();
                    if (UserAnswer < 1 || UserAnswer > 4) {
                        System.out.println("Invalid input.");
                        trial = true;
                    } else {
                        trial = false;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    trial = true;
                }
            }
            if (UserAnswer == (random + 1)) {
                System.out.println("Correct Answer");
                u.IncrementCorrectAnswer();
            } else {
                System.out.println("Wrong Answer");
            }
            result = u.getcorrectAnswer();
        }
        System.out.println("Final Score: " + result / 10 * 100 + "%");

        this.eraseData();

    }
}
