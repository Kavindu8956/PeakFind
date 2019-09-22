package com.example.peakfind;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HotelUserListModel extends ArrayAdapter<Resturent_Owner_Form2> {
    private Activity context;
    private List<Resturent_Owner_Form2> hotelList;

    public HotelUserListModel(Activity context, List<Resturent_Owner_Form2> hotelList){
        super(context,R.layout.hoteluser_listdetails,hotelList);
        this.context=context;
        this.hotelList=hotelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View ListViewItem=inflater.inflate(R.layout.hoteluser_listdetails,null,true);

        TextView TextHotelName=(TextView) ListViewItem.findViewById(R.id.NameOfHotel);
        TextView TextHotelLocation=(TextView) ListViewItem.findViewById(R.id.NameOfLoaction);
        TextView TextHotelEmail=(TextView) ListViewItem.findViewById(R.id.emailView);

        Resturent_Owner_Form2 hotel=hotelList.get(position);

        TextHotelName.setText(hotel.getHotelName());
        TextHotelLocation.setText(hotel.getLocation());
        TextHotelEmail.setText(hotel.getMail());

        return ListViewItem;
    }
}
