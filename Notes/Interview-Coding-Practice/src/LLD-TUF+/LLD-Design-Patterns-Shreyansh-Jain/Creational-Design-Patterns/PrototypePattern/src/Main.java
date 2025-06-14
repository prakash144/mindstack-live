/*
                                 +---------------------+
                                 |       Client        |
                                 +---------------------+
                                           |
                                           v
                                 +---------------------+
                                 |       Student       |
                                 |   (Concrete Class)  |
                                 +---------------------+
                                           |
                          +----------------+--------------------+
                          |                                     |
                          v                                     v
              +-------------------+                   +-------------------+
              |    Prototype      |                   |     Cloning       |
              |  (Interface)      |                   |  (Using clone)    |
              +-------------------+                   +-------------------+

### Has-A and Is-A Relationships:
- **Student Is-A**: `Student` implements the `Prototype` interface.
- **Prototype Has-A**: `Prototype` is a generic interface that defines the `clone` method for creating duplicates.

*/

public class Main {
    public static void main(String[] args) {

        // Original Student object
        Student obj = new Student(1, "Prakash", 1);
        // Cloning the Student object
        Student cloneObj = (Student) obj.clone();

        // Optional: Print to verify cloning (not necessary for the pattern)
        System.out.println("Original: " + obj.name + " | Cloned: " + cloneObj.name);

    }
}