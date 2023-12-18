
/**
 * This is a class that attempts to estimate pi
 */

import java.util.Scanner;

public class UsingFraction {
    public static void main (String[] args) {
        System.out.println(estimatePI());
    }

    public static double estimatePI() {
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
        return estimate.toDouble();
    }

    public void fractionQuiz() {
        Scanner in = new Scanner(System.in);

        int operatorNum = (int) Math.random()*3+1;
        String operator;

        System.out.println("Let the Fraction Quiz Begin  Answers should be in lowest terms. Good Luck! \n");

        Fraction frac1 = new Fraction((int) Math.random()*9+1, (int) Math.random()*9+1);
        Fraction frac2 = new Fraction((int) Math.random()*9+1, (int) Math.random()*9+1);
        Fraction result = new Fraction();

        if (operatorNum == 1) operator = " + ";
        else if (operatorNum == 2) operator = " - ";
        else if (operatorNum == 3) operator = " * ";
        else if (operatorNum == 4) operator = " / ";
        else operator = " ERROR ";

        System.out.println(frac1 + operator + frac2);
        if (operatorNum == 1) Fraction.add(frac1, frac2);
        else if (operatorNum == 2) Fraction.subtract(frac1, frac2);
        else if (operatorNum == 3) Fraction.multiply(frac1, frac2);
        else if (operatorNum == 4) Fraction.divide(frac1, frac2);

        String answer = in.nextLine();
        
    }
}
