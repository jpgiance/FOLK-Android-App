package com.jorgegiance.folks.models.propublicaModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("congress")
    @Expose
    private String congress;
    @SerializedName("chamber")
    @Expose
    private String chamber;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("members")
    @Expose
    private List<Member> members = null;

    public String getCongress() {
        return congress;
    }

    public void setCongress(String congress) {
        this.congress = congress;
    }

    public String getChamber() {
        return chamber;
    }

    public void setChamber(String chamber) {
        this.chamber = chamber;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

}