package exceptions;

import java.util.Random;

public class B01_Werfen_Propagieren {

	public static void main(String[] args) {
		try {
			methodeMitException(); // hierher wird die in der Methode geworfen Exception propagiert
		} catch (Exception e) {
			System.out.println("Abgefangen: " + e.getClass());
		}
		
		
		System.out.println("end of main");
		
	}
	
	//Die in der Methode geworfene Exception wird automatisch zu der Stelle des Aufrufes propagiert
	static void methodeMitException() {
		
		if (new Random().nextBoolean()) {
			throw new NullPointerException(); // werfen explizit mit throw
		} else {
			System.out.println(5/0); // geworfen vom Operator '/'
		}
		
	}
	
}
