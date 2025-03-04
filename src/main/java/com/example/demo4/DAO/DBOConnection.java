package com.example.demo4.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOConnection {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 3306;
    private static final String DBNAME = "jdbc_course_data";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;
    public static Connection getConnection() {
        // JDBC:mysql://lcalhost/jdbc_course_data
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DBNAME), USER, PASSWORD);
        }catch (SQLException es) {
            es.printStackTrace();
        }
        return connection;
    }



}
