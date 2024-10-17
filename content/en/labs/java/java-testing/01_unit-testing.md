---
title: "Unit Testing mit JUnit - Aufgaben"
linkTitle: "Unit Testing mit JUnit - Aufgaben"
type: docs
weight: 1
description: >
  Aufgaben zu Modul #J4 - Unit Testing / JUnit
---

Die folgenden Aufgaben bestehen darin für bestehende Programmlogik entsprechende Unit-Tests zu schreiben.

### Aufgabe 1: Tageszeit

Schreibe Unit-Tests, um die Logik der folgenden Methode zu testen:

```java
import java.time.LocalDateTime;

public class TimeOfDay {
    public String getTimeOfDay(LocalDateTime time) {
        if (time.getHour() < 6) {
            return "Night";
        }
        if (time.getHour() < 12) {
            return "Morning";
        }
        if (time.getHour() < 18) {
            return "Afternoon";
        }
        return "Evening";
    }
}
```

### Aufgabe 2

Schreibe Unit-Tests, um die Methode **move** zu testen:

```java
public class Mover {
    private LocalDateTime lastMovingTime;
    private Direction lastDirection;

    public void move(Direction direction) {
        if (Direction.getOpposite(direction) != this.lastDirection) {
            this.lastDirection = direction;
            this.lastMovingTime = LocalDateTime.now();
        }
    }

    public LocalDateTime getLastMovingTime() {
        return lastMovingTime;
    }

    public Direction getLastDirection() {
        return lastDirection;
    }

    private enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST;

        public static Direction getOpposite(Direction direction) {
            switch (direction) {
                case NORTH -> {
                    return SOUTH;
                }
                case EAST -> {
                    return WEST;
                }
                case SOUTH -> {
                    return NORTH;
                }
                case WEST -> {
                    return EAST;
                }
            }
            return null;
        }
    }
}
```

Falls du meinst, dass es unmöglich ist diese Methode genau zu testen. Schreibe die Methode um, damit sie einfacher zu testen ist. Benutze dazu ein Clock-Objekt. Weitere Informationen findest du [hier](https://www.baeldung.com/java-override-system-time).

### Aufgabe 3

In dieser Aufgabe geht es darum, dass die Unit-Tests für eine bestimmte Methode schon geschrieben wurden. Die Methode muss nun implementiert werden, so dass sie alle Unit-Tests erfüllt. Arbeite dich von Test zu Test durch.

**Test Source**

```java
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private PasswordValidator uut;

    @Test
    public void testPasswordNull() {
        assertFalse(this.uut.isPasswordValid(null));
    }

    @Test
    public void testPasswordTooShort() {
        assertFalse(this.uut.isPasswordValid("1234567"));
    }

    @Test
    public void testPasswordTooLong() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRSTU"));
    }

    @Test
    public void testPasswordContainsNoSpace() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQR T"));
    }

    @Test
    public void testPasswordContainsNoNumeric() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJKLMNOPQRST"));
    }

    @Test
    public void testPasswordContainsNoLowercaseChar() {
        assertFalse(this.uut.isPasswordValid("ABCDEFGHIJ0123456789"));
    }

    @Test
    public void testPasswordContainsNoUppercaseChar() {
        assertFalse(this.uut.isPasswordValid("abcdefghij0123456789"));
    }

    @Test
    public void testPasswordContainsNoSpecialChar() {
        assertFalse(this.uut.isPasswordValid("abcdeFGHIJ0123456789"));
    }

    @Test
    public void testPasswordValid() {
        assertTrue(this.uut.isPasswordValid("abcdeFGHIJ01234$*%?+"));
    }
}
```

**Source**

```java
public class PasswordValidator {
    public boolean isPasswordValid(String password) {
        // Ersetze die Exception durch deine Implementation...
        throw new IllegalStateException();
    }
}
```

Wenn du eine Lösung gefunden hast, dann kannst du diese noch aufräumen (Refactoring).

---

Hier kannst du [zurück zur Theorie](../../../../docs/java/java-testing/#junit).
