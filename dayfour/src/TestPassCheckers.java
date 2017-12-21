import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;




public class TestPassCheckers extends TestCase
{
    public void testValidate() {
        Assert.assertTrue(PassChecker.validPass("aa bb cc dd ee"));
        Assert.assertFalse(PassChecker.validPass("aa bb cc dd aa"));
        Assert.assertTrue(PassChecker.validPass("aa bb cc dd aaa"));

    }

    public void testCountValid() {
        ArrayList<String> inList = new ArrayList<>(Arrays.asList("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa"));
        PassChecker passChecker = new PassChecker(inList);
        int validPassphrases = passChecker.countValid();
        Assert.assertEquals(2,validPassphrases);
    }

    public void testValidateSecond() {
        Assert.assertTrue(PassCheckerTwo.validPass("abcde fghij"));
        Assert.assertFalse(PassCheckerTwo.validPass("abcde xyz ecdab"));
        Assert.assertTrue(PassCheckerTwo.validPass("a ab abc abd abf abj"));
        Assert.assertFalse(PassCheckerTwo.validPass("oiii ioii iioi iiio"));
        Assert.assertTrue(PassCheckerTwo.validPass("iiii oiii ooii oooi oooo"));
    }

    public void testCountValidSecond() {
        ArrayList<String> inList = new ArrayList<>(Arrays.asList(
                "abcde fghij",
                "abcde xyz ecdab",
                "a ab abc abd abf abj",
                "oiii ioii iioi iiio",
                "iiii oiii ooii oooi oooo"));
        PassCheckerTwo passChecker = new PassCheckerTwo(inList);
        int validPassphrases = passChecker.countValid();
        Assert.assertEquals(3,validPassphrases);
    }


}

