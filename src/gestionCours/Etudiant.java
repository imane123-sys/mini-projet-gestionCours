package gestionCours;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int studentId;
    private String nom;
    private String email;

    private List<Cours> coursInscrits;

    public Etudiant(int studentId, String nom, String email) {
        this.studentId = studentId;
        this.nom = nom;
        this.email = email;
        this.coursInscrits = new ArrayList<>();
    }

    public void inscrire(Cours c) {
        if (!coursInscrits.contains(c)) {
            coursInscrits.add(c);
            c.ajouterEtudiant(this);
            System.out.println(nom + " est inscrit au cours : " + c.getTitre());
        } else {
            System.out.println(nom + " est déjà inscrit à ce cours.");
        }
    }

    public void afficherCours() {
        System.out.println("Cours suivis par " + nom + " :");
        if (coursInscrits.isEmpty()) {
            System.out.println("Aucun cours inscrit.");
        } else {
            for (Cours c : coursInscrits) {
                System.out.println("- " + c.getTitre());
            }
        }
    }

    public int getStudentId() {
        return studentId;
    }
    public String getNom() {
        return nom;
    }
    public String getEmail() {
        return email;
    }
}

