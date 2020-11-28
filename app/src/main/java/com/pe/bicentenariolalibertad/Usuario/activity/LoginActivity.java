package com.pe.bicentenariolalibertad.Usuario.activity;

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
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.Activitys.MenuActivity;
import com.pe.bicentenariolalibertad.Activitys.ResetPasswordActivity;
import com.pe.bicentenariolalibertad.R;
import com.pe.bicentenariolalibertad.Usuario.Presentador.PrensentadorLogin;
import com.pe.bicentenariolalibertad.Usuario.Presentador.PresentadorRegistro;

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
    GoogleSignInClient mGoogleSignInClient;
    private PrensentadorLogin prensentadorLogin;


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
            DatabaseReference mReference = FirebaseDatabase.getInstance().getReference();
             prensentadorLogin = new PrensentadorLogin(this,mFirebaseAuth,mReference);

            callbackManager =CallbackManager.Factory.create();

             mloginEmail = findViewById(R.id.txtLoginEmail);
            mloginPassword = findViewById(R.id.txtLoginPassword);

             textRegister = findViewById(R.id.textRegister);
             //boton para iniciar con email y password
             btnLogin = findViewById(R.id.btnLogin);

        btnLoginGmail = findViewById(R.id.btnLoginGmail);
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook);
        txtResetPassord = findViewById(R.id.txtResetPassword);



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this,gso);

    }




    private void setParams(){
        textRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

        // google
        btnLoginGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

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





        txtResetPassord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                String email = mloginEmail.getText().toString().trim();
                String password = mloginPassword.getText().toString().trim();
                prensentadorLogin.singInUsser(email,password);
                break;
            case R.id.textRegister:
                Intent intent = new Intent(LoginActivity.this, PresentadorRegistro.class);
                startActivity(intent);
                break;

            case R.id.btnLoginGmail:
            case R.id.btnLoginFacebook:

        }
    }


/// inicio sesin Google

    private void signIn(){
            Intent signIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signIntent, RC_SIGN_IN);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(mFirebaseAuth.getCurrentUser()!=null){
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            finish();
        }
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

        if (requestCode == RC_SIGN_IN){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount acc = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(acc);
            } catch (ApiException e) {
                Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    }



    private void  firebaseAuthWithGoogle(GoogleSignInAccount acct){
            AuthCredential authCredential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
            mFirebaseAuth.signInWithCredential(authCredential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                       // Toast.makeText(LoginActivity.this, "ingreso", Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mFirebaseAuth.getCurrentUser();
                        Intent intn = new Intent(getApplicationContext(), MenuActivity.class);
                      startActivity(intn);


                    }else {
                        Toast.makeText(LoginActivity.this, "fallo", Toast.LENGTH_SHORT).show();

                    }
                }
            });


    }



}
