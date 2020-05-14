package com.jorgegiance.folks.models.googlecivicModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StateCabinet {


    @SerializedName("offices")
    @Expose
    private List<Office> offices = null;
    @SerializedName("officials")
    @Expose
    private List<Official> officials = null;



    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public List<Official> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Official> officials) {
        this.officials = officials;
    }

    public void removeOfficial(int index){
        officials.remove(index);
    }

    public void removeOffice(int index){
        offices.remove(index);
    }

}
