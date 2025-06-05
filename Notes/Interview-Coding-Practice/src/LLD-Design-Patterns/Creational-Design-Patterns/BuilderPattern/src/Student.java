import java.util.List;

public class Student {

    int rollNumber;
    int age;
    String name;
    String fatherName;
    String motherName;
    List<String> subjects;

    // Constructor using Builder
    public Student(StudentBuilder builder){
        this.rollNumber = builder.rollNumber;
        this.age = builder.age;
        this.name = builder.name;
        this.fatherName = builder.fatherName;
        this.motherName = builder.motherName;
        this.subjects = builder.subjects;
    }

    // Representation of the student
    public String toString(){
        return "Roll Number: " + this.rollNumber +
                ", Age: " + this.age +
                ", Name: " + this.name +
                ", Father: " + this.fatherName +
                ", Mother: " + this.motherName +
                ", Subjects: " + String.join(", ", subjects);
    }

}
