package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class HotelOwnerActivity extends AppCompatActivity {

    private Button b;
    Button  show_btn;

    TextView HotelName, Location, phoneNum, Email, Website, breakfast,hotelStar;
    TextView FreeParking,Food,car,wifi,gym,play,children,Massage,single,double1,luxuary,family;

    DatabaseReference databaseResOwner;

    FirebaseUser userid;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelowner);

        userid = FirebaseAuth.getInstance().getCurrentUser();
        uid = userid.getUid();

        DatabaseReference dbRef;
        Resturent_Owner_Form2 Res;

        String x;
        //String key = "LpKDcgq1FIL9jgXlBtS";



        Query query = FirebaseDatabase.getInstance().getReference("ResFormDetails").orderByChild("resId").equalTo(uid);

        query.addListenerForSingleValueEvent(valueEventListener);

        HotelName = (TextView) findViewById(R.id.txtHotelN2);
        Location = (TextView) findViewById(R.id.txtLocation2);
        phoneNum = (TextView) findViewById(R.id.txtphoneNum2);
        Email = (TextView) findViewById(R.id.txtEmail2);
        Website = (TextView) findViewById(R.id.txtWebsite2);
        breakfast = (TextView) findViewById(R.id.txtbreakfast2);
        hotelStar = (TextView)findViewById(R.id.StarOfHotel2);
        FreeParking = (TextView)findViewById(R.id.Parking);
        Food = (TextView) findViewById(R.id.Food);
        wifi = (TextView)findViewById(R.id.freeWifi);
        car = (TextView)findViewById(R.id.carHire);
        gym =(TextView)findViewById(R.id.Fitness);
        play=(TextView)findViewById(R.id.playGround2);
        children =(TextView)findViewById(R.id.pool);
        Massage =(TextView)findViewById(R.id.Massage2);
        single =(TextView)findViewById(R.id.single);
        double1 =(TextView)findViewById(R.id.Double1);
        family =(TextView)findViewById(R.id.Family);
        luxuary =(TextView)findViewById(R.id.Luxury);




        show_btn =(Button) findViewById(R.id.btnEdit);


/*

        b =(Button) findViewById(R.id.btnEdit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HotelOwnerActivity.this,Resturent_Form.class);
                startActivity(i);
            }
        });

*/

        b = (Button) findViewById(R.id.MenuBtn2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HotelOwnerActivity.this,ImagesActivity.class);
                startActivity(i);
            }
        });


    }

    public void clearData() {
        HotelName.setText("");
        Location.setText("");
        phoneNum.setText("");
        Email.setText("");
        Website.setText("");
        breakfast.setText("");
        hotelStar.setText("");
        show_btn.setText("");
        FreeParking.setText("");
        Food.setText("");
        car.setText("");
        wifi.setText("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    public void hotelowner(View view) {
        Intent intentHotelowner = new Intent(HotelOwnerActivity.this, Resturent_Form.class);
        startActivity(intentHotelowner);
    }




    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Resturent_Owner_Form2 Res = snapshot.getValue(Resturent_Owner_Form2.class);
                    HotelName.setText(Res.getHotelName());
                    phoneNum.setText(Res.getPhoneNum());
                    Location.setText(Res.getLocation());
                    Email.setText(Res.getMail());
                    Website.setText(Res.getWebsite());
                    breakfast.setText(Res.getBreakfast());
                    hotelStar.setText(Res.getStarOfHotel());
                    FreeParking.setText(Res.getCbParking());
                    Food.setText(Res.getCbFood());
                    wifi.setText(Res.getCbWifi());
                    car.setText(Res.getCbCar());
                    gym.setText(Res.getCbGym());
                    play.setText(Res.getPlayground());
                    children.setText(Res.getChildren());
                    Massage.setText(Res.getMassage());
                    single.setText(Res.getCbSingal());
                    double1.setText(Res.getCbDouble());
                    family.setText(Res.getCbFamliy());
                    luxuary.setText(Res.getCbLuxuary());
                }
            }

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };





}

