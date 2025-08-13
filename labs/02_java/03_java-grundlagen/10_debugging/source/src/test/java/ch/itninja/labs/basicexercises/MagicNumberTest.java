package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MagicNumberTest {
    @Test
    void givenNumber_whenCalled_thenResultAsExpected() {
        // GIVEN
        int iterations = 1000;
        int expected = -32414486;

        int result = 0;
        try {
            // WHEN
            result = MagicNumber.generate(iterations);
        } catch (Exception exception){
            System.out.println("Exception occured: " + exception);
        }

        // THEN
        assertEquals(expected, result, "Result is not as expected.");
        ItNinjaOutput.PrintItNinjaOutput("Debug", "MagicNumber.generate("+iterations+");", "" + result);
    }
}
