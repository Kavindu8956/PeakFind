package com.example.peakfind;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserInsertActivity extends AppCompatActivity {

    EditText editTextName;
    Button buttonAdd;

    DatabaseReference databaseUsers;

    ListView listViewUserDetails; //retriev
    List<UserDetailsModel> userList;

    FirebaseUser userid;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_insert);

        userid = FirebaseAuth.getInstance().getCurrentUser();
        uid = userid.getUid();

        databaseUsers = FirebaseDatabase.getInstance().getReference("UserDetails");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        listViewUserDetails = (ListView) findViewById(R.id.listViewUserDetails);  //retriev

        userList = new ArrayList<>();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDetails();
            }
        });
    }

    //retriev
    @Override
    protected void onStart() {
        super.onStart();

        databaseUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel user = userSnapshot.getValue(UserDetailsModel.class);

                    userList.add(user);
                }

                ArrayAdapter adapter = new UserDetailsListModel(UserInsertActivity.this, userList);
                listViewUserDetails.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void addDetails() {
        String name = editTextName.getText().toString().trim();

        if(!TextUtils.isEmpty(name)) {
            String id = databaseUsers.push().getKey();

            UserDetailsModel userd = new UserDetailsModel(id,uid,name,name,name);

            databaseUsers.child(id).setValue(userd);

            Toast.makeText(this, "Details Added Successfully", Toast.LENGTH_SHORT).show();

        } else{
            Toast.makeText(this,"You should enter name", Toast.LENGTH_SHORT).show();
        }
    }
}
