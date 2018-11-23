package Model;

import java.util.ArrayList;

public class Group {
    Lecture lecture;
    ArrayList<Tutorial> tutorials = new ArrayList<>();
    ArrayList<Lab> labs = new ArrayList<>();
    int number;

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
    }

    public void setTutorials(ArrayList<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }

    public void setLabs(ArrayList<Lab> labs) {
        this.labs = labs;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void addTutorial(Tutorial tutorial){
        tutorials.add(tutorial);
    }
    public void addLab(Lab lab){
        labs.add(lab);
    }

    public void clean() {
        tutorials.clear();
        labs.clear();
        number = 0;
    }
}
