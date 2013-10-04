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

    public static Deliverer getDeliverer(Deliverers deliverers){
        switch(deliverers){
            case EMAIL:
                return new EmailDeliverer();
            case RSS:
                return new RSSDeliverer();
            case TWITTER:
                return new TwitterDeliverer();
            default:
                return null;
        }
    }
}
