/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-16
 */
public class Decoder {

    private int startpoint;

    Decoder(int target) {
        createSpiral(target);
    }

    void createSpiral(int target) {
        double oddInt = 3;
        int lowerBound;
        int upperBound;
        while (true) {
            upperBound = (int) Math.pow(oddInt, 2);
            if (upperBound >= target) {
                oddInt -= 2;
                lowerBound = (int) Math.pow(oddInt, 2);
                break;
            }
            oddInt += 2;
        }

        System.out.println(lowerBound);
        System.out.println(target);
        System.out.println(upperBound);
        System.out.println((upperBound-lowerBound)/4);
    }

    public static void main(String[] args) {
        new Decoder(368078);
    }



}
