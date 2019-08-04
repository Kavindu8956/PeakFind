package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hotel(View v) {
        Intent intentHotel = new Intent(MainActivity.this,HotelActivity.class);
        startActivity(intentHotel);
    }

    public void cab(View v) {
        Intent intentCab = new Intent(MainActivity.this,CabActivity.class);
        startActivity(intentCab);
    }
    public void shoppingmall(View v) {
        Intent intentShoppingMall = new Intent(MainActivity.this,ShoppingMallActivity.class);
        startActivity(intentShoppingMall);
    }
    public void weather(View v) {
        Intent intentWeather = new Intent(MainActivity.this,WeatherActivity.class);
        startActivity(intentWeather);
    }
}
