---
title: "Variablen in Java"
linkTitle: "Variablen"
weight: 2
description: >
  In diesem Module lernst du, was Variablen sind und für was sie gebraucht werden.
---

{{< module J1 >}}

## Ziele

- Ich weiss, was Variablen sind.
- Ich kann eine Variable $deklarieren und initialisieren.

{{< zeit lesen="10">}}

---

## Was sind Variablen?

Eine Variable dient dazu, einen Wert zu speichern, damit man später darauf zugreifen oder ihn mehrfach verwenden kann.

Schau dir dieses leicht abgeänderte Hello-World-Beispiel an:

```java
public class HelloWorld {
    public static void main(String[] args) {
        var nachricht = "Hello, world!";
        System.out.println(nachricht);
    }
}
```

Was passiert hier?

- `var nachricht = "Hello, world!";` erstellt eine neue Variable namens `nachricht` und speichert den Text darin.
- Mit `System.out.println(nachricht);` wird der gespeicherte Text ausgegeben.

Du kannst jetzt denselben Text mehrfach ausgeben, ohne ihn mehrfach zu schreiben:

```java
System.out.println(nachricht);
System.out.println(nachricht);
System.out.println(nachricht);
```

Das macht deinen Code übersichtlicher und leichter wartbar.

---

## Deklaration

Bevor du eine Variable verwenden kannst, musst du sie deklarieren. Dabei gibst du ihren **Typ** und ihren **Namen** an:

```java
<Typ> <Name>;
```

Zum Beispiel:

```java
String nachricht;
```

Hier ist `String` der Datentyp (für Text) und `nachricht` der Name der Variable.

> Mit `var` kannst du seit Java 10 den Typ weglassen – der Compiler erkennt ihn automatisch. Wir zeigen aber beide
> Varianten, weil der explizite Typ in vielen Projekten bevorzugt wird.

---

## Initialisierung

Eine **Initialisierung** weist einer deklarierten Variable einen Wert zu:

```java
<Typ> <Name> = <Wert>;
```

Beispiel:

```java
int zahl = 3;
```

Du kannst eine Variable auch zuerst deklarieren und später initialisieren:

```java
int zahl;    // Deklaration
zahl = 3;    // Initialisierung
```

Oder beides in einer Zeile:

```java
int zahl = 3;
```

---

## Wichtige Regel für lokale Variablen

Lokale Variablen (also solche, die in einer Methode deklariert sind) **müssen initialisiert werden, bevor du sie verwendest**:

```java
public class Beispiel {
    public static void main(String[] args) {
        int a = 1;
        int b;
        int summe = a + b; // Fehler!
    }
}
```

Dieser Code führt zu folgendem Fehler:

```
error: variable b might not have been initialized
```

Lösung:

```java
int b = 2;
```

---

## Namenskonventionen für Variablen

Beim Benennen von Variablen beachtest du folgende Regeln:

- Der Name beginnt mit einem Kleinbuchstaben.
- Er darf Buchstaben (A–Z, a–z), Ziffern (0–9), `$` und `_` enthalten.
- Der Name darf **nicht mit einer Ziffer beginnen**.
- Der Name sollte den Inhalt der Variable beschreiben (z. B. `summe` für das Ergebnis einer Addition).

Beispiele für gültige Namen:

```java
int alter;
double preisProStunde;
String benutzername;
```

{{< ninja info>}}
Du wirst während deiner Ausbildung noch mehrmals Regeln sehen, was wie benannt oder strukturiert werden soll. In der
Fachsprache nennen wir das **Coding Guidelines** und für Java findest du unsere Regeln
[hier](../../../99_tools/zusammenarbeit/guidelines/coding/java/).
{{< /ninja>}}

---

## Zusammenfassung

| Begriff             | Bedeutung                                                  |
| ------------------- | ---------------------------------------------------------- |
| **Deklaration**     | Eine Variable benennen und ihren Typ angeben (`int zahl;`) |
| **Initialisierung** | Einer Variable einen Wert zuweisen (`zahl = 5;`)           |
| **Zuweisung**       | Eine bestehende Variable erhält einen neuen Wert           |

---

{{< video "https://www.youtube.com/watch?v=8YI0etAGQGA" "YouTube, bis 4:25">}}

---
