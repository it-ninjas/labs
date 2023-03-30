---
title: "New Spring Doc"
linkTitle: "New Spring Doc"
weight: 16
description: >
    Modul #J11 - Spring Boot
---


### Framework:

Ein Framework ist eine Grundlage, auf der Applikationen basieren. Frameworks stellen Funktionen von essenzieller Wichtigkeit bereit damit man diese nicht jedes Mal neu schreiben muss.

### Spring Framework

Das Spring Framework gibt uns die Werkzeuge eine einfache Web-Applikation zu erstellen. Mit ihm kann man vom Internet zugängliche Schnittstellen machen, mit einer Datenbank verbinden oder Objekte Speichern.

### Boot:

Spring Boot ist eine Art Vereinfachung des normalen spring Frameworks. Bei Spring Boot kann mithilfe des sogenannten Spring Initialializers Abhängigkeiten wie z.B. Datenbanktreiber oder Software für die Cloud-infrastruktur ausgewählt werden. Somit entfällt die manuelle Konfiguration des Projektes. Jedoch ist Spring Boot kein Ersatz für das Spring Framework, denn es hilft vor allem die Konfiguration zu vereinfachen.

### Design-Pattern:

Design-Patterns sind wiederverwendbare Vorlagen, die wir beim Erstellen von Anwendungen verwenden können. Das gute an diesen Design-Patterns ist, dass sie meist nicht spezifisch für eine Programmiersprache geschaffen sind, sondern bei vielen verschiedenen Programmiersprachen angewendet werden können. Es gibt 3 verschiedene Design-Patterns: 1: Kreationsmuster 2: Strukturmuster 3: Verhaltensmuster



### Inversion of Control:

«Inversion of Control» ist ein Prinzip, das besagt, dass eine Entität nur das macht, was ihre Hauptaufgabe ist. Das heisst, dass jede Entität nur für etwas zuständig ist. Zum Beispiel wenn man mit dem Auto zur Arbeit fährt, ist man für das Fahren und das Arbeiten zuständig, würde man aber ein Taxi bestellen ist der Taxifahrer fürs Fahren und du fürs Arbeiten zuständig. Die Zuständigkeiten sind also getrennt.

Das Spring Framework benutzt das «Inversion of Control» Prinzip.



### Dependency Injection

Eine Dependency oder eine Abhängigkeit (Service) wird in ein Objekt (Client) weitergegeben (normalerweise sagt ein Objekt welche Abhängigkeiten es braucht).  Das heisst, dass man die Abhängigkeit einem Objekt, welches diese Benötigt übergeben muss und dass man die Abhängigkeit nicht ins Objekt importieren kann.



### Singleton:

Wenn wir über Singleton sprechen, geht es um Objekte, die die einzige Instanz von deren Klasse sind. Das heisst wenn wir bereits ein Objekt einer bestimmten Klasse benutzen, können wir sicher sein, dass es kein weiteres Objekt dieser Klasse hier geben wird.



### HTTP Access-Control:

Die HTTP-Standards um auf Ressourcen zuzugreifen:

GET – Read only access auf eine Ressource erhalten

POST – Neue ressource erstellen

DELETE – Ressource löschen

PUT – Updated oder created resourcen, falls diese noch nicht existieren



### Bean:

Bean Objekte sind eigentlich das Rückgrat einer Anwendung. Die Bean Objekte werden instanziiert, zusammengebaut und von einem Spring IoC-Container (Inversion of Control) verwaltet. Sie werden mit Metadaten erstellt, die sie danach auch an dem Container weiterliefern. 

### Spring Struktur

(Bildlink funktioniert auf website, nicht in md!)

![spring-struktur.png](../new-spring-doc/spring-struktur.png)



Die Meisten modernen Webapplikationen bestehen aus 3 schichten:

Boundary (Grenze): Auf dieser Schicht wird die Kommunikation mit der Aussenwelt abgewickelt.

Control (Verwaltung): Auf dieser Schicht sind alle Klassen mit der Logik.

Entity (Speicher): Auf dieser Schicht wird alles abgewickelt, was mit Datenspeicherung und Auslesung zu tun hat (zb. Mit Repositories).



### Repository:

Eines der am häufigsten verwendeten Design-Patterns (siehe oben) ist das Repository Design-Pattern. Es ist ein Interface, das dafür zuständig ist, uns Zugang zu den Daten in der Datenbank zu bereiten. Man kann es sich ein wenig, wie einen Bibliothekar vorstellen. Er gibt uns die Bücher, die wir wollen, ohne dass wir wissen, wie er sie uns beschafft. Wir kennen nur die API, also die Befehle, und welche Resultate wir erwarten können.

(Codebeispiel in docs) 



Meistens wird das Interface im Hintergrund vom Framework implementiert und wir müssen nichts dafür tun.



Control Layer:

Control Layer bildet den Kern aller Anwendungen und enthält dessen Geschäft Logiken. Auf der Technischen Ebene ist der Control Layer die grundlegendste und die wenigste interessante Schicht. Der Control Layer könnte wie folgt aussehen:

(Codebeispiel in docs)

Control Layer noch nicht fertig!!! 