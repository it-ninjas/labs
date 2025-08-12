package ch.itninja.labs;

import ch.itninja.labs.basicexercises.Calculator;
import ch.itninja.labs.basicexercises.AgeValidator;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        // Sample call for "Sichere Division"
        // IT-Ninja: Füge hier Deinen Code ein...

        try {
            int age = 16;
            // Sample call for "Alter prüfen"
            // IT-Ninja: Füge hier Deinen Code ein...
            System.out.printf("Das Alter %d ist gültig.%n", age);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Sample call for "Mindestwert sicherstellen"
        // IT-Ninja: Füge hier Deinen Code ein...
    }
}
