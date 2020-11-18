package com.codeup.adlister.models;

import java.awt.*;
import java.io.File;
import java.sql.Blob;

public class UserPicture {
    private long id;
    private String imgURL;


    public UserPicture(){}

    public UserPicture(String imgURL){
        this.imgURL = imgURL;
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

}
