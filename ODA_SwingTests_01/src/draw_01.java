import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JApplet;

/**
 * Points traités
 *  	- Rédéfinition méthode paint avec appel à super
 *  	- Dessiner un texte avec positionnement automatique sur x et y fixe
 *  	- Ouverture de la fenêtre de l'applet à une taille définie (modificaiton dans les params (run configuration)
 *  	- Utilisation de showStatus()
 *  	- 
 *  
 * Méthodes utilisées en vrac (primitives) 
 * 		- drawString
 * 		- drawLine
 * 		- setFont
 * 		- setColor
 */

/**
 * @author		: oscar
 * @description	: Programme pour tester différentes fonctions pour dessiner	dans un APPLET
 *
 */
@SuppressWarnings("serial")
public class draw_01 extends JApplet{

	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		/**
		 * TRAITEMENT TEXTE PRINCIPAL DE LE FENETRE AVEC SA LIGNE DU BAS
		 */
		String txtHello = "Salut tout le monde";
		int txtHelloLength = txtHello.length();
		
		// Calcul pour placer le texte au millieu du x
		int debutTxt = (getWidth() / 2) - ((txtHello.length() / 2) * 10);
		showStatus("Taille texte : " + txtHelloLength + " -- Width :" + getWidth() + " -- Début texte : " + debutTxt);
		
		// Affichage d'un texte centré horizontalement et à 20 px du haut
		g.setFont(new Font("Helvetica", Font.BOLD, 20));
		g.setColor(Color.blue);
		g.drawString(txtHello, debutTxt, 20);
		
		// Dessiner une ligne en dessous du texte sur toute la longueur de la fenêtre
		g.setColor(Color.LIGHT_GRAY);
		g.drawLine(5, 25, getWidth() - 5, 25);
		
		/**
		 * *****************************************************************
		 */
		
		/**
		 * TRAITEMENT POUR LES 3 SMILEYS
		 */
		// Au Centre
		g.drawOval(getWidth() / 2 - 50, 50, 100, 100);
		// Oeil gauche
		g.drawOval((getWidth() / 2) - 25 - 7, 75, 15, 15);
		// Oeil droit
		g.drawOval((getWidth() / 2) + 25 - 7, 75, 15, 15);
		// Bouche 
		g.drawArc((getWidth() / 2) -25 , 110, 50, 40, 0, 180);
		
		// A Gauche
		g.drawOval(((getWidth() / 2) / 2) - 50, 50, 100, 100);
		// Oeil gauche
		g.drawOval(((getWidth() / 2) / 2) - 25 - 7, 75, 15, 15);
		// Oeil droit
		g.drawOval(((getWidth() / 2) / 2) + 25 - 7, 75, 15, 15);
		// Bouche 
		g.drawArc(((getWidth() / 2) / 2) -25 , 90, 50, 40, 0, -180);
		
		// A Droite
		g.drawOval((getWidth() / 2) + ((getWidth() / 2) / 2) - 50 , 50, 100, 100);
		// Oeil gauche
		g.drawOval((getWidth() / 2) + ((getWidth() / 2) / 2) -25 - 7, 75, 15, 15);
		// Oeil droit
		g.drawOval((getWidth() / 2) + ((getWidth() / 2) / 2) + 25 - 7, 75, 15, 15);
		// Bouche 
		g.drawArc((getWidth() / 2) + ((getWidth() / 2) / 2) -25 , 90, 50, 40, 0, -180);
		
		/**
		 * *****************************************************************
		 */
	}

}
