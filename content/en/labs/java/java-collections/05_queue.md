---
title: "Queue + Deque - Aufgaben"
linkTitle: "Queue + Deque"
type: docs
weight: 5
description: >
  Aufgaben zu [Java Collections - Queue + Deque](../../../../docs/java/java-collections/06_queue)
---

## Aufgabe 1 (Optional)

Wir implementieren eine einfache `Job`-Verarbeitung.
Zwei `InputWorker` erstellen neue `Job`'s, welche parallel von einem `OutputWorker` abgearbeitet werden.

Jeder `InputWorker` erstellt eine definierte Anzahl Jobs und stoppt anschliessend. Die Anzahl könnt ihr in der Start-Klasse anpassen: `Start.INPUTWORKER_NUMBER_OF_JOBS`.

Nach jedem Arbeitsschritt (Job erstellen oder verarbeiten) machen die Workers eine kleine Pause.
Ihr könnt die maximale zufällige Dauer über die statischen Variablen `Start.INPUTWORKER_MAX_RELAX_TIME_MS` und `Start.OUTPUTWORKER_MAX_RELAX_TIME_MS` steuern.
Auch die maximal zufällige Dauer zum Abarbeiten eines Jobs kann definiert werden: `Start.OUTPUTWORKER_MAX_PROCESS_TIME_MS`.

Der `OutputWorker` stoppt, sobald er während einer Anzahl Durchgänge (`Start.OUTPUTWORKER_STOP_AFTER_EMPTY_CYCLES`) keine Jobs zum Verarbeiten erhält.

Die Worker sind mit dem `ProcessingInterface` entkoppelt, welches das Hinzufügen und Abholen der Jobs zur Verfügung stellt:

{{% details title="Inferface ProcessingInterface" %}}

```java
package ch.itninjas.labs.j7.queue;

public interface ProcessingInterface {

    /**
     * Add a job to the system.
     * @return true if the job is added.
     */
    public boolean addJob(Job job);

    /**
     * Get the next job for processing.
     */
    public Job getNextJob();

    /**
     * Put the unprocessed job back to the system.
     */
    public void getJobBack(Job job);

    /**
     * Get the number of jobs in the system.
     */
    public int getJobs();

    /**
     * Has jobs in the system for processing?
     */
    public boolean hasJobs();
}



```

{{% /details %}}

In der Konsole seht ihr die Arbeit der Workers:

{{% details title="Mögliche Konsole-Ausgabe" %}}

```text
   [InputWorker-1] stared successfully
   [InputWorker-2] stared successfully
-> [InputWorker-1]  add job:     Job{id=1, message='[InputWorker-1]: (14:52:41) It is a very hard job!', jobState=NEW}
-> [InputWorker-2]  add job:     Job{id=2, message='[InputWorker-2]: (14:52:41) It is a very hard job!', jobState=NEW}
-> [InputWorker-2]  add job:     Job{id=3, message='[InputWorker-2]: (14:52:43) It is a very hard job!', jobState=NEW}
-> [InputWorker-1]  add job:     Job{id=4, message='[InputWorker-1]: (14:52:43) It is a very hard job!', jobState=NEW}
   [OutputWorker-1] stared successfully
<- [OutputWorker-1] process job: Job{id=1, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=1, message='It job is finish!', jobState=FINISH}
-> [InputWorker-2]  add job:     Job{id=5, message='[InputWorker-2]: (14:52:43) It is a very hard job!', jobState=NEW}
<- [OutputWorker-1] process job: Job{id=2, message='It is a really hard job!', jobState=IN_PROGRESS}
-> [InputWorker-1]  add job:     Job{id=6, message='[InputWorker-1]: (14:52:44) It is a very hard job!', jobState=NEW}
== [OutputWorker-1] finish job:  Job{id=2, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=3, message='It is a really hard job!', jobState=IN_PROGRESS}
-> [InputWorker-1]  add job:     Job{id=7, message='[InputWorker-1]: (14:52:44) It is a very hard job!', jobState=NEW}
== [OutputWorker-1] finish job:  Job{id=3, message='It job is finish!', jobState=FINISH}
-> [InputWorker-2]  add job:     Job{id=8, message='[InputWorker-2]: (14:52:45) It is a very hard job!', jobState=NEW}
<- [OutputWorker-1] process job: Job{id=4, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=4, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=5, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=5, message='It job is finish!', jobState=FINISH}
-> [InputWorker-1]  add job:     Job{id=9, message='[InputWorker-1]: (14:52:46) It is a very hard job!', jobState=NEW}
<- [OutputWorker-1] process job: Job{id=6, message='It is a really hard job!', jobState=IN_PROGRESS}
-> [InputWorker-2]  add job:     Job{id=10, message='[InputWorker-2]: (14:52:47) It is a very hard job!', jobState=NEW}
== [OutputWorker-1] finish job:  Job{id=6, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=7, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=7, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=8, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=8, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=9, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=9, message='It job is finish!', jobState=FINISH}
<- [OutputWorker-1] process job: Job{id=10, message='It is a really hard job!', jobState=IN_PROGRESS}
== [OutputWorker-1] finish job:  Job{id=10, message='It job is finish!', jobState=FINISH}
?? [OutputWorker-1] Nothing to do, I stop.

```

{{% /details %}}

Mit der `Start`-Klasse wird das gesamte System gestartet.
Leider fehlt ein zentraler Teil des Systems:
Ihr müsst das Interface `ProcessingInterface` implementieren.

> Ihr findet den Programmcode im **work Repo**:  
> https://github.com/it-ninjas/work/tree/main/labs/src/main/java/ch/itninjas/labs/j7/queue/lab1

### Aufgabe 1.1 (Optional)

1. Implementiert das `ProcessingInterface` mit einer Queue, damit die Jobs im **FIFO-Prinzip** (First-In-First-Out) verarbeitet werden.
2. Kontrolliert die Konsole-Ausgabe:
   1. Ob alle Jobs verarbeitet wurden.
   2. Ob die Jobs in der gewünschten Reihenfolge verarbeitet wurden.
3. Verändert die Pausen und Verarbeitungszeit der Worker und schaut euch der Einfluss in der Konsole an.

### Aufgabe 1.2 (Optional)

1. Implementiert das `ProcessingInterface` mit einer Queue, damit die Jobs im **LIFO-Prinzip** (Last-In-First-Out) verarbeitet werden.
2. Kontrolliert die Konsole-Ausgabe:
   1. Ob alle Jobs verarbeitet wurden.
   2. Ob die Jobs in der gewünschten Reihenfolge (Last-In-First-Out) verarbeitet wurden.
3. Verändert die Pausen und Verarbeitungszeit der Worker und schaut euch der Einfluss in der Konsole an.

## Aufgabe 2 (Optional)

Erweitert den `OutputWorker` so, dass er vor der Verarbeitung eines Jobs die Anzahl offener Jobs anzeigt.

## Aufgabe 3 (Optional)

Erweitert den OutputWorker so, dass er zufällig einzelne Jobs nicht erfolgreich bearbeiten kann und diese mit der Methode `ProcessingInterface.getJobBack(Job job)` zurück in die Queue stellt.

## Aufgabe 4 (Optional)

Erstellt ein JUnit-Test (JUnit Version 5), welcher die Schnittstelle `ProcessingInterface` der Klasse `Processing` ausführlich testet.
