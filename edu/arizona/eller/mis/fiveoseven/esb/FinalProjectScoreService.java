package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.monitors.NflGameMonitor;
import edu.arizona.eller.mis.fiveoseven.subscribers.Subscriber;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 7:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalProjectScoreService implements ScoreService{
    NflGameMonitor nflGameMonitor;
    List<Game> games;
    SubscriptionManager subscriptionManager;

    public FinalProjectScoreService(NflGameMonitor nflGameMonitor){
        this.nflGameMonitor = nflGameMonitor;
        games = new ArrayList<Game>();
        loadGames();
        subscriptionManager = new SubscriptionManager();
    }

    /*TODO: make private after testing. */
    public void loadGames(){
        int gameNumber = 1;
        File nflGames = nflGameMonitor.getWeeklyGames(this);
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

    /**TODO: remove this method later.
     *
     */
    public List<Game> getGames() {
        return games;
    }

}
