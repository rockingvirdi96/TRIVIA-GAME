package app;

import java.util.Scanner;
import java.lang.Math;

public class App {

    public static void main(String[] args) throws Exception {
        // GameData gd = new GameData();
        Person p = new Person("Manager Singh", "manager", "manager123", "manager@gmail.com");
        Game game = new Game();
        User u = new User();
        boolean trial = true;
        short choiceOne = 0;
        short choiceTwo = 0;

        ////////////////////////////////////
        // for (int i = 0; i < 20; i++) {
        // int random = (int) ((Math.random() * 10) - 8);
        // if (random < 0) {
        // random *= -1;
        // }S
        // System.out.println(random);
        // }
        ////////////////////////////////////

        // Game Execution Experiment
        // game.ReadyQuiz(game.selectCategory());
        // for (String y : game.getAnswers()) {
        // System.out.println(y);
        // }
        // for (String x : game.getQuestions()) {
        // System.out.println(x);
        // }
        // game.DisplayQuestion();

        // GameData Example
        // gd.createData();
        // System.out.println(gd.getCategories() + "\n");
        // System.out.println(gd.getIceBreakers() + "\n");
        // System.out.println(gd.getCountries() + "\n");
        // System.out.println(gd.getMovies() + "\n");

        // Main Program..
        while (trial) {
            System.out.println("\n\n-- WELCOME TO TRIVIA --");
            System.out.println("=======================");
            Scanner input = new Scanner(System.in);
            trial = false;
            System.out.println("1.Login (If already registered)");
            System.out.println("2.Register to the game.");
            System.out.println("3.Exit.");
            System.out.print("Enter your choice: ");
            try {
                choiceOne = input.nextShort();
                if (choiceOne < 1 || choiceOne > 3) {
                    System.out.println("Wrong value only 3 options available.");
                    trial = true;
                }
                if (choiceOne == 1) {
                    do {
                        Scanner inputt = new Scanner(System.in);
                        trial = false;
                        System.out.println("1.Login as the Manager.");
                        System.out.println("2.Login as a Player.");
                        try {
                            choiceTwo = inputt.nextShort();

                            if (choiceTwo == 1) {
                                p.Login();
                                ///////////////////////////////
                                trial = true;
                                break;
                            } else if (choiceTwo == 2) {
                                u.Login();
                                ///////////////////////////////
                                trial = true;
                                break;
                            } else {
                                System.out.println("Wrong choice mon ami.");
                                trial = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Only 2 choices available.Enter 1 or 2");
                            trial = true;
                        }
                    } while (trial);
                    if (choiceTwo == 1) {
                        // Edit Game and its rules.
                    }
                    if (choiceTwo == 2) {
                        game.ReadyQuiz(game.selectCategory());
                        game.PlayQuestion();
                    }
                } else if (choiceOne == 2) {
                    u.Register();
                    trial = true;
                } else if (choiceOne == 3) {
                    System.out.println("Exiting Now......");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Only 1-3 choices available.Enter 1,2 or 3.");
                trial = true;
            }

        }

    }
}