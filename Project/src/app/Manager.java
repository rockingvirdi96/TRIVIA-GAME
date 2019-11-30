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
    private String specialCode = "1234";
    GamePlay game = new GamePlay();
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

    public Boolean Login() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username :");
        String usernameTemp = input.next();
        System.out.print("Enter your password :");
        String passTemp = input.next();
        if (usernames.size() == 0) {
            System.out.println("You are not registered.");
            return false;
        }
        for (var x = 0; x < usernames.size(); x++) {
            if (this.usernames.get(x).equals(usernameTemp) && this.passwords.get(x).equals(passTemp)) {
                System.out.print("Welcome " + names.get(x));
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

    public void addNewCategory() throws IOException {
        Scanner input;
        input = new Scanner(System.in);
        System.out.print("Enter the name of your category: ");
        String name = input.nextLine();
        gd.addData(name, "Categories.txt");
        gd.addData("cat" + name, "questionAnswers.txt");
        for (short x = 0; x < 10; x++) {
            input = new Scanner(System.in);
            System.out.print("Enter Question " + (x + 1) + ": ");
            String question = input.nextLine();
            gd.addData(question, "questionAnswers.txt");
            System.out.print("Enter Answer " + (x + 1) + ": ");
            String answer = input.nextLine();
            gd.addData(answer, "questionAnswers.txt");
        }
        gd.updateData();
    }

    public void editQuestion() throws IOException {
        ArrayList<String> QandA = new ArrayList<String>();
        String file = "D:\\Sem_Troisieme\\JAVA\\TRIVIA-GAME\\Project\\src\\app\\questionAnswers.txt";
        Scanner input;
        input = new Scanner(System.in);
        short i = 0;
        String nextCat = "";
        short choice = game.selectCategory(gd);
        String SelectedCat = "cat" + gd.getCategories().get(choice);
        String question = "";
        String answer = "";
        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> answers = new ArrayList<String>();
        for (String x : gd.getQuestionAnswers()) {
            if (x.equals(SelectedCat)) {
                for (int y = (gd.getQuestionAnswers().indexOf(x) + 1), index = 0; index < 10; y += 2, index++) {
                    question = gd.getQuestionAnswers().get(y);
                    answer = gd.getQuestionAnswers().get(y + 1);
                    questions.add(question);
                    answers.add(answer);
                    System.out.println((index + 1) + ". " + question);
                }
            } else {
                if (question != "") {
                    break;
                }
            }
        }
        input = new Scanner(System.in);
        System.out.print("\nSelect which Question you wish to Edit: ");
        int select = input.nextInt();
        input = new Scanner(System.in);
        System.out.print("\nEnter the new Question: ");
        String NewQuestion = input.nextLine();
        gd.modifyData((String) questions.get(select - 1), NewQuestion);
        System.out.print("\nEnter the new Answer: ");
        String NewAnswer = input.nextLine();
        gd.modifyData((String) answers.get(select - 1), NewAnswer);
        gd.updateData();
    }

}
