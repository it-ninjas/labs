---
title: "strings - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for strings
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
strings
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
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── basicexercises
│                       │   └── EmptyTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── pom.xml
└── README.md
```

## Dateien in strings

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

/**
 * Entry point for the It-Ninja basic exercises.
 */
public class Main {

    public static void main(String[] args) {

        // IT-Ninja: rufe hier deine Methoden auf und gib die Resultate auf der Konsole aus
    }
}

```

### src\test\java\ch\itninja\labs\basicexercises

##### EmptyTest.java{#src-test-java-ch-itninja-labs-basicexercises-emptytest-java}

```java
package ch.itninja.labs.basicexercises;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyTest {
    @Test
    void emptyTest() {

        // This is just a placeholder for upcoming tests. Required by LabGenerator
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
