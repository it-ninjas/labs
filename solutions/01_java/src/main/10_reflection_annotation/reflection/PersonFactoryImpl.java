package reflection;

@PersonFactory
public class PersonFactoryImpl {
    public Person createPerson(String name, int age) {
        return new Person(name, age);
    }
}

