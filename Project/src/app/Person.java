package app;

import java.util.ArrayList;

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

    /**
     * @return the names
     */
    public ArrayList<String> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    /**
     * @return the passwords
     */
    public ArrayList<String> getPasswords() {
        return passwords;
    }

    /**
     * @param passwords the passwords to set
     */
    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }

    /**
     * @return the usernames
     */
    public ArrayList<String> getUsernames() {
        return usernames;
    }

    /**
     * @param usernames the usernames to set
     */
    public void setUsernames(ArrayList<String> usernames) {
        this.usernames = usernames;
    }

}