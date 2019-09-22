package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CabOwnerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_owner_dashboard);

        Button btn = (Button)findViewById(R.id.btnCabOwners);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerDashboardActivity.this, CabOwnerUpdate.class);
                startActivity(intent);
            }
        });

        Button btn2 = (Button)findViewById(R.id.btnRegisterCabs);
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerDashboardActivity.this, CabOwnerEditActivity.class);
                startActivity(intent);
            }
        });


        Button btn3 = (Button)findViewById(R.id.btnviewbooking);
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerDashboardActivity.this, CabBookingViewActivity.class);
                startActivity(intent);
            }
        });



    }
}
