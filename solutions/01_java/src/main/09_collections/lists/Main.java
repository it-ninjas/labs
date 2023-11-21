package lists;

public class Main {
    public static void main(String[] args) {
        // Erstellen von Modulen und LBVs
        Modul mathModul = new Modul("Mathematik");
        LBV mathLBV1 = new LBV(4.0f, 0.4f);
        LBV mathLBV2 = new LBV(3.5f, 0.6f);

        Modul historyModul = new Modul("Geschichte");
        LBV historyLBV1 = new LBV(2.0f, 0.3f);
        LBV historyLBV2 = new LBV(3.0f, 0.7f);

        // Hinzufügen von LBVs zu Modulen
        mathModul.addLBV(mathLBV1);
        mathModul.addLBV(mathLBV2);

        historyModul.addLBV(historyLBV1);
        historyModul.addLBV(historyLBV2);

        // Ausgabe der Zeugnis-Einträge
        mathModul.printReportEntry();
        historyModul.printReportEntry();

        // Versuch, ein Modul mit falscher Gewichtung zu erstellen
        Modul invalidModul = new Modul("Invalid Modul");
        LBV invalidLBV1 = new LBV(3.0f, 0.8f);
        LBV invalidLBV2 = new LBV(2.5f, 0.7f); // Die Gewichtung ist hier 0.6, was ungleich 1.0 ist
        invalidModul.addLBV(invalidLBV1);
        invalidModul.addLBV(invalidLBV2);
        invalidModul.printReportEntry();
    }
}
