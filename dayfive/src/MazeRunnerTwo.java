public class MazeRunnerTwo {

    int idx;
    int tmpidx;
    Integer[] maze;
    int steps;

    MazeRunnerTwo() { }

    MazeRunnerTwo(Integer[] maze) {
        this.idx = 0;
        this.steps = 0;
        this.maze = maze;
    }



    public int getSteps() {
        return steps;
    }
}
