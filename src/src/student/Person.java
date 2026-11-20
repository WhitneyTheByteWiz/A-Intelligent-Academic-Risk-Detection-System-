package student;

/**
 * Week 8: parent class for any person recorded by the system.
 * The name is private (Week 7 encapsulation) and validated in the constructor.
 */
public class Person {

    private String name;

    public Person(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    public String describe() {
        return "Person: " + name;
    }
}
