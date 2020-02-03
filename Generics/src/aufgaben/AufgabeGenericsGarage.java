package aufgaben;

interface Fahrzeug {}

class PKW implements Fahrzeug {}
class LKW implements Fahrzeug {}

class Garage<T extends Fahrzeug> {
	private T fahrzeug;
	
	public void reinfahren(T fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
}

public class AufgabeGenericsGarage {

	public static void main(String[] args) {
		
		LKW lkw = new LKW();
		PKW pkw = new PKW();
		
		Garage<PKW> garagePKW = new Garage();
		Garage<LKW> garageLKW = new Garage();
		
//		garagePKW = garageLKW // Gut, dass die Zeile nicht kompiliert
		
		garagePKW.reinfahren(pkw);
//		garagePKW.reinfahren(lkw);  // Gut, dass die Zeile nicht kompiliert
		
		garageLKW.reinfahren(lkw);
//		garageLKW.reinfahren(pkw);  // Gut, dass die Zeile nicht kompiliert
		
//		Garage<Integer> garageSinloss; // CF (s. Typebound)
		
	}
	
}
