package edu.arizona.eller.mis.fiveoseven.mocks;

import edu.arizona.eller.mis.fiveoseven.exceptions.InvalidStateException;
import edu.arizona.eller.mis.fiveoseven.stubs.Deliverers;
import edu.arizona.eller.mis.fiveoseven.subscribers.NflScoreSubscriber;
import edu.arizona.eller.mis.fiveoseven.subscribers.Subscriber;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/14/13
 * Time: 4:38 PM
 *
 * This is a utility class to assist with running the application in simulation mode.
 * It is used to generate some mock Subscribers.
 */
public class MockSubscriberFactory {

    public static Subscriber getSubscriber(int i) {
        try {
            if (i % 3 == 0) {
                //System.out.println(i + " i%3=" + (i % 3) + " " + Deliverers.EMAIL);
                return new NflScoreSubscriber(Deliverers.EMAIL);
            } else if (i % 2 == 0) {
                //System.out.println(i + " i%2=" + (i % 2) + " " + Deliverers.RSS);
                return new NflScoreSubscriber(Deliverers.RSS);
            } else {
                //System.out.println(i + " i=" + i + " " + Deliverers.TWITTER);
                return new NflScoreSubscriber(Deliverers.TWITTER);
            }
        } catch (InvalidStateException ie) {
            ie.printStackTrace();
        }
        return null;
    }
}
