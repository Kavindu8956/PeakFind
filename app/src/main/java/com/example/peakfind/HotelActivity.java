package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HotelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
    }
    public void hotelDetails(View v) {
        Intent intentHotelDetails = new Intent(HotelActivity.this,HotelInfoActivity.class);
        startActivity(intentHotelDetails);
    }
}
