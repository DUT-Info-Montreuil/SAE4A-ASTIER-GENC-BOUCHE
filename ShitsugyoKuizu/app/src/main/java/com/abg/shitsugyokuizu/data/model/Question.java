package com.abg.shitsugyokuizu.data.model;

public class Question {

    private int id;
    private String intitule;
    private String reponse1, reponse2, reponse3, reponse4;
    private int nReponse;

    public Question(int idQuestion, String intitule, String reponse1, String reponse2, String reponse3, String reponse4, int nReponse) {
        this.id = idQuestion;
        this.intitule = intitule;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.nReponse = nReponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String titleQues) {
        this.intitule = titleQues;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponse4() {
        return reponse4;
    }

    public void setReponse4(String reponse4) {
        this.reponse4 = reponse4;
    }

    public int getnReponse() {
        return nReponse;
    }

    public void setnReponse(int nReponse) {
        this.nReponse = nReponse;
    }



}
