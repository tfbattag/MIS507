package edu.arizona.eller.mis.fiveoseven;

import edu.arizona.eller.mis.fiveoseven.esb.NflScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.mocks.SubscriberGenerator;
import edu.arizona.eller.mis.fiveoseven.providers.NflGameProvider;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 9:35 PM
 *
 * This class is used to simulate the running environment. It will be responsible for
 * executing all of the code in the various sub-systems.
 */
public class MainTestHarness {
    private static ScoreService scoreService;
    private static NflGameProvider nflGameProvider;
    private static SubscriptionManager subscriptionManager;
    private static Properties properties = new Properties();

    public static void main(String args[]){
        loadConfig();


        nflGameProvider = new NflGameProvider(properties.getProperty("GAMES"));
        subscriptionManager = new SubscriptionManager();
        try{
            scoreService = new NflScoreService(nflGameProvider, subscriptionManager);
        }catch(InvalidStateException ie){
            ie.printStackTrace();
        }

        addSubscribers();                   //at this point, the subscriptionManager should have a list of Subscribers.
        nflGameProvider.updateAllScores(new File(properties.getProperty("SCORES_1")));   //the monitor has a reference to the subscriptionManager. Thus scoreService's scores are updated.
        subscriptionManager.updateScores(scoreService.getGames());

        updateScores();
    }

    private static void addSubscribers(){
        for(int i = 0; i <= 12; i++){
            subscriptionManager.addSubscribers(SubscriberGenerator.getSubscriber(i), scoreService);
        }
    }

    /**
     * This method is used to refresh the scores after they have changed.
     */
    private static void updateScores(){
        nflGameProvider.updateAllScores(new File(properties.getProperty("SCORES_2")));
        subscriptionManager.updateScores(scoreService.getGames());
    }

    /**
     * This method is used to read file locations from the file "file.properties". This file
     * is needed to put the location of the other files that are necessary to make this application run.
     * The current setup is for a Unix filesystem. To change locations, the only change needed is in the
     * files.properties file.
     */
    private static void loadConfig(){
        try{
            properties.load(MainHarness.class.getResourceAsStream("files.properties"));
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}

