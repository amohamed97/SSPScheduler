import java.lang.reflect.Array;
import java.util.ArrayList;

public class Schedule {
    Period[][] schedule = new Period[6][12];
    Input input;


    public void makeSchedule(){
        input = new Input();
        Lecture lec;
        Tutorial tut;
        boolean added = false;
         ArrayList<Course> courses = input.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < courses.get(i).getInstructors().size(); j++) {
                for (int k = 0; k <courses.get(i).getInstructors().get(j).getGroups().size() ; k++) {
                     lec = courses.get(i).getInstructors().get(j).getGroups().get(k).getLecture();
                     tut = courses.get(i).getInstructors().get(j).getGroups().get(k).getTutorial();
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
        }

    }

    public boolean checkClash(Period period){
        for (int i = 0; i < period.getLength(); i++) {
            if(schedule[period.getTime().getDay()-1][period.getTime().getFrom()+i-1]!=null)
                return true;
            else
                return false;
        }
        return true;
    }

    public void addPeriod(Period period){
        for (int i = 0; i < period.getLength(); i++) {
            schedule[period.getTime().getDay()-1][period.getTime().getFrom()+i-1] = period;
        }
    }

    public void printSchedule(){
        for (int i = 0; i < 6 ; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < 12 ; j++) {
                if(schedule[i][j] == null)
                    System.out.print(j+1);
                else
                    schedule[i][j].printMe();
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.makeSchedule();
        schedule.printSchedule();
    }
}


//schedule[lec.getTime().getDay()][lec.getTime().getFrom()]