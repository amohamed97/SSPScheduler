public class Time {
    int day;
    int from;
    int to;

    public Time(int from, int to, int day) {

        this.from = from;
        this.to = to;
        this.day = day;
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
}
