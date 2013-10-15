package edu.arizona.eller.mis.fiveoseven.stubs;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class RSSDeliverer implements Deliverer {
    ScoreService scoreService;
    List<Game> games;

    public RSSDeliverer(ScoreService scoreService){
        this.scoreService = scoreService;
    }

    public void updateScores(List<Game> games){
        this.games = games;
        printScores();
    }

    private void printScores() {
        System.out.println("<<RSS>> NOTIFICATION OF SCORES FROM NFL SCORE-SERVICE");
        System.out.println(this.toString());
        Iterator<Game> it = scoreService.getGames().iterator();
        while(it.hasNext()){
            Game game = it.next();
            System.out.println("GAME: " + game.getGameID());
            System.out.println(game.getVisitingTeam() + ": " + game.getVisitorScore());
            System.out.println(game.getHomeTeam() + ": " + game.getHomeScore());
            System.out.println("\n");
        }
    }

    /**
     * Implementation of repInvariant to test valid state of object.
     * @return
     */
    private boolean isValid(){
        if(scoreService == null || games == null){
            return false;
        }else{
            return true;
        }
    }
}
