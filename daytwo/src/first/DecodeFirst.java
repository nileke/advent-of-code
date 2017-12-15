package first;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-15
 */
public class DecodeFirst {

    private Scanner sc;
    LinkedList spreadsheet;

    DecodeFirst(String filepath) {
        try {
            sc = new Scanner(new File(filepath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        readFile();
    }

    void readFile() {
        ArrayList<Integer> digits = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] row = line.split("\t");
            for (String aRow : row) {
                if (aRow.length() > 0) {
                    digits.add(Integer.parseInt(aRow));
                }
                spreadsheet.add(digits);
            }
        }
    }

    int parseInput() {
        int checksum = 0;
        for (int i=0; i < spreadsheet.size(); i++) {
            ArrayList<Integer> row = (ArrayList<Integer>) spreadsheet.pop();
            checksum += Collections.max(row) - Collections.min(row);
            }
        return checksum;
        }

    }

