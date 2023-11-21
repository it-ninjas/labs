package ch.sbb.talentfactory.oop.exercises.d_immo;

import java.time.LocalDate;

public class Employee {
    private final String firstname;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private String lastname;

    public Employee(String firstname, String lastname, LocalDate dateOfBirth, Gender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }
}
