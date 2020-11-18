package com.codeup.adlister.models;


public class UserPicture {
    private long id;
    private String imgURL;
    private long userID;

    public UserPicture(){}

    public UserPicture(String imgURL, long userID){
        this.imgURL = imgURL;
        this.userID = userID;
    }

    public UserPicture(long id, String imgURL){
        this.id = id;
        this.imgURL = imgURL;
    }

    public long getImgID(){
        return this.id;
    }

    public String getImgURL(){
        return this.imgURL;
    }
    public void setImgURL(String imgURL){
        this.imgURL = imgURL;
    }

    public long getUserID(){
        return this.userID;
    }
}
