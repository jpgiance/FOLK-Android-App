package com.jorgegiance.folks.util;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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


    public static String photoUrl(String name){
        final Map<String, String> photoUrls = new HashMap<>();

        photoUrls.put("Ron DeSantis", "https://upload.wikimedia.org/wikipedia/commons/a/aa/Ron_DeSantis%2C_Official_Portrait%2C_113th_Congress.jpg");
        photoUrls.put("Jeanette Nuñez", "https://www.flgov.com/wp-content/uploads/2019/06/LG-Bio.jpg");
        photoUrls.put("Charles T. Canady", "https://www.floridasupremecourt.org/var/site/storage/images/media/images/images-supreme-court/2019-canady-headshot-300/4681229-1-eng-US/2019-Canady-Headshot-300.jpg");
        photoUrls.put("Jimmy Patronis", "https://unfspinnaker.com/wp-content/uploads/2018/11/PatronisPage.jpg");
        photoUrls.put("Jorge Labarga", "https://www.floridasupremecourt.org/var/site/storage/images/media/images/images-supreme-court/2019-labarga-headshot-300/4681235-1-eng-US/2019-Labarga-Headshot-300_large.jpg");
        photoUrls.put("Ricky Polston", "https://upload.wikimedia.org/wikipedia/commons/d/d1/Florida-Supreme-Court-Justice-Ricky-Polston-2019.jpg");
        photoUrls.put("Carlos G. Muñiz", "https://www.floridasupremecourt.org/var/site/storage/images/media/images/images-supreme-court/2019-muniz-headshot-300/4681265-1-eng-US/2019-Muniz-Headshot-300.jpg");
        photoUrls.put("Alan Lawson", "https://www.floridasupremecourt.org/var/site/storage/images/media/images/images-supreme-court/2019-lawson-headshot-300/4681247-1-eng-US/2019-Lawson-Headshot-300.jpg");
        photoUrls.put("Ashley Moody", "https://upload.wikimedia.org/wikipedia/commons/a/a0/AttorneyGeneral_AshleyMoody.jpg");
        photoUrls.put("Nicole \"Nikki\" Fried", "https://tallahasseereports.com/wp-content/uploads/2019/06/Official_photo_of_Nikki_Fried.jpg");
        photoUrls.put("Chip Roy", "https://www.congress.gov/img/member/r000614.jpg");
        photoUrls.put("Erin Zwiener", "https://kylebudadems.com/wp-content/uploads/2018/08/DSC_0348.jpg");
        photoUrls.put("Lon Shell", "https://hayscountytx.com/wp-content/uploads/sites/69/2018/08/Commissioner-Lon-Shell-Precinct-3.png");
        photoUrls.put("Beverly Crumley", "https://www.sanmarcosrecord.com/sites/sanmarcosrecord.etypegoogle4.com/files/styles/juicebox_large/public/field/image/beverly_crumley_photo_-_district_clerk.jpg?itok=MS8c9VUq");
        photoUrls.put("Ruben Becerra", "https://pbs.twimg.com/profile_images/1248464156082102275/9TLyLwEu_400x400.jpg");
        photoUrls.put("Jenifer O'Kane", "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxMSEhUTExIVFRUWFxUVFRcVFRUXFxUVFRUWFhUVFRUYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGy0lHSAuLS8tLS0tLS0tLS0tLy0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLSstLS0rLf/AABEIAOEA4QMBIgACEQEDEQH/xAAcAAAABwEBAAAAAAAAAAAAAAAAAQMEBQYHAgj/xABLEAABAwICBQcHCQUHAwUAAAABAAIDBBEFIQYSMUFREyJhcYGRoQcyUpKxwdEUFkJTYnKC4fAjJDOy0hU0Q1STosIXc6NEY7PT8f/EABoBAAIDAQEAAAAAAAAAAAAAAAIDAAEEBQb/xAAqEQACAgEEAgIBAwUBAAAAAAAAAQIRAwQSITEiQRNRMmGRoQVCUnGBI//aAAwDAQACEQMRAD8A3BBBBQgTtir2H5NIII5z9o+0VYJfNPUV50xjSitbVagqpQ2wyDjZU1ZTVm4u1OA7k3n1OAWRs0hqrf3iX1klJpBVf5iTvSw1iZrD9ToSDgzgFkU2klWP8d/h8E1fpNWfXu7m/BXyX8ZsD2R8GpF0cfBqx86T1f17u5nwRfOis+vPqs/pUplbDYBqt2WCicTfzwftD+VZp86av64+qz4Jem0irHuDQ8OJO9jT7lNrJRpkjGuHOslqKeGMElzWjpcB7VTnYpI0BpPKPsdawAAO4ZKuYjWTgkmNx69nYqSZe016kroX3DJGE8A9pPcEhK1t1jcVQXZjm59NgengpeHSGojFtcnhrWdbqJUaZNn0aa1oRkN6FmB0sq9z2H8H5rn521fGP/T/ADU2sE086q6aWjesuGl9Vxj/ANP80Y0vq+MX+n+amxkLhp/KDQTWO+Mf72pl5ODaEX+ud/8AG0KpYppDUVEZifqapsTqsscjcZ3QwfHp6ZmpGWEXLuc25uQAcwRwCva6os1+pYHOzHtRtjbwWXfPar4Reof6kfz5q+EXqO/qQ7GSzQXxtvsQETeCzv571Xow+o7+pEdN6r0IfVd/UpsZdo0YQM4e1JvjZuHtWdnTqq9CH1Xf1IvnzU/Vw+q7+pTZIu0aFyLeHifigs++fVT9XD6rv6kFNjJaPSyCCCcLOZNh6ivL2kjwyrudgA969RP2FeXdNW/vB6veVF2X6O241DbMn1Sk34zD6R9V3wVccEmQpsRPlkWD5Yx+bTfsKTLgUxwtvNPX7gpBjFW1IJZGxEsRckeCetjXYjVE3sYCB3D2KYwg8lbmkySEtYBttsuOu9uxCnguQBtOStOgtC2WrkkOYiAZH0HMF3WfeUMnSChcnRY9G9GNVoc9o1jmQc+9TU+GMcLFjSOkBTMeQTOpfmsc7fJ0MdLhIzvSzRloBdG0A9Ass3dKc2O2t4rccQuduxZ5plgAIMrBZzcz9obwjw5edsgM+G1uiUhtQQU8ju7zQT1C6inlSODVWq729W/u29i2GCxYwu9F3qlEInei7uKtXJIckq3FFVMbvRPcUWqeB7lajCuORUshWLHge5FqqzmFcmFVuLKzZcuVmMK4MClkKyVxZWcwLkwdClkK0grJ8nQUsh6XQQQRgBOXmTTln7wer/k5enCvNWnrf3l3b/M5V7QS/FlQeEk4Jy8JFwRgD7Bm8133vcFKRsTPR5vMd973BTMcaCT5CS4EWsSgYnTYxwSgjCDcXQKJtru4AnuVg8kstoZ5Dt5a3/jY63e4qDqhqwSHgx3w96sHkjjbJRyN2HlTf1GAexLm/FjsK8kWfHNJHU4vaMg7jJqnxGaTpMYE0fKDYNuYPiFC45oW12xpc4u1i57jrO6CbZN6N26ykcBwEUkMt9sgBIGwcLDdtKVLbXZshuvrghsU0q1XajA252lxAATWfEtdhDix197P1mmQ0e13PcBrF1wQTsvttlkUpQ6Gah1rlg4Ag36xZU/jqwv/AEuq4M1ro9SR7dwcbdW7wsuGi2Y3K1ac4SGPD27xZ3ZsKqWqtkJKUbObkg4SaNCwOoEsLXbwNV3WPjtT/klB6FOBY4b759gy/XQVZ+SQPsqhmYlzyafGFFyKqyUMTGuTEn5hXJhUsgwMS5MSfmFcmFQlDAxIjEn5hXPIqWXQx5JBPuRQUslG8IIIJwsBXm/ygD95d+L+dy9ILzh5Qf7y7rf/ADuVe0EumVB6RcnD0i4IgSV0aHNf973BTsbVE6Jsu2T7w9isLIkqb5GRXBwxqUDUo2NKCJBZdDTGDalkHEBve4J/5HanUdUMJy5jh184H3JjpDlC1vFxPcD+uxM/JzWtbUFjjblmvaPvA67R3NcpVwYyDqaNUxfHGtcGtGs47AnVTXx8kddzQctYdNt11CPoHNfrxND3WuGvcWty+0AbdyZYzM+Zg1442ne3lHNINsxratnZpCVo3X9DU4iwSFzDrC+dtye1OKAjIqpxve06jIgSftnLpJLVJS0NgNY5ncELikGpsitI3B7blUCqaA8gHge/PPpVr0yrOTiDGmxJAFtthmfh2qlU5z61rwxqJzdTK50WPRSs1JQDsdl7h7Vo8WYWRMJaQ4cfELTNHsQErAf1dSYtdEoWotVOdRFyaCyxvqrktTnUXDmKEGxC5Kb4zW8jGXWubgAbrniq6zSSUkAMaSTYCxzJyA85GlYLZaCubqMxA18Ob6XLi0Fw72k2UO3SV5NtRt+t3wU2sllsQVW+cMn1be8/BBTayWemEEEE0AC84+UP+9O65P5yvRy85+UofvTvvSfzlC+0FHplOeknJRyTKMontEPNk+8PYrG1VvQ/ZL95vsKszAkT7GQ6FGhLMbmk2BKs2pYZAac1GTGjgR37T+uKqJmczVcxxa5pDmkbWuBuCPBT+lrtaZ3Buq0duZVal+Kfj/EVPs2/QfSmOtjFyGyjKRnB3EfZO49ilcYwrX517dqwbRiqMVSxwNtxtwP/AOLWavEZNW4OsLZH4gJOTHT4NeDNa5OTSsiu4m9t91EVuJXuewdSRqZnv2lNxClqFcsdLJfRTdKXOMjSeB7FExHNXbEsI5XJVHEKIwvLTu961Y5pqjBlg4u2LMddTOjWKGF9ieacj8VXmPTgOyuNyuUQYs2mnkuEoq9olX8pC3O+Wqesfkp+6QGdLhyF1y4qEEv7DZWO5J7nNA5922vllvB9JWCLQ+iYWvEADmWcCC7zm5gkXsc1G6OSfvQHGOQ9zo1aDUtc3mODhfa0gjLpCYugfYhC0g+cSOkD2hM8Twmnnymp2P6bZ9+RUowZJvVSAbTb4qrLogPmph3+Ub6kiCnOVHpeI+KNXZVF0QQQTRYF518pjr1bvvSdP0l6GqJWtF3EAdK87eUiRrqpxZ5us+1tm1C+0FH2U5ySKdMgLtngLp1BhL3bhbiSArslDrQ45S9bfYVZ2qIwPCTCX85p1rG19lr79+1WLDaJ0sjWAbTt3ADMkkbAAkTfI2C4OYWXTiSIMBLzqgZm5srjBRxxN1WN63Ec5x9w6B47VnGneIF72sBszP8AFbK/Ve/cghc5bUNlDZByZWdIJgZnkbHapHcAoOUZlP8AEOcAeGXYmBBWpKuDLJ2c0eUjTwK1WgdrRix3LNsMp9Z4K0fBKY6tkrMx2GLFW4fcXRR0BurLSUPNTqLDwFmkzVFFMrmNhjdI/YO8nYGjpJWa1TjI9z3bXEk/BW3TjFhNNyTD+zjJ2fSfsLuobB28VXOTXS0umcY7pds5ur1O+W2PSI00fBLUrLGxWiaDaItmby8zdZlyGMOxxGRc4bxfIDoKvcuDx6urybdXhqi3cs+p1EIS2pWaNNpZzjuboxnCaySnvybhquIJBFxceKmzpc4uDQwEkgX80XPC+ZT7SfRMsJkhAtvYN/V0rPKtrg64uPdbpQY5RychZcbx8Mv8OlbfNc2x322dimIqvWANwQRe4usj+Vuuc1JUOPyRizXHIWscx12KNwYlSRqGiFTyldkLBjJmHPbcx2PgVcJLl3NNrbrZLNvJZNrTSS31iIiXcWlzyLdJyv2rRYLHNriDtsc9vQc1T4VF+xw2Yjzh2g3SDpc76psc75dyN7nDK3aNniuRTk3IcQeu47ihRBXlGej/ALR8ES55B/pDuQVkJyTH2jY1M5dInbrdg/P9XVaw+fXiiN9sbXHtAyS75WtBJNgBc9ACW8kroKMItJklNisjweff1ctm6youIaNPnEpmDo3hxfHNzbuOsNUC+49Sl8Jx+nqbmGQFw2sI1X238059qm5KiKZ2o6KPIAkFrTrPaLFzuJU3S5vsGULXj7M0hp65o5xZKzWIaXxA3FzYXYGm9tqf02Jw31ZWRxnZzTbvbJYjvKvLIoozdsbGN+kGNDbgcbDNKNrqN26G+4uDSR1Fydj2z7QMlKPRXqTCIZReORp8FL4XhIhJNuc4W/DtPebdyWnw2mludWJ9/t5+BStFC1lmtFmjIC5O8k5npJS80VFcMbgbcufR3iJ1YnG9srX4XNr+Pgsd0tnvUOsMmBoA4C17ePgVsOJgGMi/AjrBuPYsMx2UvmksRznOO3bnsRaOk3L6C1bbio/ZFtltt45rvEA24LeAukJIS11nA9m/qRF41uhO9iPRK4Ewa/QtPwSC4CzLAqljHc42AO218rdC0XDtKaKJmc2fAMeT3aqRkhKT4RpxZIRjy0XGFlgqlptpS2JrqeF15XCz3A5RjeL+nu6OtQekGnD5mlkAdEy1i4mz3DgLeYPHqVOJsLrbp9FXlk/Yx6jWprbj/c4YLlPMNpDPMyJm172t6rnM9guexNWZNJ7VefI/heu99S76A1W/fftPY3+ZatRl+LG5GTBj+TIkafS0jIo2xsFmsaGtHQBZIznJOXvUdVyrzUuT0cFREYm/asi08pdSUOGQeLkbrjafYtUrnLO9P47sa70XeBB+ATNNxMHVK8bKKClA5cONzmb9aDV1DjmheR6stUSw7DIwOB/7bsx2h/8AtWvRwn6QDwN+w36vzXnrQnEvk1dTyk2aJA133ZAWOv0c6/YvRTaqP0299knJ2Nh0N33JOqSOF9y6hjdvGfRl4FKiSL0m9pC7bKzc9vrBAEcXPou7/wA0Eet9tveEFCFUwmKWKmby0b4THrAmRpaA0ONrk2BFrZqD0m0mhfA6OKohLnZG0jbau05g9AUbW+UnEJm3dVsgafoxN5/sNu0hVXEsNqKiR8sbZpxkTIWm7hbbcgax6BcnddEsS3Wxam1BRQ2bTjW1vlMTS06wLJHB4t6Nm7VpdD5QaRhs4Meyw52q4y3tbNzgM+JGSyB4DSQ7mkZEHIg8CDsKl8IoaZ4LppZGtAJJjjc+1uLgCAOlMnFPsGLa6LPpNp497tWle5rNUhxe1hcSTtAsQ2wy704oMfa+JmtzpCMwC69xkScrZ9apeNRU7ZbUznvjsCC8EHzRfaBvuu6Gu1RbVB77juKiikuA1Jt8l8pq8Pexo+k5otkdp3rRafYsj0QquVqoxa1iT3An3LXo8mrLnfNGvCuCv6a4kYoDY853NHWd/ddZBUX94PA8Qr55Q6rWdGzhrH2Ae0qlyDJdTRYV8Nv2c3W5X81fRGuqXDzs0rNEx7dZuR3j8lxMy+1NDe+X5W6UrJDa+A8c7XI7p5mgEWF+j80q2TPYEwhjJOWxS1PBbbtT9PBvkTnmkqFHbAP1lmk35lKOOf66/guFtkZIgqDZjuorTfJvVtjw0EecZXX7mj2WWYVR5hUvoRihDH05PnFrmfeyabf7e5c/+oLdCkb/AOntKfJtEjslHVEikXM5o6lDVu9cJo7kSOq33VR0wg1qeTi3neqbnwurRUOUbWRazXNOwgg9osrxupJlzW6LRjxRgoOZYkcCR3ZIguucNnRWt4P5QaDk42ziZkgY0PIa5zS6w1iC1xNr33LIyp3B8GE0evztpabW3Z+8JGfFGa8v4G420+DXqPSfC5fNq2N6JHOjP/kAU5S0sEovHIHjiyRrvZdZ5oj5O4JmvknDyzzGC+pd21zrt2gDLtPBTw8k1Cecx07DuLXi46iW3WX4Wvxm/wDvI6/tFt/sZn2+8fBBVj/pkz/PV3+t+SNT48v+f8E4+gUWDU8Ja1sDGP1m2Lmhrj6Q1tjh+MKSe0tA1mgW13bA11icgCQRbpz61FVmlUYzMzzmXDk7MFyPTJLrdCr9bpnGDcMBPpPJe7vcbIqk/RRcaXFHtddmdzmNXXvYbTe9+u6nIdLwGkTsY3L0hnxBZmVi9bpnK/IONuAyHdkFCzYnM/efH8lfwyfZTcR/p9T0wqy6lbqRvAcWW5rX3IcGZZNNgbbrqullktJI4nnbQkyVpjaSQNKy4+S2nLql79zGeLzYeActXqptVipPkuoNWnMhGcjyfws5rfHWParLjUtmlZMruRtwqomd6V1GvP1C3iVByFL4lPeR56U1AXoMEduKMf0OBnluyyl+ok9iLkAdoSq6bGi2pi91BxMA2JYIrWQunJJCm22JHaev2ZIiVw5+3rSbnpTY5IKpkyslNGm/vcA/91vhn7kzkddSehsZdX044PJ7mOWPPK0zVgVSX+z0BL5g6lXsRcp+pdZvYqxiL81wZ9noIdEfI5Mah2SdSuUPi1UGsceAJ7grgrZJypGX1LryPPFzj3uKSRArorqnEfIauegUzdR7HPa28gzcbABwAv1Cypi7hO1VJWgocM9O09XRiJkbKuNoYLAh7BfeSdYbzc9qe09VAP8A1UTh/wByMewry219thI6ilY6yQbJHj8R+KTtH2eqflMP1sfrt+KC8uf2lN9c/wBY/FBTaQnqrCTPJq0fLSjO4tex3WLGi471P4P5J62XN7REDvebHuGaexVeN0T6aja6Jr3D9mxpgJNjciZ1rB2qCduYBsSQlsRhxVrJnT4xTRNe6xtUuPOFyBHqMJYDsIFurYmqNIQ5WTdJ5G4mNvJUFxANw1oHVYn4LM9L6MU8zo47hrTbpOW8rWvJxjkk76lkmICqMTGtAbHqtAD3sEgf/iXDAbgfTzust8oedVJ1+4Kmi4t2VMoBpOQzOwdJOxGVJaLU3KVcLbZa4cepgL/+KpukNStmz4BRiGGOP0GNb3DM99000hfzSpNpsFA44+7SsCds6NUjLqp/OPWfauGSosSykcOm/emoevQwyeKPOZIeTJBjwuzKFGa6MSpiyCnjJDlURkTHlUYeVfyFbBSR+ZSTnriV2aTJSZSHRidEq1+S+m167W9Bjj2uIA96qJK0fyO0v8aXiQwdTRf/AJLJnlUGatPG5o0mvfkqxVuzKsOIOVbrTmuRLs7keiNqXqqaWz6sJbfN5DezafZbtVnqSs/0rqteYNGxgz63Znwsn4I3IzaqVQK+W2RkpxOzm36k2W85dnQQCDUAoWuw11+t65CNANDuf0SiQ1kShR6Hi8jcDnNdPVTymzde5aNZwFsnEEhvAZkZZpxQeRygY0iR0spLgQdbUs0fQs3bfedvUtGQUBI0YZBAx3JQxx82xLGNaSBsBIFyvOnlAF6qTr9wXpTET+zd1LzPp9UN+VSWI25577KmXB+TK0Wq3+TCi16l8m6NlvxPOXg13eqPJPwWv+SzDeTo+UPnSuL+zzWeAv2pebxgaMPlMs9XJqtVexOS7SpPFb22qBll5pB2rBE3vooOKUUkkj+TaXFrS9wG3VBAJA3+cMutRHKW2gg8CLeC0jRWH94nfwYxvrOJ/wCCrenL2uqzl5rGtPSc3exwXWwTbe04+eKXJXRMEOWC75MbkXyda6kZLQXLBHyyHyVcujYN6vyK8Tl7kQK5e4bkewJb7DQCVtfkuo+TomO3vu/1iSPCyxB7sl6L0dpuSpomeixo7Q0LHqpeKRu0cfJs6xFyr1UdqsGIbCqzWv2rm9s6y6IjEZ9UEncCVmTnmR7nn6Tr/DNW/TGt1YiN7zq9m0+APeqM15GwnsK34I0rOXq53Kh1VEAWG02v0W/X6yu1QQTzIG1AbUTUDtVhI7CNEiuhGhoIkFCj2smeK4pDTRmWeRsbBtc427ANpPQEljT6oRH5KyF0u7lnuawdJ1Wku6sutYdpZoLjtVIZZ2ic7gyZmq0cGMcWho7FKBHGnvlffOHQ0QMcewyu/iOH2R9AePUsmlkLiSSSTmSeKnMR0OxCHOWinaOIjLx3suFDyR6uRBB6RZWCc08Be5rRtcQ0dZNh7V6JwmmEcTGNGTWhoHULBYloVhklRVxhjC4McHvP0WAZguO65AHSt+paM6nnAHcRnZZdTy0jbpY8NkRWNVSxxlswrbXVBZrRtcC7e5wt2XF1X6+m5UWPNf0+ae0e5ZlSZvlC1wcaM0+rT652yuL/AMI5rfYT+JUDS6XWqXn7RaOpgaPbdaa1j46dgcOc1lui7RuPYsdxOfXkJ6ST1lb9N25HG1F9MNrkOXSLSlW2XQTZiaRy+QlGyLoRunaEk+oJ2BU2vZaT9HbwEjI5T2EaHVtTYiPk2n6Ut2DsHnHuV1wryYQNznlfKd7W/s2eF3eIWXLqscfZrxaTJP0ZnhFPylRCzbrSxi3RrDW8Lr0RRvPYo2gwOlp84oI2H0g0F3a45+KcTVYA2rm59Qp9I6mn0zxrlnWKHJVDE5dqla+vuLXVSx6vDWk8LlLxptjsklGJTNKazXl1dzMu05n3KGCOR5cSTtJJPWUQXUiqVHEnLc2w0dkEEQITUHIwicoQ6QQQQjEwrI0SNQh7WQQQVFDDGT+yP63LzlpuT8ofbj7gvReOH9kf1uXnTTcfvL+v3KmSH5M60J0hfTudA1rSJ3Mu4DnNIuAbWzGa02KmnJDeVcBa93Ny2bGj81A+TvFIIKdgLdRzi4Fxaee+52OtnlYdisNViJkkDW6zgdwbe6z5OzoYuIjY4Tcu1ZCTxIG3sUY2WWFxDm9RBuD8F3iHymnuWxOLdpFwSB2G/goWnxvXfznEA7Rl3ZpDhZpU17J11cXNs43vfI7gs+xrQuXW16Ya4O1hLQ5v3SbAjx61bflDSTa9tye081s1UMk8b4KyYoZVUjP6LQSukFzE1n35GD+UkqUpvJnOf4k0TB9nWefYFeGV2W3fYBLOkIGZTJa3L6oStBhX2ys0Xk4pm/xZZJOgWY091z4qy4fg1LB/ChY08bXd6xzSDqy29ISV/Skyy5J9sfDDih0idfOAm8tcAoCXEOlMZsR6UtQbDc0TtRifSoyfErqDqMSHFRNTjLRvATo4bEyzJE5W1yp2kVWXc2/SfcEc+N32An2KInlLnFx2lbcOKnbMGozblSGrkAupFyFoZlOkESCogYKJyILoqEDagUGoyqYaCQR2QVFntVBBBUURmPH9mvPmmTL1DutegNInfs+9YfpJAHTFUyQfkyX0Mx2GWNlLUNaNQarN2s0Xtb7SuRqqenYXMkPABxv+aybDcMjfKGyP5NuZLhty2AXyur3JQNeQ4PY5lgSNbV7Tbovs3pE0boStcjWrx0GUlz7DgSM+gKKxGqgJuWNOe0ZHvCeYjUUzXhpiZfYSbO7blQtYKRpu1jT0D8kvaOUxYTMIBBtfde/almzDeVCVuMiOF5bEA3IXyGZyFhxvmqxLpDKdnirWFyBnnjE0cYgwb01rNImg21r9WaziWumftcQOAySQgcdrj3lEtPH2xb1Mn0i71GkY4+KZS6Qj0h3qtMowl2Ug4IvjggfkyMkpce4EnqBTSXFnnY09psuRS9C6FOr8UD5MZyOkdtdbqXLKRSAhXQjRbibF7GsdMEckATosXJYhthbUMeSHBEaVvAJd4sUTSitgNIbGjb+iuHUQ4lPiiV7mV8cWR5oTxRfJHdHepINXcbVe9lfFEixSP9HusfYrFg3k/wARqohNDSudGSQCXMYXW2kB5BI6egrT/JBoWdYV07LAf3drhtJ/xbcNzesngtdRJsVJJOkeXP8Aphi3+Rf/AKsH/wBiC9QcqOlBWCKIIIKiELpJ5ixvHP4rkEEMisfbILEfMd1J3oz/AAH9R9yCCCXRogVXST3lFgSJBF/aA/yHWkPmD749hUG1GgrXQUuxZiVaggqYURdqXaiQS2NQs1KBBBCxiOCumokFCgFJSIIK0UxrOk0EEYtnSJyCCsg8w3a77pSdL5w6x7UEFPRF2es6fzW9Q9i4qPN70aCYZBqgggrLP//Z");
        photoUrls.put("Wes Mau", "https://www.sanmarcosrecord.com/sites/sanmarcosrecord.etypegoogle4.com/files/styles/juicebox_large/public/field/image/wes_mau_photo_-_criminal_district_attorney_hays_county.jpg?itok=8ffuYY72");
        photoUrls.put("Gary Cutler", "https://hayscountytx.com/wp-content/uploads/sites/69/2018/11/sheriff2-228x300.jpg");
        photoUrls.put("Britney Bolton Richey", "https://www.sanmarcosrecord.com/sites/sanmarcosrecord.etypegoogle4.com/files/styles/juicebox_large/public/field/image/britney_bolton_richey_-_county_treasurer_candiate.jpg?itok=PKJUt9bK");
        photoUrls.put("Elaine H. Cardenas", "https://hayscountytx.com/wp-content/uploads/sites/69/2019/08/Elaine-Cardenas-Formal-200x300.jpg");
        photoUrls.put("Sonny Perdue", "https://upload.wikimedia.org/wikipedia/commons/0/00/Sonny_Perdue_at_rally.jpg");
        photoUrls.put("William Barr", "https://upload.wikimedia.org/wikipedia/commons/4/45/William_Barr.jpg");
        photoUrls.put("Gina Haspel", "https://upload.wikimedia.org/wikipedia/commons/9/98/Gina_Haspel_official_CIA_portrait.jpg");
        photoUrls.put("Wilbur L. Ross, Jr.", "https://upload.wikimedia.org/wikipedia/commons/f/fd/Wilbur_Ross_Official_Portrait.jpg");
        photoUrls.put("Mark Esper", "https://upload.wikimedia.org/wikipedia/commons/b/b0/Dr._Mark_T._Esper_%E2%80%93_Secretary_of_Defense.jpg");
        photoUrls.put("Elisabeth Prince DeVos", "https://upload.wikimedia.org/wikipedia/commons/8/88/Betsy_DeVos_official_portrait.jpg");
        photoUrls.put("Dan Brouillette", "https://upload.wikimedia.org/wikipedia/commons/3/30/Dan_Brouillette_official_photo.jpg");
        photoUrls.put("Andrew Wheeler", "https://media.npr.org/assets/img/2018/07/06/rts1vfoh_custom-329c99b0eff63fb119fb7242664e367ee32fc4fa.jpg");
        photoUrls.put( "Alex Azar","https://upload.wikimedia.org/wikipedia/commons/1/13/Alex_Azar_official_portrait_2.jpg");
        photoUrls.put("Chad Wolf", "https://upload.wikimedia.org/wikipedia/commons/d/d0/Chad_Wolf_official_portrait_2017.jpg");
        photoUrls.put("Benjamin S. Carson, Sr.", "https://www.whitehouse.gov/wp-content/uploads/2017/11/SecCarson.jpg");
        photoUrls.put("David Bernhardt", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/David_Bernhardt_official_photo_%28cropped%29.jpg/170px-David_Bernhardt_official_photo_%28cropped%29.jpg");
        photoUrls.put("Eugene Scalia", "https://upload.wikimedia.org/wikipedia/commons/9/93/Eugene_Scalia_%28cropped%29.jpg");
        photoUrls.put("Russ Vought", "https://upload.wikimedia.org/wikipedia/commons/6/64/Russell_Vought.jpg");
        photoUrls.put("John Ratcliffe", "https://upload.wikimedia.org/wikipedia/commons/c/c0/John_Ratcliffe_official_photo.jpg");
        photoUrls.put("Jovita Carranza", "https://upload.wikimedia.org/wikipedia/commons/b/b1/Jovita_Carranza_official_photo.jpg");
        photoUrls.put("Mike Pompeo", "https://upload.wikimedia.org/wikipedia/commons/1/16/Mike_Pompeo_official_photo.jpg");
        photoUrls.put("Elaine L. Chao", "https://www.whitehouse.gov/wp-content/uploads/2017/11/SecChao.jpg");
        photoUrls.put("Steven T. Mnuchin", "https://www.whitehouse.gov/wp-content/uploads/2017/11/SecMnuchin.jpg");
        photoUrls.put("Robert Lighthizer", "https://upload.wikimedia.org/wikipedia/commons/d/d8/Robert_E._Lighthizer_official_portrait.jpg");
        photoUrls.put("Robert Wilkie", "https://upload.wikimedia.org/wikipedia/commons/d/db/Robert_Wilkie_official_portrait.jpg");
        photoUrls.put("Mark Meadows", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Mark_Meadows%2C_Official_Portrait%2C_113th_Congress.jpg/800px-Mark_Meadows%2C_Official_Portrait%2C_113th_Congress.jpg");

        return photoUrls.get(name);
    }

    public static Map<String, String> getCabinetOfficesAndNames(){

        Map<String, String> list = new HashMap<>();

        list.put("Secretary of Agriculture", "Sonny Perdue");
        list.put("Attorney General", "William Barr");
        list.put("Director of the Central Intelligence Agency", "Gina Haspel");
        list.put("Secretary of Commerce", "Wilbur L. Ross, Jr.");
        list.put("Secretary of Defense", "Mark Esper");
        list.put("Secretary of Education", "Elisabeth Prince DeVos");
        list.put("Secretary of Energy", "Dan Brouillette");
        list.put("Administrator of the Environmental Protection Agency", "Andrew Wheeler");
        list.put("Secretary of Health and Human Services", "Alex Azar");
        list.put("Acting Secretary of Homeland Security", "Chad Wolf");
        list.put("Secretary of Housing and Urban Development", "Benjamin S. Carson, Sr.");
        list.put("Secretary of the Interior", "David Bernhardt");
        list.put("Secretary of Labor", "Eugene Scalia");
        list.put("Acting Director of the Office of Management and Budget", "Russ Vought");
        list.put("Director of National Intelligence", "John Ratcliffe");
        list.put("Administrator of the Small Business Administration", "Jovita Carranza");
        list.put("Secretary of State", "Mike Pompeo");
        list.put("Secretary of Transportation", "Elaine L. Chao");
        list.put("Secretary of the Treasury", "Steven T. Mnuchin");
        list.put("U.S. Trade Representative", "Robert Lighthizer");
        list.put("Secretary of Veterans Affairs", "Robert Wilkie");
        list.put("White House Chief of Staff", "Mark Meadows");

        return list;
    }

}
