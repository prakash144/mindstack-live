/*
 * Flowchart Explanation:

       +-------------------------------+
       |          Client (Main)        |
       +-------------------------------+
                      |
                      v
       +-------------------------------+
       |      Director (optional)      |
       +-------------------------------+
                      |
                      v
       +--------------------------------------+
       |          StudentBuilder (abstract)   |
       +--------------------------------------+
                  /                   \
                 v                     v
     +-----------------------+     +----------------------+
     | EngineeringStudent    |     | MBAStudent           |
     |  Builder (concrete)   |     |  Builder (concrete)  |
     +-----------------------+     +----------------------+
                      |
                      v
       +--------------------------------------+
       |           Student (Product)          |
       +--------------------------------------+
       | rollNumber, age, name, fatherName,   |
       | motherName, subjects                 |
       +--------------------------------------+

 * IS-A Relationships:
 * - EngineeringStudentBuilder and MBAStudentBuilder are concrete implementations of StudentBuilder.

 * HAS-A Relationships:
    - Student has attributes: rollNumber, age, name, fatherName, motherName, subjects.

 */

public class Main {
    public static void main(String[] args) {

        // ======================== Using Director =======================

        System.out.println("======================== Using Director =======================");

        Director directorObj1 = new Director(new EngineeringStudentBuilder());
        Director directorObj2 = new Director(new EngineeringStudentBuilder());

        Student engineerStudent1 = directorObj1.createStudent();
        Student mbaStudent1 = directorObj2.createStudent();

        System.out.println(engineerStudent1.toString());
        System.out.println(mbaStudent1.toString());

        // ======================== Without Director =======================
        System.out.println("======================== Without Director =======================");

        // Building an Engineering Student
        Student engineerStudent2 = new EngineeringStudentBuilder()
                .setRollNumber(1)
                .setAge(22)
                .setName("John")
                .setFatherName("FatherEngineer")
                .setMotherName("MotherEngineer")
                .setSubjects()  // Subjects set specifically for Engineering
                .build();

        // Building an MBA Student
        Student mbaStudent2 = new MBAStudentBuilder()
                .setRollNumber(2)
                .setAge(24)
                .setName("Mike")
                .setFatherName("FatherMBA")
                .setMotherName("MotherMBA")
                .setSubjects()  // Subjects set specifically for MBA
                .build();

        System.out.println(engineerStudent2.toString());
        System.out.println(mbaStudent2.toString());
    }
}