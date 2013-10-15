package edu.arizona.eller.mis.fiveoseven.providers;

import edu.arizona.eller.mis.fiveoseven.esb.NflScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 7:12 PM
 *
 * This class is a Publisher/Provider as well. It provides the listing of teams and the scores
 * from the NFL in File format.
 */
public class NflGameProvider {
    List<ScoreService> scoreServices;

    /**
     * Default constructor creates an instance of "subscribing" score relay services.
     */
    public NflGameProvider(){
        scoreServices = new ArrayList<ScoreService>();
    }

    /**
     * This method accepts an instance of a ScoreService to be registered for future score updates.
     * This is a representation of the registering of a Subscriber to this Provider/Publisher.
     * @param nflScoreService
     * @return File that contains a listing of the weekly matchups.
     */
    public File getWeeklyGames(NflScoreService nflScoreService){
        scoreServices.add(nflScoreService);
        File games = new File("/data/GIT_REPOS/mis507/Final_Project/MIS507/src/weeklyGames.txt");
        return games;
    }

    /**
     * This method will iterate through a list of registered ScoreServices to inject them with a feed of updated scores.
     * In this example, there is only one ScoreService, our NflScoreService.
     */
    public void updateAllScores(){
        File scores = new File("/data/GIT_REPOS/mis507/Final_Project/MIS507/src/scores1.txt");
        Iterator<ScoreService> it = scoreServices.iterator();

        while(it.hasNext()){
            ScoreService ss = it.next();
            ss.updateAllScores(scores);
        }
    }
}
