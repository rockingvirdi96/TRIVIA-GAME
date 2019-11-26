package app;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User
 */
public class Manager {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();
    private String specialCode;
    Game game = new Game();
    GameData gd = new GameData();

    public void Register() {
        boolean trial = false;
        Scanner input = new Scanner(System.in);
        String username;
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        do {
            trial = false;
            System.out.print("Enter your username: ");
            username = input.nextLine();
            if (this.usernames.contains(username)) {
                System.out.println("This username already exists.Try a different one.");
                trial = true;
            }
        } while (trial);
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        this.names.add(name);
        this.usernames.add(username);
        this.passwords.add(password);
        this.email.add(email);
        System.out.println("SUCCESS! You are registered.");
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public void Login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username :");
        String usernameTemp = input.next();
        System.out.print("Enter your password :");
        String passTemp = input.next();
        if (usernames.size() == 0) {
            System.out.println("You are not registered.");
            return;
        }
        for (var x = 0; x < usernames.size(); x++) {
            if (this.usernames.get(x).equals(usernameTemp) && this.passwords.get(x).equals(passTemp)) {
                System.out.print("Welcome " + names.get(x));
                return;
            }
        }
        System.out.println(
                "Information provided is not correct\nPress enter to try again or any key to go to main menu.");
        input = new Scanner(System.in);
        if (input.nextLine().equals("")) {
            Login();
        } else {
            Register();
        }
    }

    public void function(ArrayList x) throws IOException {
        Scanner input;
        input = new Scanner(System.in);
        for (short i = 0; i < x.size(); i++) {
            System.out.println(x.get(i));
        }
        System.out.print("Select which question you wish to edit.");
        short qNo = input.nextShort();
        input = new Scanner(System.in);
        System.out.println("Enter the new question you want to replace it.");
        String newQuestion = input.nextLine();
        System.out.println((String) x.get(qNo - 1));
        System.out.println("---" + newQuestion
                + "\n this is what your new question will look like.\n Enter Y to save or N to edit.");
        input = new Scanner(System.in);
        char choix = input.nextLine().charAt(0);
        if (choix == 'Y') {
            gd.modifyData((String) x.get(qNo - 1), newQuestion);
            return;
        } else {
            editQuestion();
        }
    }

    public void editQuestion() throws IOException {
        GameData gd = new GameData();
        gd.createData();
        short choice = game.selectCategory();
        game.DivideQandA(choice);
        switch (choice) {
        case 1: {
            function(game.getQuestions());
            break;
        }
        case 2: {
            function(game.getQuestions());
            break;
        }
        case 3: {
            function(game.getQuestions());
            break;
        }
        }

    }

    public void addNewCategory() {

    }

}
