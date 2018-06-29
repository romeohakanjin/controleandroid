package com.example.sindy.controleevaluationm1.model;

public class Question {

    String titre, date;
    int profil;
    long id;

    public Question(String titre, String date, int profil, long id) {
        this.titre = titre;
        this.date = date;
        this.profil = profil;
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}