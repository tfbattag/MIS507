package edu.arizona.eller.mis.fiveoseven.monitors;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 7:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class NflGameMonitor {

    public static File getWeeklyGames(){
        File games = new File("/data/GIT_REPOS/mis507/Final_Project/MIS507/src/weeklyGames.txt");
        return games;
    }
}
