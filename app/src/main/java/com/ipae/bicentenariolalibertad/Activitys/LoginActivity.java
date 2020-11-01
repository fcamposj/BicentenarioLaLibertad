package com.ipae.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ipae.bicentenariolalibertad.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Jorge Ventura on 2020-02-15.
 * jorge.venturag@gmail.com
 *
 * Ventura Apps
 * Lima, Peru.
 **/
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int RC_SIGN_IN = 123 ;
    private TextView textRegister;
    private Button btnLogin;
    private Button btnLoginGmail;
    private Button btnLoginFacebook;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initParams();
        setParams();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser  user= firebaseAuth.getCurrentUser();
                if(user !=null){

                }else {



                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            if(requestCode == RESULT_OK){

            }else{

            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mAuthStateListener != null){
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }
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
