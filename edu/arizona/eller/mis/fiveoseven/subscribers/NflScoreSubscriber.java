package edu.arizona.eller.mis.fiveoseven.subscribers;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverer;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverers;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/14/13
 * Time: 4:50 PM
 *
 * This class is the implementation of a Subscriber that is used for NflScore tracking.
 * It is the required subscriber/client of the Observer pattern.
 * It also requires a proxy named Deliverer to hide the functionality of how the scores get properly
 * translated from the source and printed/sent to end-users.
 */
public class NflScoreSubscriber implements Subscriber{
    private SubscriptionManager subscriptionManager;
    private Deliverers preferredMethod;
    private Deliverer deliverer;

    private NflScoreSubscriber(){}

    /**
     * This is the only public constructor available. It requires that instances of this class
     * to be created with the chosen method for delivery. These methods are validated and only
     * provided by the Enumertation Deliverers.
     * @param preferredMethod
     * @exception InvalidStateException
     */
    public NflScoreSubscriber(Deliverers preferredMethod) throws InvalidStateException{
        this.preferredMethod = preferredMethod;
        if(!isValid())
            throw new InvalidStateException("A delivery method from Deliverers is required.");
    }

    @Override
    public void registerPublisher(SubscriptionManager subscriptionManager) {
        this.subscriptionManager = subscriptionManager;
    }

    public Deliverer getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(Deliverer deliverer) {
        this.deliverer = deliverer;
    }

    @Override
    public Deliverers getPreferredMethod() {
        return preferredMethod;
    }

    @Override
    public void updateScores(List<Game> games) {
        deliverer.updateScores(games);
    }

    private boolean isValid(){
        if(preferredMethod == null){
            return false;
        }else{
            return true;
        }
    }
}
