package com.example.peakfind;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private String mImageUrl;
    private String mKey;

    public Upload(){
        //empty constructor needed

    }

    public Upload (String name , String imageUrl){

        if(name.trim().equals("")){
            name = "No name";
        }


        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName(){

        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }

    @Exclude
     public String getKey(){
        return mKey;
     }
     @Exclude
     public void setmKey(String key){
        mKey = key;

     }
}
