package reflection;

@PersonFactory
public class Person {
    private String name;
    private int age;

    @PersonData(names = {"Max Mustermann", "Erika Musterfrau", "John Doe"}, ages = {30, 25, 35})
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
