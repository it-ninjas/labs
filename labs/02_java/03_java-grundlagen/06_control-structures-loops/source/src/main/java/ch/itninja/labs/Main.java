package ch.itninja.labs;

import ch.itninja.labs.basicexercises.NumberHelper;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        NumberHelper.sumDivisibleByEightFixedRange();
        NumberHelper.sumDivisibleBy(2, 64, 4);
        NumberHelper.sumCommonMultiples(1, 88, 3, 5);
    }
}