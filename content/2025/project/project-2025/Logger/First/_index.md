---
title: "Projekt: Logger (alte Version)"
linkTitle: "Logger (alte Version)"
type: docs
weight: 3
description: >
  Dies ist die erste Version der Aufgabe für den Logger. Bitte nicht umsetzen. Sie wurde durch die beiden Aufgaben 
  'Logger' und 'Logger (erweitert)' ersetzt.
---

## Ziele

- Ich kann ein Java-Package ohne `main` erstellen und darin **nur** statische Hilfsfunktionen bereitstellen.
- Ich kann zeilenweise **Logausgaben** in eine Datei schreiben (anhängen, nicht überschreiben).
- Ich kann **Log-Level** unterscheiden und sichtbar machen.
- Ich kann ein leicht lesbares **Zeitformat** vorneweg in jeder Zeile schreiben.

{{< zeit lesen="15" >}}

---

{{< ninja warning >}}
Für das Logger-Projekt musst Du ein neues Repository erstellen!
{{< /ninja >}}

## Einführung

**Was ist ein Logger?** Ein Logger schreibt wichtige Ereignisse deines Programms in eine **Datei**, damit du später
nachvollziehen kannst, **was wann passiert** ist (z. B. Start, Fehler, Warnungen). Jedes Ereignis ist eine **Zeile**
(bei langen Nachrichten ggf. mehrere Zeilen), die u. a. Informationen zu **Zeit**, **Prozess** und **Thread** des
Ereignisses enthält.

**Was ist ein Log-Level?** Log-Level sind **Bedeutungsstufen**: z. B. `INF` (Information), `WRN` (Warnung), `ERR`
(Fehler). Optional: `DBG` (Debug), `TRC` (sehr detailliert). Über einen **Minimal-Level** kannst du steuern, **ab
welcher Stufe** geschrieben wird: `TRC` → `DBG` → `INF` → `WRN` → `ERR`. Bei Minimal-Level `INF` werden auch `WRN`
und `ERR` geschrieben, bei Minimal-Level `WRN` nur noch `WRN` und `ERR`.

**PID & TID (kurz):**

- **PID** = _Process ID_, die Kennzahl deines laufenden **Prozesses** (Programms).
- **TID** = _Thread ID_, die Kennzahl eines **Ausführungsstrangs** innerhalb des Prozesses.

> Details zu Threads behandeln wir später im eigenen Modul. Für das Loggen reicht: PID/TID helfen, Aktivitäten
> voneinander zu unterscheiden.

---

## Kontext & Einschränkungen

- **Nur statische Hilfsfunktionen:** keine Instanzen, keine Vererbungsthemen.
- **Kein `main`:** Das Ergebnis ist **ein Package**, das in anderen Projekten genutzt werden kann.
- **Kein Test-Framework:** Du testest **manuell** (siehe Abschnitt _Manuelles Testen_).
- **Coding-Style:** Halte den **Coding-Style-Guide** strikt ein (Einrückung, Namen, Konstanten, Javadoc etc.).

## Aufgabenstellung

Implementiere ein **Logging-Package**, das folgende Aufgaben erfüllt:

1. **Log-Zeilen schreiben:** Pflicht-Methoden `info`, `warn`, `error(msg)`, `error(msg, ex)`, `debug` schreiben eine
   oder mehrere Zeile(n) in eine Log-Datei **(append → am Ende anfügen, falls Datei schon existiert)**. Die API ist
   weiter unten definiert.

2. **Dateiformat:** In der Log-Datei muss klar ersichtlich sein, wann welches Ereignis wo vorgekommen ist.

   - **Zeitstempel:** Logging-Einträge können über mehrere Tage verteilt, aber auch innerhalb von Millisekunden
     erfolgen. Das muss ersichtlich sein.
   - **Message:** freie Nachricht; **kann mehrere Zeilen** enthalten.
   - **PID/TID:** nach Möglichkeit im Bereich 000–999 darstellen; falls grösser, darf kein Abschneiden erfolgen.
   - **Log-Level:** Kurzform verwenden: `INF`, `WRN`, `ERR`, …
   - **Quelle (optional):** Mit einem 4-stelligen String soll mitgeteilt werden können, aus welchem Package der
     Eintrag kommt (z. B. `MAIN` → aus dem Main-Package, `STHE` → aus dem String-Helper-Package, …).

3. **Dateiverwaltung & Dateiname:**

   - **Verzeichnis:** bei Bedarf erstellen.
   - **Dateiname:** es muss klar unterschieden werden können, in welcher Reihenfolge die Dateien erstellt wurden
     (über Zeitstempel, Index, …). Es soll ein Text definiert werden können, der jeweils im Dateinamen
     enthalten ist (File Identifier).
   - **Dateigrösse:** es muss festgelegt werden können, wie gross die Log-Datei werden darf (z. B. 1 MB).
   - **Rotation (Rolling):** es soll definiert werden können, wie viele (Zahl) oder wie lange (Zeit) Log-Dateien
     aufbewahrt werden sollen. Wird eine der beiden Limiten überschritten, sollen zu viele vorhandene Log-Dateien
     gelöscht werden.

4. **Thread-Sicherheit (basic):** Mehrere Aufrufe dürfen keine Zeilen **vermischen** (synchronisieren oder
   `Files.newBufferedWriter` mit Append & Flush benutzen).

5. **Konfiguration (ENV/User-Datei):**

   - Der Logger liest Einstellungen aus **Umgebungsvariablen** oder einer **User-Konfigdatei**.

     - **LogFolder:** Speicherort der Log-Dateien.
     - **LogIdentifier:** String, der in jeder Log-Datei enthalten sein soll.
     - **MinLevel:** Minimal-Level.
     - **MaxFiles:** maximale Anzahl an Log-Dateien, die aufbewahrt werden sollen.
     - **MaxDays:** maximale Aufbewahrungszeit für eine Log-Datei in Tagen.
     - **LineLen (optional):** maximale Länge einer Zeile in der Log-Datei. Längere Zeilen sollen umgebrochen
       werden.

   - **Konfig-Pfad-Ermittlung (Reihenfolge):**

     1. explizit via `setConfigPath(Path)` (falls genutzt),
     2. ENV `ITNINJA_LOGGER_CONFIG`,
     3. Default: im Benutzerverzeichnis, z. B. `~/.itninja-logger` (Windows: `%USERPROFILE%\.itninja-logger`).

   - **Umgebungsvariablen:**

     - **ITNINJA_LOGGER_LOGFOLDER:** Speicherort der Log-Dateien.
     - **ITNINJA_LOGGER_LOGIDENTIFIER:** String, der in jeder Log-Datei enthalten sein soll.
     - **ITNINJA_LOGGER_MINLEVEL:** Minimal-Level.
     - **ITNINJA_LOGGER_MAXFILES:** maximale Anzahl an Log-Dateien, die aufbewahrt werden sollen.
     - **ITNINJA_LOGGER_MAXDAYS:** maximale Aufbewahrungszeit für eine Log-Datei in Tagen.
     - **ITNINJA_LOGGER_LINELEN (optional):** maximale Länge einer Zeile in der Log-Datei. Längere Zeilen sollen
       umgebrochen werden.

   - **Konfigurationsermittlung (Reihenfolge):**
     1. explizit via Methodenaufruf im Code (falls vorhanden),
     2. aus der Konfigurationsdatei, falls definiert und vorhanden,
     3. aus den Umgebungsvariablen.

6. **Fehlertoleranz:** Wenn die Log-Datei nicht geschrieben werden kann, wirf **keine** Exception nach aussen.
   Dokumentiere das Verhalten (z. B. Fallback auf `System.err`).

7. **Performance:** Das Schreiben in die Log-Datei soll so performant wie möglich erfolgen. Alle zusätzlichen
   Aufgaben wie z. B. die Dateiverwaltung erfolgen in separaten Methoden, die beim Start aufgerufen werden und vom
   Benutzer des Logging-Packages aufgerufen werden können.

8. **Konsole:** Per Konfiguration soll es möglich sein, die Log-Ausgabe nicht nur in die Log-Datei zu schreiben,
   sondern auch auf der Konsole auszugeben. (Optional) Mittels farbigem Text soll zwischen den verschiedenen
   Log-Levels unterschieden werden können.

## API – minimale Pflicht

Die folgenden **Pflicht-Methoden** müssen vorhanden sein; alle weiteren sind **optional**. Der Logger funktioniert
**ohne** optionale Methoden (Defaults & Konfigurationsdatei/Umgebungsvariablen).

```java
public static void info(String message);
public static void warn(String message);
public static void error(String message);
public static void error(String message, Throwable exception);
public static void debug(String message);

public static void maintain(); // checks for outdated files, configuration changes, ...
```

## API – optionale Erweiterungen

```java
// Optional: explizit Konfigpfad setzen (ansonsten ENV/Default)
public static void setConfigPath(java.nio.file.Path configFile);

// Optional: direkte Datei- oder Verzeichnis-Init (bypasst/ergänzt Konfigdatei)
public static void initWithDir(java.nio.file.Path logDir, String postfix, LogLevel minLevel, String moduleCode);
public static void init(java.nio.file.Path logFile, LogLevel minLevel, String moduleCode);

// Optionale Setter (falls nicht ausschliesslich per Konfigdatei gesteuert)
public static void setLogFolder(Path path);

enum LogLevel { TRC, DBG, INF, WRN, ERR }
public static void setMinLevel(LogLevel level);

public static void setLogIdentifier(String identifier);
public static void setMaxLineLength(int len);
public static void setMaxFiles(int count);
public static void setMaxDays(int days);

// Optional Convenience
public static void trace(String message);
```

> Du darfst die API **vereinfachen oder erweitern**, solange die Anforderungen erfüllt sind.

## Manuelles Testen (ohne Test-Framework)

1. **Mini-Demo-Klasse** in _einem separaten_ Projekt (oder im selben Repo unter `demo/`), **nicht** im Logger-Package:

   ```java
   public class LoggerDemo {
       public static void main(String[] args) {
           Logger.init(Path.of("./logs/app.log"), "Tournament", LogLevel.INF);
           Logger.info("Round started");
           Logger.warn("Low disk space (drive=C: freeMB=512)");
           Logger.error("Failed to open config file (path=./cfg/app.yaml)");
       }
   }
   ```

2. **Mehrfachlauf:** Programm 3–5× starten → prüfen, dass Zeilen **angehängt** werden.
3. **Level-Filter:** `setMinLevel(LogLevel.WRN)` setzen → `INF` darf **nicht** mehr erscheinen.
4. **Race-Test (einfach):** In der Demo mehrere Threads starten, die parallel loggen → keine Zeilenverschachtelung.
5. **Datei öffnen:** Mit einem Editor prüfen, dass **keine leeren** Zeilen entstehen.
6. **(Optional) Rotation:** Datei bis > 1 MB füllen → prüfen, dass eine neue Log-Datei erstellt und beschrieben wird.

---

## Akzeptanzkriterien (Definition of Done)

- Package baut ohne Fehler, **ohne `main`**.
- Es wird ein `.jar` erstellt.
- Es existiert eine **README.md** im Package mit **kurzer API-** und Konfigurations-Beschreibung und Beispiel.
- API ist mit JavaDoc dokumentiert.
- Log-Datei wird **angelegt**, **angehängt** und enthält die geforderten Informationen.
- Minimal-Level-Filter funktioniert.
- Keine Exceptions verlassen die öffentlichen Methoden (Fehler beim Schreiben werden intern behandelt und dokumentiert).
- **Coding-Style-Guide** eingehalten (Formatierung, Namen, Kommentare/Javadoc, keine Magic Numbers, sinnvolle
  `final`-Konstanten).

---

## Ordner-/Dateistruktur (Vorschlag)

{{< ninja tip >}}
Nutze die folgende Struktur, damit du deinen Code im **Logger-Projekt** entwickeln und im **Demo-Projekt** testen kannst!
Für die `pom.xml` in den Verzeichnissen `logger` und `demo` kannst du eine `pom.xml` aus deinen Übungen als Vorlage
nehmen.
{{< /ninja >}}

```
project-root/
  pom.xml           (Aggregator)
  logger/
    src/main/java/
      ch/individuell/logger/
        Logger.java
    pom.xml
    README.md

  demo/
    src/main/java/
      LoggerDemo.java
    pom.xml
```

**`pom.xml` im Root:**

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.itninja</groupId>
  <artifactId>itninja-logger-parent</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <modules>
    <module>logger</module>
    <module>demo</module>
  </modules>
</project>
```

## Abgabe

{{< ninja warning >}}
Für das Logger-Projekt musst Du ein neues Repository erstellen!
{{< /ninja >}}

- Eigenes Repo `it-ninja-[deinName]-logger` (ersetze `[deinName]` mit deinem Namen).
- Repo-URL mit `logger/` (Package) und `demo/` (manuelle Tests).
- Kurze Beschreibung in der `README.md` – wie ausführen, wo die Datei liegt.

---

## Architektur & Austauschbarkeit (Ausblick)

Ziel ist eine Struktur, in der wir **Packages austauschen** können: `Logger`, `Tournament`, `Game` sowie getrennte
**Frontend**- und **Backend**-Varianten. Damit können wir z. B. vergleichen, wie **GameEngine A** ein Spiel gegenüber
**GameEngine B** anders spielt, ohne den Logger oder das Frontend zu ändern.

- Halte die API des Loggers **stabil** und minimal.
- Verwende neutrale, sprechende Methodennamen und kurze, robuste Formate (siehe Pflichtformat), damit andere Module
  leicht integrieren können.
- Erstelle zusätzliche Utility-Klassen, wenn sinnvoll.
