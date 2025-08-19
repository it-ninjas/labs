---
title: "Scanner"
linkTitle: "Scanner"
weight: 15
description: >
  In diesem Modul lernst du, wie man mit der Scanner-Klasse Eingaben von der
  Konsole liest und in Variablen speichert.
---

## Ziele

- Ich kann eine Eingabe von der Konsole lesen und in einer Variablen speichern.

{{< zeit lesen="10" >}}

## Scanner

Um Benutzereingaben in Java vorzunehmen, kann die `Scanner`-Klasse verwendet
werden. Dazu wird sie zuerst importiert und danach ein Objekt erstellt:

```java
import java.util.Scanner;

public class TakeInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Your name is: " + name);
    }
}
```

### Erklärung zum Code

- **Zeile 1:**  
  Die `Scanner`-Klasse stammt aus dem Paket
  [java.util](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/package-summary.html).
  Damit sie im Programm verwendet werden kann, muss sie importiert werden.

- **Zeile 5:**  
  Wir deklarieren eine Variable mit dem Datentyp `Scanner` und dem Namen
  `scanner`. Anschliessend erstellen wir ein neues Objekt, das den
  Eingabestream `System.in` (Tastatureingaben) nutzt.

- **Zeile 7:**  
  Wir deklarieren eine Variable `name` vom Typ `String`. Ihr wird der Rückgabewert
  der Methode `scanner.nextLine()` zugewiesen.  
  Diese Methode liest die gesamte Zeile ein, die der Benutzer in die Konsole
  eingibt, und liefert sie als `String` zurück, sobald Enter gedrückt wird.

---

## Zahlen einlesen

Häufig möchtest du Zahlen von der Konsole einlesen. Dafür bietet `Scanner`
passende Methoden an:

```java
System.out.print("Enter an integer: ");
int number = scanner.nextInt();
```

Die Methode `nextInt()` liest die nächste Zahl und liefert sie als `int`
zurück.

{{< ninja warning>}}
**Wichtig:**  
`nextInt()` hat eine Eigenheit: Das gedrückte Enter nach der Zahl wird nicht
automatisch verarbeitet. Wenn du danach `nextLine()` aufrufst, bekommst du
einen leeren String zurück. Um dieses Verhalten zu umgehen, rufst du nach
`nextInt()` einfach ein zusätzliches `nextLine()` auf.

Für die Labs und das Exam im Modul #J1 kannst du `nextInt()` gut verwenden.
Spiele aber ruhig ein wenig damit, um die Eigenheiten selbst kennenzulernen.
{{< /ninja>}}

---
