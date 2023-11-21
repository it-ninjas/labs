package set;

import java.util.ArrayList;

/**
 * This class is a little helper for verify the console log output from a app.
 * For calculating the hash code, it is use a `,` as delimiter between the log rows.
 * For print the log on standard output, it uses the delimiter {@code System.lineSeparator()}.
 */
public class OutputValidation {
    ArrayList<String> log = new ArrayList<>();

    /**
     * Add a new line to the saved output.
     *
     * @param line The content from the line.
     */
    public void log(String line) {
        log.add(line);
    }

    /**
     * Add a new line to the saved output and print
     * this line also to the standard output.
     *
     * @param line The content from the line.
     */
    public void logAndPrint(String line) {
        log.add(line);
        System.out.println(line);
    }

    /**
     * Print all saved output lines to the standard output,
     * in the same order as the lines are added.
     */
    public void printAll() {
        System.out.println(collectLogs(System.lineSeparator()));
    }

    /**
     * Calculate the hash of the whole saved outputs and print
     * the hash to the standard output.
     */
    public void printControlHash() {
        System.out.println(collectLogs(",").hashCode());
    }

    /**
     * Calculate the hash of the whole saved output and verify
     * it with the controlHash parameter.
     *
     * @param controlHash The hash for verify the calculated hash.
     * @return {@code true} if the calculated hash is equal to the
     * controlHash or {@code false}.
     */
    public boolean verifyControlHash(int controlHash) {
        return collectLogs(",").hashCode() == controlHash;
    }

    private String collectLogs(String delimiter) {
        return String.join(delimiter, log);
    }
}
