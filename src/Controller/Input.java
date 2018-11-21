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

    }

}
