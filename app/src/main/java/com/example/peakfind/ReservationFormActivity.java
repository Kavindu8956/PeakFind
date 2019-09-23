package com.example.peakfind;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Queue;

public class ReservationFormActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;

    private Button button1;
    TextView hotelName;
    TextView cusName;
    TextView phone;
    TextView date;
    Spinner noPeople;
    Spinner room;
    Spinner noRoom;
    Spinner spinner5;

    DatabaseReference dbRoomReserve1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationform);
        userid= FirebaseAuth.getInstance().getCurrentUser();
        uid=userid.getUid();
        mAuth=FirebaseAuth.getInstance();
        dbRoomReserve1= FirebaseDatabase.getInstance().getReference("RoomReservation1").child(uid);

        hotelName=(TextView)findViewById(R.id.Hname) ;
        cusName=(TextView)findViewById(R.id.textViewName);
        phone=(TextView)findViewById(R.id.textView22) ;
        date=(TextView)findViewById(R.id.textView);
        noPeople=(Spinner)findViewById(R.id.spinner);
        room=(Spinner)findViewById(R.id.spinner3);
        noRoom=(Spinner)findViewById(R.id.spinner4) ;


        final Intent intent=getIntent();
        final String HotelName=intent.getStringExtra(HotelUserListView.Hotel_Name);
        hotelName.setText(HotelName);

        Button button=(Button)findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker1");
            }
        });

        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        Spinner spinner1=(Spinner)findViewById(R.id.spinner);
        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        Spinner spinner4=(Spinner)findViewById(R.id.spinner4);
        spinner5=(Spinner)findViewById(R.id.spinner5);

        ArrayAdapter<String> my1=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Adults));
        ArrayAdapter<String> my3=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rooms));
        ArrayAdapter<String> my4=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.roomNo));
        ArrayAdapter<String> my5=new ArrayAdapter<>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Nights));
        my1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(my1);
        spinner3.setAdapter(my3);
        spinner4.setAdapter(my4);
        spinner5.setAdapter(my5);

        button1=(Button)findViewById(R.id.buttonDelete);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(TextUtils.isEmpty(date.getText())){
                    final AlertDialog.Builder builder=new AlertDialog.Builder(ReservationFormActivity.this);
                    builder.setMessage("You should Enter the date.").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    AlertDialog alert=builder.create();
                    alert.setTitle("Error!!!");
                    alert.show();
                }else{
                    addRoom();
                    Intent intent2=new Intent(ReservationFormActivity.this, HotelCustomerReservedList.class);
                    startActivity(intent2);
                }
            }
        });
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel userDetailsModel = snapshot.getValue(UserDetailsModel.class);
                    cusName.setText(userDetailsModel.getUserName());
                    phone.setText(userDetailsModel.getUserNumber());
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c1=Calendar.getInstance();
        c1.set(Calendar.YEAR,year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH,day);

        String checkInDate= DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());
        TextView textView1=(TextView)findViewById(R.id.textView);
        textView1.setText(checkInDate);

    }
    public void addRoom(){
        String hotName=hotelName.getText().toString().trim();
        String customerName=cusName.getText().toString().trim();
        String CusPhone=phone.getText().toString().trim();
        String dateReserve=date.getText().toString().trim();
        String numberPeople=noPeople.getSelectedItem().toString().trim();
        String roomType=room.getSelectedItem().toString().trim();
        String numberRoom=noRoom.getSelectedItem().toString().trim();
        String numberNights=spinner5.getSelectedItem().toString().trim();

        if((!TextUtils.isEmpty(dateReserve))){
                String id=dbRoomReserve1.push().getKey();
                HotelUserRoomModel room1=new HotelUserRoomModel(hotName,customerName,CusPhone,dateReserve,numberPeople,roomType,numberRoom,uid,numberNights);
                dbRoomReserve1.setValue(room1);

            Toast.makeText(this,"Reserved",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"You should fill fields",Toast.LENGTH_LONG).show();
        }
    }

}
