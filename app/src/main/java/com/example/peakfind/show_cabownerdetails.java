package com.example.peakfind;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class show_cabownerdetails extends AppCompatActivity {



    DatabaseReference dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails");
    ListView listView;

    List<CabDetails> cabDetails;
    CabDetails cabdetails;




    public static final String Owner_Name = "owner name";
    public static final String Data_KEY = "owner_key";
    public static final String Company_Name = "company name";
    public static final String City_ = "city";
    public static final String Mobile_No = "mobile no";
    public static final String Email_ = "email";
    public static final String Vehicle_1 = "vehicle 1";
    public static final String Vehicle_2 = "vehicle 2";
    public static final String Vehicle_3 = "vehicle 3";
    public static final String Vehicle_4 = "vehicle 4";
    public static final String num_1 = "number 1";
    public static final String num_2 = "number 2";
    public static final String num_3 = "number 3";
    public static final String num_4 = "number 4";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cabownerdetails);

        listView = findViewById(R.id.listView);

        cabDetails = new ArrayList<>();



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                cabdetails = cabDetails.get(i);

                Intent intent = new Intent(getApplicationContext(),CabOwnerUpdate.class);

                intent.putExtra(Data_KEY,cabdetails.getKey());
                intent.putExtra(Owner_Name, cabdetails.getOwnerName());
                intent.putExtra(Company_Name, cabdetails.getCompanyName());
                intent.putExtra(City_, cabdetails.getCity());
                intent.putExtra(Mobile_No, cabdetails.getMobileNo());
                intent.putExtra(Email_, cabdetails.getEmail());
                intent.putExtra(Vehicle_1, cabdetails.getVehicle1());
                intent.putExtra(Vehicle_2, cabdetails.getVehicle2());
                intent.putExtra(Vehicle_3, cabdetails.getVehicle3());
                intent.putExtra(Vehicle_4, cabdetails.getVehicle4());
                intent.putExtra(num_1, cabdetails.getNum1());
                intent.putExtra(num_2, cabdetails.getNum2());
                intent.putExtra(num_3, cabdetails.getNum3());
                intent.putExtra(num_4, cabdetails.getNum4());

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

                CabOwnerDetailsList adapter = new CabOwnerDetailsList(show_cabownerdetails.this,cabDetails);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }










}

