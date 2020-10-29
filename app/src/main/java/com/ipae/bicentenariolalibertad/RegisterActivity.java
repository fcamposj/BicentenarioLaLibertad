package com.ipae.bicentenariolalibertad;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Jorge Ventura on 2020-02-29.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgToolbarBack;
    private Spinner spinnerSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        initParams();
        setParams();

    }

    private void initParams(){
        spinnerSchool = findViewById(R.id.spinnerSchool);
        imgToolbarBack = findViewById(R.id.imgToolbarBack);

    }

    private void setParams(){
        String[] arraySpinner = new String[] {
                "Hermanos Blancos", "San Juan", "GUE", "Marcial Acharan", "Victor A. Belaunde", "Cesar Vallejo", "Raimondi"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchool.setAdapter(adapter);

        imgToolbarBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgToolbarBack:
                finish();
                break;
        }

    }
}
