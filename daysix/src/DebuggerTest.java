import junit.framework.TestCase;

public class DebuggerTest extends TestCase {

    private int[] start = {0, 2, 7, 0};

    public void testDebugInput() {
        Debugger debug = new Debugger(start);
        int result = debug.debugInput();
        assertEquals(5, result);
    }

    public void testFindNumberOfCycles() {
        Debugger debug = new Debugger(start);
        int result = debug.findNumberOfCycles();
        assertEquals(4, result);
    }

}