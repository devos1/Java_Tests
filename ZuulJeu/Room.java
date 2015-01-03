import java.util.HashMap;

/**
 * Classe Room - une pièce dans un jeu d'aventures.
 *
 * Cette classe fait partie de l'application "le monde de Zuul".
 * "Le monde de Zuul" est un jeu d'aventures très simple en mode texte.
 *
 * Une pièce ("Room") représente un lieu dans le scénario du jeu.
 * Elle est reliée à d'autres pièces à l'aide de sorties. Les sorties
 * sont nommées nord, est, sud, ouest. Pour chaque direction, la pièce stocke une référence
 * vers la pièce voisine ou null s'il n'existe pas de sortie dans cette direction.
 * 
 * @author  Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    private String description;
//    private Room northExit;
//    private Room southExit;
//    private Room eastExit;
//    private Room westExit;
    private HashMap<String, Room> exits;
    private HashMap<String, Objet> Objets;
    private HashMap<String, Objet> ObjetsDansMains;
    
    /**
     * Crée une pièce décrite par la chaîne "description". Au départ, il n'existe 
     * aucune sortie. "description" est une chaîne comme "une cuisine" ou
     * "une cour de jardin".
     * @param description La description de la pièce.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String,Room>();
        Objets = new HashMap<String,Objet>();
        ObjetsDansMains = new HashMap<String,Objet>();
    }
    
    public void addObjet(Objet Objet) {
    	Objets.put(Objet.getNom(), Objet);
    }
    
	public void printLocationInfo() {
		System.out.println("Vous �tes dans " + getDescription());
		System.out.print("Les sorties : ");
		for (String direction : exits.keySet()) {
			System.out.print(direction + " ");
		}		
//		if(northExit != null) {
//            System.out.print("nord ");
//        }
//        if(eastExit != null) {
//            System.out.print("est ");
//        }
//        if(southExit != null) {
//            System.out.print("sud ");
//        }
//        if(westExit != null) {
//            System.out.print("ouest ");
//        }
        System.out.println();
	}
	
	public Room go(String direction) {
		return exits.get(direction);
		// nous essayons de quitter la pièce courante.
//        Room nextRoom = null;
//        if(direction.equals("nord")) {
//            nextRoom = northExit;
//        }
//        if(direction.equals("est")) {
//            nextRoom = eastExit;
//        }
//        if(direction.equals("sud")) {
//            nextRoom = southExit;
//        }
//        if(direction.equals("ouest")) {
//            nextRoom = westExit;
//        }
//
//        return nextRoom;
	}

    /**
     * Définit les sorties de cette pièce. Chaque direction soit conduit 
     * à une autre pièce, soit est null (il n'y a pas de sortie dans cette direction).
     * @param north La sortie nord.
     * @param east La sortie est.
     * @param south La sortie sud.
     * @param west La sortie ouest.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            exits.put("nord",north);
        if(east != null)
        	exits.put("est",east);
        if(south != null)
        	exits.put("sud",south);
        if(west != null)
        	exits.put("ouest",west);
    }
    
    public void setExit(String direction,Room room) {
    	exits.put(direction,room);
    }

    /**
     * @return La description de la pi�ce.
     */
    public String getDescription()
    {
        return description;
    }

    // Fonction pour regarder les objets
	public int regarder() {
		
		for (Objet obj : Objets.values()) {
			System.out.print(obj.getNom() + " ");
		}
		
		System.out.println();
		return Objets.size();
	}
	
 	// Fonction pour prendre un objet
	public boolean prendreObjet(String nomObjet){
		boolean isPoison, isAntidote;
		Objet obj = Objets.get(nomObjet);
		
		int arraySizeBeforeTake, arraySizeAfterTake;
		arraySizeBeforeTake = Objets.size();
		
		if (obj != null) {
			Objets.remove(obj.getNom());
			// Ajout de l'objet dans la main (hashmap)
			ObjetsDansMains.put(nomObjet, obj);
			// Voir si c'est un objet avec poison ou antidote
			isPoison = obj.isPoison();
			isAntidote = obj.isAntidote();
		}
		
		arraySizeAfterTake = Objets.size();
		
		if (arraySizeAfterTake < arraySizeBeforeTake) {
			return true;
		}else {
			return false;
		}
	}


	
	// Fonction pour poser un objet
 	public boolean poserObjet(String nomObjet){
 		Objet obj = ObjetsDansMains.get(nomObjet);
		
 		int arraySizeBeforeTake, arraySizeAfterTake;
		arraySizeBeforeTake = ObjetsDansMains.size();
		
		if (obj != null) {
			Objets.put(nomObjet, obj);
		}
		
		ObjetsDansMains.remove(nomObjet);
		
		arraySizeAfterTake = ObjetsDansMains.size();
		
		if (arraySizeAfterTake < arraySizeBeforeTake) {
			return true;
		}else {
			return false;
		}
	}
 	

}
