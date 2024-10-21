---
title: "Debugging"
type: docs
linkTitle: "Debugging"
weight: 24
date: 2023-03-31
description: >
  Modul #F4 - JavaScript - Debuggen ist in jeder Programmiersprache wichtig und die IDE hat dazu viele nützliche Tools, welche hier angeschaut werden.
---

## Ziele

- Du weisst, wie du in VSCode JavaScript Code debuggen kannst.
- Du weisst, wie du in IntelliJ JavaScript Code debuggen kannst.

## Wieso ist debuggen wichtig?

Es gibt eine Vielzahl von Gründen, warum JavaScript-Anwendungen Fehler enthalten können. Typische Fehler sind zum Beispiel unerwartete Nutzereingaben, Netzwerkprobleme, inkonsistente Daten oder eine fehlerhafte Logik innerhalb des Codes. Debugging kann dazu beitragen, diese Fehler zu identifizieren und zu beseitigen.

Ein weiterer wichtiger Grund, warum Debuggen in JavaScript wichtig ist, ist, dass JavaScript eine dynamisch typisierte Sprache ist. Das bedeutet, dass Typfehler während der Laufzeit auftreten können, wenn eine Variable unbeabsichtigt einen anderen Datentyp zugewiesen bekommt, als erwartet. Typfehler können schwer zu finden sein, da sie nicht immer sofort zu offensichtlichen Fehlern führen und zu unerwartetem Verhalten führen können.

### Ist es nun schlau zum debuggen `console.log()` zu verwenden?

Die Antwort ist Ja und Nein.

Es ist zwar eine der gängigsten Methoden, die verwendet wird, da sie es sehr schnell und einfach ist. Jedoch beeinträchtigen zu viele davon die Leistung des Codes, was dann zum Problem wird, wenn man sie beim `git push` vergisst, herauszunehmen und sie dann auf produktiven Umgebungen landen könnten. So passiert es dann schnell, dass die Konsole überfüllt mit sinnlosen Logs ist. Ausserdem können sie auch zu Sicherheitsproblemen führen, wenn sensible Daten geloggt werden.

Somit ist es besser mit Tools von VSCode oder IntelliJ zu debuggen.

## Debugging nach alter Schule

Es gibt eine Möglichkeit, die immer funktioniert, wenn du JavaScript-Code im Browser debuggen möchtest.

Praktisch jeder Browser (sogar der Internet Explorer) bietet Debugging-Tools an.

Möchtest du an einer bestimmten Stelle im Code einen Breakpoint anbringen und die Ausführung pausieren, wenn dieser erreicht ist, dann kannst du das mit folgender Anweisung erreichen:

```javascript
debugger;
```

Wenn nun diese Stelle erreicht wird, dann pausiert der Browser automatisch. Vielleicht musst du hierfür die Entwickler-Tools je nach Browser geöffnet haben.

In der Debugging-Ansicht siehst du dann den aktuellen Code:

![Debugging-Ansicht](../images/debugging-browser.png "Die Debugging-Ansicht im Firefox.")

Folgende Dinge siehst du:

1. Das Script ist pausiert an der Stelle, an welcher `debugger;` steht. Du kannst dir die Werte der Variablen anschauen, indem du mit der Maus darüberhoverst. Hier siehst du z.B., was in der Variable `browser` gespeichert ist.
2. Auf der rechten Seite oben kannst du die Ausführung wie gewöhnlich fortsetzen lassen, oder auch Schritt-für-Schritt weiterdebuggen.
3. Weiter unten sind die Breakpoints aufgelistet. Du kannst im Browser direkt weitere Breakpoints hinzufügen, indem du auf eine Zeilennummer klickst. Bei den Breakpoints siehst du auch die Möglichkeit, dass das Script automatisch einen Breakpoint aktivieren soll, wenn ein Fehler geworfen wird (auch wenn er später ge`catch`ed wird).

Das Schöne an dieser Möglichkeit ist, dass sie praktisch immer funktioniert, egal welches Framework du für deine HTML-Seiten verwendest.

Wenn dir aber deine Entwicklungsumgebung eine Lösung anbietet, dann verwende diese! Verwendest du das `debugger`-Keyword im Code, so musst du immer wieder daran denken, es vor dem Teilen wieder zu entfernen.

## Debuggen in VSCode

### HTML-Datei mit JavaScript debuggen (Client-seitig)

Möchtest du JavaScript-Code in einer lokalen HTML-Datei debuggen, dann kannst du das wie folgt tun:

Klicke auf "Run and Debug" im Debugging-Tab:

![Klick auf "Run and Debug"](../images/debugging-vscode-run-and-debug.png "Debugging direkt starten in VS Code")

Dann solltest du gefragt werden, auf welche Art du debuggen möchtest:

![Klick auf "Web App"](../images/debugging-vscode-launch-web-html.png "Verbinde dich mit dem Browser")

Dort wählst du den Browser aus, mit dem du Debuggen möchtest.

Nun ist Debugging in HTML- und JavaScript-Dateien möglich, indem du Breakpoints setzt:

![Breakpoints sollten nun getriggert werden](../images/debugging-vscode-first-breakpoint-in-hmtl.png "Nun sollten Breakpoints den Browser stoppen können")

Möchtest du das Debugging auf Knopfdruck starten?

- Dann Klicke im "Run and Debug"-Tag auf "create a launch.json file" statt auf "Run and Debug".
- Wähle wieder den richtigen Browser aus.
- In der Datei ".vscode/launch.json" wurde eine Konfiguration erstellt. Du kannst sie wie folgt generalisieren:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "msedge", // bzw. chrome.
      "request": "launch",
      "name": "Open current html",
      "file": "${file}"
    }
  ]
}
```

Wenn du nun deine Datei ausgewählt hast und [F5] klickst, wird automatisch ein Browser geöffnet, der die aktuelle Seite im Browser anzeigt. Ausserdem sollten alle Breakpoints direkt funktionieren.

### Debuggen in VSCode mit LiveServer (Client-seitig)

Wenn du die Extension [Live Server](https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer) verwendest, dann muss das Debugging ein bisschen anders konfiguriert werden.

Als Erstes muss man das `launch.json` erweitern, denn es muss einen neue Configuration hinzugefügt werden (innerhalb des Arrays `configurations`).

```json
{
  "name": "Live Server: Chrome",
  "type": "chrome",
  "request": "launch",
  "url": "http://localhost:5500/${relativeFile}",
  "webRoot": "${workspaceFolder}",
  "sourceMapPathOverrides": {
    "webpack:///./src/*": "${webRoot}/*"
  }
}
```

- Für Microsoft Edge gibst du natürlich `"type": "edge"` an.
- Achte darauf, dass du den gleichen Port verwendest wie der Live Server. Normalerweise ist der `5500`. Es kann aber auch vorkommen, dass sich der Port ändert. Den Port siehst du unten rechts im VS Code (in meinem Fall `5501`), wenn der Live Server läuft:

![Port vom LiveServer](../images/debugging-vscode-live-server-port.png "Port vom LiveServer")

Nun sollte man die gewünschten Breakpoints setzen bevor man dann startet.

Um zu Debuggen

- musst du zuerst den Live Server starten (z.B. einen Rechtsklick auf die entsprechende HTML-Datei, dann "Open with Live Server")
- Danach beim Debuggen den Eintrag "Live Server: Chrome" im Dropdown wählen und mit dem daneben befindenden grünen Startbutton das gesamte starten. Man kann jedoch auch nur im Dropdown das Gewollte auswählen und mit F5 starten:

![VS Code zeigt Debugging Dropdown](../images/debugging-live-server-vscode.png "Debugging Dropdown VS Code")

Es öffnet sich ein Chrome Fenster mit den Ordnern, dort kann man dann in das gewollte File navigieren. Wird nun eine Aktion ausgeführt, die ein Breakpoint beinhaltet, kann man wie gewohnt Debuggen.

### JavaScript-Dateien mit NodeJS (Server-seitig) debuggen

Damit man in VSCode Server-seitigen JavaScript-Code mit NodeJS debuggen kann, muss man zuerst ein `launch.json` erstellen. Dies geht am besten in dem man rechts in der Menüleiste auf das vierte Icon klickt:

![VS Code zeigt nun, wo man das launch.json erstellt](../images/debugging-create-launch-json-vscode.png "launch.json erstellen in VS Code")

Man muss natürlich auch den Debugger aussuchen, den man verwenden möchte:
![VS Code zeigt nun, welchen Debugger man möchte](../images/debugging-debugger-vscode.png "Debugger auswählen in VS Code")

Nun muss man den Code im `launch.json` mit dem folgenden ersetzen:

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "node",
      "request": "launch",
      "name": "Launch Program",
      "skipFiles": ["<node_internals>/**"],
      "program": "${file}",
      "cwd": "${workspaceFolder}"
    }
  ]
}
```

Nun kann man den Debugger mittels F5 starten.

Damit dieser jedoch etwas bringt, muss man auch Breakpoints setzen.
Dafür kann man links neben der Zeilenzahl mittels Links-Klick einen normalen Breakpoint setzen oder mit Rechts-Klick die Optionen ansehen:

![VS Code zeigt nun, die Breakpoint Optionen](../images/debugging-options-vscode.png "Breakpoint Optionen VS Code")

### Breakpoints

Die Optionen zeigen folgende drei Breakpoints:

- Breakpoints: Breakpoints sind die am häufigsten verwendeten. Sie ermöglichen es, den Programmfluss an einer bestimmten Zeile zu unterbrechen und den Code schrittweise zu debuggen.
- Logpoints: Logpoints ermöglichen es, während des Debuggings eine Nachricht in der Konsole auszugeben, ohne den Programmfluss zu unterbrechen.
- Conditional Breakpoints: Conditional Breakpoints ermöglichen es, einen Breakpoint zu setzen, der nur unter bestimmten Bedingungen ausgelöst wird.

Setzt man einen Logpoint oder Conditional Breakpoint, kann man im Dropdown noch zwei weitere auswählen.

![VS Code zeigt nun, die Conditional Breakpoint Optionen](../images/debugging-breakpoint-options-vscode.png "Conditional Breakpoint Optionen VS Code")

- Exception Breakpoints: Exception Breakpoints ermöglichen es, den Programmfluss an der Stelle zu unterbrechen, an der eine Ausnahme (Exception) auftritt.
- Hit count breakpoint: Hit count Breakpoints ermöglichen es, eine Pause im Code an einer bestimmten Stelle einlegt, wenn eine bestimmte Bedingung erfüllt ist. Der "Hit count" bezieht sich dabei auf die Anzahl der Male, die dieser Breakpoint erreicht wurde.

Wenn man im Debug-Modus ist, kann man links ein Panel sehen mit drei Unterteilungen:

- Watch: Die "Watch"-Funktion ermöglicht es, die Werte von Variablen, Objekten und Ausdrücken in Echtzeit zu überwachen. Man kann Variablen hinzufügen, um ihre Werte zu verfolgen und sie zu überprüfen, während man durch den Code gehen. Dies ist besonders nützlich, wenn man einen Fehler vermuten und den Wert einer bestimmten Variable überprüfen möchten.
- Call Stack: Die "Call Stack"-Funktion zeigt die Aufrufliste der Codezeilen an. Man kann sehen, welche Funktionen aufgerufen wurden und in welcher Reihenfolge. Dies ist hilfreich, um zu verstehen, wie der Code funktioniert und wo Fehler auftreten können. Man kann auch zurückgehen und zu einem bestimmten Punkt in der Liste springen, um den Code von diesem Punkt aus zu überprüfen.
- Variables: Die "Variables"-Funktion zeigt eine Liste der Variablen an, die im aktuellen Kontext verfügbar sind. Man kann den Wert jeder Variable überprüfen und sie ändern, um zu sehen, wie sich der Code verhält. Diese Funktion ist besonders nützlich, wenn man eine Variable suchen und ihren Wert überprüfen müssen, um einen Fehler zu finden.

![VS Code zeigt nun, sein Debugging Panel](../images/debugging-panel-vscode.png "Debugging Panel in VSCode")

### Die Debugging Actions

Die Debugging Actions sind wichtig zum während des Debuggen zu navigieren. Die Icons auf dem folgenden Bild werden darunter von links nach rechts erklärt:

![VS Code zeigt nun, die Debugging Actions](../images/debugging-actions-vscode.png "Debugging Actions VS Code")

- Fortsetzen/Pause (F5):
  Fortsetzen: Setzt die normale Programm- oder Skriptausführung fort (bis zum nächsten Breakpoint).
  Pause: Ermöglicht die Inspektion des Codes, der gerade ausgeführt wird.

- Schritt über (F10):
  Führt die nächste Anweisung aus, ohne ihre Bestandteile zu inspizieren.

- Schritt in (F11):
  Betritt die nächste Methode, um ihre Ausführung Zeile für Zeile zu verfolgen.

- Schritt zurück (⇧F11):
  Wenn man sich innerhalb einer Methode oder Unterprozedur befinden, kehrt man zum früheren Ausführungskontext zurück, indem man die verbleibenden Zeilen der aktuellen Methode als einzelnen Befehl ausführt.

- Neu starten (Ctr+⇧+F5 bzw. ⇧⌘F5):
  Beendet die aktuelle Programmausführung und startet das Debuggen erneut mit der aktuellen Ausführungskonfiguration.

- Stoppen (⇧F5):
  Beendet die aktuelle Programmausführung.

### Die Debugging-Konsole

Während dem Debugging bietet VS Code die Debugging-Konsole an:

![Debugging-Konsole.](../images/debugging-vscode-debug-console.png "Die Debugging-Konsole.")

Hier erscheinen die gleichen Logs wie in der Browser-Konsole. Ausserdem kannst du hier auch Ausdrücke testen (ob z.B. `browser.includes("Chrome")` wahr ist) und Code ausführen lassen.

Im Zusammenhang mit dem Browser klingt das vielleicht sehr unspektakulär, ist aber sehr praktisch, wenn du eine server-seitige Anwendung (Backend) laufen lässt mit NodeJS, Java, Python oder so ähnlich.

## Debuggen in IntelliJ

Um in IntelliJ zu debuggen, muss man nicht zuerst ein File erstellen oder eine Extension haben. Es reicht, bereits wenn man die Breakpoints setzt. Dafür kann man, wie bei VSCode, links neben der Zeilenzahl mittels Links-Klick einen normalen Breakpoint setzen oder mit Rechts-Klick die Optionen ansehen:

![IntelliJ zeigt nun, die Breakpoint Optionen](../images/debugging-options-intelliJ.png "Breakpoint Optionen IntelliJ")

Hier gibt es neben dem normalen Breakpoint den Conditional Breakpoint. Dieser ist für das gleich wie bei VSCode.

![IntelliJ zeigt nun, den Conditional Breakpoint](../images/debugging-conditional-breakpoint-intelliJ.png "Conditional Breakpoint in IntelliJ")

Hier gibt es dann die Möglichkeit, noch mehrere Optionen zu sehen. Dazu muss man auf `more` klicken und es öffnet sich ein Popup.

![IntelliJ zeigt nun, die weiteren Optionen des Conditional Breakpoint](../images/debugging-conditional-breakpoint-extend-intelliJ.png "weitere Conditional Breakpoint Optionen in IntelliJ")

Hier kann man, wie bei VSCode, auch einen Log machen und der Breakpoint ist nun das gleiche wie der Logpoint in VSCode. Man kann auch einstellen, dass der Breakpoint entfernt werden soll, sobald er einmal aufgerufen wurde. Oder das er solang inaktiv sein soll bis ein anderer Breakpoint ausgelöst wurde.

Um den Debug-Modus zu starten, kann man in IntelliJ oben rechts das Icon das wie ein Käfer aussieht verwenden:

![IntelliJ zeigt nun, den Debuggstartbutton](../images/debugging-starten-intelliJ.png "Startbutton zum Debuggen in IntelliJ")

Das Debugging-Panel unten auf der Benutzeroberfläche besitzt verschiedene nützliche Tools:

- Debugger Controls
- Debug Console
- Frames
- Variables
- Watches

![IntelliJ zeigt nun, das Debugger Panel](../images/debugging-panel-intelliJ.png "Debugger Panel in IntelliJ")

### Debugger Controls:

![IntelliJ zeigt nun, das Debugger Actions](../images/debugging-actions-intelliJ.png "Debugger Actions in IntelliJ")

- Rerun:
  Dieser Button startet das Programm im Debug-Modus neu.

- Stop:
  Mit diesem Button stoppt man den Debug-Modus.

- Pause:
  Dieser Button unterbricht den Programmablauf und hält den Debugger an. Man benutzt es, um das Programm zu pausieren und den aktuellen Zustand der Variablen und Objekte zu überprüfen.

- Resume Program:
  Mit diesem Button kann man das Programm im Debug-Modus fortsetzen, nachdem es unterbrochen wurde.

- Step Over:
  Dieser Button führt das aktuelle Statement im Code aus und hält an der nächsten Zeile an. Wenn das Statement eine Methode aufruft, wird die Methode ausgeführt und der Debugger hält an der nächsten Zeile an.

- Step Into:
  Diese Schaltfläche führt das aktuelle Statement im Code aus und hält an der nächsten Zeile an. Wenn das Statement eine Methode aufruft, wird der Debugger in die Methode hineinspringen und an der ersten Zeile der Methode anhalten.

- Step Out:
  Mit dieser Schaltfläche kann man aus einer Methode heraus zurückkehren und den Debugger an der nächsten Zeile nach der Methode anhalten.

- View Breakpoints:
  Mit diesem Button kann man alle Breakpoints anzeigen und konfigurieren, einschliesslich Bedingungen und Aktionen, die bei der Unterbrechung ausgelöst werden sollen.

- Mute Breakpoint:
  Mit diesem Button kann man einen Breakpoint stumm schalten, ohne ihn zu entfernen. Dies ist nützlich, wenn man schnell durch den Code navigieren möchten, ohne dass der Debugger bei jedem Breakpoint stoppt.

### Debug Console:

Hier kann man interaktiv mit dem Code interagieren, indem man JS-Befehle eingibt und ihre Ausgabe sieht. Man kann auch Fehlermeldungen oder Ausnahmen sehen, die während der Ausführung des Codes auftreten.

### Frames:

In diesem Bereich werden die Stack-Frames angezeigt, die den aktuellen Programmablauf darstellen. Man kann durch die Frames navigieren, indem man auf den Namen des Frames klicken.

![IntelliJ zeigt nun, das Frame Panel](../images/debugging-frames-panel-intelliJ.png "Frame Panel in IntelliJ")

### Variables:

Hier kann man die Werte von Variablen während des Debugging-Prozesses überwachen. Man kann die Variablen auswählen, um ihre aktuellen Werte anzuzeigen, oder man kann Ausdrücke eingeben, um ihre Werte zu berechnen.

![IntelliJ zeigt nun, das Variable Panel](../images/debugging-variables-panel-intelliJ.png "Variable Panel in IntelliJ")

### Watches:

Man kann eine Liste von Variablen erstellen, die man überwachen möchten. Man kann Variablen zur Watcherlist hinzufügen, indem man mit der rechten Maustaste auf die Variable klicken und "Add to Watches" auswählen.
Die Variable kann man auch im Inputfeld eingeben und auf das Plusicon am Ende klicken, um sie in die Watcherlist hinzuzufügen:

![IntelliJ zeigt nun, das hinzufügen eines Watchers](../images/debugging-add-watcher-intelliJ.png "Watcher hinzufügen in IntelliJ")

Die Watcher werden dann über den Variablen aufgelistet:

![IntelliJ zeigt nun, die Watchers](../images/debugging-watchers-intelliJ.png "Watchers in IntelliJ")

Genau wie beim Hinzufügen kann man einen Watcher entfernen, indem man einem rechten Mausklick auf die Variabel tätigt und "Remove Watch" anklickt.
