package edu.arizona.eller.mis.fiveoseven.subscribers;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverer;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverers;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:24 PM
 * This interface describes the methods required by all Subscriber implementations.
 */
public interface Subscriber {

    /**
     * This method allows the Publisher/Manager to register itself with this Subscriber.
     * It is a component of the Observer pattern.
     * @param subscriptionManager
     */
    public void registerPublisher(SubscriptionManager subscriptionManager);

    /**
     * This is the update or notify method for the subscriber to the ScoreService.
     * It accepts a List of Games with their most recent scores.
     * It is implemented by NflSubscriber.
     * @param games
     */
    public void updateScores(List<Game> games);

    /**
     * This method returns a String from the enum Deliverers.
     * @return String/enum
     */
    public Deliverers getPreferredMethod();

    /**
     * This method accepts the type of proxied Deliverer chosen by the Subscriber.
     * @param deliverer
     */
    public void setDeliverer(Deliverer deliverer);

    /**
     * This method grants access (returns) the injected Deliverer instance when needed.
     * @return
     */
    public Deliverer getDeliverer();
}


