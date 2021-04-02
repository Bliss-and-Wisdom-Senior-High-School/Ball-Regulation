package com.company;

import java.util.ArrayList;
import java.util.Calendar;

public class School {
    private ArrayList<Class>  classes= new ArrayList<Class>();
    private ArrayList<Ball> balls = new ArrayList<Ball>();

    Calendar now = Calendar.getInstance();

    School() {
 
    }

    void addClass (Class cls){
        classes.add(cls);
    }
    void addBall(Ball bal){ balls.add(bal); }
    int getBallKinds(){return balls.size();}
    int getClassNum(){return classes.size();}

    String getYear(){return String.valueOf(now.get(Calendar.YEAR)-1911);} //民國
    String getMonth(){return String.valueOf(now.get(Calendar.MONTH)+1);}//月
    String getDate(){return String.valueOf(now.get(Calendar.DATE));}
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
