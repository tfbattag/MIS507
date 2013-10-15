package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.stubs.*;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class DelivererFactory {

    public static Deliverer getDeliverer(Deliverers deliverers, ScoreService scoreService){
        switch(deliverers){
            case EMAIL:
                return new EmailDeliverer(scoreService);
            case RSS:
                return new RSSDeliverer(scoreService);
            case TWITTER:
                return new TwitterDeliverer(scoreService);
            default:
                return null;
        }
    }
}
