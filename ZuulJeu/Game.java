/**
 *  Cette classe est la classe principale de l'application "le monde de Zuul".
 * "Lle monde de Zuul" est un jeu d'aventures très simple en mode texte.
 * Les utilisateurs peuvent se promener dans le décor. C'est tout. 
 * Elle devrait vraiment être étendue pour rendre le jeu plus intéressant !
 * 
 * Pour jouer à ce jeu,  créez une instance de cette classe 
 * et appelez la méthode "play".
 * 
 * Cette classe principale crée et initialise toutes les autres : 
 * elle crée toutes les pièces, crée l'analyseur syntaxique et démarre le jeu.  
 * Elle évalue aussi et exécute les commandes renvoyées par l'analyseur syntaxique. 
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
     * Création du jeu et initialisation de sa carte interne.
     */
    public Game() 
    {
        scenario = new Scenario();
        player = new Player(scenario.getInitRoom());
        parser = new Parser();
    }

    /**
     *  Fonction principale de jeu. Boucle jusqu'à la fin du jeu.
     */
    public void play() 
    {            
        printWelcome();

        // Entrée dans la boucle principale des commandes.  Ici, nous
        // répétons la lecture et l'exécution des commandes jusqu'à la fin du jeu.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Merci d'avoir joué. Au revoir.");
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
     * Etant donné une commande, traiter (exécuter) la commande.
     * @param command La commande à traiter.
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
     * Essai de déplacement dans une direction. Si une sortie existe, 
     * entrer dans la nouvelle pièce, sinon afficher un message d'erreur.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // en cas d'absence du deuxième mot, nous ne savons pas où aller...
            System.out.println("Aller où ?");
            return;
        }

        String direction = command.getSecondWord();

        player.walk(direction);
    }




    /** 
     * "Quitter" vient d'être saisi. Vérification du reste de la commande
     * pour s'assurer que nous voulons réellement quitter le jeu.
     * @return true si cette commande arrête le jeu, false autrement.
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

