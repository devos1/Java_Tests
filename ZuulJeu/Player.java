public class Player {

	private Room currentRoom;
	private boolean isPoisoned;

	public Player(Room initialRoom) {
		currentRoom = initialRoom;
	}

	public void printLocationInfo() {
		currentRoom.printLocationInfo();
	}
	

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public boolean walk(String direction) {
		Room nextRoom = currentRoom.go(direction);
        if (nextRoom == null) {
            System.out.println("Il n'y a pas de porte !");
            return false;
        }
        else {
        	currentRoom = nextRoom;
            printLocationInfo();   
            return true;
        }
	}
	
	public int regarder() {
		return currentRoom.regarder(); 
	}

	public boolean prendre(String nom) {
		if (nom.equals("Champ")) {
			this.setPoisoned(true);
		}else if (nom.equals("Pomme")) {
			this.setPoisoned(false);
		}
		return currentRoom.prendreObjet(nom);
	}
	
	public boolean poser(String nom) {
		return currentRoom.poserObjet(nom);
	}
	
	public boolean getIsPoisoned() {
		return isPoisoned;
	}
	
	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}
	
}
