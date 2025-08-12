package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageHelperTest {

    @ParameterizedTest
    @CsvSource({
            "1, 'Peter', 'Das Meeting beginnt um 9 Uhr.', 'Nachricht an Peter: Das Meeting beginnt um 9 Uhr.'",
            "2, 'Linda', 'Bitte rufe Hans Mustermann zurück.', 'Nachricht an Linda: Bitte rufe Hans Mustermann zurück.'",
    })
    void givenPrintMessage_whenCalled_thenOutputAsExpected(int lab, String name, String message, String expected) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: methode(name, message);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();

        // Pre-Check for implementation
        assertNotEquals("" , output
                , "Output empty. Please ensure that the method is called in try code block!");

        assertEquals(expected, output, "Output is not as expected.");

        // For documentation
        String input = String.format("yourImplementation(\"%s\", \"%s\");"
                , name, message);

        ItNinjaOutput.PrintItNinjaOutput("PrintMessage"+lab, input, output);
    }
}
