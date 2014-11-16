/**
 * TicketMachine modélise une billetterie automatique qui émet
 * des billets √† prix unique.
 * Le prix d'un billet est spécifié via le constructeur.
 * Les instances vérifieront qu'un utilisateur entre uniquement
 * des sommes logiques et n'affichera le billet
 * que si suffisamment d'argent a été inséré.
 * 
 * @author David J. Barnes et Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // Le prix d'un billet de cette machine.
    private int price;
    // La somme d'argent entrée par un client jusqu'√† maintenant.
    private int balance;
    // La somme totale collectée par cette machine.
    private int total;

    /**
     * Crée une machine qui délivre des billets du prix donné.
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
     * Return La somme d'argent déj√† insérée pour le prochain
     *  billet.
     */
    // GETTER
    public int getBalance()
    {
        return balance;
    }

    /**
     * Reçoit une somme en centimes de la part d'un client.
     * Vérifie que la somme est logique.
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
     * Affiche un billet si suffisamment d'argent a été inséré
     * et réduit le solde courant du prix du billet. Affiche
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

            // Actualise le total collecté avec le prix.
            total = total + price;
            // Réduit le solde du prix.
            balance = balance - price;
        }
        else {
            System.out.println("Vous devez insérer au moins : " +
                               (price - balance) + " centimes de plus.");
                    
        }
    }

    /**
     * Renvoie l'argent du solde.
     * Le solde est effacé.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
