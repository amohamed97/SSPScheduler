public abstract class Period {
    String instName;
    String courseName;
    String place;
    int type;
    Time time;
    int length;
    String periodType;

    public Period(String instName, String courseName, String place, int type, Time time) {
        this.instName = instName;
        this.courseName = courseName;
        this.place = place;
        this.type = type;
        this.time = time;
        this.length = time.to - time.from + 1;
    }

    public String getInstName() {
        return instName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getPlace() {
        return place;
    }

    public int getType() {
        return type;
    }

    public Time getTime() {
        return time;
    }

    public int getLength() {
        return length;
    }

    public void printMe(){
        System.out.print(courseName+"-"+periodType+" ");
    }
}
