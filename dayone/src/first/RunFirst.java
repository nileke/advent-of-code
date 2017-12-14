package first;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */
public class RunFirst {

    public static void main(String[] args) {
        String filepath = "data/input.txt";
        if (args.length > 0) {
            filepath = args[0];
        }
        DecodeFirst dec = new DecodeFirst(filepath);
        System.out.println(dec.parseInput());
    }
}
