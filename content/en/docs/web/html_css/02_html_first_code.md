---
title: "Erste Seite erstellen"
linkTitle: "Erste Seite erstellen"
weight: 2
description: >
  Modul #F3 - HTML und CSS - Erste HTML-Seite erstellen
---

#### Ziele

- Ich weiss, wie ich eine HTML-Seite erstellen kann.
- Ich weiss, wie ich meine erstellte HTML-Seite im Browser anschauen kann.

## Eine HTML-Seite mit formatiertem Text erstellen

Wir beginnen ganz unkompliziert und erstellen eine Seite, welchen einen simplen Text darstellt. Dafür musst du zuerst einen Ordner erstellen, in dem du später deine Projekt-Dateien speichern kannst. Anschliessend kannst du diesen Ordner mit der IDE (Integrated Development Environment = Entwicklungsumgebung) deiner Wahl öffnen (hier VS Code). Erstelle nun eine neue HTML-Datei im soeben erstellten Ordner. In VS Code kannst du das z.B. wie folgt machen:

![createFile](../vs-code-create-file.png "Erstelle eine neue Datei, indem du im Explorer von VS Code mit deiner Maus über deinen Ordner bewegst. Klicke dann auf das Datei-Symbol und gib einen Dateinamen an, der mit .html endet.")

Fülle diese Datei nun mit einem beliebigen Text und speichere deine Änderungen (beispielsweise mit "ctrl" + "s". Kopiere jetzt den Pfad zu dieser Datei. In VS Code kannst du den Pfad mit einem Rechtsklick auf die Datei kopieren:

![copyPath](../vs-code-copy-path.png " ")

Gib diesen Pfad im Browser deiner Wahl ein. Du solltest nun einen unformatierten Text im Browser sehen:

![unformatedHtmlFile](../unformated-html-file.png " ")

Obwohl du vorher vielleicht Zeilenumbrüche und mehrere Leerschläge hattest, sind diese im Browser nun nicht sichtbar. Willst du deinen Text strukturieren, kannst du den Text mithilfe von HTML-Tags formatieren. Der HTML-Code könnte dann zum Beispiel so aussehen:

```html
<h1>Kleiner Witz</h1>

<p>
  Wie viele Softwareentwickler braucht man, um eine Glühbirne auszuwechseln?
</p>

<p>Keinen, das ist ein Hardware-Problem!</p>
```

Nun hast du eine Seite mit formatiertem Text:

![formatedHtmlFile](../formated-html.png " ")

Was wir hier genau gemacht haben, erfährst du auf der nächsten Seite.
