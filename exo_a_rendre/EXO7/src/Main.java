import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

class Personne {
    private String nom;
    private Date dateDeNaissance;
    private double taille;

    public Personne(String nom, Date dateDeNaissance, double taille) {
        this.nom = nom;
        this.dateDeNaissance = dateDeNaissance;
        this.taille = taille;
    }

    // getters and setters for each attribute
}

class Employe extends Personne {
    private static int nbEmployes = 0;
    public static final double SALAIRE_MIN = 1000;
    private double salaire;
    private String poste;

    public Employe(String nom, Date dateDeNaissance, double taille, double salaire, String poste) {
        super(nom, dateDeNaissance, taille);
        this.salaire = salaire;
        this.poste = poste;
        nbEmployes++;
    }

    // Ajout d'une méthode pour le recrutement d'un employé avec nom, salaire et poste
    public static Employe recruterEmploye(String nom, double salaire, String poste) {
        return new Employe(nom, getRandomBirthDate(), getRandomHeight(), salaire, poste);
    }

    // Ajout d'une méthode pour le recrutement d'un employé avec nom, date de naissance et poste
    public static Employe recruterEmploye(String nom, Date dateDeNaissance, String poste) {
        return new Employe(nom, dateDeNaissance, getRandomHeight(), getRandomSalary(), poste);
    }

    // Méthode pour générer un nombre aléatoire entre 1000 et 5000
    private static double getRandomSalary() {
        Random random = new Random();
        return SALAIRE_MIN + (5000 - SALAIRE_MIN) * random.nextDouble();
    }

    // Méthode pour générer une chaîne de caractères aléatoire de 10 caractères de longueur
    private static String getRandomName() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }

    // Méthode pour générer une date de naissance aléatoire
    private static Date getRandomBirthDate() {
        Random random = new Random();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse("19" + random.nextInt(90) + "-" + random.nextInt(12) + "-" + random.nextInt(30));
        } catch (ParseException e) {
            return null;
        }
    }

    // Méthode pour générer une taille aléatoire entre 1,50 et 2,00
    private static double getRandomHeight() {
        Random random = new Random();
        return 1.50 + (2.00 - 1.50) * random.nextDouble();
    }
 
}

public class Main {
    public static void main(String[] args) {
        // Ajout de 5 employés
        List<Employe> employes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            employes.add(Employe.recruterEmploye(Employe.getRandomName(), Employe.getRandomBirthDate(), Employe.getRandomHeight(), Employe.getRandomSalary(),