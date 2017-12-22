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
        //int[] maze = new int[tmp.size()];
        Integer [] m = tmp.toArray(new Integer[tmp.size()]);
        MazeRunner maze = new MazeRunner(m);
        navigateMaze(maze);
    }

    static void navigateMaze(MazeRunner maze) {
        boolean escapedMaze = false;
        while (!escapedMaze) {
            escapedMaze = maze.navigateMaze();
        }
        System.out.println(maze.getSteps());

    }
}
