package com.abg.shitsugyokuizu.data.model;

public class QuestionnaireJoue {
    private  int idUtilisteur;
    private  int idQuestionnaire;
    private String date;
    private String intitule;


    public QuestionnaireJoue(int idUtilisteur, int idQuestionnaire, String date, String intitule) {
        this.idUtilisteur = idUtilisteur;
        this.idQuestionnaire = idQuestionnaire;
        this.date = date;
        this.intitule = intitule;
    }

    public int getIdUtilisteur() {
        return idUtilisteur;
    }

    public void setIdUtilisteur(int idUtilisteur) {
        this.idUtilisteur = idUtilisteur;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
}
