package com.example.peakfind;

public class HotelUserTableReservationDetailsModel {
    private String reservationId;
    private String hotelname;
    private String cusName;
    private String cusPhone;
    private String date;
    private String time;
    private String people;

    public HotelUserTableReservationDetailsModel() {
    }

    public HotelUserTableReservationDetailsModel(String reservationId, String cusName, String cusPhone, String date, String time, String people,String hotelname) {
        this.reservationId = reservationId;
        this.cusName = cusName;
        this.hotelname=hotelname;
        this.cusPhone = cusPhone;
        this.date = date;
        this.time = time;
        this.people = people;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCusName() {
        return cusName;
    }

    public String getCusPhone() {
        return cusPhone;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPeople() {
        return people;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public void setCusPhone(String cusPhone) {
        this.cusPhone = cusPhone;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPeople(String people) {
        this.people = people;
    }
}
