package com.pe.bicentenariolalibertad.Usuario.Model;

public class ModelUsers {

    private  String rNname;
    private  String rLast;
    private  String rEmail;
    private  String rPaswword;

    public ModelUsers(String rNname, String rLast, String rEmail, String rPaswword) {
        this.rNname = rNname;
        this.rLast = rLast;
        this.rEmail = rEmail;
        this.rPaswword = rPaswword;
    }

    public ModelUsers() {
    }


    public String getrNname() {
        return rNname;
    }

    public void setrNname(String rNname) {
        this.rNname = rNname;
    }

    public String getrLast() {
        return rLast;
    }

    public void setrLast(String rLast) {
        this.rLast = rLast;
    }

    public String getrEmail() {
        return rEmail;
    }

    public void setrEmail(String rEmail) {
        this.rEmail = rEmail;
    }

    public String getrPaswword() {
        return rPaswword;
    }

    public void setrPaswword(String rPaswword) {
        this.rPaswword = rPaswword;
    }
}
