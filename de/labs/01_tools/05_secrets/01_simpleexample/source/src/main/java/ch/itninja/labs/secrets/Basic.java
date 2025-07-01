package ch.itninja.labs.secrets;

import io.github.cdimascio.dotenv.Dotenv;
import java.util.MissingResourceException;

public class Basic {

    private static final String API_KEY_NAME = "SAMPLE_API_KEY";

    private Basic() {
        // Prevent instantiation
    }

    /**
     *
     */
    public static String getSecret (){
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String apiKey = dotenv.get(API_KEY_NAME);
        if (apiKey == null) {
            throw new MissingResourceException(
                    "API key not set. Please check your .env file or environment variables.",
                    API_KEY_NAME,
                    null
            );
        }
        return apiKey;
    }
}
