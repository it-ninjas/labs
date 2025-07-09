package ch.itninjas.program;

import java.io.IOException;

public class CodeSnippets {

    //snippet-format_and_indent-start
    // Bad:
    public int badMethode() { int a=3;int b=4;return a+b; }

    // Better:
    public int betterMethode() {
        int a=3;
        int b=4;
        return a+b;
    }

    // Annotations:
    @Override
    public String toString() {
        return "example";
    }
    //snippet-format_and_indent-end

    //snippet-long_lines_with_lot_params-start
    // Bad:
    public String badLongExample(String theFirstParameter, String theSecondParameter, String theThirdParameter, String theFourthParameter, String theFifthParameter) {
        return "...";
    }

    // Better:
    public String goodLongExample(
        String firstParameter,
        String secondParameter,
        String thirdParameter,
        String fourthParameter,
        String fifthParameter
    ) {
        return firstParameter
         + secondParameter
         + thirdParameter
         + fourthParameter
         + fifthParameter;
    }
    //snippet-long_lines_with_lot_params-end
    
    class NewApi{
        public int attemptsToWait;
    }

    public int getExtendedTimeout(int current, int previous, NewApi api) {
        //snippet-inline_comment-start
        // Bad: 
        int counter = 0; // set counter to zero to start counting from zero ← useless and long

        // Good:
        // defensive null check, required by legacy API
        if (api == null) return 0; 
    
        int timeout = 5000; // in milliseconds ← Short inline comment ok

        // Better:
        int timeoutMs = 5000;
        
        //snippet-inline_comment-end
        // Makes no sense, just to get rid of warnings ;-)
        return counter + timeout + timeoutMs;
    }

    class Image{        
    }

    class URL{
        public Image Get(){
            return null;
        }
    }

    //snippet-javadoc-start
    /**
     * Returns an Image object that can then be painted on the screen.
     *
     * @param url an absolute URL giving the location of the image
     * @return the image at the specified URL
     * @throws IOException if the URL is invalid or cannot be read
     */
    public Image getImage(URL url) throws IOException {
        if(url == null) {
            throw new IOException("Invalid URL");
        }
        return url.Get();
    }
    //snippet-javadoc-end

    //snippet-name_constants-start
    // Bad:
    public static int D(int x) {
        if (x != 0) {
            return -3;
        }
        int a = 2;
        int b = 5;
        return a + b;
    }
    
    // Good:
    private static final int STATUS_ERROR = -3;
    private static final int STATUS_OK = 0;
    private static final int WEEKEND_DAYS = 2;
    private static final int WORKING_DAYS = 5;

    public static int getWeekdaysOnSuccess(int status) {
        if (status != STATUS_OK) 
        {
            return STATUS_ERROR;
        }
        int weekendDays = WEEKEND_DAYS;
        int workingDays = WORKING_DAYS;
        int weekDays = weekendDays + workingDays;
        return weekDays;
    }
    //snippet-name_constants-end

    class User {

    }

    class UserService{
        public void save(User user) throws IOException{

        }
    }

    class Logger {
        public void error(String message, Exception e){

        }
    }

    public void SaveUser(UserService userService, User user, Logger logger)
    {
        //snippet-exceptions-start
        try {
            userService.save(user);

        } catch (IOException e) {
            logger.error("Failed to save user.", e);

        } catch (Exception ignored) {
            // intentionally empty
        }        
        //snippet-exceptions-end
    }

    public static void main( String[] args) {
        System.out.println("Hello World!");
        System.out.println("2nd Line");
    }
}
