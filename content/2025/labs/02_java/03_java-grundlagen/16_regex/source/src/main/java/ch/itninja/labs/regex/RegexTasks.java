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
