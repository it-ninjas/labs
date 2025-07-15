---
title: "Einfache-Berechnungen - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for Einfache-Berechnungen
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
Einfache-Berechnungen
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── CalculateForms.java
│   │                   │   ├── HelloName.java
│   │                   │   └── LeapYear.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   └── CalculateFormsTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in Einfache-Berechnungen

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
    }
}
```

#### basicexercises

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

    public static boolean isLeapYear(int year) {

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

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
