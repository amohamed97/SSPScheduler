package Model;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> children = new ArrayList<Node>();
    private Node parent = null;
    private Group data = null;
    private Schedule schedule = new Schedule();


    public Node(Group data) {
        this.data = data;
        this.addToSchedule();
    }

    public Node(Group data, Schedule sch) {
        this.data = data;
        this.schedule.clone(sch);
        this.addToSchedule();

    }

    public List<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void addChild(Group data) {
        Node child = new Node(data,this.getSchedule());
        child.setParent(this);
        this.children.add(child);
    }


    public Group getData() {
        return this.data;
    }

    public void setData(Group data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public void removeParent() {
        this.parent = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean checkClash(Group group , Schedule sch){
        if(sch.checkClash(group.getLecture())){
            return true;
        }
        for(int i = 0 ; i < group.getTutorials().size() ;i++){
            if(sch.checkClash(group.getTutorials().get(i))) {
                return true;
            }
        }
        for(int i = 0 ; i < group.getLabs().size() ;i++){
            if(sch.checkClash(group.getLabs().get(i))){
                return true;
            }
        }
        return false;
    }

    public void addToSchedule(){
        schedule.addPeriod(data.getLecture());
        for(int i = 0 ; i < data.getTutorials().size() ;i++){
            schedule.addPeriod(data.getTutorials().get(i));
        }
        for(int i = 0 ; i < data.getLabs().size() ;i++){
            schedule.addPeriod(data.getLabs().get(i));
        }

    }

    public Schedule getSchedule() {
        return schedule;
    }
}