---
title: "HTML Formulare"
linkTitle: "HTML Formulare"
weight: 5
description: >
  Modul #F3 - HTML und CSS - Formular-Daten mit HTML verschicken.
---

#### Ziele

- Ich weiss, wozu HTML-Formulare benutzt werden.
- Ich kenne die folgenden HTML-Formular-Elemente und weiss wie ich sie benutzen kann:  
  input, label, button, checkbox, date, email, file, hidden, number, password und radio
- Ich kann ein HTML-Formular erstellen und die Werte aus dem Formulare an einem Backend verschicken.

## Wieso HTML-Formulare?

Die Benutzer deiner Webseite möchten oder sollen Daten eingeben können, z.B. für ein Kontakt-Formular, eine Login-Seite oder für Bestellungen. HTML-Formulare ermöglichen genau das, auch ohne JavaScript.

## HTML-Input-Element

Bevor wir uns HTML-Formulare genauer anschauen, wollen wir zuerst einen Blick auf Input-Elemente werfen, die das Eingeben von Daten überhaupt ermöglichen.

Beginnen wir mit einer einfachen TextBox:

```html
Was ist dein Vorname? <input type="text" name="firstname" />
```

Probiere alle Beispiele immer selbst aus. Der obige Code reicht bereits aus, um eine einfache TextBox in HTML einzubinden.

Das `type`-Attribut definiert, um was für eine Art von Input-Element es sich handelt. `text` steht für eine gewöhnliche TextBox. Das zweite Attribut kannst du im Moment noch ignorieren.

## Label für Input-Elemente

Vor einem Input-Element steht meistens ein Text, der beschreibt, was im `<input/>`-Element eingegeben werden soll ("Was ist dein Vorname"). Dieser Text wird auch "Label" genannt. Bei einer guten Webseite wird zudem die TextBox ausgewählt, wenn der User auf das Label klickt (nicht nur beim Klick auf die TextBox). Diese Funktionalität wollen wir hinzufügen:

```html
<label>Was ist dein Vorname?<input type="text" name="firstname" /></label>
```

Die gewünschte Funktionalität haben wir so hinzufügen können. Aber was genau haben wir hier gemacht?

Wir haben das Label als Label definiert (da im `label`-Element). Wenn wir ein Input-Element in einem Label hinzufügen, dann wird bei einem Klick auf dieses Label automatisch dieses Input-Element fokussiert.

Nun sieht das noch ein bisschen unübersichtlich aus. Das können wir besser! Zum Beispiel so:

```html
<label for="firstname">Was ist dein Vorname?</label>
<input id="firstname" type="text" name="firstname" />
```

Abgesehen davon, dass das Input-Element nicht mehr im Label ist, ist der grosse Unterschied:

- dass das Input-Element nun ein `id`-Attribut hat
- und dass der Label mit dem `for`-Attribut darauf referenziert.

Fassen wir zusammen, weshalb wir das `label`-Element verwenden:

- Beim Klick auf das Label wird das entsprechende Input-Element ausgewählt.
- Beim Klick in das entsprechende Input-Element würde ein Screen-Reader den Namen des Labels laut vorlesen, (falls verwendet).
- Und ausserdem können die Labels auf diese Weise einfacher gestylt werden.

## Weitere Input-Elemente

In HTML gibt es sehr viele weitere Input-Elemente. Eine grössere Liste findest du hier: https://www.w3schools.com/html/html_form_input_types.asp

Kennen solltest du sicher die folgenden:

- button
- checkbox
- date
- email
- tel
- file
- hidden
- number
- password
- radio

Bitte schaue dir diese Elemente auf der obengenannten Seite rasch an. Du solltest wissen, wie diese Elemente aussehen und dass es sie gibt.

## Formulare

Nun solltest du im Stande sein, UI-Elemente (UI = User Interface -> Benutzerschnittstelle) mit HTML auf einer Seite anzuzeigen. Jetzt wäre es schön, wenn diese Daten auch irgendwie verwendet werden könnten.

Theoretisch könntest du mit der Programmiersprache JavaScript direkt darauf zugreifen. Im Moment wollen wir aber bei HTML bleiben. Was wir mit HTML machen können, ist, die Werte an ein Backend (=Server) zu schicken.

Als Backend verwenden wir die folgende URL: https://www.w3schools.com/action_page.php. Das ist eine spezielle Seite: sie zeigt die Daten an, die wir ihr schicken.

Folgender Code zeigt ein Formular, das eine E-Mail und ein Boolean beim Klick auf "Übermitteln" an das Backend schickt

```html
<form action="https://www.w3schools.com/action_page.php" method="get">
  <label for="email">Email:</label
  ><input type="email" name="email" id="email" required />
  <br />
  <input type="checkbox" name="interested" id="interested" />
  <label for="interested">Newsletter abonnieren</label>
  <br />
  <input type="submit" value="Übermitteln" />
</form>
```

Entscheidend ist hier das `<form>`-Tag. Das `action`-Attribut legt fest, wo die Daten hingeschickt werden. Die `method` legt fest, welche HTTP Request Method verwendet wird (GET oder POST). Bist du dir bei den Methoden nicht mehr so sicher, dann schaue bitte das "REST"-Kapitel hier noch einmal an: https://labs.it-ninjas.ch/docs/java/spring_introduction/#625-rest

Bei Formularen verwendet man meistens entweder GET oder POST. Obwohl beide zum selben Resultat führen, unterscheiden sie sich trotzdem grundlegend voneinander. Die zu verwendende Methode wird meistens vom Backend festgelegt. Unser Backend unterstützt beide Methoden.

### GET

Bei der GET-Methode werden die Daten, die an den Server gesendet werden sollen, direkt in die URL geschrieben. Sie können in der Adresszeile des Browsers im Klartext angesehen werden.

https://www.w3schools.com/action_page.php?email=hello@world.com&interested=on

**Vorteile**

Da die Parameter zusammen mit der URL gespeichert werden können, lassen sich für bestimmte Abfragen auch Lesezeichen (Bookmarks) anlegen und die Seite kann über den Browserverlauf "zurückgeholt" werden.

**Nachteile**

Hauptnachteil ist der fehlende Datenschutz.. Die mtgesendeten URL-Parameter werden nicht nur unverschlüsselt übertragen, sondern auch im Klartext im Cache, im Browserverlauf und im Logfile des Servers abgelegt. Deshlb sollten die Login-Daten, alsio insbesondere ein Passwort, besser mit POST übertragen werden.
Ein weiterer Nachteil besteht in der beschränkten Kapazität, je nach Webserver und Browser ist die maximale Länge der URL auf 2.000 Zeichen begrenzt. URL-Parameter können ausserdem nur ASCII-Zeichen aufnehmen, d.h. Bilder, Videos oder Audiodaten können mit dieser Methode nicht übertragen werden.

### POST

Die POST-Methode schreibt die URL-Parameter in den HTTP-Request. Sie sind damit für Benutzer nicht sichtbar. Der Umfang der POST-Anfragen ist unbeschränkt.

**Vorteile**

Wenn sensible Daten an den Server übermittelt werden sollen – z. B. das Loginformular mit Benutzername und Passwort –, bietet die POST-Methode die erforderliche Diskretion. Die Daten werden weder im Cache gespeichert, noch erscheinen sie im Browserverlauf.  Mit der POST-Methode können nicht nur kurze Texte, sondern Daten jeglichen Umfangs und Typs übermittelt werden, etwa Fotos oder Videos.

**Nachteile**

Wenn eine Webseite mit einem Formular im Browser aktualisiert wird, müssen die Formulardaten nochmals übermittelt werden. Dabei besteht die Gefahr, dass die Daten versehentlich mehrmals gesendet werden, was etwa bei einem Bestellformular unerwünschte Doppelaufträge auslösen kann. Ebenso können die Daten, die mit der POST-Methode übermittelt werden, nicht zusammen mit der URL als Lesezeichen gespeichert werden.

### Wann sollte welche Methode verwendet werden?

POST wird fast durchwegs bevorzugt, wenn der Anwender Daten oder Dateien an den Server übermitteln muss, beispielsweise bei Formularen mit vielen Daten oder beim Hochladen von Bildern.

GET eignet sich besonders gut für das Personalisieren von Websites: Die Sucheingaben, Filter-Einstellungen und Listensortierungen des Anwenders können zusammen mit der URL als Lesezeichen gespeichert werden, sodass beim nächsten Aufruf die Website exakt so aussieht, wie man es sich wünscht.

Wichtig für das Formular ist, dass es einen `submit`-Button besitzt. Dieser Submit-Button löst das Senden der Daten an die angegebene Url (`action`) mit der entsprechenden HTTP Request Method (`method`) aus. Probiere dieses Formular einmal aus. Du wirst sehen, dass etwas wie Folgendes an den Server übermittelt wird:

```
email=hello@world.com&interested=on
```

Die Daten werden also als Text übermittelt. Die einzelnen Felder werden jeweils mit

```
key=value
```

übermittelt und mit einem "&" miteinander kombiniert. Der `key` stammt jeweils vom `name`-Attribut der Input-Elemente.

Im oben gezeigten Beispiel haben wir bereits eine kleine Validierung (Überprüfung der Eingaben) integriert:

- Einerseits haben wir mit dem `required`-Attribut festgelegt, dass die E-Mail-Box nicht leer sein darf beim Übermitteln.
- Anderseits verbietet `type="email"` das Senden, wenn etwas anderes als eine E-Mail-Adresse eingegeben wird. Aus diesem Grund verwenden wir lieber `type="email"` als `type="text"` für E-Mail-Adressen, `type="tel"` für Telefonnummern und `type="date"` für ein Datum.

### Ein komplexeres Beispiel

Um zu zeigen, wie einfach Input-Elemente verwendet werden könnten, kannst du folgendes Beispiel ausprobieren:

```html
<h2>Login</h2>
<form action="https://www.w3schools.com/action_page.php" method="get">
      <label>email: <input type="email" name="your-email" /></label> <br />
      <label for="pw">password:</label>
  <input type="password" name="your-password" id="pw" />     <br />
     
  <label
    ><input type="checkbox" name="stay" value="yes" />Stay logged in.</label
  >
     
  <h4>Favorite Language?</h4>
     
  <p>
            <input type="radio" id="html" name="fav_language" value="HTML" />  
          <label for="html">HTML</label><br />
            <input type="radio" id="css" name="fav_language" value="CSS" />    
        <label for="css">CSS</label><br />
       
  </p>
      <input type="submit" />
</form>
```

![asset](/images/hint.png) Jetzt bist du dran. Löse bitte die [Aufgabe 1](../../../../labs/web/html_css/01_html#aufgabe-1---input-elemente) in den Labs.
