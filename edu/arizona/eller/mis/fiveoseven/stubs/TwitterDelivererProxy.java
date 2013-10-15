package edu.arizona.eller.mis.fiveoseven.stubs;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.ScoreService;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:33 PM
 *
 * This class is an implementation of the DelivererProxy that will convert input in the form of Games
 * into the "appropriate" form as chosen by the Subscriber that owns an instance of this class. */
public class TwitterDelivererProxy implements DelivererProxy {
    List<Game> games;

    /**
     * Default constructor.
     */
    public TwitterDelivererProxy(){}

    /**
     * This method is used to accept the List of Games that this DelivererProxy will process.
     * It also is used to force the output to the clients via the call to the private printScores() method.
     * @param games
     */
    public void updateScores(List<Game> games){
        this.games = games;
        printScores();
    }

    /**
     * This method is the "proprietary" method hidden by the Proxy.
     * In this case, it only changes the title of the notification.
     * It would normally be used to handle the appropriate communication.
     */
    private void printScores() {
        System.out.println("twitter(R) NOTIFICATION OF SCORES FROM NFL SCORE-SERVICE");
        System.out.println(this.toString());
        Iterator<Game> it = games.iterator();
        while(it.hasNext()){
            Game game = it.next();
            System.out.println("GAME: " + game.getGameID());
            System.out.println(game.getVisitingTeam() + ": " + game.getVisitorScore());
            System.out.println(game.getHomeTeam() + ": " + game.getHomeScore());
            System.out.println("\n");
        }
    }
}
