package com.example.peakfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CabUserListShowActivity extends AppCompatActivity {


    DatabaseReference dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails");
    ListView listView111;

    List<CabDetails> cabDetails;
    CabDetails cabdetails;

    public static final String Cab_Owner_Name = "owner name";
    public static final String Cab_Data_KEY = "owner_key";
    public static final String Cab_Company_Name = "company name";
    public static final String Cab_City_ = "city";
    public static final String Cab_Mobile_No = "mobile no";
    public static final String Cab_Email_ = "email";
    public static final String Cab_Vehicle_1 = "vehicle 1";
    public static final String Cab_Vehicle_2 = "vehicle 2";
    public static final String Cab_Vehicle_3 = "vehicle 3";
    public static final String Cab_Vehicle_4 = "vehicle 4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabuser__list__show);
        listView111 = findViewById(R.id.listview1);
        cabDetails = new ArrayList<>();

        listView111.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                cabdetails = cabDetails.get(i);
                Intent intent = new Intent(getApplicationContext(),CabUserDetailsActivity.class);

                intent.putExtra(Cab_Data_KEY,cabdetails.getKey());
                intent.putExtra(Cab_Owner_Name, cabdetails.getOwnerName());
                intent.putExtra(Cab_Company_Name, cabdetails.getCompanyName());
                intent.putExtra(Cab_City_, cabdetails.getCity());
                intent.putExtra(Cab_Mobile_No, cabdetails.getMobileNo());
                intent.putExtra(Cab_Email_, cabdetails.getEmail());
                intent.putExtra(Cab_Vehicle_1, cabdetails.getVehicle1());
                intent.putExtra(Cab_Vehicle_2, cabdetails.getVehicle2());
                intent.putExtra(Cab_Vehicle_3, cabdetails.getVehicle3());
                intent.putExtra(Cab_Vehicle_4, cabdetails.getVehicle4());

                startActivity(intent);
            }
        });


    }




    @Override
    protected void onStart() {
        super.onStart();

        dbref222.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                cabDetails.clear();

                for(DataSnapshot cabOwnerSnapshot : dataSnapshot.getChildren()){
                    CabDetails cabDetails2 = cabOwnerSnapshot.getValue(CabDetails.class);

                    cabDetails.add(cabDetails2);
                }

                CabUser_cabdetails adapter = new CabUser_cabdetails(CabUserListShowActivity.this,cabDetails);
                listView111.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
}}
