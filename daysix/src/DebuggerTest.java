import junit.framework.TestCase;

public class DebuggerTest extends TestCase {

    public void testDebugger() {
        int[] start = {0, 2, 7, 0};
        Debugger debug = new Debugger(start);
        int result = debug.debugInput();
        assertEquals(5, result);
    }

}