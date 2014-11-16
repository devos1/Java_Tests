
public class Start {

	public static void main(String[] args) {
		
		int choix;
		double temp;
		Menu menu = new Menu();
		Converter converter = new Converter();
		
		System.out.println("CONVERTISSEUR TEMPERATURE");
		System.out.println("-------------------------");
		
		menu.afficher();
		choix = menu.choixMenu();
		
		switch (choix) {
		case 0:
			System.out.println("Fin du programme");
			break;
		case 1:
			temp = menu.askTemp();
			System.out.printf(temp + " ¡C = %.1f ¡F", converter.CtoF(temp));
			break;
		case 2:
			temp = menu.askTemp();
			System.out.printf(temp + " ¡F = %.1f ¡C", converter.FtoC(temp));
			break;
		default:
			System.out.println("Erreur de saisie");
			break;
		}
	}
}