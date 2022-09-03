package main.java.com.p0a.com.cameramanbrayton.workers.common.screens;

import main.java.com.p0a.com.cameramanbrayton.workers.users.User;
import main.java.com.p0a.com.cameramanbrayton.workers.users.UserDAO;

import java.io.BufferedReader;
import java.io.IOException;

public class RegisterScreen extends AbstractScreen {

    public RegisterScreen(BufferedReader consoleReader) {
        super("RegisterScreen", consoleReader);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Please provide some information to register an account");

        User newUser = new User();

        // UI Logic
        boolean formComplete = false;
        while (!formComplete) {

            System.out.print("Given name (must not be empty) > ");
            String givenName = consoleReader.readLine();

            String RED_TEXT = "\u001B[31m";
            String RESET_TEXT = "\u001B[0m";
            if (givenName == null || givenName.trim().equals("")) {
                System.out.println(RED_TEXT + "Invalid given name provided. Returning to top of form" + RESET_TEXT);
                continue;
            }

            newUser.setGiven_name(givenName);

            System.out.print("Surname (must not be empty) > ");
            String surname = consoleReader.readLine();

            if (surname == null || surname.trim().equals("")) {
                System.out.println(RED_TEXT + "Invalid surname provided. Returning to top of form" + RESET_TEXT);
                continue;
            }

            newUser.setSurname(surname);

            System.out.print("Email address (must be unique) > ");
            String email = consoleReader.readLine();

            if (email == null || email.trim().equals("") || !email.contains("@")) {
                System.out.println(RED_TEXT + "Invalid email address provided. Returning to top of form" + RESET_TEXT);
                continue;
            }

            newUser.setEmail(email);

            System.out.print("Username (must be unique and at least 4 characters) > ");
            String username = consoleReader.readLine();

            if (username == null || username.trim().length() < 4) {
                System.out.println(RED_TEXT + "Invalid username provided. Returning to top of form" + RESET_TEXT);
                continue;
            }

            newUser.setUsername(username);

            System.out.print("Password (must be at least 8 characters) > ");
            String password = consoleReader.readLine();

            if (password == null || password.trim().length() < 8) {
                System.out.println(RED_TEXT + "Invalid password provided. Returning to top of form" + RESET_TEXT);
                continue;
            }

            newUser.setPassword(password);

            formComplete = true;

        }

        UserDAO userDAO = new UserDAO();
        int newUserId = userDAO.save(newUser);

        System.out.println("User successfully persisted! Generated id: " + newUserId);

    }

}
