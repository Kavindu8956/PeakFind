package com.example.peakfind.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.peakfind.HotelCustomerReservedList;
import com.example.peakfind.HotelUserReservedRoom;
import com.example.peakfind.HotelUserRoomModel;
import com.example.peakfind.HotelUserRoomReservationListModel;
import com.example.peakfind.HotelUserTableReservationListModel;
import com.example.peakfind.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class frag_Room_Reswervation extends Fragment {

    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;
    public static final String ID="id";
    public static final String Hotel_name="HotelName";
    public static final String Cus_name="customerName";
    public static final String phone="customerPhone";
    public static final String dateReserved="date";
    public static final String no_of_people="quantityPeople";
    public static final String room_type="roomtype";
    public static final String no_of_rooms="quantityRoom";
    public static final String no_of_nights="quantityNights";


    ListView tableList;
    List<HotelUserRoomModel> roomBookingList;
    DatabaseReference db1;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.hotel_user_frag_room,container,false);
        db1= FirebaseDatabase.getInstance().getReference("RoomReservation1");
        userid= FirebaseAuth.getInstance().getCurrentUser();
        uid=userid.getUid();
        mAuth=FirebaseAuth.getInstance();
        tableList=view.findViewById(R.id.tableList);
        roomBookingList=new ArrayList<>();

       //Query query=FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
       //query.addListenerForSingleValueEvent();

        tableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HotelUserRoomModel model1=roomBookingList.get(i);
                Intent int1=new Intent(getContext(), HotelUserReservedRoom.class);

                int1.putExtra(ID,model1.getId());
                int1.putExtra(Hotel_name,model1.getHotelName());
                int1.putExtra(Cus_name,model1.getCustomerName());
                int1.putExtra(phone,model1.getCustomerPhone());
                int1.putExtra(dateReserved,model1.getDate());
                int1.putExtra(no_of_people,model1.getQuantityPeople());
                int1.putExtra(room_type,model1.getRoomtype());
                int1.putExtra(no_of_rooms,model1.getQuantityRoom());
                int1.putExtra(no_of_nights,model1.getQuantityNights());

                startActivity(int1);

            }
        });

    return view;
    }



    @Override
    public void onStart() {
        super.onStart();

        db1.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                roomBookingList.clear();
                for(DataSnapshot hotelSnapshot:dataSnapshot.getChildren()){
                    HotelUserRoomModel room=hotelSnapshot.getValue(HotelUserRoomModel.class);
                    roomBookingList.add(room);
                }
                HotelUserRoomReservationListModel adapter=new HotelUserRoomReservationListModel(getActivity(),roomBookingList);
                tableList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
