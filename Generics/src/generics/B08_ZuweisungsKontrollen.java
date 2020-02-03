package generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class B08_ZuweisungsKontrollen {

	public static void main(String[] args) {
		
		Integer var1 = 12;
		Double var2 = 12.0;
		
		/*
		 * Zuweisung bei den nicht-generischen Typen: IS-A-Beziehung muss stimmen
		 */
		Number var3 = var1; // Number <= IS-A <= Integer
		var3 = var2;	// Number <= IS-A <= Double
		var3 = var3;	// Number <= IS-A <= Number
		
		/*
		 * Zuweisung bei den parametrisierungen generischen Referenzen:
		 * 
		 * 1. Kontrolle: IS-A-Beziehung muss es von rechts nach links geben
		 * 2. Kontrolle: Parametrisierungen mussen gleich sein (Ausnahme: Platzhalter - kommt in den spateren Beispielen)
		 * 
		 * ! Achtung ! Vererbung bei den Parametrisierungen ist nicht erlaubt.
		 */
		
		
		List<Integer> listIntA = null;
		ArrayList<Integer> listIntB = new ArrayList<>();
		
		/*
		 * 1. Kontrolle:    List <= IS-A <= ArrayList          : OK
		 * 2. Kontrolle:    <Integer> <= IST-GLEICH <= <Integer>     : OK 
		 */
		listIntA = listIntB;
		listIntA.add(12); // OK. Das ArrayList bleibt typsicher
		listIntA.add("hello"); // Compilerfehler. Das ArrayList bleibt typsicher
		
		
		List<Number> listNum = new LinkedList<>();
		/*
		 * 1. Kontrolle:    List <= IS-A <= ArrayList          : OK
		 * 2. Kontrolle:    <Number> <= IST-NICHT-GLEICH <= <Integer>     : Compilerfehler
		 */
		
//		listNum = listIntB; // Compilerfehler wegen der 2. Kontrolle, damit das ArrayList - Objekt IMMER Typsicher bleibt
		listNum.add(12);
		listNum.add(12.2323);
		listNum.add(0.4F);
		
	}
	
}
