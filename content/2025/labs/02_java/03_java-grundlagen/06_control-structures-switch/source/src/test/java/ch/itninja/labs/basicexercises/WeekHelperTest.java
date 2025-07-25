package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekHelperTest {
    @ParameterizedTest
    @CsvSource({
            "1, 'Montag', 'Der Montag ist der 1. Tag in der Woche.'",
            "0, 'Dienstag', 'Der Dienstag ist der 2. Tag in der Woche.'",
            "0, 'Mittwoch', 'Der Mittwoch ist der 3. Tag in der Woche.'",
            "2, 'Donnerstag', 'Der Donnerstag ist der 4. Tag in der Woche.'",
            "1, 'Freitag', 'Der Freitag ist der 5. Tag in der Woche.'",
            "4, 'Samstag', 'Der Samstag ist der 6. Tag in der Woche.'",
            "0, 'Sonntag', 'Der Sonntag ist der 7. Tag in der Woche.'",
            "3, 'Weihnachten', 'Weihnachten entspricht keinem bekannten Wochentag.'"
    })
    void givenYears_whenCalled_thenOutputAsExpected(int lab, String weekdayName, String expectedOutput) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        boolean result;

        try {
            // WHEN
            WeekHelper.printWeekdayNumber(weekdayName);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedOutput, output, "Output is not as expected.");
        ItNinjaOutput.PrintItNinjaOutput("Weekday"+lab, "WeekHelper.printWeekdayNumber(\""+weekdayName+"\");", output);
    }

}
