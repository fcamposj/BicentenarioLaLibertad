package com.pe.bicentenariolalibertad.Activitys;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pe.bicentenariolalibertad.Holder.HolderHistoryList;
import com.pe.bicentenariolalibertad.R;

public class HistoryListActivity extends AppCompatActivity {

    RecyclerView recyclerHistory;
    String r1[], r2[];
    int images[] = {R.drawable.facebook, R.drawable.google, R.drawable.gorjeo,
            R.drawable.ic_bronce, R.drawable.ic_caballitos, R.drawable.ic_circle,
            R.drawable.ic_logo, R.drawable.ic_zegel_ipae};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_list);

        recyclerHistory = (RecyclerView) findViewById(R.id.historyList);

        r1 = getResources().getStringArray(R.array.Historia);
        r2 = getResources().getStringArray(R.array.Description);

        HolderHistoryList holderHistoryList = new HolderHistoryList(this, r1, r2, images);
        recyclerHistory.setAdapter(holderHistoryList);
        recyclerHistory.setLayoutManager(new LinearLayoutManager(this));

    }


}
