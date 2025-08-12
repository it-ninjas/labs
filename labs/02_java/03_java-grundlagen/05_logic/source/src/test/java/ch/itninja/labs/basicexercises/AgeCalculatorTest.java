package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 9, 1973, 22, 7, 2025, 623",
            "2, 15, 4, 2008, 8, 8, 2025, 209",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int dayOfBirth, int monthOfBirth, int yearOfBirth,
                                                      int dayOfToday, int monthOfToday, int yearOfToday,
                                                      int monthsExpected) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        AgeCalculator.dayOfBirth = dayOfBirth;
        AgeCalculator.monthOfBirth = monthOfBirth;
        AgeCalculator.yearOfBirth = yearOfBirth;
        AgeCalculator.dayOfToday = dayOfToday;
        AgeCalculator.monthOfToday = monthOfToday;
        AgeCalculator.yearOfToday = yearOfToday;

        String expectedResult = String.format("Ich bin am %02d.%02d.%04d geboren und heute am %02d.%02d.%04d %d Monate alt.",
                dayOfBirth, monthOfBirth, yearOfBirth,
                dayOfToday, monthOfToday, yearOfToday,
                monthsExpected);

        try {
            // WHEN
            AgeCalculator.ageInMonths();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "Output is not as expected");

        // For documentation
        String input = String.format(
                "AgeCalculator.dayOfBirth = %d;\n" +
                "AgeCalculator.monthOfBirth = %d;\n" +
                "AgeCalculator.yearOfBirth = %d;\n" +
                "AgeCalculator.dayOfToday = %d;\n" +
                "AgeCalculator.monthOfToday = %d;\n" +
                "AgeCalculator.yearOfToday = %d;\n" +
                "\n" +
                "AgeCalculator.ageInMonths();",
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            dayOfToday,
            monthOfToday,
            yearOfToday
        );
        ItNinjaOutput.PrintItNinjaOutput("AgeInMonths"+lab, input, output);
    }


}
