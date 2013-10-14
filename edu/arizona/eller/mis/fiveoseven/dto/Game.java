package edu.arizona.eller.mis.fiveoseven.dto;

import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/4/13
 * Time: 11:58 AM
 * The Game class is used to hold the names of the two teams competing in a game and the scores that the two teams accrue
 * over the duration of the game.
 */
public class Game {
    private String homeTeam;
    private String visitingTeam;
    private int homeScore;
    private int visitorScore;

    private Game(){
        // do something here.
    }

    public Game(String homeTeam, String visitingTeam) throws InvalidStateException{
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        homeScore = 0;
        visitorScore = 0;
        if (!isValid())
            throw new InvalidStateException("Missing Team Information.");
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getVisitingTeam() {
        return visitingTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    public void setVisitorScore(int visitorScore) {
        this.visitorScore = visitorScore;
    }

    /**
     * validState() is an implementation of the repInvariant for the Game class.
     * @throws InvalidStateException
     */
    private boolean isValid() throws InvalidStateException{
        if (this.homeTeam == null || this.visitingTeam == null){
            return false;
        }else{
            return true;
        }
    }
}
