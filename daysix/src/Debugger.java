import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Debugger {

    private final int[] inputBank;

    public Debugger(String filepath) throws FileNotFoundException {
        File f = new File(filepath);
        inputBank = readInput(f);
        //debugInput();
    }

    // Constructor for testing
    public Debugger(int[] inputBank) {
        this.inputBank = inputBank;
        //debugInput();
    }

    int[] readInput(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int count = 0;
        while (sc.hasNext()) {
            count++;
            sc.nextInt();
        }
        Scanner sc1 = new Scanner(file);
        int[] inValues = new int[count];
        for (int i=0; i < inValues.length; i++) {
            inValues[i] = sc1.nextInt();
        }
        return inValues;
    }

    public int debugInput() {
        Cycler cycler = new Cycler(inputBank);
        ArrayList<int[]> generatedCycles = new ArrayList<>();
        int[] lastCycle = cycler.cycleBank().clone();
        int count = 1; // First cycle
        while (!inList(generatedCycles, lastCycle)) {
            generatedCycles.add(lastCycle);
            lastCycle = cycler.cycleBank().clone();
            count++;
        }
        return count;
    }

    public static boolean inList(final List<int[]> list, final int[] candidate) {
        return list.parallelStream().anyMatch(a -> Arrays.equals(a, candidate));
    }

    public static void main(String[] args)  {
        String filepath = "data/input.txt";
        try {
            Debugger debugger = new Debugger(filepath);
            System.out.println(debugger.debugInput());
        } catch (FileNotFoundException e) {
            System.out.println("File not found, check filepath");
        }

    }
}
