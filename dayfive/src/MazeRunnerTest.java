import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-22
 */
public class MazeRunnerTest extends TestCase {

    public void testNavigateMaze() {
        Integer[] mazeArray = {0,3,0,1,-3};
        MazeRunner maze = new MazeRunner(mazeArray);
        Assert.assertFalse(maze.navigateMaze());
        Assert.assertEquals(0, maze.idx);
        Assert.assertEquals(1, maze.getSteps());
        Assert.assertFalse(maze.navigateMaze());
        Assert.assertEquals(1, maze.idx);
        Assert.assertFalse(maze.navigateMaze());
        Assert.assertFalse(maze.navigateMaze());
        Assert.assertFalse(maze.navigateMaze());
        Assert.assertTrue(maze.navigateMaze());
        Assert.assertEquals(5, maze.getSteps());

    }


}