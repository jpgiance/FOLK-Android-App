package com.jorgegiance.folks.models.firebaseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("user")
    @Expose
    private String user;

    public Comment() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCount() {
        return user;
    }

    public void setCount(String user) {
        this.user = user;
    }
}
