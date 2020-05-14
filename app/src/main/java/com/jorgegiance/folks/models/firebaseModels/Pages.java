package com.jorgegiance.folks.models.firebaseModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pages {

    @SerializedName("last")
    @Expose
    private Integer last;
    @SerializedName("pages")
    @Expose
    private List<Page> pages = null;

    public Pages() {
    }

    public Integer getLast() {
        return last;
    }

    public void setLast( Integer last ) {
        this.last = last;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages( List<Page> pages ) {
        this.pages = pages;
    }
}
