---
title: "exception_handling - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for exception_handling
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
exception_handling
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── AgeValidator.java
│   │                   │   └── Calculator.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── util
│                       │   └── ItNinjaOutput.java
│                       ├── AgeValidatorTest.java
│                       └── CalculatorTest.java
├── pom.xml
└── README.md
```

## Dateien in exception_handling

##### pom.xml{#pom-xml}

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.itninja</groupId>
  <artifactId>itninja-labs-02-03-08-methods</artifactId>
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

import ch.itninja.labs.basicexercises.Calculator;
import ch.itninja.labs.basicexercises.AgeValidator;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        // Sample call for "Sichere Division"
        // IT-Ninja: Füge hier Deinen Code ein...

        try {
            int age = 16;
            // Sample call for "Alter prüfen"
            // IT-Ninja: Füge hier Deinen Code ein...
            System.out.printf("Das Alter %d ist gültig.%n", age);
        } catch (IllegalArgumentException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // Sample call for "Mindestwert sicherstellen"
        // IT-Ninja: Füge hier Deinen Code ein...
    }
}

```

#### basicexercises

##### AgeValidator.java{#src-main-java-ch-itninja-labs-basicexercises-agevalidator-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for age validation operations.
 */
/**
 *
 * Name der Methode: Bestimme selber einen passenden Namen für die Methode
 * Funktion: Prüft das Alter und wirft eine IllegalArgumentException, wenn das Alter kleiner 0 oder grösser 130 ist.
 * Für gültige Werte passiert nichts.
 * Parameter1: age [int]
 * Rückgabewert: keiner, IllegalArgumentException wenn Alter ausserhalb des erlaubten Bereichs ist.
 */
public class AgeValidator {

    // IT-Ninja: Füge hier Deinen Code ein...

    private AgeValidator() {
        // Prevent instantiation
    }

    // IT-Ninja: Füge hier Deinen Code ein...
}

```

##### Calculator.java{#src-main-java-ch-itninja-labs-basicexercises-calculator-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for some calculations.
 */
public class Calculator {

    private Calculator() {
        // Prevent instantiation
    }

    // Place here the methode for "Sichere Division".
    /**
     * Name der Methode: Bestimme selber einen passenden Namen für die Methode
     * Funktion: Liefert das Resultat der Divsion von a durch b. Bei einer Divsion durch 0 wird der Wert
     * Integer.MAX_VALUE zurückgeben.
     * Parameter1: a [int]
     * Parameter2: b [int]
     * Rückgabewert: Resultat der Berechnung [int], Integer,MAX_VALUE bei Division durch 0.
     * Bedingungen: Verwende try / catch, um Division durch 0 korrekt abzufangen. if darf nicht verwendet werden.
     */
    // IT-Ninja: Füge hier Deinen Code ein...

    // Place here the methode for "Mindestwert sicherstellen".
    /**
     *
     * Name der Methode: Bestimme selber einen passenden Namen für die Methode
     * Funktion: Dividiert a durch b und danach c durch d. Das Resultat wird jeweils zum Total hinzugefügt. Fehler
     * werden mit einem einzigen try / catch abgefangen. Im finally-Block wird abschliessend sichergestellt, dass das
     * Total mindestens 100 beträgt.
     * Parameter1: a [int]
     * Parameter2: b [int]
     * Parameter3: c [int]
     * Parameter4: b [int]
     * Rückgabewert: Total der Berechnung [int]
     */
    // IT-Ninja: Füge hier Deinen Code ein...
}

```

### src\test\java\ch\itninja\labs

##### AgeValidatorTest.java{#src-test-java-ch-itninja-labs-agevalidatortest-java}

```java
package ch.itninja.labs;

import ch.itninja.labs.basicexercises.AgeValidator;
import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class AgeValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "1, 120, false",
            "2, 21, false",
            "3, 0, false",
            "4, 130, false",
            "5, -12, true",
            "6, 145, true",
    })
    void givenValidateAge_whenCalled_thenResultAsExpected(int lab, int age, boolean exceptionExpected) {

        // Init to a number not used by the methode.
        boolean excptionOccured = false;
        String exceptionMessage = null;

        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } catch (IllegalArgumentException e) {
            excptionOccured = true;
            exceptionMessage = e.getMessage();
        }

        // THEN
        assertEquals(exceptionExpected, excptionOccured, "Program flow was not throwing as expected.");

        // For documentation
        String input = String.format("yourImplementation(%d);", age);
        String output = "Beispiel Ausgabe: " + (excptionOccured?
                String.format("Fehler: %s%n", exceptionMessage):
        String.format("Das Alter %d ist gültig.%n", age));

        ItNinjaOutput.PrintItNinjaOutput("AgeValidator"+lab, input, output);
    }
}

```

##### CalculatorTest.java{#src-test-java-ch-itninja-labs-calculatortest-java}

```java
package ch.itninja.labs;

import ch.itninja.labs.basicexercises.Calculator;

import static org.junit.jupiter.api.Assertions.*;
import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 120, 2, 60",
            "2, 21, 3, 7",
            "3, 4, 8, 0",
            "4, 48, 0, 2147483647",
    })
    void givenDivide_whenCalled_thenResultAsExpected(int lab, int a, int b, int expected) {

        // Init to a number not used by the methode.
        int res = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode für "Sichere Division", welche wir testen wollen (etwas wie: res = methode(a, b);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , res
                , "Please ensure that the method is called in try code block and the result is stored in variable 'res'!");

        // THEN
        assertEquals(expected, res, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("total = yourImplementation(%d, %d);", a, b);
        String output = String.format("Beispiel Ausgabe: Die Division von '%d / %d' ergibt %d.%n", a, b, res);

        ItNinjaOutput.PrintItNinjaOutput("SafeDivision"+lab, input, output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 120, 2, 230, 2, 175, ''",
            "2, 21, 3, 32, 2, 100, 'Total zu klein -> 100'",
            "3, 240, 2, 48, 0, 120, 'Exception bei `c / d`, aber `a / b` > 100'",
            "4, 48, 0, 240, 2, 100, 'Exception bei `a / b`, Total darum 0 und zu klein -> 100'",
    })
    void givenCalculation_whenCalled_thenResultAsExpected(int lab, int a, int b, int c, int d, int expected, String comment) {

        // Init to a number not used by the methode.
        int total = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode für "Mindestwert sicherstellen", welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , total
                , "Please ensure that the method is called in try code block and the result is stored in variable 'total'!");

        // THEN
        assertEquals(expected, total, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("total = yourImplementation(%d, %d, %d, %d);", a, b, c, d);
        String output = String.format("Beispiel Ausgabe: Das Total für die Berechnung mit '%d, %d, %d, %d' ist %d%s.%n"
                , a, b, c, d, total, comment.isEmpty() ? "" : " // " + comment);

        ItNinjaOutput.PrintItNinjaOutput("Calculation"+lab, input, output);
    }

}

```

#### util

##### ItNinjaOutput.java{#src-test-java-ch-itninja-labs-util-itninjaoutput-java}

```java
package ch.itninja.labs.util;

public class ItNinjaOutput {
    public static void PrintItNinjaOutput(String lab, String input, Object output) {
        System.out.printf("<itninja output lab=\"%s\">\n", lab);
        System.out.printf("Eingabe: %s\n", input);
        System.out.printf("Ausgabe: %s\n", output);
        System.out.println("</itninja output>");
    }
}

```
