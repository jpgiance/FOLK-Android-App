package com.jorgegiance.folks.util;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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

    public static String parseName(String lastName, String firsName){
        return lastName + ", " + firsName;
    }


    public static String congressPhotoId(String id){
        return "https://bioguideretro.congress.gov/Static_Files/images/photos/" + id.charAt(0) + "/" + id + ".jpg";
    }


    public static String parseParty(String party){
        switch (party){
            case "R":
                return "Rep.";
            case "D":
                return "Dem.";
            case "I":
                return "Ind.";
            case "L":
                return "Lib.";
            case "ID":
                return "Ind. and Dem.";
            case "IR":
                return "Ind. and Rep.";
            case "IL":
                return "Ind. and Lib.";
            case "G":
                return "Green";
            default:
                return party;
        }
    }




    public static String stateCode(String state){

        final Map<String, String> states = new HashMap<>();

        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CT");
        states.put("Delaware", "DE");
        states.put("District of Columbia", "DC");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Rhode Island", "RI");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");

        return states.get(state);
    }

    public static String time2Date( long time){

        @SuppressLint("SimpleDateFormat") DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return  (formatter.format(calendar.getTime()));
    }

}
