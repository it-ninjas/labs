window.timelineData = [
    {
        title: "2025/2026 (Fokus: Java Grundlagen, Tools)",
        startDate: "5.8.2025",
        endDate: "31.12.2025",
        modules: [
            { 
                type: "module",
                title: "Modulplan",
                items: [
                    { name: "LoWo | Login;Woche", startDate: "05.08.2025", durationWeeks: 1, color: "#D9D9D9" },
                    { name: "Java;Grundlagen | Basics;Scanner;Debugging;Arrays;Regex;Exceptions | #J1", url: "/de/docs/02_java/03_java-grundlagen/", startDate: "14.08.2025", durationWeeks: 4, color: "#5AC036" },
                    { name: "Java;OOP | Klassen;Vererbung;Interfaces;Collections;Exceptions | #J2", url: "/de/docs/02_java/04_java-oop/", durationWeeks: 3, color: "#5AC036" },
                    { name: "GIT | Branching;Konflikte;Cherry-Pick | #S1", url: "/de/docs/04_git/", durationWeeks: 2, color: "#F2AA84" },
                    { name: "Java;Frameworks | Maven;Lombok | #J3", url: "/de/docs/02_java/05_maven/", durationWeeks: 2, color: "#5AC036" },
                    { name: "Java;Testing | Konzepte;JUnit;Mockito;TDD | #J4", url: "/de/docs/02_java/08_java-testing/", durationWeeks: 3, color: "#5AC036" },
                    { name: "Java;OOD | Klassendiagramme;Datenmodelle;Vertiefung OOP | #J5", url: "/de/docs/02_java/07_java-ood/", durationWeeks: 5, color: "#5AC036" },
                    { name: "UX | UI Design;Datenanalyse;Accessibility | #F1", url: "/de/docs/03_web/01_ide-basic/", endDate: "31.12.2025", color: "#D86ECC" },
                ]
            }, {
                type: "crossover", 
                alignMode: "crossover",
                allowMixedGroupRows: false,
                title: "Übergreifende;Module",
                items: [
                    { group: "git", name: "GIT Intro", startDate: "18.8.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "git", name: "GIT Wissen vertiefen und anwenden", endDate: "31.12.2025", color: "#F2AA84" },
                    { group: "div", name: "MarkDown", startDate: "24.9.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "div", name: "UX & Design Thinking", startDate: "16.10.2025", durationWeeks: 3, color: "#D86ECC" },
                    { group: "proj", name: "Agile Intro", startDate: "01.12.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "proj", name: "Agiles Projekt Management Wissen vertiefen und anwenden", endDate: "31.12.2025", color: "#79A4B0" },
                    { group: "cicd", name: "CI/CD Intro", startDate: "8.12.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "cicd", name: "CI/CD Wissen vertiefen und anwenden", endDate: "31.12.2025", color: "#69A882" },
                    { group: "softskills", name: "Zeitmanagement / Selbstkompetenz", startDate: "11.9.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "softskills", name: "Gewaltfreie Kommunikation", startDate: "06.11.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "softskills", name: "KI-Umgang / SBB AI Chat", startDate: "8.10.2025", durationWeeks: 2, color: "#C04F15" },
                    { group: "ük", name: "Ük ICT-Arbeitsplatz", startDate: "20.11.2025", endDate: "05.12.2025", color: "#83CBEB" },

                ]
            }, {
                type: "crossover", 
                alignMode: "crossover",
                title: "Projekt;Exams",
                items: [
                    { name: "Exam 1", startDate: "1.09.2025", durationWeeks: 2, color: "#5AC036" },
                    { name: "Mini-Logger", durationWeeks: 3, color: "#0071FF" },
                    { name: "Exam 2", durationWeeks: 2, color: "#5AC036" },
                    { name: "Tournament-Library", durationWeeks: 5, color: "#0071FF" },
                    { name: "Exam 3", durationWeeks: 2, color: "#5AC036" },
                    { name: "Gaming-Engine", endDate: "31.12.2025", color: "#0071FF" },
                ]
            }, {
                type: "highlight", 
                alignMode: "crossover",
                items: [
                    { name: "Ferien GiBB;20.09. - 12.10.", startDate: "20.09.2025", endDate: "12.10.2025", color: "#BFBFBF" },
                    { name: "Ferien GiBB;20.12. - 04.01.", startDate: "20.12.2025", endDate: "04.01.2026", color: "#BFBFBF" },
                ],
            }
        ],
    },
    {
        title: "2025/2026 (Fokus: Datenbanken, Spring(-Boot), Web, Angular)",
        startDate: "1.1.2026",
        endDate: "31.07.2026",
        modules: [
            { 
                type: "module",
                title: "Modulplan",
                items: [
                    { name: "Java | Grundlagen;OOP;OOD;Vertiefung | #J6", url: "/de/docs/02_java/07_java-ood/", startDate: "1.01.2026", durationWeeks: 3, color: "#5AC036" },
                    { name: "Java;Datenbanken | SQL;JDBC;Postgress;MariaDB | #J7", url: "/de/docs/02_java/11_java-jdbc/", durationWeeks: 3, color: "#5AC036" },
                    { name: "Java;Frameworks | Spring;SpringBoot | #J8", url: "/de/docs/02_java/12_spring-framework/", durationWeeks: 4, color: "#5AC036" },
                    { name: "Web;HTML/CSS | Basiscs | #F2", url: "/de/docs/03_web/02_html_css/", durationWeeks: 3, color: "#D86ECC" },
                    { name: "Web;JavaScript | Basiscs;Debugging | #F3", url: "/de/docs/03_web/03_javascript/", durationWeeks: 3, color: "#D86ECC" },
                    { name: "Web;TypeScript | Basiscs | #F4", url: "/de/docs/03_web/05_typescript/", durationWeeks: 3, color: "#D86ECC" },
                    { name: "Web;Angular | Basiscs;Debugging;Testing;RxJS;(Optional: NgRx) | #F5", url: "/de/docs/03_web/06_angular/", durationWeeks: 4, color: "#D86ECC" },
                    { name: "Abschluss | Vertiefung;Wiederholen;Projekt fertigstellen;Vorbereitung Rotationsstelle", endDate: "31.07.2026", color: "#0071FF" },
                ]
            }, {
                type: "crossover", 
                alignMode: "crossover",
                title: "Übergreifende;Module",
                items: [
                    { name: "Security Workshop (1 Nachmittag pro Monat)", startDate: "1.01.2026", endDate: "31.7.2026", color: "#59000E" },
                    { name: "GIT Wissen vertiefen und anwenden", startDate: "1.01.2026", endDate: "31.7.2026", color: "#F2AA84" },
                    { name: "CI/CD Wissen vertiefen und anwenden", startDate: "1.1.2026", endDate: "31.7.2026", color: "#69A882" },
                    { name: "Agiles Projekt Management Wissen vertiefen und anwenden", startDate: "1.1.2026", endDate: "31.7.2026", color: "#79A4B0" },
                    { name: "Barrierefreiheit/Accessibility", startDate: "1.1.2026", durationWeeks: 5, color: "#C04F15" },
                    { name: "Datenbearbeitung", startDate: "2.3.2026", durationWeeks: 3, color: "#C04F15" },
                    { name: "Ük DB", startDate: "04.06.2026", endDate: "19.06.2026", color: "#83CBEB" },
                ]
            }, {
                type: "crossover", 
                alignMode: "crossover",
                title: "Projekt;Exams",
                items: [
                    { name: "Gaming-Engine", startDate: "1.1.2026", durationWeeks: 5, color: "#0071FF" },
                    { name: "Exam 4", durationWeeks: 2, color: "#5AC036" },
                    { name: "Persistency", durationWeeks: 2, color: "#0071FF" },
                    { name: "Exam 5", durationWeeks: 2, color: "#5AC036" },
                    { name: "Backend", durationWeeks: 4, color: "#0071FF" },
                    { name: "Exam 6", durationWeeks: 2, color: "#5AC036" },
                    { name: "Backend / Frontend", durationWeeks: 5, color: "#0071FF" },
                    { name: "Exam 7", durationWeeks: 2, color: "#5AC036" },
                    { name: "Frontend", endDate:"31.7.2026", color: "#0071FF" },
                ]
            }, {
                type: "highlight", 
                alignMode: "crossover",
                items: [
                    { name: "GiBB;-4.1.", startDate: "1.1.2026", endDate: "04.01.2026", color: "#BFBFBF" },
                    { name: "Ferien GiBB;31.01. - 08.02.", startDate: "31.01.2026", endDate: "08.02.2026", color: "#BFBFBF" },
                    { name: "Ferien GiBB;03.04. - 19.04.", startDate: "03.04.2026", endDate: "19.04.2026", color: "#BFBFBF" },
                    { name: "Ferien GiBB;04.07. - 09.08.", startDate: "04.07.2026", endDate: "31.07.2026", color: "#BFBFBF" },
                ],
            }
        ],
    },
];
