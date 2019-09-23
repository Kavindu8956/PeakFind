package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HotelSelect extends AppCompatActivity {


    private Button btn;
    private Button btn1;
    private Button btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_select);

        btn=(Button)findViewById(R.id.button7);

        btn2=(Button)findViewById(R.id.list) ;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HotelSelect.this,HotelActivity.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(HotelSelect.this,HotelUserListView.class);
                startActivity(intent2);
            }
        });
    }
}
