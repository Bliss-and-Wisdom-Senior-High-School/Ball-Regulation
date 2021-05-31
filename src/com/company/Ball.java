package com.company;

public class Ball {
    private final String ballName;
    private int courtNum;
    private int ballNum;
    private int batNum;
    private int ballDamaged;

    Ball(String name) {
        ballName = name;
    }

    Ball(String name, int court, int ball, int bat, int dam) {
        ballName = name;
        courtNum = court;
        ballNum = ball;
        batNum = bat;
        ballDamaged = dam;
    }

    public void subBall(int num) {}
    public void addBall(int num) {}
    public void subBat(int num) {}
    public void addBat(int num) {}
    public void subCourt(int num) {}
    public void addCourt(int num) {}

//    public  void setBallName( String str) {  }

    public String getName() {
        return ballName;
    }
    public int getBallNum() {
        return ballNum;
    }
    public int getCourtNum() { return courtNum; }
    public int getBatNum() {
        return batNum;
    }
    public int getBallDamaged() {
        return ballDamaged;
    }
}
