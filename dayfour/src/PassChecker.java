import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassChecker {

    private ArrayList<String> passphrases;
    private int validPassphrases;

    PassChecker(String inputFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(inputFile));
        passphrases = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            // line.replace("\n", "");
            passphrases.add(line);
        }
    }

    PassChecker(ArrayList<String> passphrases) {
        this.passphrases = passphrases;
    }


    static boolean validPass(String inString) {
        String[] phrase = inString.split("\\s+");
        ArrayList<String> usedWords = new ArrayList<>();
        for (String word : phrase) {
            if (usedWords.contains(word)) {
                return false;
            }
            usedWords.add(word);
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
        PassChecker passChecker = new PassChecker("data/input.txt");
        System.out.println(passChecker.countValid());

    }

}
