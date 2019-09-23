package com.example.peakfind.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.peakfind.HotelUserReservedTable;
import com.example.peakfind.HotelUserRoomModel;
import com.example.peakfind.HotelUserRoomReservationListModel;
import com.example.peakfind.HotelUserTableReservationDetailsModel;
import com.example.peakfind.HotelUserTableReservationListModel;
import com.example.peakfind.R;
import com.example.peakfind.UserDetailsModel;
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

public class frag_Table_Reswervation extends Fragment {
    FirebaseAuth mAuth;
    FirebaseUser userid;
    String uid;

    public static final String Id="reservationId";
    public static final String hName="hotelname";
    public static final String cusName="cusName";
    public static final String cusPhone="cusPhone";
    public static final String dateReserved="date";
    public static final String timeReserved="time";
    public static final String noPeople="people";

    ListView tableList;
    List<HotelUserTableReservationDetailsModel> tablebooking;
    DatabaseReference db2;
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view= inflater.inflate(R.layout.hotel_user_frag_table,container,false);
            userid= FirebaseAuth.getInstance().getCurrentUser();
            uid=userid.getUid();
            mAuth=FirebaseAuth.getInstance();
            db2=FirebaseDatabase.getInstance().getReference("ReservationTable");
            tableList=view.findViewById(R.id.listView);
            tablebooking=new ArrayList<>();
        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);


            tableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    HotelUserTableReservationDetailsModel model=tablebooking.get(i);
                    Intent intent1=new Intent(getContext(), HotelUserReservedTable.class);

                    intent1.putExtra(Id,model.getReservationId());
                    intent1.putExtra(hName,model.getHotelname());
                    intent1.putExtra(cusName,model.getCusName());
                    intent1.putExtra(cusPhone,model.getCusPhone());
                    intent1.putExtra(dateReserved,model.getDate());
                    intent1.putExtra(timeReserved,model.getTime());
                    intent1.putExtra(noPeople,model.getPeople());

                    startActivity(intent1);
                }
            });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tablebooking.clear();
                for(DataSnapshot hotelSnapshot:dataSnapshot.getChildren()){
                    HotelUserTableReservationDetailsModel table=hotelSnapshot.getValue(HotelUserTableReservationDetailsModel.class);
                    tablebooking.add(table);
                }
                HotelUserTableReservationListModel adapter=new HotelUserTableReservationListModel(getActivity(),tablebooking);
                tableList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel userDetailsModel = snapshot.getValue(UserDetailsModel.class);
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    };
}
