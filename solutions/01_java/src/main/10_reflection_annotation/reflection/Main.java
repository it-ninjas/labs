package reflection;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        try {
            // Hol dir eine Klasseninstanz über den Package- und Klassennamen
            String className = "reflection.Person";
            Class<?> personClass = Class.forName(className);

            // Hol dir den Konstruktor der Klasse
            Constructor<?> constructor = null;
            Constructor<?>[] constructors = personClass.getDeclaredConstructors();
            for (Constructor<?> c : constructors) {
                if (c.isAnnotationPresent(PersonData.class)) {
                    constructor = c;
                    break;
                }
            }

            if (constructor != null) {
                // Hol dir die Annotation vom Konstruktor
                PersonData personDataAnnotation = constructor.getAnnotation(PersonData.class);

                // Hol aus der Annotation die Namen und Altersangaben
                String[] names = personDataAnnotation.names();
                int[] ages = personDataAnnotation.ages();

                // Nutze die Angaben in einem Loop, um Instanzen der Klasse Person zu erzeugen
                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                    int age = ages[i];
                    Person person = (Person) constructor.newInstance(name, age);

                    // Drucke die Angaben der Personen auf der Kommandozeile aus
                    System.out.println("Erzeugte Person: " + person);
                }
            } else {
                System.out.println("Konstruktor mit PersonData-Annotation nicht gefunden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

