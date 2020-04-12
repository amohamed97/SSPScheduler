package Controller;

import Model.*;

import java.util.*;

public class Controller {
    private Schedule schedule;
    private List<Schedule> alternatives = new ArrayList<>();
    private List<List<Node>> levels = new ArrayList<List<Node>>();
    private List<Node> level = new ArrayList<Node>();
    private ArrayList<Node> completed = new ArrayList<>();
    private ArrayList<Node> completedPriorityDuplicate = new ArrayList<>();



    public void makeSchedule() throws Exception {

        schedule = new Schedule();
        Node perfect;
        Input input = new Input();
        ArrayList<Course> courses = input.getCourses();
//        ArrayList<Instructor> instructors = input.getInstructors();
        courses.get(2).setPriority(5);
        courses.get(4).setPriority(4);
//        courses.get(1).setPriority(3);
        courses.get(2).getInstructors().get(1).setPriority(5);
        courses.get(4).getInstructors().get(2).setPriority(4);

//        courses.get(1).getInstructors().get(1).setPriority(3);
        Comparator<Course> crPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
        Comparator<Instructor> inPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
        courses.sort(crPrComp);
        for (Course course : courses) {
            course.getInstructors().sort(inPrComp);
        }
        for(int i = 0; i < courses.get(0).getInstructors().size();i++){
            for(int j = 0; j< courses.get(0).getInstructors().get(i).getGroups().size();j++){
                Node n = new Node(courses.get(0).getInstructors().get(i).getGroups().get(j));
                n.getSchedule().addToPriorityValue(courses.get(0).getInstructors().get(i).getPriority());
                level.add(n);
            }
        }
        levels.add(level);

        for (int i = 1; i < courses.size(); i++) {
            levels.add(new ArrayList<Node>());
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                  for (int k = 0; k < courses.get(i).getInstructors().get(j).getGroups().size(); k++) {
                    for(int o = 0 ; o < levels.get(i-1).size() ; o++){
                        if(!levels.get(i-1).get(o).checkClash(courses.get(i).getInstructors().get(j).getGroups().get(k),
                                levels.get(i-1).get(o).getSchedule())) {
//                            levels.get(i-1).get(o).getSchedule().addToPriorityValue(courses.get(i).getInstructors().get(j).getPriority());
//                            add el node elly maskha delwa2ty
                            levels.get(i-1).get(o).addChild(courses.get(i).getInstructors().get(j).getGroups().get(k));
//                            add priority el parent w instructor elly masko ll node elly et7tt
                            levels.get(i-1).get(o).getChildren().get(levels.get(i-1).get(o).getChildren().size()-1).getSchedule().addToPriorityValue(
                                    levels.get(i-1).get(o).getChildren().get(levels.get(i-1).get(o).getChildren().size()-1).getParent().getSchedule().getPriorityValue() +
                                            courses.get(i).getInstructors().get(j).getPriority()
                            );
//                            by7t el node elly dt7tt fy el level bta3ha
                            levels.get(i).add(levels.get(i-1).get(o).getChildren().get(levels.get(i-1).get(o).getChildren().size()-1));
                            if(i == courses.size()-1){
                                completed.add(levels.get(i-1).get(o).getChildren().get(levels.get(i-1).get(o).getChildren().size()-1));
                            }
                        }
                    }
                }
            }
        }

        Comparator<Node> cnPrComp = (o1, o2) -> o2.getSchedule().getPriorityValue()-o1.getSchedule().getPriorityValue();
        Comparator<Node> ctPrComp = (o1, o2) -> o1.getSchedule().getDaysTaken()-o2.getSchedule().getDaysTaken();
        completed.sort(cnPrComp);
        int ii = 1;
        int tempPri = completed.get(ii).getSchedule().getPriorityValue();
        completedPriorityDuplicate.add(completed.get(0));
        while(completed.get(0).getSchedule().getPriorityValue() == tempPri ){
            completedPriorityDuplicate.add(completed.get(ii));
            ii++;
            if(ii == completed.size())
                break;
            tempPri = completed.get(ii).getSchedule().getPriorityValue();
        }
        completedPriorityDuplicate.sort(ctPrComp);
        schedule = completedPriorityDuplicate.get(0).getSchedule();
        perfect = completedPriorityDuplicate.get(0);
        for(int i = 0; i < courses.size(); i++){
            completedPriorityDuplicate.clear();
            if(i != 0){
                perfect = perfect.getParent();
            }
            System.out.println(perfect.getData().getLecture().getCourseName()+"---");
            perfect.getData().setAvailable(false);
            for (int j = 0; j < completed.size() ; j++) {
                if(completed.get(j).allAvailable()){
                    completedPriorityDuplicate.add(completed.get(j));
                    ii=1;
                    tempPri = completed.get(j+ii).getSchedule().getPriorityValue();
                    while(completed.get(j).getSchedule().getPriorityValue() == tempPri){
                        if(completed.get(j+ii).allAvailable()){
                            completedPriorityDuplicate.add(completed.get(j+ii));
                        }
                        ii++;
                        if(j+ii == completed.size())
                            break;
                        tempPri = completed.get(j+ii).getSchedule().getPriorityValue();
                    }
                    break;
                }
            }
            if(completedPriorityDuplicate.size() != 0){
                completedPriorityDuplicate.sort(ctPrComp);
                alternatives.add(completedPriorityDuplicate.get(0).getSchedule());
            }
            perfect.getData().setAvailable(true);
        }
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public List<Schedule> getAlternatives() {
        return alternatives;
    }
}

