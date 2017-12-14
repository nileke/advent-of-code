package first;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-14
 */
public class RunDecoder {

    public static void main(String[] args) {
        String filepath = "data/input.txt";
        if (args.length > 0) {
            filepath = args[0];
        }
        Decoder dec = new Decoder(filepath);
        System.out.println(dec.parseInput());
    }
}
