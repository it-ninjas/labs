---
title: "LinkedList - Aufgaben"
linkTitle: "LinkedList"
type: docs
weight: 7
description: >
  Aufgaben zu [Java Collections - LinkedList](../../../docs/02_java/08_java-collections/07_linked-list)
---

## Aufgabe 1

Du hast eine Playlist mit 5 Liedern, die in einer LinkedList gespeichert ist und wie folgt vordefiniert ist:

```java
 LinkedList<String> songList = new LinkedList<>(Arrays.asList(
            "Bohemian Rhapsody",
            "Stairway to Heaven",
            "Hotel California",
            "Imagine",
            "Hey Jude"
        ));
```

Nun sollen verschiedene Aktionen mit der Playlist vorgenommen werden.

1. Entferne den ersten Song in der Playlist.
2. Füge den Song "Blinding Lights" in der Mitte der Playlist ein.
3. Ersetze den letzten Song mit "Smells Like Teen Spirit".

Schreibe anschliessend die Playlist in die Konsole. Vom Format her sollte die Ausgabe so aussehen:

```java
[Stairway to Heaven, Hotel California, Blinding Lights, Imagine, Smells Like Teen Spirit]
```

Um dieses Format zu erhalten, kannst du die Methode `toString()` auf deiner LinkedList aufrufen.

> **Ausgabe überprüfen**
> Verwende wieder die kleine Hilfsklasse [`OutputValidation`](https://github.com/it-ninjas/code/blob/main/helper/src/main/java/ch/itninjas/validator/OutputValidation.java) zum Verifizieren des Konsolen-Outputs.
> Der Konsole-Output Hash für diese Aufgabe ist: **`-642408310`**
