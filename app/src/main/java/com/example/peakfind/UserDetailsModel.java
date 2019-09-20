package com.example.peakfind;

public class UserDetailsModel {
    String userId;
    String userName;

    public UserDetailsModel() {
    }

    public UserDetailsModel(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
