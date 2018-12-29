package Controller;

import Model.*;
import Model.Time;

import java.sql.*;
import java.util.ArrayList;

public class Input {
    ArrayList<Course> courses = new ArrayList();
    ArrayList<Instructor> insts = new ArrayList();
    ArrayList<Group> gs = new ArrayList();
    Connection c = Database.makeConnection();

    public Input() throws Exception {
        read();
        create();
    }

    public void read () {
        String s = "SELECT NUM, LEC_INST_NAME, LEC_CRS_NAME, LEC_PLACE, LEC_TYPE, LEC_DAY, LEC_FROM, LEC_TO, LEC_PER_TYPE, " +
                "TUT1_INST_NAME, TUT1_CRS_NAME, TUT1_PLACE, TUT1_TYPE, TUT1_DAY, TUT1_FROM, TUT1_TO, TUT1_PER_TYPE, " +
                "TUT2_INST_NAME, TUT2_CRS_NAME, TUT2_PLACE, TUT2_TYPE, TUT2_DAY, TUT2_FROM, TUT2_TO, TUT2_PER_TYPE, " +
                "LAB1_INST_NAME, LAB1_CRS_NAME, LAB1_PLACE, LAB1_TYPE, LAB1_DAY, LAB1_FROM, LAB1_TO, LAB1_PER_TYPE, " +
                "LAB2_INST_NAME, LAB2_CRS_NAME, LAB2_PLACE, LAB2_TYPE, LAB2_DAY, LAB2_FROM, LAB2_TO, LAB2_PER_TYPE FROM GROUPS";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(s);


            while (rs.next()) {
                Group g = new Group();
                Time t = new Time();
                g.setNumber(rs.getInt("NUM"));
                Lecture l = new Lecture();
                l.setInstName(rs.getString("LEC_INST_NAME"));
                l.setCourseName(rs.getString("LEC_CRS_NAME"));
                l.setPlace(rs.getString("LEC_PLACE"));
                l.setType(rs.getInt("LEC_TYPE"));
                t.setDay(rs.getInt("LEC_DAY"));
                t.setFrom(rs.getInt("LEC_FROM"));
                t.setTo(rs.getInt("LEC_TO"));
                l.setTime(t);
                l.setPeriodType(rs.getString("LEC_PER_TYPE"));
                g.setLecture(l);

                Tutorial tut = new Tutorial();
                t = new Time();
                tut.setInstName(rs.getString("TUT1_INST_NAME"));
                tut.setCourseName(rs.getString("TUT1_CRS_NAME"));
                tut.setPlace(rs.getString("TUT1_PLACE"));
                tut.setType(rs.getInt("TUT1_TYPE"));
                t.setDay(rs.getInt("TUT1_DAY"));
                t.setFrom(rs.getInt("TUT1_FROM"));
                t.setTo(rs.getInt("TUT1_TO"));
                tut.setTime(t);
                tut.setPeriodType(rs.getString("TUT1_PER_TYPE"));
                if(!tut.getCourseName().equals(""))
                    g.addTutorial(tut);

                tut = new Tutorial();
                t = new Time();
                tut.setInstName(rs.getString("TUT2_INST_NAME"));
                tut.setCourseName(rs.getString("TUT2_CRS_NAME"));
                tut.setPlace(rs.getString("TUT2_PLACE"));
                tut.setType(rs.getInt("TUT2_TYPE"));
                t.setDay(rs.getInt("TUT2_DAY"));
                t.setFrom(rs.getInt("TUT2_FROM"));
                t.setTo(rs.getInt("TUT2_TO"));
                tut.setTime(t);
                tut.setPeriodType(rs.getString("TUT2_PER_TYPE"));
                if(!tut.getCourseName().equals(""))
                    g.addTutorial(tut);



                Lab lab = new Lab();
                t = new Time();
                lab.setInstName(rs.getString("LAB1_INST_NAME"));
                lab.setCourseName(rs.getString("LAB1_CRS_NAME"));
                lab.setPlace(rs.getString("LAB1_PLACE"));
                lab.setType(rs.getInt("LAB1_TYPE"));
                t.setDay(rs.getInt("LAB1_DAY"));
                t.setFrom(rs.getInt("LAB1_FROM"));
                t.setTo(rs.getInt("LAB1_TO"));
                lab.setTime(t);
                lab.setPeriodType(rs.getString("LAB1_PER_TYPE"));
                if(!lab.getCourseName().equals(""))
                    g.addLab(lab);

                lab = new Lab();
                t = new Time();
                lab.setInstName(rs.getString("LAB2_INST_NAME"));
                lab.setCourseName(rs.getString("LAB2_CRS_NAME"));
                lab.setPlace(rs.getString("LAB2_PLACE"));
                lab.setType(rs.getInt("LAB2_TYPE"));
                t.setDay(rs.getInt("LAB2_DAY"));
                t.setFrom(rs.getInt("LAB2_FROM"));
                t.setTo(rs.getInt("LAB2_TO"));
                lab.setTime(t);
                lab.setPeriodType(rs.getString("LAB2_PER_TYPE"));
                if(!lab.getCourseName().equals(""))
                    g.addLab(lab);

                gs.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void create(){
        for (int i = 0; i <gs.size() ; i++) {
            Group g = gs.get(i);
            insts.add(new Instructor(g.getLecture().getInstName(),g.getLecture().getCourseName(),g));
        }
        Instructor inst;
        for (int i = 0; i <insts.size() ; i++) {
            inst = insts.get(i);
            for (int j = i+1; j <insts.size() ; j++) {
                if(inst.getName().equals(insts.get(j).getName()) && inst.getCourseName().equals(insts.get(j).getCourseName())){
                    inst.addGroup(insts.get(j).getGroups().get(0));
                    insts.remove(j);
                    j--;
                }
            }
        }
        courses.add(new Course(insts.get(0).getCourseName(),insts.get(0)));
        boolean check = true;
        for (int i = 1; i < insts.size() ; i++) {
            inst = insts.get(i);
            int n = courses.size();
            for (int j = 0; j < n ; j++) {
                if(inst.getCourseName().equals(courses.get(j).getName())){
                    courses.get(j).addInstructor(inst);
                    check = false;
                }
            }
            if(check){
                courses.add(new Course(inst.getCourseName(),inst));
            }
            check = true;
        }
    }

    public ArrayList<Course> getCourses () {
        return courses;
    }

    public ArrayList<Instructor> getInstructors() {
        return insts;
    }
}