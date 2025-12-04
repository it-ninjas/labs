---
title: "Projekt: Logger"
linkTitle: "Logger"
type: docs
weight: 1
description: >
  Baue ein Logging-Package. Das Package schreibt strukturierte Log-Zeilen und kann so informationen über den
  Programfluss geben.
---

## Ziele

- Ich kann ein Java-Package ohne `main` erstellen und darin **nur** statische Hilfsfunktionen bereitstellen.
- Ich kann strukturierte Log-Zeilen mit **Zeitstempel**, **Log-Level**, **PID** und **TID** ausgeben.
- Ich kann **Log-Level** unterscheiden, filtern, sichtbar machen und optional farblich kennzeichnen.
- Ich kann ein leicht lesbares **Zeitformat** zu Begin von jeder Zeile schreiben.
- Ich kann das Logging modular erweitern (**Datei**, **Rotation**, **Konfiguration**, **Thread-Sicherheit**).
- Ich halte eine **verbindliche Public-API** ein, damit Logger zwischen Auszubildenden austauschbar bleiben.

{{< zeit lesen="20" >}}

---

{{< ninja warning >}}
Für das Logger-Projekt musst Du ein neues Repository erstellen!
{{< /ninja >}}

## Einführung

Ein **Logger** dokumentiert wichtige Ereignisse deines Programms, damit du später nachvollziehen kannst, **was wann
passiert ist**. Im Gegensatz zu `System.out.println` sind Log-Einträge **strukturiert**, können **gefiltert** und
meist zusätzlich in **Dateien** gespeichert werden. Jedes Ereignis ist eine **Zeile** (bei langen Nachrichten ggf.
mehrere Zeilen), die u. a. Informationen zu **Zeit**, **Prozess** und **Thread** des Ereignisses enthält.  

In diesem Projekt baust du einen Logger **schrittweise** auf: Zuerst Konsolen-Ausgabe, dann optionale Erweiterungen wie
Datei-Logging mit Rotation, Konfiguration (API/Args/ENV/Datei) und Thread-Sicherheit.

## Informationen zum Aufbau eines Loggers

{{< ninja tip >}}
Recherchiere ein wenig im Internet, wie andere Applikationen, Tools und Services ihr Verhalten loggen.
{{< /ninja >}}

### Mitteilung (Message)

Die Mitteilung ist die Kernbotschaft eines Ereignisses. Sie dient dazu, dass der Analyst der Log-Ausgabe sich einer
Vorstellung machen kann, was aktuell in der Applikation passiert.

### Zeitstempel

Oft beginnt die Log-Ausgabe mit der aktuellen Zeit (bei länger laufenden Prozessen mit Datum). Diese Zeitangaben helfen,
ein Gefühl zu bekommen, ob es sich bei einem Problem um ein generelles Problem handelt (schreiben in eine Datei geht
nicht, weil Verzeichnis nicht vorhanden) oder nur zu bestimmten Zeiten auftaucht (jeden Abend um 21:00 ist der File-
Server für 1h nicht erreichbar da Reinigungskraft die Steckdose des Servers für den Staubsauger braucht).

Beispiel für eine Log-Ausgabe mit Zeitstempel:
```
20251118-22:04:16.345 Connection to File-Server reestablished.
```

### Log-Level

Um eine bessere Übersicht zu behalten, ob eine Log-Eintrag rein informativ ist oder ob es um eine kritische
Systeminformation geht, wird jedem Log-Eintrag ein **Level** zugeordnet. Die folgenden **Log-Levels** haben sich in der
Praxis bewährt:

| Level | Beschreibung | Typische Bedeutung / Wann verwenden |
|-------|--------------|-------------------------------------|
| TRACE | Sehr feine, detaillierte Informationen | Ablaufverfolgung auf Methoden-/Zeilenebene, tiefes Debugging |
| DEBUG | Diagnostische Informationen für Entwickler | Untersuchung von Fehlern, interne Zustände, Variablenwerte |
| INFO  | Allgemeine Laufzeitereignisse | Normaler Betriebsstatus (Start/Stop, erfolgreiche Aktionen) |
| WARN  | Ungewöhnliche oder potenziell problematische Ereignisse | Hinweise auf mögliche Probleme, die Anwendung läuft weiter |
| ERROR | Fehler, die Funktionalität beeinträchtigen | Fehler, die ein Feature/Request scheitern lassen, System läuft weiter |

Über einen **Minimal-Level** kann man normalerweise steuern, ab welcher Stufe geschrieben wird:  
`TRC` → `DBG` → `INF` → `WRN` → `ERR`.  

Bei Minimal-Level `INF` werden auch `WRN` und `ERR` geschrieben, bei Minimal-Level `WRN` nur noch `WRN` und `ERR`.

### Prozess- und Thread-Id

Vorallem bei grösseren Programmen teilen sich mehrere Threads (parallele Tasks) die Ressourcen des Systems, bei
grösseren Lösungen können es auch mehrere Prozesse sein. Die Prozess- und Thread-Id hilft, ein Ereigniss in der
Log-Ausgabe dem richtigen Prozess / Thread zuzuordnen.

- **PID** = _Process ID_, die Kennzahl deines laufenden **Prozesses** (Programms).
- **TID** = _Thread ID_, die Kennzahl eines **Ausführungsstrangs** innerhalb des Prozesses.

> Details zu Threads behandeln wir später im eigenen Modul. Für das Loggen reicht: PID/TID helfen, Aktivitäten
> voneinander zu unterscheiden.

Mit folgenden Befehlen kannst du in Java die PID und TID erhalten:

```
  long pid = ProcessHandle.current().pid(); // ab Java 9
  long tid = Thread.currentThread().getId();
```

Implementierungsvorgabe: Möglichst **dreistellig** darstellen (`000–999`) – aber **niemals abschneiden**, wenn größer.

### Module-Id / Source-Identifier (optional)

Um Log-Ausgaben noch einfacher zuordnen zu können, kann man in der Ausgabe auch eine Module-Id oder einen
Source-Identifier ausgeben. Dabei kann es sich um einen 3- oder 4-stelligen Kürzel oder aber auch um den Namen der
Klasse, des Packages, usw. handeln.

{{< ninja info >}}
Beim [einfachen Logger](./Simple/) verzichten wir bei der Standard-API bewusst auf die Möglichkeit eine Module-Id oder 
Source-Identifier mitzugeben. Einzig die Methode `writeLine` bietet den entsprechenden Parameter an.
{{< /ninja >}}

### Beispiel einer Log-Ausgabe

Das folgende Beispiel zeigt eine mögliche Log-Ausgabe. Diese Ausgabe ist nicht bindend. Du kannst sie nach eigenem
Gutdünken implementieren.

```
20251118-15:37:12.123 INF [P:184 T:124 M:MAIN] Application started
20251118-15:38:23.546 DBG [P:184 T:102 M:CONF] Loaded configuration: {"env":"production","maxThreads":8}
20251118-15:38:48.209 TRC [P:184 T:102 M:HTTP] ConnectionManager.openSocket(host=10.0.0.12, port=5432)
20251118-15:39:12.844 WRN [P:184 T:131 M:REST] Slow response from service 'user-profile' (latency=1200ms)
20251118-15:40:59.201 ERR [P:184 T:131 M:REST] NullPointerException while processing request /api/orders/473: (OrderService.java:87)
20251118-15:41:02.788 ERR [P:184 T:124 M:MAIN] OutOfMemoryError: unable to allocate 256MB — initiating shutdown
```

## Allgemeine Vorgaben

### Kontext & Einschränkungen

- **Nur statische Hilfsfunktionen:** keine Instanzen, keine Vererbungsthemen (OOP folgt später).
- **Kein `main`:** Der Logger ist ein Package, das in anderen Projekten verwendet wird.
- **Manuelle Tests:** ohne Test-Framework (siehe Abschnitt _Manuelles Testen_).
- **Coding-Style:** Verwende den it‑ninja **Coding-Style-Guide** (Einrückung, Namen, Konstanten, Javadoc).
- **Fehlertoleranz:** Öffentliche Methoden dürfen **keine Exceptions** nach außen werfen (intern behandeln, z. B. 
  Fallback auf `System.err`).

### Verbindliche Public‑API

{{< ninja warning >}}
Alles, was von außen sichtbar ist (Public-Methoden, Enums, ENV/Datei-Schlüssel), ist **vorgegeben**. Bitte **nicht**
eigenmächtig Signaturen oder Namen ändern – nur so bleiben Implementierungen verschiedener Auszubildender
**austauschbar**.
{{< /ninja >}}

Diese API ist für **alle** Implementationen verbindlich. Du kannst intern beliebig umsetzen, solange die äußere API
gleich bleibt.

```java
public final class Logger {
  // Log-Ausgabe, simple
  public static void info(String message);
  public static void warn(String message);
  public static void error(String message);
  public static void error(String message, Throwable exception);
  public static void debug(String message);
  public static void trace(String message);

  // Log-Ausgabe, advanced
  public static void writeLine(LogLevel level, String message, String sourceIdentifier, Throwable exception);

  // Level & Konsole
  public enum LogLevel { TRC, DBG, INF, WRN, ERR }
  public static void setMinLevel(LogLevel level);
  public static void enableConsoleOutput(boolean enabled);

  // Wartung / Housekeeping (z. B. Rotation, Aufräumen, Konfig-Reload je nach Umsetzung)
  public static void maintain();
}
```
### Allgemeine Akzeptanzkriterien

- Es wird ein `.jar` erstellt.
- Name des Java-Packages: ch.itninja.dojo.[deinName].logger (wobei **deinName** durch **deinen Namen** ersetzt werden
  muss)
- Es existiert eine **README.md** im Package mit **kurzer API-** und Konfigurations-Beschreibung und Beispiel.
- API ist mit JavaDoc dokumentiert.

- Keine Exceptions verlassen die öffentlichen Methoden (Fehler beim Schreiben werden intern behandelt und dokumentiert).
- **Coding-Style-Guide** eingehalten (Formatierung, Namen, Kommentare/Javadoc, keine Magic Numbers, sinnvolle
  `final`-Konstanten).


### Abgabe

{{< ninja warning >}}
Für das Logger-Projekt musst Du ein neues Repository erstellen!
{{< /ninja >}}

- Eigenes Repo `itninja-[deinName]-logger` (ersetze `[deinName]` mit deinem Namen).
- Repo-URL mit `logger/` (Package) und `demo/` (manuelle Tests).
- Kurze Beschreibung in der `README.md` – wie ausführen, wo die Datei liegt.

### Ordner-/Dateistruktur (Vorschlag)

{{< ninja tip >}}
Nutze die folgende Struktur, damit du deinen Code im **Logger-Projekt** entwickeln und im **Demo-Projekt** testen kannst!
Für die `pom.xml` in den Verzeichnissen `logger` und `demo` kannst du eine `pom.xml` aus deinen Übungen als Vorlage
nehmen.
{{< /ninja >}}

```
project-root/
  .gitignore
  pom.xml
  logger/
    src/main/java/
      ch/itninja/dojo/[deinName]/logger/
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
  <artifactId>itninja-dojo-[deinName]-logger-parent</artifactId>
  <version>1.0.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <modules>
    <module>logger</module>
    <module>demo</module>
  </modules>
</project>
```

## Architektur & Austauschbarkeit (Ausblick)

Ziel ist eine Struktur, in der wir **Packages austauschen** können: `Logger`, `Tournament`, `Game` sowie getrennte
**Frontend**- und **Backend**-Varianten. Damit können wir z. B. vergleichen, wie **GameEngine A** ein Spiel gegenüber
**GameEngine B** anders spielt, ohne den Logger oder das Frontend zu ändern.

- Halte die API des Loggers **stabil** und minimal.
- Verwende neutrale, sprechende Methodennamen und kurze, robuste Formate (siehe Pflichtformat), damit andere Module
  leicht integrieren können.
- Erstelle zusätzliche Utility-Klassen, wenn sinnvoll.

---

Die folgenden Aufgabe haben alle zum Ziel ein Package mit einem Logger zu erstellen.