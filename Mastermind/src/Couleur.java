import java.util.Objects;

//nom (String): Represents the name of the color.
//abr (char): Represents the abbreviation of the color.
public class Couleur {
    //creation des attributs
    private String nom;
    private char abr;

    //The class has a constructor that takes two parameters: nom and abr, which are used to initialize the attributes of the Couleur object.
    public Couleur(String nom,char abr) {
        this.nom = nom;
        this.abr= abr;
    }

    //Returns the name of the color.
    public String getNom() {
        return nom;
    }

    //Returns the abbreviation of the color
    public char getAbr() {
        return abr;
    }

    //creation of the methode equals that compares both the nom and abr attributes of two Couleur objects to determine if they are equal.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couleur couleur = (Couleur) o;
        return abr == couleur.abr && Objects.equals(nom, couleur.nom);
    }

    // methode tostring which returns a string containing the abbreviation of the color.
    @Override
    public String toString() {
        return "abr=" + abr;

    }

}
