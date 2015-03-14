import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JScrollBar;


/**
 * Points traités
 * 	- 
 * 	- 
 * Méthodes utilisées en vrac 
 * 	- 
 * 	-  	
 */

/**
 * @author oscar
 * @description	: Programme pour créer des interfaces graphiques avec différents composants
 *
 */
@SuppressWarnings("serial")
public class main extends JApplet implements AdjustmentListener {
	
	// Variables de la classe
	private JLabel titre;
	private JScrollBar sb;
	private int valeur;
	
	public void init(){
		
		// Choix du Layout
		setLayout(new FlowLayout());
				
		/**
		 * TRAITEMENT POUR LE LABEL DU TITRE
		 */
		// Création d'un label pour titre et personnalisation
		titre = new JLabel("Page pour tester divers composants graphiques");
		titre.setForeground(Color.GRAY);
		titre.setFont(new Font("Verdana", Font.BOLD, 20));
		
		// Ajout au container
		add(titre);
		
		/**
		 * *****************************************************************
		 */
		
		/**
		 * TRAITEMENT POUR LA BARRE DE PROGRESSION
		 */	
		// Crétion d'une progressbar
		sb = new JScrollBar(JScrollBar.HORIZONTAL, valeur, 1, 0, 101);
		// Ajout au container
		add(sb);
		// Abonnement à l'évenement
		sb.addAdjustmentListener(this);
		
	}
	
	// Pas possible de dessiner en même temps, voir pourquoi
	 public void paint(Graphics g) {
		 super.paint(g);
		 g.drawLine (5, 35, getWidth()-5, 35);
		 g.drawString("Valeur courante: " + valeur, 50, 100);
	 }

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		valeur = sb.getValue();
		repaint();
	}
}
