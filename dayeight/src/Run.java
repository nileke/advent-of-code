import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        String filepath = "./dayeight/data/input.txt";
        RegisterReader registerReader = new RegisterReader();
        Scanner sc;
        try {
            sc = new Scanner(new File(filepath));
            while (sc.hasNextLine()) {
                registerReader.parseCommand(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Max value held in register: " + registerReader.getMaxValue());
        System.out.println("Highest value parsed by register: " + registerReader.getHighestParsedValue());
    }

}


