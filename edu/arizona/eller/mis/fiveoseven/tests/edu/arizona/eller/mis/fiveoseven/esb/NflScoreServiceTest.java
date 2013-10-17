package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.esb.NflScoreService;
import edu.arizona.eller.mis.fiveoseven.esb.SubscriptionManager;
import edu.arizona.eller.mis.fiveoseven.providers.NflGameProvider;
import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NflScoreServiceTest {
    Properties properties;
    @Before
    public void setUp() throws Exception {
        properties = new Properties();
        properties.load(NflScoreServiceTest.class.getResourceAsStream("files.properties"));
    }
    @Test
    public void testLoadGames() throws Exception {
        NflScoreService ss = new NflScoreService(new NflGameProvider(properties.getProperty("GAMES")), new SubscriptionManager());
        ss.loadGames();
    }
}
