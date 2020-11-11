package com.pe.bicentenariolalibertad.Activitys;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.Holder.HolderDiary;
import com.pe.bicentenariolalibertad.R;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DiaryActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);


        recyclerView=(RecyclerView) findViewById(R.id.diaryreclycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new HolderDiary();
        recyclerView.setAdapter(mAdapter);
    }
}
