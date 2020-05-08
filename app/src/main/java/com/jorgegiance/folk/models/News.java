package com.jorgegiance.folk.models;

import android.os.Parcel;
import android.os.Parcelable;

public class News implements Parcelable {

    private String title;
    private String source;
    private String content;
    private long time;
    private String posterLink;
    private String videoLink;


    public News( String title, String source, String content, long time, String posterLink, String videoLink ) {
        this.title = title;
        this.source = source;
        this.content = content;
        this.time = time;
        this.posterLink = posterLink;
        this.videoLink = videoLink;
    }



    public String getContent() {
        return content;
    }

    public void setContent( String content ) {
        this.content = content;
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

    public long getTime() {
        return time;
    }

    public void setTime( long time ) {
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



    // ....parcelable implementation


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString(title);
        dest.writeString(source);
        dest.writeString(content);
        dest.writeLong(time);
        dest.writeString(posterLink);
        dest.writeString(videoLink);
    }

    protected News( Parcel in ) {
        title = in.readString();
        source = in.readString();
        content = in.readString();
        time = in.readLong();
        posterLink = in.readString();
        videoLink = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel( Parcel in ) {
            return new News(in);
        }

        @Override
        public News[] newArray( int size ) {
            return new News[size];
        }
    };
}
