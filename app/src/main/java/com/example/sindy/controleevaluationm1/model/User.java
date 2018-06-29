package com.example.sindy.controleevaluationm1.model;

public class User {

    String name;
    int points, profil;

    public User(String name, int points, int profil) {
        this.name = name;
        this.points = points;
        this.profil = profil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getProfil() {
        return profil;
    }

    public void setProfil(int profil) {
        this.profil = profil;
    }
}