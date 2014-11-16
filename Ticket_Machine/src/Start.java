import java.util.Scanner;


public class Start {
	public static void main(String[] args){
		
		// Cr�ation d'un instance pour lire � la console
		Scanner sc = new Scanner(System.in);
		int nbTickets, montant;
		
		TicketMachine tm = new TicketMachine(320);
		System.out.println("Machine cr��e");
		System.out.println("----------------");
		System.out.println("Prix ticket = " + tm.getPrice() + " centimes");
		
		// Demande � l'utilisateur combien de tickets et lui dit combien ins�rer
		System.out.print("Combien de tickets : ");
		nbTickets = sc.nextInt();
		System.out.print("Veuillez ins�rer : " + (nbTickets * tm.getPrice()) + " centimes : ");
		montant = sc.nextInt();
		
		// Insertion monnaie par utilisateur et impression ticket si assez d'argent
		tm.insertMoney(montant);
		if((nbTickets * tm.getPrice()) == tm.getBalance()){
			System.out.println("Voici votre ticket. Merci � une prochaine");
			tm.printTicket();
		}else if(tm.getBalance() < (nbTickets * tm.getPrice())){
			System.out.println("Vous n'avet pas entr� assez d'argent");
			System.out.println("Veuillez entrer encore " + ((nbTickets * tm.getPrice())  - tm.getBalance()) + " centimes");
		}else{
			// Bug ici, il ne tient compte que du prix d'un billet! 
			// Il faudrait adapter pour qu'on puisse prendre plus d'un billet � la fois
			System.out.println("Voici votre ticket. Merci � une prochaine");
			tm.printTicket();
			System.out.println("Veuillez r�cup�rer la monnaie : " + tm.refundBalance() + " centimes");
		}
		
		
	}
}
