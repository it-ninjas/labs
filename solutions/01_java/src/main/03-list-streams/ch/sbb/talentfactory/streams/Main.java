package ch.sbb.talentfactory.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sortInput();
        multiplyAndSortInput();
    }

    // Aufgabe 1
    public static void sortInput() {
        List<Integer> numbers = readNumbers();
        System.out.println("Unsortierte Liste: " + numbers);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        System.out.println("Sortierte Liste: " + sortedNumbers);

    }

    // Aufgabe 2
    public static void multiplyAndSortInput() {
        List<Integer> numbers = readNumbers();

        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .toList();

        List<Integer> sortedSquaredNumbers = squaredNumbers.stream()
                .sorted()
                .toList();

        System.out.println("Ursprüngliche Liste: " + numbers);
        System.out.println("Quadratzahlen: " + squaredNumbers);
        System.out.println("Sortierte Quadratzahlen: " + sortedSquaredNumbers);
    }

    private static List<Integer> readNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib eine Liste von Zahlen ein (getrennt durch Leerzeichen):");
        String inputLine = scanner.nextLine();

        try {
            return Arrays.stream(inputLine.split(" "))
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException ex) {
            System.err.println("Fehler beim Einlesen der Zahlen. Stelle sicher, dass eine gültige ganze Zahl eingegeben wurde.");
            return List.of();
        }
    }
}
