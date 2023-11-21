package set;

public class OutputValidationUsage {

    private static final OutputValidation outputValidation = new OutputValidation();

    public OutputValidationUsage() {
        outputValidation.logAndPrint("2) Start working");
        outputValidation.log("3) This is not a interesting line. Only log this line.");
        outputValidation.logAndPrint("4) I work very hard!");
        outputValidation.logAndPrint("5) I'm finish.");
    }

    public static void main(String[] args) {
        outputValidation.logAndPrint("1) Programm is starting ...");
        OutputValidationUsage outputValidationUsage = new OutputValidationUsage();
        outputValidationUsage.verifyOutput();
    }

    public void verifyOutput() {
        // print the saved console output
        System.out.println("--------------------------------------------------");
        System.out.println("--> Print all logged outputs: ");
        outputValidation.printAll();
        System.out.println("--------------------------------------------------");
        // print the hash code
        System.out.print("--> The control hash is: ");
        outputValidation.printControlHash();
        // is the validation ok
        System.out.print("--> Is the control 2128163011 correct: ");
        System.out.println(outputValidation.verifyControlHash(2128163011));
        System.out.print("--> Is the control -105527360 correct: ");
        System.out.println(outputValidation.verifyControlHash(-105527360));
    }
}
