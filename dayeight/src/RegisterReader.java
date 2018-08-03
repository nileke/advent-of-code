import java.io.File;
import java.io.FileNotFoundException;
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
        this.register.putIfAbsent(boolReg, 0);

        if (getBoolean(boolReg, boolOperator, boolVal)) {
            this.register.put(reg, this.modifyRegister(cmd, val));
        }

    }

    /**
     * @param boolOperator - Operator for the boolean statement
     * @param boolReg - Registry to be checked
     * @param boolVal - Value to compare with registry value
     * Translate the boolean statement from file
     * */
    private boolean getBoolean(String boolReg, String boolOperator, int boolVal) {
        int val = this.register.get(boolReg);
        switch(boolOperator) {
            case "==": {
                return val == boolVal;
            }
            case "!=": {
                return val!= boolVal;
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

    private int modifyRegister(String instruction, int value) {
        switch(instruction) {
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
