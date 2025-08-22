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
            return Files.readString(Path.of("labs/regex/data/mixed.txt"));
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
