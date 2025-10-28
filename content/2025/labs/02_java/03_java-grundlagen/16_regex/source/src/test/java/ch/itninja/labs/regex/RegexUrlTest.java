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
