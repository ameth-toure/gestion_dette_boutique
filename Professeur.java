package com.gestion_des_cours.entities;

public class Professeur {
    private int id;
    private String nom;
    private String email;

   
    public Professeur() {}

    public Professeur(int id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}