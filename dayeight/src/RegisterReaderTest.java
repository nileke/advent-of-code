import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterReaderTest {
    RegisterReader register;

    String operation = "b inc 5 if b < 1";

    String[] testOperations = {
                    "b inc 5 if a > 1",
                    "a inc 1 if b < 5",
                    "c dec -10 if a >= 1",
                    "c inc -20 if c == 10"
                    };

    @BeforeEach
    void setUp() {
        register = new RegisterReader();
    }

    @Test
    void testOneCommand() {
        register.parseRegister(this.operation);
        Assertions.assertEquals(5, (int)register.register.get("b"));
    }

    @Test
    void testMultipleCommands() {
        for (String command : testOperations) {
            register.parseRegister(command);
        }
        Assertions.assertEquals(1, (int)register.register.get("a"));
        Assertions.assertEquals(0, (int)register.register.get("b"));
        Assertions.assertEquals(-10, (int)register.register.get("c"));
    }
}