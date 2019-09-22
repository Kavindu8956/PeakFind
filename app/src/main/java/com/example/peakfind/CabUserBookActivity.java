package com.example.peakfind;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CabUserBookActivity extends AppCompatActivity {

    EditText CustomerName,PickupLocation,Destination,PickupDate,PickupTime,MobileNo,VehicleType;
    Button btnbooknow;
    DatabaseReference dbref;
    CabBookDetails cabBD;

    private void clearControls() {
        CustomerName.setText("");
        PickupLocation.setText("");
        Destination.setText("");
        MobileNo.setText("");
        PickupDate.setText("");
        PickupTime.setText("");
        VehicleType.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabuserbook);

        dbref = FirebaseDatabase.getInstance().getReference("CabBookingDetails");

        CustomerName = (EditText)findViewById(R.id.cusname);
        PickupLocation = (EditText)findViewById(R.id.picklocation);
        Destination = (EditText)findViewById(R.id.destination);
        MobileNo = (EditText)findViewById(R.id.mobileNo);
        PickupDate = (EditText)findViewById(R.id.pickdate);
        PickupTime = (EditText)findViewById(R.id.picktime);
        VehicleType = (EditText)findViewById(R.id.VehicleType);

        btnbooknow = (Button)findViewById(R.id.btnbooknow);

        cabBD = new CabBookDetails();

        btnbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbref = FirebaseDatabase.getInstance().getReference("CabBookingDetails");

                if (TextUtils.isEmpty(CustomerName.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Customer Name",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(PickupLocation.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Pickup Location6",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(Destination.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Destination",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(PickupDate.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Pickup Date",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(PickupTime.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Pickup Time",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(MobileNo.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Mobile No",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(VehicleType.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Please Enter Vehicle",Toast.LENGTH_SHORT).show();
                }
                else{
                   cabBD.setKey(dbref.push().getKey());
                   cabBD.setDestination(Destination.getText().toString().trim());
                   cabBD.setPickupLocation(PickupLocation.getText().toString().trim());
                   cabBD.setPickupDate(PickupDate.getText().toString().trim());
                   cabBD.setPickupTime(PickupTime.getText().toString().trim());
                   cabBD.setVehicleType(VehicleType.getText().toString().trim());
                   cabBD.setMobileNo(Integer.parseInt(MobileNo.getText().toString().trim()));

                    dbref.child(cabBD.getKey()).setValue(cabBD);
                    Toast.makeText(getApplicationContext(), "Adding Success", Toast.LENGTH_LONG).show();
                    cleanData();
                }

            }
        });
    }

    public void cleanData(){
        CustomerName.setText("");
        Destination.setText("");
        PickupLocation.setText("");
        MobileNo.setText("");
        PickupTime.setText("");
        PickupDate.setText("");
        VehicleType.setText("");

    }
}
