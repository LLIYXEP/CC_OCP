package generics;

/*
 * compareTo ist uberladen. Alles OK
 */

class BlumeV1 {
	public int comareTo(BlumeV1 b1) { return 0; }
	public int comareTo(Object o1) { return 0; }
}

/*
 * Beim Erasing verschwinden alle Parametrisierungen
 * 
 * Implementrieren vom generischen Interface. Erasing beim Compilieren
 */
class BlumeV2 implements Comparable<BlumeV2> {
	public int compareTo(BlumeV2 o) {  // beim Erasing ensteht hier die Methode ' int compareTo(Object)'
		return 0;
		}
	public int compareTo(Object obj) { return 0; } //CF beim Erasing ensteht aine andere Methode mit derselben Signatur
	
}

/*
 * 			Beim Erasing entfernt der Compiler alle Parametrisierungen.
 * 
 			So (in etwa) sieht der Code in Wirklichkeit aus:
 
 
	class BlumeV2 implements Comparable {
	
		// der Compiler ändert die Methode (beim Erasing)
		public int compareTo(Object param) {  
			BlumeV2 b2 = (BlumeV2) param; 	// <- vom Compiler generiertes Casting
			return 0; 
		}
		
		public int compareTo(Object obj) { 
			return 0; 
		}
	}
  
 */

public class B07_Erasing_nochmal {

	public static void main(String[] args) {
		
		
		
	}
	
}
