package ch.itninja.labs;

import ch.itninja.labs.basicexercises.AgeCalculator;
import ch.itninja.labs.basicexercises.Basket;
import ch.itninja.labs.basicexercises.CalculateForms;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        // call methodes with some test parameters
        CalculateForms.printRectArea(5, 4);
        CalculateForms.printTriangleArea(8, 3);
        CalculateForms.printCircleArea(4);
        CalculateForms.printRectPerimeter(5, 4);

        Basket.printTotalBigDecimal();
        Basket.printTotalDouble();

        AgeCalculator.ageInMonths();
    }
}