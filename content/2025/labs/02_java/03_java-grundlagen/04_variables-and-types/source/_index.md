---
title: "variables-and-types - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for variables-and-types
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
variables-and-types
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── HelloName.java
│   │                   │   └── TravelReport.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── HelloNameTest.java
│                       │   └── TravelReportTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in variables-and-types

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
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
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

import ch.itninja.labs.basicexercises.HelloName;
import ch.itninja.labs.basicexercises.TravelReport;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        HelloName.printHelloName();
        TravelReport.printTravelReport();
    }
}
```

#### basicexercises

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

##### TravelReport.java{#src-main-java-ch-itninja-labs-basicexercises-travelreport-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Gibt einen Reisebericht eines it-ninjas formatiert mit printf aus.
 */
public class TravelReport {

    private TravelReport() {
        // Prevent instantiation
    }

    public static void printTravelReport() {

        // IT-Ninja: Füge hier Deinen Code ein...
    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

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

##### TravelReportTest.java{#src-test-java-ch-itninja-labs-basicexercises-travelreporttest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelReportTest {

    @Test
    void givenPrintTravelReport_whenCalled_thenOutputShowsExpectedReport() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            TravelReport.printTravelReport();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String expectedReport = new StringBuilder()
                .append("Reise Report – Takeshi, Codename ShadowFox\n")
                .append("Datum der Abreise: 26. Juli 2025\n")
                .append("Mission: Code-Review\n")
                .append("Startpunkt: Lausanne\n")
                .append("Zielort: St. Gallen\n")
                .append("Abfahrt: 06:14 Uhr\n")
                .append("Ankunft: 09:07 Uhr\n")
                .append("Zwischenhalte: 5\n")
                .append("Reisekosten: 51.80 CHF\n\n")
                .append("ShadowFox nutzte die 1. Klasse am 26. Juli 2025, um sich auf die anstehende Code-Review ")
                .append("vorzubereiten. Mit einem Akku-Ladestand von 92% und 2 mitgeführten Laptops war er bestens ")
                .append("gerüstet. Die Mission wurde erfolgreich abgeschlossen. Die Reisekosten sind in CHF.")
                .toString();

        // Make output independent of linux or windows line endings
        String output = outputStream
                .toString()
                .trim()
                .replaceAll("\r\n", "\n")
                .replaceAll("\r", "\n");

        assertEquals(expectedReport, output, "Output is not as expected");

        ItNinjaOutput.PrintItNinjaOutput("TravelReport", "TravelReport.printTravelReport();", output);

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
