package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketTest {

    @Test
    void givenPrintTotalBigDecimal_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            Basket.printTotalBigDecimal();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        final String expectedResult = "Alle Artikel zusammen kosten CHF 5.70. Der Preis ist wie erwartet.";
        assertEquals(expectedResult, output, "Output not as expected");

        ItNinjaOutput.PrintItNinjaOutput("Basket.BigDecimal", "", output);
    }

    @Test
    void givenPrintTotalDouble_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            Basket.printTotalDouble();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        final String expectedResult = "Alle Artikel zusammen kosten CHF 5.70. Der Preis ist zu hoch.";
        assertEquals(expectedResult, output, "Output not as expected");

        ItNinjaOutput.PrintItNinjaOutput("Basket.Double", "", output);
    }

}
