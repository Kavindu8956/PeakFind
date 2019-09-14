package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);
    }

    public void customerbtn(View view) {
        Intent intent = new Intent(ChooseTypeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void hotelbtn(View view) {
        Intent intent2 = new Intent(ChooseTypeActivity.this, HotelOwnerActivity.class);
        startActivity(intent2);
    }

    public void cabbtn(View view) {
        Intent intent3 = new Intent(ChooseTypeActivity.this, CabOwnerActivity.class);
        startActivity(intent3);
    }

}
