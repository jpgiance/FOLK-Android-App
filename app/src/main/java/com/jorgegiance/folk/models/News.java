package com.jorgegiance.folk.models;

public class News {

    private String title;
    private String source;
    private String time;
    private String posterLink;
    private String videoLink;

    public News( String title, String source, String time, String posterLink, String videoLink ) {
        this.title = title;
        this.source = source;
        this.time = time;
        this.posterLink = posterLink;
        this.videoLink = videoLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource( String source ) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink( String posterLink ) {
        this.posterLink = posterLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink( String videoLink ) {
        this.videoLink = videoLink;
    }

    public int mediaItemType(){
        if (videoLink != null)
            return 2;
        else if (posterLink != null)
            return 1;
        else
            return 0;
    }
}
