package com.example.peakfind;

public class CabBookDetails {
    private String key;
    private String CustomerName;
    private String PickupLocation;
    private String Destination;
    private String PickupDate;
    private String PickupTime;
    private int MobileNo;
    private String VehicleType;

    public CabBookDetails(){

    }

    public CabBookDetails(String customerName, String pickupLocation, String destination, String pickupDate, String pickupTime, int mobileNo, String vehicleType) {
        this.key = key;
        this.CustomerName = customerName;
        this.PickupLocation = pickupLocation;
        this.Destination = destination;
        this.PickupDate = pickupDate;
        this.PickupTime = pickupTime;
        this.MobileNo = mobileNo;
        this.VehicleType = vehicleType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getPickupLocation() {
        return PickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        PickupLocation = pickupLocation;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getPickupDate() {
        return PickupDate;
    }

    public void setPickupDate(String pickupDate) {
        PickupDate = pickupDate;
    }

    public String getPickupTime() {
        return PickupTime;
    }

    public void setPickupTime(String pickupTime) {
        PickupTime = pickupTime;
    }

    public int getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(int mobileNo) {
        MobileNo = mobileNo;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

}
