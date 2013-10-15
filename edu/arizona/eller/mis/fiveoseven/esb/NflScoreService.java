package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.providers.NflGameProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 7:08 PM
 *
 * This is the "CENTRAL" class that serves as the "brain" of the whole system.
 * This class is used to subscribe to the "Nfl's (fake) gateway to get a list of games.
 * On doing so, it passes an instance of itself to the gateway (NflGameProvider) to act
 * as a subscriber.
 */
public class NflScoreService implements ScoreService{
    NflGameProvider nflGameProvider;
    List<Game> games;
    SubscriptionManager subscriptionManager;

    /**
     * Constructor for the NflScoreService.
     * @param nflGameProvider
     * @param subscriptionManager
     * @throws InvalidStateException
     */
    public NflScoreService(NflGameProvider nflGameProvider, SubscriptionManager subscriptionManager)throws InvalidStateException{
        this.nflGameProvider = nflGameProvider;
        games = new ArrayList<Game>();
        loadGames();
        this.subscriptionManager = subscriptionManager;
        if(!isValid())
            throw new InvalidStateException("Cannot connect to NFL Gateway.");
    }

    /**
     * This method is used to read a listing of Games from the provider.
     * It could be made private, but it is public to allow for unit testing.
     */
    public void loadGames(){
        int gameNumber = 1;
        File nflGames = nflGameProvider.getWeeklyGames(this);
        BufferedReader br;
        try{
            String gameListing;
            br = new BufferedReader(new FileReader(nflGames));
            while((gameListing = br.readLine()) != null){
                String homeTeam = gameListing.substring(0, gameListing.indexOf("|"));
                String visitingTeam = gameListing.substring(gameListing.indexOf("|") + 1, gameListing.length());
                Game game = new Game(gameNumber, homeTeam, visitingTeam);
                games.add(game);
                gameNumber++;
            }
            br.close();
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        } catch(InvalidStateException ise){
            ise.printStackTrace();
        }
    }

    /**
     * This method accepts a File that contains the updated scores as published by the score provider.
     * @param updatedScores
     */
    public void updateAllScores(File updatedScores){
        BufferedReader br;
        int scoreNumber = 1;
        try{
            String currentScore;
            br = new BufferedReader(new FileReader(updatedScores));
            while((currentScore = br.readLine()) != null){
                String visitorScore = currentScore.substring(0, currentScore.indexOf("|"));
                String homeScore = currentScore.substring(currentScore.indexOf("|") + 1, currentScore.length());
                Game game = games.get(scoreNumber - 1);
                if(game.getGameID() == scoreNumber){
                    game.setHomeScore(Integer.valueOf(homeScore));
                    game.setVisitorScore(Integer.valueOf(visitorScore));
                }
                scoreNumber++;
            }
            br.close();
        } catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    /**
     * This method returns this Service's list of games in the form of a List.
     * @return List<Game>
     */
    public List<Game> getGames() {
        return games;
    }

    /**
     * Implementation of repInvariant method verifying that instances of this class have been created properly.
     * It verifies that the three dependencies are not null.
     */
    private boolean isValid(){
        if(nflGameProvider == null || games == null || subscriptionManager == null){
            return false;
        }else{
            return true;
        }
    }

}
