package Controller;

import Model.*;

import java.util.*;

public class Controller {
    Schedule schedule;
    Stack addedGroups;
    Set<Integer> daysTaken = new HashSet<>();



    public void makeSchedule() throws Exception {
        schedule = new Schedule();
        Input input = new Input();
        Lecture lec;
        Tutorial tut;
        boolean added = false;
        ArrayList<Course> courses = input.getCourses();
        ArrayList<Instructor> instructors = input.getInstructors();
//        Setting Priorities
//        courses.get(2).setPriority(5);
//        courses.get(1).setPriority(3);
//        courses.get(2).getInstructors().get(0).setPriority(5);
//        courses.get(1).getInstructors().get(1).setPriority(3);
        Comparator<Course> crPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();

        Comparator<Instructor> inPrComp = (o1, o2) -> o2.getPriority()-o1.getPriority();
        courses.sort(crPrComp);
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).getInstructors().sort(inPrComp);
        }
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                for (int k = 0; k <courses.get(i).getInstructors().get(j).getGroups().size() ; k++) {
                    lec = courses.get(i).getInstructors().get(j).getGroups().get(k).getLecture();
                    tut = courses.get(i).getInstructors().get(j).getGroups().get(k).getTutorials().get(0);
                    if(!schedule.checkClash(lec) && !schedule.checkClash(tut)){
                        schedule.addPeriod(lec);
                        schedule.addPeriod(tut);
                        added = true;
                        break;
                    }
                }
                if(added) {
                    added = false;
                    break;
                }
            }
        }



    }

    public Schedule getSchedule() {
        return schedule;
    }
}
