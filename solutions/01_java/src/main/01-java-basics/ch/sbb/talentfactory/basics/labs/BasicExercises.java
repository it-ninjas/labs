/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.labs;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 * Solutions for basic exercises.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class BasicExercises {

    // Aufgabe 5 - Strings
    static String poem = """
            Ein Ninja leise wie der Wind,
            Seine Waffen stets geschwind.
            "Shurikens" fliegen, scharf und schnell,
            Klingen funkeln, furchterregend hell.


            "Nunchakus" wirbeln im Tanz,
            Mit jedem Schlag, im Vorteil er ganz.
            Seine Waffen, geheim und klug,
            Begleiten ihn bei jedem Zug.""";

    // Aufgabe 2 - Conditional Statements
    // Schreibe eine Methode, die feststellen kann, ob eine Zahl (als Parameter) grösser, kleiner oder gleich 0 ist
    public static void compareToZero(int number) {
        if (number == 0) {
            System.out.println("Die Nummer ist gleich 0");
        } else {
            if (number < 0) {
                System.out.println("Die Nummer ist kleiner als 0");
            } else {
                System.out.println("Die Nummer ist grösser als 0");
            }
        }
    }

    // Schreibe eine Methode, die dich begrüsst, wenn dein Name als Parameter übergeben wird
    public static void specialGreet(String name) {
        if ("Claudio".equals(name)) {
            System.out.println("Hallo Claudio");
        }
    }

    // Schreibe eine Methode, die feststellt, ob das übergebene Jahr ein Schaltjahr ist
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 == 0 && !(year % 400 == 0);
    }


    // Aufgabe 3 - Loops

    // Schreibe eine Methode, die überprüft, ob eine Zahl (als Parameter) gerade oder ungerade ist
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Fakultät - (https://code-exercises.com/programming/easy/10/factorial)
    public static int factorial(int number) {
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int factorialRecursive(int number) {
        if (number == 0) {
            return 1;
        } else {
            return number * factorialRecursive(number - 1);
        }
    }

    // Schreibe einen Loop, welcher alle Zahlen von 1 bis 100 zusammenzählt, welche durch 8 teilbar sind
    public static int sumDivisible8() {
        return sumDivisibleN(8);
    }

    public static int sumDivisibleN(int number) {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % number == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Aufgabe 4 - Einfache Berechnungen
    // Fläche eines Rechtecks
    public static int rectangleArea(int width, int height) {
        return width * height;
    }

    // Fläche eines Kreises
    public static double circleArea(int radius) {
        return Math.pow(radius, 2) * Math.PI;
    }

    // Umfang eines Rechtecks
    public static int rectangleCircumference(int width, int height) {
        return 2 * width + 2 * height;
    }

    // Inhalt einer Pyramide mit quadratischen Grundriss und einer bestimmten Höhe
    public static double pyramidVolume(int baseWidth, int height) {
        return Math.pow(baseWidth, 2) * height / 3;
    }

    // Berechne dein Alter am heutigen Tag in Jahren, Monaten und Tagen
    public static void calculateAge(int day, int month, int year) {
        LocalDate birthday = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthday, now);
        System.out.println("Years: " + diff.getYears() + ", Months: " + diff.getMonths() + ", " + diff.getDays());
    }

    // Vielfache von 3 und 5 summieren (https://code-exercises.com/programming/easy/7/sum-multiples-of-three-and-five)
    public static int sumMultiplesOf3And5(int number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Gib in der Konsole die Anzahl Wörter aus.
    public static void countNumberOfWordsPoem(String poem) {
        String[] words = poem.split("\\s+");
        System.out.println("Das Gedicht hat " + words.length + " Worte.");
    }

    // Gib den Text in Grossbuchstaben aus.
    public static void uppercasePoem(String poem) {
        System.out.println(poem.toUpperCase());
    }

    // Gib den Text so aus, dass jedes Leerzeichen mit einem Punkt ersetzt wurde.
    public static void replaceSpaceWithPeriod(String poem) {
        System.out.println(poem.replace(" ", "."));
    }

    // Schneide das Wort "Shurikens" aus. Ermittle hierfür die Position des wortes anhand des "-Zeichens.
    public static void cutWordShurikens(String poem) {
        int indexFirstQuotation = poem.indexOf("\"");
        // + 2 because of " and white space that should be ignored
        int indexSecondQuotation = poem.indexOf("\"", indexFirstQuotation + 1) + 2;

        String firstPartPoem = poem.substring(0, indexFirstQuotation);
        String secondPartPoem = poem.substring(indexSecondQuotation);
        System.out.println(firstPartPoem + secondPartPoem);
    }


    // Aufgabe 6 - Strings & Loops
    // Schreibe eine Methode, welche als Parameter einen beliebigen String übernimmt und dessen Zeichenfolge umkehrt
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static String reverse2(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Schreibe eine Methode, welche als Parameter einen beliebigen String übernimmt und die Anzahl Wörter darin ausgibt
    public static int numberOfWords(String s) {
        return s.trim().split(" ").length;
    }

    // Aufgabe 7 - Eingaben von der Kommandozeile
    // Lies zuerst deinen Namen und danach dein Alter über einen Scanner von der Kommandozeile ein
    // und gib dann die folgenden Daten auf die Kommandozeile aus
    // Hello + <Dein Name> + you are + <Dein Alter> + years old. Next year, you will be <Dein Alter + 1> years old.
    public static void normalStringOutput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib deinen Namen ein: ");
        String name = scanner.next();
        System.out.println();

        System.out.print("Gib dein Alter ein: ");
        int age = scanner.nextInt();
        System.out.println();

        System.out.println("Hello " + name + " you are " + age + " years old. Next year, you will be " + (age + 1) + " years old.");
    }

    // Generiere diesen Output mithilfe eines StringBuilders
    public static void stringBuilderOutput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib deinen Namen ein: ");
        String name = scanner.next();
        System.out.println();

        System.out.print("Gib dein Alter ein: ");
        int age = scanner.nextInt();
        System.out.println();

        StringBuilder sb = new StringBuilder();
        sb.append("Hello ")
                .append(name)
                .append(" you are ")
                .append(age)
                .append(" years old. Next year, you will be ")
                .append(age + 1)
                .append(" years old.");
        System.out.println();
    }

    // Generiere diesen Output mithilfe der String.format()-Methode
    public static void stringFormatOutput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib deinen Namen ein: ");
        String name = scanner.next();
        System.out.println();

        System.out.print("Gib dein Alter ein: ");
        int age = scanner.nextInt();
        System.out.println();

        System.out.printf("Hello %s you are %d years old. Next year, you will be %d years old.", name, age, age + 1);
    }

    // Aufgabe 8 - Arrays
    // Linear search - (https://code-exercises.com/programming/easy/13/linear-search)
    public static int linearSearch(int n, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == n) {
                return i;
            }
        }
        return -1;
    }

    // Find maximum (https://code-exercises.com/programming/easy/18/find-maximum)
    public static int maximum(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    // Aufgabe 9 - Methoden
    // Summe von zwei Zahlen (https://code-exercises.com/programming/easy/1/sum-of-two-numbers)
    public static Integer sum(Integer i, Integer j) {
        return i + j;
    }

    // Schreibe eine eigene Methode, die als Parameter einen Namen übernimmt.
    // Die Methode soll dann die folgenden Daten auf die Kommandozeile ausgeben "Hello + <Parameter-Name>"
    public static void greet(String name) {
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
        System.out.println(sumDivisible8());
        cutWordShurikens(poem);
    }
}
