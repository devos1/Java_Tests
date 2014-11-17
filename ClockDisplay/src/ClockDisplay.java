
/**
 * La classe ClockDisplay implante l'affichage d'une horloge digitale pour
 * une horloge de style européen, de 24 heures. L'horloge affiche les heures et les minutes. 
 * La plage va de 00:00 (minuit) à 23:59 (une minute avant 
 * minuit).
 * 
 * L'affichage de l'horloge reçoit des "tics" (via la méthode timeTick) chaque minute
 * et ragit en incrémentant l'affichage. Cela fonctionne comme dans une horloge
 * normale : l'heure augmente lorsque les minutes reviennent à zéro.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simule l'affichage réel
    
    /**
     * Constructeur des objets ClockDisplay. Ce constructeur 
     * crée une nouvelle horloge à 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructeur des objets ClockDisplay. Ce constructeur
     * crée un nouveau jeu d'horloge à l'heure spécifiée par les 
     * param√®tres.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * Cette méthode doit étre appelée une fois toutes les minutes - elle fait
     * avancer l'affichage de l'horloge d'une minute.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // retour à zéro !
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Définit l'heure d'affichage sur l'heure et la minute
     * spécifiées.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Renvoie l'heure actuelle de cet affichage au format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Met à jour la chaîne interne qui sert à l'affichage.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
