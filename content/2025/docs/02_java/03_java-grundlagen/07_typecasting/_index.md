---
title: "Typumwandlung (Casting)"
linkTitle: "Typumwandlung"
weight: 7
description: >
  In diesem Modul lernst du, wie du Werte von einem Datentyp in einen anderen umwandeln kannst – z. B. von `double` nach `int`.
---

## Ziele

- Ich verstehe den Unterschied zwischen impliziter und expliziter Typumwandlung (Casting).
- Ich kann einfache Casts selbst schreiben und weiss, worauf ich achten muss.
- Ich kenne mögliche Probleme beim Casten (z. B. Datenverlust oder Rundungsfehler).

{{< zeit lesen="10" >}}

---

## Einführung

Beim Programmieren musst du oft mit verschiedenen Datentypen arbeiten – z. B. `int` und `double`. Damit Rechnungen korrekt funktionieren oder Werte gespeichert werden können, musst du manchmal eine **Typumwandlung** durchführen.

Diese Umwandlung nennt man **Casting**.

---

## Implizite Typumwandlung

Wenn Java sicher ist, dass **kein Informationsverlust** auftritt, wird automatisch eine Umwandlung gemacht – z. B. von `int` zu `double`.

```java
int a = 10;
double b = a; // int → double ist erlaubt (automatisch)

System.out.println(b); // Ausgabe: 10.0
```

Hier wird `a` automatisch in einen `double` umgewandelt, da `double` alle `int`-Werte darstellen kann.

---

## Explizite Typumwandlung (Casting)

Wenn ein möglicher Informationsverlust besteht, musst du die Umwandlung **explizit angeben**:

```java
double x = 3.7;
int y = (int) x; // explizites Casting

System.out.println(y); // Ausgabe: 3
```

{{< ninja warning >}}
Beim Casten von `double` zu `int` wird **nicht gerundet**, sondern **abgeschnitten** (der Nachkommateil wird ignoriert).
{{< /ninja >}}

---

## Weitere Beispiele

```java
byte b = 42;
int i = b;         // implizit: byte → int
short s = (short)i; // explizit: int → short
```

---

## Casting bei Operationen

```java
int a = 5;
int b = 2;

System.out.println(a / b);           // Ausgabe: 2 (Ganzzahldivision)
System.out.println((double) a / b);  // Ausgabe: 2.5 (wegen Casting)
```

{{< ninja tip >}}
Wenn du **eine** der Zahlen in `double` umwandelst, wird die ganze Rechnung als Gleitkommazahl berechnet.
{{< /ninja >}}

---

## Typumwandlung bei Zuweisungen

```java
long big = 9999999999L;
int small = (int) big;

System.out.println(small); // Ausgabe: ein unerwarteter Wert!
```

{{< ninja warning >}}
Wenn der Zieltyp zu klein ist (z. B. `int` statt `long`), kommt es zu **Überlauf**. Java schneidet einfach ab – das führt zu falschen Werten.
{{< /ninja >}}

---

## Zusammenfassung

| Von Typ → Nach Typ | Erlaubt?        | Art      |
| ------------------ | --------------- | -------- |
| `int` → `double`   | ✅ automatisch  | implizit |
| `double` → `int`   | ❌ nur mit Cast | explizit |
| `int` → `byte`     | ❌ nur mit Cast | explizit |
| `char` → `int`     | ✅ automatisch  | implizit |
