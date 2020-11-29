package com.ipae.bicentenariolalibertad;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.pe.bicentenariolalibertad.R;

/**
 * Created by Jorge Ventura on 2020-02-29.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgToolbarBack;


    private EditText registerName, registerLast, registerEmail, registerPassword, registerPasswordRepid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        initParams();


    }

    private void initParams(){

        imgToolbarBack = findViewById(R.id.imgToolbarBack);
        registerName= findViewById(R.id.txtRegisterName);
        registerLast= findViewById(R.id.txtRegisterLast);
        registerEmail= findViewById(R.id.txtRegisterEmail);
        registerPassword= findViewById(R.id.txtRegisterPassword);
        registerPasswordRepid= findViewById(R.id.txtRegisterPasswordReped);

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
