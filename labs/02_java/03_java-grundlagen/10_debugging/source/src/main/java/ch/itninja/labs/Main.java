package ch.itninja.labs;

import ch.itninja.labs.basicexercises.MagicNumber;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        try {
            int iterations = 1000;
            System.out.println("Starting calculation...");
            int z = MagicNumber.generate(iterations);
            System.out.println("The z-Value after " + iterations + " iterations is " + z);
        } catch (Exception exception){
            System.out.println("Exception occurred: " + exception);
        }
    }
}