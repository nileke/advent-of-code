import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */
public class DecodeTest extends TestCase {

    private Decode decode;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        decode = new Decode("data/test_input.txt");
    }

    public void testFileRead() {
        String in = decode.getFileContent();
        Assert.assertEquals("1211544415", in);
    }

    public void testParseInput() {
        int parsedIn = decode.parseInputOne();
        Assert.assertEquals(9, parsedIn);
        int parsedInTwo = decode.parseInputTwo();
        Assert.assertEquals(7, parsedInTwo);
    }

}