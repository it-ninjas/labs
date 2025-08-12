package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelReportTest {

    @Test
    void givenPrintTravelReport_whenCalled_thenOutputShowsExpectedReport() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            TravelReport.printTravelReport();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String expectedReport = new StringBuilder()
                .append("Reise Report – Takeshi, Codename ShadowFox\n")
                .append("Datum der Abreise: 26. Juli 2025\n")
                .append("Mission: Code-Review\n")
                .append("Startpunkt: Lausanne\n")
                .append("Zielort: St. Gallen\n")
                .append("Abfahrt: 06:14 Uhr\n")
                .append("Ankunft: 09:07 Uhr\n")
                .append("Zwischenhalte: 5\n")
                .append("Reisekosten: 51.80 CHF\n\n")
                .append("ShadowFox nutzte die 1. Klasse am 26. Juli 2025, um sich auf die anstehende Code-Review ")
                .append("vorzubereiten. Mit einem Akku-Ladestand von 92% und 2 mitgeführten Laptops war er bestens ")
                .append("gerüstet. Die Mission wurde erfolgreich abgeschlossen. Die Reisekosten sind in CHF.")
                .toString();

        // Make output independent of linux or windows line endings
        String output = outputStream
                .toString()
                .trim()
                .replaceAll("\r\n", "\n")
                .replaceAll("\r", "\n");

        assertEquals(expectedReport, output, "Output is not as expected");

        ItNinjaOutput.PrintItNinjaOutput("TravelReport", "TravelReport.printTravelReport();", output);

    }
}
