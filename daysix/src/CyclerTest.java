
import junit.framework.TestCase;
import static org.junit.Assert.assertArrayEquals;

public class CyclerTest extends TestCase {

    public void testIndex() {
        int[] block = new int[] {0, 2, 7, 0};
        Cycler cycler = new Cycler(block);
        assertEquals(cycler.getIndex(block), 2);
        block = new int[] {3, 1, 2, 3};
        assertEquals(cycler.getIndex(block), 0);
    }

    public void testCycle() {
        int[] block = new int[] {0, 2, 7, 0};
        int[] firstCycle = new int[] {2, 4, 1, 2};
        int[] secondCycle = new int[] {3, 1, 2, 3};
        int[] thirdCycle = new int[] {0, 2, 3, 4};
        int[] fourthCycle = new int[] {1, 3, 4, 1};
        Cycler cycler = new Cycler(block);
        assertArrayEquals(cycler.cycleBank(), firstCycle);
        assertArrayEquals(cycler.cycleBank(), secondCycle);
        assertArrayEquals(cycler.cycleBank(), thirdCycle);
        assertArrayEquals(cycler.cycleBank(), fourthCycle);
        assertArrayEquals(cycler.cycleBank(), firstCycle);

    }

}