package first;

import static junit.framework.Assert.*;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-15
 */
public class DecodeFirstTest extends TestCase {

        private DecodeFirst decodeFirst;

        @Override
        protected void setUp() throws Exception {
            super.setUp();
            decodeFirst = new DecodeFirst("data/test_input.txt");
        }

        public void testParseInput() {
            int parsedIn = decodeFirst.parseInput();
            Assert.assertEquals(8, parsedIn);
        }

}