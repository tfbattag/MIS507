package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.stubs.*;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:26 PM
 *
 * This class implements a Factory that delivers properly constructed DelivererProxy objects.
 */
public class DelivererFactory {

    /**
     * This method is the implementation of the Factory. It accepts an argument that specifies the type of DelivererProxy
     * needed by a Subscriber. It only creates objects from the accepted types specified by the Deliverers Enumeration.
     * @param deliverers
     * @param scoreService
     * @return
     */
    public static DelivererProxy getDeliverer(Deliverers deliverers, ScoreService scoreService){
        switch(deliverers){
            case EMAIL:
                return new EmailDelivererProxy();
            case RSS:
                return new RSSDelivererProxy();
            case TWITTER:
                return new TwitterDelivererProxy();
            default:
                return null;
        }
    }
}
