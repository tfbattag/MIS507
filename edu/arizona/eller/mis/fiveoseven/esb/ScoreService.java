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
public class ScoreService {
    List<Game> games;
    SubscriptionManager subscriptionManager;

    public ScoreService(){
        games = new ArrayList<Game>();
        loadGames();
        subscriptionManager = new SubscriptionManager();
    }

    /*TODO: make private after testing. */
    public void loadGames(){
        File nflGames = NflGameMonitor.getWeeklyGames();
        BufferedReader br;
        try{
            String gameListing;
            br = new BufferedReader(new FileReader(nflGames));
            while((gameListing = br.readLine()) != null){
                String homeTeam = gameListing.substring(0, gameListing.indexOf("|"));
                String visitingTeam = gameListing.substring(gameListing.indexOf("|") + 1, gameListing.length());
                Game game = new Game(homeTeam, visitingTeam);
                games.add(game);
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


}
