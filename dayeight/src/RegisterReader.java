import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterReader {
    private String filePath;
    private Map<String, Integer> register;
    private int highestParsedValue = 0;

    public RegisterReader() {
        this.register = new HashMap<>();
    }

    public void parseCommand(String command) {
        Scanner sc = new Scanner(command);
        String reg = sc.next();
        String cmd = sc.next();
        int val = sc.nextInt();

        sc.next(); // Consume 'if' in command line

        String boolReg = sc.next();
        String boolOperator = sc.next();
        int boolVal = sc.nextInt();

        // Get modValue to alter register and set the value. 0 if boolean is false == no change to register value.
        boolean changeValue = getBoolean(boolReg, boolOperator, boolVal);
        int modValue = changeValue ? this.getOperation(cmd, val) : 0;
        this.register.compute(reg, (k, v) -> (v == null ? modValue : v + modValue));

        if (changeValue && this.register.get(reg) > highestParsedValue) {
            highestParsedValue = this.register.get(reg);
        }
    }

    /**
     * @param boolOperator - (String) Operator for the boolean statement
     * @param boolReg - (String) Registry to be checked
     * @param boolVal - (int) Value to compare with registry value
     * @return - boolean
     * */
    private boolean getBoolean(String boolReg, String boolOperator, int boolVal) {
        int val = this.register.getOrDefault(boolReg, 0);
        switch(boolOperator) {
            case "==": {
                return val == boolVal;
            }
            case "!=": {
                return val != boolVal;
            }
            case "<": {
                return val < boolVal;
            }
            case ">": {
                return val > boolVal;
            }
            case "<=": {
                return val <= boolVal;
            }
            case ">=": {
                return val >= boolVal;
            }
        }
        return false;
    }

    /**
     * @param operation - (String) operation to be done, increase or decrease
     * @param value - (int) value to be increased or decreased with
     * @return - (int) the value with translated operator
     */
    private int getOperation(String operation, int value) {
        switch(operation) {
            case "inc": {
                return +value;
            }
            case "dec": {
                return -value;
            }
        }
        return 0;
    }

    public Map<String, Integer> getRegister() {
        return this.register;
    }

    public int getMaxValue() {
        return Collections.max(register.values());
    }

    public int getHighestParsedValue() {
        return highestParsedValue;
    }

}
