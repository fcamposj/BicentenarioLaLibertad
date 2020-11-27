package com.pe.bicentenariolalibertad.Usuario.Model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pe.bicentenariolalibertad.controller.ControllerTest;

public class UsuarioDAO {



    private static UsuarioDAO usuarioDAO;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    private  FirebaseAuth firebaseAuth;

    public  static UsuarioDAO getInstance(){
        if (usuarioDAO == null) usuarioDAO = new UsuarioDAO();
        return  usuarioDAO;
    }

    private  UsuarioDAO(){
        database = FirebaseDatabase.getInstance();
        firebaseAuth= FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
    }

 public  FirebaseAuth getFirebaseAuth(){
        return  firebaseAuth;
 }
public DatabaseReference getReference(){
        return reference;
}

}
