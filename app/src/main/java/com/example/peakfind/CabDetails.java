package com.example.peakfind;

public class CabDetails {

    private String key;
    private String ownerName;
    private String companyName;
    private String city;
    private int mobileNo;
    private String email;
    private  String vehicle1;
    private String vehicle2;
    private String vehicle3;
    private String vehicle4;

    public CabDetails() {
    }

    public CabDetails(String key, String ownerName, String companyName, String city, int mobileNo, String email, String vehicle1, String vehicle2, String vehicle3, String vehicle4) {
        this.key = key;
        this.ownerName = ownerName;
        this.companyName = companyName;
        this.city = city;
        this.mobileNo = mobileNo;
        this.email = email;
        this.vehicle1 = vehicle1;
        this.vehicle2 = vehicle2;
        this.vehicle3 = vehicle3;
        this.vehicle4 = vehicle4;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVehicle1() {
        return vehicle1;
    }

    public void setVehicle1(String vehicle1) {
        this.vehicle1 = vehicle1;
    }

    public String getVehicle2() {
        return vehicle2;
    }

    public void setVehicle2(String vehicle2) {
        this.vehicle2 = vehicle2;
    }

    public String getVehicle3() {
        return vehicle3;
    }

    public void setVehicle3(String vehicle3) {
        this.vehicle3 = vehicle3;
    }

    public String getVehicle4() {
        return vehicle4;
    }

    public void setVehicle4(String vehicle4) {
        this.vehicle4 = vehicle4;
    }
}





