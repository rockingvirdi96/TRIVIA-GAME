package app;

/**
 * User
 */
public class User extends Manager {
    private short timesPlayed = 0;
    private short correctAnswer = 0;

    public short getcorrectAnswer() {
        return correctAnswer;
    }

    public void IncrementCorrectAnswer() {
        correctAnswer += 1;
    }

    public void resetScore() {
        correctAnswer = 0;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void IncrementTimesPlayed() {
        this.timesPlayed += 1;
    }

}
