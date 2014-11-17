import java.util.Scanner;


public class Menu {
	
	Scanner sc = new Scanner(System.in);
	
	public void afficher(){
		System.out.println("Menu: ");
		System.out.println("0. Quitter");
		System.out.println("1. Celsius -> Fahrenheit");
		System.out.println("2. Fahrenheit -> Celsius");
	}
	
	public int choixMenu(){
		int choix;
		
		do {
			System.out.print("Votre choix: ");
			choix = sc.nextInt();
		} while((choix < 0 || choix > 2));
		
	return choix;
	}
	
	public double askTemp(){
		System.out.print("Entrer la température: ");
		return sc.nextDouble();
	}
		
}
