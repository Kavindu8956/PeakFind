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

public class HotelUserListModel extends ArrayAdapter<HotelUserDetailsModel> {
    private Activity context;
    private List<HotelUserDetailsModel> hotelList;

    public HotelUserListModel(Activity context, List<HotelUserDetailsModel> hotelList){
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

        HotelUserDetailsModel hotel=hotelList.get(position);

        TextHotelName.setText(hotel.getHotelName());
        TextHotelLocation.setText(hotel.getHotelLocation());

        return ListViewItem;
    }
}
