package com.jorgegiance.folk.util;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.models.Person;

import java.util.ArrayList;

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


    public static ArrayList<Person> createPeopleList(){

        ArrayList<Person> list = new ArrayList<>();

        for (int i = 0; i < 50 ; i++) {

            Person person =  new Person();
            person.setPositionTitle("Sec. of Agriculture");
            person.setName("Alexander, Lamar");
            person.setPhotoLink("https://www.alexander.senate.gov/public/_cache/files/e6fc1af2-9158-414a-b2ad-bbd4c111ec90/alexander-lamar-rgb-2400-3600.jpg");

            list.add(person);

        }

        return list;
    }
}
