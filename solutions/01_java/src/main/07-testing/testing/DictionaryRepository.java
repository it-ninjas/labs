package testing;

public interface DictionaryRepository {

    /**
     * Die Methode erhält ein Wort und die Definition dazu und speichert diese als Eintrag in der Datenbank
     *
     * @Param word          das Wort, welche in dem Wörterbuch hinzugefügt werden soll
     * @Param definition    die Definition des Wortes
     */
    void add(String key, String value);

    /**
     * Die Methode aktualisiert die Definition des Wortes in der Wörterbuch-Datenbank
     *
     * @Param word          das Wort, welche in dem Wörterbuch bereits existiert
     * @Param definition    die aktualisierte Definition des Wortes
     */
    void update(String key, String value);

    /**
     * Die Methode liefert die Definition für das gegebene Wort aus der Wörterbuch-Datenbank zurück.
     *
     * @Param word      das Wort, dessen Definition gesucht wird
     * @Return die Definition des Wortes aus der Wörterbuch-Datenbank, falls vorhanden, ansonsten null
     */
    String getDefinition(String word);
}