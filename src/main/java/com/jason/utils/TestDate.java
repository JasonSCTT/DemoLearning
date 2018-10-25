package com.jason.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by shencheng6 on 2018/10/17.
 */
public class TestDate {
    public static void main(String[] args) {
        System.out.println(dataAdd(new Date(),-90).getTime());
        System.out.println(new Date().getTime());

    }


    public static Date dataAdd(Date date, int delay) {
        Calendar cur = Calendar.getInstance();
        cur.setTime(date);
        cur.add(Calendar.DAY_OF_YEAR, delay);
        return cur.getTime();
    }
}
