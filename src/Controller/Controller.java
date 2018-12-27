package Controller;

import Model.*;

import java.util.*;

public class Controller {
    Schedule schedule;
    Stack addedGroups;
    Set<Integer> daysTaken = new HashSet<>();
    private List<List<Node>> levels = new ArrayList<List<Node>>();
    private List<Node> level = new ArrayList<Node>();
    private ArrayList<Node> completed = new ArrayList();
    private ArrayList<Node> completedPrDupl = new ArrayList<>();





    public void makeSchedule() throws Exception {

        schedule = new Schedule();
        Input input = new Input();
//        levels.get(0).add((Node) level);
//        levels.add(level);
        ArrayList<Course> courses = input.getCourses();
        ArrayList<Instructor> instructors = input.getInstructors();
//        Setting Priorities
        courses.get(2).setPriority(5);
        courses.get(1).setPriority(3);
        courses.get(2).getInstructors().get(0).setPriority(5);
        courses.get(1).getInstructors().get(1).setPriority(3);
        Comparator<Course> crPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
//
//        Comparator<Instructor> inPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
        courses.sort(crPrComp);
//        for (int i = 0; i < courses.size(); i++) {
//            courses.get(i).getInstructors().sort(inPrComp);
//        }
        for(int i = 0; i < courses.get(0).getInstructors().size();i++){
            for(int j = 0; j< courses.get(0).getInstructors().get(i).getGroups().size();j++){
                level.add(new Node(courses.get(0).getInstructors().get(i).getGroups().get(j)));
            }
        }
        levels.add(level);
        for (int i = 0; i < courses.size(); i++) {
            levels.add(new ArrayList<Node>());
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                for (int k = 0; k < courses.get(i).getInstructors().get(j).getGroups().size(); k++) {
                    for(int o = 0 ; o < levels.get(i).size() ; o++){
                        if(!levels.get(i).get(o).checkClash(courses.get(i).getInstructors().get(j).getGroups().get(k),
                                levels.get(i).get(o).getSchedule())) {
                            levels.get(i).get(o).getSchedule().addToPriorityValue(courses.get(i).getInstructors().get(j).getPriority());
                            levels.get(i).get(o).addChild(courses.get(i).getInstructors().get(j).getGroups().get(k));
                            levels.get(i).add(levels.get(i).get(o).getChildren().get(levels.get(i).get(o).getChildren().size()-1));
                            if(i+1 == courses.size()){
                                completed.add(levels.get(i).get(o).getChildren().get(levels.get(i).get(o).getChildren().size()-1));
                            }
                        }
                    }
                }
            }
        }

        Comparator<Node> cnPrComp = (o1, o2) -> o2.getSchedule().getPriorityValue()-o1.getSchedule().getPriorityValue();
        Comparator<Node> ctPrComp = (o1, o2) -> o2.getSchedule().getDaysTaken()-o1.getSchedule().getDaysTaken();
        completed.sort(cnPrComp);
        int ii = 1;
        int tempPri = completed.get(ii).getSchedule().getPriorityValue();
        while(completed.get(0).getSchedule().getPriorityValue() == tempPri ){
            completedPrDupl.add(completed.get(ii));
            ii++;
            tempPri = completed.get(ii).getSchedule().getPriorityValue();
        }
        if(completedPrDupl.size() != 0){
            completedPrDupl.sort(ctPrComp);
            schedule = completedPrDupl.get(0).getSchedule();
        }
        else{
            schedule = completed.get(0).getSchedule();
        }
    }

//    public void makeSchedule() throws Exception {
//        schedule = new Schedule();
//        Input input = new Input();
//        Lecture lec;
//        Tutorial tut;
//        boolean added = false;
//        ArrayList<Course> courses = input.getCourses();
//        ArrayList<Instructor> instructors = input.getInstructors();
////        Setting Priorities
////        courses.get(2).setPriority(5);
////        courses.get(1).setPriority(3);
////        courses.get(2).getInstructors().get(0).setPriority(5);
////        courses.get(1).getInstructors().get(1).setPriority(3);
//        Comparator<Course> crPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
//
//        Comparator<Instructor> inPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
//        courses.sort(crPrComp);
//        for (int i = 0; i < courses.size(); i++) {
//            courses.get(i).getInstructors().sort(inPrComp);
//        }
//        for (int i = 0; i < courses.size(); i++) {
//            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
//                for (int k = 0; k <courses.get(i).getInstructors().get(j).getGroups().size() ; k++) {
//                    lec = courses.get(i).getInstructors().get(j).getGroups().get(k).getLecture();
//                    tut = courses.get(i).getInstructors().get(j).getGroups().get(k).getTutorials().get(0);
//                    if(!schedule.checkClash(lec) && !schedule.checkClash(tut)){
//                        schedule.addPeriod(lec);
//                        schedule.addPeriod(tut);
//                        added = true;
//                        break;
//                    }
//                }
//                if(added) {
//                    added = false;
//                    break;
//                }
//            }
//        }
//
//
//
//    }

    public Schedule getSchedule() {
        return schedule;
    }


}

