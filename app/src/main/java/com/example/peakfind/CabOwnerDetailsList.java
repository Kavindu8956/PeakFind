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

public class CabOwnerDetailsList extends ArrayAdapter<CabDetails> {
    private Activity context;
    private List<CabDetails> cabOwnerDetailsList;


    public CabOwnerDetailsList(Activity context,List<CabDetails> cabOwnerDetailsList){
        super(context, R.layout.list_layout,cabOwnerDetailsList);
        this.context = context;
        this.cabOwnerDetailsList = cabOwnerDetailsList;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater =context.getLayoutInflater();
        View listView =inflater.inflate(R.layout.list_layout,null,true);

        TextView txtowner = (TextView) listView.findViewById(R.id.textView40);
        TextView txtCompany = (TextView) listView.findViewById(R.id.textView41);
        TextView txtcity = (TextView) listView.findViewById(R.id.textView42);
        TextView txtmobile = (TextView) listView.findViewById(R.id.textView43);
        TextView txtemail = (TextView) listView.findViewById(R.id.textView44);
        TextView txtvehicle1 = (TextView) listView.findViewById(R.id.textView45);
        TextView txtvehicle2 = (TextView) listView.findViewById(R.id.textView46);
        TextView txtvehicle3 = (TextView) listView.findViewById(R.id.textView47);
        TextView txtvehicle4 = (TextView) listView.findViewById(R.id.textView48);
        TextView txtnum1 = (TextView) listView.findViewById(R.id.textView49);
        TextView txtnum2 = (TextView) listView.findViewById(R.id.textView50);
        TextView txtnum3 = (TextView) listView.findViewById(R.id.textView51);
        TextView txtnum4 = (TextView) listView.findViewById(R.id.textView52);


        CabDetails cabdetails = cabOwnerDetailsList.get(position);


        //Toast.makeText(getContext(),""+cabdetails.getOwnerName()+"",Toast.LENGTH_LONG).show();



    txtowner.setText(cabdetails.getOwnerName());
    txtCompany.setText(cabdetails.getCompanyName());
    txtcity.setText(cabdetails.getCity());
    txtmobile.setText(Integer.toString(cabdetails.getMobileNo()));
    txtemail.setText(cabdetails.getEmail());
    txtvehicle1.setText(cabdetails.getVehicle1());
    txtvehicle2.setText(cabdetails.getVehicle2());
    txtvehicle3.setText(cabdetails.getVehicle3());
    txtvehicle4.setText(cabdetails.getVehicle4());
    txtnum1.setText(Integer.toString(cabdetails.getNum1()));
    txtnum2.setText(Integer.toString(cabdetails.getNum2()));
    txtnum3.setText(Integer.toString(cabdetails.getNum3()));
    txtnum4.setText(Integer.toString(cabdetails.getNum4()));




        return listView;


    }
}