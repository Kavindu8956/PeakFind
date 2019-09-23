package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HotelInfoActivity extends AppCompatActivity {

    //ViewFlipper v_flipper;

    DatabaseReference ReservationDetails;
    Resturent_Owner_Form2 rest;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private Button btn1;
    private Button btn2;
    public static final String Hotel_Name="HotelName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView myImageview;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelinfo);
        ReservationDetails= FirebaseDatabase.getInstance().getReference("Reservation");

        tv1=(TextView)findViewById(R.id.HotelTopic);
        tv2=(TextView)findViewById(R.id.LocationView);
        tv3=(TextView)findViewById(R.id.emailView);
        tv4=(TextView)findViewById(R.id.Address);
        tv5=(TextView)findViewById(R.id.phoneView);
        btn1=(Button)findViewById(R.id.roomBooking);
        btn2=(Button)findViewById(R.id.tableRearve);

        final Intent intent=getIntent();

        final String HotelName=intent.getStringExtra(HotelUserListView.Hotel_Name);
        final String mail=intent.getStringExtra(HotelUserListView.Email);
        final String web=intent.getStringExtra(HotelUserListView.address);
        final String phone=intent.getStringExtra(HotelUserListView.PhoneNumber);
        final String location=intent.getStringExtra(HotelUserListView.Location);

        tv1.setText(HotelName);
        tv2.setText(location);
        tv3.setText(mail);
        tv4.setText(web);
        tv5.setText(phone);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it1=new Intent(HotelInfoActivity.this,ReservationFormActivity.class);
                it1.putExtra(Hotel_Name,HotelName);
                startActivity(it1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(HotelInfoActivity.this,HotelUserTableReservation.class);
                it2.putExtra(Hotel_Name,HotelName);
                startActivity(it2);
            }
        });

    }

}
