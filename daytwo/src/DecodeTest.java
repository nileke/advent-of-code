import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-15
 */
public class DecodeTest extends TestCase {

        private Decode decode;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            decode = new Decode("data/test_input.txt");
        }

        public void testParseInput() {
            int parsedIn = decode.parseInputOne();
            int parsedInTwo = decode.parseInputTwo();
            Assert.assertEquals(15, parsedIn);
            Assert.assertEquals(5, parsedInTwo);

        }

}