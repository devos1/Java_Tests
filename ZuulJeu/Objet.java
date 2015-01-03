import java.util.Random;

/**
 * Classe Objet
 * @author Heig-Vd
 *
 */

public class Objet {

	private String nom;
	private int poids;
	private boolean poison;
	private boolean antidote;
	private int nivPoison; 		// 3 niveaux pour le poison allant de 1 à 3
	private int minutes;
	private boolean lecturePoisonOK;

	public Objet(String nom, int poids, boolean poison, boolean antidote) {

		super();

		if (antidote == true && poison == true) {
			System.out.println("Erreur dans la création de l'objet - l'objet ne peut avoir en même temps le poison et l'antidote");
		}else{
			this.nom = nom;
			this.poids = poids;
			this.poison = poison;
			this.antidote = antidote;
		}		
	}

	public void defineNivPoison(){	
		Random rnd = new Random();
		int min = 1;
		int max = 4;
		nivPoison = rnd.nextInt(max - min) + min;
	}

	public String getNom() {
		return nom;
	}

	public int getPoids() {
		return poids;
	}

	public boolean getPoison(){
		return poison;
	}

	public boolean getAntidote(){
		return antidote;
	}

	public int getNivPoison(){
		return nivPoison;
	}

	/**
	 * Description	: Affiche un message si l'aliment contient un poison
	 * 				: 1 = Niveau faible -> 10 minutes avant de mourir
	 * 				: 2 = Niveau moyen 	-> 5 minutes avant de mourir
	 * 				: 3 = Niveai élevé	-> 1 minute avant de mourir 
	 */
	public boolean isPoison() {
		// Annoncer qu'on vient de manger un aliment empoisonné
		if (this != null) {
			if (this.getPoison()) {
				this.defineNivPoison();
				nivPoison = this.getNivPoison();
				switch (nivPoison) {
				case 1:
					minutes = 10;
					lecturePoisonOK = true;
					break;
				case 2:
					minutes = 5;
					lecturePoisonOK = true;
					break;
				case 3:
					minutes = 1;
					lecturePoisonOK = true;
					break;
				default:
					System.out.println("Erreur lecture du niveau de poison : niveau -> " + nivPoison);
					lecturePoisonOK = false;
					minutes = 0;
					break;
				}
				if (lecturePoisonOK) {
					System.out.println("Vous venez de prendre un aliment empoisonné");
					System.out.println("...");
					System.out.println("Vous avez "+ minutes + " minute(s) pour trouver l'antidote, bonne chance...");	
				}
				return true;
			}
		}
		return false;
	}
		
	public boolean isAntidote(){
		if (this != null){
			if (this.getAntidote()) {
				System.out.println("Vous venez de prendre un aliment avec antidote, bravo vous êtes sauvé");
				return true;
			}
		}
		return false;
	}
}
