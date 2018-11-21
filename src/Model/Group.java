package Model;

public class Group {
    Lecture lecture;
    Tutorial tutorial;
    Lab lab;
    int number;

    public Group(Lecture lecture, Tutorial tutorial, Lab lab, int number) {
        this.lecture = lecture;
        this.tutorial = tutorial;
        this.lab = lab;
        this.number = number;
    }

    public Group(Lecture lecture, Tutorial tutorial, int number) {
        this.lecture = lecture;
        this.tutorial = tutorial;
        this.number = number;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public Lab getLab() {
        return lab;
    }

    public int getNumber() {
        return number;
    }
}
