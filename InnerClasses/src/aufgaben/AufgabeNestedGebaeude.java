package aufgaben;


public class AufgabeNestedGebaeude {

	public static void main(String[] args) {
		
		int anzahlRaumeProStockwerk = 10;
		int anzahlStockwerke = 3;
		Gebauede g1 = new Gebauede("Hauptstr.", "45", anzahlStockwerke , anzahlRaumeProStockwerk);
		
		System.out.println(g1);
		
		Gebauede.Stockwerk sw1 = g1.getStockwerk(0);
		System.out.println(sw1);
		
		System.out.println(g1.getRaum(0, 2));
		
		Object raum = g1.getRaum(0, 2);
		System.out.println(raum);
	}
	
}
