package com.jorgegiance.folk.models;

public class Person {

    private String name;
    private String positionTitle;
    private String photoLink;
    private String party;
    private String biography;

    public Person( String name, String positionTitle, String photoLink, String party, String biography ) {
        this.name = name;
        this.positionTitle = positionTitle;
        this.photoLink = photoLink;
        this.party = party;
        this.biography = biography;
    }

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle( String positionTitle ) {
        this.positionTitle = positionTitle;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink( String photoLink ) {
        this.photoLink = photoLink;
    }

    public String getParty() {
        return party;
    }

    public void setParty( String party ) {
        this.party = party;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography( String biography ) {
        this.biography = biography;
    }
}
