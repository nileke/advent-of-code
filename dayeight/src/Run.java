import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String filepath = "./dayeight/data/input.txt";
        /*
        RegisterReader register = new RegisterReader(filepath);
        Map reg = register.register;
        System.out.println(reg.keySet());
        try {
            register.readRegisterCommands();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(register.register.entrySet());
        */
        RegisterReader register = new RegisterReader();
        Scanner sc;
        try {
            sc = new Scanner(new File(filepath));
            while (sc.hasNextLine()) {
                register.parseRegister(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(register.register.entrySet());
    }

}


