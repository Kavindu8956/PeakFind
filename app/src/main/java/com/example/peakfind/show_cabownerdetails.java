package com.example.peakfind;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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

public class show_cabownerdetails extends AppCompatActivity {
    EditText OwnerName,CompanyName,City,MobileNo,Email,Vehicle1,Vehicle2,Vehicle3,Vehicle4;
    Button BtnSave;
    DatabaseReference dbref = FirebaseDatabase.getInstance().getReference("CabDetails");
    CabDetails cbd;

    ListView listView;

    List<CabDetails> cabDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cabownerdetails);

        listView = (ListView) findViewById(R.id.listView);

        cabDetails = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbref.addValueEventListener(new ValueEventListener() {
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

