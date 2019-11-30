package app;

import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User
 */
public class User extends Manager {
    private short timesPlayed = 0;
    private short correctAnswer = 0;
    GameData gd = new GameData();

    public short getcorrectAnswer() {
        return correctAnswer;
    }

    public void IncrementCorrectAnswer() {
        correctAnswer += 1;
    }

    public void resetScore() {
        correctAnswer = 0;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void IncrementTimesPlayed() {
        this.timesPlayed += 1;
    }

    public void PlayQuestion(User u) throws IOException {
        GamePlay game = new GamePlay();
        game.DivideQandA(gd);
        boolean trial = true;
        this.resetScore();
        float result = 0;
        for (int i = 0; i < game.getQuestions().size(); i++) {
            String currentQuestion = game.getQuestions().get(i);
            String answer = game.getAnswers().get(i);
            short UserAnswer = 0;

            ArrayList<String> options = new ArrayList<String>();

            System.out.println((i + 1) + ". " + currentQuestion);
            while (options.size() != 4) {
                int random = ThreadLocalRandom.current().nextInt(0, 10);

                if (!options.contains(game.getAnswers().get(random)) && (game.getAnswers().get(random) != answer)) {
                    options.add(game.getAnswers().get(random));
                }
            }
            int random = ThreadLocalRandom.current().nextInt(0, 4);
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

    }

}
