package com.example.peakfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CabOwnerUpdate extends AppCompatActivity {


    CabDetails cabdetails;
    EditText OwnerName,CompanyName,City,MobileNo,Email,vehicle1,vehicle2,vehicle3,vehicle4,num1,num2,num3,num4;;

    Button updateBtn,DeleteBtn;
    DatabaseReference dbref222;

    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_owner_update);

        userid = FirebaseAuth.getInstance().getCurrentUser();
        uid = userid.getUid();

        mAuth = FirebaseAuth.getInstance();


        Query query = FirebaseDatabase.getInstance().getReference("CabDetails").orderByChild("key").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        cabdetails = new CabDetails();

        OwnerName = findViewById(R.id.txtowner);
        CompanyName = findViewById(R.id.txtcompany);
        City = findViewById(R.id.txtcity);
        MobileNo = findViewById(R.id.txtmobile);
        Email = findViewById(R.id.txtemail);
        vehicle1 = findViewById(R.id.txtvehicle1update);
        vehicle2 = findViewById(R.id.txtvehicle2update);
        vehicle3 = findViewById(R.id.txtvehicle3update);
        vehicle4 = findViewById(R.id.txtvehicle4update);
        num1 = findViewById(R.id.txtnum1update);
        num2 = findViewById(R.id.txtnum2update);
        num3 = findViewById(R.id.txtnum3update);
        num4 = findViewById(R.id.txtnum4update);
        updateBtn = findViewById(R.id.btnUpdate);
        DeleteBtn = findViewById(R.id.btnDelete);



        Intent intent = getIntent();

        final String key = intent.getStringExtra(show_cabownerdetails.Data_KEY);
        final String Oname = intent.getStringExtra(show_cabownerdetails.Owner_Name);
        final String Cname = intent.getStringExtra(show_cabownerdetails.Company_Name);
        final String city = intent.getStringExtra(show_cabownerdetails.City_);
        final int Mnum = intent.getIntExtra(show_cabownerdetails.Mobile_No,0);
        final String email = intent.getStringExtra(show_cabownerdetails.Email_);
        final String V1 = intent.getStringExtra(show_cabownerdetails.Vehicle_1);
        final String V2 = intent.getStringExtra(show_cabownerdetails.Vehicle_2);
        final String V3 = intent.getStringExtra(show_cabownerdetails.Vehicle_3);
        final String V4 = intent.getStringExtra(show_cabownerdetails.Vehicle_4);
        final int N1 = intent.getIntExtra(show_cabownerdetails.num_1,0);
        final int N2 = intent.getIntExtra(show_cabownerdetails.num_2,0);
        final int N3 = intent.getIntExtra(show_cabownerdetails.num_3,0);
        final int N4 = intent.getIntExtra(show_cabownerdetails.num_4,0);

            OwnerName.setText(Oname);
            CompanyName.setText(Cname);
            City.setText(city);
            MobileNo.setText(Integer.toString(Mnum));
            Email.setText(email);
            vehicle1.setText(V1);
            vehicle2.setText(V2);
            vehicle3.setText(V3);
            vehicle4.setText(V4);
            num1.setText(Integer.toString(N1));
            num2.setText(Integer.toString(N2));
            num3.setText(Integer.toString(N3));
            num4.setText(Integer.toString(N4));


           dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails").child(key);

         updateBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                cabdetails.setKey(key);
                cabdetails.setOwnerName(OwnerName.getText().toString());
                cabdetails.setCompanyName(CompanyName.getText().toString());
                cabdetails.setCity(City.getText().toString());
                cabdetails.setMobileNo(Integer.parseInt(MobileNo.getText().toString()));
                cabdetails.setEmail(Email.getText().toString());
                cabdetails.setVehicle1(vehicle1.getText().toString());
                cabdetails.setVehicle2(vehicle2.getText().toString());
                cabdetails.setVehicle3(vehicle3.getText().toString());
                cabdetails.setVehicle4(vehicle4.getText().toString());
                cabdetails.setNum1(Integer.parseInt(num1.getText().toString()));
                cabdetails.setNum2(Integer.parseInt(num2.getText().toString()));
                cabdetails.setNum3(Integer.parseInt(num3.getText().toString()));
                cabdetails.setNum4(Integer.parseInt(num4.getText().toString()));

                dbref222.setValue(cabdetails);

                 Toast.makeText(getApplicationContext(),"Details Updated",Toast.LENGTH_SHORT).show();
             }
         });



       DeleteBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dbref222.removeValue();
               Toast.makeText(getApplicationContext(),"Successfully Deleted",Toast.LENGTH_SHORT).show();

               cleanData();
           }


       });
       }

    public void cleanData(){
        OwnerName.setText("");
        CompanyName.setText("");
        City.setText("");
        MobileNo.setText("");
        Email.setText("");
        vehicle1.setText("");
        vehicle2.setText("");
        vehicle3.setText("");
        vehicle4.setText("");
        num1.setText("");
        num2.setText("");
        num3.setText("");
        num4.setText("");
    }



    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){

                    CabDetails cabDetails = snapshot.getValue(CabDetails.class);

                    OwnerName.setText(cabDetails.getOwnerName());
                    CompanyName.setText(cabDetails.getCompanyName());
                    City.setText(cabDetails.getCity());
                    MobileNo.setText(cabDetails.getMobileNo());
                    Email.setText(cabDetails.getEmail());
                    vehicle1.setText(cabDetails.getVehicle1());
                    vehicle2.setText(cabDetails.getVehicle2());
                    vehicle3.setText(cabDetails.getVehicle3());
                    vehicle4.setText(cabDetails.getVehicle4());
                    num1.setText(cabDetails.getNum1());
                    num2.setText(cabDetails.getNum2());
                    num3.setText(cabDetails.getNum3());
                    num4.setText(cabDetails.getNum4());

                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };




}

