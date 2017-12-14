import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */

public class Decoder {
    private String filepath;
    private String fileContent;

    public Decoder(String filepath) {
        this.filepath = filepath;
        setFileContent();
    }

    public int parseInput() {
        int captcha = 0;
        String[] digits = fileContent.split("(?<=.)");
        int x = (Integer.parseInt(digits[0]));
        int y = Integer.parseInt(digits[digits.length-1]);
        if (x == y) {
            captcha += x;
        }

        for (int n=0; n < digits.length-1; n++) {
            x = Integer.parseInt(digits[n]);
            y = Integer.parseInt(digits[n+1]);
            if (x == y) {
                captcha += x;
            }
        }
        return captcha;
    }

    public String getFileContent() {
        // for debugging
        return fileContent;
    }

    private void setFileContent() {
        this.fileContent = "";
        try {
            fileContent = new Scanner(new File(filepath)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        }
    }
}


