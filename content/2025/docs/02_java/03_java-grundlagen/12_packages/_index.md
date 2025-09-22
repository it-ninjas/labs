---
title: "Packages"
linkTitle: "Packages"
weight: 12
description: >
  In diesem Modul lernst du, wie man Java-Packages strukturiert, importiert, wiederverwendet und weitergeben kann.
---

{{< module "J1" >}}

## Ziele

- Ich weiss, was ein Package ist und wozu man es verwendet.
- Ich kann eigene Packages deklarieren und verstehen, wie sie im Dateisystem aufgebaut sind.
- Ich kenne die Sichtbarkeiten `public`, `protected`, `private` und `(default)` und deren Bedeutung im Zusammenhang mit
  Packages.
- Ich weiss, wie man Packages importiert und wann dies notwendig ist.
- Ich verstehe den Unterschied zwischen eingebauten, externen und selbst geschriebenen Packages.
- Ich weiss, woher externe Packages stammen können (lokal, Maven Central, GitHub ...).
- Ich kann ein Java-Package lokal so bereitstellen, dass es in anderen Projekten verwendet werden kann.
- Ich weiss, was eine API ist und warum eine gute JavaDoc wichtig ist.
- Ich habe eine erste Vorstellung, was `static` bedeutet und wofür man es nutzt.

{{< zeit lesen="15" >}}

## Was ist ein Package?

Ein **Package** ist ein Namensraum zur Gruppierung von Klassen und anderen Programmteilen. In einem späteren Modul wirst
du Klassen auch in einem anderen Zusammenhang begegnen. Klassen benötigt man später auch, um Objekte zu beschreiben.
Vorerst helfen uns die Klassen, Methoden zu gruppieren.

In Java beginnt jede Datei optional mit einer `package`-Anweisung:

```java
package ch.itninja.tool;
```

Damit sagst du, dass sich die Datei im Package `ch.itninja.tool` befindet. Entsprechend muss die Datei im Verzeichnis
`ch/itninja/tool` liegen.

{{< ninja tip >}}
Ein Package entspricht einem Verzeichnis im Dateisystem. Achte auf die korrekte Ordnerstruktur und wähle den Namen eines
Packages mit bedacht. Ein guter Name hilft dir später, den Zusammenhang komplexer Software schneller zu verstehen und
das passende Packet für eine Problemstellung schneller zu finden.
{{< /ninja >}}

Packages helfen, deinen Code zu strukturieren und Wiederverwendung zu ermöglichen. Auch Bibliotheken wie `java.util`
oder `java.io` sind Packages.

{{< ninja info >}}
Packages eröffnen dir eine Welt ungeahnter Möglichkeiten: Bis jetzt hast du Aufgaben meist mit mathematischen und
logischen Operationen sowie bedingten Anweisungen gelöst. Das kann bei komplexeren Problemen sehr aufwändig werden.

Hier kommen Packages ins Spiel: Für viele wiederkehrende Aufgaben gibt es bereits fertige Hilfsklassen – sogenannte
**Utility-Klassen**. Du musst das Rad nicht neu erfinden!

Beispiele für nützliche Packages:

- `java.lang.Math`: Mathematische Methoden wie `max()`, `min()`, `pow()` oder `sqrt()`
- `java.lang.String`: Zeichenketten-Verarbeitung (nächstes Modul)
- `java.util.Scanner`: Einfache Konsoleneingabe (folgt bald)
- `java.io.File`: Arbeiten mit Dateien

Die Methoden dieser Klassen kannst du direkt verwenden – oft ohne objektorientierte Programmierung.
{{< /ninja >}}

## Packages vs. Bibliotheken

| Begriff        | Bedeutung                                                |
| -------------- | -------------------------------------------------------- |
| **Package**    | Logische Gruppierung von Klassen im Quellcode            |
| **Bibliothek** | Weitergabe eines oder mehrerer Packages als `.jar` Datei |

### Package

Ein Package ist eine logische Gruppierung von Klassen, um Code zu strukturieren. Beispiel:

```java
package ch.itninja.util;
```

Das Package hilft, Code zu ordnen und wiederzuverwenden. Es zeigt, wo man den Quellcode findet (der Package Name
entspricht dem Pfad, wo der Quellcode abgelegt ist)

### Bibliothek (Library)

Eine Bibliothek ist ein weitergegebenes `.jar`-Archiv mit einem oder mehreren Packages.  
Beispiel: Du exportierst `MathUtils` im Package `ch.itninja.util` als `math-utils.jar`.

## Sichtbarkeiten verstehen

In Java steuerst du über Sichtbarkeiten, von wo auf eine Klasse, Methode oder Variable zugegriffen werden darf:

| Sichtbarkeit | Bedeutung                                                           |
| ------------ | ------------------------------------------------------------------- |
| `public`     | Überall sichtbar – auch von anderen Packages                        |
| `protected`  | Sichtbar für Unterklassen und innerhalb desselben Packages          |
| `(default)`  | Sichtbar nur innerhalb desselben Packages (kein Modifier angegeben) |
| `private`    | Sichtbar nur innerhalb derselben Klasse                             |

`public` ist nötig, wenn eine Klasse oder Methode von einem **anderen Package** aus genutzt werden soll.  
Mit `(default)` (kein Modifier) ist die Nutzung nur **innerhalb desselben Packages** erlaubt, das ist sehr praktisch für
interne Hilfsmethoden oder Klassen.

{{< ninja tip >}}
Wähle die Sichtbarkeit so restriktiv wie möglich – am besten in dieser Reihenfolge:

1. `private`
2. `protected`
3. `(default)` _(package-intern)_
4. `public`

**Begründung:**  
Je offener die Sichtbarkeit, desto größer das Risiko von ungewollten Abhängigkeiten und Nebenwirkungen.  
Wenn etwas `public` ist, kann es von beliebigen anderen Packages (auch außerhalb deines Projekts) genutzt werden.  
Änderungen an einer `public`-Schnittstelle können daher weitreichende Folgen haben, die du nicht immer abschätzen kannst.

Mit `(default)`, `protected` oder `private` bleiben die Auswirkungen auf dein eigenes Package oder sogar nur auf die
eigene Klasse beschränkt. Das verringert das Risiko erheblich.
{{< /ninja >}}

## Importieren von Packages

Wenn du eine `public`-Klasse aus einem anderen Package brauchst, musst du sie **importieren**:

```java
import java.util.Scanner;
```

Oder mit Wildcard (nicht empfohlen):

```java
import java.util.*;
```

Manche Klassen stehen dir ohne Import zur Verfügung, z. B. `String` oder `System`. Das sind Klassen aus dem Package
`java.lang`, welches **automatisch importiert** wird.

## Woher kommen Packages?

Es gibt drei Arten von Packages:

1. **Java-eigene Packages** – z. B. `java.util`, `java.io`, `java.math`
2. **Externe Packages** – z. B. `org.apache.commons.math3`
3. **Eigene Packages** – z. B. `ch.itninja.util`

Externe Packages müssen **zuerst zum Projekt hinzugefügt werden**, z. B.:

- aus dem **lokalen Dateisystem** (z. B. `.jar`-Datei)
- aus einem **Maven-Repository** (z. B. Maven Central)
- aus einem **GitHub Release** oder privaten Server

## Eigene Packages erstellen

Wenn du eigenen Code schreibst, sollte:

- zu Beginn der Datei der Name des Packages mit `package` definiert werden, z. B. `package ch.itninja.math;`
- die Datei in einen gleichnamigen Ordner legen: `ch/itninja/math`

{{< ninja warning>}}
**Verwende keine Klassen ohne package-Deklaration!**
Nur mit einer package-Zeile liegt deine Datei in einem benannten Package – das ist wichtig für Struktur,
Wiederverwendbarkeit und Importierbarkeit.
{{< /ninja>}}

Die `src`-Struktur eines Projekts sieht z. B. so aus:

```
myproject/
├── src/
│   └── main/
│       └── java/
│           └── ch/
│               └── itninja/
│                   └── math/
│                       └── Calculator.java
```

> `src/main/java` ist eine weitverbreitete Abmachung, welche hilft, dass Tools wie Maven mit dem Quellcode arbeiten
> können. Java selbst kann auch ohne diese Verzeichnisse kompilieren.

## Packages weitergeben und wiederverwenden

Wenn du ein Package (z. B. eine Hilfsklasse) in einem anderen Projekt verwenden willst, hast du zwei Möglichkeiten:

1. **Du erstellst eine `.jar`-Datei** deines Projekts (Java-Archiv)
2. **Du kopierst den Sourcecode (temporär, nicht empfohlen)**

Ein `.jar` kannst du in anderen Projekten verwenden, z. B. per "Add as Library".

Du kannst eine `.jar` auch weitergeben:

- als **lokale Datei** oder ZIP
- über ein **gemeinsames Netzlaufwerk**
- über einen **lokalen Maven-Server** (kommt später)

{{< ninja tip >}}
Wenn du IntelliJ nutzt und eine `.jar`-Datei ohne Maven erzeugen und in ein anderes Projekt einbinden willst, lernst du
im Modul [Packages lokal verwenden](../../../99_shared/ide/intellij/07_packages/) wie das geht.
{{< /ninja >}}

## API und JavaDoc

Ein **API** (Application Programming Interface) ist die **Schnittstelle** deines Codes nach außen.  
Zur API gehören alle **`public`-Klassen und `public`-Methoden**, die von anderen Packages oder Projekten aus genutzt
werden können.

**Wichtig:**  
Alles, was `public` ist, wird Teil deiner API – egal, ob du es als „offizielle Schnittstelle“ geplant hast oder nicht.  
Darum solltest du `public` nur dort verwenden, wo die Nutzung von außen **gewollt und langfristig stabil** sein soll.

Damit andere deinen Code verstehen und richtig verwenden können, solltest du deine API mit **JavaDoc** gut **dokumentieren**:

```java
/**
 * Diese Klasse stellt mathematische Hilfsmethoden bereit.
 */
public class Calculator {
    /**
     * Addiert zwei Zahlen.
     * @param a erste Zahl
     * @param b zweite Zahl
     * @return Summe von a und b
     */
    public static int add(int a, int b) {
        return a + b;
    }
}
```

JavaDoc-Kommentare beginnen mit `/** ... */` und können von Tools wie IntelliJ oder javadoc automatisch in eine
HTML-Dokumentation umgewandelt werden.

{{< ninja tip >}}

Denke daran:

private, (default) und protected sind nicht Teil der öffentlichen API.

Nur public definiert, was andere Packages direkt nutzen können.

Überlege gut, bevor du etwas public machst, denn jede API-Änderung kann externe Nutzer deines Codes betreffen.

{{< /ninja >}}

## Was bedeutet `static`?

Vielleicht hast du bereits `public static void main(String[] args)` gesehen.

`static` bedeutet:

- Diese Methode oder Variable gehört **nicht zu einem Objekt**, sondern direkt zur Klasse.
- Du kannst sie verwenden, **ohne zuerst etwas zu erzeugen**.

Das ist praktisch für Hilfsmethoden, z. B. `Math.max(5, 10)` oder `System.out.println(...)`.

In Grundlagenprojekten verwendest du fast nur `static` Methoden. Die Objekt Orientiert Programmier Welt (OOP-Welt) kommt
später.

{{< ninja info >}}
Klassen, die nur `static`-Methoden enthalten, nennt man **Utility-Klassen** oder **Helper-Klassen**. Damit programmiert
man eher **modular** und weniger **objektorientiert**.

Der Begriff _Modul_ ist in Java jedoch offiziell vergeben: Ab Java 9 steht er für ein Set von Packages mit eigener
`module-info.java`.

Daher spricht man bei dieser Art der modularen Strukturierung besser von _Utility-Klassen_ und nicht von _Modulen_.
{{< /ninja >}}

---

{{< aufgaben "[](../../../../labs/02_java/03_java-grundlagen/12_packages//)" >}}
