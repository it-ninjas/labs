package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloNameTest {

    @Test
    void givenPrintHelloName_whenCalled_thenOutputStartsWithHello() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            HelloName.printHelloName();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertTrue(output.startsWith("Hello "), "Output should start with 'Hello '");

        ItNinjaOutput.PrintItNinjaOutput("HelloName", "", output);

    }
}
