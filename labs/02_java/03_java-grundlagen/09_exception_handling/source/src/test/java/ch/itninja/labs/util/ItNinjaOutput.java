package ch.itninja.labs.util;

public class ItNinjaOutput {
    public static void PrintItNinjaOutput(String lab, String input, Object output) {
        System.out.printf("<itninja output lab=\"%s\">\n", lab);
        System.out.printf("Eingabe: %s\n", input);
        System.out.printf("Ausgabe: %s\n", output);
        System.out.println("</itninja output>");
    }
}
