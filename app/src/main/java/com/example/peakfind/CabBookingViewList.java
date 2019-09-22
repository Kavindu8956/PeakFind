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

public class CabBookingViewList extends ArrayAdapter<CabBookDetails> {

    private Activity context;
    private List<CabBookDetails> cabBookDetailsList;

    public CabBookingViewList(Activity context,List<CabBookDetails> cabBookDetailsList){
        super(context, R.layout.cab_customer_booking_layout,cabBookDetailsList);
        this.context = context;
        this.cabBookDetailsList = cabBookDetailsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View listView1 =inflater.inflate(R.layout.cab_customer_booking_layout,null,true);


        TextView txtcustomername = (TextView) listView1.findViewById(R.id.textcustomername);
        TextView txtpickuplocation = (TextView) listView1.findViewById(R.id.textpickuplocation);
        TextView txtdestination = (TextView) listView1.findViewById(R.id.textdestination);
        TextView txtpickupdate = (TextView) listView1.findViewById(R.id.textpickupdate);
        TextView txtpicktime = (TextView) listView1.findViewById(R.id.textpickuptime);
        TextView txtmobileno = (TextView) listView1.findViewById(R.id.textmobileno);
        TextView txtvehicletype = (TextView) listView1.findViewById(R.id.textvehicletype);


        CabBookDetails cabBookDetails = cabBookDetailsList.get(position);



        txtcustomername.setText(cabBookDetails.getCustomerName());
        txtpickuplocation.setText(cabBookDetails.getPickupLocation());
        txtdestination.setText(cabBookDetails.getDestination());
        txtmobileno.setText(Integer.toString(cabBookDetails.getMobileNo()));
        txtpicktime.setText(cabBookDetails.getPickupTime());
        txtpickupdate.setText(cabBookDetails.getPickupDate());
        txtvehicletype.setText(cabBookDetails.getVehicleType());

        return listView1;


    }
}
