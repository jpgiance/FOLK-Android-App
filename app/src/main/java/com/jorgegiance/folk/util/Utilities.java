package com.jorgegiance.folk.util;

public class Utilities {

    public static String time2String(long time){

        long seconds = System.currentTimeMillis()/1000 - time/1000;

        if (seconds > 86400){
            return String.valueOf((int) seconds/86400) + "d" + " ago";
        }
        else if (seconds > 3600){
            return String.valueOf((int) seconds/3600) + "h" + " ago";
        }
        else if (seconds > 60){
            return String.valueOf((int) seconds/60) + "m" + " ago";
        }else {
            return seconds + "s" + " ago";
        }


    }
}
