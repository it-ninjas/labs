---
title: "Debugging"
linkTitle: "Debugging"
weight: 18
description: >
  Modul #J12 - Debugging von Java Code
---

## Ziele

- Du weisst, wie du in IntelliJ Java Code debuggen kannst.

## Wieso ist Debuggen wichtig?

Es gibt eine Vielzahl von Gründen, warum Java-Anwendungen Fehler enthalten können. Typische Fehler sind zum Beispiel unerwartete Exceptions oder auch eine fehlerhafte Logik innerhalb des Codes. Mit Debugging kann man das Program systematisch analysieren und so die entsprechenden Fehler identifizieren und beheben.

Debuggen kann Entwicklern auch helfen den Ablauf eines Programms besser zu verstehen. Mit dem Debugger kann man den Code Schritt für Schritt durchlaufen und sieht, wie Daten sich verändern und wo welche Entscheidungen getroffen werden. Gerade wenn man eine Methode zum ersten Mal sieht, kann dies stark zum Verständnis der Funktionsweise des Programms beitragen.

### Warum debuggen und nicht `System.out.println()` verwenden?

Die Antwort ist ziemlich einfach, die gleiche Logik wie beim Loggen eines Wertes kannst du mit einem einfach programmierten Breakpoint erreichen. Dazu gleich mehr.

Das Problem beim Loggen von Nachrichten und Werten ist nicht, dass es nicht funktioniert. Es ist, dass es die Lesbarkeit des geschriebenen Codes beeinträchtigt und die Konsole mit sinnlosen Logs überfüllt. Ausserdem birgt jedes geschriebene Log das Risiko, dass es bei einem `git push` vergessen wird und so auf die produktiven Umgebungen gelangen könnte.

Zudem kann der Debugger deutlich mehr als nur Logs zu schreiben. Er wird benutzt, um mithilfe von Breakpoints den Code während der Ausführung anzuhalten, zu analysieren und Fehler im Code zu finden.
Somit ist es besser mit Tools von IntelliJ zu debuggen.

## Debuggen in IntelliJ

Um in IntelliJ zu debuggen, muss man nicht zuerst ein File erstellen oder eine Extension haben. Es reicht, bereits wenn man die Breakpoints setzt.
Dafür kann man, links neben der Zeilenzahl mittels Links-Klick einen normalen Breakpoint setzen oder mit Rechts-Klick die Optionen ansehen:

![IntelliJ zeigt nun, die Breakpoint Optionen](../debugging/debugging-options-intelliJ.png "Breakpoint Optionen IntelliJ")

Die Optionen zeigen folgende zwei Breakpoints:

- Breakpoints: Breakpoints sind die am häufigsten verwendeten. Sie ermöglichen es, den Programmfluss an einer bestimmten Zeile zu unterbrechen und den Code schrittweise zu debuggen.
- Conditional Breakpoints: Conditional Breakpoints ermöglichen es, einen Breakpoint zu setzen, der nur unter bestimmten Bedingungen ausgelöst wird.

Um weitere Arten von Breakpoints zu definieren, muss man in der Auswahl den Conditional Breakpoint auswählen und anschliessend auf `more` klicken.

![IntelliJ zeigt nun mehr Optionen](../debugging/debugging-conditional-breakpoint-intelliJ.png "Conditional Breakpoint Optionen IntelliJ Code")

Es öffnet sich ein Pop-Up, in welchem man weitere Möglichkeiten hat um Breakpoints zu definieren.

![IntelliJ öffnet ein erweitertes Breakpoint Menü](../debugging/debugging-conditional-breakpoint-extend-intelliJ.png "Conditional Breakpoint Optionen IntelliJ Code")

Hier kann beispielsweise, wie im Bild ersichtlich, einen Log definieren, so fungiert der Breakpoint zusätzlich als System.out.println(). Man kann auch einstellen, dass der Breakpoint entfernt werden soll, sobald er einmal aufgerufen wurde. Oder dass er solang inaktiv sein soll bis ein anderer Breakpoint ausgelöst wurde.

Um den Debug-Modus zu starten, kann man in IntelliJ oben rechts das Icon das wie ein Käfer aussieht verwenden:

![IntelliJ zeigt nun, den Debuggstartbutton](../debugging/debugging-starten-intelliJ.png "Startbutton zum Debuggen in IntelliJ")

Das Debugging-Panel unten auf der Benutzeroberfläche besitzt verschiedene nützliche Tools:

- Debugger Controls
- Debug Console
- Frames
- Variables
- Watches

![IntelliJ zeigt nun, das Debugger Panel](../debugging/debugging-panel-intelliJ.png "Debugger Panel in IntelliJ")

### Debugger Controls:

![IntelliJ zeigt nun, das Debugger Actions](../debugging/debugging-actions-intelliJ.png "Debugger Actions in IntelliJ")

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

![IntelliJ zeigt nun, das Frame Panel](../debugging/debugging-frames-panel-intelliJ.png "Frame Panel in IntelliJ")

### Variables:

Hier kann man die Werte von Variablen während des Debugging-Prozesses überwachen. Man kann die Variablen auswählen, um ihre aktuellen Werte anzuzeigen, oder man kann Ausdrücke eingeben, um ihre Werte zu berechnen.

![IntelliJ zeigt nun, das Variable Panel](../debugging/debugging-variables-panel-intelliJ.png "Variable Panel in IntelliJ")

### Watches:

Man kann eine Liste von Variablen erstellen, die man überwachen möchten. Man kann Variablen zur Watcherlist hinzufügen, indem man mit der rechten Maustaste auf die Variable klicken und "Add to Watches" auswählen.
Die Variable kann man auch im Inputfeld eingeben und auf das Plusicon am Ende klicken, um sie in die Watcherlist hinzuzufügen:

![IntelliJ zeigt nun, das hinzufügen eines Watchers](../debugging/debugging-add-watcher-intelliJ.png "Watcher hinzufügen in IntelliJ")

Die Watcher werden dann über den Variablen aufgelistet:

![IntelliJ zeigt nun, die Watchers](../debugging/debugging-watchers-intelliJ.png "Watchers in IntelliJ")

Genau wie beim Hinzufügen kann man einen Watcher entfernen, indem man einem rechten Mausklick auf die Variabel tätigt und "Remove Watch" anklickt.

## Debuggen von Spring Boot

Spring Boot Code ist in Java geschrieben, dementsprechend bleibt das Debuggen grundsätzlich gleich. Jedoch musst du die Interaktionen zwischen Repositorys, Services und Controllern gut verstehen und wissen, wo du die Breakpoints zu setzen hast. Im Zweifelsfall kann dir die Funktion Step Into behilflich sein.

---

Mehr Informationen bezüglich Debuggen in IntelliJ findest du unter folgenden Link:
[Debug Code](https://www.jetbrains.com/help/idea/debugging-code.html)
