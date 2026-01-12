import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class  Series {

    //Represents the series of colors as an ArrayList of Couleur objects.
    private ArrayList<Couleur> serie;

    //The class has a constructor that initializes the serie attribute as an empty ArrayList
    public Series() {
        serie = new ArrayList<>();
    }

    // It performs bounds checking and throws an IllegalArgumentException if the position is out of bounds.
    public Couleur getCouleur(int position) {
        if (position < 0 || position > serie.size()) {
            throw new IllegalArgumentException("la position ne correspond pas à une couleur dans la série");
        } else {
            return serie.get(position);
        }
    }

    //Adds a Couleur to the series.
    public void ajouterCouleur(Couleur unecouleur) {
        serie.add(unecouleur);
    }

    //Overrides the equals method to compare two Series objects based on the equality of their serie attributes.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Series series = (Series) o;
        return Objects.equals(serie, series.serie);
    }

    //method to generate a hash code for a Series object based on its serie attribute.
    @Override
    public int hashCode() {
        return Objects.hash(serie);
    }

    //The method returns a new Series object that represents the result of the comparison. It throws an IllegalArgumentException if the series have different sizes.
    public Series comparer(Series uneSerie){
        if (serie.size() != uneSerie.serie.size()){
           throw new IllegalArgumentException(" les deux séries n'ont pas le même nombre d'éléments");
        }
    Series result = new Series();
    boolean[] dejaCompare = new boolean[serie.size()];

        for (int i = 0; i < this.serie.size(); i++) {
            if (serie.get(i).equals(uneSerie.serie.get(i))){
                result.ajouterCouleur(new Couleur("Noire", 'N'));
                dejaCompare[i] = true;
            }
        }

        for (int i = 0; i < this.serie.size(); i++) {
            if (!dejaCompare[i]){
                for (int j = 0; j < this.serie.size(); j++) {
                    if (!serie.equals(this.serie.get(i))) {
                        result.ajouterCouleur(new Couleur("Blanche", 'B'));
                        dejaCompare[i] = true;
                        dejaCompare[j] = true;
                        break;
                    }
                }

            }
        }
        // Si toutes les couleurs correspondent dans le même ordre, retourne vrai
        return result;
    }

    //Overrides the toString method to generate a string representation of the Series object by concatenating the abbreviations of its colors. It trims the resulting string to remove leading and trailing whitespace.
    @Override
    public String toString() {
        String resultat="";
        for (int i = 0; i < serie.size(); i++) {
            resultat += serie.get(i).getAbr() +"";
        }
        return  resultat.trim();

    }

}