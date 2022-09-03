package main.java.com.p0a.com.cameramanbrayton.workers.common.screens;

import java.io.BufferedReader;

public abstract class AbstractScreen implements Screen {

    protected String name;
    protected BufferedReader consoleReader;

    public AbstractScreen(String name, BufferedReader consoleReader) {
        this.name = name;
        this.consoleReader = consoleReader;
    }

    public AbstractScreen() {

    }

    public String getName() {
        return name;
    }

}


