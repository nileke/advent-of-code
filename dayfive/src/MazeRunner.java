/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-22
 */
public class MazeRunner {

    int idx;
    int tmpidx;
    int[] maze;
    int steps;

    MazeRunner(int[] maze) {
        this.idx = 0;
        this.steps = 0;
        this.maze = maze;
    }

    boolean navigate() {
        tmpidx = maze[idx];
        try {
            maze[idx] += 1;
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
        idx = tmpidx;
        return false;
    }

    public int getSteps() {
        return steps;
    }
}
