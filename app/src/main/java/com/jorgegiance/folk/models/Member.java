package com.jorgegiance.folk.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("short_title")
    @Expose
    private String shortTitle;
    @SerializedName("api_uri")
    @Expose
    private String apiUri;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private Object middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("suffix")
    @Expose
    private Object suffix;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("party")
    @Expose
    private String party;
    @SerializedName("leadership_role")
    @Expose
    private Object leadershipRole;
    @SerializedName("twitter_account")
    @Expose
    private String twitterAccount;
    @SerializedName("facebook_account")
    @Expose
    private String facebookAccount;
    @SerializedName("youtube_account")
    @Expose
    private String youtubeAccount;
    @SerializedName("govtrack_id")
    @Expose
    private String govtrackId;
    @SerializedName("cspan_id")
    @Expose
    private String cspanId;
    @SerializedName("votesmart_id")
    @Expose
    private String votesmartId;
    @SerializedName("icpsr_id")
    @Expose
    private String icpsrId;
    @SerializedName("crp_id")
    @Expose
    private String crpId;
    @SerializedName("google_entity_id")
    @Expose
    private String googleEntityId;
    @SerializedName("fec_candidate_id")
    @Expose
    private String fecCandidateId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("rss_url")
    @Expose
    private Object rssUrl;
    @SerializedName("contact_form")
    @Expose
    private String contactForm;
    @SerializedName("in_office")
    @Expose
    private Boolean inOffice;
    @SerializedName("cook_pvi")
    @Expose
    private Object cookPvi;
    @SerializedName("dw_nominate")
    @Expose
    private Double dwNominate;
    @SerializedName("ideal_point")
    @Expose
    private Object idealPoint;
    @SerializedName("seniority")
    @Expose
    private String seniority;
    @SerializedName("next_election")
    @Expose
    private String nextElection;
    @SerializedName("total_votes")
    @Expose
    private Integer totalVotes;
    @SerializedName("missed_votes")
    @Expose
    private Integer missedVotes;
    @SerializedName("total_present")
    @Expose
    private Integer totalPresent;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("ocd_id")
    @Expose
    private String ocdId;
    @SerializedName("office")
    @Expose
    private String office;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("fax")
    @Expose
    private String fax;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("senate_class")
    @Expose
    private String senateClass;
    @SerializedName("state_rank")
    @Expose
    private String stateRank;
    @SerializedName("lis_id")
    @Expose
    private String lisId;
    @SerializedName("missed_votes_pct")
    @Expose
    private Double missedVotesPct;
    @SerializedName("votes_with_party_pct")
    @Expose
    private Double votesWithPartyPct;
    @SerializedName("votes_against_party_pct")
    @Expose
    private Double votesAgainstPartyPct;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getApiUri() {
        return apiUri;
    }

    public void setApiUri(String apiUri) {
        this.apiUri = apiUri;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Object getMiddleName() {
        return middleName;
    }

    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Object getSuffix() {
        return suffix;
    }

    public void setSuffix(Object suffix) {
        this.suffix = suffix;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Object getLeadershipRole() {
        return leadershipRole;
    }

    public void setLeadershipRole(Object leadershipRole) {
        this.leadershipRole = leadershipRole;
    }

    public String getTwitterAccount() {
        return twitterAccount;
    }

    public void setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }

    public String getFacebookAccount() {
        return facebookAccount;
    }

    public void setFacebookAccount(String facebookAccount) {
        this.facebookAccount = facebookAccount;
    }

    public String getYoutubeAccount() {
        return youtubeAccount;
    }

    public void setYoutubeAccount(String youtubeAccount) {
        this.youtubeAccount = youtubeAccount;
    }

    public String getGovtrackId() {
        return govtrackId;
    }

    public void setGovtrackId(String govtrackId) {
        this.govtrackId = govtrackId;
    }

    public String getCspanId() {
        return cspanId;
    }

    public void setCspanId(String cspanId) {
        this.cspanId = cspanId;
    }

    public String getVotesmartId() {
        return votesmartId;
    }

    public void setVotesmartId(String votesmartId) {
        this.votesmartId = votesmartId;
    }

    public String getIcpsrId() {
        return icpsrId;
    }

    public void setIcpsrId(String icpsrId) {
        this.icpsrId = icpsrId;
    }

    public String getCrpId() {
        return crpId;
    }

    public void setCrpId(String crpId) {
        this.crpId = crpId;
    }

    public String getGoogleEntityId() {
        return googleEntityId;
    }

    public void setGoogleEntityId(String googleEntityId) {
        this.googleEntityId = googleEntityId;
    }

    public String getFecCandidateId() {
        return fecCandidateId;
    }

    public void setFecCandidateId(String fecCandidateId) {
        this.fecCandidateId = fecCandidateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getRssUrl() {
        return rssUrl;
    }

    public void setRssUrl(Object rssUrl) {
        this.rssUrl = rssUrl;
    }

    public String getContactForm() {
        return contactForm;
    }

    public void setContactForm(String contactForm) {
        this.contactForm = contactForm;
    }

    public Boolean getInOffice() {
        return inOffice;
    }

    public void setInOffice(Boolean inOffice) {
        this.inOffice = inOffice;
    }

    public Object getCookPvi() {
        return cookPvi;
    }

    public void setCookPvi(Object cookPvi) {
        this.cookPvi = cookPvi;
    }

    public Double getDwNominate() {
        return dwNominate;
    }

    public void setDwNominate(Double dwNominate) {
        this.dwNominate = dwNominate;
    }

    public Object getIdealPoint() {
        return idealPoint;
    }

    public void setIdealPoint(Object idealPoint) {
        this.idealPoint = idealPoint;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getNextElection() {
        return nextElection;
    }

    public void setNextElection(String nextElection) {
        this.nextElection = nextElection;
    }

    public Integer getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(Integer totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Integer getMissedVotes() {
        return missedVotes;
    }

    public void setMissedVotes(Integer missedVotes) {
        this.missedVotes = missedVotes;
    }

    public Integer getTotalPresent() {
        return totalPresent;
    }

    public void setTotalPresent(Integer totalPresent) {
        this.totalPresent = totalPresent;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getOcdId() {
        return ocdId;
    }

    public void setOcdId(String ocdId) {
        this.ocdId = ocdId;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSenateClass() {
        return senateClass;
    }

    public void setSenateClass(String senateClass) {
        this.senateClass = senateClass;
    }

    public String getStateRank() {
        return stateRank;
    }

    public void setStateRank(String stateRank) {
        this.stateRank = stateRank;
    }

    public String getLisId() {
        return lisId;
    }

    public void setLisId(String lisId) {
        this.lisId = lisId;
    }

    public Double getMissedVotesPct() {
        return missedVotesPct;
    }

    public void setMissedVotesPct(Double missedVotesPct) {
        this.missedVotesPct = missedVotesPct;
    }

    public Double getVotesWithPartyPct() {
        return votesWithPartyPct;
    }

    public void setVotesWithPartyPct(Double votesWithPartyPct) {
        this.votesWithPartyPct = votesWithPartyPct;
    }

    public Double getVotesAgainstPartyPct() {
        return votesAgainstPartyPct;
    }

    public void setVotesAgainstPartyPct(Double votesAgainstPartyPct) {
        this.votesAgainstPartyPct = votesAgainstPartyPct;
    }

}