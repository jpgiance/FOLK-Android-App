package com.jorgegiance.folk.models;

import java.util.ArrayList;

public class HomeItem {

    private ArrayList<News> newsArrayList;
    private String sectionTitle;
    private String informationText;

    public HomeItem( ArrayList<News> newsArrayList, String sectionTitle, String informationText ) {
        this.newsArrayList = newsArrayList;
        this.sectionTitle = sectionTitle;
        this.informationText = informationText;
    }

    public ArrayList<News> getNewsArrayList() {
        return newsArrayList;
    }

    public void setNewsArrayList( ArrayList<News> newsArrayList ) {
        this.newsArrayList = newsArrayList;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle( String sectionTitle ) {
        this.sectionTitle = sectionTitle;
    }

    public String getInformationText() {
        return informationText;
    }

    public void setInformationText( String informationText ) {
        this.informationText = informationText;
    }

    public boolean hasInformation(){
        if ( informationText != null)
            return true;
        else
            return false;
    }

    public boolean hasSectionTitle(){
        if ( sectionTitle != null)
            return true;
        else
            return false;
    }

    public int itemSize(){
       return newsArrayList.size();
    }
}
