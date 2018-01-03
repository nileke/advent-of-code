import java.util.ArrayList;
import java.util.Arrays;

public class Cycler {

    private final int[] initialBank;
    private int[] lastCycle;

    Cycler(int[] initialBank) {
        this.initialBank = initialBank;
    }

    int[] cycleBank() {
        if (lastCycle == null) {
            lastCycle = initialBank.clone();
        }

        int idx = getIndex(lastCycle);
        int count = idx+1;
        int dist = lastCycle[idx];
        while (dist > 0) {
            if (count > lastCycle.length-1) {
                count  = 0;
            }
            lastCycle[count] += 1;
            lastCycle[idx] -= 1;
            dist--;
            count++;
        }
        return lastCycle;
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

    public int[] getInitialBank() {
        return this.initialBank;
    }
}
