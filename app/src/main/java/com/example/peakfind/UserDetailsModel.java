package com.example.peakfind;

public class UserDetailsModel {
    String userId;
    String userName;
    String userNumber;

    public UserDetailsModel() {
    }

    public UserDetailsModel(String userId, String userName, String userNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userNumber = userNumber;
    }

    public String getUserId() {

        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserNumber() {
        return userNumber;
    }
}
