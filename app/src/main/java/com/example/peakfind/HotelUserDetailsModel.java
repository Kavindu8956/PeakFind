package com.example.peakfind;

public class HotelUserDetailsModel {
    private String hotelId;
    private String HotelName;
    private String HotelLocation;

    public HotelUserDetailsModel() {
    }

    public HotelUserDetailsModel(String hotelId, String hotelName, String hotelLocation) {
        this.hotelId = hotelId;
        HotelName = hotelName;
        HotelLocation = hotelLocation;
    }


    public String getHotelName() {

        return HotelName;
    }

    public String getHotelLocation() {

        return HotelLocation;
    }
}
