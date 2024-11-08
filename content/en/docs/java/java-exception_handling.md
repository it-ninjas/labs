---
title: "Exception Handling"
linkTitle: "Exception Handling (und Optionals)"
weight: 8
description: >
  Modul #J5 - Exception Handling und Optionals
---

## Ziele

- Ich kenne die Schlüsselwörter `try`, `catch`, `finally`, `throw` und `throws`.
- Ich weiss, was "Unchecked" und "Checked" Exceptions sind.
- Ich kann auftretende Exceptions behandeln.
- Ich kann eigene Exceptions definieren und anwenden.
- Ich kenne Multicatch und Try-With-Resources und kann die beiden Konstrukte anwenden.
- Ich kenne die beiden Interfaces `AutoCloseable` und `Closeable`.
- Ich kenne eine Möglichkeit, um anzugeben, dass bestimmte Werte "nullable" bzw. nicht "nullable" sind.
- Ich verstehe, wie `Optional` meinen Code sicherer gegenüber `null`-Werten macht.

## Theorie / Einleitung

In jeder Applikation können erwartete oder unerwartete Fehler auftreten.
In Java werden solche Fehler durch das Exception Handling abgefangen.
Ziel des Exception Handlings ist es, durch gezieltes Behandeln von auftretenden Exceptions, Abstürze der Anwendung zu verhindern.
Jeder Softwareentwickler sollte sich bewusst sein, dass unbehandelte Exceptions eine Anwendung jederzeit beenden können.

In Java unterscheidet man zwischen zwei Arten von Fehlern:

- **Error**: Dies sind nicht reparierbare Laufzeitfehler oder Hardware-Probleme, die zum Absturz des Programms führen.
- **Exception**: Dies sind Fehler oder unvorhergesehene Ereignisse, die während der Programmausführung auftreten und den normalen Ablauf stören.

Eine Java-Applikation sollte nicht versuchen, **Errors** abzufangen, da diese Fehler in der Regel aufgrund abnormaler Bedingungen (wie z. B. zu wenig Speicher) auftreten und unter normalen Umständen nicht behoben werden können.
**Exceptions** hingegen sind unerwartete Fehler, auf die das Programm reagieren muss.

Innerhalb des Java Exception Handling unterscheiden wir zwei Arten von Exceptions:

- **Unchecked Exceptions**: Laufzeitfehler, die vom Compiler nicht erkannt werden.
- **Checked Exceptions**: Fehler, die vom Compiler zur Kompilierungszeit erkannt werden.

_Unchecked Exceptions_ sind oft Fehler, welche bei der Implementation übersehen werden.
Der häufigste Laufzeitfehler ist die `NullPointerException`. Diese kann erst zur Laufzeit auftreten,
da nur zur Laufzeit Objekte erzeugt werden und damit eine Referenz überhaupt `null` sein kann.  
Die einzige Möglichkeit, Laufzeitfehler abzuhandeln, ist "Safe Programming". Das heisst, dass wir während der Implementation
Prüfungen und sog. "Guards" im Code einbauen (z.B. prüfen, ob eine Referenz nicht `null` ist bevor wir darauf zugreifen) um sicherzustellen,
dass solche Situationen zur Laufzeit nicht auftreten.

**Checked Exceptions** müssen entweder am Ort des Auftretens abgefangen oder an den Aufrufer der Methode weitergegeben werden.
Dadurch wird die Verantwortung zur Behandlung der Exception an den Aufrufer weitergegeben.

Dazu ein kleines Beispiel:

```java
public static void main(String[] args) {
    PhoneBook phoneBook = new PhoneBook();
    Person person = phoneBook.findByPhoneNumber("079 654 32 10");
    System.out.println(person.getName());
}
```

Ohne die Implementierung der Methode `findByPhoneNumber` zu kennen, muss ein Softwareentwickler das zurückgelieferte Objekt vom Typ `Person` zunächst auf `null` prüfen.
Schauen wir uns daher die Implementierung dieser Methode genauer an:

```java
public class PhoneBook {
    private List<Person> entries = new ArrayList<>();

    public Person findByPhoneNumber(String number) {
        for (Person p: this.entries) {
            if (p.getPhoneNumber().equals(number)) {
                return p;
            }
        }
        return null;
    }
}
```

Wie (vielleicht) erwartet, liefert die Methode `null` zurück, falls kein Eintrag mit der gesuchten Nummer gefunden wird.
Dies führt in der Main-Methode im obigen Code auf der letzten Zeile zu einer `NullPointerException`, da die Referenz `person` auf `null` zeigt.
Ein einfaches `if`-Statement kann hier Abhilfe schaffen:

```java
public static void main(String[] args) {
   AddressBook addressBook = new AddressBook();
   Person person = addressBook.findByPhoneNumber("079 654 32 10");
   if (person != null) {
       System.out.println(person.getName());
   }
}
```

Der Laufzeitfehler kann nun nicht mehr auftreten. Es stellt sich jedoch die Frage, ob diese Lösung zufriedenstellend ist.
Prinzipiell sollten wir zumindest informiert werden, wenn keine Person mit dieser Nummer gefunden wird.
Eine Möglichkeit besteht darin, ein `else`-Statement hinzuzufügen:

```java
public static void main(String[] args) {
    AddressBook addressBook = new AddressBook();
    Person person = addressBook.findByPhoneNumber("079 654 32 10");
    if (person != null) {
        System.out.println(person.getName());
    } else {
        System.out.println("Es wurde keine Person mit dieser Nummer gefunden!");
    }
}

```

Eine alternative Lösung könnte darin bestehen, das Null-Object-Pattern oder ein `Optional`-Objekt zu verwenden, um ein gültiges Objekt anstelle von `null` zurückzugeben.

---

## try / catch / finally

Um eine **Checked Exception** zu behandeln, muss der Codeblock, der die Exception erzeugen könnte, innerhalb eines `try`-Blocks stehen.
Der Exception-Typ, der abgefangen werden soll, wird in den zugehörigen `catch`-Block geschrieben:

```java
try {
    // Code, welcher eine IOException werfen könnte
} catch (IOException e) {
    // Code zur Behandlung der IOException
}
```

Ein `try`-Statement kann beliebig viele `catch`-Blöcke haben:

```java
try {
    FileReader fileReader = new FileReader("nonexistent.txt");
    // Hier würde noch Code kommen, welcher vom File lesen würde.
} catch (FileNotFoundException e) {
    // Hier wird nun die FileNotFoundException gehandhabt
    System.err.println("File not found: " + e.getMessage());
} catch (IOException e) {
    System.err.println("Error reading from file: " + e.getMessage());
}
```

Bei mehreren `catch`-Blöcken muss die spezifischste Exception stets zuerst stehen.
Je weiter unten der `catch`-Block steht, desto allgemeiner ist die Exception, die abgefangen wird.
Der Grund dafür ist, dass alle Checked Exceptions von der Klasse `Exception` abgeleitet sind.
Befindet sich eine allgemeinere Exception weiter oben, wird der `catch`-Block der spezifischeren Exception weiter unten nicht mehr erreichbar sein.

```java
try {
    // Code, der eine Ausnahme auslösen könnte
    int[] zahlen = {1, 2, 3};
    System.out.println(zahlen[5]); // Dies wird eine ArrayIndexOutOfBoundsException auslösen
} catch (ArrayIndexOutOfBoundsException e) { // Spezifische Ausnahme
    System.out.println("Spezifische Ausnahme abgefangen: ArrayIndexOutOfBoundsException");
} catch (Exception e) { // Allgemeinere Ausnahme
    System.out.println("Allgemeine Ausnahme abgefangen: Exception");
}
```

Ein `try`-Block (ob mit oder ohne `catch`-Block) kann zusätzlich einen `finally`-Block haben.
Der `finally`-Block wird nach der Bearbeitung der Exception ausgeführt.
Falls keine Exception aufgetreten ist, wird der Code im `finally`-Block direkt nach dem `try`-Block ausgeführt.

```java
try {
    // Code, welcher eine IOException werfen könnte
} catch (IOException e) {
    // Code für die Abhandlung der IOException
} finally {
    // Code, welcher nach der Abhandlung der Exception ausgeführt werden soll
}
```

Wie oben erwähnt, kann der `catch`-Block weggelassen werden:

```java
try {
    // Code, welcher eine beliebige Exception werfen könnte
} finally {
    // Code, welcher nach der Abhandlung der Exception ausgeführt werden soll
}
```

Vorsicht bei `return`-Anweisungen innerhalb von `catch`- oder `finally`-Blöcken: Da der `finally`-Block immer zuletzt ausgeführt wird, ist ein `return`-Statement in diesem Block massgeblich für die Funktionalität.

---

## throw / throws

Eine Exception muss nicht immer dort behandelt werden, wo sie auftritt.
Falls die Behandlung in andere Klassen verlagert werden soll, kann mit dem Schlüsselwort `throws` angegeben werden, dass die aufrufende Komponente die Exception abfangen und behandeln muss.

Dazu ein kurzes Beispiel:

```java
public class EntryForbiddenException extends Exception {
    // Optionale Erweiterungen für diese Exception
}
```

```java
public class Saloon {
    public void checkAge(int age) throws EntryForbiddenException {
        if (age < 18) {
            throw new EntryForbiddenException();
        }
        // Zusätzlicher Code ...
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Saloon saloon = new Saloon();
        try {
            saloon.checkAge(15);
        } catch (EntryForbiddenException e) {
            // Behandlung der EntryForbiddenException
        }
    }
}
```

In diesem Beispiel wird die Behandlung in die `main`-Methode verlagert.
Exceptions können über beliebig viele Stufen weitergegeben werden.
Wenn jedoch die "oberste" Stufe (hier die `main`-Methode) die Exception nicht behandelt, wird die Anwendung mit einer entsprechenden Fehlermeldung beendet, da die Exception unbehandelt bleibt.

---

## Umwandlung Laufzeitfehler in Checked Exception

Mit der Lösung aus dem vorherigen Beispiel können wir noch nicht vollständig zufrieden sein.
Anstatt den Rückgabewert der Methode `findByPhoneNumber` auf `null` zu prüfen, wählen wir nun einen anderen Ansatz:

Wir erweitern die Anwendung so, dass die Methode keine `null`-Werte mehr als Rückgabewert liefert.
Da der Compiler jedoch einen Rückgabewert erzwingt, bleibt uns nur die Möglichkeit, eine Exception zu werfen, wenn kein Ergebnis gefunden wird.

Zu diesem Zweck definieren wir zuerst eine entsprechende Exception:

```java
public class PersonNotFoundException extends Exception {
    // Optional: Erweiterungen für die Exception
}
```

Diese Exception wird nun an der entsprechenden Stelle im Code geworfen.
Die Methode wird zusätzlich mit dem Schlüsselwort `throws` versehen:

```java
public class PhoneBook {
    private List<Person> entries = new ArrayList<>();

    public Person findByPhoneNumber(String number) throws PersonNotFoundException {
        for (Person p: this.entries) {
            if (p.getPhoneNumber().equals(number)) {
                return p;
            }
        }
        throw new PersonNotFoundException();
    }
}
```

Beim Aufruf der Methode sind wir nun gezwungen, die Exception zu behandeln:

```java
public static void main(String[] args) {
    AddressBook addressBook = new AddressBook();
    try {
        Person person = addressBook.findByPhoneNumber("079 654 32 10");
        System.out.println(person.getName());
    } catch (PersonNotFoundException e) {
        System.out.println("Es wurde keine Person mit dieser Nummer gefunden!");
        throw new RuntimeException();
    }
}
```

Aus dem ursprünglichen Laufzeitfehler ist nun eine behandelte Exception geworden.
Diese Implementierung vermeidet, wo immer möglich, die Rückgabe von `null`-Werten.

---

## Multi-Catch

Seit Java 7 gibt es die Möglichkeit, mehrere Exceptions in einem sogenannten Multi-Catch zu behandeln.
Schauen wir uns das folgende Beispiel an:

#### Ohne Multi-Catch

```java
 public static void main(String[] args) {
    String filename = "example.txt";
    BufferedReader reader = null;

    try {
        reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        System.err.println("Ein-/Ausgabefehler beim Lesen der Datei: " + e.getMessage());
    } catch (ParseException e) {
        System.err.println("Fehler beim Parsen der Daten: " + e.getMessage());
    } finally {
        reader.close();
    }
}
```

#### Mit Multi-Catch

```java
public static void main(String[] args) {
    String filename = "example.txt";
    BufferedReader reader = null;

    try {
        reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException | ParseException e) {
        System.err.println("Ein-/Ausgabefehler oder Fehler beim Parsen der Daten: " + e.getMessage());
    } finally {
        reader.close();
    }
}
```

Die beiden Exceptions werden hier in einem einzigen `catch`-Block zusammengefasst.
Zu beachten ist, dass die Exceptions innerhalb eines Multi-Catch nicht in einer Vererbungsbeziehung zueinander stehen dürfen.
Das bedeutet, dass ihre Basistypen unterschiedlich sein müssen.

---

## Try-With-Resources

Ebenfalls seit Java 7 gibt es die Möglichkeit für automatisches Ressourcen-Management.  
Betrachten wir dazu zuerst ein Beispiel ohne automatisches Ressourcen-Management:

```java
public static String readFirstLine(String path) {
    BufferedReader br = null;
    try {
        br = new BufferedReader(new FileReader(path));
        return br.readLine();
    } catch (IOException e) {
        // handle or rethrow
    } finally {
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            // ignore
        }
    }
    return "";
}
```

Der `finally`-Block ist notwendig, um die verwendete Ressource des `BufferedReaders` zu schliessen.  
Da beim Schliessen eine `IOException` auftreten kann, benötigen wir im `finally`-Blocks
einen zusätzlichen `try-catch`-Block.

Betrachten wir nun das gleiche Beispiel mit automatischem Ressourcen-Management:

```java
public static String readFirstLine(String path) {
    try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
        return br.readLine();
    } catch (IOException e) {
        // handle or rethrow
    }
    return "";
}
```

Wie wir sehen, entfällt der `finally`-Block zum Schliessen der Ressourcen vollständig.
Die Ressourcen `FileReader` und `BufferedReader` werden automatisch geschlossen.
Dies geschieht im Hintergrund über die Methode `close`, die vom Interface `AutoCloseable` bereitgestellt wird.
In einem `try-with-resources`-Statement dürfen daher nur Objekte verwendet werden, die das genannte Interface implementieren.
Das `Closeable`-Interface stellt dabei die Abwärtskompatibilität zu älteren Java-Versionen sicher, da es ebenfalls die `close`-Methode definiert.
Grundsätzlich sollte das `Closeable`-Interface für IO-Streams verwendet werden, da es mit `IOException` arbeitet.

Das Schliessen der Ressourcen erfolgt immer in umgekehrter Reihenfolge.
In unserem Beispiel wird also zuerst der `BufferedReader` geschlossen und danach der `FileReader`.
Die Verkettung von Ressourcen innerhalb eines `try-with-resources`-Statements sollte vermieden werden. Besser ist die getrennte Deklaration wie im obigen Beispiel.

---

## Null-Safety

Ein häufiger Laufzeitfehler in Java ist die `NullPointerException`. Diese Exception tritt auf, wenn

- eine Methode auf einem `null`-Objekt aufgerufen wird,
- versucht wird, auf ein Feld (Variable) eines `null`-Objekts zuzugreifen.

Oft wird schlicht übersehen, dass eine bestimmte Variable `null` sein könnte:

```java
public static void main(String[] args) {
    method(null);
}

private static void method(String parameter) {
    System.out.println("Länge des Wortes: " + parameter.length());
}
```

Im obigen Beispiel führt der Versuch, die Methode `length()` auf einem null-Objekt aufzurufen, zur `NullPointerException`.

Hier werden zwei typische Ursachen für das Auftreten einer `NullPointerException` deutlich:

- Einer Variable (hier `parameter`) wird `null` zugewiesen/übergeben, was in manchen Fällen unerwartet ist.
- Es wird vergessen zu prüfen, dass eine Variable den Wert `null` haben könnte.

Diese beiden Fälle können in Java auf verschiedene Arten abgefangen werden.

### `null` durch Check abfangen

Die offensichtlichste Möglichkeit, `NullPointerExceptions` zu vermeiden, ist die Verwendung von `null`-Checks.

Im folgenden Beispiel verhindern wir `null`, indem wir die Variable zu Beginn der Methode prüfen und eine `Exception` werfen, falls die Variable `null` ist:

```java
private static void method(String parameter) throws IllegalArgumentException {
    if (parameter == null) {
        throw new IllegalArgumentException("Parameter parameter must not be null.");
    }
    System.out.println("Länge des Wortes: " + parameter.length());
}
```

In diesem Beispiel ist sichergestellt, dass der Wert `null` für das Argument `parameter` nicht erlaubt ist.
Ein Nachteil dieser Lösung ist, dass Entwickler von aussen nicht direkt erkennen können, dass `n`ull-Werte unzulässig sind.
Diesen Fall könnte man stattdessen besser mit einer `@NotNull`-Annotation abdecken, wie später beschrieben.

Manchmal jedoch sollen `null`-Werte zulässig sein. In solchen Fällen verwenden wir Bedingungen, um den richtigen Code auszuführen:

```java
private static void method(String parameter) {
    if (parameter != null) {
        System.out.println("Länge des Wortes: " + parameter.length());
    } else {
        System.out.println("Länge fes Wortes: ist nicht definiert bzw. 0.");
    }
}
```

Um hier `null`-Sicherheit zu garantieren, wurden einige zusätzliche Zeilen eingefügt. In solchen Fällen kann auch der Ternary-Operator nützlich sein:

```java
private static void method(String parameter) {
    System.out.println("Länge des Wortes: "
            + (parameter != null ? parameter.length() : "ist nicht definiert bzw. 0."));
}
```

Der Ternary-Ausdruck ist hierbei der folgende:

```java
parameter != null ? parameter.length() : "ist nicht definiert bzw. 0."
```

Dieser Ausdruck gibt `parameter.length()` zurück, wenn `parameter != null` ist. Ansonsten gibt er den String `"ist nicht definiert bzw. 0."` zurück.

Ganz allgemein ist der Ternary-Ausdruck wie folgt aufgebaut:

```
Bedingung ? Wert-wenn-Bedingung-true : Wert-wenn-Bedingung-false
```

### Annotationen wie `@NotNull` und `@Nullable`

Sicherlich ist dir schon einmal die Angabe `@Nullable` bei einem Argument von einer Methode aus einer externen Library aufgefallen.

Solche Annotationen teilen mit,

- dass bei einer Variable erwartet wird, dass sie unter Umständen auch den Wert `null` haben kann (`@Nullable`)
- bzw. dass eine Variable nicht den Wert `null` aufweisen darf (`@NotNull` bzw. `@NonNull`).

In den folgenden Beispielen verwenden wir die Bibliothek `org.jetbrains.annotations`.
Es gibt jedoch auch andere Bibliotheken mit ähnlichen Annotationen.
Da die Verwendung von Dependencies hier noch nicht behandelt wurde (Maven-Teil), bleibt dies ein theoretischer Hinweis.

Hier ein Beispiel, wie Annotationen zu mehr `null`-Sicherheit führen können:

```java
public static void main(String[] args) {
    method("Lightning Moon", new String[]{"Lightning", "Moon"});
    method(null, null);
}

private static void method(@Nullable String fullName, @NotNull String[] names) {
    System.out.println(fullName.length());

    if (names != null) {
        System.out.println(Arrays.toString(names));
    }
}
```

In diesem Beispiel wird

- die Annotation `@Nullable` verwendet, um mitzuteilen, dass bei der Variable `fullName` der Wert `null` möglich ist. In IntelliJ Idea (von Jetbrains) wird dadurch die Methode `length()` gelb unterstrichen, weil für die Variable `fullName` der `null`-Check fehlt.
- die Annotation `@NotNull` verwendet, um mitzuteilen, dass die Variable `names` <ins>**nicht**</ins> den Wert `null` haben darf. Leider fügt diese Möglichkeit kein Warning beim Aufruf von `method(..., null)` hinzu. Dafür aber wird eine `IllegalArgumentException` zur Laufzeit geworfen, falls ihr `null` beim Methodenaufruf zugewiesen wird.

### Optionals

In Java gibt es auch ohne externe Bibliothek eine Möglichkeit anzugeben, dass eine Variable den Wert `null` „repräsentieren“ kann.
Hierfür wurde die generische Klasse `Optional<T>` eingeführt.

Die Idee dabei ist, dass Variablen, die den Wert `null` haben könnten, den Typ `Optional<...>` erhalten. Ein `nullable` String hätte zum Beispiel den Typ `Optional<String>`:

```java
import java.util.Optional;


public static void main(String[] args) {
    // Richtige Verwendung von Optionals:
    method(Optional.of("Hello World"));     // Repräsentiert den Wert "Hello World".
    method(Optional.empty());               // Repräsentiert den Wert null.

    // Falsche Verwendung von Optionals:
    method(Optional.of(null));              // Null-Pointer, weil `Optional.of()` beim Wert `null` einen Fehler wirft.
    method(null);                           // Null-Pointer, weil `isPresent()` nicht auf `null` aufgerufen werden kann.
}

private static void method(Optional<String> parameter) {
    System.out.println("Länge des Wortes: "
            + (parameter.isPresent() ? parameter.get().length() : "ist nicht definiert bzw. 0."));
}
```

Der Vorteil von `Optional`s ist, dass man als Entwickler:in gezwungen wird, einen `null`-Check zu machen:

```java
if (optional.isPresent()) {
    System.out.println("Wert ist: " + optional.get());
}
```

Denn

- wenn kein `null`-Check vor dem Aufrufen von `.get()` (was den eigentlichen Wert zurückgibt) gemacht wird , dann reklamiert deine Entwicklungsumgebung (IntelliJ/VS Code) automatisch mit einer Warnung.
- wenn `.get()` aufgerufen wird, und der Wert `null` repräsentiert, dann wird bereits an dieser Stelle eine `NullPointerException` geworfen.

Optionals sind daher eine gängige Möglichkeit, Entwickler zu einer Prüfung auf `null` zu verpflichten.

Diese Technik wird z.B. bei Streams häufig eingesetzt:

```java
Optional<Integer> firstResult = Stream
        .of(1, 2, 3, 4, 5)
        .filter(x -> x % 6 == 0)
        .findFirst();

// Die Verwendung des Optionals zwingt einen dazu, den `.isPresent()`-Check zu machen, da es vorkommen könnte,
// dass kein solches Element vorhanden ist, welches die Bedingung erfüllt:

if (firstResult.isPresent()) {
    System.out.println("Erste Zahl aus der 6er-Reihe: " + firstResult.get());
} else {
    System.out.println("Keine Zahl aus der 6er-Reihe präsent.");
}
```

### Zusammenfassung zu Null-Safety

Die `NullPointerException` ist eine der häufigsten Exceptions in Java-Programmen. Deswegen lohnt es sich, besser mit `null`-Werten umzugehen bzw. besser sichtbar zu machen, dass Werte `null` sein können.

Drei der häufigsten Möglichkeiten, um mehr Null-Sicherheit in deinen Code zu bringen, sind:

- `null`-Checks
- Annotationen wie `@NotNull` und `@Nullable`
- und `Optional<...>`-Typen zu verwenden.

## Exceptions testen

Wie regulären Java Code kann man natürlich auch Exceptions mit JUnit testen. Eine ausführliche Erklärung dazu ist [hier](https://www.baeldung.com/junit-assert-exception) zu finden.
Das folgende Beispiel testet anhand `assertThrows()` dass die Methode `testCheckAge()` mit einem Alter unter 18 eine `EntryForbiddenException` wirft.

```java
public class SaloonTest {

    @Test
    public void testCheckAge() {
        Saloon saloon = new Saloon();

        // Testet mit einem Alter unter 18
        int age = 17;
        assertThrows(EntryForbiddenException.class, () -> {
            saloon.checkAge(age);
        });

        // Testet mit dem Alter 18 (sollt keine Exception werfen)
        age = 18;
        try {
            saloon.checkAge(age);
        } catch (EntryForbiddenException e) {
            fail("Unexpected EntryForbiddenException thrown");
        }
    }
}
```

---

## Exceptions: Keine Kontrollstrukturen, sondern Fehlerbehandlung

Nach den Prinzipien von Clean Code sollten Ausnahmen (Exceptions) nicht als normaler Programmfluss eingesetzt werden.
Exceptions dienen dazu, **Ausnahmesituationen** zu behandeln, die unerwartet auftreten und oft nicht durch reguläre Überprüfungen abgefangen werden können, wie z. B. Netzwerk- oder Datenbankfehler.
Wenn Exceptions jedoch als Ersatz für reguläre Kontrollstrukturen (wie if-Abfragen) verwendet werden, wird der Code schwerer lesbar, schlechter wartbar und häufig ineffizienter.

**Warum sollten Exceptions nicht für den Programmfluss genutzt werden?**

- **Lesbarkeit**: Die Verwendung von Exceptions für den Programmfluss macht den Code schwer verständlich, da andere Entwickler erwarten, dass Ausnahmen nur in Fehlerfällen auftreten.
- **Performance**: Exceptions sind in der Regel ressourcenintensiver, da das Erstellen und Verarbeiten von Exception-Objekten zusätzliche Leistung kostet. Das ist besonders problematisch, wenn Exceptions in Schleifen verwendet werden.
- **Debugging**: Der Missbrauch von Exceptions erschwert das Debugging, weil oft unklar ist, ob eine Ausnahme durch einen Fehler oder absichtlich durch eine Programmlogik ausgelöst wurde.
- **Log-Analyse**: Wenn Exceptions für den Programmfluss verwendet werden, kann die Log-Analyse erschwert werden, da die Logs mit unnötigen Ausnahme-Einträgen überflutet werden. Dies macht es schwierig, echte Fehler zu identifizieren, da sich Logs mit Informationen über erwartete oder absichtlich ausgelöste Ausnahmen füllen.

**Beispiel für falsche Verwendung:**

In diesem Beispiel wird eine Exception missbräuchlich zur Kontrolle des Programmflusses verwendet:

```java
try {
    int value = Integer.parseInt("abc"); // Wirft NumberFormatException
} catch (NumberFormatException e) {
    value = 0; // Setzt einen Standardwert
}
```

**Richtige Verwendung:**
Besser ist es, die Eingabe vor der Verarbeitung zu validieren und Exceptions nur für unerwartete Fehler zu nutzen:

```java
String input = "abc";
int value;

if (input.matches("\\d+")) { // Überprüfung, ob die Eingabe numerisch ist
    value = Integer.parseInt(input);
} else {
    value = 0; // Standardwert setzen, ohne eine Exception auszulösen
}
```

**Fazit**: Durch die Verwendung von Kontrollstrukturen anstelle von Exceptions für den Programmfluss wird der Code nicht nur sauberer und verständlicher, sondern auch effizienter und robuster.

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgaben zu Exception Handling](../../../labs/java/java-exception-handling) in den Labs.
