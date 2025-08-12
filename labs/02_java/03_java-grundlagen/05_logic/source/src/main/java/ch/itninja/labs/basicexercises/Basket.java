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
