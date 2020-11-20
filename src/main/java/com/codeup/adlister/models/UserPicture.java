package com.codeup.adlister.models;


import java.util.Date;

public class UserPicture {
    private long id;
    private String imgURL;
    private long userID;
    private String alt_text;

    public UserPicture(){}

    public UserPicture(String imgURL, long userID){
        this.imgURL = imgURL;
        this.userID = userID;
    }

    public UserPicture(long id, String imgURL){
        this.id = id;
        this.imgURL = imgURL;
    }

    public UserPicture(long id, String imgURL, String alt_text, long user_id) {
        this.id = id;
        this.imgURL = imgURL;
        this.alt_text = alt_text;
        this.userID = user_id;
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
