---
title: "Referenztypen"
linkTitle: "Referenztypen"
weight: 11
description: >
  In diesem Modul lernst du den Unterschied zwischen primitiven Typen und Referenztypen kennen.
---

{{< module "J1" >}}

## Ziele

- Ich verstehe den Unterschied zwischen primitiven und Referenztypen.
- Ich weiss, dass Referenzvariablen nicht den Wert, sondern einen Verweis speichern.
- Ich kenne `null` als möglichen Wert einer Referenz.
- Ich kann einfache Beispiele von Referenztypen (z. B. `String`, `Array`) erkennen.

{{< zeit lesen="10" >}}

## Primitive und Referenztypen

Als Auffrischung. Du hast bereits gelernt, dass es in Java zwei Arten von Datentypen gibt:

| Kategorie           | Beispiele                          | Beschreibung                                 |
| ------------------- | ---------------------------------- | -------------------------------------------- |
| **Primitive Typen** | `int`, `double`, `char`, `boolean` | Speichern den **Wert direkt**                |
| **Referenztypen**   | `String`, `Array`, eigene Klassen  | Speichern **nur einen Verweis** auf den Wert |

### Vergleich von `int` zu `String`

Folgendes Beispiel zeigt die Initialisierung eines primitiven Datentypes und eines Referenztypes:

```java
int a = 42;
String text = "Hallo";
```

- `a` enthält direkt die Zahl `42`
- `text` enthält nur eine **Referenz** auf ein `String`-Objekt im Speicher

## null als Wert

Wenn eine Referenzvariable noch **auf kein Objekt** zeigt, ist sie `null`:

```java
String name = null;
```

Versucht man, auf `name` zuzugreifen, ohne vorher etwas zuzuweisen, gibt es einen **Fehler zur Laufzeit**.

{{< ninja info>}}
Hier verhalten sich die Referenztypen wie primitive Datentypen. Auch bei den Referenztypen muss zuerst ein Wert
zugewiesen werden, bevor die Variable benutzt werden darf.
{{< /ninja>}}

## Vorsicht bei Vergleichen

Bei Referenztypen vergleicht `==` nicht den Inhalt, sondern ob es dieselbe Referenz ist (auf das gleiche Objekt verweist):

```java
String s1 = "Hallo";
String s2 = s1;
```

`s1` und `s2` beinhalten nur eine Zahl, auch Adresse oder Verweis genannt, welche dem Programm mitteilt, wo sich der
eigentliche String im Speicher befindet.

## Hinweis: Verbindung zu Objekten

Referenztypen werden vor allem im Zusammenhang mit **Objekten** verwendet. In diesem Grundlagenmodul lernst du zwar noch nicht, wie man eigene Objekte erstellt – aber du wirst schon erste Referenztypen wie `String` und Arrays kennenlernen.

`String` ist intern bereits ein **Objekt** – deshalb verhält es sich wie ein Referenztyp.

Mehr zu Objekten und Klassen erfährst du später im Modul **Java OOP**.

## Bekannte Referenztypen

Diese Referenztypen wirst du bald näher kennenlernen:

- **`String`** – für Text
- **Arrays** – Sammlung von Werten (z. B. mehrere Zahlen)

Beide speichern nicht direkt die Werte, sondern sind Referenztypen.

## Unterschied deklarieren und initialisieren

Es gibt einen wichtigen Unterschied zwischen einer **expliziten Initialisierung mit `null`** und einer **nicht initialisierten Referenzvariable**.

### Explizite Initialisierung

```java
String name = null;
```

- Die Variable `name` ist deklariert und **explizit mit `null` initialisiert**.
- `null` bedeutet: Die Variable verweist auf **kein Objekt**.
- Zugriff auf Methoden oder Eigenschaften führt zu einer **NullPointerException**.

```java
String name = null;
System.out.println(name);         // Ausgabe: null
System.out.println(name.length()); // NullPointerException
```

### Nicht initialisierte Referenzvariable

```java
String name;
```

- Die Variable `name` ist **deklariert**, aber **nicht initialisiert**.
- Ein Zugriff ohne vorherige Zuweisung führt zu einem **Compilerfehler**.

```java
String name;
System.out.println(name); // Fehler: Variable might not have been initialized
```

### Zusammenfassung

| Ausdruck              | Status                   | Verwendung möglich?      | Zugriff erlaubt?                 |
| --------------------- | ------------------------ | ------------------------ | -------------------------------- |
| `String name = null;` | Initialisiert mit `null` | ✅ ja                    | ⚠️ Vorsicht bei Methodenaufrufen |
| `String name;`        | Nur deklariert           | ❌ nein (Compilerfehler) | ❌ nicht erlaubt                 |

---

## Was passiert bei `String text = "Hallo";`?

Wenn du einen `String` direkt mit einem Text initialisierst, dann wird der Text im sogenannten **String-Literal-Pool**
gespeichert:

```java
String text = "Hallo"; // "Hallo" ist ein String-Literal
```

Der **String-Literal-Pool** ist ein spezieller Bereich im **Heap-Speicher**, in dem **alle konstanten Textwerte**
verwaltet werden. `"Hallo"` wird dort **nur einmal gespeichert**, auch wenn du es mehrfach verwendest.

Beispiel:

```java
String a = "Hallo";
String b = "Hallo";
System.out.println(a == b); // true – gleiche Referenz im Literal-Pool

String c = new String("Hallo");
System.out.println(a == c); // false – c zeigt auf neues Objekt im Heap
```

Vorteil:

- Spart Speicher
- Macht String-Vergleiche mit `==` in einfachen Fällen möglich

Wenn du bewusst **neue String-Objekte** erzeugst (mit `new String(...)`), liegen diese **zusätzlich** im Heap – auch wenn der Inhalt gleich ist.

{{< ninja tip>}}
Auch wenn String-Literals eingesetzt werden sollte man Strings immer mit `.equals()` vergleichen. Das Risiko ist sonst gross, dass ein Vergleich nicht korrekt funktioniert.

```java
String a = "Hallo" + ""; // Jave Kompiler optimiert das zu "Hallo"
String b = "Hallo";
System.out.println(a == b); // true – gleiche Referenz im Literal-Pool

String c = "";
String d = "Hallo" + c; // Java kann das nicht optimieren. Wert von d wird zur Laufzeit berechnet.
System.out.println(a == d); // false – d zeigt auf neues Objekt im Heap
```

{{< /ninja>}}

## Vergleich von Referenztypen: `==` vs `.equals()`

Wenn du zwei Referenzvariablen vergleichst, musst du unterscheiden:

### Vergleichen von Referenzen (Speicheradresse)

Das folgende Beispiel vergleicht die Adressen der beiden Strings, nicht den Inhalt:

```java
String a = new String("Hallo");
String b = new String("Hallo");

System.out.println(a == b); // false – verschiedene Objekte im Speicher
```

### Vergleichen der Inhalte

Das folgende Beispiel vergleicht den Inhalt der beiden Strings:

```java
String a = new String("Hallo");
String b = new String("Hallo");

System.out.println(a.equals(b)); // true – gleiche Zeichenfolge
```

Zwei Strings, welche den gleichen Inhalt (Text) haben gelten als equal.

{{< ninja info >}}
Die Methode `.equals()` ist in der Klasse `String` (und vielen anderen Klassen) so programmiert, dass sie den **Inhalt** vergleicht.
{{< /ninja >}}

### Vorsicht bei `null`

Wenn eine Variable `null` ist, darfst du **nicht `.equals()` darauf aufrufen**, sonst gibt es eine `NullPointerException`:

```java
String a = null;
System.out.println(a.equals("Test")); // NullPointerException
```

Besser so:

```java
System.out.println("Test".equals(a)); // false, aber kein Fehler
```

## Zusammenfassung

- Primitive Typen speichern Werte direkt.
- Referenztypen speichern nur einen Verweis.
- `null` bedeutet: keine Referenz vorhanden.
- `String` und `Array` sind die ersten Referenztypen, die du kennenlernen wirst.
