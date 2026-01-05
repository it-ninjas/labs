---
title: "List"
linkTitle: "List"
weight: 1
description: >
  Das Interface List.
---

## java.util.List

Listen sind geordnete Collections, denn sie enthalten beliebige Objekte in einer bestimmten Reihenfolge. In Listen
werden eine Menge von Elemente (genauer genommen Referenzen auf Objekte)
abgespeichert, wobei die Menge geordnet ist, da jedes Element an einer bestimmten Position zu finden ist:

![list1](./images/list1.png)

Beachte, dass wir bei den Listen, die Indexierung der Positionen bei 0 beginnt, genauso wie bei dem primitiven Datentyp
Array.

Listen haben eine dynamische Grösse, d.h. die Grösse der Liste muss bei der Erstellung nicht bekannt sein und die Anzahl
der enthaltenen Elemente kann sich während der Laufzeit ändern. Daher ist es möglich, fortlaufend Elemente zur Liste
hinzuzufügen oder aus der Liste zu entfernen. Hierbei entstehen nie Lücken:
Fügt man ein Element an einer bestimmten Position zur Liste hinzu, dann rutschen alle nachfolgenden Elemente eine
Position nach. Entfernt man ein Element an einer bestimmten Position, so rutschen alle nachfolgen Elemente eine Position
nach oben.

Man kann auf Elemente über ihren ganzzahligen Index (Position in der Liste) zugreifen und nach Elementen in der Liste
suchen.

![list2](./images/list2.png)

Ein Element aus einer Liste entfernen:

![list3](./images/list3.png)

Wie zu Beginn erwähnt, enthalten Lists Referenzen auf Objekte. Deshalb ist es nicht möglich, Listen zu erstellen, welche
primitive Datentypen als Elemente enthalten (`int`, `double`, `boolean`, `char`, `...`). Dafür müssen die sogenannten
Wrapper-Klassen verwendet werden. Wrapper-Klassen bieten eine Möglichkeit, primitive Datentypen (int, double, boolean,
char, ...) als Objekte zu verwenden:
java.lang.Integer, java.lang.Double, java.lang.Boolean, java.lang.Character,..

Schauen wir uns die folgenden Beispiele an, wo wir einer Liste mit Elementen vom Typ Integer das Element 3 hinzufügen:

```java
List<Integer> integerList = new ArrayList<>();
integerList.add(Integer.valueOf(3));
```

Oben haben wir der Liste das Integer-Objekt 3 hinzugefügt - also ein `Integer`-Objekt und nicht der Wert des primitiven Datentyps `int`.

```java
List<Integer> integerList = new ArrayList<>();
integerList.add(3);
```

Beim unteren Beispiel haben wir der Liste den int-Wert 3 als **primitiven Datentyp** hinzu.
Obwohl wir den int-Wert 3 als primitiver Datentypen und nicht als Integer-Objekte zur Liste
`integerList` hinzufügen, kompiliert dieser Code genau so ohne Fehler.
`integerList` ist jedoch eine Liste von Integer-Objekten und nicht eine Liste von int-Werten.
Warum haben wir dann beim Kompilieren dieses Codes kein gekriegt?

Der Copmpiler konvertiert den int-Wert zu einem Integer-Objekt und fügt dieses dann zur Liste _integerList_ hinzu.
Diese Konvertierung nennt man _Autoboxing_.
_Autoboxing_ ist die automatische Konvertierung zwischen den primitiven Datentypen zu Objekten ihrer entsprechenden Wrapper-Klassen, die der Java Compiler durchführt
(beispielsweise `int` zu `Integer`, `double` zu `Double`, ect.).
Wenn die Konvertierung in die andere Richtung erfolgt, nennt man dies `Unboxing`.

Somit ist es nicht mehr nötig, dass wir dieses Autoboxing wie im ersten Beispiel selber durchführen müssen.

### Einige Methoden vom Interface java.util.List

```java
/*
 * Gibt die Anzahl der Elemente in dieser Liste zurück.
 */
int size();

/*
 * Gibt true zurück, wenn diese Liste keine Elemente enthält.
 */
boolean isEmpty();

/*
 * Gibt true zurück, wenn diese Liste das angegebene Element enthält.
 */
boolean contains(Object o);

/*
 * Gibt das Element an der angegebenen Position in dieser Liste zurück.
 */
E get(int index);

/*
 * Ersetzt das Element an der angegebenen Position in dieser Liste durch das angegebene Element.
 */
E set(int index,E element);

/*
 * Gibt den Index des ersten Auftretens des angegebenen Elements in dieser Liste zurück,
 * oder -1, wenn diese Liste das Element nicht enthält.
 */
int indexOf(Object o);


/*
 * Hängt das angegebene Element an das Ende der Liste an
 */
boolean add(E e);

/*
 * Fügt das angegebene Element an der angegebenen Position in dieser Liste ein.
 * Verschiebt das Element, das sich derzeit an dieser Position befindet (falls vorhanden),
 * und alle nachfolgenden Elemente.
*/
void add(int index,E element);

/*
 * Entfernt das erste Vorkommen des angegebenen Elements aus dieser Liste,
 * sofern es vorhanden ist.  Wenn diese Liste das Element nicht enthält,
 * bleibt sie unverändert.
 */
boolean remove(Object o);

/*
 * Entfernt das Element an der angegebenen Position in dieser Liste.
 */
E remove(int index);

/*
* Entfernt alle Elemente aus dieser Liste.
/*
void clear();

...
```

Das Interface `java.util.List` im Collection Framework ist der Datentyp der Listen, wobei in der abstrakten Klasse
`java.util.AbstractList` die grundlegenden Funktionalitäten implementiert sind, sodass diese den verschiedenen konkreten
Listen-Implementierungen weiter geerbt werden können.

Auf der nächsten Seite geht es mit einer konkreten Umsetzung einer `List` weiter. Nun wird es also praktischer!
