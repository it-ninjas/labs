package ch.itninja.labs.basicexercises;

import java.math.BigDecimal;

/**
 * Utility class providing methods for basket calculation.
 */
public class Basket {

    private Basket() {
        // Prevent instantiation
    }

    public static void printTotalBigDecimal(){

        BigDecimal totalExpected = new BigDecimal("0.0");   // Expected total price (your calculation)
        BigDecimal total = new BigDecimal(0);               // Actual total price (computed)
        // to add 2 BigDecimal you can use total = big1.add(big2).add(big3)

        // IT-Ninja: Füge hier Deinen Code ein...
        String expectedResult;
        if(total.compareTo(totalExpected) == 0){
            expectedResult = "wie erwartet";
        }
        else if(total.compareTo(totalExpected) > 0){
            expectedResult = "zu hoch";
        }
        else {
            expectedResult = "zu tief";
        }
        System.out.println("Alle Artikel zusammen kosten CHF " + total + ". Der Preis ist " + expectedResult + ".");
    }

    public static void printTotalDouble(){

        double totalExpected = 0;   // Expected total price (your calculation)
        double total = 0;           // Actual total price (computed)

        // IT-Ninja: Füge hier Deinen Code ein...
        String expectedResult;
        if(total == totalExpected){
            expectedResult = "wie erwartet";
        }
        else if(total > totalExpected){
            expectedResult = "zu hoch";
        }
        else {
            expectedResult = "zu tief";
        }
        System.out.printf("Alle Artikel zusammen kosten CHF %.2f. Der Preis ist %s.%n", total, expectedResult);

    }

}
