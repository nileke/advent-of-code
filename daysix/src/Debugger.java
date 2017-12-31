import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Debugger {

    private final int[] inputBank;
    ArrayList<int[]> generatedCycles;

    public Debugger(String filepath) throws FileNotFoundException {
        File f = new File(filepath);
        inputBank = readInput(f);
    }

    // Constructor for testing
    public Debugger(int[] inputBank) {
        this.inputBank = inputBank;
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
        generatedCycles = new ArrayList<>();
        int[] lastCycle = cycler.cycleBank().clone();
        int count = 1; // First cycle
        while (!inList(generatedCycles, lastCycle)) {
            generatedCycles.add(lastCycle);
            lastCycle = cycler.cycleBank().clone();
            count++;
        }
        return count;
    }

    public int findNumberOfCycles() {
        Cycler cycler = new Cycler(inputBank);
        generatedCycles = new ArrayList<>();
        int[] lastCycle = cycler.cycleBank().clone();
        int count = 0;
        while (true) {
            if (inList(generatedCycles, lastCycle)) {
                int idx = findCycleStartIndex(generatedCycles, lastCycle);
                return count - idx;
            }
            generatedCycles.add(lastCycle);
            lastCycle = cycler.cycleBank().clone();
            count++;
        }
    }


    public static boolean inList(final List<int[]> list, final int[] candidate) {
        return list.parallelStream().anyMatch(a -> Arrays.equals(a, candidate));
    }

    public static int findCycleStartIndex(final List<int[]> list, final int[] candidate){
        for(final int[] item : list){
            if(Arrays.equals(item, candidate)){
                return list.indexOf(item);
            }
        }
        return -1;
    }

    public static void main(String[] args)  {
        String filepath = "data/input.txt";
        try {
            Debugger debugger = new Debugger(filepath);
            System.out.println(debugger.debugInput());
            System.out.println(debugger.findNumberOfCycles());
        } catch (FileNotFoundException e) {
            System.out.println("File not found, check filepath");
        }

    }
}
