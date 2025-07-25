---
title: "Datentypen"
linkTitle: "Datentypen"
weight: 3
description: >
  In diesem Module lernst du was Datentypen sind und was der Unterschied zwischen primitiven Datentypen und
  Referenztypen ist.
---

{{< module J1 >}}

## Ziele

- Ich weiss, was Datentypen sind.

{{< zeit lesen="10" >}}

## Datentypen

In Java sind Variablen **stark typisiert**. Das bedeutet, dass jede Variable beim Erstellen mit einem **Datentyp** versehen werden muss. Damit wird sichergestellt, dass das Programm jederzeit weiss, um was für einen Typ es sich bei einer Variablen handelt.

{{< ninja warning >}}
Stell dir einen Gewürzschrank vor. Beim Kochen ist es sehr wichtig, dass man die richtigen Gewürze nimmt und weiss,
welches Gewürz sich in welchem Gefäss befindet. Was würde passieren, wenn in einem Rezept steht, dass du Salz und
Pfeffer nehmen sollst, die Gefässe aber nicht oder sogar falsch angeschrieben sind – und du zum ersten Mal vor dem
Schrank stehst und auch nicht probieren kannst, was in welchem Gefäss drin ist?
{{< /ninja >}}

Um die Zahl 3 als ganzzahligen (Integer) Wert in der Variable sum zu speichern, schreibst du:

```java
int sum = 3;
```

Seit Java 10 gibt es eine vereinfachte Schreibweise mit **Typinferenz**. Du kannst den Datentyp bei lokalen Variablen weglassen – Java erkennt den Typ automatisch. Verwende dazu das Schlüsselwort `var`:

```java
var sum = 20;
```

{{< ninja info >}}
Auch wenn du `var` verwendest, bleibt die Variable stark typisiert. Der Unterschied ist nur: Du schreibst den Typ nicht
selbst hin – Java erkennt ihn automatisch anhand des zugewiesenen Werts.
{{< /ninja >}}

### Zwei Arten von Datentypen

In Java unterscheidet man zwischen:

- **Primitiven Datentypen**
- **Referenztypen**

Der Unterschied ist grundlegend:

- Ein **primitiver Typ** speichert direkt den Wert (z. B. `3` oder `true`).
- Ein **Referenztyp** speichert eine Adresse – also den Ort im Speicher, wo das eigentliche Objekt liegt.

Das hängt mit dem **Java Memory Model** zusammen. Die folgende Grafik zeigt das vereinfacht:

![Java Memory Modell](./images/Datentypen.png)

### Stack und Heap

Java arbeitet intern mit zwei Speicherbereichen:

- **Stack Memory**: Hier liegen primitive Werte und Referenzen.
- **Heap Space**: Hier werden alle Objekte gespeichert, z. B. ein `Car`-Objekt.

Im Bild siehst du: Die Variable `car` liegt auf dem Stack und zeigt auf ein Objekt im Heap.

Der Grund für diese Aufteilung liegt darin, wie ein Programm Daten verarbeitet:

Wenn eine Methode aufgerufen wird, werden die Parameter, die du ihr übergibst, auf den Stack kopiert. Danach „springt“
das Programm in die Methode. Dort greift es auf die Werte auf dem Stack zu.

Bei primitiven Werten geht das sehr schnell – sie sind klein (nur ein paar Bytes) und lassen sich effizient kopieren.

Objekte hingegen können viel Speicher benötigen – oft hunderte oder tausende Bytes. Wenn bei jedem Methodenaufruf das
ganze Objekt kopiert würde, würde das das Programm stark verlangsamen. Deshalb wird das Objekt im **Heap** abgelegt, und
**nur eine Referenz** (also die Adresse im Speicher) wird über den Stack an die Methode übergeben.

Das spart Zeit und Speicher – und ist der Grund, warum Java primitive Typen und Referenztypen unterschiedlich behandelt.

### Vergleiche von Werten

Dieser Unterschied ist entscheidend, wenn du zwei Werte vergleichst:

- Mit `==` vergleichst du **Stack-Inhalte**.
  - Bei primitiven Typen also den Wert selbst.
  - Bei Referenzen hingegen die Speicheradresse – also ob es **dasselbe Objekt** ist.
- Um den **Inhalt zweier Objekte** zu vergleichen, brauchst du die Methode `equals()`:

```java
car1.equals(car2)
```

Das prüft, ob die Objekte **inhaltlich gleich** sind, nicht ob sie identisch im Speicher sind.

{{< ninja info >}}
Stell dir vor, du kommst zu deinem Auto zurück – und gleich daneben steht ein Auto vom exakt gleichen Modell, gleicher
Farbe, gleicher Ausstattung. Eine fremde Person könnte nicht sagen, welches dein Auto ist, weil sie es nur oberflächlich
betrachtet. Man müsste also bewusst festlegen, was genau verglichen wird: Die Farbe reicht vielleicht nicht aus.
Eindeutig wird es mit der Fahrgestellnummer – oder, falls es keine Wechselnummer ist, mit dem Kennzeichen.
{{< /ninja >}}

Zeigen zwei Referenzen auf dasselbe Objekt, ist ein Vergleich mit equals() nicht nötig – == genügt in diesem Fall, da es
sich garantiert um exakt dasselbe Objekt handelt.

Du wirst später lernen, dass Java beim Vergleichen von Objekten standardmässig prüft, ob es sich um dieselben handelt – also ob beide genau auf dasselbe Objekt im Speicher zeigen.

Wenn man aber prüfen möchte, ob zwei Objekte inhaltlich gleich sind (z. B. zwei Autos mit gleicher Farbe und gleichem Modell), muss man in Java definieren, wie dieser Vergleich aussehen soll – zum Beispiel, worauf genau geachtet werden soll.
