package Model;

import java.util.ArrayList;

public class Instructor {
    private String name;
    private String  courseName;
    private int priority;
    private ArrayList<Group> groups = new ArrayList<>();

    public Instructor(String name, ArrayList<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public Instructor(String name,String courseName, Group group){
        this.name = name;
        this.courseName = courseName;
        addGroup(group);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public int getPriority() {
        return priority;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }
    public void addGroup(Group group){
        groups.add(group);
    }

}
