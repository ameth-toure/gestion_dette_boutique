package com.gestion_des_cours.entities;

public class Cours {
    private int id;
    private String date;
    private String heureDebut;
    private String heureFin;
    private Professeur professeur;

   
    public Cours() {}

    public Cours(int id, String date, String heureDebut, String heureFin, Professeur professeur) {
        this.id = id;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.professeur = professeur;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getHeureDebut() { return heureDebut; }
    public void setHeureDebut(String heureDebut) { this.heureDebut = heureDebut; }

    public String getHeureFin() { return heureFin; }
    public void setHeureFin(String heureFin) { this.heureFin = heureFin; }

    public Professeur getProfesseur() { return professeur; }
    public void setProfesseur(Professeur professeur) { this.professeur = professeur; }

    @Override
    public String toString() {
        return "Cours{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", professeur=" + professeur +
                '}';
    }
}

