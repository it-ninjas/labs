---
title: "Methoden"
linkTitle: "Methoden"
weight: 8
description: >
  In diesem Modul lernst du, wie du Methoden in Java definierst, Parameter übergibst und Rückgabewerte nutzt.
---

{{< module "J1" >}}

## Ziele

- Ich weiss, wofür Methoden da sind.
- Ich kenne den Aufbau einer Methode.
- Ich weiss, wie Parameter an eine Methode übergeben werden.
- Ich weiss, wie eine Methode einen Wert zurückgibt.
- Ich kann Methoden gezielt in meinem Programm einsetzen.

{{< zeit lesen="15" >}}

## Was sind Methoden?

In Java sind Methoden benannte Codeblöcke, die eine bestimmte Aufgabe ausführen. Sie helfen, Programme besser zu
strukturieren und wiederverwendbaren Code zu schreiben.

{{< ninja info >}}
Wenn du die bisherigen Aufgaben anschaust, welche du gelöst hast, wirst du feststellen, dass dort deine Anpassungen
immer in einem benannten CodeBlock war. Du hast also schon die ganze Zeit Methoden angepasst und benutzt.
{{< /ninja>}}

Methoden ermöglichen:

- das Bündeln von Anweisungen zu einer klaren Funktionalität
- das Ausführen dieser Funktionalität durch einen einfachen Aufruf
- eine saubere Trennung einzelner Aufgaben im Programm

## Aufbau einer Methode

Eine Methode besteht aus einem Methodenkopf und einem Rumpf:

```java
public static Rückgabetyp methodName(Parameterliste) {
    // Anweisungen
}
```

- **public static**: Gibt an, dass die Methode überall und immer genutzt werden darf (darauf gehen wir später genauer
  ein)
- **Rückgabetyp**: Gibt an, welcher Datentyp zurückgegeben wird (`int`, `String`, …). Wird nichts zurückgegeben, nutzt
  man `void`.
- **methodName**: Der Name der Methode – über diesen wird sie aufgerufen.
- **Parameterliste**: Liste von Eingabewerten, die die Methode beim Aufruf erwartet.
- **Anweisungen**: Der Code, der ausgeführt wird, wenn die Methode aufgerufen wird.

## Methoden mit Parametern

Methoden können Parameter (Eingabewerte) erwarten:

```java
public static void greetUser(String name) {
    System.out.println("Hallo, " + name + "!");
}
```

Diese Methode erhält einen `String`-Parameter `name` und gibt eine Begrüssung aus.

{{< video "https://www.youtube.com/watch?v=oSDtCcDXcTM" "YouTube, Methoden einfach erklärt">}}

## Methoden ohne Parametern

Methoden können auch ohne Parameter definiert werden:

```java
public static void sayGoodBye() {
    System.out.println("Good Bye!");
}
```

Diese Methode hat keinen Parameter und gibt einfach einen Text aus.

## Methoden mit Rückgabewert

Methoden können auch Werte zurückgeben:

```java
public static int add(int a, int b) {
    return a + b;
}
```

Diese Methode addiert zwei Zahlen und gibt die Summe zurück.

Du kannst diese Methode so aufrufen:

```java
int result = add(17, 10); // Variable result will be 27 afterwards
```

---

{{< video "https://www.youtube.com/watch?v=qQ79aq7HZ-U" "YouTube, Methoden mit Rückgabewert" >}}

---

## Methoden ohne Rückgabewert (`void`)

Wenn eine Methode **keinen Wert zurückgeben soll**, verwendest du den Rückgabetyp `void`.

Solche Methoden führen Anweisungen aus, ohne ein Ergebnis an den Aufrufer zurückzugeben – z. B. eine Ausgabe oder das
Setzen eines Wertes.

```java
public static void greet() {
    System.out.println("Hallo!");
}
```

Du kannst diese Methode so aufrufen:

```java
greet();
```

## Wozu brauche ich Methoden?

Methoden bringen viele Vorteile:

- **Wiederverwendbarkeit**: Einmal schreiben, beliebig oft nutzen.
- **Reduktion von Code-Duplikaten**: Weniger Fehler, einfachere Wartung.
- **Lesbarkeit**: Durch sprechende Namen versteht man den Code schneller.
- **Strukturierung**: Jede Methode übernimmt eine klar abgegrenzte Aufgabe.

## Beispiel: Division ohne Methoden

Ohne Methoden wiederholen sich Prüfungen und Ausgaben:

```java
public static void main(String[] args) {
    Random random = new Random();

    int a = random.nextInt(11);
    int b = random.nextInt(11);
    int c = random.nextInt(11);

    if (b != 0) {
        int result1 = a / b;
        if (c != 0) {
            int result2 = result1 / c;
            System.out.println("Ergebnis: " + result2);
        } else {
            System.out.println("Division durch 0 nicht erlaubt.");
        }
    } else {
        System.out.println("Division durch 0 nicht erlaubt.");
    }
}
```

⚠️ Gleicher Code mehrfach und verschachtelte Blöcke → schlecht wartbar.

## Beispiel: Division mit Methoden

Eleganter und übersichtlicher mit einer Methode:

```java
public static void main(String[] args) {
    Random random = new Random();

    int a = random.nextInt(11);
    int b = random.nextInt(11);
    int c = random.nextInt(11);

    int result1 = divide(a, b);
    int result2 = divide(result1, c);

    System.out.println("Ergebnis: " + result2);
}

public static int divide(int numerator, int denominator) {
    if (denominator == 0) {
        System.out.println("Division durch 0 nicht erlaubt.");
        return 0;
    }
    return numerator / denominator;
}
```

✅ Nur eine zentrale Prüfung  
✅ Verständlicher Code  
✅ Wiederverwendbare Methode

## Namenskonventionen für Methoden und Parameter

### Methoden

Beim Benennen von Methoden beachtest du folgende Regeln:

- Der Name beginnt mit einem **Kleinbuchstaben**.
- Er besteht aus mehreren sinnvollen Wörtern im **camelCase** (z. B. `calculateTotal`).
- Der Name beschreibt eine **Aktion oder Aufgabe** (z. B. `printText`, `getUserName`).
- Vermeide Abkürzungen, ausser sie sind allgemein verständlich (z. B. `id`, `url`).
- Parameter sind benannte Eingabewerte von Methoden. Für sie gelten
  [**die gleichen Regeln wie bei Variablen**](../02_variables/#namenskonventionen-für-variablen)

Beispiele:

```java
public static void calculateTaxes(double income) { ... }
public static String formatDate(LocalDate date) { ... }
public static void printReport(String title, int pageCount) { ... }
```

{{< ninja info >}}
Die Regeln zur Benennung von Methoden und Parametern sind Teil unserer **Coding Guidelines**. Du findest die vollständige
Richtlinie für Java [hier](../../../99_tools/zusammenarbeit/guidelines/coding/java/).
{{< /ninja >}}

## Rekursive Methoden

Eine Methode kann **sich selbst aufrufen** – das nennt man **Rekursion**.  
Das ist besonders hilfreich, wenn sich ein Problem in gleichartige Teilprobleme zerlegen lässt.

Beispiel: Fakultät berechnen (`n! = n * (n-1) * (n-2) * ... * 1`)

```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

Ablauf bei `factorial(3)`:

```
→ factorial(3)
→ 3 * factorial(2)
→ 3 * 2 * factorial(1)
→ 3 * 2 * 1 → ergibt 6
```

{{< ninja tip >}}
Jede Rekursion braucht eine **Abbruchbedingung**, sonst ruft sich die Methode endlos selbst auf – und das führt zu einem
Fehler ("Stack Overflow").

Vielleicht erinnerst du dich noch an die Erklärung von Stack und Heap. Der Stack wird benutzt, um Parameter an eine
Methode zu übergeben. Sie bleiben dort, bis die Methode zurückkehrt. Bei Rekursion kommen immer wieder neue Parameter
auf den Stack, ohne dass sie wieder freigegeben werden. Das führt dann innert kurzer Zeit dazu, dass es keinen Platz
mehr auf dem Stack hat und es zum sogenannten "Stack Overflow" kommt. Es können dann keine Methoden mehr aufgerufen
werden und das Programm wird beendet.
{{< /ninja >}}

## Aufruf fremder Methoden

Methoden werden immer einer "Klasse" zugeordnet:

```java
public class EineKlasse {

    public static void eineMethode() {
        System.out.println("Ich mach mal was...");
    }
}
```

In anderen Methoden in derselben "Klasse" können sie direkt aufgerufen werden:

```java
public class EineKlasse {

    public static void eineMethode() {
        System.out.println("Ich mach mal was...");
    }

    public static void eineAndereMethode() {
        eineMethode();
        System.out.println("... und mach noch was anderes.");
    }
}
```

Der Name einer Methode muss innerhalb der gleichen Klasse eindeutig sein:

```java
public class EineKlasse {

    public static void eineMethode() {
        System.out.println("Ich mach mal was...");
    }

    public static void eineMethode() {  // <- Compiler-Error... 2 Methoden mit gleichem Namen
        eineMethode();
        System.out.println("... und mach noch was anderes.");
    }
}
```

Ist die Methode in einer anderen "Klasse", muss man den Namen der Klasse angegen:

```java
public class EineKlasse {

    public static void eineAndereMethode() {
        EineAndereKlasse.eineMethode();
        System.out.println("... und mache noch was anderes.");
    }
}

public class EineAndereKlasse {

    public static void eineMethode() {
        System.out.println("Ich mache AUCH was...");
    }

    public static void eineAndereMethode() {
        eineMethode();
        System.out.println("... und mache noch was anderes.");
    }
}

```

{{< ninja info >}}
Ist die Methode in einer anderen "Klasse", darf der Name gleich sein. Durch den Namen der "Klasse" ist immer klar, welche
Methode aufgerufen werden soll. Ist keine "Klasse" angegeben, wird immer die Methode aus derselben "Klasse" genommen.
{{< /ninja >}}

## Lokale und statische Variablen

Bis jetzt hast du Variablen immer innerhalb einer Methode genutzt. Die bezeichnet man genau genommen als lokale Variablen.

- **Lokale Variablen** werden innerhalb einer Methode deklariert und existieren nur während der Ausführung dieser Methode.
- **Statische Variablen** gehören zur Klasse und behalten ihren Wert zwischen mehreren Methodenaufrufen.

Beispiel:

```java
public class Demo {
    private static int calls = 0; // statische Variable

    public static void sayHello() {
        calls = calls + 1;        // Zugriff auf die statische Variable
        String message = "Hallo"; // lokale Variable
        System.out.println(message + " #" + calls);
    }
}
```

In diesem Beispiel:

`message` ist eine lokale Variable: Sie existiert nur innerhalb von sayHello() und wird bei jedem Aufruf neu erstellt.

`calls` ist eine statische Variable: Sie merkt sich, wie oft die Methode aufgerufen wurde – auch über mehrere Aufrufe hinweg.

---

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/08_methods/)" >}}
