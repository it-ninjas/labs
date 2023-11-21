package exceptionhandeling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordAnalyzerImpl implements WordAnalyzer {
    private final String filename;

    public WordAnalyzerImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public int countWords() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int countWordsWithLetterQ() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("q")) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Set<Character> getUniqueSpecialCharacters() {
        Set<Character> specialCharacters = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                        specialCharacters.add(c);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specialCharacters;
    }

    @Override
    public Map<Character, Integer> getLetterFrequenciesMap() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char lowercaseC = Character.toLowerCase(c);
                        frequencyMap.put(lowercaseC, frequencyMap.getOrDefault(lowercaseC, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return frequencyMap;
    }

    @Override
    public Map<Integer, List<String>> groupWordsByLength() {
        Map<Integer, List<String>> wordGroups = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.trim();
                    int wordLength = word.length();
                    wordGroups.computeIfAbsent(wordLength, k -> new ArrayList<>()).add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordGroups;
    }
}
