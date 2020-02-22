package app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Person
 */
public class Person {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }

    public ArrayList<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

    public Boolean Login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username :");
        String usernameTemp = input.next();
        System.out.print("Enter your password :");
        String passTemp = input.next();
        if (this.getUsernames().size() == 0) {
            System.out.println("You are not registered.");
            return false;
        }
        for (var x = 0; x < getUsernames().size(); x++) {
            if (getUsernames().get(x).equals(usernameTemp) && getPasswords().get(x).equals(passTemp)) {
                System.out.print("Welcome " + getNames().get(x));
                return true;
            }
        }
        System.out.println("Information provided is not correct" + "\nPress Y to try again or N to Register.");
        boolean trial = true;
        while (trial) {
            trial = false;
            input = new Scanner(System.in);
            String choice = input.next();
            if ((char) choice.toUpperCase().charAt(0) == 'Y') {
                Login();
            } else if ((char) choice.toUpperCase().charAt(0) == 'N') {
                Register();
            } else {
                trial = true;
            }
        }
        return true;
    }

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
            if (this.getUsernames().contains(username)) {
                System.out.println("This username already exists.Try a different one.");
                trial = true;
            }
        } while (trial);
        System.out.print("Enter your password: ");
        String password = input.nextLine();
        System.out.print("Enter your Email: ");
        String email = input.nextLine();
        this.getNames().add(name);
        this.getUsernames().add(username);
        this.getPasswords().add(password);
        this.getEmail().add(email);
        System.out.println("SUCCESS! You are registered.");
    }
}