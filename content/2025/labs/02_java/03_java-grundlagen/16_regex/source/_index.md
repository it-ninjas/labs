---
title: "regex - Source"
linkTitle: "Source"
type: docs
weight: 0
description: >
  Source code for regex
build:
  list: never
  render: always
cascade:
  _menu: false
---

## Verzeichnis-Struktur

```console
regex
├── .idea
│   └── runConfigurations
│       ├── it_ninja.xml
│       └── it_ninja_test.xml
├── data
│   └── mixed.txt
├── src
│   ├── main
│   │   └── java
│   │       └── ch
│   │           └── itninja
│   │               └── labs
│   │                   └── regex
│   │                       └── RegexTasks.java
│   └── test
│       └── java
│           └── ch
│               └── itninja
│                   └── labs
│                       └── regex
│                           ├── ItNinjaOutput.java
│                           ├── RegexChPlzTest.java
│                           ├── RegexEmailTest.java
│                           ├── RegexIbanTest.java
│                           ├── RegexMatcherUtil.java
│                           ├── RegexPasswordTest.java
│                           ├── RegexPhoneTest.java
│                           └── RegexUrlTest.java
├── pom.xml
└── README.md
```

## Dateien in regex

##### pom.xml{#pom-xml}

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.itninja.labs</groupId>
  <artifactId>regex-lab</artifactId>
  <version>1.0-SNAPSHOT</version>
  <properties>
    <maven.compiler.source>21</maven.compiler.source>
    <maven.compiler.target>21</maven.compiler.target>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <junit.jupiter.version>5.10.2</junit.jupiter.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter</artifactId>
      <version>${junit.jupiter.version}</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.2.5</version>
        <configuration>
          <useModulePath>false</useModulePath>
        </configuration>
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

### data

##### mixed.txt{#data-mixed-txt}

```
Kontakt: max.mustermann@example.com, info@test.mail, support@sub.domain.co.uk
Telefone: +41 31 987 65 43, 031 987 65 43, +41-44-668-18-00
URLs: https://it-ninjas.ch, http://example.org/test, https://sub.domain.tld/path?x=1#anchor.
IBANs: CH93 0076 2011 6238 5295 7, DE89370400440532013000, XX12 TEST 1234
Passwörter: SecuRe!234, password1, N0SymbolsHere, Sh0rt!
PLZ: 3007 Bern (BE), 1000 Lausanne (VD), 0123 Silberwyl (GN), 12345 Sternenbrugg (TN)

```

### src\main\java\ch\itninja\labs\regex

##### RegexTasks.java{#src-main-java-ch-itninja-labs-regex-regextasks-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Regex tasks for learners. Methods are intentionally left unimplemented.
 * Keep code/comments in English. Implement solutions inside the marked blocks.
 */
public class RegexTasks {

    /**
     * Build a Pattern that matches email-like addresses.
     * Tip: local-part + "@" + domain + TLD of length >= 2.
     */
    public static Pattern buildEmailPattern() {
        // TODO: implement
        return Pattern.compile("");
    }

    /**
     * Build a Pattern that matches IBANs syntactically with optional spaces.
     * Examples: "CH93 0076 2011 6238 5295 7", "DE89 3704 0044 0532 0130 00"
     * Note: Only format validation here, not the Mod-97 checksum.
     */
    public static Pattern buildIbanPattern() {
        // TODO: implement
        return Pattern.compile("");
    }

    /**
     * Build a Pattern for (Swiss/international) phone numbers with optional country code
     * and separators (space, dot, hyphen). Keep it reasonably permissive.
     */
    public static Pattern buildPhonePattern() {
        // TODO: implement
        return Pattern.compile("");
    }

    /**
     * Build a Pattern that captures http/https URLs without trailing punctuation.
     */
    public static Pattern buildUrlPattern() {
        // TODO: implement
        return Pattern.compile("");
    }

    /**
     * Build a Pattern enforcing: >= 8 chars, at least 1 lowercase, 1 uppercase, 1 digit, 1 symbol.
     * Hint: lookaheads.
     */
    public static Pattern buildPasswordPolicyPattern() {
        // TODO: implement
        return Pattern.compile("");
    }

    /**
     * Build a Pattern that matches Swiss postal codes (4 digits, no leading zero).
     */
    public static Pattern buildChPostalCodePattern() {
        // TODO: implement
        return Pattern.compile("");
    }
}

```

### src\test\java\ch\itninja\labs\regex

##### ItNinjaOutput.java{#src-test-java-ch-itninja-labs-regex-itninjaoutput-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Prints well-formed blocks for the it-ninja generator.
 * Keep console output stable and simple so the generator can parse it.
 */
public final class ItNinjaOutput {

    private ItNinjaOutput() {}

    public static void PrintItNinjaOutput(String lab, String input, Collection<String> output) {
        String outJoined = output == null ? "" :
                output.stream().filter(Objects::nonNull).collect(Collectors.joining(", "));

        System.out.println("<itninja input lab=\"" + lab + "\">" + input + "</itninja>");
        System.out.println("<itninja output lab=\"" + lab + "\">" + outJoined + "</itninja>");
    }
}

```

##### RegexChPlzTest.java{#src-test-java-ch-itninja-labs-regex-regexchplztest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexChPlzTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("3007", "1000"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void ch_plz_extraction(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildChPostalCodePattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        ItNinjaOutput.PrintItNinjaOutput("regex-ch-plz", text, matches);
        assertEquals(expected, matches);
    }
}

```

##### RegexEmailTest.java{#src-test-java-ch-itninja-labs-regex-regexemailtest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexEmailTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("max.mustermann@example.com",
                                 "info@test.mail",
                                 "support@sub.domain.co.uk"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void email_extraction(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildEmailPattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        // Print for docs
        ItNinjaOutput.PrintItNinjaOutput("regex-email", text, matches);
        assertEquals(expected, matches);
    }
}

```

##### RegexIbanTest.java{#src-test-java-ch-itninja-labs-regex-regexibantest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexIbanTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("CH93 0076 2011 6238 5295 7",
                                 "DE89370400440532013000"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void iban_format_validation(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildIbanPattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        ItNinjaOutput.PrintItNinjaOutput("regex-iban", text, matches);
        assertEquals(expected, matches);
    }
}

```

##### RegexMatcherUtil.java{#src-test-java-ch-itninja-labs-regex-regexmatcherutil-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Utility to collect regex matches from a text. */
public final class RegexMatcherUtil {

    private RegexMatcherUtil() {}

    public static List<String> findAll(Pattern pattern, String text) {
        List<String> res = new ArrayList<>();
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            res.add(m.group());
        }
        return res;
    }
}

```

##### RegexPasswordTest.java{#src-test-java-ch-itninja-labs-regex-regexpasswordtest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexPasswordTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("SecuRe!234"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void password_policy_matches(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildPasswordPolicyPattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        ItNinjaOutput.PrintItNinjaOutput("regex-password", text, matches);
        assertEquals(expected, matches);
    }
}

```

##### RegexPhoneTest.java{#src-test-java-ch-itninja-labs-regex-regexphonetest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexPhoneTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("+41 31 987 65 43",
                                 "031 987 65 43",
                                 "+41-44-668-18-00"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void phone_extraction(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildPhonePattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        ItNinjaOutput.PrintItNinjaOutput("regex-phone", text, matches);
        assertEquals(expected, matches);
    }
}

```

##### RegexUrlTest.java{#src-test-java-ch-itninja-labs-regex-regexurltest-java}

```java
// SPDX-License-Identifier: MIT
package ch.itninja.labs.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class RegexUrlTest {

    static String readMixed() {
        try {
            return Files.readString(Path.of("data/mixed.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Stream<List<String>> expectedProvider() {
        return Stream.of(List.of("https://it-ninjas.ch",
                                 "http://example.org/test",
                                 "https://sub.domain.tld/path?x=1#anchor"));
    }

    @ParameterizedTest
    @MethodSource("expectedProvider")
    void url_extraction(List<String> expected) {
        var text = readMixed();
        var p = RegexTasks.buildUrlPattern();
        var matches = RegexMatcherUtil.findAll(p, text);
        ItNinjaOutput.PrintItNinjaOutput("regex-url", text, matches);
        assertEquals(expected, matches);
    }
}

```
