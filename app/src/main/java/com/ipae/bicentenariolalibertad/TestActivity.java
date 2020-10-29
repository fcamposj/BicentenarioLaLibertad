package com.ipae.bicentenariolalibertad;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Jorge Ventura on 2020-03-01.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout linearComodin;
    private ImageView imgToolbarBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        linearComodin = findViewById(R.id.linearComodin);
        imgToolbarBack = findViewById(R.id.imgToolbarBack);
        linearComodin.setOnClickListener(this);
        imgToolbarBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linearComodin:
                Intent intent = new Intent(TestActivity.this, ComodinActivity.class);
                startActivity(intent);
                break;
            case R.id.imgToolbarBack:
                finish();
                break;
        }
    }
}
