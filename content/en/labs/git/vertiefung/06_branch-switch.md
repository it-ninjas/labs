---
title: "Aufgabe: Arbeiten mit unterschiedlichen Branches"
linkTitle: "Wechseln von Branches"
type: docs
weight: 7
description: >
  Aufgabe Arbeiten mit unterschiedlichen Branches [Git Vertiefung](../../../../docs/git/vertiefung/parallel-processing)
---

Das Lab ist eine praktische Übung zum Wechseln zwischen verschiedenen Branches oder Commits eines
Repositories. Dabei sollen die erlernten Kenntnisse zu **checkout**, **stash**, **commit**, **pull**
und **push** vertieft werden. Für die Aufgabe wird nur das zweite Projekt benötigt.

Diese Aufgabe ist eine Einzelaufgabe, die von jedem IT-Ninja eigenständig bearbeitet werden muss.

### Schritt 1: Feature-Branch auf dem 2. Repository erstellen

Erstelle einen neuen Feature-Branch von `develop`auf dem 2. Repository. Nutze dazu die dir bekannten
Tools und Befehle.

### Schritt 2: Neuen Branch ausschecken

Hole den neuen Branch als Arbeitskopie auf deinen Rechner. Gehe dazu vor, wie in den anderen Aufgaben
gelernt.

### Schritt 3: Code ändern

Ändere eine beliebige Methode oder erstelle eine neue Methode in einer beliebigen Klasse. Speichere
deine Änderungen im lokalen Arbeitsbereich und führe `commit & push` aus.

### Schritt 4: "Hotfix" erstellen

Erstelle einen weiteren Branch von `develop` auf diesem Repository und checke diesen aus. Mache einen
Hotfix, indem du die Zeile **System.out.println("This is a hotfix");** in einer beliebigen Methode
einfügst. Committe deine Änderungen (ohne push!).

### Schritt 5: Zum ersten Branch wechseln

Checke wieder den ersten Branch aus und füge hier den folgenden Code in der main-Methode ein:

```
if (args.length > 0) {
    System.out.println("Es wurden " + args.length + " Argumente übergeben");
}
```

Speichere deine Änderungen.

### Schritt 6: Zuruck zum Hotfix-Branch

Gehe auf _Git › Branches..._, wähle den Hotfix-Branch aus und gehe auf _Checkout_. Du solltest nun
einen Hinweis sehen, der dich vor dem Überschreiben von nicht committeten Änderungen warnt. klicke auf
`Don't checkout`.

#### Schritt 7: Stash

Stashe deine lokalen Änderungen mit dem Git Befehl oder über das Kontextmenü in der IDE (muss auf der
geänderten Klasse aufgerufen werden).

### Schritt 8: Checkout

Führe den Checkout auf dem Hotfix-Branch erneut aus. Überprüfe die main-Methode. Die Änderungen aus
Schritt 5 sollten nun nicht mehr vorhanden sein.

### Schritt 9: Unstash

Kehre nun zum Feature-Branch zurück und überprüfe die Main-Methode. Auch hier sind die Änderungen aus
Schritt 5 nicht vorhanden. Überlege warum das so ist.

Führe nun `git pop` oder `git apply` auf dieser Klasse aus. Begründe deine Entscheidung!
