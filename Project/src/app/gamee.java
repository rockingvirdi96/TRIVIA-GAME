package app;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * gamee
 */
public class gamee extends GameData {
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<String> answers = new ArrayList<>();

    public gamee() {

    }

    // Welcome to the Game.
    public short selectCategory() {
        boolean trial = true;
        short choiceOne = 0;
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
        return choiceOne;
    }

    public void DivideQuestionAndAnswers(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (String x : list) {
                if (i % 2 == 0) {
                    this.answers.add(x);
                } else {
                    this.questions.add(x);
                }
            }
        }
    }

    public void ReadyQuiz(this.selectCategory()) {
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

    
}