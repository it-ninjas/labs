---
title: "Git Branches"
linkTitle: "Git Branches"
weight: 5
---

## Inhalt

* [Beispiel für Branching, Merging und Rebasing](#beispiel-für-branching-merging-und-rebasing)
* [Einfache Mergekonflikte](#einfache-mergekonflikte)

## Ziele
- Ich kann mit Mergekonflikten umgehen
- Ich kann ein Rebase eines Branches vornehmen
- Ich kenne die zwei verschiedenen Flows und kann sie voneinander unterscheiden 

Im vorherigen Kapitel haben wir gelernt, dass man nur dann seine Änderungen pushen kann, wenn einem niemand anders zuvorkam. Um diesem Problem aus dem Weg zu gehen, kann ein Branch (engl. für Ast/Zweig) verwendet werden, welcher zu einem späteren Zeitpunkt wieder auf den Hauptpfad gemerged wird.

Im ersten Kapitel haben wir gelernt, dass Git mit jedem Commit ein Snapshot der Daten und eine Referenz auf den vorgehenden Commit speichert. Ein Branch ist nichts anderes als ein Zeiger auf einen spezifischen Snapshot.

Erzeugen wir mit `git branch testing` einen neuen Branch namens "testing" so wird ein Zeiger erstellt, welcher auf den selben Commit zeigt auf dem man sich im Moment befindet. Damit Git weiss, wo man sich im Moment gerade befindet gibt es einen speziellen Zeiger namens `HEAD`:

```txt
                                        +----------+
                                        |   HEAD   |
                                        +----+-----+
                                             |
                                             v
                                        +----+-----+
                                        |  master  |
                                        +----+-----+
                                             |
                                             v
+----------+        +----------+        +----+-----+
| Commit 1 +<-------+ Commit 2 +<-------+ Commit 3 |
+----------+        +----------+        +----+-----+
                                             ^
                                             |
                                        +----+-----+
                                        | testing  |
                                        +----------+
```

Wie man auf der Skizze erkennen kann, wurde der neue Branch "testing" erstellt, wir befinden uns aber immer noch auf dem "master" Branch (HEAD). Um nun auf den neuen Branch zu wechseln können wir den Befehl `git checkout testing` verwenden. *Protipp*: Um einen neuen Branch zu erstellen und gleich auf diesen zu wechseln, kann der Befehl `git checkout -b <branchname>` verwendet werden.

Erstellen wir nun einen Commit auf dem "testing" Branch, dann zeigt sich folgendes Bild:

```txt
                                        +----+-----+
                                        |  master  |
                                        +----+-----+
                                             |
                                             v
+----------+        +----------+        +----------+        +----------+
| Commit 1 +<-------+ Commit 2 +<-------+ Commit 3 |<-------+ Commit 4 |
+----------+        +----------+        +----------+        +----------+
                                                                  ^
                                                                  |
                                                            +----------+
                                                            | testing  |  
                                                            +----+-----+
                                                                  ^
                                                                  |
                                                            +----------+
                                                            |   HEAD   |  
                                                            +----+-----+    
```

## Beispiel für Branching, Merging und Rebasing

In diesem Abschnitt wird davon ausgegangen, dass es einen Fehler im aktuellen `master`-Branch gibt, der unter `testing` nicht behoben wurde, da er zur Entwicklung neuer Funktionen verwendet wird. Um den Fehler zu beheben, wird ein neuer Branch mit dem Namen `bugfix` erstellt, der mit der gleichen Revision wie `master` beginnt. 
```bash
$ git checkout master   
Switched to branch 'master'
$ git checkout -b bugfix
Switched to a new branch 'bugfix'
```
### git commit

Nachdem der Branch `bugfix` erstellt und ausgecheckt wurde, wird die Korrektur entwickelt und übertragen.
```bash
$ git diff
diff --git a/first-file.txt b/first-file.txt
index 4c5fd91..aa24abd 100644
--- a/first-file.txt
+++ b/first-file.txt
@@ -1 +1 @@
-First file
+First file with bugfix 
$ git commit -a -m "Bugfix for first file"
[bugfix a27a927] Bugfix for first file
1 file changed, 1 insertion(+), 1 deletion(-)
```
- Die erste Zeile in `first-file.txt` wurde geändert, indem `with bugfix` zur ersten Zeile hinzugefügt wurde.

Mit der neuen Übergabe an `bugfix` fangen die Branches an, auseinanderzulaufen.

```txt
                                                    
                                                            +----------+
                                                            | testing  |
                                        +----------+        +----+-----+
                                        |  master  |             |
                                        +----+-----+             v
                                             |              +----+-----+
                                             v              + Commit 4 |
+----------+        +----------+        +----+-----+<-------+----------+
| Commit 1 +<-------| Commit 2 +<-------+ Commit 3 +
+----------+        +----------+        +----------+<-------+----------+
                                                            + commit 5 |
                                                            +----+-----+
                                                                 ^
                                                                 |
                                                            +----+-----+
                                                            |  bugfix  |
                                                            +----+-----+
                                                                 ^
                                                                 |
                                                            +----+-----+
                                                            |   HEAD   |
                                                            +----+-----+                          
```

### Mergen der Branches

<img style="padding-bottom: 30px;" src="../img/gitmerge.gif">

Nach der Fehlerbehebung ist es nun an der Zeit, sie wieder in den Master-Branch einzubinden, damit andere Benutzer sie ebenfalls verwenden können.

#### git merge

Merge ist eine Wiederholung der Änderungen eines benannten Commits (auch Branch genannt) in einen anderen Branch, da diese voneinander abwichen. Damit dies funktioniert, ändert man zuerst den Zielbranch. In diesem Fall ist das `bugfix`. Die Änderungen sollen nach `master` zurückgespielt werden. Da das Ziel `master` ist, ist der erste Schritt, zu diesem Branch zu wechseln.
```bash
$ git checkout master 
Switched to branch 'master'
$ git branch
* master 
     testing
     bugfix
$ git merge bugfix 
Updating e303af7..a27a927
Fast-forward
first-file.txt | 2 +-
1 file changed, 1 insertion(+), 1 deletion(-)
```
- Wechseln Sie zum Zielbranch (`master`).

- Bestätigen Sie, dass Sie sich im Zielbranch befinden. Dieser Schritt ist optional.

- Wiederholen Sie die Änderungen von `bugfix` in `master`.

Nach der Zusammenführung zeigen `bugfix` und `master` auf dieselbe Revision.!

```txt
                                                                               +----+-----+
                                                                               |   HEAD   | 
                                                                               +----+-----+ 
                                                            +----------+            |
                                                            | testing  |            v
                                                            +----+-----+       +----------+    
                                                                 |             |  master  |
                                                                 v             +----+-----+
                                                            +----+-----+            |      
                                                            + Commit 4 |            v      
+----------+        +----------+        +----+-----+<-------+----------+       +----+-----+
| Commit 1 +<-------| Commit 2 +<-------+ Commit 3 +<--------------------------+ commit 5 |
+----------+        +----------+        +----------+                           +----+-----+
                                                                                    ^
                                                                                    |
                                                                               +----+-----+
                                                                               |  bugfix  |
                                                                               +----+-----+
```

#### git branch -d

Es gibt keinen Grund mehr, den `bugfix`-Branch beizubehalten, da die Änderungen nun in `master` eingearbeitet wurden. Mit dem Befehl `branch -d <branchname>` wird der Branch gelöscht.
```bash
$ git branch
     bugfix
   * master 
     testing
$ git branch -d  bugfix 
Deleted branch bugfix (was a27a927).
$ git log  --oneline -n 1
a27a927 (HEAD -> master) Bugfix for first file 
```
- Der Branch kann beim Auschecken nicht gelöscht werden. Der aktive Branch ist `master`, der für die Löschung von `bugfix` funktioniert.

- Der Branch wird gelöscht und die Ausgabe enthält den kurzen SHA1-Hash.

- Die Überprüfung mit `git log` bestätigt, dass `master` auf denselben Hash zeigt wie `bugfix`.

Nachdem der Branch `bugfix` gelöscht wurde, bleiben nur noch `master` und `testing` übrig.

### Rebasing Branches

Nachdem die Fehlerkorrektur in den Branch `master` eingebracht wurde, ist der nächste logische Schritt, die Änderungen in den Branch `testing` einzubringen, um sicherzustellen, dass der nächste Release die korrigierte Version enthält. Wenn man mit mehreren Branches arbeitet, ist diese Operation notwendig, um nicht zu weit in den `master` zurückzufallen und viele Merge-Konflikte zu vermeiden.

#### git rebase

Rebase bedeutet, dass der übergeordnete Commit der ersten Änderung im Branch verschoben und an den aktuellen Zeiger des Branches oder Commits angehängt wird, der in der Befehlszeile als Argument angegeben wird. Im folgenden Beispiel wechseln wir als erstes in den Branch, der rebase werden soll, und geben dann den Befehl `rebase` gegen `master` aus.
```bash
$ git branch 
   * master
     testing
$ git checkout testing 
Switched to branch 'testing'
$ git rebase master 
Successfully rebased and updated refs/heads/testing. 
```
- Derzeit auf dem Branch `master`, muss vor dem rebase auf `testing` wechseln.

- Wechseln Sie zum Branch `testing`, der mit `master` rebased wird.

- Erteilen Sie den Befehl rebase mit dem Argument `master`, dem Branch oder Zeiger, der für den rebase verwendet wird.

- Die Meldung ist knapp und bezieht sich auf die git-interne Dateistruktur unter dem Verzeichnis `.git`.

> **Hinweis**
>
> Die Durchführung eines rebase zwischen zwei Branches erfordert einen gemeinsamen Vorfahren im Tree.

Nach dem Rebase sind "Master" und "Testing" wieder synchronisiert.

```txt
                                                            +----+-----+
                                                            |  master  |
                                                            +----+-----+
                                                                 |
                                                                 v
+----------+        +----------+        +----------+        +----------+        +----------+
| Commit 1 +<-------| Commit 2 +<-------+ Commit 3 +<-------+ Commit 5 |<-------+ Commit 4 |
+----------+        +----------+        +----------+        +----------+        +----------+
                                                                                     ^
                                                                                     |
                                                                                +----------+
                                                                                | testing  |  
                                                                                +----+-----+
                                                                                     ^
                                                                                     |
                                                                                +----------+
                                                                                |   HEAD   |  
                                                                                +----+-----+ 
```

## Einfache Mergekonflikte

Im oben erwähnten Beispiel ist alles automatisch gegangen beim Mergen, es gibt jedoch Fälle, bei denen Git nicht mehr in der Lage ist automatisch die Dateien Zusammenzuführen, wenn zum Beispiel eine Änderung an der gleichen Stelle einer Datei in beiden Branches vorgenommen wird. Gehen wir vom Beispiel oben aus, die Story die man da umsetzt macht auch etwas mit dem Dashboard welches wir kurzum anpassen mussten:

```bash
$ git merge bugfix
Auto-merging first-file.txt
CONFLICT (content): Merge conflict in first-file.txt
Automatic merge failed; fix conflicts and then commit the result.
```

Git konnte nicht automatisch mergen und hat somit keinen commit erstellt, wir müssen den Mergekonflikt von Hand lösen, bevor wir weiter arbeiten können. Weitere Infos liefert `git status`:

```bash
$ git status
On branch master
You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)

Unmerged paths:
  (use "git add <file>..." to mark resolution)
	both modified:   first-file.txt

no changes added to commit (use "git add" and/or "git commit -a")
```

Git fügt automatisch eine Markierung in die Dateien ein, welche gmerged werden müssen:
```diff
<<<<<<< HEAD
first line from master
=======
first line from testing
>>>>>>> bugfix
```

Das bedeutet, dass der HEAD (also der Masterbranch, weil auf den haben wir vor dem Mergen gewechselt) den oberen Teil (also immer alles auf Grün) und unsere neuen Änderungen den unteren Teil auf dieser Zeile hatten. Man kann den Konflikt nun lösen, indem man den ganzen Block, mit der gewünschten Änderung ersetzt. Ist der Konflikt gelöst, können wir die Datei ganz normal stagen und commiten. Gerade bei grösseren Mergekonflikten kann es praktisch sein mit tools zu Arbeiten, welche einem die Unterschiede zwischen den beiden Branches Grafisch darstellen, dafür gibt es den Befehl `git mergetool`.

In der Regel können viele Merge-Konflikte verhindert oder minimiert werden, indem:

- Regelmässige Kommunikation von Änderungen zwischen Teammitgliedern.

- Regelmässige Rebases mit dem Merge-Zielbranch.

- Erstellen kleiner und atomarer Commits.

## Flows
### Feature Branch Flow
Der Feature Branch Flow besagt, dass man für jede neue Funktion oder Verbesserung (Feature) einen eigenen Branch erstellt. Auf diesem Branch kann die Funktion entwickelt werden, ohne den Main-Branch zu beeinflussen. Sobald die Arbeit abgeschlossen und getestet ist, wird der Feature-Branch wieder in den Hauptbranch (main) integriert.


<img style="padding-bottom: 30px; width: 50%" src="../img/featureBranchFlow.png">

Vertiefende Informationen zum Feature Branch Flow können auf [dieser Seite](https://www.atlassian.com/git/tutorials/comparing-workflows/feature-branch-workflow) gelesen werden.

### Gitflow
Der Gitflow unterscheidet sich primär vom Feature Branch Flow indem, dass zwei Hauptbranches, main für den stabilen Code und develop für die laufende Entwicklung verwendet werden. So werden Feature-Branches nicht direkt vom Main, sondern vom Development-Branch (Name kann abweichen) abzweigen. So werden fertiggestellte Änderungen auch nicht gleich in den Main integriert, sondern zurück in den Development-Branch.
Zudem wird ein release-Branch verwendet, auf welchen Änderungen vom Development-Branch gepusht werden, um dort vor einem Release getestet zu werden. Anschließend wird der release-Branch, und nur dieser, in den main gemerged.
Nebst Feature Branches können auch Branches für Releases und Hotfixes erstellt werden. Der Flow ermöglicht eine strukturierte Vorgehensweise für die Entwicklung und Veröffentlichung von Software, indem Entwicklungs- und Produktionscode getrennt werden.

<img style="padding-bottom: 30px; width: 40%" src="../img/Gitflow.png">

Vertiefende Informationen zum Gitflow können auf [dieser Seite](https://www.atlassian.com/git/tutorials/comparing-workflows/gitflow-workflow) gelesen werden.


### Hands On

https://learngitbranching.js.org/
