package exceptionhandeling;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib die erste Zahl ein: ");
        int num1 = getIntInput(scanner);

        System.out.print("Gib die zweite Zahl ein: ");
        int num2 = getIntInput(scanner);

        Random random = new Random();
        int operationIndex = random.nextInt(4);
        switch (operationIndex) {
            case 0:
                performOperation(num1, num2, "+", (a, b) -> a + b);
                break;
            case 1:
                performOperation(num1, num2, "-", (a, b) -> a - b);
                break;
            case 2:
                performOperation(num1, num2, "*", (a, b) -> a * b);
                break;
            case 3:
                if (num2 != 0) {
                    performOperation(num1, num2, "/", (a, b) -> (double) a / b);
                } else {
                    System.out.println("Division durch Null ist nicht erlaubt.");
                }
                break;
        }
    }

    private static int getIntInput(Scanner scanner) {
        int num = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                num = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ungültige Eingabe. Bitte gib eine ganze Zahl ein.");
                scanner.nextLine();
            }
        }
        return num;
    }

    private static void performOperation(int a, int b, String operator, Operation operation) {
        double result = operation.calculate(a, b);
        System.out.println(a + " " + operator + " " + b + " = " + result);
    }

    interface Operation {
        double calculate(int a, int b);
    }
}
