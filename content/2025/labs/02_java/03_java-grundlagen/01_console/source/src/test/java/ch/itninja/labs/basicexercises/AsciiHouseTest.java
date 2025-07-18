package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class AsciiHouseTest {

    @Test
    void givenPrintHouse_whenCalled_thenOutputHasOnlyAllowedCharacters() {
        // GIVEN
        Set<Character> allowedChars = Set.of(
                ' ', '/', '\\', '+', '-', '_', '[', ']', '|', '\n', '\r'
        );
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            AsciiHouse.printHouse();
        } finally {
            // System.out zurücksetzen, egal ob Fehler auftritt oder nicht
            System.setOut(originalOut);
        }

        // THEN
        List<String> lines = outputStream.toString().lines().toList();

        System.out.println(lines);

        assertFalse(lines.isEmpty(), "Output should not be empty");
        assertTrue(lines.size() >= 2, "A house should have at least 2 lines, but has " + lines.size());

        for (String line : lines) {
            for (int pos = 0; pos < line.length(); pos++) {
                char c = line.charAt(pos);
                if (!allowedChars.contains(c)) {
                    fail("Invalid character '" + c + "' in line: " + line);
                }
            }
        }

        ItNinjaOutput.PrintItNinjaOutput("AsciiHouse", "", String.join("\r\n", lines));
    }
}
