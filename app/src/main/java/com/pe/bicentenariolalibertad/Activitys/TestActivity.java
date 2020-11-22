package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.controller.TestControlador;

/**
 * Created by Jorge Ventura on 2020-03-01.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class TestActivity extends AppCompatActivity  {


      TextView preInicial,txttiempo, txtnum;
      Button opc1, opc2, opc3;

      int computerCount =1;

      ImageView imagenicon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        preInicial= findViewById(R.id.txtquestions);
        opc1 = findViewById(R.id.txtopcone);
        opc2 = findViewById(R.id.txtopctwo);
        opc3 = findViewById(R.id.txtopcthree);
        txttiempo = findViewById(R.id.txtTiempo);
        txtnum = findViewById(R.id.txtnum);

        updateQuestion();
    }


    private  void updateQuestion(){
        txtnum.setText(""+computerCount);
        TestControlador.nuevometodo(preInicial,opc1,opc2,opc3,txtnum,txttiempo);
    }

    public void ventana(){
        Intent intent = new Intent(TestActivity.this, MenuActivity.class);
       startActivity(intent);
    }

}
