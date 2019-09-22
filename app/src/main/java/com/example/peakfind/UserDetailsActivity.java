package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {

    private Button button;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);
        button=(Button)findViewById(R.id.detailbutton) ;

        button1=(Button)findViewById(R.id.editButton) ;
        button1.setOnClickListener(new View.OnClickListener() {
            //   @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDetailsActivity.this,UserProfileActivity.class);
                startActivity(intent);
            }
        });
        button2=(Button)findViewById(R.id.editButton9) ;
        button2.setOnClickListener(new View.OnClickListener() {
            //   @Override
            public void onClick(View view) {
                Intent intent=new Intent(UserDetailsActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}
