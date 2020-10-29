package com.ipae.bicentenariolalibertad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Jorge Ventura on 2020-02-15.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textRegister;
    private Button btnLogin;
    private Button btnLoginGmail;
    private Button btnLoginFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initParams();
        setParams();
    }

    private void initParams(){
        textRegister = findViewById(R.id.textRegister);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginGmail = findViewById(R.id.btnLoginGmail);
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
    }

    private void setParams(){
        textRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnLoginGmail.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textRegister:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            case R.id.btnLoginGmail:
            case R.id.btnLoginFacebook:
            case R.id.btnLogin:
                Intent intentMenu = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intentMenu);
                finish();
                break;
        }
    }
}
