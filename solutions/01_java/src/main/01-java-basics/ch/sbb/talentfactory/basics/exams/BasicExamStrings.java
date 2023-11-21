/*
 * Copyright (C) Schweizerische Bundesbahnen SBB, 2021
 */
package ch.sbb.talentfactory.basics.exams;

import java.text.Collator;
import java.util.Arrays;

/**
 * Solutions for basic exam strings.
 *
 * @author u210148 (Claudio Zesiger)
 */
public class BasicExamStrings {

    private static final String SPACE = " ";

    private static final String EMPTY = "";

    private static final String ALPHANUMERIC = "[^A-Za-z0-9 ]";

    public static void main(String[] args) {
        String endOfTheWorld =
                "That's great, it starts with an earthquake " +
                        "Birds and snakes, and aeroplanes " +
                        "And Lenny Bruce is not afraid " +
                        "Eye of a hurricane, listen to yourself churn " +
                        "World serves its own needs " +
                        "Don't mis-serve your own needs " +
                        "Speed it up a notch, speed, grunt, no, strength " +
                        "The ladder starts to clatter " +
                        "With a fear of height, down, height " +
                        "Wire in a fire, represent the seven games " +
                        "And a government for hire and a combat site " +
                        "Left her, wasn't coming in a hurry " +
                        "With the Furies breathing down your neck " +
                        "Team by team, reporters baffled, trumped, tethered, cropped " +
                        "Look at that low plane, fine, then " +
                        "Uh oh, overflow, population, common group " +
                        "But it'll do, save yourself, serve yourself " +
                        "World serves its own needs, listen to your heart bleed " +
                        "Tell me with the Rapture and the reverent in the right, right " +
                        "You vitriolic, patriotic, slam fight, bright light " +
                        "Feeling pretty psyched " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it and I feel fine " +
                        "Six o'clock, T.V. hour, don't get caught in foreign tower " +
                        "Slash and burn, return, listen to yourself churn " +
                        "Lock him in uniform, book burning, bloodletting " +
                        "Every motive escalate, automotive incinerate " +
                        "Light a candle, light a motive, step down, step down " +
                        "Watch your heel crush, crush, uh oh " +
                        "This means no fear, cavalier, renegade and steering clear " +
                        "A tournament, a tournament, a tournament of lies " +
                        "Offer me solutions, offer me alternatives and I decline " +
                        "It's the end of the world as we know it (I had some time alone) " +
                        "It's the end of the world as we know it (I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "I feel fine (I feel fine) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "The other night I drifted nice continental drift divide " +
                        "Mountains sit in a line, Leonard Bernstein " +
                        "Leonid Brezhnev, Lenny Bruce and Lester Bangs " +
                        "Birthday party, cheesecake, jellybean, boom " +
                        "You symbiotic, patriotic, slam but neck, right, right " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it (time I had some time alone) " +
                        "It's the end of the world as we know it and I feel fine (time I had some time alone)";

        String endOfTheWorldClean = removeSpecialCharacters(endOfTheWorld);

        int wordCount = countWordsExistingTwiceOrMore(endOfTheWorldClean);
        System.out.println("Word count: " + wordCount);

        String[] sortedWords = sortAlphabetically(endOfTheWorldClean);
        System.out.println("Sorted words: " + Arrays.toString(sortedWords));

        double averageWordLength = averageWordLength(endOfTheWorldClean);
        System.out.println("Average word length: " + averageWordLength);

        String[] sortedWordsByLength = sortWordsByLength(endOfTheWorldClean);
        System.out.println("Sorted words by length: " + Arrays.toString(sortedWordsByLength));

        String mostCommonWord = findMostCommonWord(endOfTheWorldClean);
        System.out.println("Most common word: " + mostCommonWord);

        String[][] characterIndizes = toCharacterCountArray(endOfTheWorld);
        int max = 0;
        for (String[] chars : characterIndizes) {
            System.out.print(String.format("|  %s  ", chars[0]));
            if (chars.length > max) {
                max = chars.length;
            }
        }
        System.out.println("|");
        for (int i = 1; i < max; i++) {
            for (String[] chars : characterIndizes) {
                if (i < chars.length) {
                    System.out.print(String.format("|%5s", chars[i]));
                } else {
                    System.out.print("|     ");
                }
            }
            System.out.println("|");
        }
    }

    private static String removeSpecialCharacters(String s) {
        return s.replaceAll(ALPHANUMERIC, EMPTY);
    }

    // Aufgabe 1
    // Schreibe eine Methode, welche die Anzahl Wörter zählt, welche mindestens zweimal im Text vorkommen. Entferne zu diesem Zweck zuerst die Sonderzeichen.
    // Die Methode liefert die Anzahl dieser Wörter zurück.
    private static int countWordsExistingTwiceOrMore(String endOfTheWorld) {
        endOfTheWorld = endOfTheWorld.toLowerCase();
        String[] words = endOfTheWorld.split(SPACE);
        String[] uniqueWords = generateUniqueWords(words);
        int result = 0;
        int wordCount;
        for (String uniqueWord : uniqueWords) {
            wordCount = 0;
            for (String word : words) {
                if (uniqueWord.equals(word)) {
                    wordCount++;
                    if (wordCount > 1) {
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    private static String[] generateUniqueWords(String[] words) {
        String[] uniqueWords = new String[words.length];
        int index = 0;
        for (String word : words) {
            boolean found = false;
            word = word.toLowerCase();
            for (String uniqueWord : uniqueWords) {
                if (uniqueWord != null) {
                    if (uniqueWord.equals(word)) {
                        found = true;
                        break;
                    }
                }
            }
            if (!found) {
                uniqueWords[index++] = word;
            }
        }
        return Arrays.copyOfRange(uniqueWords, 0, index);
    }

    // Aufgabe 2
    // Schreibe eine Methode, welche die Wörter aus dem Text oben alphabetisch sortiert. Entferne zu diesem Zweck zuerst die Sonderzeichen.
    // Die Methode liefert ein Array mit den sortierten Wörtern zurück.
    private static String[] sortAlphabetically(String endOfTheWorld) {
        String[] words = endOfTheWorld.split(SPACE);
        Arrays.sort(words, Collator.getInstance());
        return words;
    }

    // Aufgabe 3
    // Schreibe eine Methode, welche die durchschnittliche Wortlänge berechnet. Entferne zu diesem Zweck zuerst die Sonderzeichen.
    // Die Methode liefert die durchschnittliche Wortlänge als Gleitkommazahl zurück.
    private static double averageWordLength(String endOfTheWorld) {

        String[] words = endOfTheWorld.split(SPACE);
        double lengthTotal = 0d;
        for (String word : words) {
            lengthTotal += word.length();
        }
        return lengthTotal / words.length;

        // Alternative Lösung für "Schlaumeier"
//        String allLetters = endOfTheWorld.replace(" ", "");
//        return allLetters.length() / words.length;
    }

    // Aufgabe 4
    // Schreibe eine Methode, welche die Wörter aus dem Text nach ihrer Länge sortiert. Kurze Wörter kommen dabei zuerst. Entferne zu diesem Zweck zuerst die Sonderzeichen.
    // Die Methode liefert ein Array mit den sortierten Wörtern zurück.
    private static String[] sortWordsByLength(String endOfTheWorld) {
        String[] words = endOfTheWorld.split(SPACE);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (words[i].length() < words[j].length()) {
                    String tmp = words[i];
                    words[i] = words[j];
                    words[j] = tmp;
                }
            }
        }
        return words;
    }

    // Aufgabe 5
    // Schreibe eine Methode, welche das Wort zurückliefert, das im Text oben am häufigsten vorkommt. Entferne zu diesem Zweck zuerst die Sonderzeichen.
    // Die Methode liefert das gesuchte Wort zurück.
    private static String findMostCommonWord(String endOfTheWorld) {
        String[] words = endOfTheWorld.split(SPACE);
        String[] uniqueWords = generateUniqueWords(words);
        String result = EMPTY;
        int max = 0;
        for (String uniqueWord : uniqueWords) {
            int wordCount = 0;
            for (String word : words) {
                if (uniqueWord.equals(word)) {
                    wordCount++;
                }
            }
            if (wordCount > max) {
                max = wordCount;
                result = uniqueWord;
            }
        }
        return result;
    }

    // Aufgabe 6
    // Schreibe eine Methode, welche die einzelnen Buchstaben des Textes in ein zweidimensionales Array von Strings überführt.
    // Die erste Dimension hat dabei die Grösse der verschiedenen vorkommenden Zeichen im Text in alphabetischer Reihenfolge.
    // Sonderzeichen sind ebenfalls Teil dieser alphabetischen Reihenfolge, die Sortierung richtet sich nach dem Integer-Wert der einzelnen Zeichen.
    // Die zweite Dimension enthält pro Zeichen ein Array mit den Positionen der Zeichen im Text. An erster Stelle steht dabei das jeweilige Zeichen.
    // Sämtliche Buchstaben sollen immer nur als kleingeschriebene Buchstaben behandelt werden.
    private static String[][] toCharacterCountArray(String endOfTheWorld) {
        // count unique chars
        String chars = toUniqueChars(endOfTheWorld);

        // sort alphabetically
        char[] characters = chars.toCharArray();
        Character[] uniqueChars = new Character[characters.length];
        for (int i = 0; i < characters.length; i++) {
            uniqueChars[i] = characters[i];
        }
        quicksort(uniqueChars, 0, uniqueChars.length - 1);

        // count indizes
        String[][] result = new String[chars.length()][];
        int mainIndex = 0;
        for (char c : uniqueChars) {
            int count = 0;
            for (int index = 0; index < endOfTheWorld.length(); index++) {
                if (Character.toLowerCase(endOfTheWorld.charAt(index)) == c) {
                    count++;
                }
            }
            String[] arr = new String[count + 1];
            arr[0] = Character.toString(c);
            int arrIndex = 1;
            for (int index = 0; index < endOfTheWorld.length(); index++) {
                if (Character.toLowerCase(endOfTheWorld.charAt(index)) == c) {
                    arr[arrIndex++] = Integer.toString(index);
                }
            }
            result[mainIndex++] = arr;
        }

        return result;
    }

    private static String toUniqueChars(String base) {
        StringBuilder uniqueChars = new StringBuilder();
        for (short s = 0; s < base.length(); s++) {
            char c = base.charAt(s);
            if (!uniqueChars.toString().contains(Character.toString(c).toLowerCase())) {
                uniqueChars.append(Character.toString(c).toLowerCase());
            }
        }
        return uniqueChars.toString();
    }

    private static <T extends Comparable<T>> void quicksort(T[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            quicksort(arr, low, index - 1);
            quicksort(arr, index + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T current = arr[high];
        int index = low - 1;
        for (int i = low; i <= high - 1; i++) {
            if (arr[i].compareTo(current) < 0) {
                index++;
                T tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
        T tmp = arr[index + 1];
        arr[index + 1] = arr[high];
        arr[high] = tmp;
        return index + 1;
    }

}
