package com.example.peakfind;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HotelUserListView extends AppCompatActivity {


    private ListView hotelListView;
    private List<HotelUserDetailsModel> hotelList;
    DatabaseReference databaseHotel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteluser_listview);

        databaseHotel= FirebaseDatabase.getInstance().getReference("Hotel");

        hotelListView=(ListView) findViewById(R.id.hotelList) ;
        hotelList=new ArrayList<>();



    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseHotel.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot hotelSnapshot:dataSnapshot.getChildren()){
                    HotelUserDetailsModel hotel=hotelSnapshot.getValue(HotelUserDetailsModel.class);
                    hotelList.add(hotel);
                }

                HotelUserListModel adapter=new HotelUserListModel(HotelUserListView.this,hotelList);
                hotelListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
