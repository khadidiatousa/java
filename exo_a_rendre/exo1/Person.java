import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String nom;
    private String prenom;
    private String matricule;
    private int age;
    private LocalDate dateDeNaissance;

    public Personne(String nom, String prenom, LocalDate dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.matricule = generateMatricule();
        this.age = calculateAge();
    }

    public String generateMatricule() {
        int unique_id = Person.hashCode();
        String matricule = String.format("%s%s%04d", prenom.charAt(0), nom.charAt(0), unique_id);
        return matricule;
    }

    public int calculateAge() {
        LocalDate now = LocalDate.now();
        Period age = Period.between(dateDeNaissance, now);
        return age.getYears();
    }


}