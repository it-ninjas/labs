package ch.sbb.talentfactory.oop.exercises.b_adressbook;


public class Person {
    private final String name;
    private final String emailAddress;
    private final String phoneNumber;

    public Person(String name, String emailAddress, String phoneNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
