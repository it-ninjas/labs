---
title: "Testing"
linkTitle: "Testing"
weight: 9
description: >
  Modul #J4
---

## Testmanagement

Unter Testmanagement versteht man die geplante und effiziente Koordination aller Testprozesse, die die Qualität von Software optimieren und langfristig gewährleisten.
Grundsätzlich wird so die Identifizierung von und Reduzierung teilweise versteckter Qualitätsrisiken ermöglicht, womit potenzielle zukünftig auftretende finanzielle und aufwandstechnische
Belastungen in der Zukunft minimiert werden können. Hauptsächlich verfolgt das Testmanagement also 2 Ziele:

- Möglichst früh Software-Fehler aufdecken.
- Die Unsicherheit bezüglich der Qualität der Software minimieren.

Diese beiden Punkte sollen nachfolgend noch ein Stück ausformuliert werden.

### Möglichst früh Software-Fehler aufdecken

Oft ist es so, dass in der Entwicklung, Anpassungen oder Installation von Software erst recht spät getestet wird, was dazu führt, dass eine entsprechende Reaktion auf einen Fehler
meist erst verspätet ermöglicht wird. Grundsätzlich ist es so, dass die aus einem Fehler entstehenden Kosten exponentiell ansteigen, je später ein solcher gefunden und behandelt wird.
Die untenstehende Grafik veranschaulicht das relativ gut. Während das Beheben eines gefundenen Fehlers beim Erstellen und Prüfen der Anforderungen (Reqs) kaum etwas kostet, sind die
Kosten im Produktiven-Kontext (PROD) schon um einiges höher.

Da die meisten Fehler schon sehr früh im Umsetzungs-Ablauf passieren, lohnt es sich enorm, in ein sinnvolles Test-Management zu investieren, da so enorm viele Ressourcen gespart
werden können.

### Die Unsicherheit bezüglich der Qualität der Software minimieren

Es ist oft schwierig, einen guten Ausgleich zwischen einer guten Testabdeckung und einer lohnenswerten Wirtschaftlichkeit für das Unternehmen zu finden, da beispielsweise eine Testabdeckung
von 100% bei einer App schon sehr teuer werden kann. Daher ist es auch ein Fehlschluss, dass man mit genügend Tests sicherstellen könne, dass eine Software **fehlerfrei** ist. Testmanagement
hat daher zum Ziel, die Unsicherheit, dass eine Software **kritische** Fehler enthält, soweit zu minimieren, dass eine Produktivsetzung der App ohne schlechtes Gewissen durchgeführt werden kann.
Testmanagement hat daher **nicht** zum Ziel, dass eine Software absolut fehlerfrei ist.

### Vorteile von Testmanagement

Ein strukturiertes Testmanagement mit klar verteilten Rollen, Verantwortlichkeiten und Aufgaben resultiert zumeist in einigen Vorteilen, beispielsweise den folgenden:

- **Kostenreduktion**: Da Fehler oft zu einem früheren Zeitpunkt gefunden werden, wenn ein sinnvolles Testmanagement umgesetzt wird, können viele sonst entstehende Mehrkosten vermieden werden.
  Zudem bestehen in diesem Fall auch geringe Wartungsaufwände durch wiederholbare Tests und Klarheit in Bezug auf die zu testenden Anforderungen. Auch so kann stellenweise viel Geld gespart werden.
- **Bessere Planbarkeit** der Testphasen durch bekannte Testumfänge.
- **Personenunabhängige Tests** durch ausreichende Testfalldefinitionen und -dokumentation, was je nachdem sogar ein Outsourcing des Testings erlaubt.
- Stetige **Verbesserung der Softwarequalität** durch das Leben und durchgehende Verbessern des Testmanagements.
- Potenzielle Ressourcen- und Zeiteinsparung durch automatisierte Tests.

### Der Testprozess nach ISTQB

Ein offizieller Testprozess, nachdem man sich grundsätzlich ausrichten kann, ist der des International Software Testing Qualitications Board. (ISTQB)
Das ISTQB hat gängige, bewährte Praktiken und Terminologien zu einem prinzipiell universell anwendbaren Standard gebündelt, auf den nachfolgend etwas genauer eingegangen werden soll.

Der ISTQB-Prozess besteht grundsätzlich aus 4 Testphasen:

- Incident Management
- Problem Management
- Change Management
- Release Management

![ISTQB-Prozess](./images/testprozess_ISTQB.png)

Zu den jeweiligen Phasen gehören jeweils noch die entsprechenden Aktivitäten, namentlich die Planung, Spezifikation, Durchführung, Protokollierung und Auswertung der Tests. Diese Aktvitäten werden per
ISTQB jeweils in die folgenden Gruppen eingerodnet:

- Testplanung und -steuerung
- Testanalyse und -design
- Testrealisierung und -durchführung
- Testauswertung und -bericht
- Abschluss

### Rollen im Testmanagement

Es gibt innerhalb des Testmanagements viele verschiedene Rollen, die jeweils verschiedene Tätigkeiten verfolgen. Wie man diese unterscheidet, ist jeweils abhängig von der Tiefe der Betrachtung pro Fall,
der Einfachheit nehmen wir hier aber die einfachste Unterscheidung mit 2 Rollen; einmal der des Testmanagers und einmal der des Testers.

#### Testmanager

Der Testmanager ist für den gesamten, übergreifenden Testprozess und die erfolgreiche Durchführung der Testaktivitäten zu verantworten. Da es sich hier um eine rein koordinative Arbeit handelt, kann diese Rolle
von verschiedenen Personen übernommen werden. Wenn es der technische Prozess fordert, kann das ein professioneller Testmanager sein, in anderen Fällen kann es aber genau so gut ein Projektleiter ohne grossen technischen
Hintergrund sein.

Typische Aufgaben eines Testmanagers umfassen:

- Das Festlegen der Testrategie und -vorgaben für das Unternehmen
- Das Erstellen und Aktualisieren von Testplänen
- Das Koordinieren der Testpläne zwischen verschiedenen Stakeholdern
- Das Einplanen und Anstossen der verschiedenen Testaktivitäten wie der Testanalyse, dem Testdesign, der Testimplementierung und der Testdurchführung.
- Das Monitoring (Überwachen) der Testfortschritte und -ergebnisse
- Das Berichten über die Testfortschritte und -ergebnisse

Diese Aufgaben sind nicht als fixe Beschreibung der Rolle eines Testmanagers zu verstehen, sondern mehr als Beispiele. Je nach Grösse des Unternehmens, Anforderungen an das Testmanagement und das Produkt selbst und gegebener Zeit
können andere Aufgaben dazukommen oder genannte Aufgaben wegfallen. Eine Priorisierung dieser Aufgaben ist somit für jeden Fall unterschiedlich.

#### Tester

Ein Tester übernimmt grundsätzlich alle operativen Aufgaben innerhalb des Testprozesses, wobei das Durchführen der Tests nur eine Aufgabe darstellt, die der Tester übernimmt.
Je nachdem, welches Rollenmodell verfolgt wird, wird innerhalb der Rolle des Testers noch weiter zwischen einzelnen rollen unterschieden. Das können beispielsweise die folgenden sein:

- Testdesigner
- Testautomatisierer
- Testarchitekt
- etc.

Im Rahmen dieser Dokumentation nehmen wir aber alle diese Teilrollen unter einen Hut als "Tester". Typische Aufgaben in dieser Rolle können das Folgende umfassen:

- Prüfen der Anforderungen, Spezifikationen und Akzeptanzkriterien in Bezug auf die Testbarkeit
- Identifizieren und Dokumentieren der Testvoraussetzungen
- Erstellung und Implementation von Testfällen und Testprozeduren
- Erstellung des detaillierten Testausführungsplans
- Testautomatisierung
- (Bereitstellung der Testumgebung mit geeigneten Testdaten)