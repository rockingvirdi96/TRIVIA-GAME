package app;

import java.util.ArrayList;

/**
 * Player
 */
public class Player extends Person {
    private short wins;
    private short losses;
    private short timesPlayed;
    ArrayList<Player> playerList = new ArrayList<Player>();

    public short getWins() {
        return wins;
    }

    public void setWins(short wins) {
        this.wins = wins;
    }

    public short getTimesPlayed() {
        return timesPlayed;
    }

    public void setTimesPlayed(short timesPlayed) {
        this.timesPlayed = timesPlayed;
    }

    public short getLosses() {
        return losses;
    }

    public void setLosses(short losses) {
        this.losses = losses;
    }

}