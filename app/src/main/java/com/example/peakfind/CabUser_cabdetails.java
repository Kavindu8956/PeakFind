package com.example.peakfind;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CabUser_cabdetails extends ArrayAdapter<CabDetails> {

    private Activity context;
    private List<CabDetails> cabUser_cabdetails;


    public CabUser_cabdetails(Activity context,List<CabDetails> cabUser_cabdetails) {
        super(context, R.layout.cabuser_list_layout,cabUser_cabdetails);
        this.context = context;
        this.cabUser_cabdetails = cabUser_cabdetails;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View listView =inflater.inflate(R.layout.cabuser_list_layout,null,true);


        TextView txtowner = (TextView) listView.findViewById(R.id.textView40);
        TextView txtCompany = (TextView) listView.findViewById(R.id.textView41);
        TextView txtcity = (TextView) listView.findViewById(R.id.textView42);
        TextView txtmobile = (TextView) listView.findViewById(R.id.textView43);
        TextView txtemail = (TextView) listView.findViewById(R.id.textView44);
        TextView txtvehicle1 = (TextView) listView.findViewById(R.id.textView45);
        TextView txtvehicle2 = (TextView) listView.findViewById(R.id.textView46);
        TextView txtvehicle3 = (TextView) listView.findViewById(R.id.textView47);
        TextView txtvehicle4 = (TextView) listView.findViewById(R.id.textView48);


        CabDetails cabdetails = cabUser_cabdetails.get(position);

        txtowner.setText(cabdetails.getOwnerName());
        txtCompany.setText(cabdetails.getCompanyName());
        txtcity.setText(cabdetails.getCity());
        txtmobile.setText(Integer.toString(cabdetails.getMobileNo()));
        txtemail.setText(cabdetails.getEmail());
        txtvehicle1.setText(cabdetails.getVehicle1());
        txtvehicle2.setText(cabdetails.getVehicle2());
        txtvehicle3.setText(cabdetails.getVehicle3());
        txtvehicle4.setText(cabdetails.getVehicle4());




        return listView;





    }
}
