package com.epam.se7.lesson33.pool2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            ConnectionPool.init();
            pool = ConnectionPool.getInstance();
            con = pool.takeConnection();

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }

            pool.releaseConnection(con);
            ConnectionPool.dispose();
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
