package app;

// import java.io.File;
// import java.util.Scanner;
// import java.util.ArrayList;

/**
 * User
 */
public class User extends Person {
    private short timesPlayed = 0;
    private short timesWon = 0;
    private String favCategory = "";
    // private short timesLost = timesPlayed - timesWon;

    public short getTimesWon() {
        return timesWon;
    }

    public void setTimesWon(short timesWon) {
        this.timesWon = timesWon;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(short timesPlayed) {
        this.timesPlayed = timesPlayed;
    }
}



    