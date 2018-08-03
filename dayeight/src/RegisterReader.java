import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegisterReader {
    private String filePath;
    public Map<String, Integer> register;
    public int maxValue = 0;

    public RegisterReader() {
        this.register = new HashMap<>();
    }

    public void parseRegister(String command) {
        Scanner sc = new Scanner(command);
        String reg = sc.next();
        String cmd = sc.next();
        int val = sc.nextInt();
        sc.next(); // Consume 'if' in command line
        String boolReg = sc.next();
        String boolOperator = sc.next();
        int boolVal = sc.nextInt();

        // Get modValue to alter register and set the value. 0 if boolean is false == no change to register value.
        int modValue = getBoolean(boolReg, boolOperator, boolVal) ? this.getOperation(cmd, val) : 0;
        this.register.compute(reg, (k, v) -> (v == null ? modValue : v + modValue));
    }

    /**
     * @param boolOperator - Operator for the boolean statement
     * @param boolReg - Registry to be checked
     * @param boolVal - Value to compare with registry value
     * Translate the boolean statement from file
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



}
