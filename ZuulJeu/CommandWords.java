/**
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 * 
 * Cette classe stocke une �num�ration de toutes les commandes 
 * connues par le jeu. Elle est utilis�e pour reconnaître les commandes lors de la saisie.
 *
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // un tableau de constantes qui contient toutes les commandes
    private static final String[] validCommands = {
        "aller", "quitter", "aide", "regarder", "prendre","poser"
    };

    /**
     * Affichage de l'aide.
     * Nous affichons ici quelques messages stupides, myst�rieux et 
     * une liste des ordres.
     */
    public void printHelp() 
    {
        System.out.println("Vous �tes perdu. Vous �tes seul. Vous errez");
        System.out.println("dans l'universit�.");
        System.out.println();
        System.out.println("Les commandes sont :");
        for (String command : validCommands) {
        	System.out.print(" " + command);
        }
        System.out.println();
    }

    /**
     * V�rifie si une chaîne de caractères donn�e est une commande valide.
     * @return true si c'est le cas, false dans le cas contraire.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // si nous arrivons ici, la chaîne de caractères n'est pas une commande
        return false;
    }
}
