package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHelperTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 0, 0",
            "2, 1, 1",
            "3, 2, 1",
            "4, 7, 13",
            "5, -5, 0",
            "6, 100, -1",
    })
    void testFibonacci(int lab, int n, int expected) {

        // Init to a number not used by the methode.
        int fibonacci = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: fibonacci = methode(n);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , fibonacci
                , "Please ensure that the method is called in try code block and the result is stored in variable 'fibonacci'!");

        // THEN
        assertEquals(expected, fibonacci, "The fibonacci number is not correct");

        // For documentation
        String input = String.format("fibonacci = yourImplementation(%d);", n);
        String output = String.format("Example Output: The %d. element of the Fibonacci sequence is %d.%n", n, fibonacci);

        ItNinjaOutput.PrintItNinjaOutput("Fibonacci"+lab, input, output);
    }
}
