package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class School {
    private ArrayList<Class> classes= new ArrayList<Class>();
    private ArrayList<Ball> balls = new ArrayList<Ball>();
    private ArrayList<His> history = new ArrayList<His>();




    Calendar now = Calendar.getInstance();

    School() {//??
        String []schoolDefault = new String[]{"高三忠", "高三孝", "高二忠", "高二孝", "高一忠", "高一孝", "國三忠", "國三孝", "國二忠", "國二孝", "國一忠", "國一孝"};
        for (int i=0; i<12; i++) {
            classes.add(new Class(schoolDefault[i], 0, 0, false));
        }
        String []ballDefault = new String[] { "排球", "桌球", "羽球"};
        for (int i=0; i<ballDefault.length;i++) {
            balls.add(new Ball(ballDefault[i], 6, 20, 20, 0));
        }
    }

    void pushHis(String [][]cls) {
        now = Calendar.getInstance();
        history.add(new His(now, this, cls));
    }

    void clearBall() {balls.clear();}

    void addClass (Class cls){
        classes.add(cls);
    }
    void addBall(Ball bal){ balls.add(bal); }
    void subClass (Class cls){
        classes.remove(classes.indexOf(cls));
    }
    void subBall(Ball bal){ balls.remove(balls.indexOf(bal)); }
    int getBallKinds(){return balls.size();}
    int getClassNum(){return classes.size();}
    Class getClass(int i){return classes.get(i);}
    Class getClass(String str) {
        for (Class cls : classes) {
            if (Objects.equals(cls.getName(), str))
                return cls;
        }
        return null;
    }
    Ball getBall(int i ) { return balls.get(i);}
    Ball getBall(String ballName) {
        for (Ball ball : balls) {
            if (Objects.equals(ball.getName(), ballName))
                return ball;
        }
        return null;
    }

    Class[] getJunior() {
        ArrayList<Class> cls= new ArrayList<Class>();
        for (Class c : classes) {
            if ( String.valueOf(c.getName().toCharArray()[0]).equals("國"))
                cls.add(c);
        }
        return cls.toArray(new Class[cls.size()]);
    }

    Class[] getSenior() {
        ArrayList<Class> cls= new ArrayList<Class>();
        for (Class c : classes) {
            if ( String.valueOf(c.getName().toCharArray()[0]).equals("高"))
                cls.add(c);
        }
        return cls.toArray(Class[]::new);
    }

    String getYear(){return String.valueOf(now.get(Calendar.YEAR)-1911);} //民國
    String getMonth(){return String.valueOf(now.get(Calendar.MONTH)+1);}//月
    String getDate(){return String.valueOf(now.get(Calendar.DATE));}//日
    String getDay(){
        String str = new String();
        switch (now.get(Calendar.DAY_OF_WEEK)){
            case 1->{str="日";}
            case 2->{str="一";}
            case 3->{str="二";}
            case 4->{str="三";}
            case 5->{str="四";}
            case 6->{str="五";}
            case 7->{str="六";}
        }
        return str;
    }

}
