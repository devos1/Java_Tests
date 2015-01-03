/**
 *  Cette classe est la classe principale de l'application "le monde de Zuul".
 * "Lle monde de Zuul" est un jeu d'aventures tr�s simple en mode texte.
 * Les utilisateurs peuvent se promener dans le d�cor. C'est tout. 
 * Elle devrait vraiment �tre �tendue pour rendre le jeu plus int�ressant !
 * 
 * Pour jouer � ce jeu,  cr�ez une instance de cette classe 
 * et appelez la m�thode "play".
 * 
 * Cette classe principale cr�e et initialise toutes les autres : 
 * elle cr�e toutes les pi�ces, cr�e l'analyseur syntaxique et d�marre le jeu.  
 * Elle �value aussi et ex�cute les commandes renvoy�es par l'analyseur syntaxique. 
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */

public class Game 
{
	/**
	 * Introduction programme
	 * @param args
	 */
	public static void main(String[] args) {
		new Game().play();
	}
	

    private Parser parser;
    private Player player;
	private Scenario scenario;
   
        
    /**
     * Cr�ation du jeu et initialisation de sa carte interne.
     */
    public Game() 
    {
        scenario = new Scenario();
        player = new Player(scenario.getInitRoom());
        parser = new Parser();
    }

    /**
     *  Fonction principale de jeu. Boucle jusqu'� la fin du jeu.
     */
    public void play() 
    {            
        printWelcome();

        // Entr�e dans la boucle principale des commandes.  Ici, nous
        // r�p�tons la lecture et l'ex�cution des commandes jusqu'� la fin du jeu.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Merci d'avoir jou�. Au revoir.");
    }

    /**
     * Affichage du message d'accueil au joueur.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bienvenue au jeu de Zuul !");
        System.out.println("Zuul est un nouveau jeu d'aventure terriblement ennuyeux.");
        System.out.println("Tapez 'aide' si vous avez besoin d'aide.");
        System.out.println();    
        player.printLocationInfo();
    }



    /**
     * Etant donn� une commande, traiter (ex�cuter) la commande.
     * @param command La commande � traiter.
     * @return true Si la commande termine le jeu, false autrement.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Je ne comprends pas cette commande...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("aide"))
            parser.printHelp();
        else if (commandWord.equals("aller"))
            goRoom(command);
        else if (commandWord.equals("quitter"))
            wantToQuit = quit(command);
        else if (commandWord.equals("regarder"))
        	player.regarder();
        else if (commandWord.equals("prendre"))
        	prendre(command);
        else if (commandWord.equals("poser"))
        	poser(command);

        return wantToQuit;
    }

    private void prendre(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("prendre quoi ?");
            return;
        }

        String nom = command.getSecondWord();
		player.prendre(nom);
	}
    
    private void poser(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("poser quoi ?");
            return;
        }

        String nom = command.getSecondWord();
		player.poser(nom);
	}


    /** 
     * Essai de d�placement dans une direction. Si une sortie existe, 
     * entrer dans la nouvelle pi�ce, sinon afficher un message d'erreur.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // en cas d'absence du deuxi�me mot, nous ne savons pas o� aller...
            System.out.println("Aller o� ?");
            return;
        }

        String direction = command.getSecondWord();

        player.walk(direction);
    }




    /** 
     * "Quitter" vient d'�tre saisi. V�rification du reste de la commande
     * pour s'assurer que nous voulons r�ellement quitter le jeu.
     * @return true si cette commande arr�te le jeu, false autrement.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quitter quoi ?");
            return false;
        }
        else {
            return true;  // informe que nous voulons quitter le jeu
        }
    }
}

