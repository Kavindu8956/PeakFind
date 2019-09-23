package com.example.peakfind;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

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

import com.example.peakfind.ui.main.UpdateDatePicker;
import com.example.peakfind.ui.main.frag_Room_Reswervation;
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

public class HotelUserReservedRoom extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private TextView hotName;
    private TextView cusName;
    private TextView phone;
    private TextView date;
    private Spinner Nopeople;
    private Spinner roomType;
    private Spinner noRooms;
    private Spinner noNights;
    private Button update;
    private Button delete;
    private Button datePick;
    HotelUserRoomModel model;
    DatabaseReference db;
    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_user_reserved_room);
        userid= FirebaseAuth.getInstance().getCurrentUser();
        uid=userid.getUid();
        mAuth=FirebaseAuth.getInstance();
        model=new HotelUserRoomModel();

        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        hotName=(TextView)findViewById(R.id.Hname);
        cusName=(TextView)findViewById(R.id.textViewName);
        phone=(TextView)findViewById(R.id.textView22);
        date=(TextView)findViewById(R.id.textView);
        Nopeople=(Spinner) findViewById(R.id.spinner);
        roomType=(Spinner)findViewById(R.id.spinner3);
        noRooms=(Spinner)findViewById(R.id.spinner4);
        noNights=(Spinner)findViewById(R.id.spinner5);
        update=(Button)findViewById(R.id.buttonupdate);
        delete=(Button)findViewById(R.id.buttonDelete);
        datePick=(Button)findViewById(R.id.btnLogin);

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker1=new UpdateDatePicker();
                datePicker1.show(getSupportFragmentManager(),"date picker1");
            }
        });


        ArrayAdapter<String> my1=new ArrayAdapter<String>(HotelUserReservedRoom.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Adults));
        ArrayAdapter<String> my2=new ArrayAdapter<String>(HotelUserReservedRoom.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rooms));
        ArrayAdapter<String> my3=new ArrayAdapter<String>(HotelUserReservedRoom.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.roomNo));
        ArrayAdapter<String> my4=new ArrayAdapter<String>(HotelUserReservedRoom.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Nights));

        my1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Nopeople.setAdapter(my1);
        roomType.setAdapter(my2);
        noRooms.setAdapter(my3);
        noNights.setAdapter(my4);

        Intent int2=getIntent();

        final String hotNameV=int2.getStringExtra(frag_Room_Reswervation.Hotel_name);
        final String cusNameV=int2.getStringExtra(frag_Room_Reswervation.Cus_name);
        final String phoneV=int2.getStringExtra(frag_Room_Reswervation.phone);
        final String dateV=int2.getStringExtra(frag_Room_Reswervation.dateReserved);
        final String NopeopleV=int2.getStringExtra(frag_Room_Reswervation.no_of_people);
        final String roomTypeV=int2.getStringExtra(frag_Room_Reswervation.room_type);
        final String noRoomsV=int2.getStringExtra(frag_Room_Reswervation.no_of_rooms);
        final String noNightsV=int2.getStringExtra(frag_Room_Reswervation.no_of_nights);
        final String id=int2.getStringExtra(frag_Room_Reswervation.ID);

        ArrayAdapter ad1=(ArrayAdapter)Nopeople.getAdapter();
        final int spinnerPosition=ad1.getPosition(NopeopleV);
        Nopeople.setSelection(spinnerPosition);

        ArrayAdapter ad2=(ArrayAdapter)roomType.getAdapter();
        final int spinnerPosition1=ad2.getPosition(roomTypeV);
        roomType.setSelection(spinnerPosition1);

        ArrayAdapter ad3=(ArrayAdapter)noRooms.getAdapter();
        final int spinnerPosition3=ad3.getPosition(noRoomsV);
        noRooms.setSelection(spinnerPosition3);

        ArrayAdapter ad4=(ArrayAdapter)noNights.getAdapter();
        final int spinnerPosition4=ad4.getPosition(noNightsV);
        noNights.setSelection(spinnerPosition4);


        hotName.setText(hotNameV);
        cusName.setText(cusNameV);
        phone.setText(phoneV);
        date.setText(dateV);

        db= FirebaseDatabase.getInstance().getReference("RoomReservation1").child(uid);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setId(uid);
                model.setHotelName(hotName.getText().toString());
                model.setCustomerName(cusName.getText().toString());
                model.setCustomerPhone(phone.getText().toString());
                model.setDate(date.getText().toString());
                model.setQuantityPeople(Nopeople.getSelectedItem().toString());
                model.setRoomtype(roomType.getSelectedItem().toString());
                model.setQuantityRoom(noRooms.getSelectedItem().toString());
                model.setQuantityNights(noNights.getSelectedItem().toString());

                db.setValue(model);
                Toast.makeText(getApplicationContext(),"Reservation Updated",Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.removeValue();
                Toast.makeText(getApplicationContext(),"Recervation deleted.",Toast.LENGTH_LONG).show();
            }
        });
    }




    public void onDateSet(DatePicker datePicker1, int year, int month, int day) {
        Calendar c1=Calendar.getInstance();
        c1.set(Calendar.YEAR,year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH,day);

        String checkInDate= DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());
        TextView textView1=(TextView)findViewById(R.id.textView);
        textView1.setText(checkInDate);

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
}
