package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberHelperTest {

    @Test
    void givenSumDivisibleByEightFixedRange_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumDivisibleByEightFixedRange();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expected = "Die Summe aller durch 8 teilbaren Zahlen von 1 bis 100 beträgt 624.";
        assertEquals(expected, output, "Output is not as expected");

        ItNinjaOutput.PrintItNinjaOutput("SumDivisibleByEightFixedRange", "NumberHelper.sumDivisibleByEightFixedRange()", output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10, 30, 7, 63",
            "2, 30, 10, 7, -1",
    })
    void givenSumDivisibleBy_whenCalled_thenOutputAsExpected(int lab, int min, int max, int divisor, int result) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumDivisibleBy(min, max, divisor);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expectedResult = result > 0 ? String.format("Die Summe aller durch %d teilbaren Zahlen von %d bis %d beträgt %d."
                , divisor, min, max, result) : "Berechnung mit diesen Werten nicht möglich.";

        assertEquals(expectedResult, output, "Output is not as expected.");

        // For documentation
        String input = String.format("NumberHelper.sumDivisibleBy(%d, %d, %d);"
                , min, max, divisor);

        ItNinjaOutput.PrintItNinjaOutput("SumDivisibleBy"+lab, input, output);
    }

    @ParameterizedTest
    @CsvSource({
            // einfache Beispiele mit kleinem Bereich
            "1, 1, 50, 3, 5, 90",
            "2, 1, 100, 4, 6, 432",
            "0, 10, 30, 2, 3, 84",
            "0, 1, 60, 5, 10, 210",

            // keine gemeinsamen Vielfachen im Bereich
            "3, 1, 10, 4, 6, 0",
            "0, 20, 24, 3, 5, 0",

            // min > max → Berechnung nicht möglich
            "4, 50, 1, 3, 5, -1",

            // Randwert = genau ein gemeinsames Vielfaches
            "5, 15, 15, 3, 5, 15",
            "6, 60, 60, 4, 6, 60",

            // negatives Intervall (z. B. für erweiterte Version)
            "7, -30, 30, 6, 10, 0",  // negatives Vielfaches ignoriert (nach Bedarf anpassen)

            // sehr großer Bereich
            "8, 1, 1000, 8, 12, 20664"
    })

    void givenSumCommonMultiples_whenCalled_thenOutputAsExpected(int lab, int min, int max, int number1, int number2, int result) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumCommonMultiples(min, max, number1, number2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expectedResult = result >= 0 ? String.format("Summe der Zahlen von %d bis %d, die ein gemeinsames Vielfache von %d und %d sind: %d."
                , min, max, number1, number2, result) : "Berechnung mit diesen Werten nicht möglich.";

        assertEquals(expectedResult, output, "Output is not as expected.");

        // For documentation
        String input = String.format("NumberHelper.sumCommonMultiples(%d, %d, %d, %d);"
                , min, max, number1, number2);

        ItNinjaOutput.PrintItNinjaOutput("SumCommonMultiples"+lab, input, output);
    }

}
