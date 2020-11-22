package com.pe.bicentenariolalibertad.Datos;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestDatos {

  Conexion conexion;

    public DatabaseReference tablapregunta(int computerCount){

        return  conexion.getmReference().child("Questions").child(String.valueOf(computerCount));
    }
}
