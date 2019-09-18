package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HotelOwnerActivity extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelowner);
/*
        b =(Button) findViewById(R.id.btnEdit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HotelOwnerActivity.this,Resturent_Form.class);
                startActivity(i);
            }
        });

*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        return true;
    }
    public void hotelowner(View view) {
        Intent intentHotelowner = new Intent(HotelOwnerActivity.this,Resturent_Form.class);
        startActivity(intentHotelowner);
    }




}
