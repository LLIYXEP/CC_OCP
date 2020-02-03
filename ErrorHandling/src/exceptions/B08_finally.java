package exceptions;

import java.util.Random;

public class B08_finally {

	public static void main(String[] args) {
		
//		System.out.println(kleineFrage()); // 7
		
		try {
			System.out.println(5/ new Random().nextInt(2));
			System.out.println("a");
		} finally {
			System.out.println("b");
		}
		
		/*
		 * Mogliche Ergebnisse:
		 * 
		 * 5ab oder b gefolgt von der Ausgabe ArithmeticException
		 */
		
	}
	
	static int kleineFrage() {
		try {
			return 2;
		} finally {
			return 7; // Achtund! return 2 wird durch return 7 ersetzt
		}
	}
	
}
