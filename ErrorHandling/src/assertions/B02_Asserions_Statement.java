package assertions;

public class B02_Asserions_Statement {

	public static void main(String[] args) {
		
		int x = 0;
		
		/*
		 * Variante 1;
		 */
		
		assert x == 0;
		
		/*
		 * Variante 2;
		 */
		
		assert x == 0: "Der Text fur die Fehlermeldung";
		assert x == 0 : 22;
		assert x == 0 : String.valueOf(12 + 5.2);
		
		System.out.println("end of main");
		
		assert x == 0 ? true : x == 1; // bitte so nicht in der Praxis
//		assert x == 0 ? 12 : 13; // CF 
		
	}
	
}
