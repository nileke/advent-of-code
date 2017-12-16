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
        Decode dec = new Decode(filepath);
        System.out.println(dec.parseInputOne());
        System.out.println(dec.parseInputTwo());
    }
}
