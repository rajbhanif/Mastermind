import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Mastermind {
    //    solution (Series): Represents the secret combination that the player needs to guess.
    //    nbrEssais (int): Keeps track of the number of attempts the player has made.
    //    essais (Array of Series): An array to store the player's guesses.
    private Series solution;
    private int nbrEssais;
    private Series[] essais;

    //Constructs a Mastermind instance with a predefined solution.
    public Mastermind(Series uneSolution) {
        this.solution = uneSolution;
        nbrEssais= 0;
        essais = new Series[12];

    }

    // Constructs a Mastermind instance with a randomly generated solution related to CouleursPossibles enum to choose random colors for the solution.
    public Mastermind() {
        Random rand = new Random();
        solution = new Series();

        for (int i = 0; i < 5; i++) {
            int index = rand.nextInt(CouleursPossibles.values().length);
            Couleur couleur = CouleursPossibles.values()[index].getCouleur();
            solution.ajouterCouleur(couleur);
        }
        nbrEssais = 0;
        essais = new Series[12];
    }
    //Returns the secret combination (the solution).
    public Series getSolution() {
        return solution;
    }

    // Returns the number of attempts made by the player.
    public int getNbrEssais() {
        return nbrEssais;
    }

    //Allows the player to make a guess by providing a Series object representing their guess.
    //Compares the player's guess to the secret combination (solution) using the comparer method from the Series class.
    //Stores the player's guess in the essais array and increments the nbrEssais counter.
    //Returns a Series object that represents the result of the comparison
    public Series essayer (Series uneSerie) {

        // verifier les bonnes couleurs au bon endroit(noires)
        if (nbrEssais >= 12) {
            throw new IllegalStateException("Vous avez atteint le nombre maximum d'essais (12).");
        }


        Series result = solution.comparer(uneSerie);
        essais[nbrEssais] = uneSerie;
        nbrEssais++;

        return result;
    }

    public String toString() {
        String results = "";
        for (int i = 0; i < nbrEssais; i++) {
            results += essais[i].toString() + " : ";
            Series result = essayer(essais[i]);
            results += result.toString();
        }
        return results;
    }

    //Defines an enum containing the possible colors that can be used in the game. Each color is associated with a Couleur object.
    enum CouleursPossibles {
        ROUGE(new Couleur("Rouge", 'R')),
        JAUNE(new Couleur("Jaune", 'J')),
        BLEU(new Couleur("Bleu", 'B')),
        ORANGE(new Couleur("Orange", 'O')),
        VERT(new Couleur("Vert", 'V')),
        GRIS(new Couleur("Gris", 'G')),
        NOIR(new Couleur("Noir", 'N')),
        TURQUOISE(new Couleur("Turquoise", 'T'));

        private final Couleur couleur;

        CouleursPossibles(Couleur couleur) {
            this.couleur = couleur;
        }

        public Couleur getCouleur() {
            return couleur;
        }
    }
}
