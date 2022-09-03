package main.java.com.p0a.com.cameramanbrayton.workers.users;

import main.java.com.p0a.com.cameramanbrayton.workers.common.datasource.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDAO {

    public List<User> getAllUsers() {

        String sql = "SELECT id, given_name, surname, email, username, \"password\", salary\n" +
                "FROM workersapp.workers;\n ";

        List<User> allUsers = new ArrayList<>();

        try {
            //assert ConnectionFactory.getInstance() != null;
            try (Connection connection = ConnectionFactory.getInstance().getConnection()) {

                // JDBC Statement objects are subject to SQL Injections
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    User user = new User();
                    user.setId(Integer.parseInt(String.valueOf(resultSet.getInt("id"))));
                    user.setGiven_name(resultSet.getString("given_name"));
                    user.setSurname(resultSet.getString("surname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setUsername(resultSet.getString("username"));
                    user.setPassword("***********"); // done for security purpose
                    user.setSalary(resultSet.getInt("salary"));
                    allUsers.add(user);
                }

            }
        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database!");
            e.printStackTrace();
        }

        return allUsers;

    }
    public int save(User user) {
        String sql = "INSERT INTO workersapp.workers" +
                "(given_name, surname, email, username, password, salary)" +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {



            PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"id"});
            //pstmt.setObject(1, user.getId());
            pstmt.setString(1, user.getGiven_name());
            pstmt.setString(2, user.getSurname());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUsername());
            pstmt.setString(5, user.getPassword());
            pstmt.setInt(6, user.getSalary());

            pstmt.executeUpdate();

            //conn.commit();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt("id"));

        } catch (SQLException e) {
            System.err.println("Something went wrong when communicating with the database");
            e.printStackTrace();
        }
        return user.getId();
    }
}









