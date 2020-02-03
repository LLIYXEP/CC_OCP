package nested;

import java.util.Comparator;
import java.util.Map;

/*
 * Innere - Klassen konnen den Design verbessern
 * 
 * - Logische verbindung zum ausseren Typ
 * - Verstecken der Klassen, die nur in der ausseren klasse verwendet werden
 * - Keine Sichbarkeitseinschrankungen in dem ausseren Typ fur alle Inhalte (also auch fur Innere typen)
 * - impliziert Zugriff auf eine Objekt vom ausseren typ in der nichtstatischen inneren Klassen
 */

class Buch {
	public String titel;
	
	class Seite {
		@Override
			public String toString() {
				return "Eine Seite aus dem Buch " + titel;
			}
	}
}

public class B01_Warum {
	
	private static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return 0;
		}
		
	}

	public static void main(String[] args) {
		
		Buch.Seite s1;
		Map.Entry e1;
		
		new MyComparator();
	}
	
}
