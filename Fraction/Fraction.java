
/**
 * This class represents a fraction with a numerator and denominator.
 * @author Angela Chen
 * @version Dec. 5, 2023
 */

public class Fraction {
    //INSTANCE VARIABLES
    private int numerator;
    private int denominator;

    //CONSTRUCTORS
    /**
     * Constructs a default fraction with numerator 1 and denominator 1.
     */
    public Fraction () {
        numerator = 1;
        denominator = 1;
    }

    /**
     * Constructs a fraction with specified numerator and denominator.
     * @param num The numerator of the fraction.
     * @param den The denominator of the fraction. 
     */
    public Fraction (int num, int den) {
        numerator = num;
        denominator = den;
        Error();
    }

    /**
     * Constructs a fraction from a string.
     * @param frac The string representation of the fraction.
     */
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

    /**
     * Constructs a fraction from another Fraction object.
     * @param frac The fraction object to be copied.
     */
    public Fraction (Fraction frac) {
        numerator = frac.numerator;
        denominator = frac.denominator;
        Error();
    }

    private void Error () {
        if (denominator == 0) {
            System.out.println("ERROR - Denominator can't be 0 and has been changed to 1");
            denominator = 1;
        }
    }

    //ACCESSOR METHODS
    /**
     * @return The numerator of the fraction.
     */
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

    public static Fraction divide(Fraction a, Fraction b) {
        int n = a.numerator * b.denominator;
        int d = a.denominator * b.numerator;
        Fraction result = new Fraction(n, d);
        result.reduce();

        return result;
    }

    public static Fraction add(Fraction a, Fraction b) {
        int n = a.numerator * b.denominator + b.numerator * a.denominator;
        int d = a.denominator * b.denominator;
        Fraction result = new Fraction(n, d);
        result.reduce();

        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        int n = a.numerator * b.denominator - b.numerator * a.denominator;
        int d = a.denominator * b.denominator;
        Fraction result = new Fraction(n, d);
        result.reduce();

        return result;
    }

    //HELPER METHODS
    public int GCF(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
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
