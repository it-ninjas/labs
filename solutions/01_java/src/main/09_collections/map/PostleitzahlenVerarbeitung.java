package map;

import set.OutputValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PostleitzahlenVerarbeitung {
    public static void main(String[] args) {
        OutputValidation outputValidation = new OutputValidation();

        // HashMap zum Speichern der Postleitzahlen und Gemeinden
        Map<Integer, List<String>> postleitzahlenMap = new HashMap<>();

        // CSV-Datei einlesen und Daten in die HashMap speichern (UTF-8)
        int i = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/09_collections/map/Postleitzahlen_UTF8.csv", Charset.forName("UTF-8")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",\"");
                if (i != 0) {
                    int plz = Integer.parseInt(parts[0].trim());
                    String[] gemeinden = parts[1].trim().replace("\"", "").split(",");
                    postleitzahlenMap.put(plz, new ArrayList<>(Arrays.asList(gemeinden)));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Statistik und Ausgaben
        int anzahlPLZ = postleitzahlenMap.size();
        outputValidation.logAndPrint("- Anzahl PLZ: " + anzahlPLZ);

        // Gemeinden in eine Liste kopieren und sortieren
        List<String> gemeindenListe = new ArrayList<>();
        for (List<String> gemeindeList : postleitzahlenMap.values()) {
            gemeindenListe.addAll(gemeindeList);
        }
        Collections.sort(gemeindenListe);

        // Kleinste und grösste PLZ der Gemeinde Bern finden
        int kleinstePLZ = 0;
        int groesstePLZ = 0;
        int j = 0;
        for (Map.Entry<Integer, List<String>> entry : postleitzahlenMap.entrySet()) {
            if (entry.getValue().contains("Bern")) {
                int plz = entry.getKey();
                if (j == 0) {
                    kleinstePLZ = plz;
                    groesstePLZ = plz;
                }
                if (plz < kleinstePLZ) {
                    kleinstePLZ = plz;
                }
                if (plz > groesstePLZ) {
                    groesstePLZ = plz;
                }
                j++;
            }
        }
        outputValidation.logAndPrint("- Kleinste PLZ der Gemeinde Bern: " + kleinstePLZ + " Bern");
        outputValidation.logAndPrint("- Grösste PLZ der Gemeinde Bern: " + groesstePLZ + " Bern");

        // Anzahl Gemeinden mit mehr als 10 Buchstaben zählen
        long anzahlMehrAls10Buchstaben = gemeindenListe.stream().filter(g -> g.length() > 10).count();
        outputValidation.logAndPrint("- Anzahl Gemeinden mit mehr als 10 Buchstaben: " + anzahlMehrAls10Buchstaben);

        // Anzahl Gemeinden mit 7 Buchstaben zählen
        long anzahlMit7Buchstaben = gemeindenListe.stream().filter(g -> g.length() == 7).count();
        outputValidation.logAndPrint("- Anzahl Gemeinden mit 7 Buchstaben: " + anzahlMit7Buchstaben);

        // Anzahl Gemeinden mit der Buchstabenfolge 'ent' zählen
        long anzahlMitEnt = gemeindenListe.stream().filter(g -> g.contains("ent")).count();
        outputValidation.logAndPrint("- Anzahl Gemeinden mit der Buchstabenfolge 'ent': " + anzahlMitEnt);

        // Gemeinden mit 3 Buchstaben
        List<String> gemeindenMit3Buchstaben = gemeindenListe.stream().filter(g -> g.length() == 3).sorted().collect(Collectors.toList());
        outputValidation.logAndPrint("- Gemeinden mit 3 Buchstaben: " + String.join(", ", gemeindenMit3Buchstaben));

        // Kleinsten Gemeinden
        List<String> kleinstenGemeinden = new ArrayList<>();
        int minBuchstaben = Integer.MAX_VALUE;
        for (String gemeinde : gemeindenListe) {
            int buchstaben = gemeinde.length();
            if (buchstaben < minBuchstaben) {
                kleinstenGemeinden.clear();
                kleinstenGemeinden.add(gemeinde);
                minBuchstaben = buchstaben;
            } else if (buchstaben == minBuchstaben) {
                kleinstenGemeinden.add(gemeinde);
            }
        }
        Collections.sort(kleinstenGemeinden);
        outputValidation.logAndPrint("- Anzahl Buchstaben der kleinsten Gemeinden: " + minBuchstaben);
        outputValidation.logAndPrint("- Kleinsten Gemeinden: " + String.join(", ", kleinstenGemeinden));

        // Grössten Gemeinden
        List<String> groesstenGemeinden = new ArrayList<>();
        int maxBuchstaben = 0;
        for (String gemeinde : gemeindenListe) {
            int buchstaben = gemeinde.length();
            if (buchstaben > maxBuchstaben) {
                groesstenGemeinden.clear();
                groesstenGemeinden.add(gemeinde);
                maxBuchstaben = buchstaben;
            } else if (buchstaben == maxBuchstaben) {
                groesstenGemeinden.add(gemeinde);
            }
        }
        Collections.sort(groesstenGemeinden);
        outputValidation.logAndPrint("- Anzahl Buchstaben der grössten Gemeinden: " + maxBuchstaben);
        outputValidation.logAndPrint("- Grössten Gemeinden: " + String.join(", ", groesstenGemeinden));

        outputValidation.printControlHash();
    }
}


