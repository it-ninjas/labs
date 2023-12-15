---
title: "Basics zu HTML"
linkTitle: "Basics zu HTML"
weight: 3
description: >
    Modul #F3 - HTML und CSS - Der Aufbau eines HTML-Tags
---

#### Ziele
* Ich kenne die HTML-Tags `<h1>` und `<p>` und weiss, was ihre Aufgaben sind.
* Ich kenne die allgemeine Struktur von HTML-Tags.

## Erklärung zum vorherigen Beispiel
Im vorherigen Beispiel hatten wir diesen Code:

```html
<h1>Kleiner Witz</h1>

<p>Wie viele Softwareentwickler braucht man, 
um eine Glühbirne auszuwechseln?</p>

<p>Keinen, das ist ein Hardware-Problem!</p>
```

Du hast gesehen, dass das zwischen `<h1>` und `</h1>` wie ein Titel formatiert wurde, und dass der Text zwischen `<p>` und `</p>` in eigenen Abschnitten dargestellt wurde.

## HTML Tags

Du hast schon die ersten "HTML Tags" kennengelernt: `<h1>` und `<p>`. `<h1>` wird für Titel und `<p>` wird für Paragrafen verwendet.

HTML Tags sind wie Keywords (Schlüsselbegriffe), die beschreiben, wie der Browser deren Inhalt (Content) formatiert bzw. darstellt.

Die Tags inklusiv deren Inhalt nennen wir "Element". Das Element ist wie folgt aufgebaut:

![htmlElement](../html-tag.svg "(Bild, das den Aufbau eines HTML-Elements zeigt.)")

Jedes Element beginnt mit einem "Opening Tag". Zwischen diesem und dem Closing Tag befindet sich der Content, der auf Grundlage des Tags formatiert wird. Der Content wird oft "InnerText" oder "InnerHtml" genannt. Das Closing Tag hat immer vor dem Tag-Namen ein "/", das symbolisiert, dass es sich um ein Closing Tag handelt.

Im Opening Tag können Attribute vorkommen, die den Tag "konfigurieren". Eine solche Konfiguration beinhaltet in den meisten Fällen ein Attribut-Key und -Value, welche mit einem Gleichzeichen verbunden werden. Der Attribut-Value (Wert) beginnt und endet IN JEDEM FALL mit einem Anführungs- bzw. Schlusszeichen, auch wenn der Wert eine Zahl oder true bzw. false ist.
