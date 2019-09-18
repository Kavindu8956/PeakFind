package com.example.peakfind;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class ReservationFormActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {


    private Button button1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationform);
        Button button=(Button)findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker1");
            }
        });
        Spinner spinner1=(Spinner)findViewById(R.id.spinner);
        Spinner spinner2=(Spinner)findViewById(R.id.spinner2);
        Spinner spinner3=(Spinner)findViewById(R.id.spinner3);
        Spinner spinner4=(Spinner)findViewById(R.id.spinner4);

        ArrayAdapter<String> my1=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Adults));
        ArrayAdapter<String> my3=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Rooms));
        ArrayAdapter<String> my2=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Children));
        ArrayAdapter<String> my4=new ArrayAdapter<String>(ReservationFormActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.roomNo));
        my1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        my4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(my1);
        spinner2.setAdapter(my2);
        spinner3.setAdapter(my3);
        spinner4.setAdapter(my4);

        button1=(Button)findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent3=new Intent(ReservationFormActivity.this, UserDetailsActivity.class);
                startActivity(intent3);
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar c1=Calendar.getInstance();
        c1.set(Calendar.YEAR,year);
        c1.set(Calendar.MONTH,month);
        c1.set(Calendar.DAY_OF_MONTH,day);

        String checkInDate= DateFormat.getDateInstance(DateFormat.FULL).format(c1.getTime());
        TextView textView1=(TextView)findViewById(R.id.textView);
        textView1.setText(checkInDate);

    }


}
