package app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * gamee
 */
public class Game extends GameData {
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();
    // private ArrayList<String> options = new ArrayList<String>();
    short choiceOne = 0;
    boolean trial = true;

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
            System.out.println("\nSelect the Category for the Quiz:-");
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

    public void PlayQuestion() {

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
            Scanner input = new Scanner(System.in);
            while (trial) {
                Scanner inputt = new Scanner(System.in);
                System.out.print("Enter the correct answer(1-4):");
                UserAnswer = inputt.nextShort();
                if (UserAnswer < 1 || UserAnswer > 4) {
                    trial = true;
                } else {
                    trial = false;
                }
            }
            if (UserAnswer == (random + 1)) {
                System.out.println("Correct Answer");
            } else {
                System.out.println("Wrong Answer");
            }

        }

    }
}

// short x = 0;
// for (String question :questions) {
// System.out.println("\n" + (x + 1) + ". " + question + "\n");
// x++;
// for (int i = 0; i < 4; i++) {
// int random = (int) ((Math.random() * 10) - 1);
// if (random < 0) {
// random *= -1;
// }
// System.out.println((i + 1) + ". " + this.answers.get(random));
// }
// }