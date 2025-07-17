---
title: "control-structures - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for control-structures
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
control-structures
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── CompareNumbers.java
│   │                   │   ├── HelloName.java
│   │                   │   └── LeapYear.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── CompareNumbersTest.java
│                       │   ├── HelloNameTest.java
│                       │   └── LeapYearTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in control-structures

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

import ch.itninja.labs.basicexercises.CompareNumbers;
import ch.itninja.labs.basicexercises.HelloName;
import ch.itninja.labs.basicexercises.LeapYear;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        HelloName.printHelloName();
        CompareNumbers.compareNumbers(4, 7);
        LeapYear.isLeapYear(1973);
    }
}
```

#### basicexercises

##### CompareNumbers.java{#src-main-java-ch-itninja-labs-basicexercises-comparenumbers-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for comparing numbers.
 */
public class CompareNumbers {

    private CompareNumbers() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Vergleiche die beiden Zahlen 'zahl1' und 'zahl2' und gib das Resultat des Vergleichs auf
     * auf der Konsole aus:
     *
     * - Zahl1(value1) ist kleiner als Zahl2(value2)
     * - Zahl1(value1) ist grösser als Zahl2(value2)
     * - Zahl1(value1) ist gleich gross wie Zahl2(value2)
     *
     * Wobei in der Ausgabe value1 und value2 durch die tatsächlichen Werte ersetzt werden sollen.
     */
    public static void compareNumbers(int number1, int number2) {

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}




```

##### HelloName.java{#src-main-java-ch-itninja-labs-basicexercises-helloname-java}

```java
package ch.itninja.labs.basicexercises;


/**
 * Utility class providing methods for basic Hello Name output.
 */
public class HelloName {

    private HelloName() {
        // Prevent instantiation
    }

    /**
     * Erstelle eine Variable, welche deinen Namen beinhaltet.
     * Gib Hello [name] auf der Konsole aus.
     */
    public static void printHelloName(){

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

##### LeapYear.java{#src-main-java-ch-itninja-labs-basicexercises-leapyear-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for leap year calculation.
 */
public class LeapYear {

    // IT-Ninja: Füge hier Deinen Code ein...

    private LeapYear() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Stell fest, ob das übergebene Jahr ein Schaltjahr ist (Gregorianischer Kalender). Gib auf
     * der Konsole das Resultat aus:
     *
     * - Das Jahr year ist ein Schaltjahr gemäss gregorianischem Kalender
     * - Das Jahr year ist kein Schaltjahr gemäss gregorianischem Kalender
     *
     * Wobei in der Ausgabe year durch das tatsächliche Jahr ersetzt werden soll.
     * Falls das Jahr ein Schaltjahr ist, soll die Methode true zurückgeben, andernfalls false.
     *
     * Verwende keine logischen Ausdrücke zur Berechnung des Schaltjahres. Nutze stattdessen if-else- und else-if Anweisungen.
     */
    public static boolean isLeapYear(int year) {

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

##### CompareNumbersTest.java{#src-test-java-ch-itninja-labs-basicexercises-comparenumberstest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareNumbersTest {

    @ParameterizedTest
    @CsvSource({
            "1, -1, 5, 'Zahl1(-1) ist kleiner als Zahl2(5)'",
            "2, 23, 7, 'Zahl1(23) ist grösser als Zahl2(7)'",
            "3, 47, 47, 'Zahl1(47) ist gleich gross wie Zahl2(47)'",
            "4, 0, 0, 'Zahl1(0) ist gleich gross wie Zahl2(0)'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int value1, int value2, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            CompareNumbers.compareNumbers(value1, value2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "For "+value1+" and "+value2+" output should be '"+ expectedResult +"'");

        ItNinjaOutput.PrintItNinjaOutput("CompareNumbers"+lab, "CompareNumbers.compareNumbers("+value1+", "+value2+");", output);
    }
}

```

##### HelloNameTest.java{#src-test-java-ch-itninja-labs-basicexercises-hellonametest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HelloNameTest {

    @Test
    void givenPrintHelloName_whenCalled_thenOutputStartsWithHello() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            HelloName.printHelloName();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertTrue(output.startsWith("Hello "), "Output should start with 'Hello '");

        ItNinjaOutput.PrintItNinjaOutput("HelloName", "", output);

    }
}

```

##### LeapYearTest.java{#src-test-java-ch-itninja-labs-basicexercises-leapyeartest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeapYearTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1200, false, 'Das Jahr 1200 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "2, 1996, true, 'Das Jahr 1996 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "3, 1900, false, 'Das Jahr 1900 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "4, 2000, true, 'Das Jahr 2000 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "5, 2021, false, 'Das Jahr 2021 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "6, 2024, true, 'Das Jahr 2024 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "7, 2100, false, 'Das Jahr 2100 ist kein Schaltjahr gemäss gregorianischem Kalender'",
            "8, 2400, true, 'Das Jahr 2400 ist ein Schaltjahr gemäss gregorianischem Kalender'",
            "9, 2023, false, 'Das Jahr 2023 ist kein Schaltjahr gemäss gregorianischem Kalender'"
    })
    void givenYears_whenCalled_thenOutputAsExpected(int lab, int year, boolean expectedResult, String expectedOutput) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        boolean result;

        try {
            // WHEN
            result = LeapYear.isLeapYear(year);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedOutput, output, "For "+year+" output should be '"+ expectedOutput +"'");
        assertEquals(expectedResult, result,  "For "+year+" result should be '"+ result +"'");
        ItNinjaOutput.PrintItNinjaOutput("LeapYear"+lab, "boolean result = LeapYear.isLeapYear("+year+");", output);
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
