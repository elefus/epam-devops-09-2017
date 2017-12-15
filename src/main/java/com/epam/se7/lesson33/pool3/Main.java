package com.epam.se7.lesson33.pool3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        ConnectionPool pool;
        Connection con;
        Statement st = null;
        ResultSet rs = null;
        try {
            pool = ConnectionPool.getInstance("org.gjt.mm.mysql.Driver", "jdbc:mysql://127.0.0.1/test","root", "123456", 5);
            con = pool.getConnection();

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            con.close();
            pool.freeConnection(con);
            pool.release();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) st.close();
                if (rs != null) rs.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}