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
            return Files.readString(Path.of("labs/regex/data/mixed.txt"));
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
