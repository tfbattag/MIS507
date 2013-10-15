package edu.arizona.eller.mis.fiveoseven.subscribers;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.stubs.DelivererProxy;
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
 * It also requires a proxy named DelivererProxy to hide the functionality of how the scores get properly
 * translated from the source and printed/sent to end-users.
 */
public class NflScoreSubscriber implements Subscriber{
    private SubscriptionManager subscriptionManager;
    private Deliverers preferredMethod;
    private DelivererProxy delivererProxy;

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

    /**
     * This method is to allow a Publisher to be registered and thus to allow instances of this class
     * to call the remove method to unsubscribe.
     * @param subscriptionManager
     */
    @Override
    public void registerPublisher(SubscriptionManager subscriptionManager) {
        this.subscriptionManager = subscriptionManager;
    }

    /**
     * Returns the DelivererProxy used by instances of this class.
     * @return DelivererProxy
     */
    public DelivererProxy getDelivererProxy() {
        return delivererProxy;
    }

    /**
     * Accepts a DelivererProxy which is the Proxy for receiving updates and handling translation and printing.
     * @param delivererProxy
     */
    public void setDelivererProxy(DelivererProxy delivererProxy) {
        this.delivererProxy = delivererProxy;
    }

    /**
     * This method returns the chosen type of delivery as chosen from the Enumeration Deliverers.
     * @return String from Delivers
     */
    @Override
    public Deliverers getPreferredMethod() {
        return preferredMethod;
    }

    /**
     * This method is the implementation of the Observer pattern's update/notify method.
     * It accepts a List of Game objects and passes them directly to the DelivererProxy (proxy) for translation
     * and printing.
     * @param games
     */
    @Override
    public void updateScores(List<Game> games) {
        delivererProxy.updateScores(games);
    }

    /**
     * This is an implementation of the repInvariant to check for valid states.
     * @return boolean
     */
    private boolean isValid(){
        if(preferredMethod == null){
            return false;
        }else{
            return true;
        }
    }
}
