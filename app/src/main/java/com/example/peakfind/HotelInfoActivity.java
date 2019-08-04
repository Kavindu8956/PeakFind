package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class HotelInfoActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView myImageview;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelinfo);

        int images[]={R.drawable.amari,R.drawable.amari2,R.drawable.amari3};

        v_flipper=findViewById(R.id.v_flipper);

        for(int i=0;i<images.length;i++){
            flipperImages(images[i]);
        }
        

    }
    public void openActivity2(){
        Intent intent= new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void flipperImages(int image){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);
    }

}
