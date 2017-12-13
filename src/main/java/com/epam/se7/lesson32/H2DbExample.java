package com.epam.se7.lesson32;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class H2DbExample {

    public static void main(String[] args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:~/university", "sa", "");
        Statement statement = connection.createStatement();
        statement.execute("USE UNIVERSITY");
        getDepartments(statement);

        int modified = statement.executeUpdate("INSERT INTO DEPARTMENTS (ID, NAME, ACRONYM) VALUES (4, 'ФКТИ2', 'ФКТИ2')");
        System.out.println(modified);
        getDepartments(statement);





    }

    private static void getDepartments(Statement statement) throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM DEPARTMENTS;");
        while (result.next()) {
            System.out.println(result.getInt("ID") + " " + result.getString("NAME") + " " + result.getString( "ACRONYM"));
        }
    }

}
