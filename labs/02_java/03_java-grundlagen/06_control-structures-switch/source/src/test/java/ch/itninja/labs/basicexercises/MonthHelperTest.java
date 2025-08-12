package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthHelperTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 'Januar'",
            "2, 5, 'Mai'",
            "3, 9, 'September'",
            "4, 12, 'Dezember'",
            "5, 22, 'ungültiger Monat'",
            "6, -3, 'ungültiger Monat'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int month, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            MonthHelper.printMonthByNumber(month);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "Output is not as expected.");

        ItNinjaOutput.PrintItNinjaOutput("MonthByNumber"+lab, "MonthHelper.printMonthByNumber("+month+");", output);
    }
}
