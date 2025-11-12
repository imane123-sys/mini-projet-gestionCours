package gestionCours;

import java.util.ArrayList;
import java.util.List;

public class Cours {

    private int courseId;
    private String titre;
    private String description;
    private Instructeur instructeur; // un seul instructeur
    private List<Etudiant> etudiants; // plusieurs étudiants


    public Cours(int courseId, String titre, String description) {
        this.courseId = courseId;
        this.titre = titre;
        this.description = description;
        this.etudiants = new ArrayList<>();
    }


    public void ajouterEtudiant(Etudiant e) {
        if (!etudiants.contains(e)) {
            etudiants.add(e);
        }
    }

    public void assignerInstructeur(Instructeur i) {
        this.instructeur = i;
    }

    public void afficherDetails() {
        System.out.println("=== Détails du cours ===");
        System.out.println("ID : " + courseId);
        System.out.println("Titre : " + titre);
        System.out.println("Description : " + description);
        System.out.println("Instructeur : " + (instructeur != null ? instructeur.getNom() : "Non assigné"));
        System.out.println("Etudiants inscrits :");
        if (etudiants.isEmpty()) {
            System.out.println("Aucun étudiant.");
        } else {
            for (Etudiant e : etudiants) {
                System.out.println("- " + e.getNom());
            }
        }
    }

    // Getters simples
    public int getCourseId() { return courseId; }
    public String getTitre() { return titre; }
    public String getDescription() { return description; }
}
