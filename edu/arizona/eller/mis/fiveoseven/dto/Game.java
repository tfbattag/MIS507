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
    private int gameID;
    private String homeTeam;
    private String visitingTeam;
    private int homeScore;
    private int visitorScore;

    private Game(){}

    /**
     * This constructor builds a game that represents two teams, their score against each other and an id that
     * identifies this Game. The constructor calls isValid() to verify that it has been instantiated correctly
     * to a valid state.
     * @param gameID
     * @param visitingTeam
     * @param homeTeam
     * @throws InvalidStateException
     */
    public Game(int gameID, String visitingTeam, String homeTeam) throws InvalidStateException{
        this.gameID = gameID;
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        homeScore = 0;
        visitorScore = 0;
        if (!isValid())
            throw new InvalidStateException("Missing Team Information.");
    }

    /**
     * Returns the ID of this Game.
     * @return int
     */
    public int getGameID() {
        return gameID;
    }

    /**
     * Returns the name of the home team in String.
     * @return String
     */
    public String getHomeTeam() {
        return homeTeam;
    }

    /**
     * returns the name of the visiting team as String.
     * @return String
     */
    public String getVisitingTeam() {
        return visitingTeam;
    }

    /**
     * Returns the score of the home team.
     * @return int
     */
    public int getHomeScore() {
        return homeScore;
    }

    /**
     * Accepts input of the home teams' score.
     * @param homeScore
     */
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    /**
     * Returns the visitor's score
     * @return int
     */
    public int getVisitorScore() {
        return visitorScore;
    }

    /**
     * Accepts input of the visiting team's score.
     * @param visitorScore
     */
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
