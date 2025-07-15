package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareNumbersTest {

    @ParameterizedTest
    @CsvSource({
            "1, -1, 5, 'Zahl1(-1) ist kleiner als Zahl2(5)'",
            "2, 23, 7, 'Zahl1(23) ist grösser als Zahl2(7)'",
            "3, 47, 47, 'Zahl1(47) ist gleich gross wie Zahl2(47)'",
            "4, 0, 0, 'Zahl1(0) ist gleich gross wie Zahl2(0)'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CompareNumbers.compareNumbers(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CompareNumbers"+lab, "CompareNumbers.compareNumbers("+value1+", "+value2+");", output);
    }
}
