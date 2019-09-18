package com.example.peakfind;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInsertActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonAdd;

    DatabaseReference databaseUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_insert);

        databaseUsers = FirebaseDatabase.getInstance().getReference("UserDetails");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetails();
            }
        });
    }

    private void addDetails() {
        String name = editTextName.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {
            String id = databaseUsers.push().getKey();

            UserDetailsModel user = new UserDetailsModel(id,name);

            databaseUsers.child(id).setValue(user);

            Toast.makeText(this, "Details added", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this,"You should enter name", Toast.LENGTH_SHORT).show();
        }
    }
}
