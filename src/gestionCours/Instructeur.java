package gestionCours;

import java.util.ArrayList;
import java.util.List;

public class Instructeur {

    private int instructorId;
    private String nom;
    private String specialisation;


    private List<Cours> coursEnseignes;


    public Instructeur(int instructorId, String nom, String specialisation) {
        this.instructorId = instructorId;
        this.nom = nom;
        this.specialisation = specialisation;
        this.coursEnseignes = new ArrayList<>();
    }


    public void assignerCours(Cours c) {
        if (!coursEnseignes.contains(c)) {
            coursEnseignes.add(c);
            c.assignerInstructeur(this); // lie l'instructeur au cours
            System.out.println("Cours " + c.getTitre() + " assigné à " + nom);
        }
    }


    public void afficherCours() {
        System.out.println("Cours enseignés par " + nom + " :");
        if (coursEnseignes.isEmpty()) {
            System.out.println("Aucun cours.");
        } else {
            for (Cours c : coursEnseignes) {
                System.out.println("- " + c.getTitre());
            }
        }
    }

    public int getInstructorId() { return instructorId; }
    public String getNom() { return nom; }
    public String getSpecialisation() { return specialisation; }
}

