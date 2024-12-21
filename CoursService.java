package com.gestion_des_cours.services;

import java.util.List;

import com.gestion_des_cours.entities.Cours;
import com.gestion_des_cours.repositories.CoursRepository;

public class CoursService {
    private final CoursRepository repository = new CoursRepository();

    public void ajouterCours(Cours cours) {
        repository.ajouterCours(cours);
    }

    public List<Cours> listerCours() {
        return repository.listerCours();
    }

    public List<Cours> listerCoursParProfesseur(int professeurId) {
        return repository.listerCoursParProfesseur(professeurId);
    }
}
