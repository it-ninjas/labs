---
title: "CSS-Selektoren"
type: docs
linkTitle: "CSS-Selektoren"
weight: 12
date: 2022-04-14
description: >
  Modul #F3 - HTML und CSS - Die verschiedenen CSS-Selektoren.
---

#### Ziele

- Ich weiss, was CSS-Selektoren sind und wofür sie verwendet werden.
- Ich kenne die verschiedenen Arten von CSS-Selektoren und ihre jeweiligen spezifischen Anwendungsfälle.
- Ich kann CSS-Selektoren gezielt in HTML-Dokumenten anwenden.

## Welche CSS-Selektoren gibt es?

Nun da wir die Grundlagen von CSS gelernt haben, können wir uns die Selektoren genauer anschauen.
Die Selektoren bestimmen, für welche HTML-Elemente die definierten CSS-Regeln gelten.

## Selektoren im Überblick

Es gibt verschiedenste Selektoren, welche alle ihren eigenen Nutzen erfüllen. In der folgenden Tabelle werden die gängigsten aufgezählt und erklärt:

| Name    | Anwendung in HTML               | Anwendung in CSS     | Beschreibung                                                                                                                                                                                                                                                                                                                                                              |
| ------- | ------------------------------- | -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Klasse  | `class="demo-class"`            | `.demo-class {...}`  | CSS-Klassen können mit dem "class"-Attribut auf jedes beliebige HTML-Element angewendet und dann in CSS referenziert werden. Klassen können dabei auf mehrere Elemente angewandt werden, was das Wiederverwenden der CSS-Regeln ermöglicht. Ein HTML-Element kann auch mehrere Klassen haben.                                                                             |
| ID      | `id="demo-id"`                  | `#demo-class {...}`  | IDs können mit dem "id"-Attribut auf jedes beliebige HTML-Element angewendet werden. Grundsätzlich sollten IDs eindeutig sein, also nicht an mehreren Orten verwendet werden.                                                                                                                                                                                             |
| Element | `<element-name></element-name>` | `element-name {...}` | Um alle HTML-Elemente eines Types auszuwählen, muss man nichts Spezielles in HTML anpassen. Es muss lediglich der Umstand gegeben sein, dass die angesprochenen Elemente auch tatsächlich vorhanden sind. Im CSS muss man dann nur noch den Element-Namen angeben (im Beispiel zu ersetzen mit z.B. `a`, `p`, `input`, `body` etc.), wobei keine Prefixes notwendig sind. |

Im nächsten Beispiel werden alle 3 Möglichkeiten einmal angewandt:

```html
<form class="round-container">
  <p>Bitte gib deinen Namen ein:</p>
  <label for="your-name">Name</label>
  <input type="text" id="your-name" name="name" />
  <input type="submit" />
</form>

<style>
  .round-container {
    width: 20em;
    background-color: lightgrey;
    border-radius: 2em;
    padding: 1em;
  }
  #your-name {
    background-color: orange;
  }
  label {
    font-weight: bold;
  }
</style>
```

In diesem Beispiel wurden das `<form>`-Element mit der Klasse `round-container`, das `<input>`-Element mit der ID `your-name` und das Element `label` mit einer Designanpassung per CSS versehen.

## Spezifischere Selektoren

### Element aufgrund eines spezifischen Attributes stylen

Es kann vorkommen, dass du ein Element mit einem spezifischen Attribut stylen willst. Möchtest du z.B. alle Submit-Buttons stylen, kannst du das mit diesem Selektor bewerkstelligen: `input[type=submit] {...}`

Es besteht aber auch die Möglichkeit, dass der Attribut-Wert einen bestimmten Text enthält, damit beginnt oder damit endet. Für diesen Fall sei auf diese Seite verwiesen: https://www.w3schools.com/cssref/css_selectors.asp

### Spezifisches Element per Klasse stylen

Möchtest du alle `<form>`-Elemente stylen, denen die Klasse `round-container` zugewiesen ist, dann kannst du den folgenden Selektor verwenden: `form.round-container {...}`

### Elemente, die sich in einem anderen Element befinden müssen

Möchtest du alle `label`-Elemente stylen, die sich in einem `form`-Element befinden, dann verwende den folgenden Selektor: `form label {...}`. Zuerst kommt das übergeordnete Element, dann dasjenige, das tiefer verschachtelt ist. Die Elemente werden mit einem Leerzeichen voneinander getrennt. Bei diesem Selektor spielt es keine Rolle, ob `label` genau eine Stufe innerhalb von `form` ist. Es ist lediglich die Frage, ob sich überhaupt ein `<label>`-Element darin befindet.

Ist es hingegen relevant, dass das `label` direkt als erste weitere Stufe in der `form` vorkommt (also keinen anderen Parent hat als `form`), dann benutze folgende Regel: `form > label {...}`. Bei diesem Selektor bedeutet das `>`, dass das erste Element der Parent vom zweiten Element sein muss.

### Pseudoklassen
Mithilfe von Pseudoklassen kann ein besonderer Zustand abgefragt werden. Mit `:hover` können CSS-Regeln beispielsweise auf Elemente beschränkt werden, über welchen sich derzeit der Mauszeiger befindet.
Dazu nachfolgend ein Beispiel:
```css
input[type="submit"]:hover {
  background-color: orange;
  color: white;
}
```

Für `<input>`-Elemente sind Pseudoklassen wie `:disabled` oder `:checked` (für Checkboxen) relevant, welche den Zustand des `<input>`-Elements als Kondition haben.

Du hast des Weiteren aber auch Zugriff auf völlig andere Aspekte! Du kannst zum Beispiel auch den ersten Buchstaben einem Paragrafen automatisch grossschreiben lassen:

```css
p:first-letter {
  font-size: 200%;
}
```

Viele weitere Pseudoklassen findest du hier beschrieben: https://web.dev/learn/css/pseudo-classes/
