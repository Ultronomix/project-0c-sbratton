package main.java.com.p0a.com.cameramanbrayton.workers.common.screens;

import main.java.com.p0a.com.cameramanbrayton.workers.common.util.AppContext;


import java.io.BufferedReader;
import java.io.IOException;

public class WelcomeScreen extends AbstractScreen {

    public WelcomeScreen(BufferedReader consoleReader) {
        super("WelcomeScreen", consoleReader);
    }

    public WelcomeScreen() {
        super();
    }

    @Override
    public void render() throws IOException {

        System.out.println("+--------------------------------------------------------+");

        String welcomeMenu = "Welcome to the Workers App!\n" +
                "Please make a selection from the options below:\n" +
                "1) Register\n" +
                "2) Login\n" +
                "3) Exit\n" +
                "> ";

        System.out.print(welcomeMenu);

        String userSelection = consoleReader.readLine();

        switch (userSelection) {
            case "1":
                new RegisterScreen(consoleReader).render();
                break;
            case "2":
                new LoginScreen(consoleReader).render();
                break;
            case "3":
                System.out.println("Exiting the application!");
                AppContext.shutdown();
                break;
            default:
                System.out.println("You have made an incorrect selection. Please try again.");
        }
    }

}
