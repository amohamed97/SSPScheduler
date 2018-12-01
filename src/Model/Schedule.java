package Model;

import Controller.Input;

import java.util.ArrayList;
import java.util.Comparator;

public class Schedule {
    public Period[][] schedule = new Period[6][12];
    Input input;


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

    public Period[][] getSchedule() {
        return schedule;
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