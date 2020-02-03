package nested;

public class B04_Local {

	public static void main(String[] args) {
		
//		Fahrzeug f;		// CF
		
		class Fahrzeug {
			void fahren() {
				System.out.println("Fahrzeug fahrt...");
			}
		} // Fahrzeug gultig ab hieer bis zum Ende der main Methode
		
		new Fahrzeug().fahren();
		
	} // end of main
	
	static void test() {
//		Fahrzeug f;		// CF
	}
	
}
