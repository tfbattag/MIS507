package edu.arizona.eller.mis.fiveoseven;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.NflScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.mocks.SubscriberGenerator;
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
    private static SubscriptionManager subscriptionManager;

    public static void main(String args[]){
        nflGameMonitor = new NflGameMonitor();
        subscriptionManager = new SubscriptionManager();
        try{
            scoreService = new NflScoreService(nflGameMonitor, subscriptionManager);
        }catch(InvalidStateException ie){
            ie.printStackTrace();
        }

        addSubscribers();                   //at this point, the subscriptionManager should have a list of Subscribers.
        nflGameMonitor.updateAllScores();   //the monitor has a reference to the subscriptionManager. Thus scoreService's scores are updated.
        subscriptionManager.updateScores(scoreService.getGames());


    }

    private static void addSubscribers(){
        for(int i = 0; i <= 12; i++){
            subscriptionManager.addSubscribers(SubscriberGenerator.getSubscriber(i), scoreService);
        }
    }
}
