import java.util.ArrayList;
import java.util.Arrays;

public class Cycler {

    private final int[] initialBank;
    private int[] lastCycle;
    private ArrayList<int[]> generatedCycles;

    Cycler(int[] initialBank) {
        this.initialBank = initialBank;
        //this.generatedCycles = new ArrayList<>();
    }

    void cycleBank() {
        if (lastCycle == null) {
            lastCycle = initialBank.clone();
        }

        int[] tmp = lastCycle;
        int idx = getIndex(tmp);
        int count = idx+1;
        int dist = tmp[idx];
        while (dist > 0) {
            if (count > tmp.length-1) {
                count  = 0;
            }
            tmp[count] += 1;
            tmp[idx] -= 1;
            dist--;
            count++;
        }
        //generatedCycles.add(tmp.clone());
        this.lastCycle = tmp;
    }

    int getIndex(int[] a) {
        int idx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[idx] < a[i]) {
                idx = i;
            }
        } return idx;
    }

    public int[] getLastCycle() {
        return this.lastCycle;
    }

    public ArrayList<int[]> getGeneratedCycles() {
        return this.generatedCycles;
    }

    public int[] getInitialBank() {
        return this.initialBank;
    }
}
