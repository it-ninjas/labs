---
title: "Special Typescript Operators"
type: docs
linkTitle: "Special Typescript Operators"
weight: 2
date: 2023-05-19
description: >
  Modul #F5 - TypeScript - Special Operators
---
## Ziele
* Du kennst, die wichtigen special Operators in Angular und kannst diese anwenden.

## Special Operators
Viele der wichtigen Operatoren wurden bereits beim JavaScript behandelt, diese können auch in TypeScript verwendet 
werden. Die Operatoren können [hier](../../javascript/06_js_operators) nachgelesen werden.

### ?-Operator
Der `?`-Operator ist der optionale Aufruf-Operator (optional chaining operator). Er ermöglicht den Zugriff auf Eigenschaften oder Methoden eines Objekts, wenn das Objekt potenziell `null` oder `undefined` sein kann.

Er wird verwendet, um sicherzustellen, dass der Code nicht abbricht und einen Fehler auslöst, wenn eine Eigenschaft oder Methode auf einem möglicherweise `null` oder `undefined` Objekt aufgerufen wird. Wenn das Objekt `null` oder `undefined` ist, gibt er `undefined` zurück, anstatt einen Fehler zu werfen.

```typescript
interface Person {
    name: string;
    age?: number;
    getInfo(): string;
}

const person1: Person = null;
const person2: Person = {
    name: 'Alice',
    getInfo() {
        return `Name: ${this.name}, Age: ${this.age}`;
    },
};

console.log(person1?.name); // undefined
console.log(person2?.name); // 'Alice'

console.log(person1?.getInfo()); // undefined
console.log(person2?.getInfo()); // 'Name: Alice, Age: undefined'
```
> Wichtig der hier gezeigte Operator ist nicht das gleiche wie der [ternary Operator(?:)](../..//javascript/06_js_operators/#ternary-operator-)! Wenn du unsicher bist, lies dir nochmal die Beschreibung des ternary Operators durch. 

### !-Operator
Der `!`-Operator ist ein Non-null-Assertion-Operator. Er wird verwendet, um dem Compiler mitzuteilen und zu garantieren, dass eine Variabel während der Laufzeit nicht `null` oder `undefiniert` ist und somit einen gültigen Wert hat.
 
Dadurch wird der Compiler davon abgehalten, Warnungen oder Fehlermeldungen auszugeben, die normalerweise auftreten würden, wenn eine mögliche Null- oder Undefined-Zuweisung vorliegt.

Es ist wichtig zu beachten, dass der Operator mit Vorsicht verwendet werden sollte. Wenn der Wert tatsächlich `null` oder `undefined` ist und der Operator verwendet wird, tritt zur Laufzeit ein Fehler auf. 

```typescript
function greet(name: string): string {
  return `Hello, ${name!.toUpperCase()}!`;
}

let userName: string = 'Alice';
console.log(greet(userName)); // 'Hello, ALICE!'

userName = null;
console.log(greet(userName)); // Error: Cannot read properties of null (reading 'toUpperCase')
```

