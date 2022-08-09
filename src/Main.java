// Vartan Artyunyan
// Martikelnummer 5120007
public class Main {


	public static void main(String[] args) {
		FloyWa aufgabe1 = new FloyWa("Aufgabe1.csv");
		
		aufgabe1 .printPath();
		aufgabe1 .printDist();
		
		FloyWa aufgabe2 = new FloyWa("Aufgabe2.csv");
		
		System.out.println(aufgabe2.getLargestDist());
		
		for (Integer i : aufgabe2.getPath(0, 2)) {
			System.out.print("->" + (char) (i + 65));
		}
		
		

	}

}
