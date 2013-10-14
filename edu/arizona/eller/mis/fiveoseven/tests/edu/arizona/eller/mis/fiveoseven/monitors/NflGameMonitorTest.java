package edu.arizona.eller.mis.fiveoseven.monitors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 8:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class NflGameMonitorTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetWeeklyGames() throws Exception {
        assert(NflGameMonitor.getWeeklyGames() != null);
    }
}
