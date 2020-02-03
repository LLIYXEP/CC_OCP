package exceptions;

import java.util.Random;

public class B04_Mehrere_catch {

	public static void main(String[] args) {
		/*
		 * Gleich alle Exceptions behandeln
		 */
		try {
			myMethod();
		} catch (Exception e) {
			System.out.println("catch 1");
		} 
//		catch (NumberFormatException e) {
//			System.out.println("catch 1");
//		}
		
		/*
		 * Achtung
		 * 
		 * NumberFormatException extends IllegalArgumentException 
		 * Zuerst catch fur abgeleitete Exc, danach fur die Basistyp-Exc, sonst CF
		 */
		try {
			myMethod();
		} catch (IllegalArgumentException e) {
			System.out.println("IAE 2");
		} 
//		catch (NumberFormatException e) {
//			System.out.println(""); 	// CF : unreachable
//		}
		
		/*
		 * 
		 */
		try {
			myMethod();
		} catch (NumberFormatException e) {
			System.out.println("NFE 2");
		} catch (IllegalArgumentException e) {
			System.out.println("IAE 3"); 	
		}
		
		/*
		 * Bei den Geschwistertypen ist dei Reihenfolge der Catch-Block egal
		 */
		try {
			// ...
		} catch (NumberFormatException e) {
			// ...
		} catch (IllegalArgumentException e) {
			// ...
		}
		
		System.out.println("main");
		
	}
	
	static void myMethod() {
		if (new Random().nextBoolean()) {
			throw new NumberFormatException();
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
