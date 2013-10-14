package edu.arizona.eller.mis.fiveoseven;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.FinalProjectScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;
import edu.arizona.eller.mis.fiveoseven.monitors.NflGameMonitor;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 9:35 PM
 *
 * This class is used to simulate the running environment. It will be responsible for
 * executing all of the code in the various sub-systems.
 */
public class MainHarness {
    private static ScoreService scoreService;
    private static NflGameMonitor nflGameMonitor;

    public static void main(String args[]){
        nflGameMonitor = new NflGameMonitor();
        scoreService = new FinalProjectScoreService(nflGameMonitor);


        scoreService.loadGames();
        nflGameMonitor.updateAllScores();


        Iterator<Game> it = scoreService.getGames().iterator();
        while(it.hasNext()){
            Game game = it.next();
            System.out.println(game.getVisitingTeam() + ": " + game.getVisitorScore());
        }
    }
}
