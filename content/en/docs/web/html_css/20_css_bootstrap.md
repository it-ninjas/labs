---
title: "Bootstrap"
type: docs
linkTitle: "Bootstrap"
weight: 20
date: 2022-04-19
description: >
  Modul #F3 - HTML und CSS - Einmal CSS schreiben genügt! Brauch ein CSS-Framework, damit wir nicht
  immer wieder die gleichen CSS-Regeln schreiben.
---

In Frontend-Projekten wirst du dich immer wieder fragen, ob bereits ein Objekt
gleich gestylt wurde wie eines, welches du gerade stylen möchtest. Du wirst es aber
vielleicht nicht finden oder du schreibst die genau gleiche Regel ein weiteres Mal.
Das führt dazu, dass im Code sehr viele CSS-Leichen zu finden sein werden.

Um diesem Problem entgegenzuwirken, verwendet man oft eine CSS-Datei, die für das
ganze Projekt gelten soll.

Wenn du aber oft das Projekt wechselst, wirst du aber nicht den Überblick haben
oder bekommen, was für ein Konzept früher im CSS-Code versucht wurde umzusetzen.

Aus diesem Grund kann es Sinn machen, projekt-übergreifend ein gleiches CSS-Framework
zu verwenden, wo die gleichen CSS-Klassen immer gleich heissen.

Hier kommt Bootstrap ins Spiel: Es bietet viele CSS-Klassen bereits an und
vereinfacht komplexes Styling teilweise extrem. Z.B. kannst du komplett mühelos
Accordions (bzw. Tabs) erstellen, die dann beim Klick auf deren Titel ihren Inhalt dann anzeigen/verstecken inkl. Animation.

## Bootstrap
Bootstrap wird in sehr vielen Projekten bereits benutzt. Und so einfach kannst du es auch in deine HTML-Dateien einbinden:

```html
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
```

Eine grosse Stärke von Bootstrap ist es, dass sich deine Seite 'responsive' verhält: Du kannst mit einer CSS-Klasse (`col-md-4` z.B.) definieren, dass ein Element im Normalfall 4/12 der Breite einnimmt (4 ist in der Klasse angegeben, Bootstrap arbeitet mit 12 Spalten). Ist dein Browser weniger breit als eine bestimmte Weite (`md` -> medium), so werden dann die Elemente automatisch untereinander angezeigt.

Da wir vermehrt Bootstrap einsetzen möchten, empfehlen wir dir, Bootstrap anzuschauen. Hier findest du ein Tutorial zur aktuellen Version: https://www.w3schools.com/bootstrap5/index.php.

Bitte probiere folgendes so aus, dass du es anwenden kannst:
* GET Started
* Containers
* Grid Basic
* Tables
* Buttons
* Collapse
* Flex

Bei den folgenden solltest du einfach wissen, dass Bootstrap hierfür auch eine Lösung bereitstellt:
* Colors
* Images
* Alerts
* Button Groups
* Badges
* Progress Bars & Spinners
* Pagination
* List Groups
* Cards
* Dropdowns
* Navbar
* Carousel
* Modal
* Tooltip
* Popover
* Toast
* Scrollspy
* Utilities
* alles unter Forms

![asset](/images/hint.png) Hierzu findest du eine [Aufgabe im Lab](../../../../labs/web/html_css/02_css).
