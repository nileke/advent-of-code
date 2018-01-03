import junit.framework.TestCase;
import junit.framework.Assert;

import static org.junit.Assert.assertArrayEquals;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-22
 */
public class MazeRunnerTest extends TestCase {

    public void testNavigateMaze() {
        Integer[] mazeArray = {0,3,0,1,-3};
        MazeRunner maze = new MazeRunner(mazeArray);
        assertFalse(maze.navigateMaze());
        assertEquals(0, maze.idx);
        assertEquals(1, maze.getSteps());
        assertFalse(maze.navigateMaze());
        assertEquals(1, maze.idx);
        assertFalse(maze.navigateMaze());
        assertFalse(maze.navigateMaze());
        assertFalse(maze.navigateMaze());
        assertTrue(maze.navigateMaze());
        assertEquals(5, maze.getSteps());

    }

    public void testNavigateSecondMaze() {
        Integer[] mazeArray = {0,3,0,1,-3};
        MazeRunner maze = new MazeRunner(mazeArray);
        assertFalse(maze.navigateSecondMaze());
        assertEquals(0, maze.idx);
        assertEquals(1, maze.getSteps());
        for (int i=0; i<8; i++) {
            assertFalse(maze.navigateSecondMaze());
        }
        assertFalse(maze.navigateSecondMaze());
        assertTrue(maze.navigateSecondMaze());
        assertArrayEquals(new Integer[]{2, 3, 2, 3, -1}, maze.maze);
        assertEquals(10, maze.getSteps());

    }


}