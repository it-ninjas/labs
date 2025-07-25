package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1200, false, 'Das Jahr 1200 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "2, 1996, true, 'Das Jahr 1996 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "3, 1900, false, 'Das Jahr 1900 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "4, 2000, true, 'Das Jahr 2000 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "5, 2021, false, 'Das Jahr 2021 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "6, 2024, true, 'Das Jahr 2024 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "7, 2100, false, 'Das Jahr 2100 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "8, 2400, true, 'Das Jahr 2400 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "9, 2023, false, 'Das Jahr 2023 ist kein Schaltjahr gemäss gregorianischem Kalender'"
    })
    void givenYears_whenCalled_thenOutputAsExpected(int lab, int year, boolean expectedResult, String expectedOutput) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        boolean result;

        try {
            // WHEN
            result = LeapYear.isLeapYear(year);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedOutput, output, "For "+year+" output should be '"+ expectedOutput +"'");
        assertEquals(expectedResult, result,  "For "+year+" result should be '"+ result +"'");
        ItNinjaOutput.PrintItNinjaOutput("LeapYear"+lab, "boolean result = LeapYear.isLeapYear("+year+");", output);
    }

}
