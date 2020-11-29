package com.pe.bicentenariolalibertad.Usuario.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.Activitys.MenuActivity;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.Usuario.Presentador.PresentadorRegistro;
import com.pe.bicentenariolalibertad.Videos.activity.VideoActivity;

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
    private EditText registerName, registerLast, registerEmail, registerPassword, registerPasswordRepid;
    CheckBox checkTerminos;
    private  Button nbtnRegister;
    private String rName = "", rLast="", rEmail="", rPaswword="", repetirpaswword="";
    private boolean term= false;
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;
    PresentadorRegistro presentadorRegistro;

            ImageView imagenicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initParams();
        setParams();




                imagenicon = findViewById(R.id.imgToolbarBackregister);


        imagenicon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intents = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intents);
            }
        });

    }

    private void initParams(){
        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();
        presentadorRegistro = new PresentadorRegistro(this,mAuth,mDatabase);

        imgToolbarBack = findViewById(R.id.imgToolbarBack);
        registerName= findViewById(R.id.txtRegisterName);
        registerLast= findViewById(R.id.txtRegisterLast);
        registerEmail= findViewById(R.id.txtRegisterEmail);
        registerPassword= findViewById(R.id.txtRegisterPassword);
        registerPasswordRepid= findViewById(R.id.txtRegisterPasswordReped);
        checkTerminos = findViewById(R.id.checkRegister);


        nbtnRegister =  findViewById(R.id.btnRegister);


    }

    private  void  setParams(){
    nbtnRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegister:
                rName =  registerName.getText().toString();
                rLast= registerLast.getText().toString();
                rEmail=registerEmail.getText().toString();
                rPaswword = registerPassword.getText().toString();
                repetirpaswword = registerPasswordRepid.getText().toString();
                 term =checkTerminos.isChecked();
                presentadorRegistro.signupuservalidation(rName,rLast,rEmail,rPaswword,repetirpaswword,term);

                break;
            case R.id.imgToolbarBack:
                finish();
                break;
        }

    }
}
