package exceptions;

import java.util.Random;

public class B05_Multicatch {

	public static void main(String[] args) {
		
		/*
		 * Entweder ArithmeticException oder NullpointerException abfangen und gleich behandeln
		 */
		try {
			myMethod();
		} catch (ArithmeticException | NullPointerException e) { // <- Multicatch fur Geschwistertypen
			System.out.println("Abgefangen: " + e.getClass());
		}
		
		/*
		 * 
		 */
		try {
	
		} catch (ArithmeticException | NullPointerException | ClassCastException e) { // <- Multicatch fur Geschwistertypen
			
		} 
		
		/*
		 * Achtung in der Prufung!
		 */
//		try {
//	
//		} catch (RuntimeException | NullPointerException e) { // <- CF - Multicatch bei Vererbunghierarchie nicht moglich
//			
//		} 
		
	} // end of main
	
	static void myMethod() {
		int x = new Random().nextInt(2);
		switch (x) {
		case 0:
			throw new ArithmeticException();
		case 1:
			throw new NullPointerException();
		default:
			break;
		}
	}
	
}
