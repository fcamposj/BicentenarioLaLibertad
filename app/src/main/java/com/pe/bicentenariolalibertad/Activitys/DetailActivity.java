package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.pe.bicentenariolalibertad.Entidades.CategoryActivity;
import com.pe.bicentenariolalibertad.R;


public class DetailActivity extends AppCompatActivity {

    private ImageView recyclerImageHistoria;
    private TextView recyclerTitle;

    CategoryActivity selectCategoryActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        setUpViews();
        getItemDetailCategory();

    }

    public void setUpViews() {
        recyclerImageHistoria = (ImageView) findViewById(R.id.imageDetailCell);
        recyclerTitle = (TextView) findViewById(R.id.textDetailCell);
    }

    private void getItemDetailCategory() {
        Intent prevIntent = getIntent();
        int position = prevIntent.getIntExtra("position",0);
        //selectCategoryActivity = HistoryListActivity.recycleCat.get(position);
        recyclerImageHistoria.setImageResource(selectCategoryActivity.getImage());
        recyclerTitle.setText(selectCategoryActivity.getName());

    }
}
