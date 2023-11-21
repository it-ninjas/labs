package ch.sbb.talentfactory.oop.exercises.b_adressbook;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private final List<Person> personList = new LinkedList<>();

    public Integer getAddressBookLength() {
        return this.personList.size();
    }

    public boolean newPerson(Person person) {
        if (this.personList.stream().noneMatch(o -> o.getEmailAddress().equals(person.getEmailAddress()))) {
            this.personList.add(person);
            return true;
        }
        System.out.printf("Email %s already exists\n", person.getEmailAddress());
        return false;
    }

    public List<Person> findPerson(String name) {
        List<Person> found = this.personList.stream().filter(o -> o.getName().equals(name)).collect(Collectors.toList());
        if (found.size() == 0) {
            System.out.printf("No Person with name %s found\n", name);
        }
        return found;
    }

    public boolean deletePerson(String email) {
        if (!this.personList.removeIf(person -> person.getEmailAddress().equals(email))) {
            System.out.printf("No Person with email %s found\n", email);
            return true;
        }
        return false;
    }

}
