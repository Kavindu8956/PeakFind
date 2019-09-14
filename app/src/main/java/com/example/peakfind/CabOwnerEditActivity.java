package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
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


    EditText OwnerName,CompanyName,City,MobileNo,Email,vehicle1,vehicle2,vehicle3,vehicle4;
    Button BtnSave;
    DatabaseReference dbref;
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
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabowneredit);



            dbref = FirebaseDatabase.getInstance().getReference("CabDetails");

            OwnerName = (EditText)findViewById(R.id.txtowner);
            CompanyName = (EditText)findViewById(R.id.txtcompany);
            City = (EditText)findViewById(R.id.txtcity);
            MobileNo = (EditText)findViewById(R.id.txtmobile);
            Email = (EditText)findViewById(R.id.txtemail);
            vehicle1 = (EditText)findViewById(R.id.editText6);
            vehicle2 = (EditText)findViewById(R.id.editText7);
            vehicle3 = (EditText)findViewById(R.id.editText8);
            vehicle4 = (EditText)findViewById(R.id.editText9);

            BtnSave = (Button)findViewById(R.id.button);

            cbd = new CabDetails();




            BtnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //cbd.setKey(dbref.push().getKey());
                    cbd.setOwnerName(OwnerName.getText().toString().trim());
                    cbd.setCompanyName(CompanyName.getText().toString().trim());
                    cbd.setCity(City.getText().toString().trim());
                    cbd.setMobileNo(Integer.parseInt(MobileNo.getText().toString().trim()));
                    cbd.setEmail(Email.getText().toString().trim());
                    cbd.setVehicle1(vehicle1.getText().toString().trim());
                    cbd.setVehicle2(vehicle2.getText().toString().trim());
                    cbd.setVehicle3(vehicle3.getText().toString().trim());
                    cbd.setVehicle4(vehicle4.getText().toString().trim());


                    dbref.push().setValue(cbd);
                    Toast.makeText(getApplicationContext(),"Adding Success",Toast.LENGTH_LONG).show();

                    cleanData();

                    Intent intent = new Intent(CabOwnerEditActivity.this, show_cabownerdetails.class);
                    startActivity(intent);
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
        }

      /*  Button button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(CabOwnerEditActivity.this, CabOwnerUpload.class);
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
    }

