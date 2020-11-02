package com.ipae.bicentenariolalibertad.Activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ipae.bicentenariolalibertad.R;

public class GameActivity extends AppCompatActivity {
        private TextView mtxtProfileName;

        private FirebaseAuth mAuth;
        private DatabaseReference mReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        initParams();
        setParams();
    }


    private void initParams(){
        mtxtProfileName = findViewById(R.id.txtProfileName);
        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance().getReference();


    }

    private void setParams(){
     informationUser();
    }


    private void informationUser(){
        String id = mAuth.getCurrentUser().getUid();
        mReference.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String name= snapshot.child("rName").getValue().toString();
                    String Lats= snapshot.child("rLast").getValue().toString();

                    mtxtProfileName.setText(name + " " + Lats);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
