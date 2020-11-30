package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pe.bicentenariolalibertad.R;

import androidx.appcompat.app.AppCompatActivity;

public class TerminosActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminos_condiciones);



                imageView = findViewById(R.id.imgToolterminos);


        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intents = new Intent(TerminosActivity.this, MenuActivity.class);
                startActivity(intents);
            }
        });



    }
}
