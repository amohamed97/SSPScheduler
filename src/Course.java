import java.util.ArrayList;

public class Course {
    String name;
    int priority;
    ArrayList<Instructor> instructors;

    public Course(String name, ArrayList<Instructor> instructors) {
        this.name = name;
        this.instructors = instructors;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
