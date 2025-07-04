---
title: "SimpleExample - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for SimpleExample
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
SimpleExample
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   ├── secrets
│   │                   │   └── Basic.java
│   │                   └── Main.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       ├── secrets
│                       │   └── BasicTest.java
│                       └── util
│                           └── ItNinjaOutput.java
├── .env
├── .gitignore
├── pom.xml
└── README.md
```

## Dateien in SimpleExample

##### .env{#env}

```
# This file contains the required environment variables! To use it, rename it to '.env'.
# Always make sure that the '.env' file containing sensitive information is never committed to a Git repository!

SAMPLE_API_KEY=mein_geheimnis
```

##### .gitignore{#gitignore}

```
.env
```

##### pom.xml{#pom-xml}

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
             https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.itninja</groupId>
  <artifactId>itninja-labs-01-security</artifactId>
  <version>1.0.0</version>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>

  <dependencies>
    <!-- dotenv -->
    <dependency>
      <groupId>io.github.cdimascio</groupId>
      <artifactId>dotenv-java</artifactId>
      <version>3.0.0</version>
    </dependency>
    <!-- JUnit 5 -->
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>5.10.2</version>
      <scope>test</scope>
    </dependency>
    <!-- jBCrypt -->
    <dependency>
      <groupId>org.mindrot</groupId>
      <artifactId>jbcrypt</artifactId>
      <version>0.4</version>
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
      <!-- Testausführung -->
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

import ch.itninja.labs.secrets.Basic;

/**
 * Entry point for the It-Ninja basic secret example.
 */
public class Main {
    public static void main(String[] args) {
        String secret = Basic.getSecret();
        System.out.println("Das Geheimnis ist: '" + secret + "'");
    }
}
```

#### secrets

##### Basic.java{#src-main-java-ch-itninja-labs-secrets-basic-java}

```java
package ch.itninja.labs.secrets;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.MissingResourceException;

public class Basic {

    private static final String API_KEY_NAME = "SAMPLE_API_KEY";

    private Basic() {
        // Prevent instantiation
    }

    /**
     *
     */
    public static String getSecret (){
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String apiKey = dotenv.get(API_KEY_NAME);
        if (apiKey == null) {
            throw new MissingResourceException(
                    "API key not set. Please check your .env file or environment variables.",
                    API_KEY_NAME,
                    null
            );
        }
        return apiKey;
    }
}

```

### src\test\java\ch\itninja\labs\secrets

##### BasicTest.java{#src-test-java-ch-itninja-labs-secrets-basictest-java}

```java
package ch.itninja.labs.secrets;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicTest {

    @Test
    void givenBasicExample_whenCalled_thenReturnSecret() {
        // GIVEN
        String output = "Das Geheimnis ist: ";
        String hash = "$2a$10$HidiMxXZdm1KEIT1nqGoHeiQoiruQd0VrL8I6yz6L.DucmcKjXp2.";

        // WHEN
        String secret = Basic.getSecret();

        // THEN
        assertTrue(BCrypt.checkpw(secret, hash));

        ItNinjaOutput.PrintItNinjaOutput("Basic", "", output + "'" + secret + "'");
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
