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
            return Files.readString(Path.of("labs/regex/data/mixed.txt"));
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
