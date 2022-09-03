package main.java.com.p0a.com.cameramanbrayton.workers.common.screens;

import java.io.BufferedReader;
import java.io.IOException;

public class LoginScreen extends AbstractScreen {

    public LoginScreen(BufferedReader consoleReader) {
        super("LoginScreen", consoleReader);
    }

    @Override
    public void render() throws IOException {
        System.out.println("Login screen works!");
    }
}