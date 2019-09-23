package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Resturent_Form extends AppCompatActivity {

     Button b;
     EditText txtName;
     EditText txtMail;
     EditText txtPhoneNum;
     EditText txtLocation;
     EditText txtHotelName;
     EditText txtWebSite;
     Spinner StarOfHotel;
     Spinner BreakfastInclude;
     Button btnSave;
     CheckBox cbParking,cbFood , cbCar ,cbWifi;
     CheckBox cbGym,playground,children,Massage1,outpool;
     CheckBox cbDouble,cbSingle,cbFamliy,cbLuxary;
     EditText txtOpen , txtClose;

     DatabaseReference databaseResOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent__form);


        databaseResOwner = FirebaseDatabase.getInstance().getReference("ResFormDetails");

        txtName = (EditText) findViewById(R.id.txtName);
        txtMail = (EditText) findViewById(R.id.txtMail);
        txtPhoneNum = (EditText) findViewById(R.id.txtPhoneNum);
        txtLocation =(EditText) findViewById(R.id.txtLocation);
        txtHotelName =(EditText) findViewById(R.id.txtHotelName);
        txtWebSite = (EditText)findViewById(R.id.txtWebSite);
        StarOfHotel =(Spinner) findViewById(R.id.StarOfHotel);
        BreakfastInclude = (Spinner) findViewById(R.id.BreakfastInclude);
        cbParking = (CheckBox) findViewById(R.id.checkBoxParking);
        cbFood = (CheckBox) findViewById(R.id.checkBoxFood);
        cbCar = (CheckBox) findViewById(R.id.checkBoxCar);
        cbWifi = (CheckBox) findViewById(R.id.checkBoxFree);
        cbGym = (CheckBox)findViewById(R.id.Gym);
        playground=(CheckBox)findViewById(R.id.playGround);
        children = (CheckBox)findViewById(R.id.children);
        Massage1 = (CheckBox)findViewById(R.id.Massage);
        outpool =(CheckBox)findViewById(R.id.outpool);
        cbSingle = (CheckBox)findViewById(R.id.cbsingle);
        cbDouble = (CheckBox)findViewById(R.id.cbdouble);
        cbLuxary = (CheckBox)findViewById(R.id.cbluxuary);
        cbFamliy = (CheckBox)findViewById(R.id.cbfamily);
        txtClose =(EditText)findViewById(R.id.editText46);
        txtOpen =(EditText)findViewById(R.id.txtOpen);



        btnSave = (Button) findViewById(R.id.btnSave) ;


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addResturentInfo();

            }
        });



        b=(Button)findViewById(R.id.MenuBtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Resturent_Form.this,Menu_Resturent.class);
                startActivity(i);
            }
        });







    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    private void addResturentInfo(){
        String name  = txtName.getText().toString().trim();
        String mail = txtMail.getText().toString().trim();
        String phoneNum = txtPhoneNum.getText().toString().trim();
        String location = txtLocation.getText().toString().trim();
        String hotelName = txtHotelName.getText().toString().trim();
        String website = txtWebSite.getText().toString().trim();
        String starOfHotel = StarOfHotel.getSelectedItem().toString();
        String breakfast = BreakfastInclude.getSelectedItem().toString();
        String txtclose = txtClose.getText().toString().trim();
        String txtopen = txtOpen.getText().toString().trim();

        String Parking;
        String Food;
        String Car;
        String Wifi;
        String gym;
        String ground;
        String Children;
        String massage;
        String pool;
        String Single;
        String cbdouble;
        String famliy;
        String luxuary;

        if(cbParking.isChecked()){
            Parking = cbParking.getText().toString().trim();

        }else{
            Parking = "";
        }
        if(cbFood.isChecked()){
            Food = cbFood.getText().toString().trim();
        }else{
            Food="";
        }
        if (cbCar.isChecked()){
            Car = cbCar.getText().toString().trim();
        }else{
            Car="";
        }
        if(cbWifi.isChecked()){
            Wifi = cbWifi.getText().toString().trim();
        }else{
            Wifi="";
        }



        if(cbGym.isChecked()){
            gym = cbGym.getText().toString().trim();

        }else{
            gym = "";
        }
        if(playground.isChecked()){
            ground = playground.getText().toString().trim();
        }else{
            ground="";
        }
        if (children.isChecked()){
            Children = children.getText().toString().trim();
        }else{
            Children="";
        }
        if(Massage1.isChecked()){
            massage = Massage1.getText().toString().trim();
        }else{
            massage="";
        }
        if(outpool.isChecked()){
            pool = outpool.getText().toString().trim();
        }else{
            pool="";
        }


        if(cbSingle.isChecked()){
            Single = cbSingle.getText().toString().trim();
        }else{
            Single ="";
        }
        if(cbDouble.isChecked()){
            cbdouble = cbDouble.getText().toString().trim();
        }else{
            cbdouble ="";
        }
        if(cbFamliy.isChecked()){
            famliy = cbFamliy.getText().toString().trim();
        }else{
            famliy ="";
        }
        if(cbLuxary.isChecked()){
            luxuary = cbLuxary.getText().toString().trim();
        }else{
            luxuary ="";
        }




        if(!TextUtils.isEmpty(name)){
           String id = databaseResOwner.push().getKey();
           Resturent_Owner_Form2 Owner =  new Resturent_Owner_Form2(id,name,mail,phoneNum,location,hotelName,website,starOfHotel,breakfast,Parking,Food,Car,Wifi,
                   gym,ground,Children,massage,pool,Single,cbdouble,famliy,luxuary,txtclose,txtopen);


           databaseResOwner.child(id).setValue(Owner);

           Toast.makeText(this,"Successfully added", Toast.LENGTH_SHORT).show();

           Intent hintent = new Intent(Resturent_Form.this,LoginHotelOwnerActivity.class);
           startActivity(hintent);

        }else{
            Toast.makeText(this,"You Should Enter the Details",Toast.LENGTH_LONG).show();
        }

    }

}
