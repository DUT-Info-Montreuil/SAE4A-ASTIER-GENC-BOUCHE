package com.abg.shitsugyokuizu.data.model;

public class QuestionnaireJoue {
    private  int idUtilisateur;
    private  int idQuestionnaire;
    private String dateDeJeu;
    private String intitule;
    private String dateDeCreation;

    public QuestionnaireJoue(int idUtilisateur, int idQuestionnaire, String dateDeJeu, String intitule, String dateDeCreation) {
        this.idUtilisateur = idUtilisateur;
        this.idQuestionnaire = idQuestionnaire;
        this.dateDeJeu = dateDeJeu;
        this.intitule = intitule;
        this.dateDeCreation = dateDeCreation;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getDateDeJeu() {
        return dateDeJeu;
    }

    public void setDateDeJeu(String dateDeJeu) {
        this.dateDeJeu = dateDeJeu;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }
}
