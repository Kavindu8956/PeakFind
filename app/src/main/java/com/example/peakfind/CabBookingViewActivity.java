package com.example.peakfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CabBookingViewActivity extends AppCompatActivity {

    DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("CabBookingDetails");
    ListView listView1;

    List<CabBookDetails> cabBookDetails;
    CabBookDetails cabbookdetails;


    public static final String Customer_Name = "customer name";
    public static final String Data_KEY = "customer_key";
    public static final String Pickup_Location = "pickup location";
    public static final String Destination_ = "destination";
    public static final String Mobile_No = "mobile no";
    public static final String Pickup_Date = "pickup date";
    public static final String Pickup_Time = "pickup time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_booking_view);

        listView1 = findViewById(R.id.listviewcustomerbooking);

        cabBookDetails = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cabBookDetails.clear();

                for(DataSnapshot cabOwnerSnapshot : dataSnapshot.getChildren()){
                    CabBookDetails cabDetails11 = cabOwnerSnapshot.getValue(CabBookDetails.class);

                    cabBookDetails.add(cabDetails11);
                }

                CabBookingViewList adapter1 = new CabBookingViewList(CabBookingViewActivity.this,cabBookDetails);
                listView1.setAdapter(adapter1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
