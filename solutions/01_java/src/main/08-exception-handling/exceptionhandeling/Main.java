package exceptionhandeling;

public class Main {
    public static void main(String[] args) {
        WordAnalyzer wordAnalyzer = new WordAnalyzerImpl("src/main/08-exception-handling/wordList.txt");
        System.out.println(wordAnalyzer.countWords());
        System.out.println(wordAnalyzer.countWordsWithLetterQ());
        System.out.println(wordAnalyzer.getUniqueSpecialCharacters());
        System.out.println(wordAnalyzer.getLetterFrequenciesMap());
        // this method works but is kinda ugly in the console xD
//        System.out.println(wordAnalyzer.groupWordsByLength());

        Logger logger = new Logger();
        logger.logText("Hans mag Peter, dass aber erst später");
        logger.logText("Jetzt ist es später, also mag Peter auch Hans");
    }
}
