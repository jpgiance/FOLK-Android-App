package com.jorgegiance.folk.util;

import com.jorgegiance.folk.models.HomeItem;
import com.jorgegiance.folk.models.News;

import java.util.ArrayList;

public class DummyDB {


    public ArrayList<HomeItem> getHomeItemList(){

        ArrayList<News> newsList2 = new ArrayList<>();
        ArrayList<News> newsList3 = new ArrayList<>();
        ArrayList<News> newsList4 = new ArrayList<>();
        ArrayList<News> newsList5 = new ArrayList<>();
        ArrayList<HomeItem> itemsList = new ArrayList<>();

        News news1 = new News(
                "Biden to discuss sexual assault claim, network says, as President Trump says it could be a ‘false accusation’",
                "The Washington Post",
                Long.toString(System.currentTimeMillis()),
                "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/ZTV2U7ULFYI6VHP5TEHZ3TDR7Q.jpg&w=767",
                null
        );

        News news2 = new News(
                "Trump calls newly released UFO footage 'a hell of a video'",
                "CNN",
                Long.toString(System.currentTimeMillis()),
                null,
                "https://amd-ssl.cdn.turner.com/cnn/big/ads/2020/04/30/CoronaVirusFactsAndFears_TownHall_Number9_BillGates_Rev_Tonight_8p_15_C4JJ4_576x324.mp4"
        );

        News news3 = new News(
                "House Democrats push to include primary care workers in coronavirus relief package",
                "The Hill",
                Long.toString(System.currentTimeMillis()),
                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
                null
        );

        News news4 = new News(
                "House Democrats push to include primary care workers in coronavirus relief package",
                "The Hill",
                Long.toString(System.currentTimeMillis()),
                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
                null
        );

        News news5 = new News(
                "House Democrats push to include primary care workers in coronavirus relief package",
                "The Hill",
                Long.toString(System.currentTimeMillis()),
                "https://thehill.com/sites/default/files/styles/thumb_small_article/public/castrojoaquin_111219gn2_lead.jpg?itok=yg96tJXi",
                null
        );


        newsList2.add(news1);
        newsList3.add(news3);
        newsList3.add(news3);
        newsList4.add(news2);

        HomeItem item1 = new HomeItem(
                null,
                null,
                "COVID-19 updates: a map of the virus spread in the U.S., plus what your next hotel stay could look like."
        );

        HomeItem item2 = new HomeItem(
                newsList2,
                "Politics",
                null
        );

        HomeItem item3 = new HomeItem(
                newsList3,
                null,
                null
        );
        HomeItem item4 = new HomeItem(
                newsList4,
                null,
                null
        );
        HomeItem item5 = new HomeItem(
                newsList2,
                null,
                null
        );

        itemsList.add(item1);
        itemsList.add(item2);
        itemsList.add(item3);
        itemsList.add(item4);
        itemsList.add(item5);

        return itemsList;

    }







}
