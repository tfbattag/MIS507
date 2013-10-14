package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.monitors.NflGameMonitor;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class FinalProjectScoreServiceTest {
    @Test
    public void testLoadGames() throws Exception {
        FinalProjectScoreService ss = new FinalProjectScoreService(new NflGameMonitor());
        ss.loadGames();
    }
}
