
/**
 * This class represents a fraction with a numerator and denominator
 * @author Angela Chen
 * @version 1-2
 */

public class Fraction {
    //INSTANCE VARIABLES
    private int numerator;
    private int denominator;

    //CONSTRUCTORS
    public Fraction () {
        numerator = 1;
        denominator = 1;
    }

    public Fraction (int num, int den) {
        numerator = num;
        denominator = den;
        Error();
    }

    public Fraction (String frac) {
        int slash = frac.indexOf("/");

        if (slash > 0) {
            numerator = Integer.parseInt(frac.substring(0, slash));
            denominator = Integer.parseInt(frac.substring(slash+1));
            Error();
        } else {
            System.out.println("ERROR - INVALID FRACTION FORMAT");
            numerator = 1;
            denominator = 1;
        }
    }

    public Fraction (Fraction frac) {
        numerator = frac.numerator;
        denominator = frac.denominator;
        Error();
    }

    private void Error () {
        if (denominator == 0) {
            System.out.print("ERROR - Denominator can't be 0 and has been changed to 1");
            denominator = 1;
        }
    }

    //ACCESSOR METHODS
    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    //MUTATOR METHODS
    public void reduce() {
        int num = GCF(numerator, denominator);
        numerator /= num;
        denominator /= num;

        if (numerator < 0 && denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public void setNum(int num) {
        numerator = num;
    }

    public void setDenom(int den) {
        denominator = den;
        Error();
    }

    //STATIC METHODS
    public static Fraction multiply(Fraction a, Fraction b) {
        int n = a.numerator * b.numerator;
        int d = a.denominator * b.denominator;
        Fraction result = new Fraction(n, d);
        result.reduce();
        return result;
    }

    //HELPER METHODS
    public int GCF(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a-b;
            } else {
                b = b-a;
            }
        }
        return a;
    }
}
