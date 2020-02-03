package assertions;

/*
 * Assertions:
 * 
 * Es geht um die Entwicklung! (nicht um den Einsatz der fertigen Losung in der Produktion)
 * Assertions sollten Invarianten kontrollieren
 * Assertions sind standardmassig deaktiviert
 * 
 * Asserions mit der Option '-ea' aktivieren:
 * 
 * 	java -ea KlasseMitDerMain
 * 
 * (Unter Eclipse: unter 'Run Configuration...'
 */

class MyPrinter {
	/*
	 * Public API (public Methoden) werden normalerweise mit Unit-Tests getestet
	 */
	public void print(String s) {
		/*
		 * Die Exc sollte beim Testen der print endeckt werden und soll einen Entwickler benachrichtigen, dass er die Methode 'print' falsch verwendet
		 */
		if (s == null) {
			throw new IllegalArgumentException("S darf nicht null sein");
		}
		
		s = format(s);
		System.out.println(s);
	}
	
	/*
	 * Private Methoden konnen nicht (sollten nicht) mit Unit-Tests getestet werden
	 */
	private String format(String s ) {
		/*
		 * Invariante : s ist garantiert nicht null
		 */
		assert s != null; // 
		
		return s.toUpperCase();
	}
}

public class B01_Assertions {

	public static void main(String[] args) {
		
		new MyPrinter().print("Moin!");
		
	}
	
}
