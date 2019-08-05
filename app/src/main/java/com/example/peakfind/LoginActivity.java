package com.example.peakfind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText tv1;
    String str1;
    int num1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void onLogin(View view) {
        tv1 = findViewById(R.id.mnum);

        str1 = tv1.getText().toString();

        //num1 = Integer.parseInt(str1);

        if (str1.equals("customer") ) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (str1.equals("hotel")) {
            Intent intent2 = new Intent(LoginActivity.this, HotelOwnerActivity.class);
            startActivity(intent2);
        } else if (str1.equals("cab")) {
            Intent intent3 = new Intent(LoginActivity.this, CabOwnerActivity.class);
            startActivity(intent3);
        }
    }
}
