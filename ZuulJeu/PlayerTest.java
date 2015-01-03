import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class PlayerTest {

	private Scenario scenario;
	private Player player;
	private Objet obj;
	private Objet objWithPoison;
	private Objet objWithAntidote;
	private int minutes;
	
	@Before
	public void setUp() throws Exception {
		scenario = new Scenario();
        player = new Player(scenario.getInitRoom());
        obj = new Objet("Vase", 2, false, false);
        objWithPoison = new Objet("Champ", 1, true, false);
        objWithAntidote = new Objet("Pomme", 1, false, true);
	}

	@Test
	public void walk() {
		assertEquals(true,player.walk("est"));
		assertEquals(" le salon", player.getCurrentRoom().getDescription());
		assertEquals(false,player.walk("nord"));
		assertEquals(" le salon", player.getCurrentRoom().getDescription());
	}
	
	@Test
	/* Commentaire Oscar : Ajout méthodes pour tester la fanction:
	 * de poser un objet
	 * de manger un aliment empoisonné
	 * de manger un aliment avec antidote
	 * pour savoir si le joueur est empoisonnée oi pas
	 */ 
	public void objet() {
		assertEquals(false,player.prendre("vase"));
		assertEquals(true,player.walk("est"));
		assertEquals(2,player.regarder());
		assertEquals(true,player.prendre("Vase"));
		assertEquals(1,player.regarder());
		assertEquals(true, player.poser("Vase"));
		assertEquals(2,player.regarder());
		assertEquals(true,player.prendre("Vase"));
		assertEquals(1,player.regarder());
		assertEquals(false, player.poser("vase"));	
		assertEquals(false, player.prendre("Champ"));	//Champ n'existe pas dans la 1ère pièces
		player.walk("est");
		player.walk("sud");
		assertEquals(3,player.regarder());
		assertEquals(true,player.prendre("Champ"));	//Champ existe donc ok
		assertEquals(true,player.poser("Champ"));
		assertEquals(true, player.prendre("Champ"));		// Mange un champigon, le joueur est empoisonné
		assertEquals(true, player.getIsPoisoned());
		assertEquals(true, player.prendre("Pomme"));		// Mange une pomme qui contient l'antidote, le joueur ne devrait plus être empoisonné
		assertEquals(true, objWithAntidote.isAntidote());	// Test si la pomme contient bien l'antidote
		assertEquals(false, player.getIsPoisoned());		// Test de l'état du jour si empoisonné ou pas
	}


}
