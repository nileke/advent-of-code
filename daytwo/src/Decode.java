import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-15
 */
public class Decode {

    private Scanner sc;
    private ArrayList<int[]> spreadsheet;

    Decode(String filepath) {
        readFile(filepath);
    }

    private void readFile(String filepath) {
        try {
            sc = new Scanner(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        spreadsheet = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] row = line.split("\\s+");
            int[] digits = new int[row.length];
            for (int i=0; i < row.length; i++) {
                digits[i] = (Integer.parseInt(row[i]));
            } spreadsheet.add(digits);
        }
    }

    int parseInputOne() {
        int checksum = 0;
        for (int[] row : spreadsheet) {
            Arrays.sort(row);
            checksum += row[row.length-1] - row[0];
        }
        return checksum;
        }


    int parseInputTwo() {
        int checksum = 0;
        for (int[] row : spreadsheet) {
            rowloop:
            for (int i=0; i < row.length; i++) {
                for (int n=0; n < row.length; n++) {
                    if (n == i) {
                        continue;
                    }
                    if (row[i] % row[n] == 0) {
                        checksum += row[i]/row[n];
                        break rowloop;
                    }
                }
            }
        }
        return checksum;
    }
    }

