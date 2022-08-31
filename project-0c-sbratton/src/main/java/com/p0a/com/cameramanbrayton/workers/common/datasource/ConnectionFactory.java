package main.java.com.p0a.com.cameramanbrayton.workers.common.datasource;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Implements the Factory and Singleton design patterns
public class ConnectionFactory {

    private static ConnectionFactory connFactory;
    private Properties dbProps = new Properties();

    public ConnectionFactory() {
        try {
            Class.forName("org.postgresql.Driver");
            //dbProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            dbProps.load(new FileReader("project-0c-sbratton/resources/application.properties"));
        } catch (IOException e) {
            // TODO replace RuntimeException with a custom exception
            throw new RuntimeException("Could not read from properties file.", e);
        } catch (ClassNotFoundException e) {
            // TODO replace RuntimeException with a custom exception
            throw new RuntimeException("Failed to load PostgreSQL JDBC driver.", e);
        }
    }

    public static ConnectionFactory getInstance() {
        if (connFactory == null) {
            connFactory = new ConnectionFactory();
        }
        return connFactory;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbProps.getProperty("db-url"), dbProps.getProperty("db-username"), dbProps.getProperty("db-password"));
    }

}
