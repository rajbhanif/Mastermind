import java.util.Random;
import java.util.Scanner;

// the class main
public class Main {


    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu Mastermind!");
        System.out.println("Vous devez deviner une série de 5 couleurs parmi : Rouge (R), Jaune (J), Bleu (B), Orange (O), Vert (V), Gris (G), Noir (N), Turquoise (T).");
        System.out.println("Les couleurs peuvent être répétées.");
        System.out.println("Vous avez 12 essais pour deviner la bonne combinaison.");
        System.out.println();

        //The System.in parameter is used to take input from the standard input or Create an instance of the Mastermind class and a Scanner object for user input.
        Mastermind jeu = new Mastermind();
        Scanner scanner = new Scanner(System.in);

        //Start a loop to allow the player 12 attempts to guess the correct combination.
       // Prompt the player to enter their guess for a combination of 5 colors (e.g., "R J B O V").
        //Parse the input into an array of color abbreviations (e.g., "R", "J", "B", "O", "V").
        //Check if the input contains exactly 5 color abbreviations; if not, inform the player and continue to the next iteration of the loop.
        //Create a Series object to represent the player's guess.
        //Validate each color abbreviation and add it to the essai (guess) if it is valid.
        while (jeu.getNbrEssais() < 12) {
            System.out.print("Essai #" + (jeu.getNbrEssais() + 1) + ": Entrez votre série de 5 couleurs (ex: R J B O V) : ");
            String input = scanner.nextLine();
            String[] couleurs = input.split(" ");

            if (couleurs.length != 5) {
                System.out.println("Veuillez entrer exactement 5 couleurs.");
                continue;
            }

            Series essai = new Series();
            boolean saisieValide = true;

            for (String couleurAbreviation : couleurs) {
                Couleur couleur = CouleurParAbreviation(couleurAbreviation);
                if (couleur == null) {
                    System.out.println("Couleur invalide : " + couleurAbreviation);
                    saisieValide = false;
                    break;
                }
                essai.ajouterCouleur(couleur);
            }

            //
            if (!saisieValide) {
                continue;
            }
            /*  Call the essayer method on the Mastermind object to get a result for the guess.
                Display the result to the player, which typically indicates how many colors were correctly placed and how many were correct but in the wrong position.
                Check if the player's guess is equal to the solution; if so, inform the player that they've won and break out of the loop.*/
            Series resultat = jeu.essayer(essai);
            System.out.println("Résultat : " + resultat.toString());

            if (jeu.getSolution().equals(essai)) {
                System.out.println("Bravo ! Vous avez trouvé la solution en " + jeu.getNbrEssais() + " essais.");
                break;
            }
        }

        //Check if the player has exhausted all 12 attempts; if so, inform the player of the solution.
        if (jeu.getNbrEssais() == 12) {
            System.out.println("Désolé, vous avez épuisé tous vos essais. La solution était : " + jeu.getSolution().toString());
        }
    }

    // Define a private method CouleurParAbreviation to link color abbreviations to their respective colors.
    private static Couleur CouleurParAbreviation(String abreviation) {
        for (Mastermind.CouleursPossibles couleurPossible : Mastermind.CouleursPossibles.values()) {
            if (abreviation.equalsIgnoreCase(String.valueOf(couleurPossible.getCouleur().getAbr()))) {
                return couleurPossible.getCouleur();
            }
        }
        return null;
    }
}