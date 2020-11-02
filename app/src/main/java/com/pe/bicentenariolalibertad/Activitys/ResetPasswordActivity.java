package com.pe.bicentenariolalibertad.Activitys;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.pe.bicentenariolalibertad.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

        private EditText mtxtResetEmail;
        private Button btnReset;
        private  String resetEmail="";
        FirebaseAuth mAuth;
       private ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resert_password);

         initParams();
         setParams();


    }


    private void initParams(){
      mtxtResetEmail = findViewById(R.id.txtResetEmail);
      btnReset = findViewById(R.id.btnReset);
      mAuth=FirebaseAuth.getInstance();
      mProgressDialog= new ProgressDialog(this);

    }

    private void setParams(){
       btnReset.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             resetEmail = mtxtResetEmail.getText().toString();
             if(!resetEmail.isEmpty()){
                 mProgressDialog.setMessage("Espera un momento");
                 mProgressDialog.setCanceledOnTouchOutside(false);
                 mProgressDialog.show();
                 resetPassword();
             }
             else{
                 Toast.makeText(ResetPasswordActivity.this, "Ingrese el Correo", Toast.LENGTH_SHORT).show();
             }
           }
       });
    }

    private  void resetPassword(){
        mAuth.setLanguageCode("es");
        mAuth.sendPasswordResetEmail(resetEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ResetPasswordActivity.this, "Se ha enviado un correo para restablecer tu contraseña", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ResetPasswordActivity.this, "No se pudo enviar el correo para restablecer contraseña", Toast.LENGTH_SHORT).show();
                }
                mProgressDialog.dismiss();
            }
        });
    }
}
