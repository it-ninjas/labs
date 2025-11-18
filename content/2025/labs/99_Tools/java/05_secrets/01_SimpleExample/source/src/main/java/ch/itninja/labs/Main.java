package ch.itninja.labs;

import ch.itninja.labs.secrets.Basic;

/**
 * Entry point for the It-Ninja basic secret example.
 */
public class Main {
    public static void main(String[] args) {
        String secret = Basic.getSecret();
        System.out.println("Das Geheimnis ist: '" + secret + "'");
    }
}