package edu.arizona.eller.mis.fiveoseven.stubs;

import edu.arizona.eller.mis.fiveoseven.dto.Game;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 8/29/13
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Deliverer {
    public void updateScores(List<Game> games);
}
