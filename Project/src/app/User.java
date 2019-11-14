package app;

// import java.io.File;
// import java.util.Scanner;
// import java.util.ArrayList;

/**
 * User
 */
public class User extends Person {
    private short timesPlayed = 0;
    private short correctAnswer = 0;
    // private String favCategory = "";
    // private short timesLost = timesPlayed - correctAnswer;

    public short getcorrectAnswer() {
        return correctAnswer;
    }

    public void setcorrectAnswer(short correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(short timesPlayed) {
        this.timesPlayed = timesPlayed;
    }
}
