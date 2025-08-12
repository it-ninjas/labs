package ch.itninja.labs.secrets;

import ch.itninja.labs.util.ItNinjaOutput;
import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BasicTest {

    @Test
    void givenBasicExample_whenCalled_thenReturnSecret() {
        // GIVEN
        String output = "Das Geheimnis ist: ";
        String hash = "$2a$10$HidiMxXZdm1KEIT1nqGoHeiQoiruQd0VrL8I6yz6L.DucmcKjXp2.";

        // WHEN
        String secret = Basic.getSecret();

        // THEN
        assertTrue(BCrypt.checkpw(secret, hash));

        ItNinjaOutput.PrintItNinjaOutput("Basic", "", output + "'" + secret + "'");
    }
}
