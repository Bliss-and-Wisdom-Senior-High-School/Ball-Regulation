package com.company;

public class Class {
    private String className;
    private int goodPoint;
    private int badPoint;
    private boolean banned;
    private int count;

    Class (String name) {

    }

    Class (String name, int gPoint, int bPoint, boolean ban) {
        className = name;
        goodPoint = gPoint;
        badPoint = bPoint;
        banned = ban;
        count = 0;
    }

    public void add(int num) {}
    public void sub(int num) {}
    public void ban(int day) {}
    public void unban() {}
    public void unban(int day) {}
    public void delay(int day) {}
    public void setCount() { count++; }
    public void clearCount() { count=0; }
    public  void addGoodPoint(){goodPoint++;}
    public  void addBadPoint(){badPoint++;}
    public void balance() {//??抵消
        goodPoint = Math.max(goodPoint - badPoint, 0);
        badPoint = Math.max(badPoint - goodPoint, 0);
    }

    public void setBadPoint(int badPoint) {
        this.badPoint = badPoint;
    }

    public void setGoodPoint(int goodPoint) {
        this.goodPoint = goodPoint;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() { return className; }
    public int getCount() {
        return count;
    }
    public boolean isBanned() {
        return banned;
    }
    public int getGoodPoint() {
        return goodPoint;
    }
    public int getBadPoint() {
        return badPoint;
    }
    public String getBanned() {
        if (banned) return "禁球中";
        return "正常借球";
    }
    public void getBanTime() {}

    public String getClassName() {
        return className;
    }
}
