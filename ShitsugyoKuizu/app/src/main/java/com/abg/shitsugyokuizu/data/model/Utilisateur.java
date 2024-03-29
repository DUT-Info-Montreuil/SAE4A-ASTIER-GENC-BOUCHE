package com.abg.shitsugyokuizu.data.model;

public class Utilisateur {
    private int id;
    private String pseudo;
    private String email;

    private String mdp;

    public Utilisateur(int id, String pseudo, String email, String mdp) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.mdp =mdp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
