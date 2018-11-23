package Model;

public class Lab extends Period {

    public Lab(String instName, String courseName, String place, int type, Time time) {
        super(instName, courseName, place, type, time);
        super.periodType = "Model.Lab";
    }

    public Lab() {
    }
}
