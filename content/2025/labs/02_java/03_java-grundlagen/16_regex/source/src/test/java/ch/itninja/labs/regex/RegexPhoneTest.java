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
