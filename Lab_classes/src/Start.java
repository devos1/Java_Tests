
class Start{
	public static void main(String[] args){
		System.out.println("Welcome to Lab classes project");
		System.out.println("------------------------------");
		
		LabClass laboClasse = new LabClass(10);
		System.out.println("Classe crŽŽe");
		System.out.println("------------------");
		laboClasse.printList();
		Student etu1 = new Student("Oliver twist", "etu_01");		
		Student etu2 = new Student("Nicky Larson", "etu_02");
		Student etu3 = new Student("Sango han", "etu_03");
		Student etu4 = new Student("Sango ku", "etu_04");
		laboClasse.enrollStudent(etu1);
		laboClasse.enrollStudent(etu2);
		laboClasse.enrollStudent(etu3);
		laboClasse.enrollStudent(etu4);
		System.out.println("------------------------------");
		laboClasse.printList();
		laboClasse.setInstructor("Pierre JEAN");
		laboClasse.setRoom("T104");
		laboClasse.setTime("Jeudi, 18h00");
		System.out.println("------------------------------");
		laboClasse.printList();
	}
}
