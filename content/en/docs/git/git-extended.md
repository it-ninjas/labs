---
title: "Git Erweitert"
linkTitle: "Git Erweitert"
weight: 4
---

Nachdem du die Basics von git gelernt hast, ist es Zeit dich weiter zu vertiefen.

## Inhalt

* [Stash](#Stash)
* [Cherry Pick](#CherryPick)
* [Tag](#Tag)
* [Alias](#Alias)

## Stash
#### Was ist stash?
Mit git stash ist es möglich Änderungen zwischenzuspeichern und diese später abzurufen.
Nach dem Stash-Vorgang kannst du an anderen Dateien arbeiten, bis du die zwischengespeicherten Daten wieder abrufen kannst.

#### Wie funktioniert stash?
Um Dateien zu stashen wird der folgende Befehl verwendet:

```bash
git stash
```
Um Dateien im Anschluss abzurufen wird der folgende Befehl verwendet:
```bash
git stash pop
```
Mit ```git stash pop``` werden alle Änderungen des Stashes gelöscht und der ursprünglichen Datei hinzugefügt.

Die Alternative dazu ist:
```bash
git stash apply
```
Mit ```git stash apply``` werden die Änderungen ebenfalls übernommen,
der Unterschied zu ```git stash pop``` liegt darin das stash apply die Dateien nicht aus dem Stash löscht,
dies kann nützlich sein, wenn dieselbe Änderung mehreren Branches hinzugefügt werden soll.


## Squash
#### Was ist Squash
squash in Git meint mehrere Commits zu vereinen.
Squash wird meistens benutzt, wenn Branches gemerged werden.
An dieser Stelle ist es jedoch wichtig zu erwähnen das es keinen ```git squash``` Befehl gibt.


#### Wie funktioniert squash?
Es gibt verschiedene Wege um Commits zu squashen.
Zum Beispiel gibt es die Methode des manuellen Squashens, dazu wird das Interactive Rebase Feature von Git genutzt.
Um die Interactive Rebase Session zu starten wird der folgende Befehl verwendet:
```bash
git rebase -i HEAD~3
```
Danach öffnet sich ein Editor, der die letzten n Commits anzeigt, n wird durch die Zahl nach dem "~" definiert.
Um jetzt die Commits zu squashen muss das Pick zu Beginn der Zeile mit squash ersetzt werden.
Jetzt werden alle Commits mit dem squash Schlüsselwort an den obersten Commit hinzugefügt.


##### Wieso sollte man Squashen:
Angenommen du beendest die Arbeit an einem Feature-Branch und willst diese in den Main-Branch mergen.
Der Feature-Branch enthält aber viele Commits, die nicht zwingend im Main-Branch aufgeführt werden sollen,
in diesem Fall eignet sich das squashen, um diese Commits zusammenzufassen.



## Merge/Pull Requests
### Was ist der Unterschied zwischen einer Merge Request und einer Pull Request?
Beide Begriffe meinen dasselbe, werden jedoch mit einer anderen Plattform assoziiert.
Der Begriff Merge Request wird im Zusammenhang mit GitLab verwendet.
Im Zusammenhang mit GitHub wird jedoch der Begriff Pull Request verwendet.
Der Einfachheit halber wird im folgenden Text nur von Pull Request gesprochen.

### Was ist ein Pull Request bzw. ein Merge Request?
In ihrer einfachsten Form sind Pull-Requests eine Funktion für Entwickler
die andere Teammitglieder darüber informiert, dass ein Feature fertiggestellt wurde.
Dies lässt alle Beteiligten wissen, dass der Code bereit für eine Überprüfung ist und danach in einen anderen Zweig gemerged werden kann.

### Wie kann ein Pull Request erstellt werden (IntelliJ)
Um einen Pull Request direkt aus IntelliJ zu erstellen, muss zuerst sichergestellt werden das man selbst berechtigt ist einen Pull Request zu erstellen.
Sind diese Berechtigungen vorhanden, kann der Pull Request in wenigen Schritten erstellt werden.
Oben Links in IntelliJ befindet sich einen Button der mit Pull Request beschriftet ist.
Danach öffnet sich ein Fenster in dem ausgewählt werden kann, welchen der lokalen Branches in das Ziel Repo gemerged werden soll.
Danach muss noch ein Titel festgelegt werden. Es besteht ebenfalls die Möglichkeit eine Beschreibung hinzuzufügen, dies ist jedoch nur optional.
Im Anschluss besteht die Möglichkeit einen Reviewer hinzuzufügen.
Jetzt kann der Pull Request erstellt werden.

### Wie kann eine Pull Request erstellt werden (Github)
Um einen Pull Request direkt von GitHub aus zu erstellen, muss zuerst der Reiter Pull Request ausgewählt werden,
Jetzt stehen verschiedene Möglichkeiten zu Auswahl, in unserem Fall wollen wir aber nur einen neuen Pull Request erstellen.
Im Anschluss erscheint ein neues Panel, das Wichtigste dabei ist die Wahl der richtigen Source und Target Branches.
Danach kann noch ein Name und eine Beschreibung für den Pull Request gesetzt werden.
Wie in IntelliJ besteht auch hier die Möglichkeit einen Reviewer hinzuzufügen, der Button dazu befindet sich mittig auf der linken Seite.
Da nun alle Einstellungen vorgenommen wurden, kann der Pull Request erstellt werden.


## Cherry Pick
### Was ist Cherry-Pick ?
git cherry-pick ist ein Befehl welcher es ermöglicht beliebige Git-Commits per Referenz
anzusprechen und diese an den momentanen Arbeitskopf (HEAD) anzuheften.
git cherry-pick kann sehr nützlich sein, um Änderungen rückgängig zu machen.

Zum Beispiel: Ein Commit wurde aus Versehen im falschen Branch durchgeführt. Nun kannst du zum korrekten
Branch wechseln und git cherry-pick nutzen, um den Commit am richtigen Ort zu befestigen.

### Wie funktioniert Cherry-Pick ?
Um Cherry Pick anzuwenden gibt man folgenden Befehl ein:
```
git cherry-pick <commit-hash>
```
Der <commit-hash> muss natürlich noch mit dem korrekten Hash des Commits ersetzt werden, welchen
man verschieben will. Anschliessend wird der Commit an den Branch angeheftet, auf dem man sich gerade
befindet. Darum Achtung!: Immer zuerst kontrollieren ob man derzeit auch wirklich auf dem korrekten
Branch ist.

## Tag
### Was sind Tags ?
Tags sind Referenzen, welche an einen bestimmten Punkt der History
zeigen. Tagging wird üblicherweise benutzt um wichtige Ereignisse wie z.B.
den Release einer Applikation festzuhalten. Ein Tag ist etwas ähnliches
wie ein Branch, nur das ein Tag sich nicht verändert. Anders als ein Branch,
kann ein Tag nach dem Erstellen keine weiteren Commits
beinhalten.

### Wie funktionieren Tags ?
Um ein Tag zu erstellen wird folgender Befehl benötigt:
```
git tag <tagname>
 ```
Wobei der <tagname> auch wieder durch den gewünschten String ersetzt werden muss.
Will man zusätzlich zum Tag eine Beschriftung hinzufügen, macht man das mit:
```
git tag <tagname> -a
 ```
Damit wird ein Annotated Tag erstellt.
Diese Tags werden im Gegensatz zu normalen Tags für einen Release verwendet.

Auch wichtig anzumerken: Wenn du normal auf den Branch pushst, werden die Tags
nicht standardmässig mitgepusht. Dazu brauchst du dann:
```
git push origin --tags
 ```
Willst du nur ein einzelnes Tag pushen, brauche:
```
git push origin <tag>
 ```

## Alias
### Was sind Aliasse ?
Ein Git-Alias ist zu vergleichen mit einem Shortcut. Aliase werden z.b.
auch beim Arbeiten mit der Bash-Konsole eingesetzt. Aliase werden gebraucht um kürzere Befehle
zu realisieren. Sie ermöglichen effizienteres Programmieren.

Nehmen wir zum Beispiel den git-checkout Befehl.
Dieser Befehl wird häufig verwendet und muss immer wieder neu eingetippt werden. Mit den Git-Aliassen
jedoch kann man git-checkout z.B. in git.co verwandeln. Dies spart enorme Schreibarbeit über längere Zeit
und verliert dennoch nicht an Wirksamkeit.

### Wie funktionieren Aliasse?
Um Aliasse festzulegen, müssen wir diese in der gitconfig-Datei definieren. Dort erstellen wir das
Stichwort [alias]. Das könnte in etwa so aussehen:
```
[alias]
    st = status
    ci = commit -v
 ```
Die Aliasse können beliebig definiert werden, Ziel davon soll nur sein, die Schreibarbeit zu
minimieren und das eigene Programmieren praktischer zu machen.

## Gitg
### Was ist Gitg
Gitg ist eine grafische Benutzeroberfläche für git. Es zielt darauf ab, ein kleines,
schnelles und bequemes Werkzeug zu sein, um Git-Repositories zu visualisieren.
Neben der Visualisierung bietet Gitg auch einfache Möglichkeiten zur Verwaltung eines Repository.
Jedoch bietet IntelliJ standardmässig die dieselben Möglichkeiten, sollte man jedoch eine IDE ohne Git integration verwenden ist gitg ein praktisches Tool.


### Installationsanleitung
Unter Linux kann gitg mit folgendem Befehl installieren:
<br>```sudo apt install gitg```<br>
Leider ist gitg unter Windows nicht verfügbar.
Eine empfehlenswerte Alternative dazu ist der offizielle GitHub Client.

## Github Client
### Was ist der GitHub Client
Der GitHub Client ist ein Windows Programm für die Verwaltung von Git Repositories.
Der GitHub Client funktioniert am besten mit GitHub Repositories,
das bedeutet aber nicht das dieser keine Repositories von anderen Quellen unterstützt.
Es ist lediglich ein wenig aufwändiger Repositories aus anderen Quellen einzubinden.


### Installationsanleitung
Unter Windows kann der GitHub Client auf der folgenden Seite heruntergeladen werden:
```https://desktop.github.com/``` 

Unter Linux der Client mithilfe des folgenden Scripts heruntergeladen werden:
```https://gist.github.com/berkorbay/6feda478a00b0432d13f1fc0a50467f1```

## Git Blame
### Was ist Git-Blame?
Ist ein Befehl, welcher dazu dient den Author der letzten Änderung anzuzeigen. Deswegen auch
git "blame". Man "blamed" den Verfasser der letzten Änderung für seinen Fehler (falls er
einen gemacht hat). 

### Wie funktioniert Git-Blame?
Um git blame anzuwenden brauchen wir den folgenden Befehl:
```
git blame <filename>
 ```
Und schon haben wir den Verantwortlichen für die letzte Änderung an einer Datei ausfindig gemacht.
Jedoch bietet  ```git blame``` auch andere Anwendungsmöglichkeiten:

```Bash
git blame -L 1,5 <filename>
 ```
Hier zum Beispiel definieren wir eine Range von der Zeile 1 bis zur Zeile 5. Oder hier, noch
eine weitere Variante:
```
git blame -e <filename>
 ```
Die Option -e zeigt uns anstatt des Benutzernamen des Authors, direkt die E-mail Adresse von
ihm, so dass wir gerade Kontakt aufnehmen können.

Zum Schluss haben wir noch die -w Option
```
git blame -w <filename>
 ```
Dieser Befehl ignoriert wenn ein Author nur Leerschläge geändert hat. Das hat den Vorteil, dass
wir nur die Authoren bekommen, welche auch wirklich etwas am Code selbst geändert und ihn
nicht nur formatiert haben.

## Blobs und Trees
### Was sind Blobs und Trees show?
Zuerst zu den Blobs: Blobs werden benutzt, um die Inhalte einzelner Dateien zu speichern.
Trees wiederum beinhalten Referenzen zu anderen Blobs oder Unterbäumen. 

### Wozu braucht es sie?
Wenn man eine Datei staged wird eine Blob-Datei erstellt. Dieser Blob hat den
Inhalt der Datei und hat den Typ "blob". Ein Blob eigentlich der Inhalt der Datei
an einer bestimmten Instanz. Die verschiedenen Blobs fallen danach unter einen
Tree. 

Nun bildet sich hier eine Kette: Das Commit-Objekt greift auf die Tree-Objekte zu.
Diese wiederum geben uns die Blob-Objekte zurück. Deshalb brauchen wir diese Konstellation also.
Ohne die Trees und Blobs hätten wir keinen Zugriff auf die Inhalte unserer Dateien mehr.

<img src="https://miro.medium.com/max/541/1*ZGVkiRbMErfng2CqpU3YQQ.png">
Im Diagramm kann die Abhängigkeit dementsprechend besichtigt werden.



