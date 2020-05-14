package com.jorgegiance.folks.models.firebaseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Poll {

    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("count")
    @Expose
    private Integer count;

    public Poll() {
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}