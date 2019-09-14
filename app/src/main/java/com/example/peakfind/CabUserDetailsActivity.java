package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CabUserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabuserdetails);


        Intent intent = new Intent(CabUserDetailsActivity.this, CabUserBookActivity.class);
        startActivity(intent);




    }
}
