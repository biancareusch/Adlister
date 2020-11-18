package com.codeup.adlister.models;

public class BusinessProfile {
    private long id;
    private long businessId;
    private String aboutMe;
    private String phoneNumber;
    private String profilePic;
    private long adId;
    private String websiteURL;
    private Boolean viewingPreference;

    public BusinessProfile(){}

    public BusinessProfile(long businessId, String aboutMe, String phoneNumber, String profilePic, long adId, String websiteURL, Boolean viewingPreference) {
        this.businessId = businessId;
        this.aboutMe = aboutMe;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.adId = adId;
        this.websiteURL = websiteURL;
        this.viewingPreference = viewingPreference;
    }

    public BusinessProfile(long id, long businessId, String aboutMe, String phoneNumber, String profilePic, long adId, String websiteURL, Boolean viewingPreference) {
        this.id = id;
        this.businessId = businessId;
        this.aboutMe = aboutMe;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.adId = adId;
        this.websiteURL = websiteURL;
        this.viewingPreference = viewingPreference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(long businessId) {
        this.businessId = businessId;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public Boolean getViewingPreference() {
        return viewingPreference;
    }

    public void setViewingPreference(Boolean viewingPreference) {
        this.viewingPreference = viewingPreference;
    }
}
