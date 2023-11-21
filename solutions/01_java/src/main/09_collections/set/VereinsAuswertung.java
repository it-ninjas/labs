package set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class VereinsAuswertung {
    public static void main(String[] args) {
        // Vereinsmitglieder
        Set<String> fussballVerein = Set.of(
                "Emil", "Hans", "Felix", "Fritz", "Patrick",
                "Hanne", "Anja", "Paula", "Petra", "Anna"
        );

        Set<String> schwimmVerein = Set.of(
                "Emil", "Klaus", "Paul", "Fritz", "Patrick",
                "Hanne", "Anina", "Nicole", "Petra", "Gerda"
        );

        Set<String> musikVerein = Set.of(
                "Kari", "Hans", "Max",
                "Karin", "Petra", "Anna"
        );

        Set<String> tanzVerein = Set.of(
                "Emil", "Hans", "Paul", "Felix", "Max",
                "Lara", "Anja", "Sabine", "Anna"
        );

        // Vereinsauswertung
        Set<String> alleMitglieder = new HashSet<>();
        alleMitglieder.addAll(fussballVerein);
        alleMitglieder.addAll(schwimmVerein);
        alleMitglieder.addAll(musikVerein);
        alleMitglieder.addAll(tanzVerein);

        // Wie viele Personen machen min. in einem Verein mit
        Set<String> mindestensInEinemVerein = new TreeSet<>();
        for (String person : alleMitglieder) {
            if (fussballVerein.contains(person) || schwimmVerein.contains(person) || musikVerein.contains(person) || tanzVerein.contains(person)) {
                mindestensInEinemVerein.add(person);
            }
        }

        // Alle Personen, die im Fussball und Tanz Verein sind
        Set<String> fussballUndTanzMitglieder = new TreeSet<>(fussballVerein);
        fussballUndTanzMitglieder.retainAll(tanzVerein);

        // Alle Personen, die im Fussball sind und nicht im Tanz oder Schwimm Verein
        Set<String> nurImFussballVerein = new TreeSet<>(fussballVerein);
        nurImFussballVerein.removeAll(tanzVerein);
        nurImFussballVerein.removeAll(schwimmVerein);

        // Erstellen einer Instanz von OutputValidation
        OutputValidation outputValidation = new OutputValidation();

        // Ausgabe der Ergebnisse
        outputValidation.logAndPrint("- Wie viele Personen machen min. in einem Verein mit: " + mindestensInEinemVerein.size() + ": " + String.join(",", mindestensInEinemVerein));
        outputValidation.logAndPrint("- Alle Personen, welche im Fussball und Tanz Verein sind: " + fussballUndTanzMitglieder.size() + ": " + String.join(",", fussballUndTanzMitglieder));
        outputValidation.logAndPrint("- Alle Personen, welche im Fussball sind und nicht im Tanz oder Schwimm Verein: " + nurImFussballVerein.size() + ": " + String.join(",", nurImFussballVerein));

        // Überprüfung des Hash-Werts
        outputValidation.printControlHash();
        System.out.println(outputValidation.verifyControlHash(-1421274666));
    }
}

