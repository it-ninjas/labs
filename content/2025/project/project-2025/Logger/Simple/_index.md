---
title: "Projekt: Logger"
linkTitle: "Logger"
type: docs
weight: 1
description: >
  Baue ein simples Logging-Package mit statischen Hilfsfunktionen. Das Package schreibt strukturierte Log-Zeilen auf die
  Konsole und kann manuell getestet werden.
---

## Ziele

- Ich kann die [Basis-Ziele](../#ziele) umsetzen
- Ich kann zeilenweise **Log-Ausgaben** auf der Konsole ausgeben.
- Ich kann **Log-Level** unterscheiden und (farblich) sichtbar machen.
- Ich kann ein leicht lesbares **Zeitformat** zu Begin von jeder Zeile schreiben.
- Ich kann mittels API-Aufruf die Log-Ausgabe ein- und ausschalten.
- Ich kann mittels API-Aufruf festlegen, ab welchem **Log-Level** die Log-Ausgabe erfolgen soll.

{{< zeit lesen="15" >}}

---

{{< ninja warning >}}
Für das Logger-Projekt musst Du ein neues Repository erstellen! [Hier](../#ordner-dateistruktur-vorschlag) findest du
einen Vorschlag, wie die Verzeichnisstruktur aussehen kann.
{{< /ninja >}}

---

## Kontext & Einschränkungen

- [Allgemeine Einschränkungen](../#kontext--einschränkungen) werden eingehalten.

---

## Aufgabenstellung / Anforderungen

Implementiere ein **Java-Logging-Package**, das folgende Anforderungen erfüllt:

### Log-Ausgabe auf Konsole

Implementiere die Pflicht-Methoden `info`, `warn`, `error(msg)`, `error(msg, ex)`, `debug`. Jeder Aufruf schreibt eine
oder mehrere Zeile(n) auf die Konsole. Die API ist [hier](../#verbindliche-publicapi) definiert.

### Maximale Zeilenlänge

Pro Zeile dürfen nicht mehr als 160 Zeichen geschrieben werden.

### Log-Level farblich darstellen (optional)

Mittels farbigem Text soll zwischen den verschiedenen Log-Levels unterschieden werden können.

Beispiel für farbige Ausgabe auf die Konsole:

```
public class ColorDemo {
    public static final String RESET  = "\u001B[0m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";

    public static void main(String[] args) {
        System.out.println(RED + "Fehler!" + RESET);
        System.out.println(GREEN + "Alles OK." + RESET);
        System.out.println(YELLOW + "Warnung!" + RESET);
        System.out.println(BLUE + "Info." + RESET);
    }
}
```

---

## Testen: manuell (ohne Test-Framework)

Stelle mit manuellen Test sicher, dass deine Implementation alle Anforderungen erfüllt.

Erstelle eine **Mini-Demo-Klasse** in _einem separaten_ Projekt (oder im selben Repo unter `demo/`), aber **nicht** im
Logger-Package:

   ```java
   public class LoggerDemo {
       public static void main(String[] args) {
           Logger.info("Round started");
           Logger.warn("Low disk space (drive=C: freeMB=512)");
           Logger.error("Failed to open config file (path=./cfg/app.yaml)");
           ...
       }
   }
   ```

Folgende Aspekte sollten deine Tests umfassen:
* **Normale Ausgabe:** Eine normale Log-Ausgabe wird korrekt auf der Konsole ausgegeben.
* **Zeitstempel:** Der Zeitstempel stimmt mit der aktuellen Zeit überein.
* **Lange Ausgabe:** Eine lange `message` soll korrekt umgebrochen und auf mehrere Zeilen verteilt werden.
* **Mehrzeilige Ausgabe:** Eine mehrzeilige `message` soll korrekt umgebrochen und auf mehrere Zeilen verteilt werden.
* **Level-Filter:** `setMinLevel(LogLevel.WRN)` setzen → `INF` darf **nicht** mehr erscheinen.

---

## Abgrenzung

- Ausgabe nur auf Konsole, **keine** schreiben in eine Datei.
- Keine externe Konfiguration (nur `setMinLevel`, `enableConsoleOutput`).

---

## Akzeptanzkriterien (Definition of Done)

- Ausgabe der Log-Einträge erfolgen auf der Konsole.
- Jede Ausgabe enthält Zeitstempel, Level, PID, TID und Nachricht (mehrzeilige Nachrichten sind erlaubt, nach erster
  Zeile soll eingerückt werden, damit Nachricht als Block wahrgenommen wird).
- Keine leeren Zeilen entstehen.
- Log-Ausgabe ist formatiert auf eine maximale Zeilenlänge von 160 Zeichen.
- Minimal-Level-Filter funktioniert.
- Package baut ohne Fehler, **ohne `main`**.
