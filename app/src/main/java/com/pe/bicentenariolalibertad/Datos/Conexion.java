package com.pe.bicentenariolalibertad.Datos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Conexion {
    private static final String PATH_PRODUCTS = "products";

    private DatabaseReference mReference;

    private static Conexion INSTANCE = null;

    private Conexion() {
        mReference = FirebaseDatabase.getInstance().getReference();
    }

    public static Conexion getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Conexion();
        }
        return INSTANCE;
    }

    // Referencias
    public DatabaseReference getmReference(){
        return mReference;
    }

    public DatabaseReference getProductsReference(){
        return getmReference().child(PATH_PRODUCTS);
    }
}
