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

public class HotelUserTableReservationListModel extends ArrayAdapter<HotelUserTableReservationDetailsModel> {
    private Activity contex;
    private List<HotelUserTableReservationDetailsModel> list;

    public HotelUserTableReservationListModel(Activity contex,List<HotelUserTableReservationDetailsModel> list){
        super(contex,R.layout.table_reservation_list_layout,list);
        this.contex=contex;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=contex.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.table_reservation_list_layout,null,true);

        TextView textHotel=(TextView)listViewItem.findViewById(R.id.HotelName);
        TextView textDate=(TextView)listViewItem.findViewById(R.id.DateReserve);
        TextView time=(TextView)listViewItem.findViewById(R.id.time);

        HotelUserTableReservationDetailsModel table=list.get(position);

        textHotel.setText(table.getHotelname());
        textDate.setText(table.getDate());
        time.setText(table.getTime());

        return  listViewItem;
    }
}
