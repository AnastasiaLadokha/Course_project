package ua.stu.entity;

import ua.stu.Walking;
import ua.stu.view.App;

public abstract class Character implements Runnable {

    protected String name;
    protected boolean isFinished;
    protected App app;
    protected Object monitor;

    public Character(String name, boolean isFinished, App app, Object monitor) {
        this.name = name;
        this.isFinished = isFinished;
        this.app = app;
        this.monitor = monitor;
    }

    public String getName() {
        return name;
    }

    public boolean isFinished() {
        return isFinished;
    }

}
