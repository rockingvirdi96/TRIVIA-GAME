package app;

import java.util.Scanner;

/**
 * Person
 */
public class Person {
    private String name;
    private String username;
    private String password;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void Register(Player p) {
        boolean trial = true;
        String name, username, password, email;
        do {
            Scanner input = new Scanner(System.in);
            trial = false;
            try {
                System.out.print("Enter your Name:");
                name = input.nextLine();
                setName(name);
                System.out.print("Enter your UserName:");
                username = input.nextLine();
                setUsername(username);
                System.out.print("Enter your Password:");
                password = input.nextLine();
                setPassword(password);
                System.out.print("Enter your Email:");
                email = input.nextLine();
                setEmail(email);
                if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    System.out.println("\nOne or more fields were left empty.\n");
                    trial = true;
                } else {
                    p.playerList.add(p);
                    System.out.println("\nCongrats. You are successfully registered.\n");
                }
            } catch (Exception e) {
                System.out.println("Try Again.");
                trial = true;
            }
        } while (trial);
    }

    public void Register(Manager m) {
        boolean trial = true;
        String name, username, password, email;
        do {
            Scanner input = new Scanner(System.in);
            trial = false;
            try {
                System.out.print("Enter your Name:");
                name = input.nextLine();
                setName(name);
                System.out.print("Enter your UserName:");
                username = input.nextLine();
                setUsername(username);
                System.out.print("Enter your Password:");
                password = input.nextLine();
                setPassword(password);
                System.out.print("Enter your Email:");
                email = input.nextLine();
                setEmail(email);
                if (name.isEmpty() || username.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    System.out.println("\nOne or more fields were left empty.\n");
                    trial = true;
                } else {
                    m.managerList.add(m);
                    System.out.println("\nCongrats. You are successfully registered.\n");
                }
            } catch (Exception e) {
                System.out.println("Try Again.");
                trial = true;
            }
        } while (trial);
    }

}