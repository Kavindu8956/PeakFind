package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    public static final String Hotel_Name="HotelName";
    public static final String Email="mail";
    public static final String PhoneNumber="phoneNum";
    public static final String Location="location";
    public static final String address="website";

    private ListView hotelListView;
    Resturent_Owner_Form2 rest;
    private List<Resturent_Owner_Form2> hotelList;
    DatabaseReference databaseHotel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteluser_listview);

        databaseHotel= FirebaseDatabase.getInstance().getReference("ResFormDetails");

        hotelListView=(ListView) findViewById(R.id.hotelList) ;
        hotelList=new ArrayList<>();

        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Resturent_Owner_Form2 restownerForm2=hotelList.get(i);
                Intent intent1=new Intent(getApplicationContext(),HotelInfoActivity.class);

                intent1.putExtra(Hotel_Name,restownerForm2.getHotelName());
                intent1.putExtra(Email,restownerForm2.getMail());
                intent1.putExtra(PhoneNumber,restownerForm2.getPhoneNum());
                intent1.putExtra(Location,restownerForm2.getLocation());
                intent1.putExtra(address,restownerForm2.getWebsite());
                startActivity(intent1);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseHotel.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot hotelSnapshot:dataSnapshot.getChildren()){
                    Resturent_Owner_Form2 hotel=hotelSnapshot.getValue(Resturent_Owner_Form2.class);
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
