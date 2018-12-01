package Model;

import java.util.ArrayList;

public class Course {
    String name;
    int priority;
    ArrayList<Instructor> instructors = new ArrayList<>();

    public Course(String name, ArrayList<Instructor> instructors) {
        this.name = name;
        this.instructors = instructors;
    }

    public Course(String name, Instructor instructor){
        this.name = name;
        addInstructor(instructor);
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

    public void addInstructor(Instructor instructor){
        instructors.add(instructor);
    }

    public int getPriority() {
        return priority;
    }

}
