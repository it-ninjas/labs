---
title: "CSS - Aufgaben"
linkTitle: "CSS - Aufgaben"
type: docs
weight: 2
description: >
  Aufgaben zu Modul #F3 - CSS
---

### Aufgabe 1 - Header-Navigation

![task1](/images/task.png) Erstelle nachfolgende Seite.

Der Schwerpunkt ist die Navigation im Header: Das Bild und die Links auf der rechten Seite.

![exFlexNav](../ex_flexbox-navigation.jpeg "So soll deine Seite mit Navigation ungefähr aussehen.")

### Aufgabe 2 - relative Positionierung
In Aufgabe 1 hast du eine Seite mit Header und Navigation erstellt.

![task2](/images/task.png) Adjustiere dort das Bild oben links.

### Aufgabe 3 - persönliche Portfolio
Erstelle eine reine HTML-Webseite, welche dein persönliches Portfolio darstellt.
Die Seite soll folgende Struktur und Elemente beinhalten:

**Navigation**

Die Navigation besteht auf drei Elemente:
* Über mich
* Hobbies
* Kontakt

Beim Klicken auf einem Navigationsitem wird die Anzeige entsprechend geändert. Dazu siehe folgende Abschnitte.

**Über mich**

Wenn man auf "Über mich" klickt, erscheint eine ähnliche Seite wie hier dargestellt:  
![](../01_about.png)

**Hobbies**

Wenn man auf "Hobbies" klickt, erscheint eine ähnliche Seite wie hier dargestellt:  
![](../01_hobbies.png)

Die Texte unterhalb der Fotos sind Links auf entsprechende Webseiten, welche in einem neuen Browserfenster/-tab geöffnet werden.

**Kontakt**

Wenn man auf "Kontakt" klickt, erscheint eine ähnliche Seite wie hier dargestellt:  
![](../01_kontakt.png)

Wenn man auf "Github" oder "Twitter" usw. klickt, wird ein neues Browserfenster mit der richtigen Seite geöffnet

Hinweise:
* Verwende semantische Elemente wo nötig/sinnvoll.
* Hier geht es um die Struktur der Seite, nicht um das Styling. Es ist wichtig, dass die Elemente gemäss der Anforderungen funktionieren und dass das HTML gut strukturiert ist.

### Aufgabe 4 - Info-Box
![task4](/images/task.png) Erstelle eine HTML-Seite (oder erweitere eine andere so, dass) die ganz unten eine Meldung anzeigt mit einem "OK"-Button. 

Inspiriere dich an den nervigen Cookie-Meldungen von anderen Seiten.

Du kannst die Meldung ganz unten oder in der Mitte des Bildschirms anzeigen.

Wenn du willst, kannst du über alles andere ein "Overlay" schmeissen mit einem Transparenzwert von 50 - 90%, damit der User sich automatisch auf die Meldung fokussiert.

Wenn du willst, kannst du alles andere auch verschwommen darstellen. Hierfür könnte das CSS-Property `backdrop-filter` interessant sein, siehe https://www.w3schools.com/cssref/css3_pr_backdrop-filter.php.

Erstelle nun eine Cookie-Meldung wie diese (der weisse Teil mit dem roten Button ist die Meldung, der Rest gehört zum Hintergrund):


![exCookieBanner](../ex_pos_abs_cookie_banner.jpeg)

### Aufgabe 5 - Bootstrap
![task5](/images/task.png) Nachfolgend ist eine Beispiel-Seite. Setze diese mit Bootstrap um:

![pricingPage](../bootstrap-pricing-page-example.jpg)

Schaue dir [diese Seite](https://getbootstrap.com/docs/5.1/examples/pricing/) auf auf kleineren Bildschirmen an - also verändere die Fenster-Breite deines Browsers. Du wirst sehen, dass z.B. die einzelnen Abos untereinander erscheinen, wenn die Breite kleiner wird. Berücksichtige dies auch in deinem Code.

{{% details title="Hinweis" %}}

Solltest du nicht weiterkommen, dann schaue in den Entwickler-Tools ([F12]-Taste) im DOM nach. Da diese Seite auch mit Bootstrap umgesetzt wurde, kannst du nachschauen, welche Bootstrap-Klassen sie verwendet haben.

{{% /details %}}


### Aufgabe 6 - Transitionen
Erstelle einen Fliesstext. Dort drin soll es bestimmte Elemente haben wie z.B. Links. Diese Elemente befinden sich zwingend im Fliesstext.

![task6](/images/task.png) Lasse diese Elemente (z.B. Links) vergrössern und gib' ihnen z.B. einen Border, wenn sich die Maus darüber befindet. Zusätzlich sollen noch weitere Informationen zum Element angezeigt werden.

Beispiel: Auf Wikipedia erscheint eine kleine Ansicht, die eine Kurzbeschreibung beinhaltet, wenn du mit der Maus über einen Wikipedia-Link darüberfährst.

### Aufgabe 7 - Animationen
Hier hattest du ein Beispiel für einen Ladebalken: https://www.w3schools.com/howto/howto_css_loader.asp

Sicherlich kennst du den Ladebalken von Apple. Sieh dir den Cupertino Loading Indicator als GIF hier an: https://flutterawesome.com/a-collection-of-high-fidelity-loading-animations-in-gif-format-with-flutter/

![task7](/images/task.png) Implementiere diesen Loading Indicator. Du darfst gerne ein (aber nicht mehrere) Bild benutzen, welches du dann entsprechend animierst.