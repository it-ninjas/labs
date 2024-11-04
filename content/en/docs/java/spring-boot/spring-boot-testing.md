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

Nun schauen wir an, wie die einzelnen Layers getestet werden können. Starten wir mit dem PersonService!

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

Wir schreiben zuerst **Mockito**-Tests. Da sollte dir bereits bekannt sein, wie's geht.

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

![Service-Mockito-Tests](../spring-boot-testing/service-mockito.png)

Wichtige Punkte zum Test:

- Das PersonRepo wird gemockt.
- _createPerson()_:
  - Die MyUtilityBean wird gespied, ob sie 2x aufgerufen wird und gleichzeitig wird gecaptured, ob die Bean auch die korrekten Person-Objekte übergeben bekommt.

## @SpringBootTest

![Service-SpringBootTest-Tests](../spring-boot-testing/service-springboottest.png)

## @WebMvcTest

![Controller-WebMvcTest-Tests](../spring-boot-testing/controller-webmvctest.png)

## @DataJpaTest

![Repo-DataJpaTest-Tests](../spring-boot-testing/repo-datajpatest.png)

## Testcontainers

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
