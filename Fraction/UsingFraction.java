
/**
 * This is a class that attempts to estimate pi
 */

public class UsingFraction {
    public static void main (String[] args) {
        Fraction MILU = new Fraction(355, 113); 
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        Fraction estimate = new Fraction(355, 113);

        while (Math.abs(Math.PI - estimate.toDouble()) >= EPSILON) {
            if (Math.PI >= estimate.toDouble()) {
                estimate.setNum(estimate.getNum() + 1);
            } else {
                estimate.setDenom(estimate.getDenom() + 1);
            }
        }
        System.out.println("Closest fraction to PI: " + estimate.toDouble());

    }
}
