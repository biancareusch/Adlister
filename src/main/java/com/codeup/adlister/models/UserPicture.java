package com.codeup.adlister.models;

import java.awt.*;
import java.io.File;
import java.sql.Blob;

public class UserPicture {
    private long id;
    private Boolean isMultipart;
    private String filePath;
    private Image file;
    private Blob fileBlob;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;

    public UserPicture(){}

    public UserPicture(Boolean isMultipart, String filePath, Blob file){
        this.filePath = filePath;
        this.fileBlob = file;
        this.isMultipart = isMultipart;
        int maxFileSize = 50 * 1024;
        int maxMemSize = 4 * 1024;
    }

    public UserPicture(long id, String filePath, Blob file){
        this.id = id;
        this.filePath = filePath;
        this.fileBlob = file;
        int maxFileSize = 50 * 1024;
        int maxMemSize = 4 * 1024;
    }

//    public UserPicture(long id, String filePath, Image file) {
//        this.id = id;
//        this.filePath = filePath;
//        this.fileBlob = fileBlob;
//        int maxFileSize = 50 * 1024;
//        int maxMemSize = 4 * 1024;
//    }

    public long getPictureID(){
        return this.id;
    }

    public String getPictureFilePath(){
        return this.filePath;
    }
    public void setPictureFilePath(String filePath){
        this.filePath = filePath;
    }
    public Blob getPictureFile(){
        return (Blob) this.file;
    }
    public Boolean getMultipart(){
        return this.isMultipart;
    }
}
