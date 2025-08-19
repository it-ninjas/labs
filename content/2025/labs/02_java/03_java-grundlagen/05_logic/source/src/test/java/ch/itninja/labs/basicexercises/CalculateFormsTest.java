package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateFormsTest {

    @ParameterizedTest
    @CsvSource({
            "1, 4, 5, 'Das Rechteck mit a=4cm und b=5cm hat eine Fläche von 20cm2.'",
            "2, 3, 7, 'Das Rechteck mit a=3cm und b=7cm hat eine Fläche von 21cm2.'",
            "3, 6, 4, 'Das Rechteck mit a=6cm und b=4cm hat eine Fläche von 24cm2.'",
            "4, 0, 0, 'Das Rechteck mit a=0cm und b=0cm hat eine Fläche von 0cm2.'",
    })
    void givenNumbers_whenCalledPrintRectArea_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
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

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.RectArea"+lab, "CalculateForms.printRectArea("+value1+", "+value2+");", output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4, 5, 'Das Dreieck mit c=4cm und h=5cm hat eine Fläche von 10cm2.'",
            "2, 3, 12, 'Das Dreieck mit c=3cm und h=12cm hat eine Fläche von 18cm2.'",
            "3, 6, 4, 'Das Dreieck mit c=6cm und h=4cm hat eine Fläche von 12cm2.'",
            "4, 0, 0, 'Das Dreieck mit c=0cm und h=0cm hat eine Fläche von 0cm2.'",
    })
    void givenNumbers_whenCalledPrintTriangleArea_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CalculateForms.printTriangleArea(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.TriangleArea"+lab, "CalculateForms.printTriangleArea("+value1+", "+value2+");", output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4, 'Der Kreis mit r=4cm hat eine Fläche von 50.27cm2.'",
            "2, 3, 'Der Kreis mit r=3cm hat eine Fläche von 28.27cm2.'",
            "3, 6, 'Der Kreis mit r=6cm hat eine Fläche von 113.10cm2.'",
            "4, 0, 'Der Kreis mit r=0cm hat eine Fläche von 0.00cm2.'",
    })
    void givenNumbers_whenCalledPrintCircleArea_thenOutputAsExpected(int lab, int value1, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CalculateForms.printCircleArea(value1);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.CircleArea"+lab, "CalculateForms.printCircleArea("+value1+");", output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 4, 5, 'Das Rechteck mit a=4cm und b=5cm hat einen Umfang von 18cm.'",
            "2, 3, 12, 'Das Rechteck mit a=3cm und b=12cm hat einen Umfang von 30cm.'",
            "3, 6, 4, 'Das Rechteck mit a=6cm und b=4cm hat einen Umfang von 20cm.'",
            "4, 0, 0, 'Das Rechteck mit a=0cm und b=0cm hat einen Umfang von 0cm.'",
    })
    void givenNumbers_whenCalledPrintRectPerimeter_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CalculateForms.printRectPerimeter(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.RectPerimeter"+lab, "CalculateForms.printRectPerimeter("+value1+", "+value2+");", output);
    }

}
