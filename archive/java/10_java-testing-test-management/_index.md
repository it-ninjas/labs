---
title: "Testing"
linkTitle: "Testing"
weight: 9
description: >
  Modul #J4
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

![ISTQB-Prozess](./images/testprozess_ISTQB.png)

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

| #   | Beschreibung                                                                                                                                              | Screenshot                                            |
| --- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- |
| 1   | Ordner für Bibliotheken im Projekt anlegen. Im Projekt (Root) einfach einen neuen Ordner "lib" erzeugen.                                                  | ![lib-Verzeichnis erstellen](./images/1518642046.png) |
| 2   | Die oben genannten JAR-Bibliotheken in den neuen Ordner kopieren                                                                                          | ![JARs kopieren](./images/1616908690.png)             |
| 3   | Projekteinstellungen öffnen. Das Projekt mit einem Klick markieren und Taste F4 drücken. Die Projekteinstellungen werden geöffnet                         |                                                       |
| 4   | Auf der linken Seite den Tab "Libraries" auswählen                                                                                                        | ![Lib-Tab auswählen](./images/1518642115.png)         |
| 5   | Oben auf das Plus-Icon klicken und Java auswählen                                                                                                         | ![Bibliothek hinzufügen](./images/1518642153.png)     |
| 6   | Die vorhin kopierten Bibliotheken auswählen und alle Dialoge mit OK bestätigen                                                                            | ![Bibliotheken auswählen](./images/1616908730.png)    |
| 7   | Die Bibliothek muss anschliessend dem Modul hinzugefügt werden. Der Scope sollte auf Test gestellt werden, da es sich um reine Test-Bibliotheken handelt. | ![Ins Modul aufnehmen](./images/1616908738.png)       |

#### Abhängigkeiten einbinden mit Maven

Dieser Abschnitt kann übersprungen werden, wenn es sich nicht um ein Maven Projekt handelt.

Seit JUnit 5.4 reicht die folgende Abhängigket für das Project Object Model (pom.xml):

```xml
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.9.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

Füge diese Abhängigkeit in dein pom.xml ein. Danach besitzt du alle Bibliotheken, die zur Implementation von Unit-Tests notwendig sind.

---

## Test Driven Development (TDD)

Test Driven Development (TDD) (Testgetriebene Entwicklung) ist ein Softwareentwicklungsansatz,
bei dem ein Test geschrieben wird, bevor der Code geschrieben wird.
Sobald der neue Code den Test besteht, wird er auf einen akzeptablen Standard umgestellt.

TDD stellt sicher, dass der Quellcode gründlich getestet wird und zu modularisiertem, flexiblem und
erweiterbarem Code führt. Es konzentriert sich darauf, nur den Code zu schreiben, der notwendig ist,
um Tests zu bestehen, wodurch das Design einfach und klar wird.  
Mit TDD kann der Programmierer beim Schreiben von Software kleine Schritte unternehmen.

Der Test wird vor dem Testen der Funktionalität geschrieben und stellt sicher, dass die Anwendung
für die Testbarkeit geeignet ist, erst danach wird die Funktionalität implementiert. Dies wird als „Rot-Grün-Refaktor“ bezeichnet,
wobei Rot bedeutet, fehlgeschlagen zu sein, und Grün zeigt einen erfolgreichen Durchlauf an.
Diese Schritte werden dann wiederholt.

### Schritte eines test gesteuerten Entwicklungszyklus

Der test-gesteuerte Entwicklungszyklus besteht aus folgenden, sich immer wiederholenden, Schritten:

![TDD Entwicklungszyklus](./images/tdd.png)

- **Hinzufügen eines Tests, der fehlschlägt**: Jedes neue Feature in TDD beginnt mit einem Test, der nach seiner Implementation fehlschlagen muss, bevor die Features implementiert werden.
- **Code schreiben und damit den Test "begrünen"**: Es wird nur soviel Code geschrieben, wie zum "Begrünen" des Tests nötig ist - nicht mehr! (alle bisherigen Tests müssen weiterhin erfolgreich durchlaufen!!)
- **Code verbessern, ohne dabei die Funktionalität zu verändern (Refactor)**: Code bereinigen (z.B. das Entfernen von Duplikaten, kleinere Methoden usw.) und auf "Clean Code" Standard bringen

### TDD Walkthrough

In diesem Walkthrough wird der TDD Entwicklungszyklus anhand eines Beispiels erläutert.

In diesem Beispiel geht es darum eine Klasse zu schreiben, welche ein Tier modelliert.
Das Tier soll uns informieren, ob es Hunger hat oder nicht.

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
