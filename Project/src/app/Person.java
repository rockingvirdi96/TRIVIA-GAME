package app;

import java.util.Scanner;

import java.util.ArrayList;

/**
 * User
 */
public class Person {

    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();

    public Person() {

    }

    public Person(String name, String username, String password, String email) {
        this.names.add(name);
        this.usernames.add(username);
        this.passwords.add(password);
        this.email.add(email);
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
                System.out.print("Logged In\n");
                return;
            }
        }
        System.out.println("Information provided is not correct\nPress enter to try again.");
        input = new Scanner(System.in);
        if (input.nextLine().equals("")) {
            Login();
        }
    }

    public void DisplayAllUsers() {
        System.out.println(this.names);
        System.out.println(this.usernames);
        System.out.println(this.passwords);
        System.out.println(this.email);

    }

}