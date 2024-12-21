package com.gestion_des_cours.repositories;

import java.util.ArrayList;
import java.util.List;

import com.gestion_des_cours.entities.Cours;

public class CoursRepository {
    private List<Cours> coursList;

   
    public CoursRepository() {
        this.coursList = new ArrayList<>();
    }

   
    public void ajouterCours(Cours cours) {
        coursList.add(cours);
    }


    public List<Cours> listerCours() {
        return coursList;
    }

   
    public List<Cours> listerCoursParProfesseur(int professeurId) {
        List<Cours> result = new ArrayList<>();
        for (Cours cours : coursList) {
            if (cours.getProfesseur().getId() == professeurId) {
                result.add(cours);
            }
        }
        return result;
    }

   
    public List<Cours> getCoursList() {
        return coursList;
    }

    
    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    @Override
    public String toString() {
        return "CoursRepository{" +
                "coursList=" + coursList +
                '}';
    }
}