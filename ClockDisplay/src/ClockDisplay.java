
/**
 * La classe ClockDisplay implante l'affichage d'une horloge digitale pour
 * une horloge de style europ�en, de 24 heures. L'horloge affiche les heures et les minutes. 
 * La plage va de 00:00 (minuit) � 23:59 (une minute avant 
 * minuit).
 * 
 * L'affichage de l'horloge re�oit des "tics" (via la m�thode timeTick) chaque minute
 * et ragit en incr�mentant l'affichage. Cela fonctionne comme dans une horloge
 * normale : l'heure augmente lorsque les minutes reviennent � z�ro.
 * 
 * @author Michael Kolling et David J. Barnes
 * @version 2008.03.30
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simule l'affichage r�el
    
    /**
     * Constructeur des objets ClockDisplay. Ce constructeur 
     * cr�e une nouvelle horloge � 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructeur des objets ClockDisplay. Ce constructeur
     * cr�e un nouveau jeu d'horloge � l'heure sp�cifi�e par les 
     * paramètres.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(0,24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * Cette m�thode doit �tre appel�e une fois toutes les minutes - elle fait
     * avancer l'affichage de l'horloge d'une minute.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // retour � z�ro !
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * D�finit l'heure d'affichage sur l'heure et la minute
     * sp�cifi�es.
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
     * Met � jour la cha�ne interne qui sert � l'affichage.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue();
    }
}
