import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;


public class PassCheckerTest extends TestCase {


    public void testValidate() {
        Assert.assertTrue(PassChecker.validPass("aa bb cc dd ee"));
        Assert.assertFalse(PassChecker.validPass("aa bb cc dd aa"));
        Assert.assertTrue(PassChecker.validPass("aa bb cc dd aaa"));

    }

    public void testCountValid() {
        ArrayList<String> inList = new ArrayList<>();
        inList.addAll(Arrays.asList("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa"));
        PassChecker passChecker = new PassChecker(inList);
        int validPassphrases = passChecker.countValid();
        Assert.assertEquals(2,validPassphrases);
    }

}