import java.util.ArrayList;

public class Instructor {
    String name;
    ArrayList<Group> groups;

    public Instructor(String name, ArrayList<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }
}
