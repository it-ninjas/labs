---
title: "Persönliches Git-Repository einrichten"
linkTitle: "Persönliches Git-Repository einrichten"
weight: 1
description: >
  Modul #O4 - Persönliches Git-Repository einrichten
---

#### Ziele
* Ich erkläre anhand von Beispielen, wozu Git verwendet werden kann 
* Ich richte selbständig ein persönliches Git-Repository gemäss Anleitung korrekt ein
* Ich verwalte meine Code-Aufgaben im persönlichen Git-Repository unter Einhaltung der firmeninternen Richtlinien korrekt

### Voraussetzungen
* Du hast Zugriff auf das Git-Tool Bitbucket
* Git (inkl. Git-Bash) ist auf deinem Computer installiert
* Du hast die Grundeinstellungen für Git im Terminal nach der Installation gemacht
{{% details title="Folgende Einstellungen sind hier gemeint und können im Git-Bash Terminal ausgeführt werden:" %}}
```bash
git config --global user.name "u123456"
git config --global user.email "u123456@sbb.ch"
# Für Windows zusätzlich:
git config --global core.autocrlf true
git config --global core.longpaths true 
```
{{% /details %}}

### Warum du Git ab heute verwenden wirst
Stell dir folgendes Szenario vor:
Du arbeitest mit deinem Computer seit mehreren Stunden um deine Hausaufgaben, welche morgen fällig werden, zu erledigen.
Du speicherst deine Anpassungen immer wieder, damit diese nicht verloren gehen.
Plötzlich stürzt dein Computer ab und startet nicht wieder.
Zum Glück, hast du noch ein altes Laptop, welcher funktionstüchtig ist und womit du morgen in die Schule gehen kannst.
Nur, was ist mit deinen Hausaufgaben? Die ganze Arbeit ist verloren und du musst wieder von Anfang an beginnen. Grrr....

Wenn du deine Arbeit nicht nur auf deinem Computer, sondern auch irgendwo anders gespeichert hättest (z.B. Dropbox, Google-Drive usw.), 
wäre es ganz einfach die Arbeit auf deinem Ersatz-Computer von dort aus herunterzuladen und dort weiterzumachen, wo du aufgehört hast.

Und hier ein weiteres Szenario:
Du arbeitest an einem Computer-Programm. Es funktioniert. Nun musst du etwas Neues in dem Programm einbauen.
Du arbeitest ein paar Stunden dran und am Schluss merkst du, dass was bisher einwandfrei funktioniert hat, jetzt gar nicht funktioniert.
Du willst die Änderungen rückgängig machen, weisst aber nicht wie der Code vor der Änderungen ausgesehen hat. Grrr....

Wenn du deine ursprüngliche Arbeit als eine Art "Snapshot" irgendwo abgelegt hättest bevor du mit den Änderungen begonnen hast, 
so hättest du ganz einfach auf diesen "Snapshot" zurückgreifen können und den alten, funktionierenden Zustand wiederherstellen können.

Diese zwei, in der Realität nicht ganz seltenen, Szenarien sind nur zwei Gründe, warum du ab heute mit Git und mit dem Git-Tool "Bitbucket" arbeiten wirst.
Git ist ein Software-System, das es ermöglicht, den Arbeitszustand in einem sog. **lokalen Repository** aufzubewahren und diesen bei Bedarf (z.B. im zweiten Szenario) wiederherzustellen.
Bitbucket ist ein Git-Cloud-Tool, welches sog. **Remote-Repositories** in der Cloud zur Verfügung stellt. 
Diese Remote-Repositories sind im Wesentlichen eine Kopie der lokalen Repositories und dienen unter anderem auch als Backup der Arbeit ausserhalb der eigenen Maschine.

Später im Ausbildungsprogramm wirst du mehr über Git und seine weitere Anwendungszwecke erfahren.
Hier geht es aber in erster Linie um das Backup deiner Arbeit, damit du bei einem Computerabsturz nicht alles von vorne machen musstest.

### Persönliches Bitbucket Repository einrichten
Um deine Arbeit ausserhalb deines Computers zu sichern, wirst du in den nächsten Abschnitten ein 
Remote Git-Repository in Bitbucket erstellen und einrichten.  
Anschliessend, wirst du dieses Repository bei dir (lokal) "klonen", sodass du auch ein lokales 
Repository hast, womit du auch ohne Internetverbindung arbeiten kannst.

#### Remote Repository erstellen
1. Klicke auf den folgenden Link, um Bitbucket in deinem Browser zu öffnen: [Bitbucket](https://code.sbb.ch/)
2. Wenn du noch nicht eingeloggt bist, folge den Anweisungen auf der Login-Seite
3. Nach dem Login wirst du oben rechts ein, vermutlich, noch leeres Profil-Bild sehen. Klicke darauf und wähle **View Profile** (Profil anzeigen) aus  
   ![View Profile](../bitbucket/bitbucket_view_profile.png)
4. Auf deiner Profilseite, klickst du nun den **Create repository** (Neues Repository erstellen) Schaltfläche
5. Gib im geöffneten Formular deinem Repository einen Namen (z.B. "ausbildungsprogramm") und lasse die andere Felder leer. Anschliessend klicke auf **Create Repository** (Repository erstellen).

Bitbucket erstellt nun das Repository für dich und du wirst automatisch zu deinem, noch leeren, Repository geführt.
Herzliche Gratulation! Du hast soeben dein erstes Git-Repository erstellt.

#### SSH-Schlüssel für dein Repository erstellen
Ein SSH-Schlüssel ist ein Zugriffsberechtigungsnachweis für das SSH-Netzwerkprotokoll (Secure Shell). 
Dieses authentifizierte und verschlüsselte sichere Netzwerkprotokoll wird für die Remote-Kommunikation zwischen Computern verwendet.
  
SSH verwendet ein Schlüsselpaar, um einen sicheren Handshake zwischen Remote-Parteien zu initiieren. 
Das Schlüsselpaar enthält einen öffentlichen und einen privaten Schlüssel.
Den öffentlichen Schlüssel kannst du dir als **Schloss** und den privaten Schlüssel als **Schlüssel** für dieses Schloss vorstellen.

##### SSH Schlüssel-Paar erstellen:
Öffne ein Git-Bash Terminal und gib folgenden Befehl ein. Verwende hierfür deine E-Mail-Adresse:
```bash
ssh-keygen -t rsa -b 4096 -C "u123456@sbb.ch"
```
Danach wirst du aufgefordert, eine Datei anzugeben, in der der Schlüssel gespeichert werden soll.
Drücke hier die Eingabetaste (Enter), um den Standardspeicherort zu übernehmen.
Bei der nächsten Eingabeaufforderung wirst du nach einer sicheren Passphrase gefragt.
Auch hier kannst du die Eingabetaste verwenden, um keine Passphrase zu definieren (oder du wählst dir eine Passphrase aus).

Deine SSH-Schlüsselpaar-Dateien sind nun in deinem Standardverzeichnis (auf Windows: C:\Users\<deine-uNummer>\.ssh) vorhanden:
Der private Schlüssel ist in der Datei **id_rsa** abgelegt.
Der öffentliche Schlüssel ist in der Datei **id_rsa.pub** abgelegt.

##### Öffentlicher Schlüssel in Bitbucket ablegen
Als letzter Schritt legst du deinen öffentlichen SSH-Schlüssel wie folgt in Bitbucket ab:
1. Öffne ein Git-Bash Terminal und navigiere zum Speicherort deines SSH-Schlüsselpaars
2. Gib folgenden Befehl ein, um deinen Schlüssel im Terminal auszugeben:
```bash
C:\Users\u123456\.ssh> cat id_rsa.pub
```
3. Markiere die Ausgabe und kopiere sie zum Clipboard (CTRL+C)
4. [Klicke hier, um deinen öffentlichen Schlüssel ins Bitbucket hinzuzufügen](https://code.sbb.ch/plugins/servlet/ssh/account/keys)
5. Klicke die "Add key" Schaltfläche, fülle das geöffnete Formular wie folgt aus und drücke anschliessend die "Save" Schaltfläche:  
   ![Bitbucket SSH-Schlüssel](../bitbucket/bitbucket_ssh_key.png)

Somit hast du die SSH-Konfiguration abgeschlossen und du kannst dieses Protokoll beim Klonen benutzen.

### Repository lokal klonen
Dein erstelltes Repository befindet sich nun auf dem Bitbucket-Server.  
Damit du diesen Repository aus deinem Computer benutzen kannst, musst du jetzt dieses lokal "klonen".  
Klonen bedeutet hier einerseits lokal kopieren und andererseits eine Verbindung zwischen Remote- und Lokal-Repository herzustellen, um die Arbeit zwischen den beiden synchronisieren zu können.

Da du jetzt einen Ort hast, an dem du deine Arbeitsdateien hinzufügen und sichern kannst, muss es auch eine Möglichkeit geben,  
von deinem lokalen System (also direkt von deinem Computer und nicht nur über Browser) darauf zuzugreifen.  
Um dies einzurichten, kopierst du das Bitbucket-Repository auf dein System.  
Bei Git wird dieser Kopiervorgang als **Klonen** bezeichnet.  
Wenn du ein Repository klonst, erstellst du eine Verbindung zwischen dem Bitbucket-Server (den Git als "origin" kennt) und deinem lokalen System.  

![Git Clone](../bitbucket/git_clone.png)

#### Ordner für deine Repositories anlegen
Bevor du dein Repository klonen wirst, erstellst du nun ein Ordner, welcher dieses Repository (und später auch weitere Repositories) beinhalten wird.

**Aufgabe**  
Erstelle den Ordner "local_repos" unter deinem Startverzeichnis (bei Windows unter *"C:\\Users\\\<dein Benutzername\>"*)

{{% details title="Falls du Hilfe brauchst.." %}}
```bash
C:\> cd Users\e123456 # e123456 ist der Benutzername auf dieser Maschine
C:\Users\e123456> mkdir local_repos # erstellt den Ordner "local_repos" unter dein Startverzeichnis
C:\Users\e123456> cd local_repos # ins Ordner local_repos navigieren
C:\Users\e123456\local_repos> # fertig...
```
{{% /details %}}

#### Repository klonen
1. Auf deiner Bitbucket-Repository Seite, klicke die **Clone** (klonen) Schaltfläche.
2. Im geöffneten Popup-Fenster, wähle **SSH** als Protokoll und kopiere (CTRL+C) die URL zu deinem Repository (direkt neben dem Protokoll) in dein Clipboard  
   ![Bitbucket Clone](../bitbucket/bitbucket_clone.png)
3. Öffne nun dein Git-Bash Terminal und navigiere zu deinem, im vorherigen Schritt erstellten, "local_repos" Ordner
4. Verwende folgenden Befehl, um dein Repository zu klonen:  
```bash
C:\Users\e123456\local_repos> git clone ssh://git@codessh.sbb.ch:7999/~e123456/ausbildungsprogramm.git
```

Nun findest du unter deinem "local_repos" Ordner einen neuen Ordner mit dem Namen deines Repositorys.
Dieser neue Ordner ist dein lokales Git-Repository und hier wirst du deine Arbeit ab jetzt speichern und verwalten.

Gratuliere! Nun hast du dein lokales Repository, worin du deine Arbeit verwalten kannst.

#### Ordnerstruktur im lokalen Repository anlegen
Jetzt erstellst du eine Ordnerstruktur, welche dazu dient, deine Arbeit im Ausbildungsprogramm strukturiert zu speichern und zu verwalten.

**Aufgabe:**  
Erstelle folgende Ordnerstruktur in deinem lokalen Repository Ordner:

![Ordnerstruktur](../bitbucket/ordner_struktur.png)

Im Ordner **J1** wirst du die Arbeit, welche zum ersten Java-Modul gehört speichern und verwalten (J1 entspricht der ID des ersten Moduls).
Für jedes weitere Modul, welches du bearbeitest, wirst du einen Ordner unter deinem Repository-Ordner erstellen mit der ID des Moduls als Ordnername.
Der **src** Ordner wirst du mit deinem Code befüllen. Darin wird später eine Java-Package-Struktur sein, die du dann anlegen wirst.  

### "Snapshots" erstellen und ins Repository commiten
In diesem Schritt wirst du eine neue Datei erstellen, diese in deinem lokalen Repository hinzufügen und Änderungen als "Snapshots" im Repository speichern.

**Aufgabe:**  
Erstelle eine Datei mit dem Namen "README.md" in deinem **src** Folder.

#### "git add" und "git status"
Die Datei, welche du eben erstellt hast, befindet sich in deinem Arbeitsverzeichnis.
Damit du diese nun in deinem Repository speichern kannst, musst du die Datei zuerst in eine sog. **Staging-Umgebung** verschieben.
Dies wird mit dem Befehl **git add** gemacht. Gib folgenden Befehl in deinem Git-Bash Terminal ein:  
```bash
C:\Users\e123456\local_repos\ausbildungsprogramm\J1> git add README.md
```
Somit befindet sich ein Snapshot deiner Datei in der **Staging-Umgebung**.  
Mit dem Befehl **git status** kannst du dies auch prüfen. Gebe den Befehl im Terminal ein.  
Die Ausgabe zeigt dir, dass es eine neue Datei in der **Staging-Umgebung** gibt, die aber noch nicht ins Repository "commited" wurde. Dies machst du nun im nächsten Schritt.  

#### "git commit"
Wenn du den Befehl **git commit** eingibst, speicherst du die "gestagete" Arbeit in deinem lokalen Repository.
Bei Bedarf, kannst du diesen Snapshot aus dem Repository wiederherstellen.

Führe folgender Befehl aus, um den ersten Snapshot deiner Datei im Repository zu speichern:

```bash
C:\Users\e123456\local_repos\ausbildungsprogramm\J1> git commit -m 'Eine leere README.md Datei'
```

Das "-m" gibt an, dass eine Commit-Nachricht folgt. Diese ist dann im Repository auch ersichtlich und hilft dir später herauszufinden was du in diesem Snapshot gemacht hast.
Nun ist der erste Snapshot deiner Datei im lokalen Repository gespeichert.  
Wenn du wieder **git status** ausführst, wirst du sehen, dass es jetzt nichts zu commiten gibt.

Wenn du beim Ausführen von **git status** die folgende Meldung siehst:

![Meldung Upstream branch is gone](../bitbucket/upstream_branch_gone.png)  

kannst du dies mit dem vorgeschlagenen Befehl korrigieren:

```bash
C:\Users\e123456\local_repos\ausbildungsprogramm\J1> git branch --unset-upstream
```

Wenn du **git status** oder auch andere Git-Befehle nun eingibst, siehst du diese Meldung nicht mehr.

**Aufgabe:**  
Öffne deine *README.md* Datei mit einem Text-Editor (z.B. Notepad++) und füge den folgenden Text hinzu:

```text
Nützliche Git-Befehle:
git add: verschiebt Änderungen aus dem Arbeitsverzeichnis in die Staging-Umgebung von Git.  
git status: gibt den Status des Arbeitsverzeichnisses und den Status des Snapshots in der Staging-Umgebung zurück.  
git commit: committet den Snapshot aus der Staging-Umgebung in den Projektverlauf. Das bedeutet, dass dieser Snapshot nun in deinem lokalen Repository gespeichert wurde.  
```

Erstelle einen neuen Snapshot deiner Datei und commite sie in deinem lokalen Repository.

### Dateien ins Remote-Repository laden
Bis jetzt hast du deine Arbeit im lokalen Repository, sprich nur auf der Festplatte deines Computers, gespeichert.
Damit du diese Arbeit immer noch hast, auch wenn dein Computer oder die Festplatte versagen, wirst du nun deine Arbeit zum Remote-Repository auf Bitbucket schicken.

#### "git push"
Der Befehl **git push**, schickt die committeten Änderungen von deinem lokalen Repository an das Remote-Repository.
Das Remote-Repository wird als **origin** bezeichnet.

Gib also folgenden Befehl in deinem Git-Bash Terminal ein:

```bash
C:\Users\e123456\local_repos\ausbildungsprogramm\J1\src>git push origin master
```

Wenn du dein Bitbucket-Repository im Browser öffnest, wirst du deine Arbeit jetzt auch dort sehen.  
Nun ist deine Arbeit auch ausserhalb deines Computers abgesichert.

**Aufgabe**  
Öffne deine README.md Datei in einem Texteditor und füge den folgenden Text hinzu:

```text
git push origin master: pusht die Änderungen aus dem lokalen Repository in den Haupt-Branch **master** (Bitbucket-Branch) auf "origin" (Bitbucket-Server). 
```

Erstelle einen neuen Snapshot deiner Datei, commite sie in deinem lokalen Repository und pushe sie auf den Bitbucket-Server.

### Den Ernstfall üben
Deine Arbeit ist nun auf dem Bitbucket-Server gesichert.  
Wenn dein Computer sich jetzt für immer verabschiedet, kannst du die Arbeit auf einem neuen Computer wiederherstellen.  
Dieses Szenario wirst du jetzt üben.  

**Aufgabe**  
1. Lösche dein lokale Repository (das Verzeichnis unter **local_repos** und alles darunter löschen).
2. Stelle deine Arbeit aus dem Bitbucket-Server wieder her.
3. Füge folgenden Text deinem README.md File hinzu: "git clone: klont ein Remote-Repository auf das lokale System in einem lokalen Repository."
4. Erstelle ein Snapshot für die Änderung, commite sie und pushe sie auf den Bitbucket-Server

{{% details title="Falls du etwas Hilfe brauchst..." %}}
```bash
# Mit Git-Bash auf deinem "local_repos" Verzeichnis wechseln
cd C:\Users\[deine U/E-Nummer]\local_repos
# Remote Repository klonen
git clone ssh://git@codessh.sbb.ch:7999/~[deine U/E-Nummer]/ausbildungsprogramm.git
# Wechsle in das Arbeitsverzeichnis deines lokalen Repositorys
# Du findest deine README.md Datei im Verzeichnis C:\Users\[deine U/E-Nummer]\local_repos\ausbildungsprogramm\J1\src
cd ausbildungsprogramm\J1\src

# Füge den gewünschten Text mit einem Texteditor hinzu und speichere die Datei

# Verschiebe die Datei in die Staging-Umgebung
git add README.md
# Commite deine Änderungen in das lokale Repository
git commit -m 'Information zu git clone hinzugefügt'
# pushe deine Änderungen auf dem Bitbucket-Server
git push origin master
```
{{% /details %}}

### Coaches auf deinem Repository berechtigen
Nun kannst du deine Arbeit mit Git verwalten. Somit stellst du sicher, dass deine Arbeit auch im schlimmsten Fall nicht verloren geht.
Damit deine Coaches dich bei Problemsituationen unterstützen können, musst du sie auf deinem Bitbucket-Repository berechtigen.
Dies erledigst du mit folgenden Schritten:
1. Öffne dein Bitbucket-Repository im Browser
2. Im Navigationsbereich klicke auf *Repository Settings* und dort auf *Repository Permissions*
   ![Bitbucket Repo Permissions](../bitbucket/bitbucket_repo_permissions.png)
3. Klicke die Schaltfläche "Add user or group" und berechtige alle Coaches als Administratoren auf deinem Repository. Anschliessend klicke die "Add" Schaltfläche
   ![Coaches Permissions](../bitbucket/coaches_admin_permission.png)

Nun sind alle Coaches auf deinem Repository berechtigt.
