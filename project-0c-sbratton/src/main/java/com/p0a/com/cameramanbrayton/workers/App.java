package main.java.com.p0a.com.cameramanbrayton.workers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    public static void main( String[] args ) {
        String dburl = "jdbc:postgresql://fake-db-url:5432/postgres?currentSchema=workersapp";
        String dbUsername = "fake-user";
        String dbPassword = "fake-password";
        try {
            Connection connection = DriverManager.getConnection(dburl, dbUsername, dbPassword);
            if (connection != null) {
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
