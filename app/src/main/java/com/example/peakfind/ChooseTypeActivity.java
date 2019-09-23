package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_type);

        findViewById(R.id.buttonCustomer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcustomer = new Intent(ChooseTypeActivity.this,MainActivity.class);
                startActivity(intentcustomer);
            }
        });

        findViewById(R.id.buttonHotel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ChooseTypeActivity.this, LoginHotelOwnerActivity.class);
                startActivity(intent2);
            }
        });


        findViewById(R.id.buttonCab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(ChooseTypeActivity.this, LoginCabOwnerActivity.class);
                startActivity(intent3);
            }
        });




    }







}
