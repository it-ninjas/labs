---
title: "Utility Klassen"
linkTitle: "Utility Klassen"
weight: 17
description: >
  Häufig verwendete Java-Pakete mit statischen Hilfsmethoden (Utility-Klassen).
---

{{< module "J1" >}}

## Ziele

- Ich kann typische Utility-Klassen wie `Math`, `String`, `Arrays`, `System` benennen und anwenden.
- Ich kann statische Methoden anhand der Schreibweise `Klasse.Methode(...)` erkennen.
- Ich weiss, dass viele Aufgaben mit bestehenden Klassen gelöst werden können ohne eigene Objekte zu bauen.
- Ich verstehe, dass Utility-Klassen in Java oft ohne `new` verwendet werden.

{{< zeit lesen="15" >}}

## Einführung

Im Modul [„Packages“](../12_packages/) hast du bereits gelernt, was Utility-Klassen sind:
Klassen mit statischen Methoden, die du direkt über ihren Klassennamen verwenden kannst.

In diesem Modul stellen wir dir nun einige besonders nützliche Utility-Klassen aus der Java-Standardbibliothek vor.
Sie helfen dir dabei, viele typische Aufgaben zu lösen ohne dass du eigene Objekte oder Klassen bauen musst.

Java enthält viele praktische Klassen, die du sofort verwenden kannst ohne zuerst eigene Klassen oder Objekte zu
erstellen. Diese sogenannten **Utility-Klassen** stellen häufige Funktionen bereit, zum Beispiel um Zahlen zu runden,
Strings zu verarbeiten, Zufallszahlen zu erzeugen oder Arrays zu sortieren.

Die Methoden rufst du dabei, wie in früheren Modulen gelernt, direkt über den Klassennamen auf.

```java
int maximum = Math.max(10, 25); // kein Objekt nötig
```

Das macht Utility-Klassen zu idealen Helfern.

## Typische Utility-Klassen

Hier eine Auswahl von Klassen, die du sofort nutzen kannst:

### `Math` – Mathematische Funktionen

```java
int betrag = Math.abs(-42);
double wurzel = Math.sqrt(9);
double zufall = Math.random();
double kreis = Math.PI * Math.pow(5, 2); // Fläche eines Kreises mit Radius 5
```

### `Integer` / `Double` – Texte in Zahlen umwandeln

```java
int zahl = Integer.parseInt("123");
double komma = Double.parseDouble("3.14");
```

### `Arrays` – Hilfen für Arrays

```java
int[] zahlen = {3, 5, 4, 1, 5};
Arrays.sort(zahlen); // sortieren → zahlen ist danach {1, 3, 4, 5, 5}
System.out.println(Arrays.toString(zahlen)); // Ausgabe

int[] kopie = Arrays.copyOf(zahlen, 10); // Array mit mehr Platz, kopie ist danach {1, 3, 4, 5, 5, 0, 0, 0, 0, 0}
Arrays.fill(kopie, 5, 10, 99); // auffüllen ab Index 5 mit 99, kopie ist danach {1, 3, 4, 5, 5, 99, 99, 99, 99, 99}

int index = Arrays.binarySearch(zahlen, 4); // sortiert → Index von der Zahl 4 ist 2
```

### `System` – Ausgaben und Informationen

Mit `System` kannst du zum Beispiel etwas auf die Konsole schreiben (`System.out.println(...)`), die aktuelle Zeit in Millisekunden abfragen oder Informationen über die Umgebung erhalten:

```java
System.out.println("Hallo Welt"); // Kennst du schon lange :-)
long zeit = System.currentTimeMillis();
String benutzer = System.getenv("USERNAME"); // unter Windows
String home = System.getenv("HOME");         // unter Linux/macOS
```

Die Methode `System.getenv(...)` liefert dir **Umgebungsvariablen**, die vom Betriebssystem gesetzt werden – z. B. dein Benutzername oder dein Home-Verzeichnis.

### `ThreadLocalRandom` – Zufallszahlen ohne `new`

```java
int augenzahl = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 7);
```

### `LocalDate` – mit Datum rechnen

```java
java.time.LocalDate heute = java.time.LocalDate.now();
java.time.LocalDate geburtstag = java.time.LocalDate.of(2025, 9, 12);
```

### `Files` – Dateien und Verzeichnisse verwalten (ab Java 11)

Mit der Klasse `Files` kannst du einfach auf Dateien und Verzeichnisse zugreifen: lesen, schreiben, anfügen, löschen
oder auch Verzeichnisse erstellen.

```java
java.nio.file.Path pfad = java.nio.file.Path.of("daten.txt");

// Datei lesen
String inhalt = java.nio.file.Files.readString(pfad);

// Datei überschreiben
java.nio.file.Files.writeString(pfad, "Neuer Inhalt\n");

// Datei erweitern (anhängen)
java.nio.file.Files.writeString(
        pfad,
        "Zusätzliche Zeile\n",
        java.nio.file.StandardOpenOption.APPEND
);

// Datei löschen
java.nio.file.Files.delete(pfad);
```

Auch für Verzeichnisse gibt es einfache Methoden:

```java
java.nio.file.Path ordner = java.nio.file.Path.of("meinOrdner");

// Verzeichnis erstellen
java.nio.file.Files.createDirectory(ordner);

// Verzeichnis löschen (nur wenn leer!)
java.nio.file.Files.delete(ordner);
```

Für häufig genutzte Pfade wie das aktuelle Verzeichnis oder das Home-Verzeichnis kannst du folgende Techniken nutzen:

```java
String aktuellerPfad = System.getProperty("user.dir"); // aktuelles Projektverzeichnis
String home = System.getProperty("user.home");         // Home-Verzeichnis des Benutzers

// Datei im Home-Verzeichnis ansprechen
java.nio.file.Path logdatei = java.nio.file.Path.of(home, "log.txt");
```

{{< ninja warning>}}
**Wichtig:** Wenn du keinen absoluten Pfad angibst (z. B. `C:\Daten\file.txt`), dann wird der Pfad relativ zum aktuellen
Verzeichnis interpretiert. Welches Verzeichnis das ist, erfährst du mit:

```java
System.out.println(System.getProperty("user.dir"));
```

{{< /ninja >}}

## Wichtige Merkmale

- Utility-Klassen haben **nur statische Methoden** → kein `new` nötig.
- Oft sind sie **zustandslos**: sie verändern keine internen Werte.
- Sie gehören zu bekannten Paketen wie `java.lang`, `java.util`, `java.time` oder `java.nio.file`.
- Viele Klassen sind sofort verfügbar, ohne `import` (z. B. `Math`, `String`, `System`).

## Wie findest du weitere Utility-Klassen?

Java enthält Hunderte von Klassen, viele davon mit nützlichen statischen Methoden. Du kannst sie am besten so entdecken:

- Schau dir bekannte Pakete wie `java.lang`, `java.util`, `java.time` oder `java.nio.file` an.
- Verwende eine Liste von bekannten Klassen aus diesem Modul und erkunde weitere Klassen in der JavaDoc.
- Lies die **JavaDoc**, sie ist für jedes Java-Paket online verfügbar, z. B. unter:
  [!https://docs.oracle.com/en/java/javase/17/docs/api/](https://docs.oracle.com/en/java/javase/17/docs/api/)

## Erkenntnis

{{< ninja tip >}}
**Du musst das Rad nicht neu erfinden.**

Für viele Probleme gibt es bereits eine Lösung in der Java-Standardbibliothek. Ob du einen Text umwandeln, eine Liste
sortieren oder mit Datum/Zeit arbeiten möchtest. Es lohnt sich, zuerst zu prüfen, ob es bereits eine passende
Utility-Methode gibt.
{{< /ninja >}}

## Ausblick

Später wirst du eigene Klassen schreiben, um Objekte zu erzeugen und gezielt Verhalten zu kapseln. Für den Moment reicht
es aber, diese vorhandenen Helfer gut zu kennen.
