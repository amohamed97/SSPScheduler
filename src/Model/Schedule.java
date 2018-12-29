package Model;

import Controller.Input;

import java.util.ArrayList;
import java.util.Comparator;

public class Schedule {
    public Period[][] schedule = new Period[6][12];
    Input input;
    Boolean[] days = new Boolean[]{false,false,false,false,false,false};
    int daysTaken;
    int priorityValue;

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
         if(!days[period.getTime().getDay()]){
            daysTaken++;
            days[period.getTime().getDay()] = true;
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

    public int getDaysTaken() {
        return daysTaken;
    }

    public int getPriorityValue() {
        return priorityValue;
    }

    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public void addToPriorityValue(int value){
        this.priorityValue+=value;
    }

    public void clone(Schedule schedule) {
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 12 ; j++){
                this.schedule[i][j] = schedule.getSchedule()[i][j];
            }
        }
        this.priorityValue = schedule.getPriorityValue();
        this.daysTaken = schedule.getDaysTaken();
        for(int i = 0 ; i < 6 ; i++){
            this.days[i] = schedule.getDays()[i];
        }
    }

    public Boolean[] getDays() {
        return days;
    }

    public void setDays(Boolean[] days) {
        this.days = days;
    }
}