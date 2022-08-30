package main.java.com.p0a.com.cameramanbrayton.workers;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class App {

    public static void main( String[] args ) {


        Properties dbProps = new Properties();
        try {
            dbProps.load(new FileReader("project-0c-sbratton/resources/application.properties"));
            //dbProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection(dbProps.getProperty("db-url"), dbProps.getProperty("db-username"), dbProps.getProperty("db-password"));
            if (connection != null) {
                System.out.println("Connection successful");
            }
        } catch (SQLException e) {
            System.err.println("Could not establish a connection to the database");
        }

    }
}
