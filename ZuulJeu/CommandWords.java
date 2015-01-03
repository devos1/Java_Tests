/**
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures tr√®s simple en mode texte.
 * 
 * Cette classe stocke une énumération de toutes les commandes 
 * connues par le jeu. Elle est utilisée pour reconna√Ætre les commandes lors de la saisie.
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
     * Nous affichons ici quelques messages stupides, mystérieux et 
     * une liste des ordres.
     */
    public void printHelp() 
    {
        System.out.println("Vous êtes perdu. Vous êtes seul. Vous errez");
        System.out.println("dans l'université.");
        System.out.println();
        System.out.println("Les commandes sont :");
        for (String command : validCommands) {
        	System.out.print(" " + command);
        }
        System.out.println();
    }

    /**
     * Vérifie si une cha√Æne de caract√®res donnée est une commande valide.
     * @return true si c'est le cas, false dans le cas contraire.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // si nous arrivons ici, la cha√Æne de caract√®res n'est pas une commande
        return false;
    }
}
