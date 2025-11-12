import gestionCours.Cours;
import gestionCours.Etudiant;
import gestionCours.Instructeur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Etudiant> etudiants = new ArrayList<>();
    static List<Instructeur> instructeurs = new ArrayList<>();
    static List<Cours> cours = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("=== Menu Gestion des Cours ===");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Ajouter un instructeur");
            System.out.println("3. Ajouter un cours");
            System.out.println("4. Inscrire un étudiant à un cours");
            System.out.println("5. Assigner un instructeur à un cours");
            System.out.println("6. Afficher les détails d’un cours");
            System.out.println("7. Quitter");
            System.out.print("Choix : ");

            choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                System.out.print("Entrez l’ID de l’étudiant : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Email : ");
                String email = scanner.nextLine();
                etudiants.add(new Etudiant(id, nom, email));
                System.out.println("Étudiant ajouté avec succès !");
            }

            else if (choix == 2) {
                System.out.print("Entrez l’ID de l’instructeur : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Nom : ");
                String nom = scanner.nextLine();
                System.out.print("Spécialisation : ");
                String spec = scanner.nextLine();
                instructeurs.add(new Instructeur(id, nom, spec));
                System.out.println("Instructeur ajouté avec succès !");
            }

            else if (choix == 3) {
                System.out.print("Entrez l’ID du cours : ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Titre : ");
                String titre = scanner.nextLine();
                System.out.print("Description : ");
                String desc = scanner.nextLine();
                cours.add(new Cours(id, titre, desc));
                System.out.println("Cours ajouté avec succès !");
            }

            else if (choix == 4) {
                System.out.print("Entrez l’ID de l’étudiant : ");
                int idEtud = scanner.nextInt();
                System.out.print("Entrez l’ID du cours : ");
                int idCours = scanner.nextInt();
                scanner.nextLine();

                Etudiant e = trouverEtudiant(idEtud);
                Cours c = trouverCours(idCours);

                if (e != null && c != null) {
                    e.inscrire(c);
                    System.out.println("Étudiant inscrit avec succès !");
                } else {
                    System.out.println("Étudiant ou cours introuvable !");
                }
            }

            else if (choix == 5) {
                System.out.print("Entrez l’ID de l’instructeur : ");
                int idInstr = scanner.nextInt();
                System.out.print("Entrez l’ID du cours : ");
                int idCours = scanner.nextInt();
                scanner.nextLine();

                Instructeur i = trouverInstructeur(idInstr);
                Cours c = trouverCours(idCours);

                if (i != null && c != null) {
                    i.assignerCours(c);
                    System.out.println("Instructeur assigné avec succès !");
                } else {
                    System.out.println("Instructeur ou cours introuvable !");
                }
            }

            else if (choix == 6) {
                System.out.print("Entrez l’ID du cours : ");
                int idCours = scanner.nextInt();
                scanner.nextLine();
                Cours c = trouverCours(idCours);
                if (c != null) {
                    c.afficherDetails();
                } else {
                    System.out.println("Cours introuvable !");
                }
            }

        } while (choix != 7);

        System.out.println("Au revoir !");
        scanner.close();
    }

    static Etudiant trouverEtudiant(int id) {
        for (Etudiant e : etudiants) {
            if (e.getStudentId() == id) return e;
        }
        return null;
    }

    static Instructeur trouverInstructeur(int id) {
        for (Instructeur i : instructeurs) {
            if (i.getInstructorId() == id) return i;
        }
        return null;
    }

    static Cours trouverCours(int id) {
        for (Cours c : cours) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }
}
