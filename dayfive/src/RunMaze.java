import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static javafx.scene.input.KeyCode.T;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-22
 */
public class RunMaze {

    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "data/input.txt";
        Scanner sc = new Scanner(new File(filepath));
        ArrayList<Integer> tmp = new ArrayList<>();
        while (sc.hasNextLine()) {
            tmp.add(Integer.parseInt(sc.nextLine()));
        }

        Integer [] m = tmp.toArray(new Integer[tmp.size()]);
        MazeRunner maze = new MazeRunner(m);
        System.out.println(navMaze(maze));
        m = tmp.toArray(new Integer[tmp.size()]);
        MazeRunner mazeTwo = new MazeRunner(m);
        System.out.println(navSecondMaze(mazeTwo));

    }

    private static int navMaze(MazeRunner maze) {
        boolean escapedMaze = false;
        while (!escapedMaze) {
            escapedMaze = maze.navigateMaze();
        }
        return maze.getSteps();
    }

    private static int navSecondMaze(MazeRunner maze) {
        boolean escapedMaze = false;
        while (!escapedMaze) {
            escapedMaze = maze.navigateSecondMaze();
        }
        return maze.getSteps();
    }
}
