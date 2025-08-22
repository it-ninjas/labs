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
