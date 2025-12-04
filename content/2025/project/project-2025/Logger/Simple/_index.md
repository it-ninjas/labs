---
title: "Projekt: Logger (Basis)"
linkTitle: "Logger (Basis)"
type: docs
weight: 1
description: >
  Baue ein einfaches Logging-Package, das strukturierte Log-Ausgaben auf der Konsole erzeugt und manuell getestet werden kann.
---

{{< ninja warning >}}
**Wichtig:** Beachte auch die Informationen, Abgrenzungen, Kriterien in der übergeordneten **Hauptaufgabe**!
{{< /ninja >}}

## Ziele

- Ich kann strukturierte Log-Ausgaben auf der Konsole erzeugen.
- Ich kann verschiedene Log-Level unterscheiden und sichtbar machen.
- Ich kann einen gut lesbaren Zeitstempel sowie PID und TID in jede Log-Zeile integrieren.

{{< zeit lesen="20" >}}

---

## Zielsetzung der Aufgabe

Diese Aufgabe bildet das Fundament für den vollständigen **[Logger](../)**.

- Du entwickelst ein minimales, aber robustes Logging-Package.
- Du übst, wiederverwendbare Utility-Funktionen zu strukturieren.
- Du schaffst eine Basis, auf der spätere Erweiterungen aufbauen (Datei-Logging, Rotation, Konfiguration).

Weitere Hintergrundinformationen zu Log-Level, Zeitformat, PID/TID usw. findest du in der **[Hauptaufgabe,Informationen zum Aufbau eines Loggers](../#informationen-zum-aufbau-eines-loggers)**

---

## Kontext & Einschränkungen

Es gelten alle **[allgemeinen Einschränkungen der Hauptaufgabe](#kontext--einschränkungen-für-alle-aufgaben)**.

Zusätzlich für den Basis-Logger:

- Es wird **nur auf die Konsole** geloggt.

---

## Einführung

Ein Logger ersetzt unstrukturierte `System.out.println()`-Ausgaben durch einheitliche, erweiterbare Logzeilen.  
Der Basis-Logger implementiert diese Grundfunktionen, ohne zusätzliche Features wie Datei-Handling oder Konfiguration.

Alle Details zum Aufbau eines Logeintrags findest du in der **[Hauptaufgabe,Informationen zum Aufbau eines Loggers](../#informationen-zum-aufbau-eines-loggers)**.

---

## Aufgabenstellung

Erstelle ein Java-Package, das **strukturierte Log-Ausgaben auf der Konsole** erzeugt.

Der Basis-Logger muss:

- die **[Public-API](../#public-api)** vollständig einhalten  
- Log-Level wie `info`, `warn`, `error(msg)`, `error(msg, ex)`, `debug`, `trace` unterstützen,
- Zeitstempel, Level, PID, TID und Nachricht korrekt ausgeben,
- Nachrichten ab einer gewissen Länge sauber umbrechen (max. 160 Zeichen pro Zeile) und einrücken.

**Keine neuen Anforderungen einführen — alle Angaben basieren auf der Hauptaufgabe.**

---

### Umsetzungshinweise

- Definiere zuerst ein Format für jede Log-Zeile (Zeitstempel, Level, Kontextinformationen).
- Nutze Hilfsmethoden zum Formatieren und Umbrechen von langen Texten.

#### Farbig codierte Ausgabe (optional)

Mittels farbigem Text soll zwischen den verschiedenen Log-Levels unterschieden werden können. Beispiel für farbige Ausgabe auf die Konsole:

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

## Abgrenzung

Folgende Punkte gehören **nicht** zu dieser Basis-Aufgabe:

- Module-Identifier (nur `writeLine` unterstützt optional einen Identifier)

Vollständige Abgrenzung siehe **[Hauptaufgabe, Abgrenzung für alle Aufgaben](#abgrenzung-für-alle-aufgaben)**.

---

## Testen

Stelle sicher, dass deine Lösung die Anforderungen erfüllt.

### Manuelles Testen  
Erstelle eine Demo-Klasse in einem separaten Modul `demo/` (kein `main` im Logger-Package!):

```java
public class LoggerDemo {
    public static void main(String[] args) {
        Logger.info("Round started");
        Logger.warn("Low disk space (drive=C:, freeMB=512)");
        Logger.error("Could not load config file (path=./cfg/app.yaml)");
        Logger.debug("i=42");
    }
}
```

Teste insbesondere:

- **Normale Ausgabe:** Ein Zeile-Log erscheint strukturiert.
- **Zeitstempel:** korrekte Formatierung.
- **Lange Nachrichten:** Umbrechen auf mehrere Zeilen (max. 160 Zeichen).
- **Mehrzeilige Nachrichten:** korrekt aufgesplittet.
- **Level-Filter:** `setMinLevel(LogLevel.WRN)` blendet `INFO`/`DEBUG`/`TRACE` aus.

---

## Akzeptanzkriterien

Die Aufgabe gilt als erfüllt, wenn:

- [ ] Die **[allgemeinen Akzeptanzkriterien](../#allgemeine-akzeptanzkriterien)** sind erfüllt.
- [ ] Nachrichten werden korrekt umgebrochen (160-Zeichen-Limit).
- [ ] Der Minimal-Level-Filter funktioniert wie definiert.
- [ ] Das Loggen auf die Konsole lässt sich ein- und ausschalten.

---

## Abgabe

Siehe **[Hauptaufgabe, Abgabe](../#abgabe)**