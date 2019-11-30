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
        gd.createData();
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
                        input = new Scanner(System.in);
                        trial = false;
                        System.out.println("\n1.Login as the Manager.");
                        System.out.println("2.Login as a Player.");
                        try {
                            choiceTwo = input.nextShort();
                            if (choiceTwo == 1) {
                                do {
                                    input = new Scanner(System.in);
                                    System.out.print("Enter the special 4 digit password:");
                                    String spclPassword = input.nextLine();
                                    String spclCode = m.getSpecialCode();
                                    if (spclCode.contains(spclPassword)) {
                                        trial = false;
                                        break;
                                    } else {
                                        System.out.println("Wrong Code.");
                                        trial = true;
                                    }
                                } while (trial);
                            } else if (choiceTwo == 2) {

                                if (u.Login()) {
                                    break;
                                } else {
                                    u.Register();
                                    trial = true;
                                }
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
                        System.out.println("\nSelect an option from the following: ");
                        System.out.println("1.Edit a Question.");
                        System.out.println("2.Add a new Category.");
                        System.out.print("Enter choice:");
                        Short choice = input.nextShort();
                        switch (choice) {
                        case 1: {
                            m.editQuestion();
                            break;
                        }
                        case 2: {
                            m.addNewCategory();
                            break;
                        }
                        }
                        trial = true;
                    }
                    if (choiceTwo == 2) {
                        trial = true;
                        do {
                            gd.updateData();
                            game.DivideQandA(gd);
                            game.PlayQuestion(u);
                            u.IncrementTimesPlayed();
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

                    System.out.println("Exiting Now......");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Something Went Wrong");
                trial = true;
            }
        }

    }
}