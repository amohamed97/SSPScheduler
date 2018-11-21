package Model;

public class Lecture extends Period {
    public Lecture(String instName, String courseName, String place, int type, Time time) {
        super(instName, courseName, place, type, time);
        super.periodType = "Lec";
    }
}
