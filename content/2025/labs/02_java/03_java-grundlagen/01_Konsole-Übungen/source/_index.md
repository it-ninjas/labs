---
title: "Konsole-Übungen - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for Konsole-Übungen
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
Konsole-Übungen
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── AsciiHouse.java
│   │                   │   ├── AsciiSwissFlag.java
│   │                   │   └── HelloWorld.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── AsciiHouseTest.java
│                       │   ├── AsciiSwissFlagTest.java
│                       │   └── HelloWorldTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in Konsole-Übungen

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

import ch.itninja.labs.basicexercises.AsciiHouse;
import ch.itninja.labs.basicexercises.AsciiSwissFlag;
import ch.itninja.labs.basicexercises.HelloWorld;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {
        HelloWorld.printHelloWorld();
        AsciiHouse.printHouse();
        AsciiSwissFlag.printSwissFlag();
    }
}
```

#### basicexercises

##### AsciiHouse.java{#src-main-java-ch-itninja-labs-basicexercises-asciihouse-java}

```java
package ch.itninja.labs.basicexercises;

public class AsciiHouse {

    private AsciiHouse() {
        // Prevent instantiation
    }

    /**
     * Zeichne ein Haus in der Konsole. Du darfst dazu folgende Zeichen verwenden:
     *
     * - '/', '\', '+', '-', '_', '[', ']', '|', Leerzeichen (' ')
     */
    public static void printHouse(){

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

##### AsciiSwissFlag.java{#src-main-java-ch-itninja-labs-basicexercises-asciiswissflag-java}

```java
package ch.itninja.labs.basicexercises;

public class AsciiSwissFlag {

    private AsciiSwissFlag() {
        // Prevent instantiation
    }

    /**
     * Zeichne eine Schweizer Fahne. Die Fahne muss einen Rahmen haben. Du darfst dazu
     * folgende Zeichen verwenden:
     *
     * - Im Rahmen: '|', '-', '+'', Leerzeichen (' ')
     * - Innerhalb: '|', '-', '+', '*', '=', '@'', Leerzeichen (' ')
     */
    public static void printSwissFlag(){

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

##### HelloWorld.java{#src-main-java-ch-itninja-labs-basicexercises-helloworld-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing methods for basic Hello World output.
 */
public class HelloWorld {

    private HelloWorld() {
        // Prevent instantiation
    }

    /**
     * Passe den Code an damit Hello World auf der Konsole ausgegeben wird.
     */
    public static void printHelloWorld(){

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}




```

### src\test\java\ch\itninja\labs\basicexercises

##### AsciiHouseTest.java{#src-test-java-ch-itninja-labs-basicexercises-asciihousetest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class AsciiHouseTest {

    @Test
    void givenPrintHouse_whenCalled_thenOutputHasOnlyAllowedCharacters() {
        // GIVEN
        Set<Character> allowedChars = Set.of(
                ' ', '/', '\\', '+', '-', '_', '[', ']', '|', '\n', '\r'
        );
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            AsciiHouse.printHouse();
        } finally {
            // System.out zurücksetzen, egal ob Fehler auftritt oder nicht
            System.setOut(originalOut);
        }

        // THEN
        List<String> lines = outputStream.toString().lines().toList();

        System.out.println(lines);

        assertFalse(lines.isEmpty(), "Output should not be empty");
        assertTrue(lines.size() >= 2, "A house should have at least 2 lines, but has " + lines.size());

        for (String line : lines) {
            for (int pos = 0; pos < line.length(); pos++) {
                char c = line.charAt(pos);
                if (!allowedChars.contains(c)) {
                    fail("Invalid character '" + c + "' in line: " + line);
                }
            }
        }

        ItNinjaOutput.PrintItNinjaOutput("AsciiHouse", "", String.join("\r\n", lines));
    }
}

```

##### AsciiSwissFlagTest.java{#src-test-java-ch-itninja-labs-basicexercises-asciiswissflagtest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiSwissFlagTest {

    @Test
    void givenPrintSwissFlag_whenCalled_thenOutputHasValidFrameAndCharacters() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            AsciiSwissFlag.printSwissFlag();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        List<String> lines = outputStream.toString().lines().toList();

        assertFalse(lines.isEmpty(), "Output should not be empty");
        assertTrue(lines.size() >= 3, "Flag should have at least 3 lines");

        String allowedInnerChars = " +*";
        String allowedFrameChars = "|-_=`~";

        int firstLineNumber = 0;
        int lastLineNumber = lines.size() - 1;
        for (int lineNumber = 0; lineNumber < lines.size(); lineNumber++) {
            String line = lines.get(lineNumber);

            boolean isFirstLine = lineNumber == firstLineNumber;
            boolean isLastLine = lineNumber == lastLineNumber;
            if (isFirstLine || isLastLine) {
                // Top or bottom line must contain a horizontal frame character
                assertTrue(
                        line.chars().anyMatch(ch -> "-_=`~".indexOf(ch) >= 0),
                        "Top/bottom line must contain at least one horizontal border character"
                );
            } else {
                // Middle lines must start and end with '|'
                assertTrue(
                        line.length() >= 2 && line.startsWith("|") && line.endsWith("|"),
                        "Line " + (lineNumber + 1) + " must start and end with '|'"
                );
            }

            // All characters must be allowed
            for (char c : line.toCharArray()) {
                if (!allowedInnerChars.contains(String.valueOf(c)) &&
                        !allowedFrameChars.contains(String.valueOf(c))) {
                    fail("Invalid character '" + c + "' in line: " + line);
                }
            }
        }

        ItNinjaOutput.PrintItNinjaOutput("AsciiSwissFlag", "", String.join("\r\n", lines));

    }
}

```

##### HelloWorldTest.java{#src-test-java-ch-itninja-labs-basicexercises-helloworldtest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    void givenPrintHelloWorld_whenCalled_thenOutputIsHelloWorld() {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            HelloWorld.printHelloWorld();
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals("Hello World", output, "Output should be exactly 'Hello World'");

        ItNinjaOutput.PrintItNinjaOutput("HelloWorld", "", output);
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
