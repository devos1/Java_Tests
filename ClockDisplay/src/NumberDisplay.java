
/**
 * La classe NumberDisplay représente un affichage digital qui peut contenir
 * des valeurs allant de zéro à une limite donnée. La limite peut être spécifiée à la création
 * de l'affichage. Les valeurs vont de zéro (inclus) à limite-1. Si elles sont utilisées,
 * par exemple pour les secondes sur une horloge digitale, la limite serait 60, 
 * entrainant des valeurs d'affichage de 0 à 59. A l'incrémentation, l'affichage 
 * revient automatiquement à zéro lorsqu'il atteint la limite.
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
     * Définit la limite à laquelle l'afficage revient à zéro.
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
     * Renvoie la valeur d'affichage (c'est-à-dire la valeur actuelle sous forme de chaÎne
     * à deux chiffres. Si la valeur est inférieure à dix, un zéro sera ajouté
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
     * Définit la valeur d'affichage sur la nouvelle valeur. Si la nouvelle
     * valeur est inférieure à zéro ; au-dessus de la limite, ne fait rien.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= start) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Incrémente la valeur d'affichage de un, en revenant à zéro si la
     * limite est atteinte.
     */
    public void increment()
    {
        // value = (value + 1) % limit;
    	// Incrémentation
        value++;
        if (value >= limit) {
            value = start; // Remise à la valeur de départ
        }
    }
}
