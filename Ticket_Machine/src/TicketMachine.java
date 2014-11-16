/**
 * TicketMachine mod�lise une billetterie automatique qui �met
 * des billets à prix unique.
 * Le prix d'un billet est sp�cifi� via le constructeur.
 * Les instances v�rifieront qu'un utilisateur entre uniquement
 * des sommes logiques et n'affichera le billet
 * que si suffisamment d'argent a �t� ins�r�.
 * 
 * @author David J. Barnes et Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // Le prix d'un billet de cette machine.
    private int price;
    // La somme d'argent entr�e par un client jusqu'à maintenant.
    private int balance;
    // La somme totale collect�e par cette machine.
    private int total;

    /**
     * Cr�e une machine qui d�livre des billets du prix donn�.
     */
    // CONSTRUCTEUR
    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return Le prix d'un billet.
     */
    // GETTER
    public int getPrice()
    {
        return price;
    }

    /**
     * Return La somme d'argent d�jà ins�r�e pour le prochain
     *  billet.
     */
    // GETTER
    public int getBalance()
    {
        return balance;
    }

    /**
     * Re�oit une somme en centimes de la part d'un client.
     * V�rifie que la somme est logique.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Utilisez un montant positif : " +
                               amount);
        }
    }

    /**
     * Affiche un billet si suffisamment d'argent a �t� ins�r�
     * et r�duit le solde courant du prix du billet. Affiche
     * un message d'erreur s'il faut rajouter de l'argent.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simule l'affichage d'un billet.
            System.out.println("##################");
            System.out.println("# La ligne BlueJ");
            System.out.println("# Billet");
            System.out.println("# " + price + " centimes.");
            System.out.println("##################");
            System.out.println();

            // Actualise le total collect� avec le prix.
            total = total + price;
            // R�duit le solde du prix.
            balance = balance - price;
        }
        else {
            System.out.println("Vous devez ins�rer au moins : " +
                               (price - balance) + " centimes de plus.");
                    
        }
    }

    /**
     * Renvoie l'argent du solde.
     * Le solde est effac�.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
