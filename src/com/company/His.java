package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class His {
    private Calendar time;

    private ArrayList<ArrayList<String>> hisCourt = new ArrayList<>();

    His(Calendar t, School s, ArrayList<ArrayList<String>> arrayList){
        time = t;
//        for (int i=0; i<s.getBallKinds();i++){
//            ArrayList<String> temp = new ArrayList<>();
//            for (int j=0; j<s.getBall(i).getCourtNum(); j++)
//                temp.add(cls[i][j]);
//            hisCourt.add(temp);
//        }
        hisCourt = arrayList;

    }

    public void update( School sch, String crt, String cls) {
        for (int i=0; i< sch.getBallKinds(); i++)
            if (crt.contains(sch.getBall(i).getName()))
                hisCourt.get(i).add(cls);

    }


    public Class getCourt ( School sch, String crt , int index) {
        for (int i=0; i<sch.getBallKinds(); i++) {
            if (Objects.equals(sch.getBall(i).getName(), crt))
                return sch.getClass(hisCourt.get(i).get(index));
        }
        return null;
    }

    public Calendar getTime() {
        return time;
    }

}
