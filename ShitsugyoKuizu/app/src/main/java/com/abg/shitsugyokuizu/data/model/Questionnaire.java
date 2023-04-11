package com.abg.shitsugyokuizu.data.model;

public class Questionnaire {
    private int idQuestionnaire;
    private String intitule;


    public Questionnaire(int id, String intitule) {
        this.idQuestionnaire = id;
        this.intitule = intitule;
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
}
