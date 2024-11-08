---
title: "Spring Boot Testing"
linkTitle: "Spring Boot Testing"
weight: 15
description: >
  Modul #J11 - Spring Boot Testing
---

In diesem Kapitel lernst du verschiedene Testarten kennen, um eine Spring Boot Applikation auf Herz und Nieren zu prüfen.

#### Ziele

- Ich kenne die verschiedenen Testarten, um Spring Boot Applikationen zu testen und weiss, bei welchen Testszenarien diese anzuwenden sind.
- Ich kann verschiedene Testarten anwenden und Testfälle dazu schreiben.
- Ich kann Tests selektiv aktivieren/deaktivieren.

---

## Das Demo-Projekt und sein Setup

Damit du den folgenden Erklärungen einfacher folgen und laufenden Code untersuchen kannst, klone bitte das
folgende GitHub-Repo und öffne das Projekt in deiner IDE (Branch: master): https://github.com/it-ninjas/springboottesting/tree/master

Das Repo beinhaltet eine laufende Spring Boot Applikation (wen wundert's ;-)), die Personen verwaltet. Via REST-Schnittstelle können
neue Personen erstellt werden (_createPerson_) und es gibt die Möglichkeit, alle Personen abzufragen (_getAllPersons_).
Damit du möglichst einfach Requests machen kannst, ist ein SwaggerUI vorhanden: [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)

<a id="podman-setup">**Datenbank**</a>: Die Applikation benötigt eine laufende JDBC Verbindung auf eine Maria-DB mit Namen 'testDB'.
Die weiteren Verbindungs-Informationen entnimmst du _/src/main/resources/application.properties_.

<details>
  <summary>Datenbank Setup</summary>
  Du kannst entweder eine bestehende Datenbank verwenden oder dann mittels Docker/Podman einen Maria-DB Container hochfahren:

1. Bestelle/Aktiviere dir die temporären Adminrechte. Als Grund kannst du die Installation von Podman angeben.
2. Führe die Podman-Installation gemäss [https://github.com/containers/podman/blob/main/docs/tutorials/podman-for-windows.md](https://github.com/containers/podman/blob/main/docs/tutorials/podman-for-windows.md#installing-podman) durch.
   Hier ist die Anleitung für Windows verlinkt. Du musst nur das Kapitel Installing Podman durchführen.
   - Falls du eine Fehlermeldung im Sinne von "WSL 2 erfordert ein Update der Kernelkomponente." erhältst, folge diesem Link: https://aka.ms/wsl2kernel und führe mindestens die Schritte 4 und 5 aus. Anschliessend führst du in der Kommando-Zeile `podman machine init` aus.
3. Öffne die Kommando-Zeile (cmd, powershell, etc.).
4. Podman starten (muss nach jedem Neustart des Geräts gemacht werden): `podman machine start`
5. Maria-DB Container erstellen und starten:
   1. Wechsle ins Projektverzeichnis und erstelle einen Ordner 'maria-db': `mkdir maria-db`
   2. Starte den Container unter dem Namen _mdb_: `podman run -d --name=mdb -p 3306:3306 -e MYSQL_USER=admin -e MYSQL_PASSWORD=saysoyeah -e MYSQL_ROOT_PASSWORD=SQLp4ss -e MYSQL_DATABASE=testDB -v ./maria-db:/var/lib/mysql docker.io/mariadb:latest`
      - Wenn du bereits eine Maria-DB auf Port 3306 am Laufen hast, musst du diese stoppen oder hier einen anderen Port verwenden: Ändere die erste Zahl 3306 auf einen neuen Port und anschliessend musst du auch die beiden application.properties Dateien anpassen.
   3. Prüfe, ob der Container läuft mittels: `podman ps -a`
   4. Ab jetzt kannst du den Container mittels `podman stop mdb` und `podman start mdb` stoppen und starten.
   </details>

Die Applikation ist minimalistisch aber mit den wichtigsten Spring-Boot-Layers aufgebaut:

![Applikations-Aufbau](../spring-boot-testing/application-structure.png)

- Wir haben 1 Entity: `Person`
- Das `PersonRepo` basiert auf `JpaRepository` und definiert keine zusätzlichen Methoden.
- Auch der `PersonService` ist sehr kompliziert :-). Wichtig ist aber, dass er die `@Component` `MyUtilityBean` verwendet.
  So haben wir auch noch eine Utility-Bean, die wir beim Testen berücksichtigen können.
- Der `PersonController` bietet zwei REST API Methoden an: _/persons_ (liefert alle Personen) und _/createPerson_ (so kannst du eine neue Person anlegen).

Der `PersonController` verwendet den `PersonService`, welcher auf das `PersonRepo` zugreift, das die `Person`-Entity nutzt.
Das Zwiebelprinzip in Reinkultur ;-).

![tipParallel](/images/hint.png) Während du die Doku hier liest, schaust du dir parallel dazu die erwähnten Code-Stellen an,
lässt die beschriebenen Tests laufen und versuchst so, die Erkärungen nachzuvollziehen.

## Testarten und Best Practices

Wir wollen alle Layers (von der Entity bis zum Controller) testen. Dazu gibt es verschiedene Möglichkeiten und Best-Practices.

Natürlich kannst du jeden Layer mit JUnit/Mockito testen. Das hast du ja bereits [früher gelernt](../../java-testing).
Dazu nimmst du deine Unit-Under-Test (UUT) und mockst alles, was "darunter" liegt. Je nachdem kann das aber ganz schön mühsam
sein resp. praktisch nicht möglich: Stell dir vor, du willst ein Repo mit Mockito testen. Wie kommst du
da an die automatisch durch den Spring-Container generierten Methoden (z.B. _findAll()_)? Gar nicht.

Deshalb gibt es Möglichkeiten, je nach Anwendungsfall den Spring Application-Context teilweise oder ganz hochzufahren.
Wollen wir nur den Daten-Teil (Entity und Repo) hochfahren ist das ein `@DataJpaTest`.
Hier werden keine Services und auch keine Controller instanziiert.

Wollen wir nur den Controller-Teil (inkl. Security, Filter, Converter) hochfahren, ist das ein `@WebMvcTest`.
Es werden keine Services, keine Repos und keine Entities instanziiert.

Bei `@DataJpaTest` und `@WebMvcTest` sprechen wir von sogenannten **Slice-Tests**, weil wir nur einen Teil-Bereich (intergrations-)testen.

Natürlich können wir auch den ganzen Spring Application Context hochfahren. Dann verwenden wir `@SpringBootTest`.

Für Services gibt es keine spezielle Slice-Test-Annotation resp. Umgebung. Da nehmen wir entweder Mockito oder dann @SpringBootTest.

> @DataJpaTest, @WebMvcTest und @SpringBootTest fahren den Application-Context (oder zumindest Teile davon) hoch.
> Das ist langsamer bei der Ausführung, als pure Unit-Tests. Wir werden daher später lernen, nur gewisse Tests zu starten.

![tipIntegrationTest](/images/hint.png) Bei @DataJpaTest, @WebMvcTest und @SpringBootTest kann man von 'Integration-Tests' sprechen,
weil verschiedene Komponenten im Zusammenspiel untersucht werden. Wir könnten nun mit Maven
das [Failsave](https://maven.apache.org/surefire/maven-failsafe-plugin/) Plugin verwenden, das für Integrations-Tests verwendet wird. Das Failsave-Plugin springt in der Maven Phase 'integraton-test' an,
also nach der Unit-Test-Phase 'test'. Es funktioniert anders als Unit-Tests. Um die Komplexität zu reduzieren,
fahren wir in diesem Projekt aber alle Tests als Unit-Tests (Maven Phase 'test').

Hier nochmals in der Übersicht, welche Testarten sich für welchen Layer eignen:
| Layer | Testart(en) | Begründung |
| ----------- | ----------- | ----------- |
| Entity/Repo | `@DataJpaTest` | Wir wollen Queries bis auf die DB "runter" testen. Es gibt viel DB-Interaktion, nicht aber Logik. |
| Service | Mockito und `@SpringBootTest` | Services beinhalten die Logik, daher mit Mockito. Services verbinden Repo und Controller, daher @SpringBootTest. |
| Controller | `@WebMvcTest` | Es geht primär darum, Anfragen entgegenzunehmen und zurückzugeben, also Eingabe- und Ausgabe-Formate zu testen. Security etc. können ein Thema sein, nicht aber Logik. |
| Utility-Klasse (hier MyUtilityBean) | Mockito | Reine Logik-Tests resp. "tun die Helper-Methoden, was sie sollen?"-Tests. Hinweise: Im Demo-Projekt gibt es keinen Unit-Test für die MyUtilityBean.|

## Tests ausführen, SpringBoot-Tests ignorieren

Du kannst alle Tests mit `mvn clean test` ausführen.

![tippFailingTests](/images/hint.png) Evtl. schlägt der Test `PersonRepoTestContainerDataJpaTest` fehl. Das hat damit zu tun,
dass bei dir Docker/Podman noch nicht installiert ist. Wir schauen das weiter unten im Abschnitt [Testcontainers](#testcontainers) an.

Wie bereits weiter oben erwähnt, sind `@DataJpaTest`-, `@WebMvcTest`- und `@SpringBootTest`-Tests zeitaufwändig bei der Ausführung.
Deshalb wird auf diese Tests manchmal in einem ersten Testlauf auch verzichtet. Dazu gibt es verschiedene
Wege, der einfachste ist aber so:

```
mvn clean test -Dsurefire.excludes=**/*WebMvcTest*,**/*DataJpaTest*,**/*SpringBootTest*
```

Mit `-Dsurefire.excludes=...` kannst du festlegen, welche Unit-Tests ignoriert werden sollen.
Das obige Beispiel bezieht sich auf die Bennenung der Tests im Demo-Projekt: Alle Tests die
_WebMvcTest_ oder _DataJpaTest_ oder _SpringBootTest_ im Klassenamen haben werden so ignoriert.

## Service testen mit Mockito

Nun schauen wir an, wie die einzelnen Layers getestet werden können. Starten wir mit dem `PersonService`!

Hier die UUT:

```java
package com.demo.springboottesting.services;

import com.demo.springboottesting.entities.Person;
import com.demo.springboottesting.repos.PersonRepo;
import com.demo.springboottesting.utilities.MyUtilityBean;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepo repo;

    private final MyUtilityBean myUtilityBean;

    public List<Person> getAllPerson() {
        return repo.findAll();
    }

    public Person createPerson(Person person) {

        myUtilityBean.addPerson(person);

        return repo.save(person);
    }
}
```

Wir schreiben zuerst **Mockito**-Tests. Wie das geht, sollte dir bereits bekannt sein. So sieht unser Testaufbau aus:

![Service-Mockito-Tests](../spring-boot-testing/service-mockito.png)

<details>
  <summary>Damit Mockito funktioniert, verwende die folgende Dependency im pom.xml</summary>

```xml
 <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-test</artifactId>
   <scope>test</scope>
 </dependency>
```

</details>

```java
package com.demo.springboottesting.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.demo.springboottesting.entities.Person;
import com.demo.springboottesting.repos.PersonRepo;
import com.demo.springboottesting.utilities.MyUtilityBean;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepo personRepo;

    @Spy
    private MyUtilityBean myUtilityBean;

    @InjectMocks
    private PersonService personService;

    @Test
    void getAllPerson() {
        //Given
        Person person = new Person(1, "Ahnis", "Gotham");
        Person person2 = new Person(2, "Saksham", "New york");
        given(personRepo.findAll())
            .willReturn(List.of(person, person2));

        //When
        var personList = personService.getAllPerson();
        //Then
        assertThat(personList).hasSize(2);
    }

    @Test
    void createPersons() {
        //Given
        Person person = new Person(1, "Ahnis", "Gotham");
        Person person2 = new Person(2, "Saksham", "New york");
        given(personRepo.save(any()))
            .willReturn(any());

        //When
        personService.createPerson(person);
        personService.createPerson(person2);

        //Then
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        verify(myUtilityBean, times(2)).addPerson(personCaptor.capture());
        assertThat(personCaptor.getAllValues().get(0)).isEqualTo(person);

    }
}
```

Wichtige Punkte zum Test:

- Das `PersonRepo` wird gemockt.
- `createPerson()`:
  - Die `MyUtilityBean` wird gespied, ob sie 2x aufgerufen wird und gleichzeitig wird gecaptured, ob die Bean auch die korrekten Person-Objekte übergeben bekommt.

## Service mit @SpringBootTest testen

Wir testen erneut den `PersonService`, jetzt aber mit dem kompletten Application-Context. Auf Mocks
verzichten wir. Es gibt keine spezielle Annotation für Slice-Tests mit Services. Deshalb fahren wir den gesamten
Application-Context hoch:

![Service-SpringBootTest-Tests](../spring-boot-testing/service-springboottest.png)

Wir verwenden eine H2 In-Memory Datenbank.

<details>
  <summary>Verwende die folgenden Dependencies im pom.xml</summary>

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>test</scope>
</dependency>
```

</details>

```java
package com.demo.springboottesting.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.demo.springboottesting.entities.Person;
import com.demo.springboottesting.repos.PersonRepo;
import com.demo.springboottesting.utilities.MyUtilityBean;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class PersonServiceSpringBootTest {

    @Autowired
    private PersonRepo personRepo;

    @SpyBean
    private MyUtilityBean myUtilityBean;

    @Autowired
    private PersonService personService;

    @Test
    @Sql(scripts = {"/data_personservice.sql"})
    @DirtiesContext
    void getAllPerson() {

        //When
        var personList = personService.getAllPerson();

        //Then
        assertThat(personList).hasSize(2);

    }

    @Test
    @DirtiesContext
    void createPersons() {
        //Given
        Person person = new Person(null, "Fritz", "Thun");
        Person person2 = new Person(null, "Alexandra", "Biel/Bienne");

        //When
        personService.createPerson(person);
        personService.createPerson(person2);

        //Then
        assertThat(personRepo.findAll()).hasSize(2);

        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass(Person.class);
        verify(myUtilityBean, times(2)).addPerson(personCaptor.capture());
        assertThat(personCaptor.getAllValues().get(0)).isEqualTo(person);

    }
}
```

Wichtige Punkte zum Test:

- Zur DB-Konfiguration verwenden wir das application.properties aus _/src/**test**/resources_. Dieses wird zuerst verwendet, weil es vorhanden ist.
- Anstelle von `@Spy` (und `@Mock`) wird `@SpyBean` (und `@MockBean`) verwendet. Du kannst jedoch dieselben Assertions und Verifys verwenden.
- Für den Test `getAllPersons()` verwenden wir ein spezifisches `@Sql` Script _data_personservice.sql_.
- Die Annotation `@DirtiesContext` bewirkt, dass nach dem Test die DB zurückgesetzt wird. Andernfalls hätten wir noch die Daten aus dem vorherigen Test in der DB.
- Im Test `createPersons()` verwenden wir einen ArgumentCaptor auf der `myUtilityBean` und zählen, ob auf ihr 2x die Methode `addPerson()` aufgerufen wird und ob die erste Person auch unseren Testdaten entspricht.
- WebEnvironment deaktivieren: Falls du verhindern möchtest, dass das WebEnvironment (u.a. Controller) hochgefahren wird, kannst du die Annoation `@SpringBootTest` erweitern um `@SpringBootTest(webEnvironment = WebEnvironment.NONE)`. In diesem Szenario hier wäre das sicher sinnvoll, da wir den Controller sowieso nicht verwenden. Also los, ändere die Annotation!

## Controller mit @WebMvcTest testen

Nun testen wir den `PersonController`. Dazu fahren wir einen Slice-Test mit `@WebMvcTest`. Es werden weder Services, noch Repos, noch Entities hochgefahren.
Deshalb mocken wir den `PersonService`:

![Controller-WebMvcTest-Tests](../spring-boot-testing/controller-webmvctest.png)

<details>
  <summary>Verwende die folgenden Dependencies im pom.xml</summary>

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-test</artifactId>
  <scope>test</scope>
</dependency>
```

</details>

Hier die UUT:

```java
package com.demo.springboottesting.controllers;

import com.demo.springboottesting.entities.Person;
import com.demo.springboottesting.services.PersonService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping("/createPerson")
    public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {
        return ResponseEntity.ok(personService.createPerson(person));
    }
}
```

Und hier die Test-Klasse:

```java
package com.demo.springboottesting.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.demo.springboottesting.entities.Person;
import com.demo.springboottesting.services.PersonService;
import java.util.List;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class PersonControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired 
    private ObjectMapper objectMapper;

    @MockBean
    private PersonService personService;

    @Test
    void getAllPersons() throws Exception {
        //given
        Person person = new Person(1, "Ahnis", "Gotham");
        Person person2 = new Person(2, "Saksham", "New york");

        when(personService.getAllPerson()).thenReturn(List.of(person, person2));

        //when
        mockMvc.perform(get("/persons"))
        //then
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(StringContains.containsString("Ahnis")))
            .andExpect(content().string(StringContains.containsString("Saksham")))
        ;
    }

    @Test
    void createPerson() throws Exception {
        //given
        when(personService.createPerson(any())).thenAnswer(invocationOnMock -> {
            Person p = invocationOnMock.getArgument(0);
            p.setPersonId(1);
            return p;
        });
        Person dto = new Person(1, "Alexandra", "Biel");

        //when
        mockMvc.perform(post("/createPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
        //then
            .andDo(print())
            .andExpect(jsonPath("$.personName").value("Alexandra"))
            .andExpect(jsonPath("$.personCity").value("Biel"))
            .andExpect(jsonPath("$.personId").isNumber());

    }
}
```

Wichtige Punkte zum Test:

- Der `PersonService` wird gemockt.
- Wir verwenden einen `MockMvc`. Damit können wir (REST-)Requests absetzen und die Antworten auswerten.
  - `getAllPersons()` macht einfache String-Überprüfungen.
  - `createPerson()` wertet die JSON-Response detailliert aus. Bei `jsonPath("$.personName")` bezieht sich _$_ auf das zurückgegebene einzelne Objekt. Erwarten wir eine Liste von Objekten kann über den Index auf ein entsprechendes Objekt zugegriffen werden. Wollen wir z.B. auf das 2te Objekt in der Liste zugreifen, verwenden wir _$[1].personName_ .
- (Tipp am Rande: Falls du trotzdem eine DB verwenden würdest: Es gibt kein automatisches Rollback der Daten nach jedem Test.)

## Repo/Entity mit @DataJpaTest testen

Jetzt ist das `PersonRepo` inkl. `Person` (Entität) und DB dran. Wir fahren den Slice-Test mit `@DataJpaTest`.
Es werden nur DB, Entities und Repos initialisert, keine Services, keine Controller:

![Repo-DataJpaTest-Tests](../spring-boot-testing/repo-datajpatest.png)

Auch hier verwenden wir die H2 In-Memory DB.

<details>
  <summary>Verwende die folgenden Dependencies im pom.xml</summary>

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
  <groupId>com.h2database</groupId>
  <artifactId>h2</artifactId>
  <scope>test</scope>
</dependency>
```

</details>

Hier die UUT:

```java
package com.demo.springboottesting.repos;

import com.demo.springboottesting.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo
    extends JpaRepository<Person, Integer> {
}
```

Und hier die Test-Klasse:

```java
package com.demo.springboottesting.repos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.springboottesting.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
class PersonRepoDataJpaTest {

    @Autowired
    private PersonRepo personRepo;

    private Person testPerson;


    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method
        testPerson = new Person(null, "Maria", "Bern");
        personRepo.save(testPerson);
    }

//Not needed, DB is reset after every test run
//    @AfterEach
//    public void tearDown() {
//        // Release test data after each test method
//        personRepo.delete(testPerson);
//    }

    @Test
    void existsById() {

        assertTrue(personRepo.existsById(testPerson.getPersonId()));
    }

    @Test
    void findAll() {

        assertThat(personRepo.findAll()).hasSize(1);
    }

}
```

Wichtige Punkte zum Test:

- Zur DB-Konfiguration verwenden wir das application.properties aus _/src/**test**/resources_. Dieses wird zuerst verwendet, weil es vorhanden ist.
- `@BeforeEach`: vor jedem Test füllen wir die DB mit einer Person ab.
- Nach jedem Test müssen wir die DB **nicht** manuell (oder mit `tearDown()`) resetten oder den Test mit `@DirtiesContext` annotieren. Dies passiert bei `@DataJpaTest` automatisch.
- Falls du möchtest, kannst du die Beans `EntityManager` oder `TestEntityManager` iniziieren lassen, um auf EntityManager-Ebene die Daten zu überprüfen.

## Testcontainers

Mit Testcontainers kannst du beliebige Umsysteme einbinden. Das System basiert auf Docker/Podman-Containern, die
für den Test hochgefahren und initalisiert werden. Der Vorteil ist, dass du für den Test exakt dieselben Umsysteme
wie in der Produktion verwenden kannst. Beispiel: Anstelle einer H2 In-Memory-DB können wir nun eine Maria-DB verwenden,
wie sie auch in der deployten App genutzt wird. Grundsätzlich kannst du alle Container verwenden, die auf https://hub.docker.com/ zur Verfügung gestellt werden oder die du selber erstellt hast.

Damit Testcontainers funktionieren, musst du zuerst Podman/Docker installieren. Falls noch nicht gemacht,
führe die Schritte 1-4 aus im oben beschriebenen [Datenbank Setup](#podman-setup). Nun hast du Podman installiert und gestartet.

Wir testen erneut das `PersonRepo` mit einem `@DataJpaTest`.

<details>
  <summary>Verwende die folgenden Dependencies im pom.xml</summary>

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-testcontainers</artifactId>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.testcontainers</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>1.20.2</version>
  <scope>test</scope>
</dependency>

<dependency>
  <groupId>org.testcontainers</groupId>
  <artifactId>mariadb</artifactId>
  <version>1.20.2</version>
  <scope>test</scope>
</dependency>
```

</details>

```java
package com.demo.springboottesting.repos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.demo.springboottesting.entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@DataJpaTest(showSql = true)
//Optional: We specify to use only our own DB connection settings below.
//If you still want to use DB settings from /src/test/resources/application.properties comment out the following line:
@AutoConfigureTestDatabase( replace = Replace.ANY )
//Set properties for these specific tests:
@TestPropertySource( properties = {"spring.jpa.hibernate.ddl-auto=create-drop"} )
//Tell the testrunner to use testcontainers:
@Testcontainers
class PersonRepoTestContainerDataJpaTest {

    //Create the container with other properties (here related to the base DB-connection):
    @Container
    static MariaDBContainer<?> testContainer = new MariaDBContainer<>( "mariadb:latest" );
    @DynamicPropertySource
    static void properties( DynamicPropertyRegistry registry ) {
        registry.add("spring.datasource.driver-class-name", testContainer::getDriverClassName);
        registry.add( "spring.datasource.url", testContainer::getJdbcUrl );
        registry.add( "spring.datasource.username", testContainer::getUsername );
        registry.add( "spring.datasource.password", testContainer::getPassword );
    }

    @Autowired
    private PersonRepo personRepo;

    private Person testPerson;


    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method
        testPerson = new Person(null, "Maria", "Bern");
        personRepo.save(testPerson);
    }

    @Test
    void existsById() {
        assertTrue(personRepo.existsById(testPerson.getPersonId()));
    }

    @Test
    void findAll() {
        assertThat(personRepo.findAll()).hasSize(1);
    }

}
```

Wichtige Punkte zum Test:

- `@AutoConfigureTestDatabase( replace = Replace.ANY )`: Wir deaktivieren die Konfiguration aus /src/test/resources/application.properties komplett.
- `@TestPropertySource( properties = {"spring.jpa.hibernate.ddl-auto=create-drop"} )`: Wir übergeben für diese Test-Klasse spezifische Properties, d.h. die DB wird komplett gelöscht und das Schema neu erzeugt.
- `@Testcontainers`: Wird benötigt, damit der Test mit Testcontainers überhaupt funktioniert.
- Container erstellen und Config-Daten aus dem gestarteten Container ins application.properties übernehmen:

```java
   @Container
   static MariaDBContainer<?> testContainer = new MariaDBContainer<>( "mariadb:latest" );
   @DynamicPropertySource
   static void properties( DynamicPropertyRegistry registry ) {
       registry.add("spring.datasource.driver-class-name", testContainer::getDriverClassName);
       registry.add( "spring.datasource.url", testContainer::getJdbcUrl );
       registry.add( "spring.datasource.username", testContainer::getUsername );
       registry.add( "spring.datasource.password", testContainer::getPassword );
   }
```

- Wie du siehst, definieren wir an verschiedenen Orten die benötigten Properties. Standard-Properties werden hier über `@DynamicPropertySource` hinzugefügt. Test-spezifische Properties werden über die Klassen-Annotation `@TestPropertySource` gesetzt. Grundsätzlich könntest du aber auch nur mit der DynamicPropertySource arbeiten.

---

![task1](/images/task.png) Jetzt bist du dran. Löse die Aufgaben in [Spring Boot Testing - Aufgaben](../../../../labs/java/spring/02_spring_boot_testing/)!
