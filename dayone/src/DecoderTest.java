import junit.framework.Assert;
import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */
public class DecoderTest extends TestCase {

    private Decoder decoder;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        decoder = new Decoder("data/test_input.txt");
    }

    public void testFileRead() {
        String in = decoder.getFileContent();
        Assert.assertEquals("91212129", in);
    }

    public void testParseInput() {
        int parsedIn = decoder.parseInput();
        Assert.assertEquals(9, parsedIn);
    }

}