
/**
 * This is a class that attempts to estimate pi
 */

import java.util.Scanner;

public class UsingFraction {
    public static void main (String[] args) {
        //System.out.println(estimatePI());
        fractionQuiz();
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

    public static void fractionQuiz() {
        Scanner in = new Scanner(System.in);

        System.out.println("Let the Fraction Quiz Begin. Answers should be in lowest terms. Good Luck! \n");
        boolean quit = false;
        int correct = 0;
        int total = 0;

        while (!quit) {
            Fraction frac1 = new Fraction(randomFrac());
            Fraction frac2 = new Fraction(randomFrac());

            String operator;
            int operatorNum = (int) (Math.random()*4);
            if (operatorNum == 0) operator = " + ";
            else if (operatorNum == 1) operator = " - ";
            else if (operatorNum == 2) operator = " * ";
            else if (operatorNum == 3) operator = " / ";
            else operator = " ERROR ";

            System.out.print(frac1 + operator + frac2 + " = ");
            String answer = in.nextLine();

            if (answer.equals("quit")) quit = true;
            else {
                Fraction uAnswer = new Fraction(answer);

                Fraction cAnswer = new Fraction();
                if (operatorNum == 0) {
                    cAnswer = Fraction.add(frac1, frac2);
                } else if (operatorNum == 1) {
                    cAnswer = Fraction.subtract(frac1, frac2); 
                } else if (operatorNum == 2) {
                    cAnswer = Fraction.multiply(frac1, frac2);
                } else if (operatorNum == 3) {
                    cAnswer = Fraction.divide(frac1, frac2);                
                }

                if (checkEqual(uAnswer, cAnswer)) {
                    System.out.println("Correct! \n");
                    correct++;
                } else {
                    System.out.println("Wrong, the answer was " + cAnswer + "\n");
                }
                total++;
            }
        }
        Fraction winLoss = new Fraction(correct, total);
        int percent = (int) ((winLoss.toDouble()*100)+0.5);
        System.out.println("Your win/loss ratio was " + winLoss + ", for a score of " + percent + " percent!");

    }

    public static Fraction randomFrac(){
        int num = (int) (Math.random()*9)+1;
        int denom = (int) (Math.random()*9)+1;
        Fraction fraction = new Fraction(num, denom);
        return fraction;
    }

    public static boolean checkEqual(Fraction f1, Fraction f2) {
        if (f1.getNum() == f2.getNum() && f1.getDenom() == f2.getDenom()) return true;
        else return false;
    }
}

