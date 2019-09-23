package com.example.peakfind;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class HotelUserTableReservation extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;

    private Button btn1;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private Spinner sp1;
    private Spinner sp2;
    private Button reserve;
    DatabaseReference ReservationDetails1;
    HotelUserTableReservationDetailsModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteluser_tablereservation);
        userid = FirebaseAuth.getInstance().getCurrentUser();
        uid = userid.getUid();
        mAuth = FirebaseAuth.getInstance();
        model = new HotelUserTableReservationDetailsModel();

        ReservationDetails1 = FirebaseDatabase.getInstance().getReference("ReservationTable").child(uid);

        btn1 = (Button) findViewById(R.id.DatePicker);
        tv2 = (TextView) findViewById(R.id.HotelTopic);
        tv1 = (TextView) findViewById(R.id.viewDate);
        reserve = (Button) findViewById(R.id.MakeReserve);
        sp1 = (Spinner) findViewById(R.id.spinnerTime);
        sp2 = (Spinner) findViewById(R.id.spinnerPeople);
        tv3 = (TextView) findViewById(R.id.textViewName);
        tv4 = (TextView) findViewById(R.id.textView22);

        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        final Intent intent = getIntent();
        final String HotelName = intent.getStringExtra(HotelUserListView.Hotel_Name);
        tv2.setText(HotelName);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(HotelUserTableReservation.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.TableTime));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String AreaSelected1 = sp1.getSelectedItem().toString();
                int s1id = sp1.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(HotelUserTableReservation.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.People));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter1);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String AreaSelected2 = sp2.getSelectedItem().toString();
                int s2id = sp2.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dp = new DatePickFragment();
                dp.show(getSupportFragmentManager(), "Date Picker");

            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTable();
            }
        });
        onButtonClick();
    }

    public void onButtonClick() {
        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(tv1.getText())) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(HotelUserTableReservation.this);
                    builder.setMessage("You should Enter the date.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Error!!!");
                    alert.show();
                } else {
                    addTable();
                    AlertDialog.Builder builder = new AlertDialog.Builder(HotelUserTableReservation.this);
                    builder.setMessage("Table reservation created successfully.Our customer support contact you shortly to get complete details of the reservation.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(HotelUserTableReservation.this, HotelCustomerReservedList.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.setTitle("Success!!!");
                    alert.show();
                }

            }

        });

    }


    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH, i1);
        c.set(Calendar.DAY_OF_MONTH, i2);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        tv1 = (TextView) findViewById(R.id.viewDate);
        tv1.setText(currentDateString);
    }

    private void addTable() {
        String date = tv1.getText().toString().trim();
        String time = sp1.getSelectedItem().toString().trim();
        String people = sp2.getSelectedItem().toString().trim();
        String cusName = tv3.getText().toString().trim();
        String cusPhone = tv4.getText().toString().trim();
        String hotName = tv2.getText().toString().trim();

        if (!TextUtils.isEmpty(date)) {
            String id = ReservationDetails1.push().getKey();
            HotelUserTableReservationDetailsModel det = new HotelUserTableReservationDetailsModel(uid, cusName, cusPhone, date, time, people, hotName);
            ReservationDetails1.setValue(det);
            Toast.makeText(this, "Reservation Details are added...", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Reservation Details are added...", Toast.LENGTH_LONG).show();
        }
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel userDetailsModel = snapshot.getValue(UserDetailsModel.class);
                    tv3.setText(userDetailsModel.getUserName());
                    tv4.setText(userDetailsModel.getUserNumber());
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };
}
