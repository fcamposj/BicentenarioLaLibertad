package com.ipae.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ipae.bicentenariolalibertad.R;

/**
 * Created by Jorge Ventura on 2020-03-01.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class ComodinActivity extends AppCompatActivity  {

    private ImageView imgClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        imgClose = findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}

