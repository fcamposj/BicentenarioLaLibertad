package com.pe.bicentenariolalibertad.Usuario.Presentador;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.pe.bicentenariolalibertad.Activitys.MenuActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.annotation.NonNull;

public class PresentadorRegistro {


    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    private String TAG= "Presentaor Registro";

    public PresentadorRegistro(Context mContext, FirebaseAuth mAuth, DatabaseReference mReference) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mReference = mReference;

    }


    // registrando por usurio y gmail


    public void signupuservalidation(String name, String last, String email , String password, String repitpassword, boolean checkterminos){

        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[\\p{L}\\p{M}\\p{N}.-]*(\\.[\\p{L}\\p{M}]{2,})$");
        Pattern pattern1 = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");

        Matcher matcher = pattern.matcher(email);
        Matcher matcher1= pattern1.matcher(name);
        Matcher matcher2 = pattern1.matcher(last);

        boolean matchFound = matcher.matches();
        boolean matc= matcher1.matches();
        boolean las= matcher2.matches();


        if(!name.isEmpty() && !last.isEmpty() && !email.isEmpty() && !password.isEmpty() ) {

            if (matc == true && las==true){
            if (password.length() >= 6) {
                if (password.equals(repitpassword)) {
                    if (checkterminos == true) {

                        if (matchFound == true) {
                            ProgressDialog dialog = new ProgressDialog(mContext);
                            dialog.setMessage("Registrando Usuario");
                            dialog.setCancelable(false);
                            dialog.show();
                            signUpUser(name, last, email, password);
                        } else {
                            Toast.makeText(mContext, "Correo invalido", Toast.LENGTH_SHORT).show();
                        }
                    } else {

                        Toast.makeText(mContext, "Acepte los terminos y condiciones", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "La contraseña es diferente e repetir la contraseña", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(mContext, "La contraseña debe ser mayor a 6 caracteres", Toast.LENGTH_SHORT).show();
            }
        }else {
                Toast.makeText(mContext, "Nombre o Apellidos solo letras y espacios" ,Toast.LENGTH_SHORT).show();
        }
        }else {
            Toast.makeText(mContext, "Debe Completar lo campos" ,Toast.LENGTH_SHORT).show();
        }
    }



    private    void  signUpUser(String name, String last, String email , String password){


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "createUserWithEmail:success");
                            Map<String, Object>createUser = new HashMap<>();
                            createUser.put("rEmail",email);
                            createUser.put("rLast",last);
                            createUser.put("rName", name);
                            createUser.put("rPasword",password);
                            mReference.child("Users").child(task.getResult().getUser().getUid()).updateChildren(createUser).addOnCompleteListener(
                                    new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task2) {
                                            if(task2.isSuccessful()) {
                                                Intent intent = new Intent(mContext, MenuActivity.class);
                                                mContext.startActivity(intent);


                                            }else{
                                                Toast.makeText(mContext, "No se pudo registrar los datos" ,Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                            );
                        }
                        else {
                           Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(mContext,"Autenticacion failed",
                                    Toast.LENGTH_SHORT).show();



                        }
                    }
                });
    }



    // ingresan


}
