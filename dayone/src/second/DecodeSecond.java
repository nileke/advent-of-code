package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */

public class DecodeSecond {
    private String filepath;
    private String fileContent;

    public DecodeSecond(String filepath) {
        this.filepath = filepath;
        setFileContent();
    }

    public int parseInput() {
        int captcha = 0;


        String[] digits = fileContent.split("(?<=.)");

        int halfLength = digits.length/2;
        for (int n=0; n < digits.length-1; n++) {
            if (halfLength == digits.length) {
                halfLength = 0;
            }
            int x = Integer.parseInt(digits[n]);
            int y = Integer.parseInt(digits[halfLength]);
            if (x == y) {
                captcha += x;
            }
            halfLength++;
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


