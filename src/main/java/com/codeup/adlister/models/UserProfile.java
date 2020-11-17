package com.codeup.adlister.models;

public class UserProfile {
    private long id;
    private long userId;
    private String aboutMe;
    private String phoneNumber;
    private String profilePic;
    private long adId;
    private Boolean viewingPreference;

    public UserProfile(){}

    public UserProfile(long userId, String aboutMe, String phoneNumber, String profilePic, long adId, Boolean viewingPreference) {
        this.userId = userId;
        this.aboutMe = aboutMe;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.adId = adId;
        this.viewingPreference = viewingPreference;
    }

    public UserProfile(long id, long userId, String aboutMe, String phoneNumber, String profilePic, long adId, Boolean viewingPreference) {
        this.id = id;
        this.userId = userId;
        this.aboutMe = aboutMe;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.adId = adId;
        this.viewingPreference = viewingPreference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public Boolean getViewingPreference() {
        return viewingPreference;
    }

    public void setViewingPreference(Boolean viewingPreference) {
        this.viewingPreference = viewingPreference;
    }
}
