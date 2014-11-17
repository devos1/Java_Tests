
public class Start {
	public static void main(String[] args){
		
		System.out.println("Simulation horloge HH:MM");
		System.out.println("------------------------");
		
		ClockDisplay cd = new ClockDisplay(23, 59);
		System.out.println("Instance de l'horloge crée");
		System.out.println("");
		System.out.println(cd.getTime());
		System.out.println("tick");
		cd.timeTick();
		System.out.println(cd.getTime());
		System.out.println("tick");
		cd.timeTick();
		System.out.println(cd.getTime());
		System.out.println("tick");
		cd.timeTick();
		System.out.println(cd.getTime());
		
	}
}
