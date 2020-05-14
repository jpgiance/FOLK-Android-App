package com.jorgegiance.folks.models.firebaseModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Page {

    @SerializedName("number")
    @Expose
    private Long number;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Page() {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber( Long number) {
        this.number = number;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
