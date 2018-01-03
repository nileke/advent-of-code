/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-22
 */
public class MazeRunner {

    int idx;
    int tmpidx;
    Integer[] maze;
    int steps;

    MazeRunner() { }

    MazeRunner(Integer[] maze) {
        this.idx = 0;
        this.steps = 0;
        this.maze = maze;
    }

    boolean navigateMaze() {
        try {
            tmpidx = maze[idx];
            maze[idx] += 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        idx = idx + tmpidx;
        steps++;
        return false;
    }

    boolean navigateSecondMaze() {
        try {
            tmpidx = maze[idx];
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }
        if (maze[idx] < 3) {
            maze[idx] += 1;
        } else {
            maze[idx] -= 1;
        }

        idx = idx + tmpidx;
        steps++;
        return false;
    }

    public int getSteps() {
        return steps;
    }
}
