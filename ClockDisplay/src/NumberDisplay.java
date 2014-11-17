
/**
 * La classe NumberDisplay repr�sente un affichage digital qui peut contenir
 * des valeurs allant de z�ro � une limite donn�e. La limite peut �tre sp�cifi�e � la cr�ation
 * de l'affichage. Les valeurs vont de z�ro (inclus) � limite-1. Si elles sont utilis�es,
 * par exemple pour les secondes sur une horloge digitale, la limite serait 60, 
 * entrainant des valeurs d'affichage de 0 � 59. A l'incr�mentation, l'affichage 
 * revient automatiquement � z�ro lorsqu'il atteint la limite.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class NumberDisplay
{
    private int limit;
    private int start;
    private int value;

    /**
     * Constructeur des objets de la classe NumberDisplay.
     * D�finit la limite � laquelle l'afficage revient � z�ro.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
        start = 0;
    }
    
    // Autre constructeur
    public NumberDisplay(int startValue, int rollOverLimit)
    {
        limit = rollOverLimit;
        value = startValue;
        start = startValue;
    }

    /**
     * Renvoie la valeur actuelle.
     */
    // GETTER
    public int getValue()
    {
        return value;
    }

    /**
     * Renvoie la valeur d'affichage (c'est-�-dire la valeur actuelle sous forme de cha�ne
     * � deux chiffres. Si la valeur est inf�rieure � dix, un z�ro sera ajout�
     * avant).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * D�finit la valeur d'affichage sur la nouvelle valeur. Si la nouvelle
     * valeur est inf�rieure � z�ro ; au-dessus de la limite, ne fait rien.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= start) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Incr�mente la valeur d'affichage de un, en revenant � z�ro si la
     * limite est atteinte.
     */
    public void increment()
    {
        // value = (value + 1) % limit;
    	// Incr�mentation
        value++;
        if (value >= limit) {
            value = start; // Remise � la valeur de d�part
        }
    }
}
