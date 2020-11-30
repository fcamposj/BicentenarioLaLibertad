package com.pe.bicentenariolalibertad.Entidades;



public class ModelTest {


    public  String question;
     public String respA, respB, respC;
     int correctAns;

    public ModelTest(String question, String respA, String respB, String respC, int correctAns) {
        this.question = question;
        this.respA = respA;
        this.respB = respB;
        this.respC = respC;
        this.correctAns = correctAns;
    }

    public ModelTest() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRespA() {
        return respA;
    }

    public void setRespA(String respA) {
        this.respA = respA;
    }

    public String getRespB() {
        return respB;
    }

    public void setRespB(String respB) {
        this.respB = respB;
    }

    public String getRespC() {
        return respC;
    }

    public void setRespC(String respC) {
        this.respC = respC;
    }

    public int getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }
}
