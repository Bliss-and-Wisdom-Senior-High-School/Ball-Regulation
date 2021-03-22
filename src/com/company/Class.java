package com.company;

public class Class {
    private String className;
    private int goodPoint;
    private int badPoint;
    private boolean banned;

    Class (String name) {

    }

    Class (String name, int gPoint, int bPoint, boolean ban) {
        className = name;
        goodPoint = gPoint;
        badPoint = bPoint;
        banned = ban;
    }

    public void add(int num) {}
    public void sub(int num) {}
    public void ban(int day) {}
    public void unban() {}
    public void unban(int day) {}
    public void delay(int day) {}

    public boolean isBanned() {
        return banned;
    }
    public int getGoodPoint() {
        return goodPoint;
    }
    public int getBadPoint() {
        return badPoint;
    }
    public void getBanTime() {}

    public String getClassName() {
        return className;
    }
}
