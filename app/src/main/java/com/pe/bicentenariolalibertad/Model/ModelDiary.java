package com.pe.bicentenariolalibertad.Model;

import java.util.Date;

public class ModelDiary {

String diaryimg;
String  diarytitulo;
String diaryFecha;
String direccion;
String hora;

    public ModelDiary(String diaryimg, String diarytitulo, String diaryFecha, String direccion, String hora) {
        this.diaryimg = diaryimg;
        this.diarytitulo = diarytitulo;
        this.diaryFecha = diaryFecha;
        this.direccion = direccion;
        this.hora = hora;
    }

    public ModelDiary() {
    }

    public String getDiaryimg() {
        return diaryimg;
    }

    public void setDiaryimg(String diaryimg) {
        this.diaryimg = diaryimg;
    }

    public String getDiarytitulo() {
        return diarytitulo;
    }

    public void setDiarytitulo(String diarytitulo) {
        this.diarytitulo = diarytitulo;
    }

    public String getDiaryFecha() {
        return diaryFecha;
    }

    public void setDiaryFecha(String diaryFecha) {
        this.diaryFecha = diaryFecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
