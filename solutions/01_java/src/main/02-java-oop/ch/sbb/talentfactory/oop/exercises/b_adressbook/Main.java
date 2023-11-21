package ch.sbb.talentfactory.oop.exercises.b_adressbook;

public class Main {

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.newPerson(new Person("Sven", "sven.jaun2@sbb.ch", "+41762603856"));
        addressBook.newPerson(new Person("Claudio", "claudio.zesiger@sbb.ch", "0785465874"));
        addressBook.newPerson(new Person("Ruzo", "ruzo.madem@google.cz", "+420452178584"));
        addressBook.newPerson(new Person("Sven", "sven.bruegger@sbb.ch", "+41798547625"));

        System.out.printf("The length of the addressbook is %s\n\n", addressBook.getAddressBookLength());

        addressBook.findPerson("Sven").forEach(Main::printPerson);

        addressBook.deletePerson("sven.bruegger@sbb.ch");

        System.out.printf("The length of the addressbook is %s\n\n", addressBook.getAddressBookLength());

        addressBook.newPerson(new Person("Claudio2", "claudio.zesiger@sbb.ch", "+41798547625"));

        System.out.printf("The length of the addressbook is %s\n", addressBook.getAddressBookLength());
    }

    private static void printPerson(Person person) {
        System.out.printf("Person's name is %s\n", person.getName());
        System.out.printf("Person's e-mail is %s\n", person.getEmailAddress());
        System.out.printf("Person's phone number is %s\n", person.getPhoneNumber());
        System.out.println();
    }
}
