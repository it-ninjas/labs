/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.exams;

import java.util.Arrays;

/**
 * Solutions for basic exam numbers.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class BasicExamNumbers {

    public static void main(String[] args) {
        int[] numbers = {
                -8, 0, 13, 0, -8, 23, -22, 18, -6, -1,
                -21, -1, 2, 20, -24, 21, 25, -16, -10, -2,
                -20, 15, -15, 0, -16, -19, 13, 24, -3, 7,
                21, -15, 21, -11, 4, -17, 3, 11, 22, 12,
                11, 12, 6, -4, -21, -20, -24, -3, -25, -13,
                17, 19, 19, 20, 22, 9, -10, 12, 16, -1,
                21, -24, 12, 19, -7, 15, 5, -22, 23, 12,
                6, 2, -14, 12, 17, -13, 3, -4, -16, 8,
                16, 6, -23, 0, 3, -16, -6, -14, 8, 25,
                -22, 2, 7, 8, -6, 20, 3, -5, -19, -15};

        int result1 = countNumbersBetween0And10Without5(numbers);
        System.out.println("Aufgabe 1: " + result1);

        int[] result2 = searchPositiveNumbersIncluding0(numbers);
        System.out.println("Aufgabe 2: " + Arrays.toString(result2));

        int[] result3 = searchNumbersInRange(numbers);
        System.out.println("Aufgabe 3: " + Arrays.toString(result3));

        int[] result4 = changeToPositives(numbers);
        System.out.println("Aufgabe 4: " + Arrays.toString(result4));

        int[] result5 = findNumbersDifferMax5FromNeighbours(numbers);
        System.out.println("Aufgabe 5: " + Arrays.toString(result5));
    }

    // Aufgabe 1
    // Schreibe eine Methode, welche alle Zahlen im Array zählt, welche zwischen 0 und 10 liegen und keine 5 sind.
    // Die Methode liefert die Anzahl dieser Zahlen zurück.
    private static int countNumbersBetween0And10Without5(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            if (number > 0 && number < 10 && number != 5) {
                result++;
            }
        }
        return result;
    }

    // Aufgabe 2
    // Schreibe eine Methode, welche aus dem Array alle positiven Zahlen inklusive 0 in ein neues Array schreibt
    // Die Reihenfolge der Zahlen im Array muss gleich bleiben. Die Methode liefert das neue Array zurück.
    private static int[] searchPositiveNumbersIncluding0(int[] numbers) {
        int[] result = new int[numbers.length];
        int lastIndex = 0;
        for (int number : numbers) {
            if (number >= 0) {
                result[lastIndex++] = number;
            }
        }
        return Arrays.copyOfRange(result, 0, lastIndex);
    }

    // Aufgabe 3
    // Schreibe eine Methode, welche aus dem Array alle Zahlen sucht, welche nicht mehr als 10 von der Zahl -6 abweichen.
    // Schreibe diese Zahlen in ein neues Array. Die Methode liefert das neue Array zurück.
    private static int[] searchNumbersInRange(int[] numbers) {
        int[] result = new int[numbers.length];
        int lastIndex = 0;
        for (int number : numbers) {
            if (number >= -16 && number <= 4) {
                result[lastIndex++] = number;
            }
        }
        return Arrays.copyOfRange(result, 0, lastIndex);
    }

    // Aufgabe 4
    // Schreibe eine Methode, welche alle Zahlen aus dem Array in positive Zahlen verwandelt und diese in ein neues Array schreibt.
    // Die Methode liefert das neue Array zurück.
    private static int[] changeToPositives(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = Math.abs(numbers[i]);
        }
        return result;
    }

    // Aufgabe 5
    // Schreibe eine Methode, welche alle Zahlen aus dem Array ausliest, die sich von ihren direkten Nachbarn um jeweils nicht mehr als den Wert 5 unterscheiden.
    // Schreibe diese Zahlen in ein neues Array. Die Methode liefert das neue Array zurück. Für die erste und die letzte Zahl im Array gibt es nur einen Nachbar.
    private static int[] findNumbersDifferMax5FromNeighbours(int[] numbers) {
        int[] result = new int[numbers.length];
        int lastIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean differMax5 = false;
            // left neighbour exists
            if (i - 1 >= 0) {
                differMax5 = Math.abs(numbers[i - 1] - numbers[i]) <= 5;
            }
            // right neighbour exists
            if (differMax5 && i + 1 < numbers.length) {
                differMax5 = Math.abs(numbers[i + 1] - numbers[i]) <= 5;
            }
            // condition match
            if (differMax5) {
                result[lastIndex++] = numbers[i];
            }
        }
        return Arrays.copyOfRange(result, 0, lastIndex);
    }

}
