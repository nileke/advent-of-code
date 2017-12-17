import static java.lang.Math.sqrt;

/**
 * Nils Ekenbäck
 * nilsek@kth.se
 * advent-of-code Date: 2017-12-16
 */
public class Decoder {

    private int startpoint;

    Decoder(int target) {
        // createSpiral(target);
        calculate(target);
    }

    void createSpiral(int target) {
        double oddInt = 3;
        int layers = 1;
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
            layers++;
        }

        System.out.println("Lower bound: " + lowerBound);
        System.out.println("My input: " + target);
        System.out.println("Upper bound: " + upperBound);
        System.out.println(upperBound - target);
        System.out.println((upperBound-lowerBound));
        System.out.println(layers);

        // 1-vector => (303,303)
        // target vector=> (371, 606)
        // vector between the two (371, 606) - (303,303) = (68, 303)
    }

    void calculate(double myInput) {
        double sqrtInput = Math.sqrt(myInput);
        double rightCorner = Math.round(sqrtInput);
        double sideLength = (rightCorner-1); // rightCorner - 1 == layer in the spiral for myInput
        double tmp = (rightCorner*rightCorner - myInput);
        double[] vectorOne = {sideLength/2, sideLength/2};
        double[] inputVector = {sideLength, tmp};

        System.out.println(inputVector[0] + ", " + inputVector[1]);
        System.out.println(vectorOne[0] + ", " + vectorOne[1]);

        // v1 - v2 == u1 == vector between two points
        // Sum of vector values gives us Manhattan Distance
        double result = Math.abs(vectorOne[0]-inputVector[0]) + Math.abs(vectorOne[1]-inputVector[1]);

        System.out.println(result);
    }

    public static void main(String[] args) {
        new Decoder(368078);
    }



}
