package app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Manager m = new Manager();
        Game game = new Game();
        User u = new User();
        GameData gd = new GameData();
        boolean trial = true;
        short choiceOne = 0;
        short choiceTwo = 0;

        // Main Program..
        while (trial) {

            System.out.println("\n\n-- WELCOME TO TRIVIA --");
            System.out.println("=======================");

            Scanner input = new Scanner(System.in);
            trial = false;
            m.setSpecialCode("1234");
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
                                break;
                                // do {
                                // Scanner inputtt = new Scanner(System.in);
                                // System.out.print("Enter the special 4 digit password:");
                                // String spclPassword = inputtt.nextLine();
                                // String spclCode = m.getSpecialCode();
                                // if (spclPassword == spclCode) {
                                // trial = false;
                                // break;
                                // } else {
                                // trial = true;
                                // }
                                // } while (trial);
                            } else if (choiceTwo == 2) {
                                u.Login();
                                trial = false;
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
                        m.editQuestion();
                        trial = false;
                        break;
                    }
                    if (choiceTwo == 2) {
                        trial = true;
                        do {
                            game.DivideQandA(game.selectCategory());
                            u.IncrementTimesPlayed();
                            game.PlayQuestion();
                            System.out.print("Press Enter to play again or any key to go to main menu:");
                            input = new Scanner(System.in);
                            if (input.nextLine().equals("")) {
                                trial = true;
                            } else {
                                trial = false;
                            }
                        } while (trial);
                        trial = true;
                    }
                } else if (choiceOne == 2) {
                    u.Register();
                    trial = true;
                } else if (choiceOne == 3) {
                    u.DisplayResults();
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