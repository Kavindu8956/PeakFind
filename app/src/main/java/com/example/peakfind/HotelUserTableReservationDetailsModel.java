package com.example.peakfind;

public class HotelUserTableReservationDetailsModel {
    private String reservationId;
    private String date;
    private String Time;
    private String people;

    public HotelUserTableReservationDetailsModel() {
    }

    public HotelUserTableReservationDetailsModel(String reservationId, String date, String time, String people) {
        this.reservationId = reservationId;
        this.date = date;
        Time = time;
        this.people = people;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return Time;
    }

    public String getPeople() {
        return people;
    }
}
