package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.pe.bicentenariolalibertad.R;

/**
 * Created by Jorge Ventura on 2020-02-29.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgMenu, imgPerfil;
    private DrawerLayout drawerLayout;

    private  LinearLayout linearGame;
    private  LinearLayout linearHistory;
    private  LinearLayout linearDiary;

    private TextView textSetting;
    private TextView textUs;
    private TextView textClose;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParams();
        setParams();
    }

    private void initParams(){
        imgMenu = findViewById(R.id.imgMenu);
        imgPerfil = findViewById(R.id.imgPerfil);
        drawerLayout = findViewById(R.id.drawerLayout);

        linearGame = findViewById(R.id.linearGame);
        linearHistory = findViewById(R.id.linearHistory);
        linearDiary = findViewById(R.id.linearDiary);
        textSetting = findViewById(R.id.TextSetting);
        textUs=findViewById(R.id.TextUs);
        textClose= findViewById(R.id.TextClose);

        mAuth = FirebaseAuth.getInstance();

    }

    private void setParams(){
        imgMenu.setOnClickListener(this);
        imgPerfil.setOnClickListener(this);
        linearGame.setOnClickListener(this);
        linearDiary.setOnClickListener(this);


        textSetting.setOnClickListener(this);
        textUs.setOnClickListener(this);
        textClose.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgMenu:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;

            case R.id.linearGame:
                Intent intent = new Intent(MenuActivity.this, AmautasActivity.class);
                startActivity(intent);
                break;

            case R.id.linearDiary:
                Intent intentDiary = new Intent(MenuActivity.this, DiaryActivity.class);
                startActivity(intentDiary);
                break;

            case R.id.TextSetting:
                Intent intentSetting = new Intent(MenuActivity.this, SettingActivity.class);
                startActivity(intentSetting);
                break;


            case R.id.imgPerfil:
                Intent intentPerfil = new Intent(MenuActivity.this, GameActivity.class);
                startActivity(intentPerfil);
                break;
            case R.id.TextClose:
              textClose.setOnClickListener(new View.OnClickListener(){

                  @Override
                  public void onClick(View v) {
                     mAuth.signOut();
                     startActivity(new Intent(MenuActivity.this, LoginActivity.class));
                     finish();
                  }
              });
                break;

        }
    }

}
