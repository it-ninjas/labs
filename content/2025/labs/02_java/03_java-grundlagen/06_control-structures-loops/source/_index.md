---
title: "control-structures-loops - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for control-structures-loops
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
control-structures-loops
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   └── NumberHelper.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   └── NumberHelperTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in control-structures-loops

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

import ch.itninja.labs.basicexercises.NumberHelper;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        NumberHelper.sumDivisibleByEightFixedRange();
        NumberHelper.sumDivisibleBy(2, 64, 4);
        NumberHelper.sumCommonMultiples(1, 88, 3, 5);
    }
}
```

#### basicexercises

##### NumberHelper.java{#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
  * Utility class providing helper methods for month operations.
*/
public class NumberHelper {

    private NumberHelper() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Zähle alle Zahlen von 1 bis 100 zusammen, welche durch 8 teilbar sind und gib das
     * Resultat auf der Konsole aus:
     *
     * - Die Summe aller durch 8 teilbaren Zahlen von 1 bis 100 beträgt 624.
     */
    public static void sumDivisibleByEightFixedRange() {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

    /**
     * Passe die folgende Methode an. Zähle alle Zahlen von min bis max zusammen, welche durch divisor teilbar sind und gib das
     * Resultat auf der Konsole aus:
     *
     * - Die Summe aller durch [divisor] teilbaren Zahlen von [min] bis [max] beträgt [result].
     *
     * Abgrenzung: Wenn max kleiner als min ist oder wenn divisor kleiner gleich 0 ist, soll folgender Text auf der
     * Konsole ausgegeben werden: Berechnung mit diesen Werten nicht möglich
     */
    public static void sumDivisibleBy(int min, int max, int divisor) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }

    /**
     * Passe die folgende Methode an. Zähle alle Zahlen von min bis max zusammen, welche ein gemeinsames Vielfaches von den
     * beiden Zahlen number1 und number2sind und gib das Resultat auf der Konsole aus:
     *
     * - Summe der Zahlen von [min] bis [max], die ein gemeinsames Vielfache von [number1] und [number2] sind: [result].
     *
     * Abgrenzung: Wenn max kleiner als min ist oder wenn eine der Zahlen number1 oder 'number2' kleiner gleich 0 ist,
     * soll folgender Text auf der Konsole ausgegeben werden: Berechnung mit diesen Werten nicht möglich
     */
    public static void sumCommonMultiples(int min, int max, int number1, int number2) {

        // IT-Ninja: Füge hier Deinen Code ein...
    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

##### NumberHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-numberhelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberHelperTest {

    @Test
    void givenSumDivisibleByEightFixedRange_whenCalled_thenOutputAsExpected() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumDivisibleByEightFixedRange();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expected = "Die Summe aller durch 8 teilbaren Zahlen von 1 bis 100 beträgt 624.";
        assertEquals(expected, output, "Output is not as expected");

        ItNinjaOutput.PrintItNinjaOutput("SumDivisibleByEightFixedRange", "NumberHelper.sumDivisibleByEightFixedRange()", output);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10, 30, 7, 63",
            "2, 30, 10, 7, -1",
    })
    void givenSumDivisibleBy_whenCalled_thenOutputAsExpected(int lab, int min, int max, int divisor, int result) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumDivisibleBy(min, max, divisor);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expectedResult = result > 0 ? String.format("Die Summe aller durch %d teilbaren Zahlen von %d bis %d beträgt %d."
                , divisor, min, max, result) : "Berechnung mit diesen Werten nicht möglich.";

        assertEquals(expectedResult, output, "Output is not as expected.");

        // For documentation
        String input = String.format("NumberHelper.sumDivisibleBy(%d, %d, %d);"
                , min, max, divisor);

        ItNinjaOutput.PrintItNinjaOutput("SumDivisibleBy"+lab, input, output);
    }

    @ParameterizedTest
    @CsvSource({
            // einfache Beispiele mit kleinem Bereich
            "1, 1, 50, 3, 5, 90",
            "2, 1, 100, 4, 6, 432",
            "0, 10, 30, 2, 3, 84",
            "0, 1, 60, 5, 10, 210",

            // keine gemeinsamen Vielfachen im Bereich
            "3, 1, 10, 4, 6, 0",
            "0, 20, 24, 3, 5, 0",

            // min > max → Berechnung nicht möglich
            "4, 50, 1, 3, 5, -1",

            // Randwert = genau ein gemeinsames Vielfaches
            "5, 15, 15, 3, 5, 15",
            "6, 60, 60, 4, 6, 60",

            // negatives Intervall (z. B. für erweiterte Version)
            "7, -30, 30, 6, 10, 0",  // negatives Vielfaches ignoriert (nach Bedarf anpassen)

            // sehr großer Bereich
            "8, 1, 1000, 8, 12, 20664"
    })

    void givenSumCommonMultiples_whenCalled_thenOutputAsExpected(int lab, int min, int max, int number1, int number2, int result) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            NumberHelper.sumCommonMultiples(min, max, number1, number2);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        String expectedResult = result >= 0 ? String.format("Summe der Zahlen von %d bis %d, die ein gemeinsames Vielfache von %d und %d sind: %d."
                , min, max, number1, number2, result) : "Berechnung mit diesen Werten nicht möglich.";

        assertEquals(expectedResult, output, "Output is not as expected.");

        // For documentation
        String input = String.format("NumberHelper.sumCommonMultiples(%d, %d, %d, %d);"
                , min, max, number1, number2);

        ItNinjaOutput.PrintItNinjaOutput("SumCommonMultiples"+lab, input, output);
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
