package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberHelperTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 63, 22, 98, 22",
            "2, 17, 67, 32, 17",
            "3, 4, 56, 3, 3",
    })
    void givenMinimumOfThree_whenCalled_thenOutputAsExpected(int lab, int a, int b, int c, int expected) {

        // Init to a number not used by the methode.
        int min = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , min
                , "Please ensure that the method is called in try code block and the result is stored in variable 'min'!");

        // THEN
        assertEquals(expected, min, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("min = yourImplementation(%d, %d, %d);", a, b, c);
        String output = String.format("Example Output: The minimum from %d, %d and %d is %d.%n", a, b, c, min);

        ItNinjaOutput.PrintItNinjaOutput("MinimumOfThree"+lab, input, output);
    }
}
