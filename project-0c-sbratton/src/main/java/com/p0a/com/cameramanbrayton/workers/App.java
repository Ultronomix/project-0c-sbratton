package main.java.com.p0a.com.cameramanbrayton.workers;

import main.java.com.p0a.com.cameramanbrayton.workers.common.datasource.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main( String[] args ) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try {
            Connection connection = connectionFactory.getConnection();
            if (connection != null) {
                System.out.println("Connection successful!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
