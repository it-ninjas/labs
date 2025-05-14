---
title: "Lombok"
linkTitle: "Lombok"
weight: 6
description: >
  Module #J3 - Vor- und Nachteile von Lombok
---

Lombok ist ein Java-Library, welche die Entwicklung von Java-Anwendungen erleichtert, indem sie die Erstellung von Standardcode reduziert, insbesondere für Getter, Setter, Konstruktoren und andere repetitive Teile des Codes.
Es automatisiert die Erstellung dieser Boilerplate-Code-Teile (\*) und verbessert somit die Lesbarkeit und Wartbarkeit des Codes.

**(\*) Info:**
Boilerplate-Code ist wiederkehrender Code, der in verschiedenen Teilen einer Softwareanwendung benötigt wird, aber wenig zur eigentlichen Funktionalität beiträgt.

### Wofür wird Lombok verwendet?

1. **Reduzierung des Boilerplate-Codes:**
   Lombok eliminiert die Notwendigkeit, viele standardmässige Java-Boilerplate-Codezeilen wie Getter, Setter, Konstruktoren und toString-Methoden manuell zu schreiben.

2. **Verbesserte Lesbarkeit:**
   Durch die Reduzierung von Boilerplate-Code wird der Quellcode klarer und lesbarer, da unnötige Details ausgeblendet werden.

3. **Kompakte Klassen:**
   Lombok ermöglicht es, Klassen mit weniger Code zu erstellen, was die Wartung und das Verständnis des Codes erleichtert.

Einige häufig verwendete Annotationen sind `@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, usw.

In folgendem Beispiel werden Getter und Setter automatisch von Lombok generiert, sobald die Annotationen `@Getter` und `@Setter` über den Klassenattributen `firstname` und `lastname` verwendet werden. Jedoch für `age` werden sie nicht generiert.

```java
import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter
    @Setter
    private String firstname;

    @Getter
    @Setter
    private String lastname;

    private int age;
}
```

Wenn es jedoch alle Klassenattribute betrifft, muss man nicht über jedem Klassenattribut die Annotationen hinzufügen, sondern man kann es auch folgendermassen schreiben.

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String firstname;

    private String lastname;

    private int age;
}
```

`@NoArgsConstructor`: Diese Annotation wird verwendet, um einen parameterlosen Konstruktor automatisch zu generieren. Sie ist besonders nützlich, wenn Klassen benötigt werden, welche von Frameworks instanziiert werden müssen.

```java
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Person {
    private String name;
    private int age;
}
```

`@AllArgsConstructor`: Diese Annotation wird verwendet, um einen Konstruktor automatisch zu generieren, der alle Felder der Klasse als Parameter akzeptiert. Dieser Konstruktor ist besonders nützlich, wenn eine Klasse erstellt werden soll, bei welcher man den gesamten Zustand über den Konstruktor initialisieren möchte.

```java
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Person {
    private String name;
    private int age;
}
```

### Maven Dependency

Im POM.xml muss folgende Dependency hinzugefügt werden.

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.34</version>
</dependency>
```

### Vorteile von Lombok

1. **Kompaktheit:**
   Lombok reduziert die Menge an Code, welcher geschrieben werden muss, um Getter und Setter etc. zu implementieren. Dadurch wird der Quellcode kompakter und einfacher zu lesen.

2. **Zeitersparnis:**
   Lombok automatisiert die Generierung von Boilerplate-Code, was Entwicklern Zeit spart, die sie sonst mit dem manuellen Schreiben dieser Methoden verbringen würden.

3. **Wartbarkeit:**
   Durch die Reduzierung von Boilerplate-Code minimiert Lombok die Möglichkeit von Fehlern und erleichtert die Wartung des Codes.

### Nachteile von Lombok

1. **Transparenz:**
   Für Entwickler, die nicht mit Lombok vertraut sind, kann der automatisch generierte Code möglicherweise undurchsichtig sein, da er nicht explizit im Quellcode angezeigt wird.

2. **Abhängigkeit:**
   Die Verwendung von Lombok bedeutet, dass ein Projekt von der Lombok-Library abhängig ist. Wenn man Library-Dependencies minimieren möchten, kann dies als Nachteil angesehen werden.

3. **Weniger Kontrolle:**
   Bei der Verwendung von Lombok hat man möglicherweise weniger Kontrolle über den generierten Code im Vergleich zur manuellen Implementierung.

### Lombok mit IntelliJ

Falls du in IntelliJ Probleme mit Lombok hast, kann es sein, dass das Annotation-Processing abgestellt ist. Helfen kann der der folgende Artikel: [Baeldung: Setting up Lombok with Eclipse and Intellij](https://www.baeldung.com/lombok-ide).

---

![hint1](/images/hint.png) Optional: Finde mehr Informationen zu Lombok und was es kann unter: [Lombok Features](https://projectlombok.org/features/)

---

{{% alert title="Git ready?!" color="warning" %}}

Falls du dich noch nicht intensiver mit Git auseinandergesetzt hast, ist jetzt die Zeit dafür: Erarbeite [**Git**](../../04_git)!

Bitte kehre nach Abschluss des Git-Moduls hierhin zurück und fahre mit der nächsten Seite fort.
{{% /alert %}}
