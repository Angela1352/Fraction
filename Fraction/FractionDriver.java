
/**
 * The driver for the FractionClass
 */

public class FractionDriver {
    public static void main(String[] args) {
        //Creating fractions using each constructor
        Fraction f1 = new Fraction(); 
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction("3/5");
        Fraction f4 = new Fraction(f2);

        System.out.println("Fraction 1: " + f1);
        System.out.println("Fraction 2: " + f2); 
        System.out.println("Fraction 3: " + f3);
        System.out.println("Fraction 4: " + f4);

        //Testing accessor methods
        System.out.println("Numerator of Fraction 3: " + f3.getNum());
        System.out.println("Denominator of Fraction 3: " + f3.getDenom()); 
        System.out.println("Fraction 2 as double: " + f2.toDouble());
        System.out.println("Fraction 1 as String: " + f1.toString()); 

        // Testing mutator methods
        f1.setNum(5);
        f1.setDenom(3);
        System.out.println("Updated Fraction 1: " + f1);

        // Testing arithmetic operations //------------------------------------------------
        Fraction multiplied = Fraction.multiply(f2, f3);
        System.out.println("Multiplication Result: " + multiplied);

        Fraction added = Fraction.add(f2, f3);
        System.out.println("Addition Result: " + added);

        Fraction subtracted = Fraction.subtract(f2, f3); 
        System.out.println("Subtraction Result: " + subtracted);

    }
}

