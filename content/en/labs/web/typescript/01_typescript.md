---
title: "Labs zu den TypeScript-Basics"
type: docs
linkTitle: "TypeScript-Basics"
weight: 1
date: 2021-11-01
description: >
    Einfache Aufgaben zu den Basics von TypeScript.
---
# Aufgaben
## Aufgabe 1
Erstelle eine neue TypeScript-Projektstruktur und richte eine tsconfig.json-Datei ein, um den TypeScript-Compiler für das Projekt zu konfigurieren.

1. Erstelle ein neues Verzeichnis für dein TypeScript-Projekt. 
2. Navigiere in das Verzeichnis und Initialisiere das Projekt mit den Node Befehlen. Diese können [hier](../../../../docs/web/ide_advanced/01_nodejs#npm-commands) nachgelesen werden. 
4. InstalliereTypeScript. 
5. Erstelle eine `tsconfig.json`-Datei im Stammverzeichnis des Projekts. Und richte diese anhand der folgenden Informationen korrekt ein:
   * ECMAScript-Version = es6
   * Modulsystem = commonjs
   * Ausgabeverzeichnis = dist
   * Typen-Check-Modus = true
6. Erstelle im Projektverzeichnis ein Unterverzeichnis namens `src`. 
7. Erstelle eine TypeScript-Datei mit dem Namen `index.ts` im Verzeichnis src und schreibe darin eine Funktion, welche einen Parameter entgegennimmt und diesen ausgibt (Typisiere zuerst den Parameter nicht und prüfe, ob die tsconfig-Datei funktioniert. Wenn die tsconfig-Datei korrekt ist, wird die IDE folgendes anzeigen: `Parameter '' implicitly has an 'any' type.ts`). Rufe danach in diesem File die Funktion mit dem Parameter `HelloWorld!` auf.
8. Transpiliere die TypeScript-Datei.
9. Führe die JS-Datei aus.

In der Konsole solltest du `HelloWorld!` sehen.


## Aufgabe 2
![task2](/images/task.png) - Einzelarbeit

Lade die <a href="/files/exams/angular/uebung2.ts" download>Datei</a> herunter und fülle wo nötig Quellcode ein.
Die Person soll sich folgendermassen vorstellen:
```
Hallo, mein Name ist [Name].
```

Die Grundstruktur, sowie die letzten 2 Codezeilen dürfen nicht verändert werden.


## Aufgabe 2.1
![task3](/images/task.png) - Einzelarbeit

In dieser Übung wollen wir die Vererbung in einem Fallbeispiel anwenden.
Wir erweitern in dieser Aufgabe den Quellcode von Übung 2.
Erstelle dazu am Besten gleich eine neue Datei und kopiere den Quellcode von Aufgabe 2.
Lösche die letzten 2 Zeilen, sodass nur noch die Klasse "Person" übrig ist.
Erstelle anschliessend die Klasse `Friend`, welche die Klasse `Person` erbt.
Diese Klasse soll die Methode `timeKnown()`, sowie `introduceSelf()` der Parent-Klasse zur Verfügung stellen.
Die Methode `timeKnown()` soll folgendes ausgeben können: "Wir sind Freunde seit [AnzahlJahre] Jahren"
Achte also darauf, welche zusätzlichen Eigenschaften `Friend` besitzen muss.
Erstelle am Schluss (wie bei Übung 2) eine neue Instanz von `Friend"` Verwende als Parameter "Peter" und "5".
Führe dann `introduceSelf()` und `timeKnown()` aus.

In der Konsole sollte Dir nun folgendes angezeigt werden.

*Hallo, mein Name ist Peter*

*Wir sind Freunde seit 5 Jahren*


## Aufgabe 3
![task4](/images/task.png) - Einzelarbeit

Lade <a href="/files/exams/angular/uebung3.ts" download>diese Datei</a> herunter.
In dieser Aufgabe wollen wir Benutzereingabe in der Konsole verarbeiten.
Dazu verwenden wir in diesem Beispiel readline(https://nodejs.org/api/readline.html) von NodeJS.
Wir wollen nun ein kleines Programm schreiben, welches wie folgt aussieht.

```console
Wie ist dein name? Hansli
hallo Hansli
War diese Aufgabe lehrreich für dich= [j / n]j
Super!
```
```console
Wie ist dein name? Hansli
hallo Hansli
War diese Aufgabe lehrreich für dich= [j / n]n
Schade! :(
```
Zuerst wird der Anwender nach seinem Namen gefragt.
Danach wird er begrüsst.
Und anschliessend wird gefragt ob diese Aufgabe lehrreich für ihn war.

Fülle in der Aufgabendatei den benötigten Code an den entsprechenden Stellen ein.

![asset](/images/hint.png) - Info zu readline.

Um readline benutzen zu können, musst du erst den entsprechenden npm-Befehl ausführen.
Achte darauf, dass du den Befehl im selben Verzeichnis ausführst, indem sich die .ts-Datei befindet!


## Aufgabe 4
Implementiere eine Funktion, welche den Durchschnitt eines Numberarrays berechnet.
Die Funktion sollte nur Numberarrays akzeptieren und eine einzelne Zahl zurückgeben. Wenn das Array jedoch leer ist sollte `NaN` (Not a Number) zurückgegeben werden.


## Aufgabe 5
Implementiere eine `User` Klasse mit den Properties `name` und `email`.
Die Klasse besitzt zwei Funktionen, eine um die email zu validieren (mit dem Format "example@example.com") und die andere um einen Begrüssungsnachricht zu erhalten in welcher der Name und die Email genannt wird.


## Aufgabe 6
Implementiere eine `ShoppingCart` Klasse, welche den ShoppingCart eines Onlineshops repräsentieren soll.
Die Klasse sollte Funktionen für das hinzufügen von Produkten, dem Errechnen des gesamten Preises und für das Anzeigen der sich im ShoppingCart befindenden Produkten haben.
Ein Produkt sollte einen `name` und `price` haben.

