package com.gestion_des_cours.views;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.gestion_des_cours.entities.Cours;
import com.gestion_des_cours.entities.Professeur;
import com.gestion_des_cours.services.CoursService;
import com.gestion_des_cours.services.ProfesseurService;

public class MainMenu {
    public static void main(String[] args) {
        ProfesseurService professeurService = new ProfesseurService();
        CoursService coursService = new CoursService();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Ajouter un professeur");
            System.out.println("2. Lister les professeurs");
            System.out.println("3. Créer un cours");
            System.out.println("4. Lister tous les cours");
            System.out.println("5. Lister les cours d’un professeur");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1 -> {
                    // Ajout du contrôle d'unicité de l'ID
                    System.out.print("ID : ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consommer la nouvelle ligne
                    
                    // Vérification de l'unicité de l'ID
                    if (professeurService.listerProfesseurs().stream().anyMatch(p -> p.getId() == id)) {
                        System.out.println("L'ID existe déjà, choisissez un autre ID.");
                        break;
                    }

                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();

                    // Ajout de la vérification de l'email
                    String email;
                    while (true) {
                        System.out.print("Email : ");
                        email = scanner.nextLine();
                        if (isValidEmail(email)) {
                            break;
                        } else {
                            System.out.println("L'email n'est pas valide. Veuillez entrer un email valide.");
                        }
                    }

                    professeurService.ajouterProfesseur(new Professeur(id, nom, email));
                }
                case 2 -> professeurService.listerProfesseurs().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID du cours : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Date (YYYY-MM-DD) : ");
                    String date = scanner.nextLine();
                    System.out.print("Heure début (HH:MM) : ");
                    String heureDebut = scanner.nextLine();
                    System.out.print("Heure fin (HH:MM) : ");
                    String heureFin = scanner.nextLine();
                    System.out.print("ID du professeur : ");
                    int profId = scanner.nextInt();
                    Professeur professeur = professeurService.listerProfesseurs()
                            .stream().filter(p -> p.getId() == profId).findFirst().orElse(null);
                    if (professeur != null) {
                        coursService.ajouterCours(new Cours(id, date, heureDebut, heureFin, professeur));
                    } else {
                        System.out.println("Professeur non trouvé !");
                    }
                }
                case 4 -> coursService.listerCours().forEach(System.out::println);
                case 5 -> {
                    System.out.print("ID du professeur : ");
                    int profId = scanner.nextInt();
                    coursService.listerCoursParProfesseur(profId).forEach(System.out::println);
                }
                case 6 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 6);
    }

    // Méthode pour valider le format de l'email
    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}