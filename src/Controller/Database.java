package Controller;

import java.sql.*;

public class Database {

    public static Connection makeConnection()throws Exception{
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:db/DB.db");
            System.out.println("connected");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("not connected");
        }
        return c;
    }

}
