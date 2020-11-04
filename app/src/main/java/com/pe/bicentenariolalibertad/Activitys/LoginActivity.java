package com.pe.bicentenariolalibertad.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.pe.bicentenariolalibertad.R;

import java.util.Arrays;

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
    private TextView  txtResetPassord;

    private CallbackManager callbackManager;


    FirebaseAuth mFirebaseAuth;


    private EditText mloginEmail, mloginPassword;
    private  String nEmail ="", nPassword="";

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initParams();
        setParams();


    }


    private void initParams(){

            mFirebaseAuth = FirebaseAuth.getInstance();
            callbackManager =CallbackManager.Factory.create();
        textRegister = findViewById(R.id.textRegister);
        btnLogin = findViewById(R.id.btnLogin);
        btnLoginGmail = findViewById(R.id.btnLoginGmail);
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
        txtResetPassord = findViewById(R.id.txtResetPassword);

        mloginEmail = findViewById(R.id.txtLoginEmail);
        mloginPassword = findViewById(R.id.txtLoginPassword);

    }

    private void setParams(){
        textRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnLoginGmail.setOnClickListener(this);

        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nEmail = mloginEmail.getText().toString();
                nPassword =mloginPassword.getText().toString();

                if(!nEmail.isEmpty() && !nPassword.isEmpty()){
                    loginUser();
                }else{
                    Toast.makeText(LoginActivity.this, " Complete los campos",Toast.LENGTH_SHORT).show();
                }

            }
        });

        txtResetPassord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(mFirebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            finish();
        }


        //   FirebaseUser user = mFirebaseAuth.getCurrentUser();
        //if (user !=null){
          //  startActivity(new Intent(LoginActivity.this, GameActivity.class));
            //finish();

       // }

    }

    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential= FacebookAuthProvider.getCredential(token.getToken());
        mFirebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        //  startActivity(new Intent(LoginActivity.this, GameActivity.class));
                       //    finish();

                          ingresado();
                           Toast.makeText(LoginActivity.this, "Ingreso Correctamente", Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(LoginActivity.this, "No puede ingresar con esta cuenta", Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }

    public void ingresado(){

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode,data);

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

        }
    }


    private void loginUser(){
   mFirebaseAuth.signInWithEmailAndPassword(nEmail, nPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
       @Override
       public void onComplete(@NonNull Task<AuthResult> task) {
           if(task.isSuccessful()){
               startActivity(new Intent(LoginActivity.this, GameActivity.class));
               finish();
           }else{
               Toast.makeText(LoginActivity.this, "No se pudo iniciar sesion, compruebe los datos",Toast.LENGTH_SHORT).show();
           }
       }
   });
    }


}
