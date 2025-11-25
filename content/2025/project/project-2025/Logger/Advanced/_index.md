---
title: "Projekt: Logger (erweitert)"
linkTitle: "Logger (erweitert)"
type: docs
weight: 2
description: >
  Erweitere deinen Logger aus der ersten Aufgabe mit der Option in eine Datei zu schreiben und das Verhalten zu
  konfigurieren. Diese Aufgabe setzt den 'Logger' aus der vorherigen Aufgabe voraus!
---

## Ziele

- Ich kann **Logausgaben** in eine Datei schreiben (anhängen, nicht überschreiben).
- Ich kann sicherstellen, dass die Logdateien nur eine klar definierte Grösse beanspruchen
- Ich kann das Verhalten des Loggers konfigurieren.

{{< zeit lesen="15" >}}

---

{{< ninja warning >}}
Für dieses Aufgabe erweiterst du deine erste Implementation des [Loggers](../Simple/)!
{{< /ninja >}}

---

## Kontext & Einschränkungen

- [Allgemeine Einschränkungen](../#kontext--einschränkungen) werden eingehalten.

## Aufgabenstellung - Schreiben in Datei

Erweitere dein **Logging-Package**, damit folgende Aufgaben erfüllt wird:

Neben der Konsole sollen Log‑Zeilen in **eine Datei** geschrieben werden (Append‑Modus). Das erlaubt spätere eine 
Analyse.

### Umsetzungshinweise

- Writer mit `StandardOpenOption.CREATE` & `StandardOpenOption.APPEND` verwenden.
- Verzeichnis bei Bedarf mit `Files.createDirectories(...)` anlegen.
- `identifier` aus `setLogIdentifier` muss im Dateinamen erscheinen (zur Zuordnung).

### Abgrenzung

- Genau **eine** Datei.
- **Ort und Name der Datei** kann selber festgelegt werden.
- **keine Rotation** (siehe weiter unten).
- **keine Limitierung** bei der Dateigrösse.

### Testen

Die Funktion wird durch manuelle Tests geprüft.

### Akzeptanzkriterien

- Datei wird beim ersten Log‑Aufruf erzeugt (falls nicht vorhanden).
- Mehrfachstart: Zeilen werden **angehängt**.
- Keine leeren Zeilen; Datei lässt sich in Editor fehlerfrei anzeigen.
- Die Log-Ausgabe beinhaltet alle Informationen wie bei der Ausgabe auf die Konsole.
- Länge einer Zeile soll maximal 160 Zeichen sein (gleicher Wert wie bei Ausgabe auf Konsole). Zu langer Text soll auf
  der nächsten Zeile eingerückt fortgesetzt werden. 

## Aufgabenstellung - Thread-Sicherheit

Erweitere dein **Logging-Package**, damit folgende Aufgaben erfüllt wird:

Auch wenn mehrere Threads parallel den Logger Aufrufen, soll die Log-Ausgabe konsistent und sauber geordnet bleiben.

### Umsetzungshinweise

Das Schreiben in eine Datei ist ein eher langsamer Vorgang. Solange nur das Hauptprogramm Log-Ausgaben macht ist das
kein Problem (ausser der Verlangsamung des ganzen Prozesses). Sobald es aber mehrere Threads gibt, besteht die Gefahr,
dass während ein Thread wenn er am schreiben in die Datei ist durch einen anderen Thread unterbrochen wird, welcher auch
in eine Log-Ausgabe machen will:

```
20251118-15:37:12.123 INF [P:184 T:124 M:MAIN] Application started
20251118-15:38:23.546 DBG [P:184 T:102 M:CONF] Loaded configuration: {"env":"production","maxThreads":8}
20251118-15:38:48.209 TRC [P:184 T:102 M:HTTP] Connection20251118-15:39:12.844 WRN [P:184 T:131 M:REST] Slow response from service 'user-profile' (latency=1200ms)
Manager.openSocket(host=10.0.0.12, port=5432)
20251118-15:40:59.201 ERR [P:184 T:131 M:REST] NullPointerException while processing request /api/orders/473: (OrderService.java:87)
20251118-15:41:02.788 ERR [P:184 T:124 M:MAIN] OutOfMemoryError: unable to allocate 256MB — initiating shutdown
```
Im obigen Beispiel sieht man, dass der Thread mit Id 102 vom Thread mit der Id 131 unterbrochen wurde.

{{< ninja info >}}
Das Thema 'Threads' wurde in den Java Grundlagen nicht behandelt. Anbei eine kurze Einführung.

Bis jetzt bis du dir gewohnt, in deiner Java Applikation ein `main` zu haben. Dort beginnt dein Programm mit der 
Ausführung des Codes und ruft ein paar Methoden auf, macht vielleiche eine Ausgabe auf die Konsole und beendet sich
dann:

```
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from main!");
        doSomething();
        System.out.println("Ending main!");
    }

    public static void doSomething() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d -> Hello from method!%n", i);
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }
}
```

Oft (eigentlich immer) wird es so sein, dass dein Programm mehrere Sachen gleichzeitig machen soll (z.B. nach Mails
suchen und gleichzeitig auf dem Server auf neue Mails prüfen). Das ist machbar, indem man mehrere Threads erstellt:

```
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from main!");

        Thread t1 = new Thread(Main::doSomething);
        Thread t2 = new Thread(Main::doSomethingOther);

        t1.start();
        t2.start();

        try {
            t1.join(); // Warten bis doSomething() fertig ist
            t2.join(); // Warten bis doSomethingOther() fertig ist
        } catch (InterruptedException e) {
            // ignore
        }

        System.out.println("Ending main!");
    }

    public static void doSomething() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d -> Hello from method!%n", i);
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }

    public static void doSomethingOther() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d -> Hello from other method!%n", i);
            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }
}
```

Java bietet noch weitere Möglichkeiten für die parallele Ausführung. Für das Lösen dieser Aufgabe beschränken wir uns
auf das erstellen von mehreren Threads mittels `new Thread(...)`.
{{< /ninja >}}

Um sicherzustellen, dass immer nur ein Thread einen Code-Abschnitt benutzen darf, bietet Java unter anderem folgende
Möglichkeit:

```
public class Main {

    private static final Object A_LOCK = new Object();

    public static void doSomethingSynchronised() {
        synchronized (A_LOCK) {
            System.out.println(message);
        }
    }
```

### Abgrenzung

- Wenn ein Thread eine Log-Ausgabe macht, werden andere Threads, welche ebenfalls eine Log-Ausgabe machen wollen
  blockiert, bis der 

## Aufgabenstellung - Datei Ort, Name, Grösse, Alter

Erweitere dein **Logging-Package**, damit folgende Aufgaben erfüllt wird:

- Es soll festgelegt werden können, was der **Name der Log‑Datei** enthalten soll und an welchem **Ort** die Log-Datei
  gespeichert werden soll.
- Es soll festgelegt werden können, wie **gross** oder wie **alt** eine Log-Datei werden darf und was beim Überschreiten
  der Grenze passieren soll (Datei löschen und neu anlegen oder Datei **rotieren**). Bei der **Datei-Rotation** werden
  mehrere alte Log-Dateien aufbewahrt (z.B. die letzten 10 oder alle Log-Datien der letzten 3 Monate). Es soll über den
  Dateiname klar sichtbar sein, welche Log-Dateien in welcher Reihenfolge zusammengehören (Zeitstempel oder Index).

Beispiele für Log-Dateinamen:
```
MyAppLog-0000.log
MyAppLog-0001.log

MyOtherAppLog-20251001.log
MyOtherAppLog-20251101.log

MyOtherApp-2025-11-19.log
MyOtherApp-2025-11-20.log
```

### Umsetzungshinweise

- Parameter über `setMaxSize(bytes)`, `setMaxFiles(count)`, `setMaxDays(days)`. Default ist keine Rotation (gleiches
  Verhalten wie bei [Aufgabenstellung - Schreiben in Datei](#aufgabenstellung---schreiben-in-datei)).
- Neuer Dateiname mit Zeitstempel oder Index (z. B. `app-2025-09-23.log`).
- Zu alte/zu viele Dateien **löschen**, wenn Limits überschritten werden.
- Logik kann in `maintain()` ausgelöst werden (z. B. beim Start oder periodisch).

### Abgrenzung
- Keine Kompression, kein Archivieren an andere Orte.

### Testen

Die Funktion wird durch manuelle Tests geprüft.

### Akzeptanzkriterien

- Falls eine Log-Datei nicht existiert, wird sie automatisch angelegt.
- Bei Überschreiten der Limits wird eine neue Datei angelegt.
- Alte Dateien werden korrekt entfernt gemäss Limits.
- Reihenfolge der Dateien ist nachvollziehbar.




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
