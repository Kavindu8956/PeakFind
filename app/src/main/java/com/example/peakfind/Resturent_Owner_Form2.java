package com.example.peakfind;

public class Resturent_Owner_Form2 {
    String ResId;
    String name;
    String mail;
    String phoneNum;
    String location;
    String HotelName;
    String website;
    String starOfHotel;
    String breakfast;
    String cbParking;
    String cbFood;
    String cbCar;
    String cbWifi;
    String cbGym;
    String playground;
    String children;
    String massage;
    String outpool;
    String cbSingal;
    String cbDouble;
    String cbLuxuary;
    String cbFamliy;
    String txtOpen,txtClose;



    public  Resturent_Owner_Form2(){

    }




    public Resturent_Owner_Form2(String resId, String name, String mail, String phoneNum, String location, String hotelName, String website,
                                 String starOfHotel, String breakfast, String cbParking, String cbFood, String cbCar, String cbWifi , String cbGym, String playground
                                    , String children , String massage , String outpool, String cbSingal, String cbDouble, String cbLuxuary, String cbFamliy , String txtClose, String txtOpen)


    {
        ResId = resId;
        this.name = name;
        this.mail = mail;
        this.phoneNum = phoneNum;
        this.location = location;
        HotelName = hotelName;
        this.website = website;
        this.starOfHotel = starOfHotel;
        this.breakfast = breakfast;
        this.cbParking = cbParking;
        this.cbFood = cbFood;
        this.cbCar = cbCar;
        this.cbWifi = cbWifi;
        this.cbGym = cbGym;
        this.playground = playground;
        this.children = children;
        this.massage = massage;
        this.outpool = outpool;
        this.cbSingal = cbSingal;
        this.cbDouble = cbDouble;
        this.cbLuxuary = cbLuxuary;
        this.cbFamliy = cbFamliy;
        this.txtOpen = txtOpen;
        this.txtClose = txtClose;



    }

    public String getResId() {
        return ResId;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getLocation() {
        return location;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getWebsite() {
        return website;
    }

    public String getStarOfHotel() {
        return starOfHotel;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public String getCbParking() {
        return cbParking;
    }

    public String getCbFood() {
        return cbFood;
    }

    public String getCbCar() {
        return cbCar;
    }

    public String getCbWifi() {
        return cbWifi;
    }

    public String getCbGym() {
        return cbGym;
    }

    public String getPlayground() {
        return playground;
    }

    public String getChildren() {
        return children;
    }

    public String getMassage() {
        return massage;
    }

    public String getOutpool() {
        return outpool;
    }

    public String getCbSingal() {
        return cbSingal;
    }

    public String getCbDouble() {
        return cbDouble;
    }

    public String getCbLuxuary() {
        return cbLuxuary;
    }

    public String getCbFamliy() {
        return cbFamliy;
    }


    public String getTxtOpen() {
        return txtOpen;
    }

    public String getTxtClose() {
        return txtClose;
    }
}
