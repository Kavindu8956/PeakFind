package com.example.peakfind;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity implements ImageAdapter.OnItemClickListener {
    private RecyclerView mRecycleView;
    private ImageAdapter mAdapter;

     private ProgressBar mProgressCircle;

     private FirebaseStorage mStorage;

    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<Upload>mUploads;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);



        mRecycleView = findViewById(R.id.recycler_view);
        mRecycleView.setHasFixedSize(true);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));

         mProgressCircle = findViewById(R.id.progress_circle);

        mUploads = new ArrayList<>();

        mAdapter = new ImageAdapter(ImagesActivity.this,mUploads);

        mRecycleView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(ImagesActivity.this);

        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Menus");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                mUploads.clear();


                 for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                     Upload upload = postSnapshot.getValue(Upload.class);
                     upload.setmKey(postSnapshot.getKey());
                     mUploads.add(upload);
                 }

                 mAdapter.notifyDataSetChanged();
                 mProgressCircle.setVisibility(View.INVISIBLE);


            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                Toast.makeText(ImagesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                mProgressCircle.setVisibility(View.INVISIBLE);


            }
        });

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this,"Normal Click at Position: "+ position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onWhatEverClick(int position) {
        Toast.makeText(this,"Whatever Click at Position: "+ position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDeleteClick(int position) {
       Upload selectedItem = mUploads.get(position);
       final String SelectedKey = selectedItem.getKey();

        StorageReference imageRef = mStorage.getReferenceFromUrl(selectedItem.getmImageUrl());
        imageRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                 mDatabaseRef.child(SelectedKey).removeValue();
                 Toast.makeText(ImagesActivity.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }




}
