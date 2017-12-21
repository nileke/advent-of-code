import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PassCheckerTwo {

    private ArrayList<String> passphrases;
    private int validPassphrases;

    PassCheckerTwo(String inputFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputFile));
        passphrases = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // line.replace("\n", "");
            passphrases.add(line);
        }
    }

    // Constructor for tests
    PassCheckerTwo(ArrayList<String> passphrases) {
        this.passphrases = passphrases;
    }


    static boolean validPass(String inString) {
        String[] phrase = inString.split("\\s+");
        ArrayList<char[]> usedWords = new ArrayList<>();
        for (String word : phrase) {
            char[] inChars = word.toCharArray();
            Arrays.sort(inChars);
            for (char[] w : usedWords) {
                if (Arrays.equals(inChars, w)) {
                    return false;
                }
            }
            usedWords.add(inChars);
        } return true;
    }

    @SafeVarargs
    final int countValid(ArrayList<String>... passphrases) {
        if (passphrases.length > 0) {
            this.passphrases = passphrases[0];
        }
        int count = 0;
        for (String line : this.passphrases ) {
            line.replace("\n", "");
            if (validPass(line)) {
                count++;
            }
        } return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        PassCheckerTwo passCheckerTwo = new PassCheckerTwo("dayfour/data/input.txt");
        System.out.println("Second half answer: " + passCheckerTwo.countValid());

    }

}
