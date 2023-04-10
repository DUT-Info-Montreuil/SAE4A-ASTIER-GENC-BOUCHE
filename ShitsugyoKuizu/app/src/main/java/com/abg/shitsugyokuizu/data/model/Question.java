package com.abg.shitsugyokuizu.data.model;

public class Question {

    private String titreQuestionnaire;
    private String titleQues;
    private String reponse1, reponse2, reponse3, reponse4;
    private int nReponse;

    public Question(String questionnaire, String titleQues, String reponse1, String reponse2, String reponse3, String reponse4, int nReponse) {
        this.titreQuestionnaire = questionnaire;
        this.titleQues = titleQues;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.nReponse = nReponse;
    }

    public String getTitleQues() {
        return titleQues;
    }

    public void setTitleQues(String titleQues) {
        this.titleQues = titleQues;
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


    public String getTitreQuestionnaire() {
        return titreQuestionnaire;
    }

    public void setTitreQuestionnaire(String questionnaire) {
        this.titreQuestionnaire = questionnaire;
    }
}
