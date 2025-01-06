---
title: "Java Grundlagen Challenge"
linkTitle: "Java Grundlagen Challenge"
type: docs
weight: 1
description: >
  Challenge zu Modul #J1
---

Die Aufgabe besteht darin ein "Vier-Gewinnt" Spielfeld in Form eines zweidimensionalen Arrays zu überprüfen.
Das zweidimensionale Array hat in beiden Dimensionen eine variable Grösse. Die zweite Dimension ist jedoch bei allen Arrays gleich gross.

Das Ziel ist herauszufinden, ob auf einem gegebenen Spielfeld einer der Spieler gewonnen hat.
Die Gewinnkombination in Form von vier aufeinanderfolgenden gleichen Feldern kann dabei horizontal, vertikal oder diagonal auf dem Spielfeld liegen.
Im Spielfeld kommen drei Zeichen vor: "X" für Spielsteine von Spieler 1, "O" für Spielsteine von Spieler 2 und " " für ein Feld, wo noch kein Spielstein liegt.

Die Methode, welche das Spielfeld überprüft liefert einen String als Rückgabewert zurück.
Der Rückgabewert ist "X" falls Spieler 1 gewonnen hat, "O" wenn Spieler 2 gewonnen hat und " " wenn noch keiner der Spieler eine Gewinnkombination hat.

Die Implementation muss in der folgenden Klasse gemacht werden:

```java
public class ConnectFourExtra implements ConnectFourCheck {
    @Override
    public String checkWin(String[][] board) {
        // TODO: Implementation here ...

        // TODO: Change return value according to the challenge description
        return " " + "X" + "O";
    }
}
```

Das dazugehörige Interface kann einfach als neue Klasse im gleichen Package angelegt werden:

```java
interface ConnectFourCheck {
    String checkWin(String[][] board);
}
```

Wenn du an der Challenge teilnehmen willst, dann musst du die Aufgabe alleine lösen.
Die Lösung vom Pult-Nachbar interessiert uns also (leider) nicht.
