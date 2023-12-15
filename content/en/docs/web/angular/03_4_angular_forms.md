---
title: "Angular Reactive Forms"
type: docs
linkTitle: "Angular Reactive Forms"
weight: 21
date: 2023-04-20
description: >
  In diesem Kapitel wird erklärt wozu das Angular Reactive Forms sind.
---
## Ziele
* Du weisst was Angular Reactive Forms sind.
* Du weisst, wozu FormsControl, -Group und -Array sind und kannst sie anwenden.
* Du weisst, was der FormBuilder ist und kannst ihn anwenden.
* Du kennst, die Validators und kannst sie verwenden und eigene schrieben.

## Angular Reactive Forms
Angular Reactive Forms sind ein leistungsstarkes Feature von Angular, mit dem Entwickler Formulare erstellen, validieren und mit ihnen interagieren können. Im Gegensatz zu Template-driven Forms, bei denen die Formularlogik hauptsächlich im HTML-Template liegt, wird bei Reactive Forms die Formularlogik in den Components selbst geschrieben.

## Doch wieso sollte man Forms verwenden? 
Dies hört sich nun sehr ähnlich an wie `ngModel`, doch wieso sollte man besser Reactive Forms verwenden? Dazu gibt es folgende Gründe:
1. Reactive Forms ermöglichen eine klare Trennung zwischen Datenmodell und View. Man erstellt ein separates FormGroup-Objekt, das die Struktur und Validierung der Formulardaten definiert. Dieses Datenmodell kann unabhängig von dem View-Components existieren und ermöglicht eine bessere Organisation und Wiederverwendbarkeit des Codes.
2. Mit Reactive Forms hat man volle Kontrolle über die Formulare, da man FormControls und FormGroups programmatisch erstellen und manipulieren kann. Man kann dynamisch Formularfelder hinzufügen, entfernen oder ändern, Validierungsregeln anpassen und auf Ereignisse reagieren.
3. Reactive Forms bieten eine umfangreichere Unterstützung für komplexe Validierungsszenarien. Man kann benutzerdefinierte Validatoren erstellen oder viele bereits existierende verwenden.

Insgesamt bietet die Verwendung von Reactive Forms eine flexiblere, leistungsfähigere und besser strukturierte Möglichkeit, Formulare in Angular zu verwalten. Es ermöglicht eine bessere Kontrolle, erweiterte Validierungsoptionen und eine klarere Trennung zwischen Datenmodell und View-Komponente.

## Importieren in Module
Bevor man Reactive Forms verwenden kann muss man die `ReactiveFormsModule` in das Modul, in dem man Reactive Forms verwenden möchte importieren.
```typescript
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [ReactiveFormsModule],
  // ..
})
export class AppModule { }
```

## Forms Control
Ein `FormControl` ein Objekt, das ein einzelnes Formularelement repräsentiert und steuert. Es ermöglicht die Verwaltung des Werts, der Validierung und des Zustands des Formularelements.

Wenn man ein `FormControl` verwenden möchte kann man dieses mittels `new FormControl('')` einer Variable zuweisen. Dadurch ist die Variabel nun das FormControl. Damit man es nun im HTML verwenden kann um es zu Binden muss man bei einem `input`-tag `[formControl]=""` verwenden in die "" kommt dann der Variabelname des FormControls.
```typescript
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormControl = new FormControl('');
    
    // ..
}
```
```html
<div>
    <label for="triumph">Titel: </label>
    <input id=triumph type="text" [formControl]="triumphForm">
    <p>Value: {{ triumphForm.value }}</p>
</div>
```

Man kann dem FormControl auch einen Defaultwert geben, dazu einfach innerhalb der runden Klammern anstelle von einem leeren String den Defaultwert einfügen.
Auch der Value kann man manuel im Typescript verändern mittels der `setValue()` Methode.
```typescript
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormControl = new FormControl('default Title');

    // ..
    
    updateTitle() {
        this.triumphForm.setValue('Triumphs');
    }
}
```
```html
<div>
    <label for="triumph">Titel: </label>
    <input id=triumph type="text" [formControl]="triumphForm">
    <p>Value: {{ triumphForm.value }}</p>
    <button type="button" (click)="updateTitle()">Update Title</button>
</div>
```

Wenn man im Typescript auch direkt auf Änderungen im FormControl subscriben möchte, damit man immer den aktuellen Value des FormControls hat, kann man `valueChanges` benutzen. Somit hat man im Typescript die gleiche aktuelle Value wie im HTML mittels `{{ name.value }}`.
```typescript
import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormControl = new FormControl('default Title');

    constructor() {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value);
        })
    }
    
    // ..
}
```
```html
<div>
    <label for="triumph">Titel: </label>
    <input id=triumph type="text" [formControl]="triumphForm">
    <p>Value: {{ triumphForm.value }}</p>
</div>
```

## Froms Group
Da eine Form normalerweise aus mehr als einem Controls besteht, kann all die FormControls zu einer gruppieren.

Für die FormGroup erstellt man auch eine neue Instanz des `FormGroup` in welcher sich die `FormControl`'s befinden. Die FormGroup wird in einer Variabel gespeichert, die FormControls werden mit eindeutigem Key-Value Prinzip definiert.
Man kann auch hier auf die Group mittels `valueChanges` subscriben, nur das man hier dann nicht einfach den Value des Inputs erhaltet, sondern ein Objekt mit den Controls als Key-Value.
Um eine FormGroup im HTML zu verwenden, sollte man den `form`-tag. In diesem muss man die FormGroup mittels `[formGroup]=""` angeben, auch hier kommt in die "" der Variabelname der FormGroup. Um nun die FormControls anzugeben verwendet man nicht mehr `[formControl]=""`, sondern `formControlName=""`, hier kommt in die "" der Key der FormControl.
```typescript
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormGroup = new FormGroup({
        name: new FormControl(''),
        yearOfAchieving: new FormControl('')
    });

    constructor() {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: ''}
        })
    }
    
    // ..
}
```
```html
<form [formGroup]="triumphForm">
    <label for="name">Title Name: </label>
    <input id="name" type="text" formControlName="name">

    <label for="yearOfAchieving">Year of Achieving: </label>
    <input id="yearOfAchieving" type="number" formControlName="yearOfAchieving">
</form>
<p>Value Title Name: {{ triumphForm.value.name }}</p>
<p>Value Year of Achieving: {{ triumphForm.value.yearOfAchieving }}</p>
```

Es ist auch möglich FormGroup innerhalb einer FormGroup zu verwenden und so das gesamte verschachteln, um komplexe Forms mit hierarchischer Struktur zu erstellen. Dies funktioniert genau gleich hier muss dann einfach die zweite FormGroup auch als Key-Value angegeben werden. 
Die zweite FormGroup muss dann mit `formGroupName=""` angegeben werden und nicht mehr mit `[formGroup]=""`, innerhalb der "" kommt hier dann auch der Key der zweiten FormGroup. Man sollte für die zweite FormGroup dann ein `div`-tag verwenden.

```typescript
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormGroup = new FormGroup({
        name: new FormControl(''),
        yearOfAchieving: new FormControl(''),
        placeOfAchieving: new FormGroup({
            street: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            zip: new FormControl('')
        })
    });

    constructor() {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}}
        })
    }
    
    // ..
}
```
```html
<form [formGroup]="triumphForm">
    <label for="name">Title Name: </label>
    <input id="name" type="text" formControlName="name">

    <label for="yearOfAchieving">Year of Achieving: </label>
    <input id="yearOfAchieving" type="number" formControlName="yearOfAchieving">

    <div formGroupName="placeOfAchieving">
        <h2>Place of Achieving</h2>

        <label for="street">Street: </label>
        <input id="street" type="text" formControlName="street">

        <label for="city">City: </label>
        <input id="city" type="text" formControlName="city">

        <label for="state">State: </label>
        <input id="state" type="text" formControlName="state">

        <label for="zip">Zip Code: </label>
        <input id="zip" type="number" formControlName="zip">
    </div>
</form>
<p>Value Title Name: {{ triumphForm.value.name }}</p>
<p>Value Year of Achieving: {{ triumphForm.value.yearOfAchieving }}</p>
<p>Value Street: {{ triumphForm.value.placeOfAchieving.street }}</p>
<p>Value City: {{ triumphForm.value.placeOfAchieving.city }}</p>
<p>Value State: {{ triumphForm.value.placeOfAchieving.state }}</p>
<p>Value Zip: {{ triumphForm.value.placeOfAchieving.zip }}</p>
```

Wenn man eine so grosse FormGroup hat und nun ein Wert ändern möchte über das Typescript, kann man dies auch mittels `setValue()` tun. Das kann jedoch mühsam sein da man bei dieser Methode alle Values (FormControls) der FormGroup angeben muss. Wenn man aber nur einzelne anpassen möchte, kann man die Methode `patchValue()` verwenden.
Denn diese Methode erlaubt es das man nur einzelne der Values (FormControls) angeben muss.

```typescript
import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormGroup = new FormGroup({
        name: new FormControl(''),
        yearOfAchieving: new FormControl(''),
        placeOfAchieving: new FormGroup({
            street: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            zip: new FormControl('')
        })
    });

    constructor() {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}}
        })
    }

    // ..

    updateTriumph() {
        this.triumphForm.patchValue({
            name: 'Assably',
            placeOfAchieving: {
                street: '123 Down Street'
            }
        });
    }
}
```
```html
<form [formGroup]="triumphForm">
    <label for="name">Title Name: </label>
    <input id="name" type="text" formControlName="name">

    <label for="yearOfAchieving">Year of Achieving: </label>
    <input id="yearOfAchieving" type="number" formControlName="yearOfAchieving">

    <div formGroupName="placeOfAchieving">
        <h2>Place of Achieving</h2>

        <label for="street">Street: </label>
        <input id="street" type="text" formControlName="street">

        <label for="city">City: </label>
        <input id="city" type="text" formControlName="city">

        <label for="state">State: </label>
        <input id="state" type="text" formControlName="state">

        <label for="zip">Zip Code: </label>
        <input id="zip" type="number" formControlName="zip">
    </div>
</form>
<button type="button" (click)="updateTriumph()">Update Triumph</button>
<p>Value Title Name: {{ triumphForm.value.name }}</p>
<p>Value Year of Achieving: {{ triumphForm.value.yearOfAchieving }}</p>
<p>Value Street: {{ triumphForm.value.placeOfAchieving.street }}</p>
<p>Value City: {{ triumphForm.value.placeOfAchieving.city }}</p>
<p>Value State: {{ triumphForm.value.placeOfAchieving.state }}</p>
<p>Value Zip: {{ triumphForm.value.placeOfAchieving.zip }}</p>
```

## Form Array
`FormArray` ist eine Alternative zu `FormGroup`, wird jedoch verwendet, wenn man eine unbestimmte Anzahl von FormControls, FormGroups oder weiteren FormArrays haben möchte. Durch das hat man die Möglichkeit dynamisch Formularelement während der Laufzeit hinzuzufügen oder löschen.
Praktisch ist das man keinen Key für die Formularelemente definieren muss und man nicht weiss wie viele Elemente es am Schluss sein werden.

Um auf das FormArray zugreifen zu können muss man eine `get`-Methode schreiben, diese findet man im folgenden Code.

Wie man Elemente in das FormArray hinzufügt und löscht ist auch im untenstehenden Code zu finden.

Im HTML muss man das FormArray mittels `formArrayName=""` angeben, auch hier kommt innerhalb der "" der Key des FormArrays. Um an die einzelnen Elemente zu gelangen, muss man mittels einem `*ngFor` darüber iterieren. Im folgenden Beispiel wird die ID des Inputs dynamisch mittels des Index des Elements erstellt.

```typescript
import { Component } from '@angular/core';
import { FormGroup, FormControl, FormArray } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm: FormGroup = new FormGroup({
        name: new FormControl(''),
        yearOfAchieving: new FormControl(''),
        placeOfAchieving: new FormGroup({
            street: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            zip: new FormControl('')
        }),
        aliases: new FormArray([
            new FormControl('')
        ])
    });

    constructor() {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}, aliases: Array[]}
        })
    }

    get aliases() {
        return this.triumphForm.get('aliases') as FormArray;
    }

    addAlias() {
        this.aliases.push(new FormControl(''));
    }

    removeAlias(index: number): void {
        this.aliases.removeAt(index);
    }
    
    // ..
}
```
```html
<form [formGroup]="triumphForm">
    <label for="name">Title Name: </label>
    <input id="name" type="text" formControlName="name">

    <label for="yearOfAchieving">Year of Achieving: </label>
    <input id="yearOfAchieving" type="number" formControlName="yearOfAchieving">

    <div formGroupName="placeOfAchieving">
        <h2>Place of Achieving</h2>

        <label for="street">Street: </label>
        <input id="street" type="text" formControlName="street">

        <label for="city">City: </label>
        <input id="city" type="text" formControlName="city">

        <label for="state">State: </label>
        <input id="state" type="text" formControlName="state">

        <label for="zip">Zip Code: </label>
        <input id="zip" type="number" formControlName="zip">
    </div>
    <div formArrayName="aliases">
        <h2>Aliases</h2>
        <div *ngFor="let alias of aliases.controls; let i=index">
            <!-- The repeated alias template -->
            <label for="alias-{{ i }}">Alias:</label>
            <input id="alias-{{ i }}" type="text" [formControlName]="i">
            <button type="button" (click)="removeAlias(i)">- Remove alias</button>
        </div>
        <button type="button" (click)="addAlias()">+ Add another alias</button>
    </div>
</form>
<p>Value Title Name: {{ triumphForm.value.name }}</p>
<p>Value Year of Achieving: {{ triumphForm.value.yearOfAchieving }}</p>
<p>Value Street: {{ triumphForm.value.placeOfAchieving.street }}</p>
<p>Value City: {{ triumphForm.value.placeOfAchieving.city }}</p>
<p>Value State: {{ triumphForm.value.placeOfAchieving.state }}</p>
<p>Value Zip: {{ triumphForm.value.placeOfAchieving.zip }}</p>
```


## Form Builder
Wie man bei der verschachtelten FormGroup gesehen hat, ist zum Teil der Code sehr duplikat. Um dies zu vermeiden, kann man beim Erstellen einer Form einen Hilfsservice namens `FormBuilder` benutzen. Diesen muss man auch importieren und dann im constructor injecten.
Anstelle von `new FormGroup()` schreibt man nun `this.formBuilder.group()`, bei `FormArray` schreibt man mittels FormBuilder noch `this.formBuilder.array()` und bei den Controls kann man jedoch einfach nur das Key-Value Paar angeben.

```typescript
import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..
    
    triumphForm = this.formBuilder.group({
        name: [''],
        yearOfAchieving: [''],
        placeOfAchieving: this.formBuilder.group({
            street: [''],
            city: [''],
            state: [''],
            zip: ['']
        }),
        aliases: this.formBuilder.array([
            this.formBuilder.control('')
        ])
    });

    constructor(private formBuilder: FormBuilder) {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}, aliases: Array[]}
        })
    }
    
    // ..
}
```

## Validators
Es gibt eine Vielzahl von Validators, die man verwenden kann, um die Eingaben der Benutzer zu überprüfen und sicherzustellen, dass sie den gewünschten Anforderungen entsprechen. Die häufigst verwendeten Validators sind:
* `Validators.required`: Dieser Validator stellt sicher, dass das Formularelement einen Wert enthält und nicht leer ist.

* `Validators.minLength(minLength)`: Dieser Validator überprüft, ob der Value des Formularelements eine Mindestlänge hat, die durch den Parameter `minLength` festgelegt wird.

* `Validators.maxLength(maxLength)`: Dieser Validator überprüft, ob der Value des Formularelements eine Maximallänge hat, die durch den Parameter `maxLength` festgelegt wird.

* `Validators.pattern(pattern)`: Dieser Validator überprüft den Value des Formularelements anhand eines regulären Ausdrucks, der durch den Parameter `pattern` definiert wird. Man kann damit bestimmte Muster wie z.B. eine gültige E-Mail-Adresse, Telefonnummer etc. überprüfen. Das `pattern` ist wie ein Regex und kann in diesem Format angegeben werden z:B. `[a-zA-Z0-9]`

* `Validators.email`: Dieser Validator überprüft, ob der Value des Formularelements eine gültige E-Mail-Adresse ist.

* `Validators.min(min)`: Dieser Validator überprüft, ob der Value des Formularelements grösser oder gleich dem angegebenen Minimum `(min)` ist. Dies wird oft für numerische Eingabefelder verwendet.

* `Validators.max(max)`: Dieser Validator überprüft, ob der Value des Formularelements kleiner oder gleich dem angegebenen Maximum `(max)` ist. Auch dies wird häufig für numerische Eingabefelder verwendet.

Es können auch mehrere Validators eingesetzt werden, dazu muss man diese einfach in einem Array angeben.
```typescript
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm = this.formBuilder.group({
        name: [''],
        yearOfAchieving: ['', Validators.required],
        placeOfAchieving: this.formBuilder.group({
            street: ['', Validators.required],
            city: ['', Validators.required],
            state: ['', Validators.required],
            zip: ['', [Validators.required, Validators.minLength(4)]]
        }),
        aliases: this.formBuilder.array([
            this.formBuilder.control('', Validators.required)
        ])
    });

    constructor(private formBuilder: FormBuilder) {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}, aliases: Array[]}
        })
    }

    // ..
}
```


### Custom Validators
Man hat zudem die Möglichkeit, benutzerdefinierte Validators zu erstellen, um spezifische Validierungslogik für Formularelements zu implementieren.

Der Ausdruck `/bob/i` wird verwendet, um nach dem Namen "Bob" im Eingabewert zu suchen, und das "i" am Ende steht für "case insensitive" (Gross- und Kleinschreibung wird ignoriert).

```typescript
export function forbiddenNameValidator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const forbidden = nameRe.test(control.value);
    return forbidden ? {forbiddenName: {value: control.value}} : null;
  };
}
```
```typescript
import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
    // ..
})
export class TriumphsComponent implements AfterViewInit {
    // ..

    triumphForm = this.formBuilder.group({
        name: ['', [Validators.required, forbiddenNameValidator(/bob/i)]],
        yearOfAchieving: ['', Validators.required],
        placeOfAchieving: this.formBuilder.group({
            street: ['', Validators.required],
            city: ['', Validators.required],
            state: ['', Validators.required],
            zip: ['', [Validators.required, Validators.minLength(4)]]
        }),
        aliases: this.formBuilder.array([
            this.formBuilder.control('', Validators.required)
        ])
    });

    constructor(private formBuilder: FormBuilder) {
        this.triumphForm.valueChanges.subscribe((value) => {
            console.log(value); // {name: '', yearOfAchieving: '', placeOfAchieving: {...}, aliases: Array[]}
        })
    }

    // ..
}
```
