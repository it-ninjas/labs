package testing;

public class Dictionary {
    private final DictionaryRepository repository;

    public Dictionary(DictionaryRepository repository) {
        this.repository = repository;
    }

    /**
     * Die Methode schreibt eine Definition für ein Wort in der Wörterbuch-Datenbank.
     * Zuerst wird geschaut, ob das Wort in der Datenbank bereits existiert.
     * Falls das Wort noch nicht existiert, wird einen neuen Eintrag in der Datenbank erstellt.
     * Falls das Wort bereits existiert, wird seine Definition aktualisiert.
     *
     * @Param word          das Wort, welche in dem Wörterbuch hinzugefügt oder aktualisiert werden soll
     * @Param definition    die Definition des Wortes
     * @Return DictionaryStatus.ADDED falls das Wort neu ist, DictionaryStatus.UPDATED falls das Wort
     * bereits vorhanden war und DictionaryStatus.INVALID, falls das Wort ein leerer String ist oder Zahlen beinhaltet
     */
    public DictionaryStatus addOrUpdateWord(String word, String definition) {
        if (word == null || word.isEmpty() || containsNumbers(word)) {
            return DictionaryStatus.INVALID;
        }

        String existingDefinition = repository.getDefinition(word);

        if (existingDefinition == null) {
            repository.add(word, definition);
            return DictionaryStatus.ADDED;
        } else {
            repository.update(word, definition);
            return DictionaryStatus.UPDATED;
        }
    }

    /**
     * Die Methode sucht nach der Definition des gegebenen Worts.
     * Falls das Wort existiert, wird die Definition zurückgeliefert und ansonsten einen
     * Text, welcher darauf hinweist, dass das Wort nicht vorhanden ist.
     *
     * @Param word    das Wort, dessen Definition gesucht wird
     * @Return die Definition des Wortes, falls das Wort im Wörterbuch existiert. Ansonsten folgenden Text:
     * "Das Wort xxx konnte im Wörterbuch nicht gefunden werden" (xxx steht als Platzhalter für das gesuchte Wort)
     */
    public String getDefinition(String word) {
        String definition = repository.getDefinition(word);

        if (definition == null) {
            return "Das Wort " + word + " konnte im Wörterbuch nicht gefunden werden";
        } else {
            return definition;
        }
    }

    private boolean containsNumbers(String str) {
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}