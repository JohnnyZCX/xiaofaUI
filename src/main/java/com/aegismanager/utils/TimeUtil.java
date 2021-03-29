package com.aegismanager.utils;

import java.util.Calendar;

public class TimeUtil {
    public static String getCurTimeString() {
        java.util.Date date = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return "" + c.get(Calendar.YEAR) + (c.get(Calendar.MONTH)+1) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR_OF_DAY)+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND);
    }
}
