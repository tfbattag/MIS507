package edu.arizona.eller.mis.fiveoseven.stubs;

import edu.arizona.eller.mis.fiveoseven.dto.Game;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:26 PM
 *
 * This interface represents the Proxies that will be implemented by Subscribers.
 * */
public interface DelivererProxy {

    /**
     * This method accepts a List of Game objects. Implementing classes will translate this input
     * into the appropriate form for the Subscribers.
     * @param games
     */
    public void updateScores(List<Game> games);
}
