package assertions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;



public class B03_Assertions_sinvoll {

	
	
	/*
	 * Regel 1: NICHT die Argumente der main -Methode mit Assertions uberprufen
	 */
	public static void main(String[] args) {
		
//		assert args != null & args.length == 2 : "Bitte Vorname und Nachname ubergeben"; // Nicht sinvoll	
//		lieber mit einer if-Abfrage und der passenden Fehlemeldung.
		
//		printIntValue(SelectedValue.ONE);
		
		
	}
	
	/*
	 * Regel 2: Die Argumente der public Methode uberprufen ist nicht sinvoll
	 */
	public static String format(Object x) {
		assert x != null; // NICHT sinvoll. Lieber if-Abfrage und Exception
		return String.valueOf(x);
	}
	
	/*
	 * Regel 3: Die Argumente der private Methode uberprufen ist sinvoll
	 */
	private static String format(String s) {
		assert s != null; //OK
		System.out.println(String.valueOf(s));
		return String.valueOf(s);
	}
	
	/*
	 * Regel 4: Es gibt seltene Ausnamen aus der Regel 2.
	 * Die Argumente der public Methode uberprufen konnen mit Assertions sinvoll kontroliert werden
	 * wenn sicher ist , dass die Invariante nicht gebrochen werden kann
	 */
	
	public enum SelectedValue{
		ONE, TEN
	}
	
	public static void printIntValue(SelectedValue ev) {
		switch (ev) {
		case ONE:
			System.out.println("1");
			break;
		case TEN:
			System.out.println("2");
			break;
		default:
			assert false;
		}
	}
	
	/*
	 * Regel 5: Bitte NIE mit Assertions die Zustande andern
	 */
	static void m() {
		 int x = new Random().nextInt(1);
		 
		 assert x == getZero();	// getZero andert den Wert einer Variable
		 
		 System.out.println("x = " + y); // 1 wenn Assertion aktiviert ist, sonst 0
	}

	static int y = 0;
	
	private static int getZero() {
		y++;
		return 0;
	}
	
	
}
