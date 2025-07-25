---
title: "Java Exercises - Einfache Berechnungen"
linkTitle: "Einfache Berechnungen"
type: docs
weight: 5
description: >
  Mit diesen Übungen kannst du dein Wissen über einfache Berechnungen vertiefen.
---

<!--suppress CheckEmptyScriptTag -->

#### Voraussetzung

- Du weisst, wie man in Java mit Zahlen rechnet.

## Vorbereitungsarbeiten

{{< toggle title=`Drücke auf den Pfeil links um eine detaillierte Anleitung zu erhalten, wie Du den Quellcode auf deinem
Rechner ablegen sollst.

{{< ninja tip >}}
Liess vor allem am Anfang die detaillierte Anleitung gut durch und befolge die Schritte
exakt. Sie helfen dir, deinen Quellcode gut organisiert, strukturiert und sicher zu verwalten.
{{< /ninja>}}

Falls du die Anleitung schon auswendig kennst, findest du den Quellcode zur Übung direkt hier:
[Download](./it-ninja_02_java_03_java-grundlagen_05_logic.zip) | [Online anschauen](./source/)` >}}

{{< ninja info >}}
**Neu bei it-ninja?**  
Die Anleitung enthält einige Befehle und Fachbegriffe, die dir möglicherweise noch nichts sagen. Mach dir deswegen
keine Sorgen – in den kommenden Modulen erklären wir dir alles Schritt für Schritt. Schon bald wirst auch du ein
it-ninja sein.
{{< /ninja >}}

Um die folgenden Aufgaben erfolgreich umzusetzen, führe diese Schritte aus:

1. Beim ersten Mal:

   1. IntelliJ IDEA installieren → [IntelliJ IDEA einrichten](/docs/02_java/02_intellij-einrichten/)
   2. Git-Repository einrichten → [Persönliches Git-Repository](/docs/01_tools/02_personal-bitbucket/)

2. Öffne eine CMD-Shell und wechsle ins Verzeichnis deines Git-Repositories:  
   {{< code >}}
   // Windows
   cd /d "[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]"
   git status
   // Linux
   cd "[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]"
   git status
   {{< /code >}}

3. Stelle sicher, dass alle Dateien im Git-Repository committed sind. Mit **git status** erhältst du eine Übersicht:

   {{< code >}}
   git status
   {{< /code >}}

4. Erstelle einen neuen Branch für die Übung:

   {{< code >}}
   git checkout -b "templates/it-ninja_02_java_03_java-grundlagen_05_logic"
   {{< /code >}}

{{< ninja info >}}
Du kannst auch einen kürzeren Namen für den Branch wählen. Wir verwenden **templates** am Anfang des Branch-Namens
für Branches, welche den ursprünglichen Übungscode enthalten.
{{< /ninja >}}

5. Lade den Source-Code zu den Übungen herunter und entpacke ihn im Root-Verzeichnis deines lokalen Repositories:  
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]`

   > Den Source-Code findest du hier: [Download](./it-ninja_02_java_03_java-grundlagen_05_logic.zip) | [Online anschauen](./source/)

6. Committe den originalen Source-Code, damit er sicher im Repository gespeichert ist:

   {{< code >}}
   git add .
   git commit -m "Initial version from it-ninja"
   {{< /code >}}

7. Erstelle einen neuen Branch, um deine Lösung zu implementieren:

   {{< code >}}
   git checkout -b "labs/it-ninja_02_java_03_java-grundlagen_05_logic"
   {{< /code >}}

{{< ninja info >}}
Auch hier kannst du einen kürzeren Namen wählen. Verwende **labs** am Anfang des Branch-Namens für Branches, die
deinen eigenen Code enthalten.
{{< /ninja >}}

{{< ninja tip >}}
**Pro-Tipp:**  
Du kannst jederzeit einen weiteren Branch erstellen – z. B. wenn du etwas ausprobieren möchtest. Alternativ kannst
du auch in der Git-History einen alten Stand wiederherstellen, was aber weniger flexibel ist.
{{< /ninja >}}

8. Starte IntelliJ und öffne mit `File → Open` das Verzeichnis mit dem Source-Code. Wenn du alles korrekt gemacht
   hast, findest du das Projekt hier:  
   {{< code >}}
   // windows
   `[[itninja_localrepo|C:\Users\u123456\repos.local\it-ninjas-lab]]\02_java\03_java-grundlagen\05_logic`
   // linux
   `[[itninja_localrepo|/home/u123456/repos.local/it-ninjas-lab]]\02_java/03_java-grundlagen/05_logic`
   {{< /code >}}

9. Falls du zum ersten Mal mit IntelliJ arbeitest, findest du [hier](/docs/99_tools/ide/intellij/03_run-and-debug)
   eine Anleitung, wie man ein Programm startet.

Nun bist du bereit, die untenstehenden Aufgaben zu lösen.

{{< ninja tip >}}
Die meisten Übungen sind professionell strukturiert – so wie in echten Softwareprojekten. Zu gutem Code gehören auch
Tests, die sicherstellen, dass dein Code wie erwartet funktioniert. Sofern nicht anders erwähnt, kannst du mit
folgendem Befehl im Root-Verzeichnis des Projekts (dort, wo sich auch die `pom.xml` befindet) überprüfen, ob du die
Aufgabe korrekt gelöst hast:

```bash
mvn test
```

Viel Erfolg!
{{< /ninja >}}

{{< /toggle >}}

## Aufgabe 1 - geometrische Berechnungen

Passe die folgenden Methoden an. Berechne Flächen, Umfang und Volumen und gib das Resultat auf der Konsole aus:

- `Das Rechteck mit a=[value1]cm und b=[value2]cm hat eine Fläche von [result]cm2.`
- `Das Dreieck mit g=[value1]cm und h=[value2]cm hat eine Fläche von [result]cm2.`
- `Der Kreis mit dem Radius [value]cm hat eine Fläche von [result]cm2.`
- `Das Rechteck mit a=[value1]cm und b=[value2]cm hat einen Umfang von [result]cm.`

Wobei in der Ausgabe die Platzhalter mit den eckigen Klammern durch die entsprechenden Zahlen ersetzt werden sollen.
Ganzzahlen sollen ohne '.' und Nachkommastellen angezeigt werden, Dezimalzahlen mit 2 Stellen hinter dem Punkt.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\CalculateForms.java](./source/#src-main-java-ch-itninja-labs-basicexercises-calculateforms-java):

```java
    public static void printRectArea(int sideA, int sideB) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }

    public static void printTriangleArea(int sideC, int heightC) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }

    public static void printCircleArea(int radius) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }

    public static void printRectPerimeter(int sideA, int sideB) {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

### Rechteck Flächenberechnung

**Beispiel 1:**

Eingabe:

```console
CompareNumbers.compareNumbers(4, 5);
```

Ausgabe:

```console
Das Rechteck mit a=4cm und b=5cm hat eine Fläche von 20cm2.
```

**Beispiel 2:**

Eingabe:

```console
CompareNumbers.compareNumbers(3, 7);
```

Ausgabe:

```console
Das Rechteck mit a=3cm und b=7cm hat eine Fläche von 21cm2.
```

**Beispiel 3:**

Eingabe:

```console
CompareNumbers.compareNumbers(6, 4);
```

Ausgabe:

```console
Das Rechteck mit a=6cm und b=4cm hat eine Fläche von 24cm2.
```

**Beispiel 4:**

Eingabe:

```console
CompareNumbers.compareNumbers(0, 0);
```

Ausgabe:

```console
Das Rechteck mit a=0cm und b=0cm hat eine Fläche von 0cm2.
```

### Dreieck Flächenberechnung

**Beispiel 1:**

Eingabe:

```console
CompareNumbers.compareNumbers(4, 5);
```

Ausgabe:

```console
Das Rechteck mit a=4cm und b=5cm hat eine Fläche von 20cm2.
```

**Beispiel 2:**

Eingabe:

```console
CompareNumbers.compareNumbers(3, 7);
```

Ausgabe:

```console
Das Rechteck mit a=3cm und b=7cm hat eine Fläche von 21cm2.
```

**Beispiel 3:**

Eingabe:

```console
CompareNumbers.compareNumbers(6, 4);
```

Ausgabe:

```console
Das Rechteck mit a=6cm und b=4cm hat eine Fläche von 24cm2.
```

**Beispiel 4:**

Eingabe:

```console
CompareNumbers.compareNumbers(0, 0);
```

Ausgabe:

```console
Das Rechteck mit a=0cm und b=0cm hat eine Fläche von 0cm2.
```

## Aufgabe 2 - Checkout

Passe die folgenden Methoden an. Nutze in einer Methode nur `double`, in der anderen `BigDecimal`. Erstelle für die untenstehende Einkaufsliste für jeden Artikel eine Variable und weise
der Variable den entsprechenden Wert zu:

- Apfel: CHF 0.50
- Brot: CHF 1.10
- Milch: CHF 2.30
- Ei: CHF 0.60
- Butter: CHF 1.80

Erstelle ebenfalls eine Variable `totalExpected` mit dem zu erwartenden Total und berechne es (im Kopf oder Taschenrechner).

Zähle die Preise der Produkte mittels Java-Code zusammen und speichere sie in der Variable `total`. Der darauf folgende
Code wird dann die beiden Werte vergleichen und eine entsprechende Ausgabe machen (was der Code macht wirst du im
nächsten Modul kennenlernen).

> Denke beim Erstellen der Variablen daran, dass bei it-ninja der Code immer in englisch sein sollte, nur die Ausgabe
> auf den Bildschirm soll auf deutsch sein.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\Basket.java](./source/#src-main-java-ch-itninja-labs-basicexercises-basket-java):

```java
    public static void printTotalBigDecimal(){

        // IT-Ninja: Füge hier Deinen Code ein:
        String expectedResult;
        if(total.compareTo(totalExpected) == 0){
            expectedResult = "wie erwartet";
        }
        else if(total.compareTo(totalExpected) > 0){
            expectedResult = "zu hoch";
        }
        else {
            expectedResult = "zu tief";
        }
        System.out.println("Alle Artikel zusammen kosten CHF " + total + ". Der Preis ist " + expectedResult + ".");
    }

    public static void printTotalDouble(){

        // IT-Ninja: Füge hier Deinen Code ein:
        String expectedResult;
        if(total == totalExpected){
            expectedResult = "wie erwartet";
        }
        else if(total > totalExpected){
            expectedResult = "zu hoch";
        }
        else {
            expectedResult = "zu tief";
        }
        System.out.printf("Alle Artikel zusammen kosten CHF %.2f. Der Preis ist %s.%n", total, expectedResult);

    }
```

Wenn du beide Methoden angepasst hat, vergleiche die Ausgabe. Du solltest folgende Ausgabe erhalten:

**Beispielausgabe:**

```console
Alle Artikel zusammen kosten CHF 5.70. Der Preis ist wie erwartet.
```

## Aufgabe 3 - Alter in Monaten

Passe die folgende Methode an. Berechne dein Alter in ganzen Monaten. Zähle den Monat wo du geboren wurdest und den
aktuellen als ganzen Monat dazu. Gib Dein Alter auf der Konsole aus:

- `Ich bin am dd.mm.yyyy geboren und heute am dd.mm.yyyy z Monate alt.`

Wobei in der Ausgabe `dd.mm.yyyy` durch das tatsächliche Datum von Deinem Geburtstag resp. dem heutigen Datum ersetzt
werden soll und `z` durch die Anzahl Monate.

> Im Quellcode findest du auch statische Variablen (`dayOfBirth`, `monthOfBirth`, `yearOfBirth`, `dayOfToday`,
> `monthOfToday`, `yearOfToday`). Passe diese Variablen an und nutze sie in in deinem Code. Es wird erwartet, dass sich
> eine Änderung einer dieser Variablen auf die Berechnung aber auch auf die Ausgabe in der Konsole auswirkt. Was es
> genau mit `static` auf sich hat lernst du bald.

Im zur Übung gehörendem Source kannst Du die Änderung an folgender Stelle machen:  
[src\main\java\ch\itninja\labs\basicexercises\AgeCalculator.java](./source/#src-main-java-ch-itninja-labs-basicexercises-agecalculator-java):

```java
    public static void ageInMonths() {

        // IT-Ninja: Füge hier Deinen Code ein:
    }
```

**Beispiel 1:**

Eingabe:

```console
AgeCalculator.dayOfBirth = 1;
AgeCalculator.monthOfBirth = 9;
AgeCalculator.yearOfBirth = 1973;
AgeCalculator.dayOfToday = 22;
AgeCalculator.monthOfToday = 7;
AgeCalculator.yearOfToday = 2025;

AgeCalculator.ageInMonths();
```

Ausgabe:

```console
Ich bin am 01.09.1973 geboren und heute am 22.07.2025 623 Monate alt.
```

**Beispiel 2:**

Eingabe:

```console
AgeCalculator.dayOfBirth = 15;
AgeCalculator.monthOfBirth = 4;
AgeCalculator.yearOfBirth = 2008;
AgeCalculator.dayOfToday = 8;
AgeCalculator.monthOfToday = 8;
AgeCalculator.yearOfToday = 2025;

AgeCalculator.ageInMonths();
```

Ausgabe:

```console
Ich bin am 15.04.2008 geboren und heute am 08.08.2025 209 Monate alt.
```

---

{{<dokumentation "../../../../docs/02_java/03_java-grundlagen/05_logic/#back-from-lab" "Mathematik & Logik">}}
