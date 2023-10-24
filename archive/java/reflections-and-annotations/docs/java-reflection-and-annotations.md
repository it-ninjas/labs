---
title: "Annotationen & Reflection API"
linkTitle: "Annotationen & Reflection"
weight: 11
description: >
  Modul #J6 - Annotationen & Reflection API
---

#### Ziele

* Ich kann mit Reflection Informationen zu Klassen, Objekten, Methoden und Attributen zur Laufzeit
  ermitteln
* Ich kenne die Vor- und Nachteile von Reflection
* Ich kenne die Metadaten Class&lt;T&gt;, Field und Method
* Ich kann mit Reflection eine Methode auf einem Objekt aufrufen
* Ich kann mit Reflection zur Laufzeit eine Klasse untersuchen
* Ich kann mit Reflection ein neues Objekt zur Laufzeit erzeugen
* Ich kenne die Grundlagen von Annotationen
* Ich kenne die wichtigsten Standard-Annotationen des JDKs
* Ich kann eigene Annotationen definieren und diese zur Laufzeit auswerten

#### Voraussetzungen

* Fundierte Grundlagenkenntnisse von Java-Anwendungen

## Reflection API

---

### Allgemeine Informationen

Reflection in Java ist eine Möglichkeit, Informationen über Klassen, Methoden und andere
Sprachelemente zu erhalten,
ohne diese Elemente während dem Programmieren (also während der Kompilierzeit) zu kennen.
Mit Reflection können Klassen, Interfaces, Konstruktoren, Methoden und Felder zur Laufzeit
untersucht und auch geändert werden.

Reflection hat die folgenden Einsatzgebiete:

* **Erweiterbarkeit:** Eine Applikation kann mit Reflection solche Klassen instanziieren, die zum
  Zeitpunkt der Kompilierung noch gar nicht bekannt waren. Zur Laufzeit benötigen wir dazu nur den
  voll qualifizierten Namen einer solchen Klasse. Die restlichen Bestandteile der Klasse können zur
  Laufzeit abgefragt werden
* **Class-Browser, Debugger, Tools zum Testen:** Mit Reflection erhält eine Anwendung Zugriff auf
  alle Bestandteile einer Klasse. Reflection kann auch auf private Attribute und Methoden zugreifen
  und hebelt damit das Prinzip der Kapselung aus. Frameworks wie Spring oder jUnit nutzen
  Reflection, um damit ihre Annotationen auswerten zu können.

In der Regel wird Reflection eher selten benutzt da der Prozess der Komponenten-Bewertung,
welcher mit Reflection getriggert wird, die Leistung und die Geschwindigkeit eines Programms
erheblich beeinträchtigt.
Es gibt jedoch Anwendungsfälle, die nur mit Reflection umzusetzen sind.
Beim Einsatz von Reflection gilt also die folgende Regel: _Wenn es eine Lösung ohne Reflection gibt,
dann wähle diese!_

---

### Grundlagen

Reflection nutzt die folgenden Konstrukte, um damit eine Anwendung zu untersuchen.
Diese Konstrukte werden Metadaten bzw. Metainformationen genannt:

* **java.lang.Class&lt;T&gt;**, Metadaten für Klassen. Beinhaltet Klassenname, implementierte
  Interfaces, Methoden und Attribute
* **java.lang.reflect.Field**, Metadaten für Instanzvariablen. Enthält Typ, Name, Sichtbarkeit, usw.
* **java.lang.reflect.Method**, Metadaten für Methoden. Enthält Name, Parameter, Sichtbarkeit, usw.

Damit wir an die Informationen einer Klasse gelangen können, benötigen wir einen Startpunkt.
Dieser Startpunkt ist bei Reflection immer eine Instanz der Klasse java.lang.Class&lt;T&gt;.  
Die anderen Metadaten lassen sich dann über diese Instanz beziehen.
Es gibt drei Möglichkeiten, an diesen Startpunkt zu gelangen:

| #   | Möglichkeit                     | Code-Beispiel                                              | Beschreibung                                                                                                                                                                                                                                      |
|-----|---------------------------------|------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1   | voll-qualifizierter Klassenname | Class&lt;?&gt; clazz = Class.forName("package.ClassName"); | Der Name der gewünschten Klasse wird einfach als String übergeben. Dies ist sehr gut einsetzbar, wenn der konkrete Typ zur Laufzeit noch unbekannt ist. Es ist also beispielsweise möglich Klassennamen aus einer Konfigurationsdatei einzulesen. |
| 2   | Methode getClass()              | Class&lt;?&gt; clazz = object.getClass();                  | Der Aufruf der Methode _getClass()_ auf einer Referenz liefert direkt eine Instanz des Klassenobjekts.                                                                                                                                            |
| 3   | statisches Attribut .class      | Class&lt;?&gt; clazz = ClassName.class;                    | Durch Kenntnis des konkreten Typs erhält man den Zugriff auf das Klassenobjekt mit dem statischen Attribut _class_.                                                                                                                               |

Bei Arrays muss eine eher kryptische Notation verwendet werden. Hier wird aus Komplexitätsgründen
nicht weiter darauf eingegangen.

---

### Methoden aufrufen

Der nächste Schritt ist nun, dass mit Reflection eine Methode aufgerufen werden kann.
Die folgende Reihenfolge gibt einen guten Überblick, welche Schritte dazu notwendig sind:

* Ermitteln der Metainformationen zur Klasse
* Ermitteln der Metainformationen zur Methode
* Aufrufen der Methode
* Exception Handling

**Beispiel**

```java
public class Greeter {
    public String greet(String name) {
        return "Hello " + name;
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        String methodName = "greet";
        Class<?>[] parameterTypes = new Class<?>[]{String.class};
        // Ermitteln der Metainformationen zur Klasse
        Class<?> clazz = Greeter.class;
        try {
            // Ermitteln der Metainformationen zur Methode
            Method greetMethod = clazz.getMethod(methodName, parameterTypes);
            // Methode aufrufen
            String parameter = "Claudio";
            Object result = greetMethod.invoke(new Greeter(), parameter);
            System.out.println(result);
        } catch (NoSuchMethodException e) {
            // handle exception
        } catch (SecurityException e) {
            // handle exception
        } catch (IllegalAccessException e) {
            // handle exception
        } catch (IllegalArgumentException e) {
            // handle exception
        } catch (InvocationTargetException e) {
            // handle exception
        }
    }
}
```

Wie wir sehen gibt es zwei grosse Nachteile beim Einsatz von Reflection:

* **Viel Code:** Vor Java 7 benötigt man für einen Methodenaufruf zwischen 40 und 50 Zeilen
  Programmcode.
* **Viel Exception Handling:** Da der Einsatz von Reflection spezielle Berechtigungen erfordert,
  welche je nach Sicherheitseinstellungen nicht immer verfügbar sind, ist die Anzahl mögliche
  Exceptions relativ gross

Seit Java 7 wurden die Nachteile ein wenig entschärft, da sich das Exception Handling deutlich
eleganter gestalten lässt.
Einerseits bietet Java 7 die Möglichkeit zum Multi-Catch (siehe Modul Exception Handling),
andererseits wurden alle Exceptions beim Einsatz von Reflection in der Klasse
_java.lang.ReflectiveOperationException_ zusammengefasst.

Abgekürzt lässt sich das oben gezeigte Beispiel so darstellen:

```java
public class Main {
    public static void main(String[] args) {
        String methodName = "greet";
        Class<?>[] parameterTypes = new Class<?>[]{String.class};

        // Ermitteln der Metainformationen zur Klasse
        Class<?> clazz = Greeter.class;
        try {
            // Ermitteln der Metainformationen zur Methode
            Method greetMethod = clazz.getMethod(methodName, parameterTypes);

            // Methode aufrufen
            String parameter = "Claudio";
            Object result = greetMethod.invoke(new Greeter(), parameter);
            System.out.println(result);
        } catch (ReflectiveOperationException e) {
            // handle exception
        }
    }
}
```

---

### Zugriff auf Methoden und Attribute

Sobald wir ein Klassenobjekt ermittelt haben können wir auf weitere Metadaten zugreifen.
Spannend ist, dass wir so nicht nur auf Methoden und Attribute, sondern auch auf Annotationen
zugreifen können.

Im Beispiel oben wurde auf eine Methode zugegriffen. Dieser Zugriff besitzt die Einschränkung, dass
nur öffentlich zugängliche Methoden ermittelt werden können. Damit wir auch Zugriff auf nicht
öffentlich sichtbare Bestandteile erhalten, ist etwas mehr Aufwand notwendig. Um alle definierten
Methoden einer Klasse unabhängig von der Sichtbarkeit aufzulisten, können wir die Methode _
getDeclaredMethod(Class&lt;?&gt;)_ verwenden.

Mit einer Rekursion können wir sicherstellen, dass wir auch Methoden, welche aus der Super-Klasse
stammen, finden:

```java
public static Method findMethod(Class<?> clazz,String methodName,Class<?>...parameterTypes){
    Objects.requireNonNull(methodName,"Methodenname darf nicht null sein");
    Objects.requireNonNull(parameterTypes,"Parameter dürfen nicht null sein");
    if(clazz==null){
        return null;
    }
    try{
        return clazz.getDeclaredMethod(methodName,parameterTypes);
    }catch(NoSuchMethodException e){
        // Rekursiver Aufruf um die Methode in der Super-Klasse zu suchen
        return findMethod(clazz.getSuperclass(),methodName,parameterTypes);
    }
}
```

Die Methode _getField(String)_ liefert für den Namen eines Attributs das entsprechende Field-Objekt
zurück. Mit der Methode _getDeclaredField(String)_ erhält man auch nicht öffentliche Attribute einer
Klasse.

---

### Eigenschaften ermitteln

Für Objekte des Typs _Method_ und _Field_ lassen sich mit der Methode _getModifiers()_ verschiedene
Eigenschaften in Form einer Zahl abfragen. Die Auswertung kann dann mit der Hilfsklasse
_java.lang.reflect.Modifier_ erfolgen.

Mögliche Abfragen sind beispielsweise:

* _isPublic(int)_, _isProtected(int)_ und _isPrivate(int)_
* _isStatic(int)_, _isFinal(int)_ und _isAbstract(int)_
* _isSynchronized(int)_ und _isVolatile(int)_

**Beispiel**

```java
Method greetMethod = clazz.getMethod(methodName,parameterTypes);
int modifiers = greetMethod.getModifiers();
boolean isPublic = Modifier.isPublic(modifiers);
```

---

### Spezialfall Konstruktoren

Der Aufruf eines Konstruktors per Reflection ist mit der Methode _newInstance()_ möglich.
Dies gilt nur für den Default-Konstruktor ohne Parameter.
Der Aufruf eines Konstruktors mit Parameter erfordert zuerst einen Methodenaufruf von
_getDeclaredConstructor(Class&lt;?&gt;...)_.
So erhalten wir den Konstruktor mit passender Signatur als Constructor-Objekt.
Auf diesem Objekt kann anschliessend der Methodenaufruf _newInstance(Object...)_ mit den korrekten
Parametern erfolgen.

---

## Annotationen

---

### Einführung

Eine Annotation ist ein Java-Sprachelement, welches die Einbindung von Metadaten in den Quelltext
erlaubt.
Eine Annotation beginnt immer mit einem @-Zeichen und wird vor das entsprechende Element
geschrieben, das annotiert werden soll. Optional kann eine, in runden Klammern eingefasste,
kommagetrennte Parameterliste folgen.

Die Einsatzgebiete sind wie folgt:

* **Compiler-Informationen:** Bereitstellung von Informationen an den Compiler wie beispielsweise
  mit
  der Annotation @Override
* **Informationen für Tools:** Diverse Annotationen, darunter auch selber geschriebene, können von
  speziellen Tools ausgewertet werden. Diese Tools nennt man Annotation-Processor. Ein solcher
  Annotation-Processor besitzt immer die Basisklasse _javax.annotation.processing.AbstractProcessor_.
  Schwergewichtige Frameworks wie beispielsweise Spring basieren in ihrer Funktionalität zu grossen
  Teilen auf Annotationen und deren Auswertung
* **Informationsbereitstellung zur Laufzeit:** Annotationen und deren Parameter können zur Laufzeit
  über Reflection ausgelesen und auch ausgewertet werden

Nicht alle Annotationen sind für jeden der oben genannten Anwendungsfälle geeignet. Der Grund dafür
sind die verschiedenen Lebensdauern von Annotationen. Abhängig von der Definition verwirft oder
überträgt der Java-Compiler Annotationen in das Kompilat oder nicht.

---

### Standard-Annotationen des JDKs

Die folgenden Annotationen werden durch das JDK zur Verfügung gestellt.
Bisher haben wir sie vielleicht bereits verwendet, nun wollen wir aber ihren Zweck nochmals genauer
anschauen.

#### @Deprecated

Zweck:

* Anzeige, dass ein markiertes Element veraltet ist und nicht mehr verwendet werden sollte
* Wird ein solches Element verwendet, so beschwert sich der Compiler mit einer Warnung
* Als zusätzliche Angabe sollte @deprecated im JavaDoc verwendet werden.

Möglich auf:

* Klassen
* Felder (=Instanzvariablen)
* Methoden
* Parameter
* Konstruktoren
* Lokale Variablen
* Packages

Beispiel:

```java
/**
 * @deprecated Diese Methode führt zu Problemen und sollte nicht mehr verwendet werden. 
 * Bitte stattdessen {@link #newMethod(int someValue)} benutzen.
 */
@Deprecated
public void oldMethod(int someValue){
    // ...
}
```

#### @Override

Zweck:

* Zeigt an, dass die annotierte Methode eine gleichnamige Methode einer Basisklasse überschreibt
  bzw. ein Interface implementiert
* Die Anwendung erscheint meistens nicht sehr sinnvoll, trotzdem hat diese Annotation ihre
  Berechtigung. Durch die Angabe dieser Annotation gleicht der Compiler die Signatur einer Methode
  mit derjenigen einer Basisklasse ab und warnt, wenn keine Überschreibung vorliegt
* Auf diese Weise kann man sehr schnell Fehler finden, falls man sich beim Methodennamen vertippt

Möglich auf:

* Methoden

Beispiel:

```java
@Override
public void overridingMethod(int someValue){
    // ...
}
```

#### @SuppressWarnings

Zweck:

* Erlaubt die Unterdrückung von Compiler-Warnungen
* Der zu unterdrückende Typ wird als Parameter an die Annotation übergeben
* Damit wir keine Fehler "verstecken" sollten wir diese Annotation nur sparsam einsetzen
* Die folgenden vordefinierten Parameterwerte sind wichtig, sie unterdrücken die genannten
  Compiler-Warnungen:
  * boxing, für Typumwandlungen mit Auto-Boxing und Auto-Unboxing
  * deprecation, für die Verwendung von veralteten Implementationen
  * unused, für die Verwendung von unbenutzten Variablen und/oder Methoden
  * unchecked, für problematische Zugriffe wo der Compiler keine Typsicherheit garantieren kann.
    Dies ist vor allem beim kombinierten Einsatz von generischen Datentypen und untypisierten
    Klassen der Fall

Möglich auf:

* Klassen
* Felder (=Instanzvariablen)
* Methoden
* Parameter
* Konstruktoren
* Lokale Variablen

Beispiel:

```java
public class WarningSuppresser {
    
    @SuppressWarnings("unchecked")
    public static void main(String[]args){

        @SuppressWarnings(value = {"unchecked", "deprecation"})
        final List<Person> persons = getPersons();
    
        for(final Person person:persons) {
            // ...
        }
    }

    @Deprecated
    public static List getPersons(){
        return new ArrayList();
    }
}
```

In diesem Beispiel geht es wirklich nur darum, den Einsatz der Annotation zu zeigen. Das Beispiel
zeigt generell eher schlechten Code, im Realfall würden wir die Methode _getPersons()_ einfach
überarbeiten, anstatt die Warnungen zu unterdrücken :-)

---

### Definition eigener Annotationen

Annotationen werden in eigenen Dateien analog zu Klassen und Interfaces definiert.
Statt des Schlüsselworts _class_ resp. _interface_ wird hier _@interface_ verwendet.
Das sorgt automatisch dafür, dass die Annotation den Basistyp _Annotation_ aus dem Package
_java.lang.annotation_ besitzt.

Die Definition einer eigenen Annotation schauen wir nun anhand eines Beispiels genauer an.
Wir erstellen eine Annotation für die Klassendokumentation.

Wir definieren nun zuerst eine eigene Annotation, diese soll zur Laufzeit für Typen
(Klassen, Interfaces, Enumeratoren) zur Verfügung stehen.

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Meta-Annotationen
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
// Annotation-Definition
public @interface Documentation {
    // Methode zur Übergabe von Informationen durch Parameter
    String id();
    String name() default "";
    String functionality();
}
```

Das ist dann auch schon alles zur Definition einer eigenen Annotation. Bevor wir weitermachen folgt
hier eine kurze Information zu den einzelnen Elementen:

| Element    | Beschreibung                                                                                                                                                                             |
|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| @Retention | Festlegung zu welchem Zeitpunkt die Annotation später verfügbar sein soll. Hier wurde mit RetentionPolicy.RUNTIME die Verfügbarkeit zur Laufzeit gewählt.                                |
| @Target    | Festlegung wo diese Annotation später im Sourcecode angewendet werden darf. Wir wollen damit Klassen, Interfaces oder auch Enums markieren und wählen aus diesem Grund ElementType.TYPE. |
| default    | Angabe eines Default-Wertes für den entsprechenden Parameter, solche Parameter werden automatisch optional.                                                                              |

Der grössere Aufwand entsteht nun erst, wenn wir diese Annotation zur Laufzeit auslesen möchten.

---

### Eigene Annotationen zur Laufzeit auslesen

Die Definition der Annotation ist nun bekannt. Wir betrachten diese nun im Einsatz und nehmen als
Beispiel eine weitere Klasse, dort soll die Annotation nun zum Einsatz kommen:

#### Ohne Annotation

```java
/**
 * This is the request for a job
 *
 * @author u210148 Claudio Zesiger
 */
@Data
public class JobRequest {
    private String id;
    private String title;
    private String code;
    private String creator;
    private LocalDateTime creationDate;
}
```

#### Mit Annotation

```java

@Documentation(id = "u210148", name = "Claudio Zesiger", functionality = "This is the request for a job")
@Data
public class JobRequest {
    private String id;
    private String title;
    private String code;
    private String creator;
    private LocalDateTime creationDate;
}
```

#### Auswertung

Die Auswertung unserer Annotation zur Laufzeit ist beispielsweise wie folgt möglich:

```java
public class AnnotationTester {
    public static void main(String[]args){
        Documentation documentation=JobRequest.class.getAnnotation(Documentation.class);
        System.out.println(JobRequest.class.getName());
        System.out.println(documentation.id());
        System.out.println(documentation.name());
        System.out.println(documentation.functionality());
    }
}
```

Durch eine solche Auswertung liesse sich beispielsweise eine automatische Dokumentation generieren.
