package edu.arizona.eller.mis.fiveoseven.esb;

import edu.arizona.eller.mis.fiveoseven.dto.Game;

import java.io.File;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 10/13/13
 * Time: 9:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ScoreService {
    public void loadGames();
    public void updateAllScores(File updatedScores);

    /*TODO: remove later:

     */
    public List<Game> getGames();
}
