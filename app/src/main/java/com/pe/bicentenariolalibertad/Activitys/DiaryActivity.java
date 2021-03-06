package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pe.bicentenariolalibertad.Holder.HolderDiary;
import com.pe.bicentenariolalibertad.Entidades.ModelDiary;
import com.pe.bicentenariolalibertad.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DiaryActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private DatabaseReference reference;
    private ArrayList<ModelDiary> mdiary ;
    private HolderDiary mholder;

    ImageView imageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        imageViews = findViewById(R.id.txtatrasdiary);


        imageViews.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intents = new Intent(DiaryActivity.this, MenuActivity.class);
                startActivity(intents);
            }
        });

        recyclerView= findViewById(R.id.diaryreclycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);



        reference = FirebaseDatabase.getInstance().getReference().child("Agenda");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mdiary = new ArrayList<ModelDiary>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    ModelDiary diary = dataSnapshot.getValue(ModelDiary.class);
                    mdiary.add(diary);
                }
                mholder = new HolderDiary(mdiary, DiaryActivity.this);
                recyclerView.setAdapter(mholder);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
