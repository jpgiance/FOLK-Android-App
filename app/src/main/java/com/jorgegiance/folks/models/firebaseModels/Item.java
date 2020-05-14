package com.jorgegiance.folks.models.firebaseModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("information")
    @Expose
    private String information;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("news")
    @Expose
    private List<News> news = null;

    public Item() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews( List<News> news ) {
        this.news = news;
    }

    public boolean hasInformation(){
        if ( this.information != null)
            return true;
        else
            return false;
    }

    public boolean hasSectionTitle(){
        if ( this.title != null)
            return true;
        else
            return false;
    }

    public int itemSize(){
        return this.news.size();
    }
}
