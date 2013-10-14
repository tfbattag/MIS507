package edu.arizona.eller.mis.fiveoseven.esb;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class ScoreServiceTest {
    @Test
    public void testLoadGames() throws Exception {
        ScoreService ss = new ScoreService();
        ss.loadGames();
    }
}
