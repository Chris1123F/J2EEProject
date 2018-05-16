package com.nju.training.logic;

import java.text.DecimalFormat;

public class StudentLogic {
    public int calStudentLevel(double consume){
        int level=0;
        int count=1;
        while(consume>0){
            consume=consume-1000*count;
            count++;
            level=level+1;
        }
        return level;
    }

    public int getPoint(double orderprice){
        return (int)Math.floor(orderprice);
    }

    public double getPriceByLevel(int level,double initialPrice){
        double x=level;
        double y=level+7;
        double count =x/y;
        double lastPrice=(1-count)*initialPrice;
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.valueOf(df.format(lastPrice));

    }

}
