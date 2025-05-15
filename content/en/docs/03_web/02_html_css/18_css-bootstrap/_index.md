---
title: "Bootstrap"
type: docs
linkTitle: "Bootstrap"
weight: 19
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Einmal CSS schreiben genügt! Brauch ein CSS-Framework, damit du nicht
  immer wieder die gleichen CSS-Regeln schreiben musst.
---

In Frontend-Projekten wirst du immer wieder mit der Frage konfrontiert sein, ob bereits ein Objekt
gleich gestylt wurde wie eines, welches du gerade stylen möchtest. Wenn dem so ist, wirst du es aber
eventuell nicht finden, womit du dieselbe Regel je nachdem zweimal schreiben müsstest.
Das führt oft dazu, dass im Code viele "CSS-Leichen" zu finden sind.

Um diesem Problem entgegenzuwirken, verwendet man oft eine CSS-Datei, die für das
ganze Projekt gelten soll. (styles.css)

Wenn du aber oft das Projekt wechselst, wirst du nicht den Überblick behalten können,
welche Konzepte vorgehend mit CSS umgesetzt wurden.

Aus diesem Grund kann es Sinn machen, projektübergreifend ein standardisiertes CSS-Framework
zu verwenden, wo die gleichen CSS-Klassen auch immer den gleichen Namen verwenden.

Hier kommt Bootstrap ins Spiel: Das Framework stellt viele CSS-Klassen bereit und
vereinfacht komplexes Styling zum Teil enorm. Du kannst beispielsweise komplett mühelos
Accordions (beziehungsweise Tabs) erstellen, die dann beim Klick auf deren Titel ihren Inhalt jeweils anzeigen oder verstecken.

## Bootstrap

Bootstrap wird in sehr vielen Projekten bereits benutzt. Das Framework in eine HTML-Datei einzubinden ist relativ einfach:

```html
<!-- Latest compiled and minified CSS -->
<link
  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
  rel="stylesheet"
/>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
```

Eine grosse Stärke von Bootstrap ist es, dass sich deine Seite 'responsive' verhält: Du kannst mit einer Bootstrap-Klasse (`col-md-4`) definieren, dass ein Element im Normalfall 4/12 der Breite einnehmen soll (4 ist in der Klasse angegeben, Bootstrap arbeitet mit 12 Spalten). Ist dein Browser weniger breit als eine bestimmte Weite (`md` -> medium), so werden dann die Elemente automatisch untereinander angezeigt.

Da wir vermehrt Bootstrap einsetzen möchten, empfehlen wir dir, das Framework genauer anzuschauen. Hier findest du ein Tutorial zur aktuellen Version: https://www.w3schools.com/bootstrap5/index.php.

Bitte schaue die folgenden Kapitel so weit an, dass du die behandelten Punkte praktisch anwenden kannst:

- GET Started
- Containers
- Grid Basic
- Tables
- Buttons
- Collapse
- Flex

Von den folgenden Abschnitten solltest du lediglich mitnehmen, dass Bootstrap für die behandelten Fälle auch Lösungen bereitstellt:

- Colors
- Images
- Alerts
- Button Groups
- Badges
- Progress Bars & Spinners
- Pagination
- List Groups
- Cards
- Dropdowns
- Navbar
- Carousel
- Modal
- Tooltip
- Popover
- Toast
- Scrollspy
- Utilities
- alles unter Forms

![asset](/images/hint.png) Hierzu findest du die [Aufgabe 6 im Lab](../../../../labs/03_web/01_html-css/02_css).
