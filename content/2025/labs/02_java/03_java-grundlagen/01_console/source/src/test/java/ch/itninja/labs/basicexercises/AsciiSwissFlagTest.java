package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiSwissFlagTest {

    @Test
    void givenPrintSwissFlag_whenCalled_thenOutputHasValidFrameAndCharacters() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            AsciiSwissFlag.printSwissFlag();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        List<String> lines = outputStream.toString().lines().toList();

        assertFalse(lines.isEmpty(), "Output should not be empty");
        assertTrue(lines.size() >= 3, "Flag should have at least 3 lines");

        String allowedInnerChars = " +*";
        String allowedFrameChars = "|-_=`~";

        int firstLineNumber = 0;
        int lastLineNumber = lines.size() - 1;
        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber);

            boolean isFirstLine = lineNumber == firstLineNumber;
            boolean isLastLine = lineNumber == lastLineNumber;
            if (isFirstLine || isLastLine) {
                // Top or bottom line must contain a horizontal frame character
                assertTrue(
                        line.chars().anyMatch(ch -> "-_=`~".indexOf(ch) >= 0),
                        "Top/bottom line must contain at least one horizontal border character"
                );
            } else {
                // Middle lines must start and end with '|'
                assertTrue(
                        line.length() >= 2 && line.startsWith("|") && line.endsWith("|"),
                        "Line " + (lineNumber + 1) + " must start and end with '|'"
                );
            }

            // All characters must be allowed
            for (char c : line.toCharArray()) {
                if (!allowedInnerChars.contains(String.valueOf(c)) &&
                        !allowedFrameChars.contains(String.valueOf(c))) {
                    fail("Invalid character '" + c + "' in line: " + line);
                }
            }
        }

        ItNinjaOutput.PrintItNinjaOutput("AsciiSwissFlag", "", String.join("\r\n", lines));

    }
}
