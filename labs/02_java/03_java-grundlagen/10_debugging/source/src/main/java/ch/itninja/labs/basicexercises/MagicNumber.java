package ch.itninja.labs.basicexercises;

import ch.itninja.labs.basicexercises.util.MagicNumberHelper;

/**
 * Utility class providing helper methods for debug operations.
 */
public class MagicNumber {

    private MagicNumber() {
        // Prevent instantiation
    }

    public static int generate(int iterations) throws InterruptedException {

// IT-Ninja: Füge hier Deinen Code ein...
        // IT-Ninja: Zum Lösen der folgenden Aufgaben darfst du den Quellcode nicht verändern!

        // IT-Ninja: Aufgabe 1 - Finde heraus, welcher Wert z hat, wenn x = 500 ist.

        // IT-Ninja: Aufgabe 2 - Hat z am Ende immer den gleichen Wert, auch wenn du in der 'for'-Schleife einen
        //                       Breakpoint gesetzt hast?

        // IT-Ninja: Erstelle Screenshots und diskutiere deine Resultate und Erkenntnisse mit deinem Praxisbildner.

        int z = 0;
        for(int x = 0; x < iterations; x++) {
            z = MagicNumberHelper.getSecretValue(x);
        }
        return z;
    }
}
