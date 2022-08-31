package main.java.com.p0a.com.cameramanbrayton.workers;

import main.java.com.p0a.com.cameramanbrayton.workers.users.User;
import main.java.com.p0a.com.cameramanbrayton.workers.users.UserDAO;

import java.util.List;

public class App {

    public static void main( String[] args ) {

        UserDAO userDAO = new UserDAO();

        User newUser = new User();
        newUser.setGiven_name("Scott");
        newUser.setSurname("Stough");
        newUser.setEmail("sco234@revature.com");
        newUser.setUsername("sstough");
        newUser.setPassword("p$$WORD");
        newUser.setSalary(25000);

        int newUserId = userDAO.save(newUser);
        System.out.println(newUserId);

        System.out.println("+---------------------------");

        List<User> users = userDAO.getAllUsers();
        users.forEach(System.out::println);

        /* UPDATE workersapp.workers
                SET given_name='', surname='', email='', username='', "password"='', salary=0
                WHERE id=0;
                 */
    }

}
