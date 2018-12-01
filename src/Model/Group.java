package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

public class Group {
    Lecture lecture;
    ArrayList<Tutorial> tutorials = new ArrayList<>();
    ArrayList<Lab> labs = new ArrayList<>();
    int number;
    Set<Integer> daysTaken;
    boolean available;

    public Group(Lecture lecture, ArrayList<Tutorial> tutorilas, ArrayList<Lab> labs, int number) {
        this.lecture = lecture;
        this.tutorials = tutorials;
        this.labs = labs;
        this.number = number;
    }

    public Group(Lecture lecture, ArrayList<Tutorial> tutorials, int number) {
        this.lecture = lecture;
        this.tutorials = tutorials;
        this.number = number;
    }

    public Group(){
        daysTaken = new HashSet<>();
        available = true;
    }

    public Lecture getLecture() {
        return lecture;
    }

      public ArrayList<Tutorial> getTutorials() {
        return tutorials;
    }

    public ArrayList<Lab> getLabs() {
        return labs;
    }

    public int getNumber() {
        return number;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
        daysTaken.add(lecture.getTime().getDay());
    }

    public void setTutorials(ArrayList<Tutorial> tutorials) {
        this.tutorials = tutorials;
        for (int i = 0; i < tutorials.size() ; i++) {
            daysTaken.add(tutorials.get(i).getTime().getDay());
        }
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
        for (int i = 0; i < labs.size() ; i++) {
            daysTaken.add(labs.get(i).getTime().getDay());
        }
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addTutorial(Tutorial tutorial){
        tutorials.add(tutorial);
        daysTaken.add(tutorial.getTime().getDay());
    }
    public void addLab(Lab lab){
        labs.add(lab);
        daysTaken.add(lab.getTime().getDay());
    }

    public void clean() {
        tutorials.clear();
        labs.clear();
        number = 0;
    }

    public Set<Integer> getDaysTaken() {
        return daysTaken;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setDaysTaken(Set<Integer> daysTaken) {
        this.daysTaken = daysTaken;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
