package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class CabOwnerEditActivity extends AppCompatActivity {


    EditText OwnerName,CompanyName,City,MobileNo,Email,vehicle1,vehicle2,vehicle3,vehicle4,num1,num2,num3,num4;
    Button BtnSave,BtnUpload;
    DatabaseReference dbref222;
    CabDetails cbd;

    ListView listViewcab;

    List<CabDetails>cabDetails;




   private void clearControls() {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabowneredit);



            dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails");

            OwnerName = (EditText)findViewById(R.id.txtowner);
            CompanyName = (EditText)findViewById(R.id.txtcompany);
            City = (EditText)findViewById(R.id.txtcity);
            MobileNo = (EditText)findViewById(R.id.txtmobile);
            Email = (EditText)findViewById(R.id.txtemail);
            vehicle1 = (EditText)findViewById(R.id.txtvehicle1update);
            vehicle2 = (EditText)findViewById(R.id.txtvehicle3update);
            vehicle3 = (EditText)findViewById(R.id.txtvehicle2update);
            vehicle4 = (EditText)findViewById(R.id.txtvehicle4update);
            num1 = (EditText)findViewById(R.id.editTextnum1);
            num2 = (EditText)findViewById(R.id.editTextnum2);
            num3 = (EditText)findViewById(R.id.editTextnum3);
            num4 = (EditText)findViewById(R.id.editTextnum4);

            BtnSave = (Button)findViewById(R.id.button);
            BtnUpload = (Button)findViewById(R.id.button10) ;


            cbd = new CabDetails();




            BtnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dbref222 = FirebaseDatabase.getInstance().getReference("CabDetails");

                    if (TextUtils.isEmpty(OwnerName.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Owner Name",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(CompanyName.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Company Name",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(City.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter City",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(MobileNo.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Mobile No",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(Email.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Email",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vehicle1.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Vehicle",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vehicle2.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Vehicle",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vehicle3.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Vehicle",Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(vehicle4.getText().toString())){
                        Toast.makeText(getApplicationContext(),"Please Enter Vehicle",Toast.LENGTH_SHORT).show();
                    }

                    else {

                        cbd.setKey(dbref222.push().getKey());
                        cbd.setOwnerName(OwnerName.getText().toString().trim());
                        cbd.setCompanyName(CompanyName.getText().toString().trim());
                        cbd.setCity(City.getText().toString().trim());
                        cbd.setMobileNo(Integer.parseInt(MobileNo.getText().toString().trim()));
                        cbd.setEmail(Email.getText().toString().trim());
                        cbd.setVehicle1(vehicle1.getText().toString().trim());
                        cbd.setVehicle2(vehicle2.getText().toString().trim());
                        cbd.setVehicle3(vehicle3.getText().toString().trim());
                        cbd.setVehicle4(vehicle4.getText().toString().trim());
                        cbd.setNum1(Integer.parseInt(num1.getText().toString().trim()));
                        cbd.setNum2(Integer.parseInt(num2.getText().toString().trim()));
                        cbd.setNum3(Integer.parseInt(num3.getText().toString().trim()));
                        cbd.setNum4(Integer.parseInt(num4.getText().toString().trim()));


                        dbref222.child(cbd.getKey()).setValue(cbd);
                        Toast.makeText(getApplicationContext(), "Adding Success", Toast.LENGTH_LONG).show();
                        cleanData();
                    }


                    //Intent intent = new Intent(CabOwnerEditActivity.this, show_cabownerdetails.class);
                    //startActivity(intent);
                }
            });


        }

    public void uploadbutton(View view) {
        Intent intent = new Intent(CabOwnerEditActivity.this, show_cabownerdetails.class);
        startActivity(intent);
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




}

      /* Button button = (Button)findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerEditActivity.this, show_cabownerdetails.class);
                startActivity(intent);
            }
        });


       Button button1 = (Button)findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerEditActivity.this, CabOwnerActivity.class);
                startActivity(intent);
            }
        });*/


