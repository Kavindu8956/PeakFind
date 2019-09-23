package com.example.peakfind;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.peakfind.ui.main.UpdateDatePicker;
import com.example.peakfind.ui.main.frag_Table_Reswervation;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.util.Calendar;

public class HotelUserReservedTable extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private TextView hotName;
    private TextView cusName;
    private TextView cusPhone;
    private TextView dateReserved;
    private Spinner timeReserved;
    private Spinner people;
    private Button update;
    private Button delete;
    private Button dtePick;
    HotelUserTableReservationDetailsModel model;
    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;

    DatabaseReference db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteluser_reservedtable);
        userid= FirebaseAuth.getInstance().getCurrentUser();
        uid=userid.getUid();
        mAuth=FirebaseAuth.getInstance();
        model=new HotelUserTableReservationDetailsModel();

        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        hotName=(TextView)findViewById(R.id.HotelTopic);
        cusName=(TextView)findViewById(R.id.textViewName);
        cusPhone=(TextView)findViewById(R.id.textView22);
        dateReserved=(TextView)findViewById(R.id.viewDate);
        timeReserved=(Spinner) findViewById(R.id.spinnerTime);
        people=(Spinner)findViewById(R.id.spinnerPeople);
        dtePick=(Button)findViewById(R.id.DatePicker);
        update=(Button)findViewById(R.id.UpdateBtn);
        delete=(Button) findViewById(R.id.Deletebtn);

        dtePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker2=new UpdateDatePicker();
                datePicker2.show(getSupportFragmentManager(),"date picker1");
            }
        });

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(HotelUserReservedTable.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.TableTime));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeReserved.setAdapter(adapter);

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(HotelUserReservedTable.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.People));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        people.setAdapter(adapter1);

        Intent intent=getIntent();

        final String hotNameV=intent.getStringExtra(frag_Table_Reswervation.hName);
        final String cusNameV=intent.getStringExtra(frag_Table_Reswervation.cusName);
        final String cusPhoneV=intent.getStringExtra(frag_Table_Reswervation.cusPhone);
        final String dateV=intent.getStringExtra(frag_Table_Reswervation.dateReserved);
        final String timeReservedV=intent.getStringExtra(frag_Table_Reswervation.timeReserved);
        final String peopleV=intent.getStringExtra(frag_Table_Reswervation.noPeople);
        final String id=intent.getStringExtra(frag_Table_Reswervation.Id);

        ArrayAdapter ad1=(ArrayAdapter)timeReserved.getAdapter();
        final int spinnerPosition=ad1.getPosition(timeReservedV);
        timeReserved.setSelection(spinnerPosition);

        ArrayAdapter ad2=(ArrayAdapter)people.getAdapter();
        final int spinnerPosition1=ad2.getPosition(peopleV);
        people.setSelection(spinnerPosition1);

        hotName.setText(hotNameV);
        cusName.setText(cusNameV);
        cusPhone.setText(cusPhoneV);
        dateReserved.setText(dateV);

        db= FirebaseDatabase.getInstance().getReference("ReservationTable").child(uid);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setReservationId(uid);
                model.setHotelname(hotName.getText().toString());
                model.setCusName(cusName.getText().toString());
                model.setCusPhone(cusPhone.getText().toString());
                model.setDate(dateReserved.getText().toString());
                model.setTime(timeReserved.getSelectedItem().toString());
                model.setPeople(people.getSelectedItem().toString());

                db.setValue(model);
                Toast.makeText(getApplicationContext(),"Resevation Updated.",Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.removeValue();
                Toast.makeText(getApplicationContext(),"Reservation Deleted.",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void onDateSet(DatePicker datePicker2, int year, int month, int day) {
        Calendar c1=Calendar.getInstance();
        c1.set(Calendar.YEAR,year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH,day);

        String checkInDate= DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());
        TextView textView1=(TextView)findViewById(R.id.viewDate);
        textView1.setText(checkInDate);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel userDetailsModel = snapshot.getValue(UserDetailsModel.class);
                    cusName.setText(userDetailsModel.getUserName());
                    cusPhone.setText(userDetailsModel.getUserNumber());
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };
}
