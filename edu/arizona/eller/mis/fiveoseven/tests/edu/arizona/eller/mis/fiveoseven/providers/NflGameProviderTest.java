package edu.arizona.eller.mis.fiveoseven.providers;

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
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NflGameProviderTest {
    NflGameProvider nfl;
    @Before
    public void setUp() throws Exception {
        Properties properties = new Properties();
        properties.load(NflGameProviderTest.class.getResourceAsStream("files.properties"));
        nfl = new NflGameProvider(properties.getProperty("GAMES"));
    }

    @Test
    public void testGetWeeklyGames() throws Exception {
        assert(nfl.getWeeklyGames(new NflScoreService(nfl, new SubscriptionManager())) != null);
    }
}
