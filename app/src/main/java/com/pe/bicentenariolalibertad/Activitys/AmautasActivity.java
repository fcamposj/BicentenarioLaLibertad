package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pe.bicentenariolalibertad.R;

/**
 * Created by Jorge Ventura on 2020-03-01.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class AmautasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(android.R.attr.windowFullscreen, android.R.attr.windowFullscreen);
        setContentView(R.layout.activity_option_slide);

       //Animation
        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView gameTextView = findViewById(R.id.gameTextView);
        TextView cargandoTextView = findViewById(R.id.cargandoTextView);
        ImageView logoImageView = findViewById(R.id.logoImageView);

        gameTextView.setAnimation(animacion2);
        cargandoTextView.setAnimation(animacion2);
        logoImageView.setAnimation(animacion1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(AmautasActivity.this, TestActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);




    }
}
