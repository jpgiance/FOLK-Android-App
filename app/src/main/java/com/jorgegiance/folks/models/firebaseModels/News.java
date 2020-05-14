package com.jorgegiance.folks.models.firebaseModels;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News implements Parcelable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;
    @SerializedName("polls")
    @Expose
    private List<Poll> polls = null;
    @SerializedName("comments")
    @Expose
    private List<Comment> comments = null;
    @SerializedName("videoUrl")
    @Expose
    private String videoUrl;

    public News() {
    }


    protected News( Parcel in ) {
        title = in.readString();
        author = in.readString();
        source = in.readString();
        if (in.readByte() == 0) {
            time = null;
        } else {
            time = in.readLong();
        }
        body = in.readString();
        photoUrl = in.readString();
        videoUrl = in.readString();
    }

    @Override
    public void writeToParcel( Parcel dest, int flags ) {
        dest.writeString(title);
        dest.writeString(author);
        dest.writeString(source);
        if (time == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(time);
        }
        dest.writeString(body);
        dest.writeString(photoUrl);
        dest.writeString(videoUrl);
    }

    @Override
    public int describeContents() {
        return 0;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Poll> getPolls() {
        return polls;
    }

    public void setPolls(List<Poll> polls) {
        this.polls = polls;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }


}
