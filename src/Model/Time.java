package Model;

public class Time {
    int day;
    int from;
    int to;

    public Time(int from, int to, int day) {

        this.from = from;
        this.to = to;
        this.day = day;
    }

    public Time(){

    }

    public int getDay() {
        return day;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
