package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.R;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
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
    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initParams();
    }

    private void initParams(){
        mAuth = FirebaseAuth.getInstance();
        mDatabase= FirebaseDatabase.getInstance().getReference();

        imgToolbarBack = findViewById(R.id.imgToolbarBack);
        registerName= findViewById(R.id.txtRegisterName);
        registerLast= findViewById(R.id.txtRegisterLast);
        registerEmail= findViewById(R.id.txtRegisterEmail);
        registerPassword= findViewById(R.id.txtRegisterPassword);
        registerPasswordRepid= findViewById(R.id.txtRegisterPasswordReped);
        checkTerminos = findViewById(R.id.checkRegister);


        nbtnRegister =  findViewById(R.id.btnRegister);

            nbtnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rName =  registerName.getText().toString();
                    rLast= registerLast.getText().toString();
                    rEmail=registerEmail.getText().toString();
                    rPaswword = registerPassword.getText().toString();
                    repetirpaswword = registerPasswordRepid.getText().toString();

                    if(!rName.isEmpty() && !rLast.isEmpty() && !rEmail.isEmpty() && !rPaswword.isEmpty() ){

                        if (rPaswword.length() >=6) {
                            if (rPaswword.equals(repetirpaswword) ){
                                if(checkTerminos.isChecked()) {
                                    registerUser();
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this, "Acepte los terminos y condiciones" ,Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(RegisterActivity.this, "La contraseña es diferente e repetir la contraseña" ,Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "La contraseña debe ser mayor a 6 caracteres" ,Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "Debe Completar lo campos" ,Toast.LENGTH_SHORT).show();
                    }
                }
            });


    }

private  void registerUser(){
mAuth.createUserWithEmailAndPassword(rEmail, rPaswword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if(task.isSuccessful()){
            Map<String, Object> map = new HashMap<>();
            map.put( "rName",rName);
            map.put("rLast",rLast);
            map.put("rEmail",rEmail);
            map.put("rPasword",rPaswword);

            String id= mAuth.getCurrentUser().getUid();

            mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task2) {
                    if(task2.isSuccessful()) {
                        startActivity(new Intent(RegisterActivity.this, MenuActivity.class));
                        finish();

                    }else{
                    Toast.makeText(RegisterActivity.this, "No se pudo registrar los datos" ,Toast.LENGTH_SHORT).show();
                }
                }
            });
        }else{
            Toast.makeText(RegisterActivity.this, "No se pudo registrar el usuario " ,Toast.LENGTH_SHORT).show();
        }
    }

});
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
