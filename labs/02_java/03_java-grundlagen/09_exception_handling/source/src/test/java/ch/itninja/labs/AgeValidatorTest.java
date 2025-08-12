package ch.itninja.labs;

import ch.itninja.labs.basicexercises.AgeValidator;
import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AgeValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 120, false",
            "2, 21, false",
            "3, 0, false",
            "4, 130, false",
            "5, -12, true",
            "6, 145, true",
    })
    void givenValidateAge_whenCalled_thenResultAsExpected(int lab, int age, boolean exceptionExpected) {

        // Init to a number not used by the methode.
        boolean excptionOccured = false;
        String exceptionMessage = null;

        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } catch (IllegalArgumentException e) {
            excptionOccured = true;
            exceptionMessage = e.getMessage();
        }

        // THEN
        assertEquals(exceptionExpected, excptionOccured, "Program flow was not throwing as expected.");

        // For documentation
        String input = String.format("yourImplementation(%d);", age);
        String output = "Beispiel Ausgabe: " + (excptionOccured?
                String.format("Fehler: %s%n", exceptionMessage):
        String.format("Das Alter %d ist gültig.%n", age));

        ItNinjaOutput.PrintItNinjaOutput("AgeValidator"+lab, input, output);
    }
}
