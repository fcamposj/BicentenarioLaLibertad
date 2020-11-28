package com.pe.bicentenariolalibertad.Entidades;

import java.io.Serializable;

public class ModelDiary implements Serializable {

    String aimagen;
    String atitulo;
    String afecha;
    String ahora;
    String adireccion;

    public ModelDiary(String aimagen, String atitulo, String afecha, String ahora, String adireccion) {
        this.aimagen = aimagen;
        this.atitulo = atitulo;
        this.afecha = afecha;
        this.ahora = ahora;
        this.adireccion = adireccion;
    }

    public ModelDiary() {
    }

    public String getAimagen() {
        return aimagen;
    }

    public void setAimagen(String aimagen) {
        this.aimagen = aimagen;
    }

    public String getAtitulo() {
        return atitulo;
    }

    public void setAtitulo(String atitulo) {
        this.atitulo = atitulo;
    }

    public String getAfecha() {
        return afecha;
    }

    public void setAfecha(String afecha) {
        this.afecha = afecha;
    }

    public String getAhora() {
        return ahora;
    }

    public void setAhora(String ahora) {
        this.ahora = ahora;
    }

    public String getAdireccion() {
        return adireccion;
    }

    public void setAdireccion(String adireccion) {
        this.adireccion = adireccion;
    }

    @Override
    public String toString() {
        return "ModelDiary{" +
                "aimagen='" + aimagen + '\'' +
                ", atitulo='" + atitulo + '\'' +
                ", afecha='" + afecha + '\'' +
                ", ahora='" + ahora + '\'' +
                ", adireccion='" + adireccion + '\'' +
                '}';
    }
}
