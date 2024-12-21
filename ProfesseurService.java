package com.gestion_des_cours.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gestion_des_cours.entities.Professeur;
import com.gestion_des_cours.repositories.ProfesseurRepository;

public class ProfesseurService {
    private final ProfesseurRepository repository = new ProfesseurRepository();

    // Vérifier la validité de l'email avec une expression régulière
    public boolean emailValide(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Ajouter un professeur
    public void ajouterProfesseur(Professeur professeur) {
        if (!emailValide(professeur.getEmail())) {
            System.out.println("Erreur : L'email n'est pas valide.");
            return; // Ne pas ajouter si l'email est invalide
        }
        repository.ajouterProfesseur(professeur);
    }

    // Lister les professeurs
    public List<Professeur> listerProfesseurs() {
        return repository.listerProfesseurs();
    }
}