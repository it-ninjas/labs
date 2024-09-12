---
title: "Git Basics"
linkTitle: "Git Basics"
weight: 3
---

Git kann auf unterschiedliche Arten eingesetzt werden, es gibt graphische Oberflächen und die meisten Git-Server Software bieten Weboberflächen, welche das interagieren mit Git Repositories kinderleicht gestalten. Da diese Oberflächen meist sehr Produktspezifisch sind und oft auch nicht alle Funktionen beinhaltet werden hier nur die Kommandozeilen Befehle angeschaut. Ausserdem empfiehlt es sich mit git auf der Kommandozeile zu starten da es so viel verständlicher ist. 

## Inhalt

* [Konfiguration von Git](#konfiguration-von-git)
* [Hilfe](#hilfe)
* [Ein Git Repository anlegen](#ein-git-repository-anlegen)
* [Änderungen verfolgen und im Repository speichern](#änderungen-verfolgen-und-im-repository-speichern)
* [Anzeigen der Commit Historie](#anzeigen-der-commit-historie)
* [Änderungen rückgängig machen](#änderungen-rückgängig-machen)
* [Mit Remotes arbeiten](#mit-remotes-arbeiten)

## Ziele
- Ich weiss wie ich ein eigenes Git-Repository anlege.
- Ich verstehe wie und warum eine .gitignore Datei genutzt wird.
- Ich kann git commit, push, fetch und pull in den richtigen Situationen anwenden.

## Konfiguration von Git

Git kann, wie viele Softwares unter Linux, auf unterschiedlichen Levels konfiguriert werden:

* `/etc/gitconfig` enthält die Werte, welche für alle Benutzer auf dem System gelten. Die Datei kann mit `git config --system` gelesen oder editiert werden. Man braucht Administrator- oder Superuser-Rechte um die Datei zu editieren.
* `~/.gitconfig` oder `~/.config/git/config` enthält die Werte, welche für den aktuellen Benutzer konfiguriert sind. Mit `git config --global` können Werte gesetzt oder ausgelesen werden.
* Die Datei `config` im `.git` Verzeichnis innerhalb eines Repositories enthält die Konfiguration, welche nur für dieses Repository zählt. Das Flag für `git config` ist in diesem Fall `--local`, ist jedoch in der Regel die Standardoption und kann weggelassen werden.

Jede dieser Konfiguration wird von der nächsten überschrieben, sodass die Repository-bezogene Konfiguration den höchsten Wert hat. Um die aktuelle Konfiguration und ihren Ursprung anzusehen kann folgender Befehl ausgeführt werden:

```bash
$ git config --list --show-origin
file:/home/lehrling/.gitconfig     user.email=lehrling@puzzle.ch
file:/home/lehrling/.gitconfig     user.name=Lehrling Puzzle
file:/home/lehrling/.gitconfig     push.default=simple
file:/home/lehrling/.gitconfig     merge.tool=meld
file:.git/config        core.repositoryformatversion=0
file:.git/config        core.filemode=true
file:.git/config        core.bare=false
file:.git/config        core.logallrefupdates=true
file:.git/config        remote.origin.url=git@github.com:puzzle-bbt/training-sbb-puzzle.git
file:.git/config        remote.origin.fetch=+refs/heads/*:refs/remotes/origin/*
file:.git/config        branch.master.remote=origin
file:.git/config        branch.master.merge=refs/heads/master
```

### Konfigurationsbeispiele

Nach der Installation von Git sollte als erstes der Name und die Email Adresse konfiguriert werden, da diese beiden Angaben bei jedem Commit benötigt werden:

```bash
$ git config --global user.name "John Doe"
$ git config --global user.email johndoe@example.com
```

Wie wir bereits gelernt haben, schreiben wir mit dem `--global` Flag in die Konfiguration in unserem `home` Verzeichnis und sie gilt somit für alle Repositories, welche wir mit unserem User bearbeiten. Wollen wir dies für ein bestimmtes Repo übersteuern, haben wir immer noch die Möglichkeit dies mit `--local` zu machen.

Eine weitere Konfiguration, die evtl. hilfreich sein kann, ist `core.editor`. Mit dieser kann der Texteditor konfiguriert werden kann. Git benutzt, falls hier nichts definiert ist, den standard Editor des Systems.

## Hilfe

Git bietet mehrere Möglichkeiten, wie man an Hilfe gelangt, wenn mal einmal nicht weiter weiss:

```bash
$ git help <verb>
$ git <verb> --help
$ man git-<verb>
# Kurzversion:
$ git <verb> -h
```

Wenn man also nicht mehr genau weiss, wie dies mit der Konfiguration von Git funktioniert kann man sich folgendermassen weiterhelfen:

```bash
$ git help config #ruft die Manpage auf
[..]
$ git config -h
usage: git config [<options>]

Config file location
    --global              use global config file
    --system              use system config file
    --local               use repository config file
    --worktree            use per-worktree config file
    -f, --file <file>     use given config file
    --blob <blob-id>      read config from given blob object

Action
    --get                 get value: name [value-regex]
    --get-all             get all values: key [value-regex]
    --get-regexp          get values for regexp: name-regex [value-regex]
    --get-urlmatch        get value specific for the URL: section[.var] URL
    --replace-all         replace all matching variables: name value [value_regex]
    --add                 add a new variable: name value
    --unset               remove a variable: name [value-regex]
    --unset-all           remove all matches: name [value-regex]
    --rename-section      rename section: old-name new-name
    --remove-section      remove a section: name
    -l, --list            list all
    -e, --edit            open an editor
    --get-color           find the color configured: slot [default]
    --get-colorbool       find the color setting: slot [stdout-is-tty]

Type
    -t, --type <>         value is given this type
    --bool                value is "true" or "false"
    --int                 value is decimal number
    --bool-or-int         value is --bool or --int
    --path                value is a path (file or directory name)
    --expiry-date         value is an expiry date

Other
    -z, --null            terminate values with NUL byte
    --name-only           show variable names only
    --includes            respect include directives on lookup
    --show-origin         show origin of config (file, standard input, blob, command line)
    --show-scope          show scope of config (worktree, local, global, system, command)
    --default <value>     with --get, use default value when missing entry
```

## Ein Git Repository anlegen

Um lokal ein neues Git Repository anzulegen gibt es zwei Varianten:

* Umwandeln eines Verzeichnis, welches (noch) nicht mit Git verwaltet wird zu einem Git Repository.
* Klonen eines existierenden Repositories von einem anderen Ort.

### Ein Verzeichnis zu einem Git Repository verwandeln

Um aus einem Ordner ein Git Repository zu erstellen, muss man zuerst in den Ordner wechseln und anschliessend das Repository initialisieren:

```bash
$ cd ~/path/to/folder
$ git init
```

Der zweite Befehl erzeugt ein `.git` Unterverzeichnis, welches die Repository-Daten beinhaltet. Im Moment werden noch keine Dateien von Git verwaltet, sondern die müssen zuerst hinzugefügt werden (`git add`) und committed werden (`git commit`). Wenn wir von einem leeren Ordner ausgehen, müssen die Dateien natürlich zuerst noch erstellt werden:

```bash
$ vim README.md
$ git add README.md
$ git commit -m 'Initial Commit'
```

### Ein bestehendes Repository klonen

Um ein Repository zu klonen wird der Befehl `git clone` verwendet:

```bash
$ git clone git@github.com:libgit2/libgit2.git
$ ls
libgit2
```

Git legt dann automatisch ein Verzeichnis `libgit2` an mit allen Dateien und initialisiert das Repository mit einem `.git` Verzeichnis im Hauptverzeichnis. Wird hinter der URL noch etwas angegeben, wird dies als Name des Zielverzeichnisses interpretiert:

```bash
$ git clone https://github.com/libgit2/libgit2 mylibgit
$ ls
mylibgit
```

## Änderungen verfolgen und im Repository speichern

Zur Erinnerung, eine Datei in einem Git Folder kann vier Zustände haben:

* Untracked: Die Datei liegt im Ordner, wird aber nicht von Git versioniert.
* Unmodified: Die Datei wird von Git versioniert, sie ist seit dem letzten Commit unverändert.
* Modified: Die Datei wurde seit dem letzten Commit verändert.
* Staged: eine neue oder editierte Datei wurde für den nächsten Commit vorgemerkt.

Der Befehl zum Überprüfen, ob man Dateien in einem anderen Zustand als `unmodified` hat, ist `git status`:

```bash
$  git status
On branch feature/git-basics
Your branch is up to date with 'origin/feature/git-basics'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
	modified:   content/en/docs/02.0/02.md

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
	modified:   content/en/docs/02.0/02.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
	.gitignore
```

Wollen wir nun die Änderungen der Datei `content/en/docs/02.0/02.md` (oder die Datei `.gitignore`) zum nächsten Commit hinzufügen, können wir dies mit `git add <pfad/zur/datei>`. Im Beispiel oben sehen wir, dass die Datei `content/en/docs/02.0/02.md` bereits gestaged ist. Ändern wir diese Datei erneut, wird die Datei sowohl bei *Changes to be committed:* wie auch bei *Changes not staged for commit:* auftauchen. Einmal mit den Änderungen, welche wir bereits gestaged haben und einmal mit den Änderungen, welche wir nach dem Stagen (`git add`) gemacht haben. Wollen wir beide Änderungen im gleichen Commit, können wir die Datei einfach wieder mit `git add` stagen und anschliessend commiten, wollen wir die Änderungen in separaten Commit, commiten wir zuerst die gestagten Änderungen und stagen anschliessend die zweite Änderungen und commiten erneut.

### .gitignore

Bevor wir lernen, wie man seine Änderungen committed, wollen wir noch kurz die spezielle Datei `.gitignore` anschauen. In dieser Datei können Dateien erfasst werden, welche Git nicht als untracked aufzählen soll, respektive ignorieren soll. Die Datei wird ganz normal wie jede andere auch ins Repo eingecheckt.

```bash
$ cat .gitignore
# ignore all .a files
*.a

# but do track lib.a, even though you're ignoring .a files above
!lib.a

# only ignore the TODO file in the current directory, not subdir/TODO
/TODO

# ignore all files in any directory named build
build/

# ignore doc/notes.txt, but not doc/server/arch.txt
doc/*.txt

# ignore all .pdf files in the doc/ directory and any of its subdirectories
doc/**/*.pdf
```

Weitere Informationen bekommt man mit `man gitignore` oder unter https://github.com/github/gitignore findet man nützliche Beispiele.

### Überprüfen der Änderungen

Bevor man seine Änderungen commited, empfiehlt es sich diese nochmals zu überprüfen. Mit `git status` sieht man, welche Dateien geändert wurden, jedoch nicht, was sich geändert hat. Dafür gibt es den Befehl `git diff`:

```diff
diff --git a/content/en/docs/02.0/02.md b/content/en/docs/02.0/02.md
index 1e6db46..dd7161b 100644
--- a/content/en/docs/02.0/02.md
+++ b/content/en/docs/02.0/02.md
@@ -145,3 +145,60 @@ mylibgit

 ## Änderungen verfolgen und im Repository speichern

+Zur Erinnerung, eine Datei in einem Git Folder kann vier Zustände haben:
-Zur Erinnerung, eine Datei in einem Git Folder kann vier Zustaende haben
```

`git diff` vergleicht die Änderungen, welche noch nicht gestaged wurden, will man bereits gestagte Änderungen überprüfen braucht es zusätzlich das Flag `--staged` oder `--cached` (die beiden Flags sind Synonyme).
 
Anders als `git diff` funktioniert `git diff-tool` mit einem externen Tool, welches dir die Änderungen anzeigt. Beispiele dafür sind 'P4Merge' oder auch 'Beyond Compare'. Sie versuchen die Bearbeitungen besser zu visualisieren
und es dem Benutzer einfacher zu machen, diese in einer Datei / im Code einzusehen.
Jetzt bleibt die Frage: Wann brauchen wir was? Grundsätzlich
wird `git diff` bei folgenden Situationen gebraucht:
- Wenn wir kein GUI haben und nur mit dem Output des Terminals arbeiten
- Falls wir gar kein externes Tool zur Verfügung haben
- Wenn du keine 'schweren' externen Tools starten möchtest, sondern so schnell wie möglich zum Ergebnis kommen willst.

`git diff-tool` kann man dann überall dort einsetzen, bei denen die oben erwähnten Situationen nicht zutreffen. Zu Beachten ist aber, dass es noch viele weitere Situationen gibt, in welchen man auf `git diff-tool` verzichten kann.
Zur genaueren Einsicht ist Google immer eine gute Anlaufstelle.

### Committen

Ist man sicher, dass man nur die Änderungen gestaged hat, welche man auch committen will, kann man dies mit dem Befehl `git commit` bewerkstelligen. Dadurch wird ein Editor geöffnet und man wird gebeten eine Beschreibung für die Änderungen anzugeben. Wie solche Beschreibungen gestaltet werden sollen und was alles in eine "Commit Message" gehört, darüber gibt es ganz unterschiedliche Meinungen. Idealerweise probiert man sich vorzustellen, was man an zusätzlichen Informationen braucht, wenn man die Änderungen in zwei Jahren wieder anschaut, um zu verstehen, was und warum das geändert wurde.

Oft gibt es pro Projekt Konventionen, wie eine Commit-Message aussehen soll. Falls dies nicht existiert gibt es ein paar wenige Punkte welche die Messages einiges lesbarer und verständlicher machen:

* Sprache: Englisch
* Kurze und prägnante Message, idealerweise unter 50 Zeichen [Details](https://chris.beams.io/posts/git-commit/#limit-50)
* Mit Grossbuchstaben beginnen [Details](https://chris.beams.io/posts/git-commit/#capitalize)
* Kein Punkt am Schluss [Details](https://chris.beams.io/posts/git-commit/#end)
* Den *imperative mood* (Befehlsform) verwenden, also «Fix bug with X» statt «Fixed bug with X» oder «More fixes for broken stuff» [Details](https://chris.beams.io/posts/git-commit/#imperative)
* Wenn vorhanden das Ticket referenzieren:
   * Bei Gitlab/Github Issues: «Add X #12345»

Weitere Quellen dazu:
* https://chris.beams.io/posts/git-commit/
* https://www.conventionalcommits.org/en/v1.0.0/


Ein paar hilfreiche Flags zu `git commit`:

* `-m` um eine Message gleich anzugeben und nicht den Editor zu öffnen (kann je nach Commit Message Guideline hinderlich sein, da es keine Multiline Kommentare erlaubt):

```bash
git commit -m "Story 182: added important Information to Readme"
[master 463dc4f] Story 182: added important Information to Readme
 2 files changed, 2 insertions(+)
 create mode 100644 README
 ```

* `-a` um alle editierten Dateien gleich mitzustagen. (Kurzform von `git add --all && git commit`) **!ACHTUNG!** kann gefährlich sein da so schnell Änderungen in einen Commit rutschen die nicht rein gehören!

* `-v` um ein `git diff --staged` im Editor angezeigt zu bekommen. So muss man sich nicht merken, was man eigentlich geändert hat und bekommt es beim schreiben der Commit Message noch einmal präsentiert.

**WICHTIG:** Es ist einiges einfacher, Fehler vor dem Committen als nach dem Committen zu beheben. Ein zweites Mal über die Änderungen schauen ist sehr empfehlenswert!

### Dateien löschen

Um eine Datei zu löschen, muss diese zuerst entfernt und dann gestaged werden, damit dies in der Git Datenbank ankommt. Um nicht zuerst `rm foo` und dann `git add foo` eingeben zu müssen, gibt es den Befehl `git rm foo`. Will man eine bereits gestagte Datei aus der Versionsverwaltung jedoch nicht vom Filesystem löschen, weil man diese zum Beispiel im `.gitignore` ergänzen möchte, dann kann man dies mit `git rm --cached foo` erledigen.

**WICHTIG:** Jede Datei, die irgendwann mal committed wurde, ist für immer in der Git-Geschichte und kann nur durch neu schreiben der selbigen wieder entfernt werden. Wer also zum Beispiel sein Passwort committed, weil dies in einer `secret.yml` Datei steht, der sollte sich sofort bei einem 10x-Git-Profi-Engineer Hilfe holen.

### Dateien Verschieben

Genauso wie das Löschen, muss auch beim Verschieben die Änderung Git mitgeteilt werden: `mv README.md README &&  git rm README.md && git add README` oder in kurz und hübsch: `git mv README.md README`.

## Anzeigen der Commit Historie

Um die Geschichte eines Git Repositories anzuzeigen, gibt es den Befehl `git log`. Ohne Argumente zeigt `git log` die Commits in umgekehrter chronologischer Reihenfolge, sprich jüngster Commit zuoberst. Pro Commit wird jeweils der Commit-Hash, der Name und die Email-Adresse des Autors, das Datum und die Commit-Message angezeigt. Um die effektiven Änderungen anzuzeigen, gibt es das `-p` oder `--patch` Flag verwendet werden. Da der Output schnell gross wird und man wahrscheinlich auch nicht bis an den Ursprung der Geschichte zurück will, empfiehlt es sich die Anzahl Commits anzugeben. Will man zum Beispiel die letzten drei Commits anschauen, macht man dies mit `-3`. Oder man schränkt die Änderungen basierend auf der Zeit ein mit `--since=` und `--until=` ein (es werden die unterschiedlichsten Zeitangaben akzeptiert, am besten probiert man etwas aus. Bsp: `--since=2.weeks` oder `--until="2020-06-03"`). Auch mit `--grep` oder `--author` kann man die Resultate einschränken. Weitere Information liefert die Manpage `man git log` und die Hilfefunktion `git log -h`.

## Änderungen rückgängig machen

Wo gehobelt wird fallen Späne. Die meisten Schnitzer kann man jedoch selber wieder ausglätten. Am häufigsten committed man wohl zu schnell, hat eine Datei vergessen dazuzufügen oder hat sich bei der Commit Message vertan. Hier kann man ganz einfach die Änderungen noch vornehmen und an den letzten Commit berichtigen mit `git commit --amend` (Wichtig, man editiert nicht den letzten Commit, sondern man löscht ihn und erstellt eine korrigierte neue Version davon. Dies kann dazuführen, dass ein Remote den Commit nicht mehr annimmt, da die History nicht mehr übereinstimmt. Aber mehr dazu später.)

Um eine gestagte Datei wieder zu modified (aber eben nicht gestaged) zu verschieben kann man `git reset HEAD <file>` verwenden. Um die Änderungen einer Datei rückgängig zu machen (also modified zu unmodified)
kann sie neu ausgecheckt werden mit `git checkout -- <file>`. **Achtung**: Alle Änderungen seit dem letzte Commit gehen damit verloren!!! Wenn man sich an die beiden Befehle gerade mal nicht erinnern kann, dann kann man einfach ein `git status` eingeben und den Hilfetext studieren 😉.

## Mit Remotes arbeiten

Um mit anderen an einem Git-Projekt mitarbeiten zu können, braucht es Remotes, sprich eine Version des Projekts im Netzwerk, wo alle Beteiligten ihre Änderungen hin pushen und die Änderungen der anderen pullen können.

Nachdem man ein Repo gecloned hat, sieht man ein Remote, der verbunden ist. Man kann jedoch auch weitere definieren:

```bash
$ git clone https://code.sbb.ch/scm/~u245517/ausbildungsprogramm.git
Cloning into 'ausbildungsprogramm'...
remote: Enumerating objects: 8485, done.
remote: Counting objects: 100% (8485/8485), done.
remote: Compressing objects: 100% (5276/5276), done.
remote: Total 8485 (delta 3095), reused 8456 (delta 3079), pack-reused 0
Receiving objects: 100% (8485/8485), 17.06 MiB | 5.11 MiB/s, done.
Resolving deltas: 100% (3095/3095), done.
$ cd ausbildungsprogramm
$ git remote
origin
$ git remote -v
origin https://code.sbb.ch/scm/~u245517/ausbildungsprogramm.git (fetch)
origin https://code.sbb.ch/scm/~u245517/ausbildungsprogramm.git (push)

```

### Fetching und Pulling

Es gibt zwei Arten, wie man Daten von einem Remote abholen kann, nachdem man das Repo gecloned hat.

- `git fetch <remote>`: holt alle Änderungen vom Remote seit dem letzten abholen und speichert die lokal. Wichtig zu beachten ist, dass `git fetch` die Änderungen nicht mit den lokalen Änderungen zusammenfügt, sondern dies manuell ausgeführt werden muss.

- `git pull`: Wenn der lokale Branch mit einem remote Branch verknüpft ist, holt `git pull` die Änderungen dieses Remotes und fügt sie gleich mit den Änderungen im lokalen Branch zusammen (merge). Was Branches sind und wie ein Merge funktioniert, schauen wir uns in Kürze an. Nur soviel: Wird ein Repo gecloned, wird der lokale sogenannte `master` (oder auch `main` genannt) Branch mit dem `master` Branch des `origin` Remotes verknüpft.

Falls korrekt gecloned wurde, muss bei `git fetch der remote nicht angegeben werden. Das Gleiche gilt für die Angabe des Branches bei einem Pull, sie kann weggelassen werden.

### Pushen

Wenn man seine Änderungen soweit hat, dass man sie mit dem Rest vom Team teilen will, dann kann man diese mit `git push <remote> <branch>` auf den Server laden. Dies funktioniert jedoch nur, wenn man auf dem Server auch Schreibrechte hat und niemand anderes vor einem gepusht hat (Merge-Konflikte!).

Auch hier muss, falls korrekt gecloned wurde, der remote nicht angegeben werden.