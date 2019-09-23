package com.example.peakfind;

public class UserDetailsModel {
    String userKey;
    String userId;
    String userName;
    String userNumber;
    String userAddress;

    public UserDetailsModel() {
    }

    public UserDetailsModel(String userKey, String userId, String userName, String userNumber, String userAddress) {
        this.userKey = userKey;
        this.userId = userId;
        this.userName = userName;
        this.userNumber = userNumber;
        this.userAddress = userAddress;
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

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
