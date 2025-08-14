---
title: "methods - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for methods
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
methods
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── FibonacciHelper.java
│   │                   │   ├── MessageHelper.java
│   │                   │   └── NumberHelper.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── FibonacciHelperTest.java
│                       │   ├── MessageHelperTest.java
│                       │   └── NumberHelperTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in methods

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

import ch.itninja.labs.basicexercises.FibonacciHelper;
import ch.itninja.labs.basicexercises.MessageHelper;
import ch.itninja.labs.basicexercises.NumberHelper;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        // Sample call for "Nachricht drucken"
        // IT-Ninja: Füge hier Deinen Code ein...

        // Sample call for "Minimum von drei Zahlen"
        // IT-Ninja: Füge hier Deinen Code ein...

        // Sample call for "Fibonacci"
        // IT-Ninja: Füge hier Deinen Code ein...
    }
}

```

#### basicexercises

##### FibonacciHelper.java{#src-main-java-ch-itninja-labs-basicexercises-fibonaccihelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing helper methods for fibonacci operations.
 */
/**
 * Name der Methode: Bestimme selber einen passenden Namen für die Methode
 * Funktion: Berechnet die n-te Zahl der Fibonacci-Folge.
 * Parameter1: n [int]
 * Rückgabewert: n-te Zahl der Fibonacci-Folge [int]
 * Abgrenzung: Gibt -1 zurück, wenn Fibonacci-Folge ausserhalb des Wertebreichs von int ist.
 */
public class FibonacciHelper {

    // IT-Ninja: Füge hier Deinen Code ein...
}

```

##### MessageHelper.java{#src-main-java-ch-itninja-labs-basicexercises-messagehelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing helper methods for fibonacci operations.
 */
/**
 * Name der Methode: Bestimme selber einen passenden Namen für die Methode
 * Funktion: Gibt eine Nachricht auf der Konsole aus, Format: Nachricht an [Name des Empfängers]: [Nachricht]
 * Parameter1: Name des Empfängers [String]
 * Parameter2: Nachricht [String]
 * Rückgabewert: Keiner
 */
public class MessageHelper {

    // IT-Ninja: Füge hier Deinen Code ein...
}

```

##### NumberHelper.java{#src-main-java-ch-itninja-labs-basicexercises-numberhelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing helper methods for fibonacci operations.
 */
/**
 * * *Name der Methode: Bestimme selber einen passenden Namen für die Methode
 * Funktion: Gibt die kleinste von 3 Zahlen zurück
 * Parameter1: Erste Zahl [int]
 * Parameter2: Zweite Zahl [int]
 * Parameter3: Dritte Zahl [int]
 * Rückgabewert: Kleinste der 3 Zahlen [int]
 */
public class NumberHelper {

    // IT-Ninja: Füge hier Deinen Code ein...
}

```

### src\test\java\ch\itninja\labs\basicexercises

##### FibonacciHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-fibonaccihelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciHelperTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 0, 0",
            "2, 1, 1",
            "3, 2, 1",
            "4, 7, 13",
            "5, -5, 0",
            "6, 100, -1",
    })
    void testFibonacci(int lab, int n, int expected) {

        // Init to a number not used by the methode.
        int fibonacci = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: fibonacci = methode(n);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , fibonacci
                , "Please ensure that the method is called in try code block and the result is stored in variable 'fibonacci'!");

        // THEN
        assertEquals(expected, fibonacci, "The fibonacci number is not correct");

        // For documentation
        String input = String.format("fibonacci = yourImplementation(%d);", n);
        String output = String.format("Example Output: The %d. element of the Fibonacci sequence is %d.%n", n, fibonacci);

        ItNinjaOutput.PrintItNinjaOutput("Fibonacci"+lab, input, output);
    }
}

```

##### MessageHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-messagehelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MessageHelperTest {

    @ParameterizedTest
    @CsvSource({
            "1, 'Peter', 'Das Meeting beginnt um 9 Uhr.', 'Nachricht an Peter: Das Meeting beginnt um 9 Uhr.'",
            "2, 'Linda', 'Bitte rufe Hans Mustermann zurück.', 'Nachricht an Linda: Bitte rufe Hans Mustermann zurück.'",
    })
    void givenPrintMessage_whenCalled_thenOutputAsExpected(int lab, String name, String message, String expected) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: methode(name, message);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();

        // Pre-Check for implementation
        assertNotEquals("" , output
                , "Output empty. Please ensure that the method is called in try code block!");

        assertEquals(expected, output, "Output is not as expected.");

        // For documentation
        String input = String.format("yourImplementation(\"%s\", \"%s\");"
                , name, message);

        ItNinjaOutput.PrintItNinjaOutput("PrintMessage"+lab, input, output);
    }
}

```

##### NumberHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-numberhelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class NumberHelperTest {

    private static final int METHOD_NOT_IMPLEMENTED = -2;

    @ParameterizedTest
    @CsvSource({
            "1, 63, 22, 98, 22",
            "2, 17, 67, 32, 17",
            "3, 4, 56, 3, 3",
    })
    void givenMinimumOfThree_whenCalled_thenOutputAsExpected(int lab, int a, int b, int c, int expected) {

        // Init to a number not used by the methode.
        int min = METHOD_NOT_IMPLEMENTED;

        try {
            // WHEN
            // Aufruf der Methode, welche wir testen wollen (etwas wie: min = methode(a, b, c);):
            // IT-Ninja: Füge hier Deinen Code ein...
        } finally {
        }

        // Pre-Check for implementation
        assertNotEquals(METHOD_NOT_IMPLEMENTED , min
                , "Please ensure that the method is called in try code block and the result is stored in variable 'min'!");

        // THEN
        assertEquals(expected, min, "The number seems not to be the minimum of three.");

        // For documentation
        String input = String.format("min = yourImplementation(%d, %d, %d);", a, b, c);
        String output = String.format("Example Output: The minimum from %d, %d and %d is %d.%n", a, b, c, min);

        ItNinjaOutput.PrintItNinjaOutput("MinimumOfThree"+lab, input, output);
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
