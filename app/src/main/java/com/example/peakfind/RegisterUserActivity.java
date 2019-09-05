package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterUserActivity extends AppCompatActivity {


    private Button bt1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeruser);

        bt1=(Button)findViewById(R.id.button5);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(RegisterUserActivity.this,LoginActivity.class);
                startActivity(i1);
            }
        });
    }

    public void Register2(View view) {
    }
}
