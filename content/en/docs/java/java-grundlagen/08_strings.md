---
title: "String"
linkTitle: "String"
weight: 8
description: >
  Modul #J1
---

## Ziele

- Ich kann `String`-Variablen deklarieren und initialisieren.
- Ich kann mehrere `String`s miteinander in eine `String`-Variable verknüpfen (String Concatenation).
- Ich weiss, wann man einen `StringBuilder` verwenden sollte.
- Ich weiss, wie ich herausfinde, wie viele Zeichen eine `String`-Variable enthält.
- Ich weiss, dass `String`-Variablen nicht mit `==` sondern `equals` verglichen werden sollten.
- Ich kann von der Klasse `String` folgende Methode anwenden: `toUpperCase()`, `toLowerCase()`, `charAt(...)`, `indexOf(...)`, `contains(...)`, `substring(...)`, `replace(...)`, `split(...)`.

## String

Eine Variable, die eine Zeichenkette repräsentiert, hat den Typ `String` und kann wie folgt initialisiert werden:

```java
String hello = "Hello, Java";
```

Diese Zeichenkette besteht aus 11 Zeichen, einschliesslich eines Leerzeichens. Wie wir hier ebenfalls sehen, müssen String-Literale von doppelten Anführungszeichen umgeben sein.

Ein Objekt des Typs `String` ist unveränderlich, die Werte innerhalb eines Strings können also nach dessen Erstellung nicht mehr verändert werden - der Variable kann aber ein neuer `String`-Wert zugewiesen werden:

```java
String hello = "Hello, Java";
hello = "Hello, how are you?";
```

Ausserdem ist es möglich, Strings mit mehreren Zeilen zu definieren, indem du einen String mit 3 `"` beginnst und beendest und den String auf einer neuen Zeile beginnst:

```java
String poem = """
    Strings dürfen mehreren Zeilen enthalten.
    So kannst du auch einfach eine Auflistung notieren:
        1. Element
        2. Element.""";
```

### Strings verknüpfen (String Concatenation)

Oft generierst du aus verschiedenen Variablen EINEN neuen `String`. Angenommen du hast eine Variable für "name" und "age" (Alter), dann kannst du wie folgt den String "Hallo {name}, du bist {age} Jahre alt." generieren:

```java
String name = "Leonardo";
int age = 68;

String greeting = "Hallo " + name +", du bist " + age + " Jahre alt.";
```

Alternativ kannst du statt die vielen `+` auch von der `String.format()`-Methode Gebrauch machen:

```java
String greeting = String.format( "Hallo %s, du bist %d Jahre alt.", name, age);
```

Bei der `String.format()`-Methode übergeben wir dann die einzelnen Werte als Argumente. Beachte hierbei, dass `%s` für String- und `%d` für Integer-Werte verwendet werden.

Wenn Performance (also wie schnell, dass ein Programm läuft) eine übergeordnete Rolle einnimmt, dann wird die Methode mit einem `StringBuilder` bevorzugt:

```java
StringBuilder sb = new StringBuilder();
sb.append("Hallo ")
   .append(name)
   .append(", du bist ")
   .append(age)
   .append(" Jahre alt.");

String greeting = sb.toString();
```

Hierbei musst du aber zuerst ein neues `StringBuilder`-Objekt erstellen. (Im Modul #J1 musst du solche Objekte noch nicht verstehen.) Anschliessend fügst du alle einzelnen Strings via `.append(...)` hinzu. Den gewünschten String kannst du dann mit `.toString()` generieren lassen.

### Neue Zeilen oder Tabs
Beim Verknüpfen von Strings ist es oft praktisch, wenn man Zeilenumbrüche hinzufügen kann. Dies kannst du mit dem `Character` `'\n'` (new line) tun:

```java
String greeting = " name: " + name + ", \n nage: " + age;
```

Das Gleiche ist auch mit Einrückungen (Tabulatoren) möglich mit dem `Character` `'\t'` (tab):
```java
System.out.println("weapon name \t ranges (m)");
System.out.println("Shuriken \t 5-10");
System.out.println("Nunchaku \t 1-1.5");
System.out.println("Naginata \t 3-4");
```

Im Java fungiert das Zeichen `\` als "escape character". Das bedeutet, dass spezielle Zeichen, die in einem String regulär nicht möglich wären, oft irgendwie mit einem `\` "escaped" werden. Neben der "New-Line" und dem "Tabulator" gibt es noch weitere, die oft verwendet werden:
* `\\`: Das `\`-Zeichen ("Backslash) selber.
* `\"`: Ein Anführungszeichen in einem String.

Hier ein Beispiel, wie das Anführungszeichen und Backslash in einem String verwendet werden können:

```java
System.out.println("Die Datei \"Main.java\" befindet sich im Ordner C:\\Users\\Ninja\\Documents.");
```

### Methoden

Nachfolgend sind einige der wichtigsten Methoden der Klasse `String` beschrieben. Alle Methoden sind detailliertet beschrieben unter [java.lang.String](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html) zu finden.

#### Anzahl Zeichen (`String.length()`)

Bei Strings sind dessen Länge (also Anzahl Zeichen) oft von Interesse.

Im folgenden Beispiel wird eine Nachricht ausgegeben, wenn eine Dummy-Usereingabe nicht mindestens 6 Zeichen enthält:

```java
String nickname = "peter";

if (nickname.length() < 6)
    System.out.println("Der Nickname muss mindestens 6 Zeichen enthalten!");
```

#### Strings miteinander vergleichen (`String.equals(String)`)

Sehr oft wirst du überprüfen, ob ein String einem anderen entspricht. Dies kannst du mit der `equals()`-Methode tun:

```java
String a = "hello";
String b = "hello";

if (a.equals(b))
    System.out.println("A ist gleich B.");
```

Beachte hierbei, dass du zum Vergleichen von Strings **in Java** immer `equals()` nun nie `==` verwenden solltest, weil `String` kein primitiver Datentyp ist. `==` funktioniert in einfacheren Beispielen, führt aber in vielen Fällen trotzdem nicht zum gewünschten Resultat.

#### In Gross-/Kleinbuchstaben umwandeln

In bestimmten Fällen soll die Gross- und Klein-Schreibung keine Rolle spielen. Nehmen wir hierfür noch einmal das Beispiel von der `equals`-Methode:

```java
String input = "hello";

if (input.toUpperCase().equals("HELLO"))
    System.out.println("Der Input entspricht 'hello'.");
```

Die relevanten String-Methoden bezüglich Gross- und Klein-Schreibung sind hierbei:

- `toUpperCase()`: Gibt die Zeichenkette in Grossbuchstaben zurück.
- `toLowerCase()`: Gibt die Zeichenkette in Kleinbuchstaben zurück.

Eine häufige Fehlerquelle ist es zu denken, dass eine dieser beiden Methoden den String verändert. Strings können sich aber nicht verändern. Deswegen geben diese beide Funktionen einen **neuen** String zurück, der Wert in der Variable bleibt also unverändert:

```java
String myString = "Hello";

myString.toUpperCase();

System.out.println(myString);
```

Damit dieses Beispiel wie gewollt funktioniert, müsste es so geschrieben werden:

```java
String myString = "Hello";

myString = myString.toUpperCase();

System.out.println(myString);
```

#### Buchstaben an bestimmter Position ermitteln (`String.charAt(int)`)

Wenn du z.B. alle Buchstaben in einem String durchgehen willst, dann musst du irgendwie den Buchstaben (`char`) an einer bestimmten Position des Strings ermitteln können. Dies kannst du mit `charAt(int)`.

Das folgende Beispiel liest den ersten Buchstaben aus einem String aus und gibt in aus:

```java
String word = "Hello";

char firstLetter = word.charAt(0);

System.out.println("Erster Buchstabe: '" + firstLetter + "'");
```

Beachte, dass die Nummerierung in Java generell bei 0 beginnt. Für das erste Element übergibst du 0, für das zweite 1, für das vierte 3, für `n` das `(n-1)`-te, usw. Für `charAt(...)` bedeutet das, dass du wie folgt Buchstaben an bestimmten Positionen ermittelst:

```java
// erstes Zeichen:
word.charAt(0);

// zweites Zeichen:
word.charAt(1);

// viertes Zeichen:
word.charAt(3);

// letztes Zeichen:
word.charAt(word.length() - 1);
```

#### Nach Strings in Strings suchen (`String.indexOf()` und `String.contains()`)

In seltenen Fällen möchtest du wissen, an welcher Position ein kleinerer String (oder `char`) in einem grösseren String vorkommt. Diese Information erhältst du mit `indexOf(String/char)`.

Möchtest du z.B. herausfinden, an welcher Stelle in einer Email-Adresse das "@" steht, dann könnte das wie folgt aussehen:

```java
String email = "wallace@gmail.com";

int indexOfAt = email.indexOf("@gmail");

System.out.println("Der Teil vor dem @ ist " + indexOfAt + " Zeichen lang.");
```

In diesem Fall gibt die Methode `7` zurück, weil sich das `@` an der 8. Stelle befindet.

Allgemein gibt `indexOf(...)` folgendes zurück:

- Wenn der Suchbegriff vorkommt, dann die Position, wo der Suchbegriff zum ersten Mal beginnt.
- Wenn der Suchbegriff nie vorkommt: `-1`.

Weil `-1` zurückgeben wird, wenn der Suchbegriff nicht vorkommt, könnte diese Methode auch dafür verwendet werden, um herauszufinden, ob ein bestimmter Text in einem String vorkommt. Java bietet aber für diesen Fall bereits eine praktischere Methode:

```java
String email = "wallace@gmail.com";

if (email.contains("@gmail."))
    System.out.println("Diese Email-Adresse ist ein Gmail-Adresse.");
```

Der Vorteil von der `contains()`-Methode ist, dass sie bereits einen `boolean` zurückgibt, was die `if`-Anweisung einfacher macht als das Überprüfen nach `-1`.

#### Text aus einem String ausschneiden

Die `substring()`-Methode ist nützlich, wenn ein Text aus einem String ausgeschnitten werden soll.

In diesem Beispiel interessiert uns die Information nach dem ":", welches sich immer an 6. Stelle befindet:

```java
String systemInfo = "power: on";

String status = systemInfo.substring(7);

System.out.println("The system is " + status + ".");
```

In diesem Beispiel haben wir mit dem Schneiden an 7. Stelle begonnen. Wir können aber auch angeben, wie viele Zeichen, das ausgeschnitten werden sollen:

```java
String sentence = "Today is Wed, 9th August 2023";

String dayOfWeek = sentence.substring(9, 12);

System.out.println("Day of Week: " + dayOfWeek);
```

In diesem Beispiel beginnt das Ausschneiden bei Index 9 und hört 1 Zeichen **VOR** Index 12 auf.

In all diesen Beispielen sind wir davon ausgegangen, dass wir wissen, ab welcher Stelle das Ausschneiden beginnt. Oft ist diese Stelle aber dynamisch. Hier kann daher eine Kombination mit `indexOf()` weiterhelfen:

```java
String dadJoke = "Warum dürfen Geister keine Lügen erzählen? Weil man durch sie hindurchsieht!";

String punchline = dadJoke.substring(dadJoke.indexOf("Weil "));
System.out.println("Pointe: " + punchline);
```

#### Teile eines Strings ersetzen (`String.replace()`)
Ein bestimmter Teil eines Strings kannst du mit `replace` ersetzen:

```java
String classicPhrase = "To be or not to be, that's the question.";
System.out.println(classicPhrase.replace("o be", "o beer"));
```

Beachte auch hier, dass `replace` den ursprünglichen String nicht verändert, sondern einen neuen zurückgibt.


#### Bausteine aus einem String herauslösen (`String.split()`)

Mit der `split(String)`-Methode kannst du einen String anhand eines Suchbegriffes aufteilen und erhältst dann eine Auflistung von Strings, die sich zwischen dem Suchbegriff befinden:

```java
String ingredients = "Käse, Brot, Speck, Eier, Surströmming";

var items = ingredients.split(", ");

System.out.println("This receipt has " + items.length + ". Ingredients: ");
for (String item : items)
    System.out.println(item);
```

Die `for`-Schlaufe musst du zu diesem Zeitpunkt noch nicht verstehen. Wichtig ist, dass die Variable `items` eine Auflistung (nicht ein String) ist von folgenden Werten:
* Käse
* Brot
* Speck
* Eier
* Surströmming

Auf diese Art und Weise können wir z.B. alle Wörter aus einem String ermitteln.

Anzufügen ist noch, dass es sich beim Suchbegriff um eine sogenannten "Regulären Ausdruck" (RegEx) handelt. Eine RegEx ist eine Folge von Zeichen, die ein Suchmuster bilden. Eine Regex wird dafür verwendet, um einen Text anhand eines Musters (einer Regel) abzugleichen. RegEx ist im Moment kein Thema im Modul #J1. Wichtig ist für dich im Moment nur, dass du weisst, dass sich bei diesem Suchbegriff von `split(...)` nicht um einen gewöhnlichen String handelt, sondern um eine RegEx. Möglicherweise können dir RegEx' viel Arbeit abnehmen. Bitte melde dich bei Interesse für RegEx.

---
![task1](/images/task.png) Jetzt bist du dran. Löse bitte die [Aufgaben 5 und 6](../../../../labs/java/java-grundlagen/01_basicexercises/#aufgabe-5---strings) in den Labs.