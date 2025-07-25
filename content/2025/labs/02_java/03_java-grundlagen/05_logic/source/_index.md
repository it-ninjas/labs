---
title: "logic - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for logic
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
logic
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── AgeCalculator.java
│   │                   │   ├── Basket.java
│   │                   │   └── CalculateForms.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── AgeCalculatorTest.java
│                       │   ├── BasketTest.java
│                       │   └── CalculateFormsTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in logic

##### pom.xml{#pom-xml}

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.itninja</groupId>
  <artifactId>itninja-labs-01-basicexercises</artifactId>
  <version>1.0.0</version>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>

  <dependencies>
    <!-- JUnit 5 -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <release>17</release>
          <encoding>UTF-8</encoding>
        </configuration>
      </plugin>
      <!-- Testing -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.2.5</version>
      </plugin>
    </plugins>
  </build>
</project>

```

##### README.md{#readme-md}

Not able to display content!

### src\main\java\ch\itninja\labs

##### Main.java{#src-main-java-ch-itninja-labs-main-java}

```java
package ch.itninja.labs;

import ch.itninja.labs.basicexercises.AgeCalculator;
import ch.itninja.labs.basicexercises.Basket;
import ch.itninja.labs.basicexercises.CalculateForms;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        // call methodes with some test parameters
        CalculateForms.printRectArea(5, 4);
        CalculateForms.printTriangleArea(8, 3);
        CalculateForms.printCircleArea(4);
        CalculateForms.printRectPerimeter(5, 4);

        Basket.printTotalBigDecimal();
        Basket.printTotalDouble();

        AgeCalculator.ageInMonths();
    }
}
```

#### basicexercises

##### AgeCalculator.java{#src-main-java-ch-itninja-labs-basicexercises-agecalculator-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for leap year calculation.
 */
public class AgeCalculator {

    public static int dayOfBirth = 11;
    public static int monthOfBirth = 5;
    public static int yearOfBirth = 1973;

    public static int dayOfToday = 22;
    public static int monthOfToday = 7;
    public static int yearOfToday = 2025;

    private AgeCalculator() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Berechne dein Alter in ganzen Monaten. Zähle den Monat wo du geboren wurdest und den
     * aktuellen als ganzen Monat dazu. Gib Dein Alter auf der Konsole aus:
     *
     * - Ich bin am dd.mm.yyyy geboren und heute am dd.mm.yyyy z Monate alt.
     *
     * Wobei in der Ausgabe dd.mm.yyyy durch das tatsächliche Datum von Deinem Geburtstag resp. dem heutigen Datum ersetzt
     * werden soll und z durch die Anzahl Monate.
     *
     * Im Quellcode findest du auch statische Variablen (dayOfBirth, monthOfBirth, yearOfBirth, dayOfToday,
     * monthOfToday, yearOfToday). Passe diese Variablen an und nutze sie in in deinem Code. Es wird erwartet, dass sich
     * eine Änderung einer dieser Variablen auf die Berechnung aber auch auf die Ausgabe in der Konsole auswirkt. Was es
     * genau mit static auf sich hat lernst du bald.
     */
    public static void ageInMonths() {

        // IT-Ninja: Füge hier Deinen Code ein...
    }
}

```

##### Basket.java{#src-main-java-ch-itninja-labs-basicexercises-basket-java}

```java
package ch.itninja.labs.basicexercises;


import java.math.BigDecimal;

/**
 * Utility class providing methods for basket calculation.
 */
public class Basket {

    private Basket() {
        // Prevent instantiation
    }

    public static void printTotalBigDecimal(){

        // IT-Ninja: Füge hier Deinen Code ein...
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

        // IT-Ninja: Füge hier Deinen Code ein...
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

}

```

##### CalculateForms.java{#src-main-java-ch-itninja-labs-basicexercises-calculateforms-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for comparing numbers.
 */
public class CalculateForms {

    private CalculateForms() {
        // Prevent instantiation
    }

    /**
     * Passe die folgenden Methoden an. Berechne Flächen, Umfang und Volumen und gib das Resultat auf der Konsole aus:
     *
     * - Das Rechteck mit a=[value1]cm und b=[value2]cm hat eine Fläche von [result]cm2.
     * - Das Dreieck mit g=[value1]cm und h=[value2]cm hat eine Fläche von [result]cm2.
     * - Der Kreis mit dem Radius [value]cm hat eine Fläche von [result]cm2.
     * - Das Rechteck mit a=[value1]cm und b=[value2]cm hat einen Umfang von [result]cm.
     *
     * Wobei in der Ausgabe die Platzhalter mit den eckigen Klammern durch die entsprechenden Zahlen ersetzt werden sollen.
     * Ganzzahlen sollen ohne '.' und Nachkommastellen angezeigt werden, Dezimalzahlen mit 2 Stellen hinter dem Punkt.
     */
    public static void printRectArea(int sideA, int sideB) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

    public static void printTriangleArea(int sideC, int heightC) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

    public static void printCircleArea(int radius) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

    public static void printRectPerimeter(int sideA, int sideB) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

}




```

### src\test\java\ch\itninja\labs\basicexercises

##### AgeCalculatorTest.java{#src-test-java-ch-itninja-labs-basicexercises-agecalculatortest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeCalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 9, 1973, 22, 7, 2025, 623",
            "2, 15, 4, 2008, 8, 8, 2025, 209",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int dayOfBirth, int monthOfBirth, int yearOfBirth,
                                                      int dayOfToday, int monthOfToday, int yearOfToday,
                                                      int monthsExpected) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        AgeCalculator.dayOfBirth = dayOfBirth;
        AgeCalculator.monthOfBirth = monthOfBirth;
        AgeCalculator.yearOfBirth = yearOfBirth;
        AgeCalculator.dayOfToday = dayOfToday;
        AgeCalculator.monthOfToday = monthOfToday;
        AgeCalculator.yearOfToday = yearOfToday;

        String expectedResult = String.format("Ich bin am %02d.%02d.%04d geboren und heute am %02d.%02d.%04d %d Monate alt.",
                dayOfBirth, monthOfBirth, yearOfBirth,
                dayOfToday, monthOfToday, yearOfToday,
                monthsExpected);

        try {
            // WHEN
            AgeCalculator.ageInMonths();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "Output is not as expected");

        // For documentation
        String input = String.format(
                "AgeCalculator.dayOfBirth = %d;\n" +
                "AgeCalculator.monthOfBirth = %d;\n" +
                "AgeCalculator.yearOfBirth = %d;\n" +
                "AgeCalculator.dayOfToday = %d;\n" +
                "AgeCalculator.monthOfToday = %d;\n" +
                "AgeCalculator.yearOfToday = %d;\n" +
                "\n" +
                "AgeCalculator.ageInMonths();",
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            dayOfToday,
            monthOfToday,
            yearOfToday
        );
        ItNinjaOutput.PrintItNinjaOutput("AgeInMonths"+lab, input, output);
    }


}

```

##### BasketTest.java{#src-test-java-ch-itninja-labs-basicexercises-baskettest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasketTest {

    @Test
    void givenPrintTotalBigDecimal_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            Basket.printTotalBigDecimal();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        final String expectedResult = "Alle Artikel zusammen kosten CHF 5.70. Der Preis ist wie erwartet.";
        assertEquals(expectedResult, output, "Output not as expected");

        ItNinjaOutput.PrintItNinjaOutput("Basket.BigDecimal", "", output);
    }

    @Test
    void givenPrintTotalDouble_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            Basket.printTotalDouble();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        final String expectedResult = "Alle Artikel zusammen kosten CHF 5.70. Der Preis ist zu hoch.";
        assertEquals(expectedResult, output, "Output not as expected");

        ItNinjaOutput.PrintItNinjaOutput("Basket.Double", "", output);
    }

}

```

##### CalculateFormsTest.java{#src-test-java-ch-itninja-labs-basicexercises-calculateformstest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleAreaTest {

    @ParameterizedTest
    @CsvSource({
            "1, 4, 5, 'Das Rechteck mit a=4cm und b=5cm hat eine Fläche von 20cm2.'",
            "2, 3, 7, 'Das Rechteck mit a=3cm und b=7cm hat eine Fläche von 21cm2.'",
            "3, 6, 4, 'Das Rechteck mit a=6cm und b=4cm hat eine Fläche von 24cm2.'",
            "4, 0, 0, 'Das Rechteck mit a=0cm und b=0cm hat eine Fläche von 0cm2.'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CalculateForms.printRectArea(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CalculateForms.RectArea"+lab, "CompareNumbers.compareNumbers("+value1+", "+value2+");", output);
    }
}

```

### src\test\java\ch\itninja\labs\util

##### ItNinjaOutput.java{#src-test-java-ch-itninja-labs-util-itninjaoutput-java}

```java
package ch.itninja.labs.util;

public class ItNinjaOutput {
    public static void PrintItNinjaOutput(String lab, String input, String output) {
        System.out.println("<itninja input lab=\""+lab+"\">");
        System.out.println(input);
        System.out.println("</itninja>");
        System.out.println("<itninja output lab=\""+lab+"\">");
        System.out.println(output);
        System.out.println("</itninja>");
    }
}

```
