package ch.itninja.labs;

import ch.itninja.labs.basicexercises.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 120, 2, 60",
            "2, 21, 3, 7",
            "3, 4, 8, 0",
            "4, 48, 0, 2147483647",
    })
    void givenDivide_whenCalled_thenResultAsExpected(int lab, int a, int b, int expected) {

        // Init to a number not used by the methode.
        int res = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , res
                , "Please ensure that the method is called in try code block and the result is stored in variable 'res'!");

        // THEN
        assertEquals(expected, res, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("total = yourImplementation(%d, %d);", a, b);
        String output = String.format("Beispiel Ausgabe: Die Division von '%d / %d' ergibt %d.%n", a, b, res);

        ItNinjaOutput.PrintItNinjaOutput("SafeDivision"+lab, input, output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 120, 2, 230, 2, 175, ''",
            "2, 21, 3, 32, 2, 100, 'Total zu klein -> 100'",
            "3, 240, 2, 48, 0, 120, 'Exception bei `c / d`, aber `a / b` > 100'",
            "4, 48, 0, 240, 2, 100, 'Exception bei `a / b`, Total darum 0 und zu klein -> 100'",
    })
    void givenCalculation_whenCalled_thenResultAsExpected(int lab, int a, int b, int c, int d, int expected, String comment) {

        // Init to a number not used by the methode.
        int total = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode für "Mindestwert sicherstellen", welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , total
                , "Please ensure that the method is called in try code block and the result is stored in variable 'total'!");

        // THEN
        assertEquals(expected, total, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("total = yourImplementation(%d, %d, %d, %d);", a, b, c, d);
        String output = String.format("Beispiel Ausgabe: Das Total für die Berechnung mit '%d, %d, %d, %d' ist %d%s.%n"
                , a, b, c, d, total, comment.isEmpty() ? "" : " // " + comment);

        ItNinjaOutput.PrintItNinjaOutput("Calculation"+lab, input, output);
    }

}
