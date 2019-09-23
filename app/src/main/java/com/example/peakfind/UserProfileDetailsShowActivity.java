package com.example.peakfind;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserProfileDetailsShowActivity extends AppCompatActivity {

    EditText EditTextName, EditTextNumber, EditTextAddress;
    Button btnUpdate;
    UserDetailsModel usermodel;
    ImageView imageView;
    private static final int CHOOSE_IMAGE = 101;

    FirebaseAuth mAuth;
    DatabaseReference databaseUsers;
    List<UserDetailsModel> userList;

    FirebaseUser userid;
    String uid;
    //Uri uriProfileImage;
    ProgressBar progressBar;
    //String profileImageUrl;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profiledetails_show);

        usermodel = new UserDetailsModel();

        userid = FirebaseAuth.getInstance().getCurrentUser();
        uid = userid.getUid();

        mAuth = FirebaseAuth.getInstance();

        databaseUsers = FirebaseDatabase.getInstance().getReference("UserDetails");

        EditTextName = findViewById(R.id.editTextDisplayName);
        EditTextNumber = findViewById(R.id.editTextContactNumber);
        EditTextAddress = findViewById(R.id.editTextAddress);

        btnUpdate = findViewById(R.id.btnSaveDetails);

        imageView = findViewById(R.id.imageViewProfilePic);

        userList = new ArrayList<>();

        progressBar = findViewById(R.id.progressBarUpload);

        Query query = FirebaseDatabase.getInstance().getReference("UserDetails").orderByChild("userId").equalTo(uid);
        query.addListenerForSingleValueEvent(valueEventListener);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = databaseUsers.push().getKey();

                usermodel.setUserId(uid);
                usermodel.setUserName(EditTextName.getText().toString());
                usermodel.setUserNumber(EditTextNumber.getText().toString());
                usermodel.setUserAddress(EditTextAddress.getText().toString());

                databaseUsers.child(id).setValue(usermodel);

                Toast.makeText(getApplicationContext(), "Details Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item2:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }

        return true;
    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    UserDetailsModel userDetailsModel = snapshot.getValue(UserDetailsModel.class);
                    EditTextName.setText(userDetailsModel.getUserName());
                    EditTextNumber.setText(userDetailsModel.getUserNumber());
                    EditTextAddress.setText(userDetailsModel.getUserAddress());
                }
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };



    /*
    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this,LoginActivity.class));
        }
    }*/

    /* authretrive
    private void loadUserInformation() {
        FirebaseUser user = mAuth.getCurrentUser();

        //String photoUrl = user.getPhotoUrl().toString();
        if (user != null) {
            if (user.getDisplayName()!=null) {
                EditTextName.setText(user.getDisplayName());

            }
        }


    }

    private void saveUserInformation() {
        String displayName = EditTextName.getText().toString();

        if (displayName.isEmpty()) {
            EditTextName.setError("Name required");
            EditTextName.requestFocus();
            return;
        }

        FirebaseUser user = mAuth.getCurrentUser();

        if(user != null && profileImageUrl !=null) {
            UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                    .setDisplayName(displayName)
                    .setPhotoUri(Uri.parse(profileImageUrl))
                    .build();

            user.updateProfile(profile).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(UserProfileActivity.this,"Profile Updated",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }*/
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHOOSE_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            uriProfileImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uriProfileImage);
                imageView.setImageBitmap(bitmap);

                uploadImageToFirebaseStorage();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void uploadImageToFirebaseStorage() {

        StorageReference profileImageRef =
                FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");

        if (uriProfileImage != null) {
            progressBar.setVisibility(View.VISIBLE);
            profileImageRef.putFile(uriProfileImage)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressBar.setVisibility(View.GONE);
                            profileImageUrl = taskSnapshot.getUploadSessionUri().toString();

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(UserProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }


    }

    private void showImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Profile Image"), CHOOSE_IMAGE);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        finish();
        startActivity(new Intent(this, LoginActivity.class));
    }*/






}
