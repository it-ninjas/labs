package ch.itninja.labs;

import ch.itninja.labs.basicexercises.CompareNumbers;
import ch.itninja.labs.basicexercises.HelloName;
import ch.itninja.labs.basicexercises.LeapYear;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        HelloName.printHelloName();
        CompareNumbers.compareNumbers(4, 7);
        LeapYear.isLeapYear(1973);
    }
}