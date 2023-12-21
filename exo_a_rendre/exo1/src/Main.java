import per.Person;

import java.time.LocalDate;

public class Main {
    public static <Personne> void main(String[] args) {
        Personne person = (Personne) new Person("Doe", "John", LocalDate.of(1990, 5, 15));
        System.out.println(Personne.getNom());
        System.out.println(Personne.getPrenom());
        System.out.println(Personne.getDateDeNaissance());
        System.out.println(Personne.getMatricule());
        System.out.println(Personne.getAge());
    }
}