package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private Button bt1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=(Button)findViewById(R.id.btnEdit);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });
    }

    public void hotel(View v) {
        Intent intentHotel = new Intent(MainActivity.this,HotelSelect.class);
        startActivity(intentHotel);
    }

    public void cab(View v) {
        Intent intentCab = new Intent(MainActivity.this, CabUserListShowActivity.class);
        startActivity(intentCab);
    }
    public void shoppingmall(View v) {
        Intent intentShoppingMall = new Intent(MainActivity.this,UserProfileDetailsShowActivity.class);
        startActivity(intentShoppingMall);
    }
    public void weather(View v) {
        Intent intentWeather = new Intent(MainActivity.this,Resturent_Form.class);
        startActivity(intentWeather);
    }
}
