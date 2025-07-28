---
title: "Fehlerbehandlung mit Exceptions"
linkTitle: "Exception Handling Grundlagen"
weight: 9
description: >
  Du lernst die Grundlagen des Exception Handlings kennen: try, catch, throw, throws sowie typische Fehlerarten und wie du sie vermeidest.
---

{{< module "J1" >}}

## Ziele

- Ich verstehe den Unterschied zwischen Fehlern (Errors) und Ausnahmen (Exceptions).
- Ich kenne den Unterschied zwischen Checked und Unchecked Exceptions.
- Ich kann `try`, `catch`, `finally`, `throw` und `throws` korrekt verwenden.
- Ich weiss, wie ich NullPointerExceptions vermeide.
- Ich weiss, warum Exceptions nicht als Kontrollstruktur verwendet werden sollten.

{{< zeit lesen="30" >}}

## Was ist ein Fehler?

In Java unterscheidet man zwei grundlegende Arten von Fehlern:

- **Error**: nicht abfangbare Fehler wie z. B. Speicherüberläufe
- **Exception**: abfangbare Ausnahmen, die während der Programmausführung auftreten

Exceptions kann man behandeln – Errors nicht.

## Checked vs. Unchecked

- **Checked Exceptions**: werden vom Compiler geprüft (z. B. `IOException`)
- **Unchecked Exceptions**: entstehen zur Laufzeit (z. B. `NullPointerException`, `ArithmeticException`)

Unchecked Exceptions sind oft auf Programmierfehler zurückzuführen und müssen nicht deklariert oder abgefangen werden.

## try / catch / finally

Mit `try` und `catch` kann man eine Exception abfangen:

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.err.println("Division durch 0 ist nicht erlaubt!");
}
```

Optional kann ein `finally`-Block folgen, der **immer** ausgeführt wird:

```java
finally {
    System.out.println("Ich werde auf jeden Fall ausgeführt.");
}
```

## throw und throws

Mit `throw` wird eine Exception ausgelöst. Mit `throws` gibt man an, dass eine Methode eine Exception auslösen könnte:

```java
public void checkAge(int age) throws IllegalArgumentException {
    if (age < 0) {
        throw new IllegalArgumentException("Alter darf nicht negativ sein");
    }
}
```

## NullPointerException vermeiden

Ein häufiger Fehler ist das Zugreifen auf `null`:

```java
String name = null;
System.out.println(name.length()); // NullPointerException!
```

Abhilfe schafft ein Guard:

```java
if (name != null) {
    System.out.println(name.length());
}
```

Oder ein `else`-Zweig für den Fehlerfall:

```java
if (name != null) {
    System.out.println(name.length());
} else {
    System.out.println("Kein Name vorhanden.");
}
```

Auch der Ternary-Operator ist möglich:

```java
System.out.println(name != null ? name.length() : 0);
```

## Exceptions ≠ Kontrollstruktur

**Falsch:**

```java
try {
    int value = Integer.parseInt("abc");
} catch (NumberFormatException e) {
    value = 0;
}
```

**Richtig:**

```java
if (input.matches("\d+")) {
    value = Integer.parseInt(input);
} else {
    value = 0;
}
```

## Und `assert`?

Mit `assert` kann man Annahmen prüfen – bricht aber bei Fehlschlag mit einem `AssertionError` ab:

```java
assert age >= 0 : "Alter darf nicht negativ sein";
```

Das funktioniert nur, wenn Java mit `-ea` gestartet wird (enable assertions). `assert` ist ein Tool zur Fehlersuche, kein Ersatz für echtes Exception Handling.

---

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/09_exception_handling/)" >}}
