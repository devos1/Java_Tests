
public class Scenario {
	
    private Room hall,salon,cuisine,  cave;
	private Objet vase;
	private Objet pc;
	
	private Objet pomme, poire, champignon;	// champignon contient poison et pomme l'antidote
	
    public Scenario()
    {      
        // cr�ation des pi�ces
        hall = new Room(" le hall");
        salon = new Room(" le salon");
        cuisine = new Room(" la cuisine");
        cave = new Room(" la cave");
        
        // initialisation des sorties des pi�ces
        hall.setExits(null, salon, null, null);
        salon.setExits(null, null, cuisine, hall);
        cuisine.setExits(salon, null, null, null);
        
        cuisine.setExit("enBas",cave);
        cave.setExit("enHaut", cuisine);
        
        vase = new Objet("Vase", 3, false, false);
        salon.addObjet(vase);
        hall.addObjet(vase);
        
        pc = new Objet("PC",5, false, false);
        salon.addObjet(pc);
        
        
        // Cr�ation d'aliments et ajout dans les pi�ces
        pomme = new Objet("Pomme", 1, false, true);
        hall.addObjet(pomme);
        cuisine.addObjet(pomme);
        
        champignon = new Objet("Champ", 2, true, false);
        cuisine.addObjet(champignon);
        cave.addObjet(champignon);
        
        poire = new Objet("Poire", 1, false, false);
        cuisine.addObjet(poire);
        hall.addObjet(poire);
        
    }
    
    public Room getInitRoom() {
    	return hall;
    }

}
