package Controller;

import Model.*;

import java.sql.*;
import java.util.ArrayList;

public class Input {
    ArrayList<Course> courses = new ArrayList<>();
    Connection c = Database.makeConnection();

    public Input() throws Exception {

    }

    public void read () {
        String s = "SELECT NUM, LEC_INST_NAME, LEC_CRS_NAME, LEC_PLACE, LEC_TYPE, LEC_DAY, LEC_FROM, LEC_TO, LEC_PER_TYPE, " +
                "TUT1_INST_NAME, TUT1_CRS_NAME, TUT1_PLACE, TUT1_TYPE, TUT1_DAY, TUT1_FROM, TUT1_TO, TUT1_PER_TYPE, " +
                "TUT2_INST_NAME, TUT2_CRS_NAME, TUT2_PLACE, TUT2_TYPE, TUT2_DAY, TUT2_FROM, TUT2_TO, TUT2_PER_TYPE, " +
                "LAB1_INST_NAME, LAB1_CRS_NAME, LAB1_PLACE, LAB1_TYPE, LAB1_DAY, LAB1_FROM, LAB1_TO, LAB1_PER_TYPE, " +
                "LAB2_INST_NAME, LAB2_CRS_NAME, LAB2_PLACE, LAB2_TYPE, LAB2_DAY, LAB2_FROM, LAB2_TO, LAB2_PER_TYPE, ";
        try {
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public ArrayList<Course> getCourses () {
        return courses;
    }

}
