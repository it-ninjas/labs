---
title: "HTML - Aufgaben"
linkTitle: "HTML - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #F3 - HTML
---

### Aufgabe 1 - Input-Elemente
Um zu zeigen, wie einfach Input-Elemente verwendet werden könnten, kannst du folgendes Beispiel ausprobieren:

```html
<h2>Login</h2>
<form action="https://www.w3schools.com/action_page.php" method="get">
    <label>email: <input type="email" name="your-email" /></label> <br />
    <label for="pw">password:</label> <input type="password" name="your-password" id="pw" />
    <br />
    <label><input type="checkbox" name="stay" value="yes" />Stay logged in.</label>
    <h4>Favorite Language?</h4>
    <p>
        <input type="radio" id="html" name="fav_language" value="HTML">
        <label for="html">HTML</label><br>
        <input type="radio" id="css" name="fav_language" value="CSS">
        <label for="css">CSS</label><br>
    </p>
    <input type="submit" />
</form>

```

Entwickle eine Registrierungsseite. Auf dieser Seite soll man mindestens folgendes angeben müssen:
* Name
* Email
* Gewünschtes Passwort
* Mögliche Interessen (mittels Checkboxen)
* Geburtsdatum
* Lieblingsfarbe
* Geschlecht (mittels Radiobuttons)
* Handynummer

Als Backend kannst du "[https://www.w3schools.com/action_page.php](https://www.w3schools.com/action_page.php)" (wie im vorherigen Beispiel) verwenden. Schaue nach dem Klick an, wie die Daten übermittelt worden sind. Wie sieht die URL im Browser aus? Variiere die HTTP Request Method.

### Aufgabe 2 - Inspiziere diese Seite
Suche auf dieser Website (ja, auf dieser IT Ninjas-Seite) mit Hilfe der Entwicklertools ([F12]-Taste) den `<header>`, eine `<nav>` und den `<footer>`.

Notiere dir deine Erkenntnisse. Versuche zudem folgende Fragen zu beantworten:

1. Wie ist diese Seite aufgebaut? Wo befinden sich `<header>`, `<nav>`, usw.? Halte das in einer Skizze fest.
2. Wie wurde die Übersicht (am linken Rand) und das rechte Aside (mit Git-Informationen) realisiert. Welche Tags und Attribute sind deiner Meinung nach die relevantesten?
3. Würdest du das gleich realisieren? Oder was würdest du anders machen?

### Aufgabe 3 - Dokument als HTML
Suche einen spanneden Text (z.B. aus einer alten Word-Datei, Wikipedia-Artikel, Anleitung). Dieser Text sollte mehrere Überschriften und Bilder besitzen. Setze diesen Text mit HTML um und versuche bereits, viele Semantic Tags zu verwenden. Zeige dein Resultat einem Coach.

### Aufgabe 4 - persönliche Portfolio
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
