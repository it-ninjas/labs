package exceptionhandeling;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface WordAnalyzer {
    int countWords();

    int countWordsWithLetterQ();

    Set<Character> getUniqueSpecialCharacters();

    Map<Character, Integer> getLetterFrequenciesMap();

    Map<Integer, List<String>> groupWordsByLength();
}

