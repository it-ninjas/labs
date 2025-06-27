---
title: "Basics zu HTML"
linkTitle: "Basics zu HTML"
weight: 3
description: >
  Modul #F3 - HTML und CSS - Der Aufbau eines HTML-Tags
---

#### Ziele

- Ich kenne die HTML-Tags `<h1>` und `<p>` und weiss, wofür ich diese verwende.
- Ich kenne die allgemeine Struktur und den Aufbau von HTML-Tags.

## Erklärung zum vorherigen Beispiel

Im vorherigen Beispiel hatten wir diesen Code:

```html
<h1>Kleiner Witz</h1>

<p>
  Wie viele Softwareentwickler braucht man, um eine Glühbirne auszuwechseln?
</p>

<p>Keinen, das ist ein Hardware-Problem!</p>
```

Du hast gesehen, dass der Teil zwischen `<h1>` und `</h1>` wie eine Überschrift formatiert wurde, und dass die jeweiligen Texte zwischen `<p>` und `</p>` in eigenen Abschnitten dargestellt wurden.

## HTML Tags

Damit hast du bereits die ersten "HTML Tags" kennengelernt: `<h1>` und `<p>`. `<h1>` wird für Überschriften und `<p>` für Absätze verwendet.

HTML Tags sind wie Keywords (Schlüsselbegriffe), die beschreiben, wie der Browser deren Inhalt (Content) interpretiert.

Die Tags inklusive deren Inhalt nennen wir "Element". Das Element ist wie folgt aufgebaut:

![htmlElement](images/html-tag.svg "(Bild, das den Aufbau eines HTML-Elements zeigt.)")

Jedes Element beginnt mit einem "Opening Tag". Zwischen diesem und dem Closing Tag befindet sich der Content, der auf Grundlage des Tags formatiert wird. Der Content wird oft "InnerText" oder "InnerHtml" genannt. Das Closing Tag hat immer vor dem Tag-Namen ein "/", das symbolisiert, dass es sich um ein Closing Tag handelt.

Im Opening Tag können Attribute vorkommen, die den Tag "konfigurieren". Eine solche Konfiguration beinhaltet in den meisten Fällen einen Attribut-Key und -Value, welche mit einem Gleichzeichen verbunden werden. Der Attribut-Value (Wert) beginnt und endet **in jedem Fall** mit einem Anführungs- beziehungsweise Schlusszeichen, auch wenn der Wert eine Zahl oder true/false ist.
