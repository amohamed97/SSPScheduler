package Controller;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class Input {
    Connection c;

    {
        try {
            c = Database.makeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ArrayList<Course> courses = new ArrayList<>();

    Input(){
        ArrayList<Group> groups1 = new ArrayList<>();
        ArrayList<Instructor> instructors1 = new ArrayList<>();
        Group group11 = new Group(
                new Lecture("Layla","Organization","P41",1, new Model.Time(1,3,1)),
                new Tutorial("Fatma","Organization","P45",2,new Model.Time(5,6,3)),1);
        Group group12 = new Group(new Lecture("Layla","Organization","C27",1, new Model.Time(7,8,4)),
                new Tutorial("Fatma","Organization","C40",2,new Model.Time(1,2,5)),2);
        groups1.add(group11);
        groups1.add(group12);
        Instructor instructor1 = new Instructor("Layla",groups1);
        instructors1.add(instructor1);
        Course course1 = new Course("Organization",instructors1);

        ArrayList<Group> groups2 = new ArrayList<>();
        ArrayList<Instructor> instructors2 = new ArrayList<>();
        Group group21 = new Group(new Lecture("Ragal","Control","P41",1, new Model.Time(2,4,1)),
                new Tutorial("Heba","Control","P45",2,new Model.Time(5,6,3)),1);
        Group group22 = new Group(new Lecture("Ragal","Control","C27",1, new Model.Time(7,8,5)),
                new Tutorial("Heba","Control","C40",2,new Model.Time(1,2,2)),2);
        groups2.add(group21);
        groups2.add(group22);
        Instructor instructor2 = new Instructor("Ragal",groups2);
        instructors2.add(instructor2);
        Course course2 = new Course("Control",instructors2);
        courses.add(course1);
        courses.add(course2);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
