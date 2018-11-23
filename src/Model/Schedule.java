package Model;

import Controller.Input;

import java.util.ArrayList;
import java.util.Comparator;

public class Schedule {
    Period[][] schedule = new Period[6][12];
    Input input;


    public void makeSchedule() throws Exception {
        input = new Input();
        Lecture lec;
        Tutorial tut;
        boolean added = false;
        ArrayList<Course> courses = input.getCourses();
//        ArrayList<Instructor> instructors = input.getInstructors();
//        Comparator<Course> crPrComp = new Comparator<Course>() {
//            @Override
//            public int compare(Course o1, Course o2) {
//                return o2.getPriority()-o1.getPriority();
//            }
//        };
//
//        Comparator<Instructor> inPrComp = new Comparator<Instructor>() {
//            @Override
//            public int compare(Instructor o1, Instructor o2) {
//                return o2.getPriority()-o1.getPriority();
//            }
//        };
//        courses.sort(crPrComp);
//        for (int i = 0; i < courses.size(); i++) {
//            courses.get(i).instructors.sort(inPrComp);
//        }
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                for (int k = 0; k <courses.get(i).getInstructors().get(j).getGroups().size() ; k++) {
                     lec = courses.get(i).getInstructors().get(j).getGroups().get(k).getLecture();
                     tut = courses.get(i).getInstructors().get(j).getGroups().get(k).getTutorials().get(0);
                     if(!checkClash(lec) && !checkClash(tut)){
                        addPeriod(lec);
                        addPeriod(tut);
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


    public boolean checkClash(Period period){
        for (int i = 0; i < period.getLength(); i++) {
            if(schedule[period.getTime().getDay()][period.getTime().getFrom()+i]!=null) {
                return true;
            }
            else
                return false;
        }
        return true;
    }

    public void addPeriod(Period period){
        for (int i = 0; i < period.getLength(); i++) {
            schedule[period.getTime().getDay()][period.getTime().getFrom()+i] = period;
        }
    }

    public void printSchedule(){
        for (int i = 0; i < 6 ; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 12 ; j++) {
                if(schedule[i][j] == null)
                    System.out.print(j);
                else
                    schedule[i][j].printMe();
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        Schedule schedule = new Schedule();
        schedule.makeSchedule();
        schedule.printSchedule();
    }
}


//schedule[lec.getTime().getDay()][lec.getTime().getFrom()]

/*for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                for (int k = 0; k <courses.get(i).getInstructors().get(j).getGroups().size() ; k++) {
                     lec = courses.get(i).getInstructors().get(j).getGroups().get(k).getLecture();
                     tut = courses.get(i).getInstructors().get(j).getGroups().get(k).getTutorials();
                     if(!checkClash(lec) || !checkClash(tut)){
                        addPeriod(lec);
                        addPeriod(tut);
                        added = true;
                        break;
                     }
                }
                if(added) {
                    added = false;
                    break;
                }
            }
        }*/