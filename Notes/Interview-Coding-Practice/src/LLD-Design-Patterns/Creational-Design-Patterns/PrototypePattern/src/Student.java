public class Student implements Prototype {

    int id;
    private int rollNo;
    String name;

    // Constructor to initialize Student object
    public Student(int id, String name, int rollNo) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public Prototype clone() {
        // Return a new instance of Student with the same attributes
        return new Student(id, name, rollNo);
    }
}
