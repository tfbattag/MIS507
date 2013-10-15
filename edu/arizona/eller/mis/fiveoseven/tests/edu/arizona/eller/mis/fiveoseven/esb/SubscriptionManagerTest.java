package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.mocks.SubscriberGenerator;
import org.junit.Test;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/14/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubscriptionManagerTest {
    SubscriptionManager sm = new SubscriptionManager();

    @Test
    public void testAddSubscribers() throws Exception {
        for(int i = 0; i <= 12; i++){
            sm.addSubscribers(SubscriberGenerator.getSubscriber(i));
        }

        assert(sm.subscribers.size() == 13);
    }

    @Test
    public void testupdateScores() throws Exception {
        sm.updateScores(new File("/data/GIT_REPOS/mis507/Final_Project/MIS507/src/scores1.txt"));

    }
}
