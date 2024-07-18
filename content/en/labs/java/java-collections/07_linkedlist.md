---
title: "LinkedList - Aufgaben"
linkTitle: "LinkedList"
type: docs
weight: 7
description: >
  Aufgaben zu [Java Collections - LinkedList](../../../../docs/java/java-collections/07_linked_list)  
---

## Aufgabe 1
Du hast eine Playlist mit 5 Liedern, die in einer LinkedList gespeichert ist und wiefolgt vordefiniert ist:
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
1. Entfehrne den ersten Song in der Playlist.
2. Füge den Song "Blinding Lights" in der Mitte der Playlist ein.
2. Ersetze den letzten Song mit "Smells Like Teen Spirit".

Schreibe anschliessend die Playlist in die Konsole. Vom Format her sollte die Ausgabe so aussehen:

```java
[Stairway to Heaven, Hotel California, Blinding Lights, Imagine, Smells Like Teen Spirit]
```
Um dieses Format zu erhalten, kannst du die Methode `toString()` auf deiner LinkedList aufrufen.

> **Ausgabe überprüfen**  
> Der Konsole-Output Hash für diese Aufgabe ist: **`-642408310`**