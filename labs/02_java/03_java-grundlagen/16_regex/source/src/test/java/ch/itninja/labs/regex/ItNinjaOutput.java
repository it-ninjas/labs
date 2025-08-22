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
