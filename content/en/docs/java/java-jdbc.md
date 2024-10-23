---
title: "JDBC (Java Database connection)"
linkTitle: "JDBC (Java Database connection)"
weight: 11
description: >
  Modul #J7 - JDBC
---

#### Ziele

- Ich weiss was die JDBC-Schnittstelle ist und wofür sie benutzt wird
- Ich weiss was JDBC-Treiber sind und warum sie benötigt werden
- Ich kenne die wichtigsten Interfaces der JDBC-Schnittstelle
- Ich weiss wie parametrisierte SQL-Anweisungen verwendet werden können
- Ich kann eine Datenbank-Verbindung aus einer Java-Anwendung herstellen
- Ich kann CRUD-Operationen aus einer Java-Anwendung ausführen

## Einleitung

Die meisten Apps und Webseiten, welche wir heutzutage fast täglich verwenden, dienen lediglich der Datenverarbeitung.  
Sobald du ein Bild deines Freundes likest, den Fahrplan abrufst oder eine neue Tastatur bestellst,
es werden immer Daten gelesen, geschrieben, bearbeitet oder gelöscht.  
Es gibt Frameworks (darunter z.B. Spring), welche die Verbindung zu Datenbanken verwalten und die sog.
"Boiler-Plate"-Details dazu von den Entwicklern verbergen. Diese Frameworks bieten auch einfache
Interaktion mit der Datenbank z.B. im Form von CRUD-Operationen.
Durch das Verwenden solcher Frameworks kann auf "Boiler-Plate" Code verzichtet werden.
Die Entwicklung von Business-Logik ist somit von infrastrukturellen Details getrennt.

Es gibt jedoch Situationen, wo solche Frameworks nicht benutzt werden können oder man muss bestimmte
Aktivitäten, welche diese Frameworks out-of-the-box anbieten, anders gestalten.
In solchen Situationen kann die JDBC-Bibliothek von Java verwendet werden.

## Was ist JDBC

JDBC ist eine Schnittstelle, welche dafür benutzt wird, um aus einer Java Anwendung eine Verbindung
zu einer Datenbank herzustellen und Queries auf den Daten darin (z.B. lesen oder bearbeiten) ausführen zu können.  
Die JDBC-Schnittstelle stellt eine Datenbank unabhängige API zur Verfügung und trägt damit dazu bei, dass
die Anwendung nicht an einer bestimmten Datenbank stark gekoppelt ist (sprich, die Anwendung muss die
unterliegende Datenbank, theoretisch, gar nicht kennen).

Um die eigentliche Verbindung mit der Datenbank zu ermöglichen, werden JDBC-Treiber eingesetzt.
Ein JDBC-Treiber ist eine Software-Komponente, welche die Zugriffstechnik für eine bestimmte Datenbank
(z.B. Oracle, Postgres usw.) kennt und somit in der Lage ist, Anfragen an der Datenbank weiterzuleiten
wie auch die Ergebnisse zurückzuliefern. Solche Treiber können umgetauscht werden, wenn die unterliegende Datenbank
geändert werden soll, ohne dass es zu einer Anpassung in der Anwendung-Code kommt.

Eine vereinfachte Darstellung der JDBC-Architektur sieht also wie folgt aus:

![](../java-jdbc/jdbc-architektur.png "JDBC-Architektur")

## JDBC in der Praxis

Die Klassen und Interfaces der JDBC-Schnittstelle befinden sich im Paket "java.sql".
Entsprechend reicht ein "import"-Statement um mit diesen Klassen/Interfaces arbeiten zu können.
Die JDBC-Treiber sind jedoch separate und proprietäre Komponenten, welche zur Laufzeit vorhanden sein müssen
damit der Classloader sie wirklich laden kann. Bei einem Maven-Projekt wird dies mittels einer Maven-Abhängigkeit
erledigt. Ansonsten muss die Jar-Datei des Treibers auf dem Klassenpfad vorhanden sein.

Die ersten Schritte bei der Arbeit mit der JDBC-Schnittstelle beinhalten die nötige Konfiguration um die
Verbindung zur Datenbank herstellen zu können. Anschliessend können Abfragen und sonstige
SQL-Anweisungen ausgeführt werden.

Die folgenden Abschnitte zeigen die nötigen Schritte anhand von Beispielen.
Diese Beispiele wurden in einem Maven-Projekt ohne das Spring-Framework erstellt.

### Maven-Dependency

Sobald die gewünschte Datenbank festgelegt wurde, kann der dazugehörende JDBC-Treiber als
Maven-Abhängigkeit herangezogen werden.

Das folgende Beispiel zeigt eine Abhängigkeit zu einem MySql-Treiber:

![dependency.png](../java-jdbc/dependency.png)

Die restlichen Schritte erfolgen im Java-Code.

### Treiber laden/registrieren

**Hinweis**  
Dieser Schritt wird nur bei JDBC-Versionen benötigt, welche älter sind als die Version 4!
Bei neueren Versionen, werden alle Treiber geladen, welche auf dem Klassenpfad gefunden werden und
somit braucht es diesen Schritt nicht mehr.

Mit der statischen Methode _forName_ von _Class_ wird die Klasse _Driver_ geladen.
Hier geht es um die Datenbank spezifischer Treiber, welche es der Anwendung den Datenzugriff auf der
gewünschten Datenbank ermöglicht.

Im folgenden Beispiel wird der JDBC-Treiber für MySql registriert:

![](../java-jdbc/driver_registration.png)

### Datenbankverbindung herstellen

Der Zugriff auf einer Datenbank erfordert die Konfiguration folgender Elemente:

- url: eine JDBC-URL, welche auf die gewünschte Datenquelle zeigt
- Benutzername: einer, für den Zugriff auf die Datenbank, autorisierter Benutzer
- Passwort: das Passwort des autorisierten Benutzers, womit er sich authentifizieren kann

![](../java-jdbc/connection_configuration.png)

Die Konfiguration wird hier einfachheitshalber als Klartext im Code geschrieben.
Selbstverständlich dürfen vertrauliche Informationen wie z.B. das Passwort nicht als Klartext im Code stehen.
Für diesen Zweck, wie auch für die Konfiguration unterschiedlichen Umgebungen, eignen sich System-
oder Umgebungsvariablen (mit oder ohne Verschlüsselung) besser.

Die obige Konfiguration kann nun für die Herstellung einer Datenbankverbindung verwendet werden.
Dazu wird die statische Methode _getConnection_ der Klasse _DriverManager_ verwendet:

![](../java-jdbc/connection_creation.png)

Ab diesem Punkt repräsentiert das Connection-Objekt die Verbindung zur Datenbank.

### SQL-Anweisung vorbereiten

Die SQL-Anweisung kann als String vor der Ausführung vorbereitet werden:

![](../java-jdbc/select_query_no_params.png)

Wenn eine IDE wie z.B. IntelliJ verwendet wird und eine Datasource mit der richtigen Datenbank definiert wird,
erkennt die IDE, dass es sich um eine SQL-Anweisung handelt und liefert entsprechend
Vorschläge und formatiert die Anweisung richtig und gut leserlich.

Die obige SQL-Anweisung dient dazu alle Daten aus einer bestehenden Tabelle zu Lesen.
SQL-Anweisungen können aber auch Operationen wie Tabellen erstellen, Daten einfügen, löschen oder
bearbeiten usw. beinhalten.

Als Beispiel, erstellt die folgende SQL-Anweisung eine Tabelle - falls diese noch nicht existiert -
mit ein paar gewünschten Attributen (Spalten):

![](../java-jdbc/create_table_query.png)

### SQL-Anweisung ausführen

Um SQL-Anweisungen ausführen zu können wird zunächst ein Statement-Objekt aus dem vorhandenen
Connection-Objekt erzeugt. Dieses Statement-Objekt wird verwendet, um die SQL-Anweisung an die
Datenbank zu richten. Dazu wird eine der _execute_ Methoden des Statement-Objektes verwendet.

Im folgenden Beispiel wird die ein Statement-Objekt mithilfe des Connection-Objekt erstellt.
Danach wird die Methode _executeQuery_ verwendet, welche eine SQL-Anweisung als
Parameter entgegennimmt, diese ausführt und eine Referenz auf die Ergebnismenge (sog. ResultSet) zurückliefert:

![](../java-jdbc/statement_exectution.png)

### Parametrisierte SQL-Anweisungen

Bis jetzt haben wir SQL-Anweisungen ausgeführt, welche keine Einschränkungen beinhaltet haben.
Oft werden jedoch SQL-Anweisungen mit bestimmten Kriterien oder Einschränkungen benötigt damit die
zurückgelieferten Daten anhand dieser Kriterien gefiltert werden können.
In solchen Situationen wird der SQL "WHERE"-Befehl benutzt. Zum Beispiel:

_SELECT \* FROM user WHERE username = 'gandalf' and age > 20;_

In diesem Beispiel, werden nur Einträge zurückgeliefert, welche die Kriterien _username = 'gandalf'_
und _age > 20_ erfüllen.
Wenn nun dieselbe Anweisung mehrmals ausgeführt werden soll aber jeweils mit anderen Parameter (also mit unterschiedlichen _username_ und _age_),
wird die Anweisung mit Platzhaltern wie folgt geschrieben (ein Fragezeichen dient als einen Platzhalter):

![](../java-jdbc/query_with_placeholder.png)

Für das eigentliche Ausführen der Anweisung müssen alle Platzhalter durch konkrete Werte ersetzt werden.
Dazu wird ein _PreparedStatement_ verwendet, welche es erlaubt, alle Platzhalter anhand ihrer Position (beginnend mit 1)
mittels _setXXX_ Methoden anzusprechen und mit den konkreten Werten zu ersetzen.
Anschliessend, kann auch hier eine der _executeXXX_ Methoden verwendet werden, um die Anweisung auszuführen:

![](../java-jdbc/prepared_statement.png)

### Rückgabewerte verarbeiten

Bei der Ausführung von bestimmten SQL-Anweisungen (z.B. bei SELECT Operationen), wird eine Ergebnismenge zurückgeliefert.
Ein ResultSet repräsentiert einen sog. _Cursor_ auf diese Ergebnismenge.
Die Methoden des ResultSets, bewegen den Cursor (je nach Art des Cursors) vorwärts, rückwärts, zur ersten oder zur letzten Position usw.
Somit kann über die gesamte Ergebnismenge, Zeile bei Zeile, iteriert werden, um die Werte zu lesen.

![](../java-jdbc/resultset_iteration.png)

Im obigen Beispiel wird die _next_ Methode verwendet um den Cursor jeweils eine Zeile vorwärtszubewegen.
Aus jeder Zeile werden aus dem ResultSet mittels _getXXX_ Methoden (XXX steht für den Typ des Wertes)
die Werte, welche in dieser aktuellen Zeile vorhanden sind.
Die _getXXX_ Methoden, bekommen als Parameter entweder die Spaltenposition oder den Spaltennamen, welche gelesen werden soll.
Bei einer Spaltenposition hat die erste zurückgelieferte Spalte die Position 1.
Hinter der letzten Zeile liefert die _next_ Methode _false_ zurück und somit wird die Schleife beendet,
nachdem alle Zeilen bearbeitet worden sind.

### Verbindungen schliessen

Objekte der Typ _Connection_, _Statement_ oder auch _PreparedStatement_ sind sog. Ressourcen.
Solche Ressourcen müssen nach Verbrauch wieder explizit geschlossen werden:

![](../java-jdbc/close_statement_and_connection.png)

Wenn diese Ressourcen innerhalb eines try-with-resources Befehls erstellt werden, entfällt diese
explizite Schliessung der Ressourcen.  
Die Arbeit mit try-with-resources ist immer vorzuziehen, wenn es um Closable-Ressourcen geht.

### Zusammenfassung

Die folgende Beispiel-Methode fasst die oben erwähnten Arbeitsschritte mit JDBC (aktuelle Version) zusammen:

![](../java-jdbc/jdbc_complete_code_example.png)

---

![task1](/images/task.png) Jetzt bist du dran. Löse bitte diese [Aufgabe](../../../../labs/java/java-jdbc/01_jdbc_exercises/) in den Labs.
