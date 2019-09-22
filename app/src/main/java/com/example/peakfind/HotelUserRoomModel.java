package com.example.peakfind;

public class HotelUserRoomModel {
    String id;
    String HotelName;
    String customerName;
    String customerPhone;
    String date;
    String quantityPeople;
    String roomtype;
    String quantityRoom;
    String quantityNights;

    public HotelUserRoomModel() {
    }

    public HotelUserRoomModel(String hotelName, String customerName, String customerPhone, String date, String quantityPeople, String roomtype, String quantityRoom,String id,String quantityNights) {
        HotelName = hotelName;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.date = date;
        this.quantityPeople = quantityPeople;
        this.roomtype = roomtype;
        this.quantityRoom = quantityRoom;
        this.id=id;
        this.quantityNights=quantityNights;
    }

    public String getId() {
        return id;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getDate() {
        return date;
    }

    public String getQuantityPeople() {
        return quantityPeople;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public String getQuantityRoom() {
        return quantityRoom;
    }



    public String getQuantityNights() {
        return quantityNights;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setQuantityPeople(String quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public void setQuantityRoom(String quantityRoom) {
        this.quantityRoom = quantityRoom;
    }

    public void setQuantityNights(String quantityNights) {
        this.quantityNights = quantityNights;
    }
}
