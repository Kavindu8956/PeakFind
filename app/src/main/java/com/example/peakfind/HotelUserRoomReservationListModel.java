package com.example.peakfind;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HotelUserRoomReservationListModel  extends ArrayAdapter<HotelUserRoomModel> {


    private Activity contex;
    private List<HotelUserRoomModel> reservationList;

    public HotelUserRoomReservationListModel(Activity contex,List<HotelUserRoomModel> reservationList){
        super(contex,R.layout.room_reservation_list_layout,reservationList);
        this.contex=contex;
        this.reservationList=reservationList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=contex.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.room_reservation_list_layout,null,true);

        TextView textHotel=(TextView)listViewItem.findViewById(R.id.HotelName);
        TextView textDate=(TextView)listViewItem.findViewById(R.id.DateReserve);
        TextView textNights=(TextView)listViewItem.findViewById(R.id.nights);

        HotelUserRoomModel room=reservationList.get(position);

        textHotel.setText(room.getHotelName());
        textDate.setText(room.getDate());
        textNights.setText(room.getQuantityNights());

        return  listViewItem;

    }
}
