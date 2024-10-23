---
title: "Testing"
linkTitle: "Testing"
weight: 7
description: >
  Modul #J4
---

#### Ziele

- Ich weiss, warum das Testen in der Softwareentwicklung eine zentrale Bedeutung hat.
- Ich kenne die relevantesten gängigen Testarten in der Software-Entwicklung und deren Zweck.
- Ich weiss, was Testmanagement ist und was es dabei zu beachten gilt.
- Ich kenne die wichtigsten Funktionen des Frameworks JUnit 5.
- Ich kann für einfache Anwendungen selber Unit-Tests implementieren.
- Ich kenne die wichtigsten Funktionen des Frameworks Mockito.
- Ich weiss, was Mocks und Spies sind und kenne den Unterschied dazwischen.
- Ich weiss, was Test-Driven-Development ist und wie ich diese Methodik anwenden kann.

## Einführung

Tests in den unterschiedlichen Phasen der Softwareentwicklung dienen dazu festzustellen,
ob die entwickelte Software die spezifizierten Anforderungen erfüllt oder nicht.
Ausserdem können Tests Mängel in dem produzierten Code aufdecken noch bevor der Code
produktiv geschaltet wird und stellen damit sicher, dass das Endprodukt fehlerfrei funktioniert.

Tests sind vor allem aus folgenden Gründen sehr wichtig und sollen entsprechend sehr früh (dazu später)
in den Entwicklungsprozess integriert werden:

- **Testing erhöht die Qualität des entwickelten Produkts,** da damit Mängel frühzeitig entdeckt und beseitigt werden können.
- **Testing gibt mehr Sicherheit bei Änderungen am Code,** da damit sichergestellt werden kann, dass die Änderung nicht zu unerwünschten Nebenwirkungen geführt haben.
- **Testing spart Geld** da damit weniger Nachbearbeitungsaufwand in Form von Bug/Hot-Fixes betrieben werden muss.
- **Testing führt zu höherer Kundenzufriedenheit** da damit weniger Fehler den Kunden davor hindern, fehlerfrei mit dem Produkt zu arbeiten.

## Testarten

Es gibt viele verschiedene Softwaretestverfahren und Methoden, mit denen sichergestellt werden kann,
dass Änderungen am Code wie erwartet funktionieren.

Softwaretests können in zwei Bereiche unterteilt werden: manuelles Testen und automatisiertes Testen.
Beim manuellen Testen werden Testfälle manuell durch einen Menschen und ohne Unterstützung durch Werkzeuge oder Skripte ausgeführt.<br>
Beim automatisierten Testen werden Testfälle jedoch mithilfe von Tools, Skripten und Software ausgeführt.<br>

Hier werden wir uns auf das automatisierte Testen konzentrieren, da dieses im Softwareentwicklungsprozess
essenziell ist.

### Unit-Tests

Unit-Tests sind inhaltlich sehr simpel und erfolgen nah an der Quelle der Anwendung.<br>
Sie dienen zum Testen einzelner Methoden und Funktionen der von der Software verwendeten Klassen,
Komponenten oder Module.

Mit Unit-Tests stellen wir sicher, dass einzelne Funktionsblöcke einer Applikation genau das machen,
was sie sollen. Vielen passiert es am Anfang, dass nur "Positiv-Fälle" getestet werden. Konkret heisst das,
dass der getestete Teil nur im Rahmen des korrekten, erwarteten Verhaltens geprüft wird. Es ist aber genauso wichtig,
Negativ-Tests und Rahmentests durchzuführen, wo der geprüfte Teil konkret auf das Verhalten in einem Grenz- oder
Fehlerfall geprüft wird. So kann bereits vielen Fehlern in der Zukunft mit wenig Aufwand vorgebeugt werden.

Ein Unit-Test ist immer ein sog. "White-Box" Test, da der Entwickler bei der Implementation
von Unit-Tests den Sourcecode kennt oder ihn einsehen kann.

Bei Unit-Tests in Java ist der Testumfang eines Unit-Tests normalerweise in der Grössenordnung einer Methode oder Funktionalität.

In der Regel lassen sich Unit-Tests automatisieren und können einzeln oder auch in Gruppen (in sog. Test-Suites)
lokal (an der eigenen Maschine) oder von einem Continuous-Integration-Server (eine externe Maschine, die dafür sorgt, dass Programmteile sofort
getestet und zusammengeführt werden können) sehr schnell durchgeführt werden.

### Integration-Tests

Mit Integration-Tests wird sichergestellt, dass verschiedene Programmteile der Anwendung
problemlos ineinandergreifen und miteinander harmonieren. So kann beispielsweise die Interaktion mit einer Datenbank oder das
Zusammenspiel von verschiedenen Mikroservices getestet werden. Im Gegensatz zu Unit-Tests beschränkt sich diese Test-Art also nicht
auf einzelne Methoden oder Funktionen, sondern auf verschiedene Module oder Klassen und deren Zusammenspiel.

Tests dieser Art sind kostspieliger und können auch länger dauern als Unit-Tests, weil dafür mehrere
Teile der Anwendung funktionsfähig sein müssen. Dafür können konkretere Aussagen über den generellen Zustand einzelner, ineinandergreifende
Funktionalitäten aufgrund der Testergebnisse getätigt werden.

### System-Tests

System-Tests gehen noch einmal eine Stufe höher als Integrations-Tests und prüfen eine gesamte Applikation auf spezifische Business-Anforderungen.
Zumeist werden diese mithilfe von Tools automatisch ausgeführt und sind im Vergleich zu Integrations-Tests und vor allem Unit-Tests
ziemlich aufwändig.

System-Tests bieten, wenn sie richtig geschrieben und gepflegt werden, einen grossen Mehrwert für das Team. Da nicht nur einzelne Funktionen,
sondern ganze Anwendungsfälle geprüft werden und die Tests automatisch ausführbar sind, bieten sie einen starken Rückhalt bei der
Pflege der Applikation und der Kommunikation bei Erreichung einer Anforderung.

### Akzeptanz-Tests

Bei Akzeptanz-Tests wird der Umgang des Benutzers (oder auch andere, externe Programme) mit der Software
in einer vollständigen Anwendungsumgebung repliziert.
Auf diese Weise wird das ordnungsgemässe Funktionieren von Benutzerabläufen überprüft.
Die Szenarien können ganz einfach sein (z.B. Laden einer Website, Anmeldevorgang) oder auch sehr komplex
(z.B. E-Mail-Benachrichtigungen, Onlinezahlungen).

Akzeptanz-Tests sind sehr nützlich, aber auch aufwändiger zu erstellen und in automatisierter Form unter Umständen schwer zu verwalten.
Daher empfiehlt es sich grundsätzlich, Akzeptanz-Tests manuell auf Basis der Use-Cases, die man für eine Applikation hat, zu testen.
Viele Teams oder Organisations-Einheiten haben ein dediziertes Testing-Team, welches sich ausschliesslich um das Testen von Applikationen
und den Umgang mit gefundenen Fehlern kümmert.

Wichtig anzumerken ist ebenfalls, dass Akzeptanz-Tests auch nicht-funktionale Anforderungen abdecken. Während Unit-Tests
hauptsächlich funktionale Anforderungen wie beispielsweise eine Anmeldefunktion geprüft werden, werden mit Akzeptanz-Tests auch
nicht-funktionale Anforderungen wie bspw. die Latenz von Anfragen geprüft.

---

## Testmanagement

Unter Testmanagement versteht man die geplante und effiziente Koordination aller Testprozesse, die die Qualität von Software optimieren und langfristig gewährleisten.
Grundsätzlich wird so die Identifizierung von und Reduzierung teilweise versteckter Qualitätsrisiken ermöglicht, womit potenzielle zukünftig auftretende finanzielle und aufwandstechnische
Belastungen in der Zukunft minimiert werden können. Hauptsächlich verfolgt das Testmanagement also 2 Ziele:

- Möglichst früh Software-Fehler aufdecken.
- Die Unsicherheit bezüglich der Qualität der Software minimieren.

Diese beiden Punkte sollen nachfolgend noch ein Stück ausformuliert werden.

### Möglichst früh Software-Fehler aufdecken

Oft ist es so, dass in der Entwicklung, Anpassungen oder Installation von Software erst recht spät getestet wird, was dazu führt, dass eine entsprechende Reaktion auf einen Fehler
meist erst verspätet ermöglicht wird. Grundsätzlich ist es so, dass die aus einem Fehler entstehenden Kosten exponentiell ansteigen, je später ein solcher gefunden und behandelt wird.
Die untenstehende Grafik veranschaulicht das relativ gut. Während das Beheben eines gefundenen Fehlers beim Erstellen und Prüfen der Anforderungen (Reqs) kaum etwas kostet, sind die
Kosten im Produktiven-Kontext (PROD) schon um einiges höher.

![Kostenverlauf für Fehler je nach Zeitpunkt](../java-testing/kosten_fehler.png)

Da die meisten Fehler schon sehr früh im Umsetzungs-Ablauf passieren, lohnt es sich enorm, in ein sinnvolles Test-Management zu investieren, da so enorm viele Ressourcen gespart
werden können.

### Die Unsicherheit bezüglich der Qualität der Software minimieren

Es ist oft schwierig, einen guten Ausgleich zwischen einer guten Testabdeckung und einer lohnenswerten Wirtschaftlichkeit für das Unternehmen zu finden, da beispielsweise eine Testabdeckung
von 100% bei einer App schon sehr teuer werden kann. Daher ist es auch ein Fehlschluss, dass man mit genügend Tests sicherstellen könne, dass eine Software **fehlerfrei** ist. Testmanagement
hat daher zum Ziel, die Unsicherheit, dass eine Software **kritische** Fehler enthält, soweit zu minimieren, dass eine Produktivsetzung der App ohne schlechtes Gewissen durchgeführt werden kann.
Testmanagement hat daher **nicht** zum Ziel, dass eine Software absolut fehlerfrei ist.

### Vorteile von Testmanagement

Ein strukturiertes Testmanagement mit klar verteilten Rollen, Verantwortlichkeiten und Aufgaben resultiert zumeist in einigen Vorteilen, beispielsweise den folgenden:

- **Kostenreduktion**: Da Fehler oft zu einem früheren Zeitpunkt gefunden werden, wenn ein sinnvolles Testmanagement umgesetzt wird, können viele sonst entstehende Mehrkosten vermieden werden.
  Zudem bestehen in diesem Fall auch geringe Wartungsaufwände durch wiederholbare Tests und Klarheit in Bezug auf die zu testenden Anforderungen. Auch so kann stellenweise viel Geld gespart werden.
- **Bessere Planbarkeit** der Testphasen durch bekannte Testumfänge.
- **Personenunabhängige Tests** durch ausreichende Testfalldefinitionen und -dokumentation, was je nachdem sogar ein Outsourcing des Testings erlaubt.
- Stetige **Verbesserung der Softwarequalität** durch das Leben und durchgehende Verbessern des Testmanagements.
- Potenzielle Ressourcen- und Zeiteinsparung durch automatisierte Tests.

### Der Testprozess nach ISTQB

Ein offizieller Testprozess, nachdem man sich grundsätzlich ausrichten kann, ist der des International Software Testing Qualitications Board. (ISTQB)
Das ISTQB hat gängige, bewährte Praktiken und Terminologien zu einem prinzipiell universell anwendbaren Standard gebündelt, auf den nachfolgend etwas genauer eingegangen werden soll.

Der ISTQB-Prozess besteht grundsätzlich aus 4 Testphasen:

- Incident Management
- Problem Management
- Change Management
- Release Management

![ISTQB-Prozess](../java-testing/testprozess_ISTQB.png)

Zu den jeweiligen Phasen gehören jeweils noch die entsprechenden Aktivitäten, namentlich die Planung, Spezifikation, Durchführung, Protokollierung und Auswertung der Tests. Diese Aktvitäten werden per
ISTQB jeweils in die folgenden Gruppen eingerodnet:

- Testplanung und -steuerung
- Testanalyse und -design
- Testrealisierung und -durchführung
- Testauswertung und -bericht
- Abschluss

### Rollen im Testmanagement

Es gibt innerhalb des Testmanagements viele verschiedene Rollen, die jeweils verschiedene Tätigkeiten verfolgen. Wie man diese unterscheidet, ist jeweils abhängig von der Tiefe der Betrachtung pro Fall,
der Einfachheit nehmen wir hier aber die einfachste Unterscheidung mit 2 Rollen; einmal der des Testmanagers und einmal der des Testers.

#### Testmanager

Der Testmanager ist für den gesamten, übergreifenden Testprozess und die erfolgreiche Durchführung der Testaktivitäten zu verantworten. Da es sich hier um eine rein koordinative Arbeit handelt, kann diese Rolle
von verschiedenen Personen übernommen werden. Wenn es der technische Prozess fordert, kann das ein professioneller Testmanager sein, in anderen Fällen kann es aber genau so gut ein Projektleiter ohne grossen technischen
Hintergrund sein.

Typische Aufgaben eines Testmanagers umfassen:

- Das Festlegen der Testrategie und -vorgaben für das Unternehmen
- Das Erstellen und Aktualisieren von Testplänen
- Das Koordinieren der Testpläne zwischen verschiedenen Stakeholdern
- Das Einplanen und Anstossen der verschiedenen Testaktivitäten wie der Testanalyse, dem Testdesign, der Testimplementierung und der Testdurchführung.
- Das Monitoring (Überwachen) der Testfortschritte und -ergebnisse
- Das Berichten über die Testfortschritte und -ergebnisse

Diese Aufgaben sind nicht als fixe Beschreibung der Rolle eines Testmanagers zu verstehen, sondern mehr als Beispiele. Je nach Grösse des Unternehmens, Anforderungen an das Testmanagement und das Produkt selbst und gegebener Zeit
können andere Aufgaben dazukommen oder genannte Aufgaben wegfallen. Eine Priorisierung dieser Aufgaben ist somit für jeden Fall unterschiedlich.

#### Tester

Ein Tester übernimmt grundsätzlich alle operativen Aufgaben innerhalb des Testprozesses, wobei das Durchführen der Tests nur eine Aufgabe darstellt, die der Tester übernimmt.
Je nachdem, welches Rollenmodell verfolgt wird, wird innerhalb der Rolle des Testers noch weiter zwischen einzelnen rollen unterschieden. Das können beispielsweise die folgenden sein:

- Testdesigner
- Testautomatisierer
- Testarchitekt
- etc.

Im Rahmen dieser Dokumentation nehmen wir aber alle diese Teilrollen unter einen Hut als "Tester". Typische Aufgaben in dieser Rolle können das Folgende umfassen:

- Prüfen der Anforderungen, Spezifikationen und Akzeptanzkriterien in Bezug auf die Testbarkeit
- Identifizieren und Dokumentieren der Testvoraussetzungen
- Erstellung und Implementation von Testfällen und Testprozeduren
- Erstellung des detaillierten Testausführungsplans
- Testautomatisierung
- (Bereitstellung der Testumgebung mit geeigneten Testdaten)

---

## JUnit

Zur Implementation von Unit-Tests steht in Java das Framework JUnit zur Verfügung.
Die aktuellste Version ist 5.9.0. Dies ändert aber stetig, da das Produkt laufend weiterentwickelt wird.
Vielfach ist in Produkten und Projekten auch JUnit 4 im Einsatz.
In diesem Modul wird jedoch nur die aktuellste Version von JUnit behandelt.
Wir schreiben Unit-Tests also mit JUnit 5.

### Wie ist JUnit 5 aufgebaut?

Das Framework besteht aus folgenden Teilen:

| Teil            | Verwendung                                                                                                                                                                                                                                            |
| --------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| JUnit Plattform | Grundlage zur Einführung von Testframeworks in die JVM. Definition der Test-Engine zur Entwicklung von Testframeworks auf der jeweiligen Plattform. Plattform-Konsole zum Starten der Plattform. Kurz gesagt: Plattform zur Ausführung von Unit-Tests |
| JUnit Jupiter   | Programmiermodell zur Implementation von Unit-Tests                                                                                                                                                                                                   |
| JUnit Vintage   | Ermöglicht die Ausführung von Tests, die mit JUnit 3 oder JUnit 4 geschrieben wurden                                                                                                                                                                  |

### Wo kann ich das Framework herunterladen?

Damit wir nun Unit-Tests implementieren können benötigen wir zuerst die Bibliotheken von JUnit 5, dies wird in den beiden folgenden Abschnitten beschrieben.

#### Abhängigkeiten einbinden ohne Maven

Dieser Abschnitt kann übersprungen werden, wenn mit einem Maven-Projekt gearbeitet wird.
Alle Bibliotheken sind unter den beiden folgenden Links zu finden:

- [org.junit.jupiter](https://search.maven.org/search?q=g:org.junit.jupiter%20AND%20v:5.9.0)
- [org.junit.platform](https://search.maven.org/search?q=g:org.junit.platform%20AND%20v:1.9.0)

Die folgenden JARs werden benötigt:

- Aus dem ersten Link
  - junit-jupiter-engine
  - junit-jupiter-params
  - junit-jupiter
  - junit-jupiter-api
- Aus dem zweiten Link
  - junit-platform-engine
  - junit-platform-commons

Die Einbindung in ein Projekt muss (ohne Maven) manuell gemacht werden. Die folgende Anleitung soll dabei helfen:

| #   | Beschreibung                                                                                                                                              | Screenshot                                                   |
| --- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------ |
| 1   | Ordner für Bibliotheken im Projekt anlegen. Im Projekt (Root) einfach einen neuen Ordner "lib" erzeugen.                                                  | ![lib-Verzeichnis erstellen](../java-testing/1518642046.png) |
| 2   | Die oben genannten JAR-Bibliotheken in den neuen Ordner kopieren                                                                                          | ![JARs kopieren](../java-testing/1616908690.png)             |
| 3   | Projekteinstellungen öffnen. Das Projekt mit einem Klick markieren und Taste F4 drücken. Die Projekteinstellungen werden geöffnet                         |                                                              |
| 4   | Auf der linken Seite den Tab "Libraries" auswählen                                                                                                        | ![Lib-Tab auswählen](../java-testing/1518642115.png)         |
| 5   | Oben auf das Plus-Icon klicken und Java auswählen                                                                                                         | ![Bibliothek hinzufügen](../java-testing/1518642153.png)     |
| 6   | Die vorhin kopierten Bibliotheken auswählen und alle Dialoge mit OK bestätigen                                                                            | ![Bibliotheken auswählen](../java-testing/1616908730.png)    |
| 7   | Die Bibliothek muss anschliessend dem Modul hinzugefügt werden. Der Scope sollte auf Test gestellt werden, da es sich um reine Test-Bibliotheken handelt. | ![Ins Modul aufnehmen](../java-testing/1616908738.png)       |

#### Abhängigkeiten einbinden mit Maven

Dieser Abschnitt kann übersprungen werden, wenn es sich nicht um ein Maven Projekt handelt.

Die entsprechenden Abhängigkeiten für das Project Object Model (pom.xml) sind:

```xml
<dependencies>
  <!-- Plattform -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>

  <!-- API, enthält unter anderem alle Annotationen -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>

  <!-- Test-Engine zur Ausführung von Unit-Tests, die mit JUnit 5 geschrieben wurden -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>

  <!-- JUnit 5 Erweiterung für parametrisierte Tests (Optional) -->
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-params</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>

  <!-- Test-Enginge zur Ausführung von Unit-Tests, die mit JUnit 3 oder JUnit 4 geschrieben wurden (Optional) -->
  <dependency>
    <groupId>org.junit.vintage</groupId>
    <artifactId>junit-vintage-engine</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>

  <!-- Bibliotheken für die Ausführung von Unit-Tests -->
  <dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-engine</artifactId>
    <version>1.9.0</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.junit.platform</groupId>
    <artifactId>junit-platform-commons</artifactId>
    <version>1.9.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

Füge diese Abhängigkeiten (ohne die optionalen) in dein pom.xml ein. Danach besitzt du alle Bibliotheken, die zur Implementation von Unit-Tests notwendig sind.

### Ordnerstruktur anlegen

Um Unit-Tests implementieren zu können benötigen wir grundsätzlich die folgende Ordnerstruktur im IntelliJ IDEA.

![Ordnerstruktur IntelliJ IDEA](../java-testing/1518642456.png)

Falls dein Projekt kein Maven-Projekt ist, kannst du die Verzeichnisse einfach manuell anlegen. Mit einem Rechtsklick auf die Verzeichnisse, kannst du sie mit dem Befehl "Mark Directory as" aus dem Kontext-Menü wie folgt markieren:

| Verzeichnis        | Markierung          | Zweck                                                      |
| ------------------ | ------------------- | ---------------------------------------------------------- |
| src/main/java      | Sources Root        | Source Code deiner Applikation                             |
| src/main/resources | Resources Root      | Ressourcen deiner Applikation, die nicht Programmcode sind |
| src/test/java      | Test Sources Root   | Source Code deiner Unit-Tests                              |
| src/test/resources | Test Resources Root | Ressourcen deiner Unit-Tests, die nicht Programmcode sind  |

Diese Ordnerstruktur wurde ursprünglich vom Projektmanagement-Tool Gradle "erfunden" und dann von Maven übernommen. Stand heute ist dies die Standard-Ordnerstruktur innerhalb von Java-Projekten.

### Implementation von Unit-Tests an einem Beispiel

Nach all den Vorbereitungen sind wir nun bereit Unit-Tests zu implementieren. Der folgende Abschnitt beschreibt die Grundlagen für das Schreiben von Unit-Tests.

Das JUnit-Framework

- nutzt Assertions, um Resultate innerhalb eines Tests zu überprüfen
- nutzt Annotationen, um Testfälle zu finden und durchzuführen

#### Erklärung

Beispiel einer Unit-Test Implementation anhand eines einfachen Beispiels.

**Source-Code**

```java
package ch.sbb.talentfactory.calculator;

public class Calculator {
    public int add(int i1, int i2) {
        return i1 + i2;
    }
}
```

**Test-Code**

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator uut = new Calculator();

    @Test
    public void testAdd() {
        // prepare test data
        int i1 = 5;
        int i2 = 9;
        // call method
        int result = this.uut.add(i1, i2);
        // verify
        assertEquals(14, result);
    }
}
```

Der Unit-Test befindet sich im gleichen Package wie die zu testende Klasse. Innerhalb der weiter oben genannten Ordnerstruktur ist die Test-Klasse aber nicht am gleichen Ort abgelegt! Innerhalb des Unit-Tests wird zuerst eine Instanz der zu testenden Klasse angelegt. Die Bezeichnung für diese Instanz lautet normalerweise UUT, dies steht für "Unit Under Test". Für jeden Test einer der Methoden aus dem UUT wird anschliessend eine Test-Methode implementiert. Diese Methoden sind mit @Test zu annotieren, so werden sie anschliessend vom Test-Framework als eigenständiger Test erkannt und ausgeführt. Ein Unit-Test kann beliebig viele Testmethoden enthalten. Grundsätzlich reichen aber je nach Funktionalität ein paar wenige Tests aus, um die ganze Funktionalität einer Methode zu überprüfen. Innerhalb der Test-Methoden implementieren wir dann "normalen" Programmcode, welcher den Code aus dem UUT "überprüft". In unserem Beispiel setzen wir zwei Variablen und rufen damit die zu testende Methode auf. Mit einer Assertion vergleichen wir dann einen erwarteten Wert mit dem von der Methode zurückgelieferten Resultat. Beachte, dass der erwartete Wert in der Assertion immer an erster Stelle stehen muss. Wenn die beiden Werte identisch sind, dann ist der Unit-Test erfolgreich.

### Vorgehen beim Schreiben von Unit-Tests

Grundsätzlich sollte die AAA-Methode angewendet werden, sie ist auch im Beispiel oben ersichtlich. AAA steht für "Arrange", "Act" und "Assert". "Arrange" steht dabei für die Vorbereitung des Tests, "Act" ist die eigentliche Durchführung und mit "Assert" werden die Resultate des Tests überprüft.

### Grenzwerte austesten

Vielfach sind gewisse Funktionen in einer Applikation so implementiert, dass sie sich mit wenigen Unit-Tests komplett testen lassen. Dazu ein kleines Beispiel: gegeben ist ein Rechteck mit bestimmten Koordinaten (Ecke oben links) und einer bestimmten Grösse (Höhe und Breite).  
Eine Methode innerhalb des Rechtecks dient dazu herauszufinden, ob eine bestimmte Koordinate inner- oder ausserhalb des Rechtecks liegt. Punkte, die auf dem Rand zu liegen kommen gelten in diesem Sinne nicht als innerhalb des Rechtecks.

```java
package ch.sbb.talentfactory.rectangle;

public class Rectangle {
    private int top;
    private int left;
    private int width;
    private int height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height= height;
    }

    public boolean isInside(int x, int y) {
        if (x > left && x < left + width) {
            if (y > top && y < top + height) {
                return true;
            }
        }
        return false;
    }
}
```

Damit keine Verwirrung entsteht, hier das verwendete Koordinatensystem.
![Koordinatensystem](../java-testing/1623657498.png)

Wie wir in der Implementation sehen können, gibt es hier vier verschiedene Bedingungen. Das Ziel des Tests muss es also sein, dass wir alle diese Bedingungen überprüfen. Wenn immer möglich, sollten alle möglichen Kombinationen getestet werden. Nur so kann sichergestellt werden, dass die Methode wie gewünscht funktioniert. Aufgrund der AND-Verknüpfung werden die zweiten Bedingungen der jeweiligen Statements nicht mehr ausgewertet. Damit müssen die folgenden Kombinationen durch einen Unit-Test abgedeckt werden

| Bedingung  | x > left | x < left + width | y > top | y < top + height | Resultat |
| ---------- | -------- | ---------------- | ------- | ---------------- | -------- |
| Variante 1 | False    |                  |         |                  | False    |
| Variante 2 | True     | False            |         |                  | False    |
| Variante 3 | True     | True             | False   |                  | False    |
| Variante 4 | True     | True             | True    | False            | False    |
| Variante 5 | True     | True             | True    | True             | True     |

Dies bedeutet wir implementieren fünf Unit-Tests, um die Methode vollständig abzudecken.

```java
package ch.sbb.talentfactory.rectangle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

	// I know this is a square ;-)
    private Rectangle uut = new Rectangle(0, 0, 10, 10);

    @Test
    public void testIsInside() {
        assertFalse(this.uut.isInside(-1, 5));
        assertFalse(this.uut.isInside(11, 5));
        assertFalse(this.uut.isInside(5, -1));
        assertFalse(this.uut.isInside(5, 11));
        assertTrue(this.uut.isInside(5, 5));
    }

}
```

Im IntelliJ gibt es wie bei der Ausführung einer Applikation auch die Möglichkeit einen Unit-Test zu debuggen.
Zusätzlich können wir die Testabdeckung anschauen, wenn wir den Unit-Test mit "Coverage" durchlaufen lassen. Wenn der Test erfolgreich durchgelaufen ist, dann kann die getestete Klasse geöffnet werden.

![Klasse mit Coverage](../java-testing/1623656576.png)

Die grünen Balken auf der linken Seite zeigen die Testabdeckung an. In diesem Fall sind sämtliche Zeilen durch einen Test durchlaufen worden.

Da der Unit-Test nun alle Möglichkeiten der Methode abdeckt, kann ein einfaches Refactoring durchgeführt werden. In unserem Fall kann die Methode wie folgt vereinfacht werden:

```java
public boolean isInside(int x, int y) {
	return x > left && x &lt; left + width && y &gt; top && y < top + height;
}
```

Der Test kann dann beliebig oft erneut durchgeführt werden, um das Refactoring zu überprüfen.

### Annotationen von JUnit5

Die folgende Tabelle zeigt eine Übersicht über die wichtigsten Annotationen von JUnit 5. Mehr Informationen zu den jeweiligen Annotationen finden sich in den nächsten Kapiteln.

| Annotation                                           | Beschreibung                                                        |
| ---------------------------------------------------- | ------------------------------------------------------------------- |
| @Test                                                | Bezeichnet einen Test                                               |
| @ParameterizedTest                                   | Bezeichnet einen parametrisierten Test                              |
| @RepeatedTest                                        | Bezeichnet einen sich wiederholenden Test                           |
| @DisplayName                                         | Namensgebung für Testklassen und -methoden                          |
| @Disabled                                            | Möglichkeit eine Testklasse oder -methode nicht ausführen zu lassen |
| @TestMethodOrder<br>@Order                           | Ausführungsreihenfolge der Tests bestimmen.                         |
| @BeforeAll<br>@BeforeEach<br>@AfterAll<br>@AfterEach | Initialiserungen und Aufräumarbeiten vor und nach Unit-Tests        |

### Parametrisierte Unit-Tests

Der oben gezeigte Unit-Test ist ein typisches Beispiel für einen Test, der mit vielen unterschiedlichen Parametern durchlaufen werden sollte.
Wenn wir den Test parametrisieren, können wir die Test-Methode wiederverwenden.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator uut = new Calculator();

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9 })
    public void testAddParameterized(int operand1) {
        // call method
        int result = this.uut.add(operand1, 5);

        // verify
        assertEquals(operand1 + 5, result);
    }
}
```

Der gezeigte Test wird so insgesamt neun Mal durchlaufen, wobei der Parameter **operand1** jeweils die Werte des angegebenen Arrays durchläuft.

### Wiederholende Unit-Tests

Unit-Tests können mehrmals hintereinander ausgeführt werden, dabei wird die annotierte Test-Methode einfach mehrfach aufgerufen. Die Anzahl Aufrufe wird durch den Parameter in der Annotation bestimmt.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator uut = new Calculator();

    @RepeatedTest(10)
    public void testAddRepeated() {
        // prepare test data
		Random random = new Random();
        int i1 = random.nextInt(100);
        int i2 = random.nextInt(100);

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(i1 + i2, result);
    }
}
```

Repetierende Tests können wie oben gezeigt benutzt werden, um beispielsweise mit generierten Zufallszahlen bestimmte Funktionen zu überprüfen.

### Display Names

Testklassen und -methoden können mit der Annotation @DisplayName beliebig umbenannt werden.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Special test for calculator")
public class CalculatorTest {
    private Calculator uut = new Calculator();

    @Test
	@DisplayName("Ultimate addition test")
    public void testAdd() {
        // prepare test data
        int i1 = 5;
        int i2 = 9;

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(14, result);
    }
}
```

Der angegebene Name erscheint dann in der Testauswertung.

### Tests ausschalten

Testklassen und -methoden können mit der Annotation @Disabled aus den Testläufen ausgeschlossen werden.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Test disabled until calculator is finished")
public class CalculatorTest {
    private Calculator uut = new Calculator();

    @Test
    public void testAdd() {
        // prepare test data
        int i1 = 5;
        int i2 = 9;

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(14, result);
    }
}
```

### Reihenfolge der Ausführung

Die Reihenfolge von Tests bei der Ausführung kann durch die Verwendung von @TestMethodOrder und @Order bestimmt werden.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {
    private Calculator uut = new Calculator();

    @Test
	@Order(1)
    public void testAdd() {
        // prepare test data
        int i1 = 5;
        int i2 = 9;

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(14, result);
    }

	@Test
	@Order(2)
	public void testAdd() {
        // prepare test data
        int i1 = -1;
        int i2 = 3;

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(2, result);
    }
}
```

Die Annotation @Order wird nur verwendet, wenn der Typ der Ausführung OrderAnnation.class ist.
Weitere Angaben sind "Alphanumeric" (Sortierung nach Methodenname) und "Random" (Zufällige Ausführungsreihenfolge).

### Daten initialisieren / aufräumen

Mit den Annotationen @BeforeEach, @AfterEach, @BeforeAll und @AfterAll können bestimmte Initialisierungen und Aufräumarbeiten vor und nach Unit-Tests ausgeführt werden.

```java
package ch.sbb.talentfactory.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator uut = new Calculator();

	@BeforeAll
	public static void setUpAll() {
		// Diese Methode wird VOR allen Test-Methoden EINMALIG ausgeführt
	}

	@BeforeEach
	public void setUp() {
		// Diese Methode wird VOR jeder Test-Methode ERNEUT ausgeführt
	}

    @Test
    public void testAdd() {
        // prepare test data
        int i1 = 5;
        int i2 = 9;

        // call method
        int result = this.uut.add(i1, i2);

        // verify
        assertEquals(14, result);
    }

	@AfterEach
	public void tearDown() {
		// Diese Methode wird NACH jeder Test-Methode ERNEUT ausgeführt
	}

	@AfterAll
	public static void tearDownAll() {
		// Diese Methode wird NACH allen Test-Methoden einmalig ausgeführt
	}
}
```

### Verwendung von Providern

Bei der Verwendung von parametrisierten Tests ist es möglich, dem Unit-Test über einen Stream von Argumenten entsprechende Testdaten oder Instanzen von verschiedenen Objekten zukommen zu lassen. Das folgende Beispiel illustriert die Verwendung eines solchen Providers.

**Vier Gewinnt Interface**

```java
public interface ConnectFourCheck {
    String checkWin(String[][] board);
}
```

```java
public class VierGewinntTest {

    private String[][] testBoard = {
        {" ", " ", " ", " ", "O"},
        {" ", " ", " ", "O", "X"},
        {" ", " ", " ", "O", "X"},
        {" ", " ", "O", "X", "X"},
        {" ", " ", " ", " ", "X"}
    };

    // Alle Klassen des Streams (VierGewinntSolution1 und VierGewinntSolution2) implementieren das oben gezeigte Interface
    private static Stream<Arguments> instances() {
        return Stream.of(
            Arguments.of(new VierGewinntSolution1()),
            Arguments.of(new VierGewinntSolution2())
        );
    }

    @ParameterizedTest
    @MethodSource("instances")
    public void testBoardWithWinnerX(ConnectFourCheck cfc) {
        try {
            String winner = cfc.checkWin(this.testBoard);
            assertEquals("X", winner);
        } catch (Exception e) {
            fail(e);
        }
    }
}
```

Mit einem solchen Provider kann derselbe Unit-Test für verschiedene Implementation (zum Beispiel eines Interfaces) wiederverwendet werden.

---

## Mockito

Mockito ist ein Framework zum Erstellen und Benutzen von Mocks in Softwaretests.
Es bietet die Möglichkeit, Verhalten von noch nicht implementierten Klassen und Methoden rudimentär zu simulieren,
um so das zu testende System (trotz fehlender Teile) testen zu können.
Mockito ermöglicht auch andere Systeme/Services zu simulieren, welche z.B. von einem anderen Team entwickelt werden
wie auch solche, deren echtes Verhalten zum Testzweck nicht interessiert oder sogar nicht erwünscht ist
(man will aber z.B. wissen, dass diese Systeme/Services vom getesteten Code angesprochen worden sind).

Mockito kann in Unit-Tests wie auch in Integrations-Tests verwendet werden.

### Wo kann ich das Framework herunterladen?

Wie bei JUnit, werden auch für die Arbeit mit Mockito die Bibliotheken davon benötigt.

#### Abhängigkeiten einbinden ohne Maven

Dieser Abschnitt kann übersprungen werden, wenn mit einem Maven-Projekt gearbeitet wird.
Das letzte Release (aktuell 5.3.1) kann hier heruntergeladen werden:
[Mockito Core 5.3.1 Jar-Datei](https://repo1.maven.org/maven2/org/mockito/mockito-core/5.3.1/mockito-core-5.3.1.jar)

Die Heruntergeladene Jar-Datei kann nun genau wie die JUnit-Jar-Dateien eingebunden werden.

#### Abhängigkeiten einbinden mit Maven

Dieser Abschnitt kann übersprungen werden, wenn es sich nicht um ein Maven Projekt handelt.

Die entsprechende Abhängigkeit für das Project Object Model (pom.xml) ist:

```xml
<dependencies>
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>5.3.1</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-junit-jupiter</artifactId>
    <version>5.3.1</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

### Mockito Begriffe

#### Mock

Mocks sind ein vollständiger Ersatz für Objekte, Services usw., von denen der zu testende Code abhängt,
um seine Kernlogik zu testen.
Ein Mock kann so programmiert werden, dass es eine angegebene Ausgabe zurückgibt, wenn eine Methode
des Mocks aufgerufen wird.

Mockito bietet eine Standardimplementierung für alle Methoden eines Mocks. Das bedeutet, dass beim
Aufrufen einer Methode eines Mocks, nicht der "echte" Code der Methode aufgerufen wird, sondern es wird
ein von Mockito vordefinierter Wert zurückgeliefert (abhängig vom Rückgabewert-Typ der Methode).

Es gibt Situationen, in denen es nützlich sein kann, bestimmte Werte aus einer Methode zurückzuliefern
statt die Mockito-Standardwerte. In diesen Situationen kann ein gewünschter Rückgabewert vorkonfiguriert werden,
so dass beim Aufruf der Methode, dieser Wert zurückgeliefert wird.

#### Spy

Ein Spy ('Spion') ist im Wesentlichen ein Wrapper für eine "echte" Instanz eines gemockten Objekts.
Dies bedeutet, dass eine neue Instanz des Objektes erforderlich ist und dann ein Spy darüber hinzugefügt wird.

Standardmässig leiten Spies Methodenaufrufe an die "echten" Methoden des Objekts weiter. Das ist auch der
Hauptunterschied zwischen Spies und Mocks. Letztere überschreiben den "echten" Methoden-Code.

Spies bieten aber auch die Möglichkeit, bestimmte Methoden als Mock-Methoden vorzukonfigurieren. In
solchen Fällen, wird der Methodenaufruf nicht auf den "echten" Code weitergeleitet, sondern es wird,
wie beim Mock, der vorgegebene Rückgabewert zurückgeliefert.

### Mockito Annotationen

Damit die Mockito-Annotationen innerhalb eines JUnit-Tests verwendet werden könnten, müssen sie zuerst eingeschaltet werden.
Eine Möglichkeit dies zu tun ist, die Unit-Test-Klasse mit @ExtendWith zu annotieren und als Parameter den Wert _MockitoExtension.class_ anzugeben:

```java
@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
    //TODO write tests
}
```

Die folgende Tabelle zeigt eine Übersicht über die wichtigsten Annotationen von Mockito:

| Annotation  | Beschreibung                                        |
| ----------- | --------------------------------------------------- |
| @Mock       | Mock-Objekte erzeugen lassen                        |
| @InjectMock | Markiert ein Feld, welches mit Mocks initiiert wird |
| @Spy        | Spy-Objekte erzeugen lassen                         |
| @Captor     | ArgumentCaptor Objekte erzeugen lassen              |

Wie diese Annotationen verwendet werden, wird in den folgenden Kapiteln gezeigt.

#### @Mock Annotation

Diese Annotation wird dazu verwendet, um Mock-Objekte komplett von Mockito erzeugen zu lassen.
Das heisst, die gesamte Mock-Funktionalität wird von Mockito zur Verfügung gestellt.

```java
@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
    @Mock
    private List<String> mockedList; // hier wird eine Liste von Strings gemockt.
                                     // Mockito stellt eine rudimentäre Umsetzung für JEDE Methode der Liste zur Verfügung

    @Test
    public void testMockedListSize() {
        mockedList.add("one");

        assertEquals(0, mockedList.size());
    }
}
```

Was mit einem Mock gemacht werden kann und wie der Mock vorkonfiguriert werden kann, wird in einem späteren Kapitel erklärt.

#### @InjectMocks Annotation

Wenn eine Klasse ein Objekt-Feld beinhaltet, kann Mockito dieses Feld mit einem Mock initiieren.
Damit es funktioniert, muss das Feld entweder via Konstruktor, via Setter oder via Property-Injection initialisiert werden.

Im folgenden Beispiel, hat die Klasse _MyService_ ein Feld vom Typ _DataService_, welches mittels Konstruktor
initialisiert werden kann:

```java
import java.util.List;

public class MyService {
  private final DataService dataService;

  public MyService(DataService dataService) {
    this.dataService = dataService;
  }

  public int processData(List<Integer> numbers) {
    return dataService.sum(numbers);
  }
}
```

```java
import java.util.List;

public interface DataService {
    int sum(List<Integer> numbers);
}
```

Im Test, wird ein Mock für ein DataService erstellt und mit der Annotation @InjectMocks, via
Konstruktor-Initialisierung in dem MyService-Objekt injektiert (der Konstruktor muss also nicht noch dazu aufgerufen werden):

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {
  @Mock
  private DataService dataService; // hier wird ein DataService gemockt.

  @InjectMocks
  private MyService myService;  // der Mock von DataService wird in die MyService-Instanz "injiziiert", das heisst
                                // überall im DataService-Objekt, wo der DataService verwendet wird, wird der Mock zum Zug kommen!


  @Test
  public void testProcessData() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    Mockito.when(dataService.sum(numbers)).thenReturn(15);

    int result = myService.processData(numbers);

    assertEquals(15, result);
  }
}
```

#### @Spy Annotation

Ein Spy wird auf einem "echten" Objekt erzeugt. Dieser Spy leitet, sofern nichts anderes konfiguriert wurde, alle Methodenaufrufe an das echte Objekt weiter.
Mit Hilfe der Mockito-Methoden, kann jedoch definiert werden, dass bestimmte Methoden "umgeleitet" werden und eine andere Umsetzung dafür angewendet wird.

```java

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
  @Spy
  private List<String> spiedList;  // Ein Spy über eine Liste. Wenn nichts anders konfiguriert wird
                                    // werden die "echte" Listen-Methoden aufgerufen, wenn der Spy verwendet wird.

  @Captor
  private ArgumentCaptor<String> stringCaptor; // stringCaptor wird ein Argument vom Typ String "fangen"

  @Test
  public void testMockedList() {
    spiedList.add("one");
    Mockito.verify(spiedList).add(stringCaptor.capture()); // während der Prüfung wird das Argument
    // für die Methode add() gefangen
    // und im stringCaptor aufbewahrt

    assertEquals("one", stringCaptor.getValue()); // mit getValue() kann das gefangene Argument inspiziert werden
  }
}
```

**⚠️ ACHTUNG ⚠️**

> Für Stubbing in @Spy muss immer die Notation `Mockito.doReturn().when().size();` verwendet werden. Mit `Mockito.when().thenReturn()` wird es nicht funktionieren.
> Grund dafür ist, dass wenn `Mockito.doReturn().when().size();` verwendet wird, in jedem Fall das gegebene Return durchgeführt wird.
> Wenn bei `Mockito.when().thenReturn()` zum Beispiel eine Exception auftritt, wird nicht das richtige Resultat zurück gegeben.


Wie ein Spy verwendet werden kann, um nur einige Methoden umzuleiten, wird in einem späteren Kapitel erklärt.

#### @Captor Annotation

Ein ArgumentCaptor kann Argumente einer Methode "fangen" damit diese danach inspiziert werden könnten.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
  @Mock
  private List<String> mockedList;

  @Captor
  private ArgumentCaptor<String> stringCaptor; // stringCaptor wird ein Argument vom Typ String "fangen"

  @Test
  public void testMockedList() {
    mockedList.add("one");
    Mockito.verify(mockedList).add(stringCaptor.capture()); // während der Prüfung wird das Argument
                                                            // für die Methode add() gefangen
                                                            // und im stringCaptor aufbewahrt

    assertEquals("one", stringCaptor.getValue()); // mit getValue() kann das gefangene Argument inspiziert werden
  }
}
```

### Mockito statische Methoden

Mockito stellt mehrere statische Methoden zur Verfügung, welche das Konfigurieren von Mocks und Spies
wie auch deren Überwachung ermöglichen. In diesem Kapitel werden die wichtigsten Methoden
anhand von Beispielen erklärt.

#### Mockito.when kombiniert mit Mockito.thenReturn

Die _Mockito.when_ Methode kombiniert mit der Methode _Mockito.thenReturn_ ermöglicht es, die Standardimplementierung einer Methode für ein gegebenen Mock zu überschreiben.
Dasselbe kann auch mit der Kombination _Mockito.doReturn_ und danach _when_ erreicht werden.

```java
@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
    @Mock
    private List<String> mockedList; // eine Mock-Liste, mit Mockitos-Standardimplementierung für alle Methoden

    @Test
    public void testMockedList() {
        assertEquals(0, mockedList.size()); // die Mockito-Standardimplementierung für "size()"
                                            // liefert immer 0 zurück

        Mockito.when(mockedList.size()).thenReturn(10); // hier wird die Standardimplementierung der Methode
                                                        // size() auf dem Mock-Objekt überschrieben,
                                                        // sodass immer der Wert 10 zurückgeliefert wird.
        assertEquals(10, mockedList.size());

        Mockito.doReturn(20).when(mockedList).size(); // auch hier wird die Standardimplementierung der Methode
                                                      // size() auf dem Mock-Objekt überschrieben,
                                                      // diesmal mit dem Wert 20.
        assertEquals(20, mockedList.size());
    }
}
```

#### Mockito.verify

Die _Mockito.verify_ Methode prüft, ob eine Interaktion mit dem Mock/Spy-Objekt stattgefunden hat.
Geprüft werden kann unter anderem folgendes (weitere Prüfungen werden [hier](https://www.baeldung.com/mockito-verify) anhand von Beispielen erklärt):

- Es gab keine Interaktion mit dem Mock/Spy
- Es gab eine Interaktion mit dem Mock/Spy
- Es gab eine gewisse Anzahl an Interaktionen mit dem Mock/Spy
- Es gab mindestens eine gewisse Anzahl an Interaktionen mit dem Mock/Spy
- Es gab nicht mehr als eine gewisse Anzahl an Interaktionen mit dem Mock/Spy

Interaktion in diesem Sinn kann entweder eine Interaktion mit dem Objekt oder mit einer seiner Methoden sein.

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MyUnitTest {
  @Mock
  private List<String> mockedList; // eine Mock-Liste, mit Mockitos-Standardimplementierung für alle Methoden

  @Spy
  private List<String> spiedList; // ein Spy über eine Liste.

  @Test
  public void testSpiedList() {
    spiedList.add("one"); // hier wird die "echte" add Methode einer Liste aufgerufen!

    verify(spiedList).add("one"); // prüfe, ob die "add" Methode mit dem Parameter "one" auf dem spyList aufgerufen wurde
    verify(spiedList, never()).size(); // prüfe, ob die size() Methode nie aufgerufen wurde

    spiedList.clear();
    spiedList.clear();
    verify(spiedList, times(2)).clear(); // prüfe, ob die clear() Methode genau 2 Mal aufgerufen wurde
  }

  @Test
  public void testMockedList() {
    Mockito.verifyNoInteractions(mockedList); // bis hier gab es keine Interaktionen mit dem mockedList Objekt

    mockedList.size();
    mockedList.size();
    mockedList.size();
    mockedList.size();

    verify(mockedList, atLeast(1)).size(); // prüfe, ob die size() Methode mindestens einmal aufgerufen wurde
    verify(mockedList, atMost(5)).size(); // prüfe, ob die size() Methode nicht mehr als 5 Mal aufgerufen wurde
  }
}
```

---

## Test Driven Development (TDD)

Test Driven Development (TDD) (Testgetriebene Entwicklung) ist ein Softwareentwicklungsansatz,
bei dem ein Test geschrieben wird, bevor der Code geschrieben wird.
Sobald der neue Code den Test besteht, wird er auf einen akzeptablen Standard umgestellt.

TDD stellt sicher, dass der Quellcode gründlich getestet wird und zu modularisiertem, flexiblem und
erweiterbarem Code führt. Es konzentriert sich darauf, nur den Code zu schreiben, der notwendig ist,
um Tests zu bestehen, wodurch das Design einfach und klar wird.<br>
Mit TDD kann der Programmierer beim Schreiben von Software kleine Schritte unternehmen.

Der Test wird vor dem Testen der Funktionalität geschrieben und stellt sicher, dass die Anwendung
für die Testbarkeit geeignet ist, erst danach wird die Funktionalität implementiert. Dies wird als „Rot-Grün-Refaktor“ bezeichnet,
wobei Rot bedeutet, fehlgeschlagen zu sein, und Grün zeigt einen erfolgreichen Durchlauf an.
Diese Schritte werden dann wiederholt.

### Schritte eines test gesteuerten Entwicklungszyklus

Der test-gesteuerte Entwicklungszyklus besteht aus folgenden, sich immer wiederholenden, Schritten:

![TDD Entwicklungszyklus](../java-testing/tdd.png)

- **Hinzufügen eines Tests, der fehlschlägt**: Jedes neue Feature in TDD beginnt mit einem Test, der nach seiner Implementation fehlschlagen muss, bevor die Features implementiert werden.
- **Code schreiben und damit den Test "begrünen"**: Es wird nur soviel Code geschrieben, wie zum "Begrünen" des Tests nötig ist - nicht mehr! (alle bisherigen Tests müssen weiterhin erfolgreich durchlaufen!!)
- **Code verbessern, ohne dabei die Funktionalität zu verändern (Refactor)**: Code bereinigen (z.B. das Entfernen von Duplikaten, kleinere Methoden usw.) und auf "Clean Code" Standard bringen

### TDD Walkthrough

In diesem Walkthrough wird der TDD Entwicklungszyklus anhand eines Beispiels erläutert.

In diesem Beispiel geht es darum eine Klasse zu schreiben, welche ein Tier modelliert.
Das Tier soll uns informieren, ob es Hunger hat oder nicht.

**_Hinweis_** im Beispielcode, wird folgendes Namensschema für Tests verwendet:

```java
public void given_when_then() {
        ...
}
```

Wobei:

- **given** die Ausgangslage definiert (z.B. _newAnimal_ oder _animalAte_)
- **when** ist der Name der Methode, welche getestet wird (z.B. _isHungry_)
- **then** ist das Ergebnis, welche erwartet wird (z.B. _returnTrue_ oder _returnFalse_)

#### Schritt 1: Grundgerüst erstellen

Es wird nur die Klasse erstellt, welche dann getestet werden soll:

```java
public class Animal {
}
```

#### Schritt 2: Fehlschlagender Test schreiben

```java
public class AnimalTest {
    @Test
    public void newAnimal_isHungry_returnTrue() {
        Animal myAnimal = new Animal();
        assertTrue(myAnimal.isHungry());
    }
}
```

Zu diesem Zeitpunkt existiert die Methode "isHungry" nicht (Kompilierfehler) und natürlich gibt sie kein "true" zurück.
Im nächsten Schritt wird die Methode hinzugefügt und der Test "begrünt".

#### Schritt 3: Test "begrünen"

```java
public class Animal {
    public boolean isHungry() {
        return true;
    }
}
```

Der Test, welcher vorher geschrieben wurde, kompiliert nun und kann erfolgreich durchlaufen werden.
Somit ist dieser Zyklus beendet (es gibt noch nichts, was refactored werden soll)

#### Schritt 4: Neuer, fehlschlagender Test schreiben

```java
public class AnimalTest {
    @Test // Dieser Test ist nun grün...
    public void newAnimal_isHungry_returnTrue() {
        Animal myAnimal = new Animal();
        assertTrue(myAnimal.isHungry());
    }

    @Test
    public void animalAte_isHungry_returnFalse() {
      Animal myAnimal = new Animal();
      animal.eat(); // Kompilierfehler, da es diese Methode noch nicht gibt
      assertFalse(myAnimal.isHungry());
    }
}
```

#### Schritt 5: zweiter Test "begrünen", ohne den ersten Test "kaputt" zu machen

In diesem Schritt finden wir heraus, dass wir einen Hunger-Zustand für unser Tier haben müssen,
welcher sich ändert, wenn das Tier gefressen hat:

```java
public class Animal {
    private boolean isHungry = true; // müssen wir hier so setzen, damit der erste Test noch funktioniert!

    public boolean isHungry() {
      if (isHungry) {
          return true;
      } else {
          return false;
      }
    }

    public void eat() {
        isHungry = false;
    }
}
```

Nach diesem Schritt kompiliert der Test wieder erfolgreich und beide Tests werden erfolgreich durchlaufen.

#### Schritt 6: Refactor

Unser Code kann nun eleganter geschrieben werden, ohne dabei die Funktionalität zu ändern:

```java
public class Animal {
    private boolean isHungry = true;

    public boolean isHungry() {
        return isHungry; // if-else ersetzt, da nicht nötig
    }

    public void eat() {
        isHungry = false;
    }
}
```

Somit ist auch dieser Zyklus beendet.

Der code wird so stetig weiterentwickelt und neue Funktionalitäten werden auf diese Weise Schritt für Schritt und getestet hinzugefügt.
Dabei werden die bereits bestehenden Funktionalitäten durch die bisherigen Tests vor ungewollten Änderungen geschützt.

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgaben](../../../../labs/java/java-testing) in den Labs.
