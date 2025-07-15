package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleAreaTest {

    @ParameterizedTest
    @CsvSource({
            "1, 4, 5, 'Das Rechteck mit a=4cm und b=5cm hat eine Fläche von 20cm2.'",
            "2, 3, 7, 'Das Rechteck mit a=3cm und b=7cm hat eine Fläche von 21cm2.'",
            "3, 6, 4, 'Das Rechteck mit a=6cm und b=4cm hat eine Fläche von 24cm2.'",
            "4, 0, 0, 'Das Rechteck mit a=0cm und b=0cm hat eine Fläche von 0cm2.'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CalculateForms.printRectArea(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.RectArea"+lab, "CompareNumbers.compareNumbers("+value1+", "+value2+");", output);
    }
}
