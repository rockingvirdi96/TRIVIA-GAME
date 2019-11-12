package app;

import java.util.Scanner;
// import java.io.File;

/**
 * Game
 */
public class Game extends GameData {
    // Welcome to the Game.
    public void startGame() {
        short index = 0;
        boolean trial = true;
        short choiceOne = 0;
        Scanner input = new Scanner(System.in);
        while (true) {
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

            }
        }

    }

}