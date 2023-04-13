package com.abg.shitsugyokuizu.data.model;

import java.sql.Date;

public class Questionnaire {
    private int idQuestionnaire;
    private int idUtilisateur;
    private String intitule;
    private String dateDeCreation;

    private  int score;

    public Questionnaire() {
    }

    public Questionnaire(int id, int idUtilisateur, String intitule) {
        this.idQuestionnaire = id;
        this.idUtilisateur = idUtilisateur;
        this.intitule = intitule;
        this.dateDeCreation = dateDeCreation;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
}
