package com.epam.se7.lesson32;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2DbExample {

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test1", "sa", "");

        Statement st = conn.createStatement();
        st.execute("DROP TABLE STUDENTS IF EXISTS");
        st.execute("CREATE TABLE STUDENTS(ID INT PRIMARY KEY, NAME VARCHAR(255),  HOBBY VARCHAR(255));");
        st.execute("INSERT INTO STUDENTS VALUES(1, 'Ivanov', '');");
        st.execute("INSERT INTO STUDENTS VALUES(2, 'Petrov', 'Swim');");
        st.execute("INSERT INTO STUDENTS VALUES(3, 'Sidorov', '');");
        st.execute("INSERT INTO STUDENTS VALUES(4, 'Andreev', 'Wrestling');");

        ResultSet result = st.executeQuery("SELECT * FROM STUDENTS");

        String id = "", name = "", hobby = "";

        while (result.next()) {
            id = result.getString("ID");
            name = result.getString("NAME");
            hobby = result.getString("HOBBY");


            if (hobby.equals("")) {
                hobby = "Нет хобби";
            }
            System.out.printf("%3s | %-10s | %-10s \n", id, name, hobby);
        }
    }

}
