package com.pe.bicentenariolalibertad.Entidades;



public class ModelTest {


    public  String question;
     public String respA, respB, respC, answer;

    public ModelTest(String question, String respA, String respB, String respC, String answer) {
        this.question = question;
        this.respA = respA;
        this.respB = respB;
        this.respC = respC;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
