package com.pe.bicentenariolalibertad.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridLayout;

import com.pe.bicentenariolalibertad.Holder.HolderCategory;
import com.pe.bicentenariolalibertad.Model.CategoryActivity;
import com.pe.bicentenariolalibertad.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements HolderCategory.OnItemListener {

    private RecyclerView recyclerView;
    public static ArrayList<CategoryActivity> categoryActivities = new ArrayList<CategoryActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //recyclerView = (RecyclerView) findViewById(R.id.Rhistory);
        //initialiseList();
        //setUpRecycler();
    }

    private void initialiseList() {

        /*CategoryActivity Personajes = new CategoryActivity("0","Personajes",R.drawable.ic_caballitos);
        categoryActivities.add(Personajes);

        CategoryActivity Casonas = new CategoryActivity("1","Casonas",R.drawable.ic_caballitos);
        categoryActivities.add(Casonas);

        CategoryActivity Museos = new CategoryActivity("2","Museos",R.drawable.ic_caballitos);
        categoryActivities.add(Museos);

        CategoryActivity Lugares = new CategoryActivity("3","Lugares Turísticos",R.drawable.ic_caballitos);
        categoryActivities.add(Lugares);

        CategoryActivity Monumentos = new CategoryActivity("4","Monumentos",R.drawable.ic_caballitos);
        categoryActivities.add(Monumentos);

        CategoryActivity Reliquias = new CategoryActivity("5","Reliquias",R.drawable.ic_caballitos);
        categoryActivities.add(Reliquias);*/
    }

    private void setUpRecycler() {
        /*recyclerView = (RecyclerView)findViewById(R.id.Rhistory);
        HolderCategory holderCategory = new HolderCategory(categoryActivities, this);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(holderCategory);*/
    }

    @Override
    public void onItemClick(int position) {
        /*Intent listItemCategory = new Intent(this,HistoryListActivity.class);
        listItemCategory.putExtra("position", position);
        startActivity(listItemCategory);*/
    }
}
