import java.util.ArrayList;
import java.util.List;

// Concrete Builder for Engineering Students
public class EngineeringStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("DSA");
        subs.add("OS");
        subs.add("Computer Architecture");
        this.subjects = subs;
        return this;

    }
}
