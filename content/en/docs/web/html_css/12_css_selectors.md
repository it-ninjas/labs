---
title: "CSS-Selektoren"
type: docs
linkTitle: "CSS-Selektoren"
weight: 12
date: 2022-04-14
description: >
  Modul #F3 - HTML und CSS - Die verschiedenen CSS-Selektoren.
---

## Was gibt es für CSS-Selektoren?

Nun da wir die Grundlagen von CSS gelernt haben, können wir uns die Selektoren genauer anschauen. 
Die Selektoren bestimmen, für welche HTML-Elemente die CSS-Regeln gelten ("ziehen").

## Selektoren im Überblick

Es gibt verschiedenste Selektoren, welche alle ihren eigenen Nutzen haben. In der folgenden Tabelle werden die gängigsten aufgezählt und erklärt.

| Name    | Anwendung in HTML    | Anwendung in CSS       | Beschreibung                                                                                                                                                                                                                                                                                         |
| ------- | -------------------- | ---------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Klasse  | `class="demo-class"` | `.demo-class {...}`    | CSS-Klassen können mit dem "class"-Attribut auf jedes beliebige HTML-Element angewendet und dann im CSS referenziert werden. Klassen können dabei auf mehrere Elemente gegeben werden, was das Wiederverwenden der CSS-Regeln ermöglicht.                            |
| ID      | `id="demo-id"`       | `#demo-class {...}`    | IDs können mit dem "id"-Attribut auf jedes beliebige HTML-Element angewendet werden. Grundsätzlich sollten IDs eindeutig sein, d.h. nicht an mehreren Orten verwendet werden.                                                                                                                        |
| Element | `<element-name></element-name>` | `"element-name" {...}` | Um alle HTML-Elemente eines Types auszuwählen, muss man nichts spezielles im HTML anpasse. Es muss einfach gegeben sein, dass die Elemente auch tatsächlich vorhanden sind. Im CSS muss man dann nur noch den Element-Namen angeben (im Beispiel zu ersetzen mit z.B. `a`, `p`, `input`, `body`), wobei keine Prefixes notwendig sind. |

Im nächsten Beispiel werden diese 3 Möglichkeiten verwendet:

```html
<form class="round-container">
    <p>Bitte gib deinen Namen ein:</p>
    <label for="your-name">Name</label>
    <input type="text" id="your-name" name="name">
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

In diesem Beispiel wurde die frei erfundene Klasse `round-container`, die ID `your-name` und das Element `label` mit CSS versehen.

## Spezifischere Selektoren
### Element auf Grund eines Attributes setzen
Es kann vorkommen, dass du ein Element mit einem spezifischen Attribut stylen musst. Möchtest du z.B. alle Submit-Buttons stylen, dann könnte dir dieser Selektor weiterhelfen: `input[type=submit] {...}`

Es gibt aber auch die Möglichkeit, ob der Attribut-Wert einen bestimmten Text enthält, damit beginnt bzw. endet. Hierfür sei auf diese Seite verwiesen: https://www.w3schools.com/cssref/css_selectors.asp

### Spezifisches Element mit Klasse
Möchtest du z.B. alle `<form>`-Elemente, die die Klasse `round-container` enthalten, stylen, dann möchtest du wahrscheinlich folgenden Selektor: `form.round-container {...}`

### Elemente, die sich in einem anderen Element befinden müssen
Möchtest du z.B. alle `label`s stylen, die sich in einer `form` befinden, dann verwende so etwas: `form label {...}`. Zuerst kommt das übergeordnete Element, dann dasjenige, das tiefer verschachtelt ist. Die Elemente werden mit einem Leerzeichen voneinander getrennt. Bei diesem Selektor spielt es keine Rolle, ob `label` direkt in `form` ist, Hauptsache `label` befindet sich innerhalb einer `form`.

Ist es hingegen relevant, dass der `label` direkt in der `form` kommt (also keinen anderen Parent hat als `form`), dann benutze folgende Regel: `form > label {...}`. Bei diesem Selektor bedeutet das `>`, dass das erste Element der Parent vom zweiten Element sein muss.

### Pseudoklassen
Mithilfe von Pseudoklassen kann einen besonderen Zustand abgefragt werden. Mit `:hover` können CSS-Regeln z.B. auf Elemente beschränkt werden, wenn sich diese unterhalb des Mauszeigers befinden.

Mit dem nächsten Selektor kannst du z.B. das Aussehen beim Darüber-"Hovern" (also wenn der Mauszeiger darüber ist) vollständig verändern:
```css
input[type=submit]:hover {
    background-color: orange;
    color: white;
}
```

Für `<input>`-Elemente könnten Pseudoklassen wie `:disabled` oder `:checked` (Checkboxen) noch interessant sein.

Du hast aber auch Zugriff auf völlig andere Sachen! Du kannst z.B. den ersten Buchstaben einem Paragraphen z.B. automatisch gross schreiben lassen:

```css
p:first-letter {
    font-size: 200%;
}
```

Viele weitere interessante Pseudoklassen findest du hier beschrieben: https://web.dev/learn/css/pseudo-classes/