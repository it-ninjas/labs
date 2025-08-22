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
            return Files.readString(Path.of("labs/regex/data/mixed.txt"));
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
