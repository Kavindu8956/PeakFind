package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        button=(Button)findViewById(R.id.detailbutton) ;
       button.setOnClickListener(new View.OnClickListener() {
        //   @Override
          public void onClick(View view) {
            Intent intent=new Intent(Activity3.this,UbdateReservation.class);
               startActivity(intent);
            }
        });

    }
}
