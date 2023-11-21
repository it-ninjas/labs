package ch.sbb.talentfactory.list;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        numberInput();
        readWords();
        scanner.close();
    }

    // Aufgabe 1
    public static void numberInput() {
        System.out.print("Gib eine Reihe von Zahlen ein: ");
        String input = scanner.nextLine();

        String[] inputArray = input.split(" ");

        try {
            int position = Integer.parseInt(inputArray[0]);
            int[] numbers = new int[inputArray.length - 1];
            for (int i = 1; i < inputArray.length; i++) {
                numbers[i - 1] = Integer.parseInt(inputArray[i]);
            }

            String result = findNumberAtPosition(numbers, position);
            System.out.println(result);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Ungültige Eingabe!");
        }
    }

    public static String findNumberAtPosition(int[] numbers, int position) {
        if (position < 1 || position > numbers.length) {
            return "ERROR! Die Position " + position + " existiert nicht";
        } else {
            return "Die Zahl an der Position " + position + " ist: " + numbers[position - 1];
        }
    }

    // Aufgabe 2
    public static void readWords() {
        System.out.print("Gib einen Text mit beliebiger Anzahl von Wörtern ein: ");
        String input = scanner.nextLine();

        // Den eingegebenen Text in Wörter aufteilen
        String[] words = input.split("\\s+");

        // Anzahl der gelesenen Wörter ausgeben
        int wordCount = words.length;
        System.out.println("Anzahl gelesene Wörter: " + wordCount);

        // Alle gelesenen Wörter ausgeben
        System.out.println("Gelesene Wörter:");
        for (String word : words) {
            System.out.println(word);
        }

        // Alle Nomen in Grossbuchstaben ausgeben
        System.out.println("Nomen in Grossbuchstaben:");
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                System.out.println(word.toUpperCase());
            }
        }

        // Alle gelesene Wörter in umgekehrter Reihenfolge ausgeben
        System.out.println("Gelesene Wörter in umgekehrter Reihenfolge:");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.println(words[i]);
        }

    }
}
