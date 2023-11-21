package annotation;

// RUN THE PROCESSOR WITH THESE TWO COMMANDS:
//javac ./annotation/ClassInfo.java ./annotation/DocumentationProcessor.java
//javac -processor annotation.DocumentationProcessor ./annotation/MyModel.java
// These comments only work from the source root (in this case 10_reflection)

@ClassInfo(
        authors = {"Max Mustermann", "Sabine Schweizer"},
        description = "Dies ist eine Beispiel-Modellklasse.",
        version = "1.0.0"
)
public class MyModel {
    private int id;
    private String name;

    public MyModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
