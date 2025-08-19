---
title: "control-structures-switch - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for control-structures-switch
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
control-structures-switch
├── .idea
│   └── runConfigurations
│       ├── it_ninja.xml
│       └── it_ninja_test.xml
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── basicexercises
│   │                   │   ├── MonthHelper.java
│   │                   │   └── WeekHelper.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   ├── MonthHelperTest.java
│                       │   └── WeekHelperTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in control-structures-switch

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

### .idea\runConfigurations

##### it_ninja.xml{#idea-runconfigurations-it_ninja-xml}

```xml
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="it-ninja" type="Application" factoryName="Application">
    <option name="ALTERNATIVE_JRE_PATH" value="temurin-21" />
    <option name="ALTERNATIVE_JRE_PATH_ENABLED" value="true" />
    <option name="MAIN_CLASS_NAME" value="ch.itninja.labs.Main" />
    <module name="itninja-labs-01-basicexercises" />
    <extension name="coverage">
      <pattern>
        <option name="PATTERN" value="main.java.ch.itninja.labs.*" />
        <option name="ENABLED" value="true" />
      </pattern>
    </extension>
    <method v="2">
      <option name="Make" enabled="true" />
    </method>
  </configuration>
</component>
```

##### it_ninja_test.xml{#idea-runconfigurations-it_ninja_test-xml}

```xml
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="Test All" type="MavenRunConfiguration" factoryName="Maven">
    <MavenSettings>
      <option name="myGeneralSettings" />
      <option name="myRunnerSettings" />
      <option name="myRunnerParameters">
        <MavenRunnerParameters>
          <option name="cmdOptions" />
          <option name="profiles">
            <set />
          </option>
          <option name="goals">
            <list>
              <option value="clean" />
              <option value="test" />
            </list>
          </option>
          <option name="multimoduleDir" />
          <option name="pomFileName" />
          <option name="profilesMap">
            <map />
          </option>
          <option name="projectsCmdOptionValues">
            <list />
          </option>
          <option name="resolveToWorkspace" value="false" />
          <option name="workingDirPath" value="$PROJECT_DIR$" />
        </MavenRunnerParameters>
      </option>
    </MavenSettings>
    <method v="2" />
  </configuration>
</component>
```

### src\main\java\ch\itninja\labs

##### Main.java{#src-main-java-ch-itninja-labs-main-java}

```java
package ch.itninja.labs;

import java.time.Month;

import ch.itninja.labs.basicexercises.MonthHelper;
import ch.itninja.labs.basicexercises.WeekHelper;

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {
    public static void main(String[] args) {

        WeekHelper.printWeekdayNumber("Donnerstag");
        MonthHelper.printMonthByNumber(3);
    }
}
```

#### basicexercises

##### MonthHelper.java{#src-main-java-ch-itninja-labs-basicexercises-monthhelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
  * Utility class providing helper methods for month operations.
*/
public class MonthHelper {

    private MonthHelper() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Gib abhängig von der Variable month den passenden Monat auf der Konsole aus. Der Wert
     * 1 soll dabei dem Monat Januar entsprechen, 2 dem Monat Februar, usw. Für Zahlen welche keinem Monat entsprechen
     * soll ungültiger Monat auf der Konsole ausgegeben werden.
     */
    public static void printMonthByNumber(int month) {

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

##### WeekHelper.java{#src-main-java-ch-itninja-labs-basicexercises-weekhelper-java}

```java
package ch.itninja.labs.basicexercises;

/**
 * Utility class providing helper methods for week operations.
 */
public class WeekHelper {

    private WeekHelper() {
        // Prevent instantiation
    }

    /**
     * Passe die folgende Methode an. Gib abhängig von der Variable weekdayName auf der Konsole aus, um welchen Wochentag es sich
     * handelt:
     *
     * - Der [weekdayName] ist der [weekday]. Tag in der Woche.
     * - [weekdayName] entspricht keinem bekannten Wochentag.
     *
     * Wobei in der Ausgabe [weekdayName] durch den Namen des Wochentags ersetzt werden soll und [weekday] durch den Tag
     * der Woche, welche dem Wochentag entspricht. Der Montag soll dabei der erste Tag in der Woche sein.
     */
    public static void printWeekdayNumber(String weekdayName) {

        // IT-Ninja: Füge hier Deinen Code ein...

    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

##### MonthHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-monthhelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MonthHelperTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1, 'Januar'",
            "2, 5, 'Mai'",
            "3, 9, 'September'",
            "4, 12, 'Dezember'",
            "5, 22, 'ungültiger Monat'",
            "6, -3, 'ungültiger Monat'",
    })
    void givenNumbers_whenCalled_thenOutputAsExpected(int lab, int month, String expectedResult) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            // WHEN
            MonthHelper.printMonthByNumber(month);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedResult, output, "Output is not as expected.");

        ItNinjaOutput.PrintItNinjaOutput("MonthByNumber"+lab, "MonthHelper.printMonthByNumber("+month+");", output);
    }
}

```

##### WeekHelperTest.java{#src-test-java-ch-itninja-labs-basicexercises-weekhelpertest-java}

```java
package ch.itninja.labs.basicexercises;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekHelperTest {
    @ParameterizedTest
    @CsvSource({
            "1, 'Montag', 'Der Montag ist der 1. Tag in der Woche.'",
            "0, 'Dienstag', 'Der Dienstag ist der 2. Tag in der Woche.'",
            "0, 'Mittwoch', 'Der Mittwoch ist der 3. Tag in der Woche.'",
            "2, 'Donnerstag', 'Der Donnerstag ist der 4. Tag in der Woche.'",
            "1, 'Freitag', 'Der Freitag ist der 5. Tag in der Woche.'",
            "4, 'Samstag', 'Der Samstag ist der 6. Tag in der Woche.'",
            "0, 'Sonntag', 'Der Sonntag ist der 7. Tag in der Woche.'",
            "3, 'Weihnachten', 'Weihnachten entspricht keinem bekannten Wochentag.'"
    })
    void givenYears_whenCalled_thenOutputAsExpected(int lab, String weekdayName, String expectedOutput) {
        // GIVEN
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        boolean result;

        try {
            // WHEN
            WeekHelper.printWeekdayNumber(weekdayName);
        } finally {
            System.setOut(originalOut);
        }

        // THEN
        String output = outputStream.toString().trim();
        assertEquals(expectedOutput, output, "Output is not as expected.");
        ItNinjaOutput.PrintItNinjaOutput("Weekday"+lab, "WeekHelper.printWeekdayNumber(\""+weekdayName+"\");", output);
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
