package Model;

public abstract class Period {
    int gNum;
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

    public Period(){

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
        String str = "("+gNum+")"+courseName+"-"+periodType;
        System.out.print(str);
        for (int i = 0; i < 38-str.length(); i++) {
            System.out.print(" ");
        }
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setTime(Time time) {
        this.time = time;
        this.length = time.to - time.from + 1;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setPeriodType(String periodType) {
        this.periodType = periodType;
    }

    public String getPeriodType() {
        return periodType;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }
}

