package app;

// import java.io.File;
// import java.util.Scanner;
// import java.util.ArrayList;

/**
 * User
 */
public class User extends Manager {
    private short timesPlayed = 0;
    private short correctAnswer = 0;
    // private String favCategory = "";
    // private short timesLost = timesPlayed - correctAnswer;

    public short getcorrectAnswer() {
        return correctAnswer;
    }

    public void IncrementCorrectAnswer() {
        this.correctAnswer += 1;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void IncrementTimesPlayed() {
        this.timesPlayed += 1;
    }

    public void DisplayResults() {
        System.out.println("Total time played :" + this.timesPlayed);
        System.out.println("Total Correct Answers :" + this.correctAnswer);
    }
}
