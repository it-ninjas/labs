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
folgende GitHub-Repo und öffne das Projekt in deiner IDE: https://github.com/it-ninjas/springboottesting

Das Repo beinhaltet eine laufende Spring Boot Applikation (wen wundert's ;-)), die Personen verwaltet. Via REST-Schnittstelle können
neue Personen erstellt (_createPerson_) werden und es gibt die Möglichkeit, alle Personen abzufragen (_getAllPersons_).
Damit du möglichst einfach Requests machen kannst, ist ein SwaggerUI vorhanden: [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)

**Datenbank**: Die Applikation benötigt eine laufende JDBC Verbindung auf eine Maria-DB mit Namen 'testDB'.
Die weiteren Verbindungs-Informationen entnimmst du _/src/main/resources/application.properties_.

<details>
  <summary>Datenbank Setup</summary>
  Du kannst entweder eine bestehende Datenbank verwenden oder dann mittels Docker/Podman einen Maria-DB Container hochfahren:

1. Bestelle dir die temporären Adminrechte. Als Grund kannst du die Installation von Podman angeben.
2. Führe die Podman-Installation gemäss [https://github.com/containers/podman/blob/main/docs/tutorials/podman-for-windows.md](https://github.com/containers/podman/blob/main/docs/tutorials/podman-for-windows.md) durch.
   Hier ist die Anleitung für Windows verlinkt. Du musst nur das Kapitel Installing Podman durchführen.
3. Öffne die Kommando-Zeile (cmd, powershell, etc.): `>`
4. Podman zum ersten Mal initialisieren (nur 1x nach der Installation, danach nie wieder): `>podman machine init`
5. Podman starten (muss nach jedem Neustart des Geräts gemacht werden): `>podman machine start`
6. Maria-DB Container erstellen und starten:
   1. Wechsle ins Projektverzeichnis und erstelle einen Ordner 'maria-db': `>mkdir maria-db`
   2. Starte den Container unter dem Namen _mdb_: `>podman run -d --name=mdb -p 3306:3306 -e MYSQL_USER=admin -e MYSQL_PASSWORD=saysoyeah -e MYSQL_ROOT_PASSWORD=SQLp4ss -e MYSQL_DATABASE=testDB -v ./maria-db:/var/lib/mysql docker.io/mariadb:latest`
   3. Prüfe, ob der Container läuft mittels: `>podman ps -a`
   4. Ab jetzt kannst du den Container mittels `>podman stop mdb` und `>podman start mdb` stoppen und starten.
   </details>

Die Applikation ist minimalistisch aber mit den wichtigsten Spring-Boot-Layers aufgebaut:

![Applikations-Aufbau](../spring-boot-testing/application-structure.png)

- Wir haben 1 Entity: **Person**
- Das **PersonRepo** basiert auf _JpaRepository_ und definiert keine zusätzlichen Methoden.
- Auch der **PersonService** ist sehr kompliziert :-) Wichtig ist aber, dass er die @Component **MyUtilityBean** verwendet.
  So haben wir auch noch eine Utility-Bean, die wir testen können.
- Der **PersonController** bietet zwei REST API Methoden an: _/persons_ (liefert alle Personen) und _/createPerson_ (so kannst du eine neue Person anlegen).

Der PersonController verwendet den PersonService, welcher das PersonRepo anzieht, das die Person Entity nutzt.
Das Zwiebelprinzip in Reinkultur ;-)

![tipParallel](/images/hint.png) Während du die Doku hier liest, schaust du dir parallel dazu die erwähnten Code-Stellen an,
lässt die beschriebenen Tests laufen und versuchst so, die Erkärungen nachzuvollziehen.

## Testarten und Best Practices

Wir wollen alle Layers (von der Entity bis zum Controller) testen. Dazu gibt es verschiedene Möglichkeiten und Best-Practices.

Natürlich kannst du jeden Layer mit JUnit/Mockito testen. Das hast du ja bereits [früher gelernt](../../java-testing).
Dazu nimmst du deine Unit-Under-Test (UUT) und mockst alles, was "darunter" liegt. Je nachdem kann das aber ganz schön mühsam
sein resp. praktisch nicht möglich: Stell dir vor, du willst ein Repo mit Mockito testen. Wie kommst du
da an die automatisch durch den Spring-Container generierten Methoden (z.B. _findAll()_)? Gar nicht.

Deshalb gibt es Möglichkeiten, je nach Anwendungsfall den Spring Application-Context teilweise oder ganz hochzufahren.
Wollen wir nur den Daten-Teil (Entity und Repo) hochfahren ist das ein @DataJpaTest. Hier werden keine Services und auch keine Controller instantiiert.

Wollen wir nur den Controller-Teil (inkl. Security, Filter, Converter) hochfahren, ist das ein @WebMvcTest. Es werden keine Services, keine Repos und keine Entities instantiiert.

Bei @DataJpaTest und @WebMvcTest sprechen wir von sogenannten **Slice-Tests**.

Natürlich können wir auch den ganzen Spring Application Context hochfahren. Dann verwenden wir @SpringBootTest.

Für Services gibt es keine spezielle Slice-Test-Annotation resp. Umgebung. Da nehmen wir entweder Mockito oder dann @SpringBootTest.

**@DataJpaTest, @WebMvcTest und @SpringBootTest fahren den Application-Context (oder zumindest Teile davon) hoch. Das ist langsamer, als pure Unit-Tests. Wir werden daher später lernen, nur gewisse Tests zu starten.**

![tipIntegrationTest](/images/hint.png) Bei @DataJpaTest, @WebMvcTest und @SpringBootTest kann man von 'Integration-Tests' sprechen, muss aber nicht.
Dafür spricht, das verschiedene Komponenten im Zusammenspiel untersucht werden. Wir könnten nun mit Maven
das failsave Plugin verwenden, das für Integrations-Tests verwendet wird. Das Failsave-Plugin springt in der Maven Phase 'integraton-test' an,
also nach der Unit-Test-Phase 'test'. Es funktioniert anders als Unit-Tests. **Um die Komplexität zu reduzieren,
fahren wir in diesem Projekt aber alle Tests als Unit-Tests (maven phase 'test').**

Hier nochmals in der Übersicht, welche Testarten sich für welchen Layer eignen:
| Layer | Testart(en) |
| ----------- | ----------- |
| Entity/Repo | @DataJpaTest |
| Service | Mockito oder @SpringBootTest |
| Controller | @WebMvcTest |

## Tests ausführen, SpringBoot-Tests ignorieren

Du kannst alle Tests mit `>mvn clean test` ausführen.

![tippFailingTests](/images/hint.png) Evtl. schlägt der Test _PersonRepoTestContainerDataJpaTest_ fehl. Das hat damit zu tun, dass bei der Docker/Podman noch nicht installiert ist. Wir schauen das weiter unten an.

Wie bereits weiter oben erwähnt, sind @DataJpaTest-, @WebMvcTest- und @SpringBootTest-Tests zeitaufwändig.
Deshalb wird auf diese Tests manchmal in einem ersten Testlauf auch verzichtet. Dazu gibt es verschiedene
Wege, der einfachste ist aber so: `>mvn clean test -Dsurefire.excludes=**/*WebMvcTest*,**/*DataJpaTest*,**/*SpringBootTest*`

Mit `-Dsurefire.excludes=...` kannst du festlegen, welche Unit-Tests ignoriert werden sollen.
Das obige Beispiel bezieht sich auf die Bennenung der Tests im Demo-Projekt: Alle Tests die
_WebMvcTest_ oder _DataJpaTest_ oder _SpringBootTest_ im Klassenamen haben werden so ignoriert.

## Services testen mit Mockito

Nun schauen wir an, wie die einzelnen Layers getestet werden können. Starten wir mit dem _PersonService_!

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

Wir schreiben zuerst **Mockito**-Tests. Da sollte dir bereits bekannt sein, wie's geht. So sieht unser Testaufbau aus:

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
- Das PersonRepo wird gemockt.
- _createPerson()_:
  - Die MyUtilityBean wird gespied, ob sie 2x aufgerufen wird und gleichzeitig wird gecaptured, ob die Bean auch die korrekten Person-Objekte übergeben bekommt.

## @SpringBootTest

Wir testen erneut den _PersonService_, jetzt aber mit dem kompletten Application-Context. Auf Mocks 
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

@SpringBootTest()
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
- Zur DB-Konfiguration verwenden wir das application.properties aus /src/**test**/resources. Dieses wird zuerst verwendet, weil es vorhanden ist.
- Anstelle von @Spy (und @Mock) wird @SpyBean (und @MockBean) verwendet. Du kannst jedoch dieselben Assertions und Verifys verwenden.
- Für den Test _getAllPersons()_ verwenden wir ein spezifisches @Sql Script _data_personservice.sql_.
- Die Annotation _@DirtiesContext_ bewirkt, dass nach dem Test die DB zurückgesetzt wird. Andernfalls hätten wir noch die Daten aus dem vorherigen Test in der DB.
- Im Test _createPersons()_ verwenden wir einen ArgumentCaptor auf der _myUtilityBean_ und zählen, ob auf ihr 2x die Methode _addPerson()_ aufgerufen wird und ob die erste Person auch unseren Testdaten entspricht.
- WebEnvironment deaktivieren: Falls du verhindern möchtest, dass das WebEnvironment (u.a. Controller) hochgefahren wird, kannst du die Annoation _@SpringBootTest_ erweitern um _@SpringBootTest(webEnvironment = WebEnvironment.NONE)_. In diesem Szenario hier wäre das sicher sinnvoll, da wir den Controller sowieso nicht verwenden. Also los, ändere die Annotation! 

## @WebMvcTest

Nun testen wir den _PersonController_. Dazu fahren wir einen Slice-Test mit _@WebMvcTest_. Es werden weder Services, noch Repos, noch Entities hochgefahren. 
Deshalb mocken wir den PersonService:

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

        //when
        mockMvc.perform(post("/createPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"personName\": \"Alexandra\", \"personCity\": \"Biel\"}"))
        //then
            .andDo(print())
            .andExpect(jsonPath("$.personName").value("Alexandra"))
            .andExpect(jsonPath("$.personCity").value("Biel"))
            .andExpect(jsonPath("$.personId").isNumber());

    }
}
```

Wichtige Punkte zum Test:
- Der _PersonService_ wird gemockt.
- Wir verwenden einen _MockMvc_. Damit können wir (REST-)Requests absetzen und die Antworten auswerten. _getAllPersons()_ macht einfache String-Überprüfungen, _createPerson()_ wertet die JSON-Response detailliert aus.
- (Tipp am Rande: Falls du trotzdem eine DB verwenden würdest: Es gibt kein automatisches Rollback der Daten nach jedem Test.)

## @DataJpaTest

Jetzt ist das PersonRepo inkl. Person (Entität) und DB dran. Wir fahren den Slice-Test mit @DataJpaTest. 
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
- Zur DB-Konfiguration verwenden wir das application.properties aus /src/**test**/resources. Dieses wird zuerst verwendet, weil es vorhanden ist.
- @BeforeEach: vor jedem Test füllen wir die DB mit einer Person ab. 
- Nach jedem Test müssen wir die DB **nicht** manuell (oder mit _tearDown()_) resetten oder den Test mit _@DirtiesContext_ annotieren. Dies passiert bei _@DataJpaTest_ automatisch.
- Falls du möchtest, kannst du die Beans _EntityManager_ oder _TestEntityManager_ iniziieren lassen, um auf EntityManager-Ebene die Daten zu überprüfen.

## Testcontainers

Bisher haben wir - wo benötigt - mit der In-Memory DB H2 gearbeitet. Wir möchten nun aber mit der "richtigen" DB, also Maria-DB, testen. 

Vorteil: Du hast für den Test exakt dieselben Umsysteme wie in der Produktion verwendet. Anstelle
einer H2 In-Memory-DB können wir hier eine Maria-DB verwenden, wie sie auch "in der Produktion" genutzt wird.

> Docker resp. Podman muss installiert sein und laufen: > podman machine start

natürlich gäbe es auch noch andere Möglichkeiten, um zur Laufzeit Tests ein- resp. auszuschalten (z.B. über Maven-Profiles).

---

![task1](/images/task.png) Jetzt bist du dran. Erweitere/Korrigiere deine Tests aus den [Spring Boot Labs](../../../../labs/java/spring/01_spring/) wie folgt:

- Schreibe Mockito-Tests für den _AdminService_.
- Ändere den _AdminControllerIntegrationTest_ zu einem WebMvcTest.
- Schreibe einen DataJpaTest, der das _StudentRepository_ inkl. _SchoolSubject_ abdeckt.
- Schreibe einen SpringBootTest als kompletten Integrationstest, der vom Controller-Aufruf mittels MockMvc bis auf die H2-DB "runter" geht. Teste, ob das Anlegen eines neuen Schulfachs funktioniert und ob die Daten persistiert werden.
