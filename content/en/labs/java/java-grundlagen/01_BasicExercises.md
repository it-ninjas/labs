---
title: "Java Exercises - Grundlagen"
linkTitle: "Java Exercises - Grundlagen"
type: docs
weight: 1
description: >
  Exercises zu Modul #J1
---

#### Ziele
* Ich kann Text und Zahlen auf der Konsole ausgeben
* Ich kann Text und Zahlen auf der Konsole eingeben und diese wieder ausgeben
* Ich kann statische Methoden schreiben, die einfache Rechnungen durchführen
* Ich kann statische Methoden mit Parametern und Return-Statements schreiben
* Ich verstehe und kenne die verschiedenen Conditional Statements
* Ich weiss, wann und wie ich welches Conditional Statement einsetzen sollte
* Ich verstehe, was Loops sind und kenne die verschiedenen Loops
* Ich weiss, wann und wie ich welchen Loop brauchen soll
* Ich kann mit Hilfe von String-Methoden Strings bearbeiten
* Ich kann Arrays initialisieren, auf deren Werte zugreifen und Werte in einem Array verändern
* Ich kann mein Programm mit einem Debugger zur Laufzeit untersuchen

## Aufgabe 1 - Ausgaben auf die Kommandozeile
![task1](/images/task.png) Gib die folgenden Daten in der Kommandozeile aus:
* `Hello World`
* `Hello + <Dein Name>`
* `Zeichne ein Haus, nutze dazu beliebige Zeichen`
* `Zeichne eine Schweizerfahne`


## Aufgabe 2 - Conditional Statements
![task1](/images/task.png) Löse die folgende Aufgaben:
* Schreibe eine Methode, die feststellen kann, ob eine Zahl (als Parameter) grösser, kleiner oder gleich 0 ist
* Schreibe eine Methode, die dich begrüsst wenn dein Name als Parameter übergeben wird
* Schreibe eine Methode, die feststellt, ob das übergebene Jahr ein Schaltjahr ist
* Schreibe eine Methode, die überprüft, ob eine Zahl (als Parameter) gerade oder ungerade ist
* Debugge mindestens zwei dieser Methoden mit einem Breakpoint

## Aufgabe 3 - Loops
![task1](/images/task.png) Löse die folgenden Aufgaben:
* Schreibe eine Methode, welche eine beliebige Ganzzahl als Parameter übernimmt und die [Fakultät](https://www.studysmarter.de/schule/mathe/algebra/fakultaet/) dieser Zahl berechnet.
* Schreibe einen Loop, welcher alle Zahlen von 1 bis 100 zusammenzählt, welche durch 8 teilbar sind
  * Erweitere deine Lösung mit einer Methode, welche eine Zahl entgegennimmt und dann die Zahlen zusammenzählt, welche durch diese Zahl teilbar sind


## Aufgabe 4 - Einfache Berechnungen
![task1](/images/task.png) Berechne die folgenden Dinge:
* Fläche eines Rechtecks
* Fläche eines Kreises
* Umfang eines Rechtecks
* Inhalt einer Pyramide mit quadratischen Grundriss und einer bestimmten Höhe
* Berechne dein Alter am heutigen Tag in Jahren, Monaten und Tagen
* Schreibe eine Methode, welche eine beliebige Ganzzahl als Parameter übernimmt und die [Vielfache](https://www.studysmarter.de/schule/mathe/algebra/vielfaches/) von 3 zusammen mit der Vielfache von 5 dieser Zahl summiert.


## Aufgabe 5 - Strings
Du hast den folgenden String:

```java
String poem = """
        Ein Ninja leise wie der Wind,
        Seine Waffen stets geschwind.
        "Shurikens" fliegen, scharf und schnell,
        Klingen funkeln, furchterregend hell.


        "Nunchakus" wirbeln im Tanz,
        Mit jedem Schlag, im Vorteil er ganz.
        Seine Waffen, geheim und klug,
        Begleiten ihn bei jedem Zug.""";
```

![task1](/images/task.png) Löse mit Hilfe dieses Strings folgende Aufgaben:
1. Gib in der Konsole die Anzahl Wörter aus.
2. Gib den Text in Grossbuchstaben aus.
3. Gib den Text so aus, dass jedes Leerzeichen mit einem Punkt ersetzt wurde.
4. Schneide das Wort "Shurikens" aus. Ermittle hierfür die Position des Wortes anhand des `"`-Zeichens.
    Hinweis: Die `indexOf()`-Methode bietet ein optionales Argument `fromIndex` an. Übergibst du die `Position des ersten Anführungszeichen + 1`, dann wird die Position des zweiten zurückgegeben.

## Aufgabe 6 - Strings und Loops
![task1](/images/task.png) Löse die folgende Aufgaben:
* Schreibe eine Methode, welche als Parameter einen beliebigen String übernimmt und dessen Zeichenfolge umkehrt
* Schreibe eine Methode, welche als Parameter einen beliebigen String übernimmt und die Anzahl Wörter darin ausgibt

## Aufgabe 7 - Eingaben von der Kommandozeile
![task1](/images/task.png) Lies zuerst deinen Namen und danach dein Alter über einen Scanner von der Kommandozeile ein und gib dann die folgenden Daten auf die Kommandozeile aus
*   `Hello + <Dein Name> + you are + <Dein Alter> + years old. Next year, you will be <Dein Alter + 1> years old.`

Generiere diesen Output
* mithilfe eines `StringBuilder`s
* und mithilfe der `String.format()`-Methode.

## Aufgabe 8 - Arrays
![task1](/images/task.png) Löse die folgenden Aufgaben:
* Schreibe eine Methode, welche zwei Parametern übernimmt: einen beliebigen Zahlen-Array und eine beliebige Zahl. Die Methode gibt die Position der Zahl im Array aus.
* Schreibe eine Methode, welche als Parameter einen beliebigen Zahlen-Array übernimmt und die grösste Zahl im Array zurückliefert.

## Aufgabe 9 - Methoden
![task1](/images/task.png) Löse die folgende Aufgaben:
* Schreibe eine Methode, die zwei beliebigen Ganzzahlen als Parameter übernimmt und die Summe der beiden zurückliefert.
* Schreibe eine eigene Methode, die als Parameter einen Namen übernimmt. Die Methode soll dann die folgenden Daten auf die Kommandozeile ausgeben ```Hello + <Parameter-Name>```