package second;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */
public class DecoderTest extends TestCase {

    private DecodeSecond decodeFirst;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        decodeFirst = new DecodeSecond("data/test_input2.txt");
    }

    public void testFileRead() {
        String in = decodeFirst.getFileContent();
        Assert.assertEquals("12131415", in);
    }

    public void testParseInput() {
        int parsedIn = decodeFirst.parseInput();
        Assert.assertEquals(4, parsedIn);
    }

}