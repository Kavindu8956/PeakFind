package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CabUserDetailsActivity extends AppCompatActivity {



    CabDetails cabdetails;
    TextView OwnerName,CompanyName,City,MobileNo,Email,vehicle1,vehicle2,vehicle3,vehicle4;

    Button btnBook;
    DatabaseReference dbref222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabuserdetails);

        cabdetails = new CabDetails();

        OwnerName = findViewById(R.id.CabOwnerName);
        CompanyName = findViewById(R.id.CabCompanyName);
        City = findViewById(R.id.CabCity);
        MobileNo = findViewById(R.id.CabMobileNo);
        Email = findViewById(R.id.CabEmail);
        vehicle1 = findViewById(R.id.CabVehicle1);
        vehicle2 = findViewById(R.id.CabVehicle2);
        vehicle3 = findViewById(R.id.CabVehicle3);
        vehicle4 = findViewById(R.id.CabVehicle4);

        Intent intent = getIntent();

        final String key = intent.getStringExtra(CabUserListShowActivity.Cab_Data_KEY);
        final String Oname = intent.getStringExtra(CabUserListShowActivity.Cab_Owner_Name);
        final String Cname = intent.getStringExtra(CabUserListShowActivity.Cab_Company_Name);
        final String city = intent.getStringExtra(CabUserListShowActivity.Cab_City_);
        final int Mnum = intent.getIntExtra(CabUserListShowActivity.Cab_Mobile_No,0);
        final String email = intent.getStringExtra(CabUserListShowActivity.Cab_Email_);
        final String V1 = intent.getStringExtra(CabUserListShowActivity.Cab_Vehicle_1);
        final String V2 = intent.getStringExtra(CabUserListShowActivity.Cab_Vehicle_2);
        final String V3 = intent.getStringExtra(CabUserListShowActivity.Cab_Vehicle_3);
        final String V4 = intent.getStringExtra(CabUserListShowActivity.Cab_Vehicle_4);

        OwnerName.setText(Oname);
        CompanyName.setText(Cname);
        City.setText(city);
        MobileNo.setText(Integer.toString(Mnum));
        Email.setText(email);
        vehicle1.setText(V1);
        vehicle2.setText(V2);
        vehicle3.setText(V3);
        vehicle4.setText(V4);

        dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails").child(key);

    }

    public void BtnBook(View view){


        Intent intent = new Intent(CabUserDetailsActivity.this, CabUserBookActivity.class);
        startActivity(intent);
    }
}
