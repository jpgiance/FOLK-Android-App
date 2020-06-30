package com.jorgegiance.folks.models;

import com.jorgegiance.folks.models.googlecivicModels.Address;
import com.jorgegiance.folks.models.googlecivicModels.Channel;
import com.jorgegiance.folks.models.googlecivicModels.Official;
import com.jorgegiance.folks.models.propublicaModels.Member;
import com.jorgegiance.folks.util.Utilities;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;                                        //
    private String title;                                       // from Member
    private String leadershipRole;                              // from Member
    private String party;
    private String district;                                    // from Member
    private String state;                                        // from Member
    private String photoUrl;
    private String proPublicaId;                                // from Member
    private String proPublicaApiUri;                            // from Member
    private String govtrackId;                                  // from Member
    private String dateOfBirth;                                 // from Member
    private String url;                                         // from Member
    private String youtubeAccount;
    private String twitterAccount;
    private String facebookAccount;
    private List<Channel> channels = null;                      // from Official
    private List<String> phones = null;                         // from Official
    private List<Address> address = null;                       // from Official


    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getLeadershipRole() {
        return leadershipRole;
    }

    public void setLeadershipRole( String leadershipRole ) {
        this.leadershipRole = leadershipRole;
    }

    public String getParty() {
        return party;
    }

    public void setParty( String party ) {
        this.party = party;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict( String district ) {
        this.district = district;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl( String photoUrl ) {
        this.photoUrl = photoUrl;
    }

    public String getProPublicaId() {
        return proPublicaId;
    }

    public void setProPublicaId( String proPublicaId ) {
        this.proPublicaId = proPublicaId;
    }

    public String getProPublicaApiUri() {
        return proPublicaApiUri;
    }

    public void setProPublicaApiUri( String proPublicaApiUri ) {
        this.proPublicaApiUri = proPublicaApiUri;
    }

    public String getGovtrackId() {
        return govtrackId;
    }

    public void setGovtrackId( String govtrackId ) {
        this.govtrackId = govtrackId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth( String dateOfBirth ) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl( String url ) {
        this.url = url;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels( List<Channel> channels ) {
        this.channels = channels;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones( List<String> phones ) {
        this.phones = phones;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress( List<Address> address ) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getYoutubeAccount() {
        return youtubeAccount;
    }

    public void setYoutubeAccount( String youtubeAccount ) {
        this.youtubeAccount = youtubeAccount;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount( String twitterAccount ) {
        this.twitterAccount = twitterAccount;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount( String facebookAccount ) {
        this.facebookAccount = facebookAccount;
    }




    public static Person OfficialToPerson( Official official){

        Person person = new Person();

        person.setName(official.getName());
        person.setPhotoUrl(official.getPhotoUrl());
        person.setAddress(official.getAddress());
        person.setParty(official.getParty());
        person.setChannels(official.getChannels());
        person.setPhones(official.getPhones());

        if (official.getUrls() != null){
            if (official.getUrls().size() > 0){
                person.setUrl(official.getUrls().get(0));
            }
        }


        if (official.getAddress() != null) {
            if (official.getAddress().size()>0){
                person.setState(official.getAddress().get(0).getState());
            }

        }

        if (official.getChannels() != null){
            for (Channel channel:official.getChannels()) {
                if (channel.getType().equals("YouTube")){
                    person.setYoutubeAccount(channel.getId());
                }else if (channel.getType().equals("Twitter")){
                    person.setTwitterAccount(channel.getId());
                }else if (channel.getType().equals("Facebook")){
                    person.setFacebookAccount(channel.getId());
                }
            }
        }

        return person;
    }


    public static Person MemberToPerson( Member member ){
        Person person = new Person();

        person.setName(member.getFirstName() + member.getLastName());
        person.setPhotoUrl(Utilities.congressPhotoId(member.getId()));
        person.setDistrict(member.getDistrict());
        person.setState(member.getState());
        person.setParty(member.getParty());
        person.setDateOfBirth(member.getDateOfBirth());
        person.setGovtrackId(member.getGovtrackId());
        person.setTitle(member.getTitle());
        person.setLeadershipRole(member.getLeadershipRole());
        person.setProPublicaApiUri(member.getApiUri());
        person.setProPublicaId(member.getId());
        person.setUrl(member.getUrl());
        person.setYoutubeAccount(member.getYoutubeAccount());
        person.setTwitterAccount(member.getTwitterAccount());
        person.setFacebookAccount(member.getFacebookAccount());

        List<String> phones = new ArrayList<>();
        phones.add(member.getPhone());
        person.setPhones(phones);


        return person;

    }
}
