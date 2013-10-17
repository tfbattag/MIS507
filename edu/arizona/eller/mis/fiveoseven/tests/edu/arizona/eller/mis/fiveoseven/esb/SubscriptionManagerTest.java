package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.dto.Game;
import edu.arizona.eller.mis.fiveoseven.mocks.MockSubscriberFactory;
import edu.arizona.eller.mis.fiveoseven.providers.NflGameProvider;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/14/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class SubscriptionManagerTest {
    SubscriptionManager sm = new SubscriptionManager();
    NflGameProvider ngp;
    Properties properties;

    @Before
    public void setUp() throws Exception {
        properties = new Properties();
        properties.load(NflScoreServiceTest.class.getResourceAsStream("files.properties"));
        ngp = new NflGameProvider((String)properties.get("GAMES"));
    }
    @Test
    public void testAddSubscribers() throws Exception {
        for(int i = 0; i <= 12; i++){
            sm.addSubscribers(MockSubscriberFactory.getSubscriber(i), new NflScoreService(ngp, sm));
        }

        assert(sm.subscribers.size() == 13);
    }

    @Test
    public void testupdateScores() throws Exception {
        sm.updateScores(new ArrayList<Game>());

    }
}
