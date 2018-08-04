import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class RegisterReaderTest {
    RegisterReader registerReader;

    String operation = "b inc 5 if b < 1";

    String[] testOperations = {
                    "b inc 5 if a > 1",
                    "a inc 1 if b < 5",
                    "c dec -10 if a >= 1",
                    "c inc -20 if c == 10"
                    };

    @BeforeEach
    void setUp() {
        registerReader = new RegisterReader();
        for (String command : testOperations) {
            this.registerReader.parseCommand(command);
        }
    }

    @Test
    void testOneCommand() {
        registerReader.parseCommand(this.operation);
        Map register = registerReader.getRegister();
        Assertions.assertEquals(5, (int)register.get("b"));
    }

    @Test
    void testMultipleCommands() {
        Map register = this.registerReader.getRegister();
        Assertions.assertEquals(1, (int)register.get("a"));
        Assertions.assertEquals(0, (int)register.get("b"));
        Assertions.assertEquals(-10, (int)register.get("c"));
    }

    @Test
    void testMaxValue() {
        int calculatedMaxVal = registerReader.getMaxValue();
        int expectedMaxVal = 1;
        Assertions.assertEquals(expectedMaxVal, calculatedMaxVal);
    }

    @Test
    void testHighestValue() {
        int calculated = registerReader.getHighestParsedValue();
        int expected = 10;
        Assertions.assertEquals(expected, calculated);
    }

}