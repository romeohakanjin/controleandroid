package com.example.sindy.controleevaluationm1.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class FavoriteQuestionEntity {
    @PrimaryKey(autoGenerate = true)
    long id;
    String titre, date;
    int profil;

    public FavoriteQuestionEntity(long id, String titre, String date, int profil) {
        this.id = id;
        this.titre = titre;
        this.date = date;
        this.profil = profil;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
