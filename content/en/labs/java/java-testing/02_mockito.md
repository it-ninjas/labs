---
title: "Mockito - Aufgaben"
linkTitle: "Mockito - Aufgaben"
type: docs
weight: 2
description: >
  Aufgaben zu Modul #J4 - Testing / Mockito
---

Eine Wörterbuch-Anwendung bewahrt die Einträge in einer Datenbank.
Die Interaktion mit der Datenbank wird durch ein DictionaryRepository umgesetzt.

Ein DictionaryRepository setzt folgendes Interface um:
```java
public interface DictionaryRepository {
    
    /**
     * Die Methode erhält ein Wort und die Definition dazu und speichert diese als Eintrag in der Datenbank
     * 
     * @Param word          das Wort, welche in dem Wörterbuch hinzugefügt werden soll
     * @Param definition    die Definition des Wortes
     * */
    void add(String key, String value);

    /**
     * Die Methode aktualisiert die Definition des Wortes in der Wörterbuch-Datenbank
     *
     * @Param word          das Wort, welche in dem Wörterbuch bereits existiert
     * @Param definition    die aktualisierte Definition des Wortes
     * */
    void update(String key, String value);

    /**
     * Die Methode liefert die Definition für das gegebene Wort aus der Wörterbuch-Datenbank zurück.
     *
     * @Param word      das Wort, dessen Definition gesucht wird
     * @Return          die Definition des Wortes aus der Wörterbuch-Datenbank, falls vorhanden, ansonsten null
     * */
    String getDefinition(String word);
}
```

Die Klasse _Dictionary_ beinhaltet die Business-Logik des Wörterbuchs und verwendet ein _DictionaryRepository_,
um die Einträge in der Datenbank zu speichern und zu finden:

```java
public enum DictionaryStatus {
    ADDED,
    UPDATED,
    INVALID,
    NOT_FOUND
}

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
     * @Return              DictionaryStatus.ADDED falls das Wort neu ist, DictionaryStatus.UPDATED falls das Wort
     * bereits vorhanden war und DictionaryStatus.INVALID, falls das Wort ein leerer String ist oder Zahlen beinhaltet
     * */
    public DictionaryStatus addOrUpdateWord(String word, String definition) {
        //TODO gemäss JavaDoc umsetzen
    }

  /**
   * Die Methode sucht nach der Definition des gegebenen Worts.
   * Falls das Wort existiert, wird die Definition zurückgeliefert und ansonsten einen
   * Text, welcher darauf hinweist, dass das Wort nicht vorhanden ist.
   *
   * @Param word    das Wort, dessen Definition gesucht wird
   * @Return        die Definition des Wortes, falls das Wort im Wörterbuch existiert. Ansonsten folgenden Text:
   * "Das Wort xxx konnte im Wörterbuch nicht gefunden werden" (xxx steht als Platzhalter für das gesuchte Wort)
   * */
    public String getDefinition(String word) {
        //TODO gemäss JavaDoc umsetzen
    }
}
```

#### Aufgabe
Schreibe eine Test-Klasse für _Dictionary_, welche folgende Tests beinhaltet:
* Tests der Methode _addOrUpdateWord_:
  * Das Wort befindet sich noch nicht in der Datenbank
  * Das Wort befindet sich bereits in der Datenbank
  * Das Wort ist ein leerer String
  * Das Wort beinhaltet Zahlen
* Tests der Methode _getDefinition_:
  * Das gesuchte Wort existiert in der Datenbank
  * Das gesuchte Wort existiert nicht in der Datenbank
  * Das gesuchte Wort is ungültig: leerer String
  * Das gesuchte Wort is ungültig: das Wort beinhaltet Zahlen

**Anforderungen**
* Schreibe jeweils einen Test und erweitere den Code dann nur soweit bis der Test grün ist. Wiederhole dies für alle Tests (die bestehende Tests müssen weiterhin funktionieren!).
* Der Interface _DictionaryRepository_ darf nicht umgesetzt werden. Für die Tests wird ein Mock oder ein Spy aus dem Mockito-Framework verwendet.
* Jede Test-Methode hat folgendes Namensschema:
  ```java
  public void given_when_then() {
      ...
  }
  ```
  Wobei:
  * **given** die Ausgangslage definiert
  * **when** ist der Name der Methode, welche getestet wird
  * **then** ist das Ergebnis, welche erwartet wird
* Jede Test-Methode prüft, dass alle Methoden eines Mocks/Spy's welche aufgerufen werden müssen, auch aufgerufen wurden.
* Jede Test-Methode prüft, dass alle Methoden eines Mocks/Spy's welche NICHT aufgerufen werden sollen, auch nicht aufgerufen wurden.

---
Hier kannst du [zurück zur Theorie](../../../../docs/java/java-testing/#mockito).